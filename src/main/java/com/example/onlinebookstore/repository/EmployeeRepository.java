package com.example.SpringCrud.repository;

import com.example.SpringCrud.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    List<Employee> findById(int id);
    void deleteById(int id);
}
