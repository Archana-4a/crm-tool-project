package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Lead;

public interface LeadService {
     Lead saveLead(Lead lead);
     List<Lead> getAllLeads();
     Lead getLeadById(Long id);
     void deleteLead(Long id);
     void assignLeadToCustomer(Long leadId,Long customerId);
	 long countLeads();
     
}
