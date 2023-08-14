package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.model.Customer;
import com.example.onlinebookstore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/user")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/login")
    @ResponseBody
    public String getCustomer(@RequestBody Customer customer) {
        return customerService.getCustomer(customer);
    }

    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);

    }

    @PutMapping("/updateCustomer/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    @Transactional
    public void deleteCustomer(@PathVariable("id") int id){
        customerService.deleteCustomer(id);
    }

    @PatchMapping("/partialUpdateCustomer/{id}")
    public void partialUpdateCustomer(@PathVariable ("id") int id, @RequestBody Customer customer){
        customerService.updateFullCustomer(id, customer);
    }
}
