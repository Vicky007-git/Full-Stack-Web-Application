package com.biggrin.employee_management_system.requests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private int empId;
    private String firstName;
    private String phone;
    private String lastName;
    private Double salary;
    private String designation;
    private String department;
}
