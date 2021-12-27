package com.spring.example;

import com.spring.example.model.Company;
import com.spring.example.model.Employee;
import com.spring.example.repository.CompanyRepository;
import com.spring.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {


//        Company company = new Company();
//        company.setCompanyName("DEF");
//        company.setCeo("Kemal");
//        company.setEmailId("kemal@gmail.com");
//        companyRepository.save(company);
//
//        Employee employee = new Employee();
//        employee.setFirstName("Ayşe");
//        employee.setLastName("met");
//        employee.setEmailId("ayse@gmail.com");
//        employeeRepository.save(employee);
//
//        Employee employee1 = new Employee();
//        employee1.setFirstName("Merve");
//        employee1.setLastName("san");
//        employee1.setEmailId("merve@gmail.com");
//        employeeRepository.save(employee1);
//
//        company.getEmployeeList().add(employee);
//        company.getEmployeeList().add(employee1);
//
//        this.companyRepository.save(company);

    }
}
