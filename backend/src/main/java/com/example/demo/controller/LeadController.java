package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Lead;
import com.example.demo.service.CustomerService;
import com.example.demo.service.LeadService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @PostMapping
    public Lead createLead(@RequestBody Lead lead) {
        return leadService.saveLead(lead);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/assign/{leadId}/customer/{customerId}")
    public ResponseEntity<String> assignLeadToCustomer(@PathVariable Long leadId, @PathVariable Long customerId) {
        Lead lead = leadService.getLeadById(leadId);
        if (lead == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lead not found");
        }
             


        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }

        lead.setCustomer(customer);
        leadService.saveLead(lead);
        return ResponseEntity.ok("Lead assigned to customer successfully");
    }
}
