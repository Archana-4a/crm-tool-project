package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Interaction;
import com.example.demo.repository.InteractionRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.InteractionService;

@Service
public class InteractionServiceImpl implements InteractionService{

	@Autowired
    private InteractionRepository interactionRepository;
	
	@Autowired
	private CustomerService customerService;

   /* @Override
    public Interaction saveInteraction(Interaction interaction) {
        return interactionRepository.save(interaction);
    }*/
	
	@Override
    public Interaction saveInteraction(Interaction interaction,long customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		interaction.setCustomer(customer);
        return interactionRepository.save(interaction);
    }

    @Override
    public List<Interaction> getAllInteractions() {
        return interactionRepository.findAll();
    }

    @Override
    public Interaction getInteractionById(Long id) {
        return interactionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInteraction(Long id) {
        interactionRepository.deleteById(id);
    }
    
    @Override
    public long countInteractions() {
        return (int) interactionRepository.count();
    }
	

}
