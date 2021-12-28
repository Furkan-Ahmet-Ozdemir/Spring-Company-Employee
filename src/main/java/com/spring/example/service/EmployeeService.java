package com.spring.example.service;

import com.spring.example.exception.ResourceNotFoundException;
import com.spring.example.model.Employee;
import com.spring.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee createEmployee( Employee employee){
        return employeeRepository.save(employee);
    }

    public ResponseEntity<Employee> getEmployeeById( long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Employee id ile kayıt yok ."+id)
        );
        return ResponseEntity.ok(employee);
    }

    public ResponseEntity<Employee> updateEmployee( long id, Employee employeeDetails){
        Employee upateEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Employee id ile kayıt yok ."+id)
        );
        upateEmployee.setFirstName(employeeDetails.getFirstName());
        upateEmployee.setLastName(employeeDetails.getLastName());
        upateEmployee.setEmailId(employeeDetails.getEmailId());
        employeeRepository.save(upateEmployee);

        return ResponseEntity.ok(upateEmployee);
    }

    public ResponseEntity<String> deleteEmployee( long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Employee id ile kayıt yok ."+id)
        );

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public long calculateSalary(long age,long salary,long year){
        salary = salary+((salary/10)*year);
        if(age>=20 && age<=25 ){
            salary = salary+((salary/100)*10);
        }else if (age>=26 && age<=30 ){
            salary = salary+((salary/100)*8);
        }else if (age>=31 && age<=36 ){
            salary = salary+((salary/100)*5);
        }else if (age>=36 ){
            salary = salary+((salary/100)*3);
        }else
            System.out.println("Geçersiz yaş");

        return salary;
    }
}
