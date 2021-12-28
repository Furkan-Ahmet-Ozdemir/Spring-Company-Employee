package com.spring.example.service;

import com.spring.example.exception.ResourceNotFoundException;
import com.spring.example.model.Company;
import com.spring.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;


    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }


    public Company createCompany( Company company){
        return companyRepository.save(company);
    }


    public ResponseEntity<Company> getCompanyById( long id){
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Company id ile kayıt yok ."+id)
        );
        return ResponseEntity.ok(company);
    }


    public ResponseEntity<Company> updateCompany( long id, Company companyDetails){
        Company upateCompany = companyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Company id ile kayıt yok ."+id)
        );
        upateCompany.setCompanyName(companyDetails.getCompanyName());
        upateCompany.setCeo(companyDetails.getCeo());
        upateCompany.setEmailId(companyDetails.getEmailId());

        companyRepository.save(upateCompany);
        return ResponseEntity.ok(upateCompany);
    }

    public ResponseEntity<String> deleteCompany( long id){
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bu Company id ile kayıt yok ."+id)
        );

        companyRepository.delete(company);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
