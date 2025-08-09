package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Interaction;

public interface InteractionService {
	//Interaction saveInteraction(Interaction interaction);
	Interaction saveInteraction(Interaction interaction,long customerId);
    List<Interaction> getAllInteractions();
    Interaction getInteractionById(Long id);
    void deleteInteraction(Long id);
    long countInteractions();
}
