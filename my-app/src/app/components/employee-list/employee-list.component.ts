import { Component, OnInit } from '@angular/core';
import { Employee } from '../../models/employee';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-employee-list',
  standalone: false,
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css'
})

export class EmployeeListComponent implements OnInit {

  employees: Employee[] = [];
  errorMessage: string = '';

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
     this.loadEmployees();
  }

  loadEmployees(): void {
    this.employeeService.getEmployees().subscribe({
      next: (data) => this.employees = data,
      error: (err) => this.errorMessage = 'Failed to load employees.'
    });
  }

  deleteEmployee(id: number): void {
    if(confirm('Are you sure to delete this employee?')) {
      this.employeeService.deleteEmployee(id).subscribe({
        next: () => this.loadEmployees(),
        error: () => this.errorMessage = 'Delete failed.'
      });
    }
  }

}
