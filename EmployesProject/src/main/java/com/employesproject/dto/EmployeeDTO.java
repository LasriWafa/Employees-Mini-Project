package com.employesproject.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class EmployeeDTO {

    private long id;
    private String name;
    private String department;
    private String email;
    private BigDecimal salary;
}
