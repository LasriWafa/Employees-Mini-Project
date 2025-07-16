package com.employesproject.controllers;

import com.employesproject.dto.EmployeeDTO;
import com.employesproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// ResponseEntity: is a Spring class representing the whole HTTP response (Status code, Headers, Body)
// @PathVariable: extract values from the URL path and use them inside your controller method
// @RequestBody: use when your client (like Angular or Postman) sends data in the body of a POST or PUT request, usually in JSON format.

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {

        // Call service layer to retrieve all employee DTOs
        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        // Return the list of employees with HTTP status 200 OK
        return ResponseEntity.ok(employees);
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {

        // Call service to get employee DTO wrapped in Optional
        return employeeService.getEmployeeById(id)
                // If found, return HTTP 200 OK with employee data
                .map(ResponseEntity::ok)
                // If not found, return HTTP 404 Not Found
                .orElse(ResponseEntity.notFound().build());
    }

    // Create employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {

        // Delegate creation logic to the service layer
        EmployeeDTO created = employeeService.createEmployee(employeeDTO);

        // Return the created employee with HTTP 200 OK
        return ResponseEntity.ok(created);
    }

    // Update employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {

        // Validate: ensure the ID in the path matches the ID in the DTO
        if (!id.equals(employeeDTO.getId())) {
            // Return HTTP 400 Bad Request if IDs are inconsistent
            return ResponseEntity.badRequest().build();
        }

        try {
            // Delegate update logic to the service layer
            EmployeeDTO updated = employeeService.updateEmployee(employeeDTO);
            // Return updated employee data with HTTP 200 OK
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            // If employee not found, return HTTP 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

        // Delegate deletion to the service laye
        employeeService.deleteEmployee(id);

        // Return HTTP 204 No Content to indicate successful deletion with no response body
        return ResponseEntity.noContent().build();
    }

}
