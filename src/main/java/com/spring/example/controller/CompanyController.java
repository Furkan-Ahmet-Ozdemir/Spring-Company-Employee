package com.spring.example.controller;

import com.spring.example.exception.ResourceNotFoundException;
import com.spring.example.model.Company;
import com.spring.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @GetMapping("{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id){
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Company id ile kayıt yok ."+id)
        );
        return ResponseEntity.ok(company);
    }

    @PutMapping("{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable long id,@RequestBody Company companyDetails){
        Company upateCompany = companyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Company id ile kayıt yok ."+id)
        );
        upateCompany.setCompanyName(companyDetails.getCompanyName());
        upateCompany.setCeo(companyDetails.getCeo());
        upateCompany.setEmailId(companyDetails.getEmailId());

        companyRepository.save(upateCompany);
        return ResponseEntity.ok(upateCompany);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id){
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Company id ile kayıt yok ."+id)
        );

        companyRepository.delete(company);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
