package com.example.SpringCrud.repository;

import com.example.SpringCrud.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {
    Company findById(int id);
    Company findByIdAndCompanyName(int id, String companyName);
}
