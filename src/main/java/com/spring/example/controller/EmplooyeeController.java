package com.spring.example.controller;

import com.spring.example.exception.ResourceNotFoundException;
import com.spring.example.model.Company;
import com.spring.example.model.Employee;
import com.spring.example.repository.CompanyRepository;
import com.spring.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmplooyeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
       return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Employee id ile kayıt yok ."+id)
        );
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee upateEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Employee id ile kayıt yok ."+id)
        );
        upateEmployee.setFirstName(employeeDetails.getFirstName());
        upateEmployee.setLastName(employeeDetails.getLastName());
        upateEmployee.setEmailId(employeeDetails.getEmailId());
        employeeRepository.save(upateEmployee);

        return ResponseEntity.ok(upateEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Employee id ile kayıt yok ."+id)
        );

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
