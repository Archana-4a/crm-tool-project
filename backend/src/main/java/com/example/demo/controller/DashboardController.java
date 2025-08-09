package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.demo.repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InteractionRepository interactionRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/summary")
    public Map<String, Long> getDashboardSummary() {
        Map<String, Long> summary = new HashMap<>();
        summary.put("users", userRepository.count());
        summary.put("leads", leadRepository.count());
        summary.put("customers", customerRepository.count());
        summary.put("interactions", interactionRepository.count());
        summary.put("tasks", taskRepository.count());
        return summary;
    }
}
