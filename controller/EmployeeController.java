package com.biggrin.employee_management_system.controller;

import com.biggrin.employee_management_system.Exception.ResourseNotFoundException;
import com.biggrin.employee_management_system.entites.Employee;
import com.biggrin.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("getAll")      // READ ALL
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")         // READ
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourseNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourseNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("updatemployee/{id}")  // UPDATE
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) throws ResourseNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourseNotFoundException("Employee not exist with id :" + id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setDesignation(employeeDetails.getDesignation());
        Employee updateEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/add")       // CREATE
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    @DeleteMapping("/{id}")   // DELETE
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long id) throws ResourseNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourseNotFoundException("Employee not exist with id :" + id));
        employeeRepository.delete(employee);
        return ResponseEntity.ok(+id + " Deleted Succeccfully : ");
    }
}





















//
//
//    private Employee mapEmployeeRequestToEmployee(EmployeeRequest employeeRequest) {
//        Employee employee = new Employee();
//        employee.setFirstName(employeeRequest.getFirstName());
//        employee.setPhone(employeeRequest.getPhone());
//        employee.setLastName(employeeRequest.getLastName());
//        employee.setSalary(employeeRequest.getSalary());
//        employee.setDesignation(employeeRequest.getDesignation());
//        employee.setDepartment(employeeRequest.getDepartment());
//        return employee;
//    }
//
//    private EmployeeResponse mapEmployeeRequestToEmployeeResponse(Employee employee) {
//        EmployeeResponse employeeResponse = new EmployeeResponse();
//        employeeResponse.setPhone(employee.getPhone());
//        employeeResponse.setEmpId(Math.toIntExact(employee.getId()));
//        employeeResponse.setFirstName(employee.getFirstName());
//        employee.setLastName(employee.getLastName());
//        employee.setSalary(employee.getSalary());
//        employee.setDesignation(employee.getDesignation());
//        employee.setDepartment(employee.getDepartment());
//        employeeResponse.setCode(HttpStatus.CREATED.value());
//        employeeResponse.setStatus(HttpStatus.CREATED.name());
//        return employeeResponse;
//    }












//    Delete MAping
//    @DeleteMapping("{id}")
//    public ResponseEntity<Employee> deleteEmploye(@PathVariable Long id){
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourseNotFoundException("Employee Id DELETE :" + id));
//        employeeRepository.delete(employee);
//        response.put("Delete")
//        return ResponseEntity.ok(employee);
//    }

//    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long Id) throws ResourseNotFoundException{
//        Employee employee = employeeRepository.findById(Id)
//                .orElseThrow(() -> new ResourseNotFoundException("Employee :Id "+Id+ " Delete Successfully : " ));
//        return ResponseEntity.ok(employee);
//    }






//    @PutMapping("/UpdateEmployee/{id}")
//    public ResponseEntity <Employee> updateEmployee(@PathVariable Long Id) throws ResourseNotFoundException {
//        Employee employee = employeeRepository.findById(Id)
//                .orElseThrow(() -> new ResourseNotFoundException("Employee :Id "+Id+ " : Updated : " ));
//        employee.setFirstName(employee.getFirstName());
//        employee.setLastName(employee.getLastName());
//        employee.setDepartment(employee.getDepartment());
//        employee.setDesignation(employee.getDesignation());
//        employee.setPhone(employee.getPhone());
//        employee.setSalary(employee.getSalary());
//        return ResponseEntity.ok(employee);
//
//    }


    //    @GetMapping("/{id}")
//    public ResponseEntity <Employee> getEmployeeId(@PathVariable Long Id) throws ResourseNotFoundException {
//        Employee employee = employeeRepository.findById(Id)
//                .orElseThrow(() -> new ResourseNotFoundException("Employee Not Exist id : " + Id));
//            return ResponseEntity.ok(employee);
//
//    }





















