import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee';
import { environment } from '../../environments/environment'; 

@Injectable({
  providedIn: 'root'
})

export class EmployeeService {

  // private baseUrl = 'http://localhost:8080/api/employees';
  private baseUrl = `${environment.apiUrl}/employees`;  


  constructor(private http: HttpClient) {}

  getEmployees(): Observable<Employee[]> { 
    return this.http.get<Employee[]>(this.baseUrl);
  }

  getEmployee(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.baseUrl, employee);
  }

  updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.baseUrl}/${employee.id}`, employee);
  }

  deleteEmployee(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

}
