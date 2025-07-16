package com.employesproject.repositories;

import com.employesproject.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // nothing more needed for basic CRUD
}
