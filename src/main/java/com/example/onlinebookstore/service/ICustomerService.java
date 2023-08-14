package com.example.onlinebookstore.service;

import com.example.onlinebookstore.model.Customer;

public interface ICustomerService {
    public String getCustomer(Customer customer);
    public void addCustomer(Customer customer);
    public void updateCustomer(int id, Customer customer);
    public void deleteCustomer(int id);
    public void updateFullCustomer(int id, Customer customer);
}
