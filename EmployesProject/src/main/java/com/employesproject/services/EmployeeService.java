package com.employesproject.services;

import com.employesproject.dto.EmployeeDTO;
import com.employesproject.entities.Employee;
import com.employesproject.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Convert Employee to DTO
    public EmployeeDTO fromEmployeeToDTO(Employee employee) {

        // Instantiate a new DTO object
        EmployeeDTO employeeDTO = new EmployeeDTO();

        // Copy relevant fields from entity to DTO
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setDepartment(employee.getDepartment());
        employeeDTO.setSalary(employee.getSalary());

        // Return the mapped DTO
        return employeeDTO;
    }

    // Convert DTO to Employee
    public Employee fromDTOToEmployee(EmployeeDTO employeeDTO) {

        // Instantiate a new entity object
        Employee employee = new Employee();

        // Copy fields from DTO to entity
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());

        // Return the mapped entity
        return employee;
    }

    // Create
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        // Instantiate a new Employee
        Employee employee = new Employee();

        // Map data from DTO to entity (excluding ID, which is auto-generated)
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());

        // Save the entity to the database (INSERT operation)
        employeeRepository.save(employee);

        // Convert the saved entity back to DTO and return it
        return fromEmployeeToDTO(employee);
    }

    // Read
    public List<EmployeeDTO> getAllEmployees() {

        // Get list of employees from repository
        List<Employee> employees = employeeRepository.findAll();

        // Create a new list of EmployeeDTO
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        // Loop through the List<Employee> from the repository
        for (Employee employee : employees) {
            // Convert each Employee to EmployeeDTO
            EmployeeDTO dto = fromEmployeeToDTO(employee);
            // Add it to the list
            employeeDTOs.add(dto);
        }

        // Return list of DTOs
        return employeeDTOs;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(this::fromEmployeeToDTO);
    }

    // Update
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {

        // Fetch existing entity by ID
        Optional<Employee> optional = employeeRepository.findById((long) employeeDTO.getId());

        if (optional.isPresent()) {
            Employee employee = optional.get();

            // Update its fields with values from DTO
            employee.setName(employeeDTO.getName());
            employee.setEmail(employeeDTO.getEmail());
            employee.setDepartment(employeeDTO.getDepartment());
            employee.setSalary(employeeDTO.getSalary());

            // Save updated entity
            employeeRepository.save(employee);

            // Return updated DTO
            return fromEmployeeToDTO(employee);
        } else {
            throw new RuntimeException("Employee not found");
        }


    }

    // Delete
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
