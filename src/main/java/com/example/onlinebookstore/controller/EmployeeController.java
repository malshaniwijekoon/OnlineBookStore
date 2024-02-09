package com.example.SpringCrud.controller;

import com.example.SpringCrud.service.EmployeeService;
import com.example.SpringCrud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/get-all-employees")
    @ResponseBody
    public Iterable<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/get-employee")
    @ResponseBody
    public List<Employee> getEmployee(@RequestParam int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/add-employee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping("/updateEmployee/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    @Transactional
    public void deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
    }
}
