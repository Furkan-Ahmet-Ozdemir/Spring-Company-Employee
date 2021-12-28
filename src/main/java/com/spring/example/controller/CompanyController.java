package com.spring.example.controller;

import com.spring.example.exception.ResourceNotFoundException;
import com.spring.example.model.Company;
import com.spring.example.repository.CompanyRepository;
import com.spring.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompany(){
        return companyService.getAllCompany();
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company){
        return companyService.createCompany(company);
    }

    @GetMapping("{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id){

        return companyService.getCompanyById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable long id,@RequestBody Company companyDetails){

        return companyService.updateCompany(id,companyDetails);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id){
        return companyService.deleteCompany(id);
    }
}
