package com.example.SpringCrud.service;

import com.example.SpringCrud.model.Company;
import com.example.SpringCrud.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company getCompanyById(int id) {
        return companyRepository.findById(id);
    }

    public String getCompanyDetails(Company company) {
        Company getCompany = companyRepository.findById(company.getId());
        if(getCompany != null){
            return "Company Already Exist";
        } else {
            companyRepository.save(company);
            return "Company Successfully Added";
        }
    }
}
