package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

	public Customer updateCustomerById(Long id, Customer updatedCustomer) {
        Customer existingCustomer = getCustomerById(id);
        if (existingCustomer != null) {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPhone(updatedCustomer.getPhone());
            return customerRepository.save(existingCustomer);
        }
        return null;
	}
	
	@Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

	@Override
	public long countCustomers() {
		// TODO Auto-generated method stub
		return (int) customerRepository.count();
	}

	
   
}
