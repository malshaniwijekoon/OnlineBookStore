package com.example.SpringCrud.service;

import com.example.SpringCrud.model.Employee;
import com.example.SpringCrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployee(int id){
        return employeeRepository.findById(id);
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee){
        List<Employee> emp = employeeRepository.findById(employee.getId());
        if(!emp.isEmpty()){
            employeeRepository.save(employee);
        }
    }

    public void deleteEmployee(int id){
        List<Employee> emp = employeeRepository.findById(id);
        if (!emp.isEmpty() || emp.size() != 0){
            employeeRepository.deleteById(id);
        }
    }
    public Iterable<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
}