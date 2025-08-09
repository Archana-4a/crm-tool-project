package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);
	Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    void deleteCustomer(Long id);
	Customer updateCustomerById(Long id, Customer updateCustomer);
    long countCustomers();
      // returns total number of users
    
}
