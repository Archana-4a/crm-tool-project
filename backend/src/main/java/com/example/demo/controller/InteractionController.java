package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Interaction;
import com.example.demo.service.InteractionService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("api/interactions")
public class InteractionController {
	
	@Autowired
	private InteractionService interactionService;
	
/*	@PostMapping
	public Interaction createInteraction(@RequestBody Interaction interaction) {
		System.out.println(interaction);
		return interactionService.saveInteraction(interaction);
	}
*/	
	@PostMapping("/{customerId}")
	public Interaction createInteraction(@PathVariable("customerId") long customerId,@RequestBody Interaction interaction) {
		System.out.println(interaction);
		return interactionService.saveInteraction(interaction,customerId);
	}
	
	@GetMapping
	public List<Interaction> getAllInteractions() {
        return interactionService.getAllInteractions();
    }
	
	@GetMapping("/{id}")
    public Interaction getInteractionById(@PathVariable Long id) {
        return interactionService.getInteractionById(id);
    }
	
	@DeleteMapping("/{id}")
    public void deleteInteraction(@PathVariable Long id) {
        interactionService.deleteInteraction(id);
    }

}
