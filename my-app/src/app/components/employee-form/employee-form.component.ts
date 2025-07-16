import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee';

@Component({
  selector: 'app-employee-form',
  standalone: false,
  templateUrl: './employee-form.component.html',
  styleUrl: './employee-form.component.css'
})

export class EmployeeFormComponent implements OnInit {

  employeeForm!: FormGroup;
  isEditMode = false;
  employeeId?: number;
  errorMessage = '';

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeService
  ) {}

  ngOnInit(): void {
    this.employeeForm = this.fb.group({
      id: [null],
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      department: ['', Validators.required],
      salary: [0, [Validators.required, Validators.min(0)]],
    });

    this.route.paramMap.subscribe(params => {
      const idParam = params.get('id');
      if (idParam) {
        this.isEditMode = true;
        this.employeeId = +idParam;
        this.loadEmployee(this.employeeId);
      }
    });
  }

  loadEmployee(id: number): void {
    this.employeeService.getEmployee(id).subscribe({
      next: (emp) => this.employeeForm.patchValue(emp),
      error: () => this.errorMessage = 'Failed to load employee'
    });
  }

  onSubmit(): void {
    if (this.employeeForm.invalid) {
      return;
    }

    const employee: Employee = this.employeeForm.value;

    if (this.isEditMode) {
      this.employeeService.updateEmployee(employee).subscribe({
        next: () => this.router.navigate(['/employees']),
        error: () => this.errorMessage = 'Update failed'
      });
    } else {
      this.employeeService.createEmployee(employee).subscribe({
        next: () => this.router.navigate(['/employees']),
        error: () => this.errorMessage = 'Creation failed'
      });
    }
  }

}
