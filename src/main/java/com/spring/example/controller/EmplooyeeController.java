package com.spring.example.controller;


import com.spring.example.model.Employee;
import com.spring.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmplooyeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
       return employeeService.createEmployee(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        return employeeService.updateEmployee(id,employeeDetails);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("{age,salary,year}")
    public long getSalary(@PathVariable long age,@PathVariable long salary,@PathVariable long year){
        return employeeService.calculateSalary(age,salary,year);
    }



}
