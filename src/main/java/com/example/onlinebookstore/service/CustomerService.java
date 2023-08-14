package com.example.onlinebookstore.service;

import com.example.onlinebookstore.repository.CustomerRepository;
import com.example.onlinebookstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String getCustomer(Customer customer) {
        List<Customer> cus = customerRepository.findByUsername(customer.getUserName());
        System.out.println(cus.size());
        if (cus != null || cus.size() > 0) {
            if (cus.get(0).getPassword().equals(customer.getPassword())){
                return "Success";
            }
        }
        return "Failed";
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        Customer cus = customerRepository.findById(id);
        if (customer.getUserName().equals(cus.getUserName())){
            cus.setPassword(customer.getPassword());
            customerRepository.save(cus);
        }
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateFullCustomer(int id, Customer customer) {
        Customer cus = customerRepository.findById(id);
        if (id == cus.getId()){
            cus.setPassword(customer.getPassword());
            cus.setUserName(customer.getUserName());
            customerRepository.save(cus);
        }
    }
}
