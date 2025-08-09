package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Lead;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.LeadRepository;
import com.example.demo.service.LeadService;
@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
    private LeadRepository leadRepository;
	
	@Autowired
	private  CustomerRepository customerRepository;

	@Override
    public Lead saveLead(Lead lead) {
        return leadRepository.save(lead);
    }

    @Override
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Override
    public Lead getLeadById(Long id) {
        return leadRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }
    
    @Override
    public void assignLeadToCustomer(Long leadId, Long customerId) {
        Lead lead = leadRepository.findById(leadId)
            .orElseThrow(() -> new RuntimeException("Lead not found"));

        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        lead.setCustomer(customer);
        leadRepository.save(lead);
    }
    
    @Override
    public long countLeads() {
        return (int) leadRepository.count();
    }
}
