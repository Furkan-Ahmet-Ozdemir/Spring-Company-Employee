package com.spring.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long compId;

    @Column(name = "name")
    private String companyName;

    @Column(name = "ceo")
    private String ceo;

    @Column(name = "email_id")
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "company_id", referencedColumnName = "id")
    List<Employee> employeeList = new ArrayList<>();

    public Company() {
    }

    public Company( String companyName, String ceo, String emailId,long compId) {
        super();
        this.compId= compId;
        this.companyName = companyName;
        this.ceo = ceo;
        this.emailId = emailId;
    }

    public long getCompId() {
        return compId;
    }

    public void setCompId(long compId) {
        this.compId = compId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void setEmployeeList() {
    }
}
