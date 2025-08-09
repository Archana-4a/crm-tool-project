package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Interaction;

public interface InteractionRepository extends JpaRepository<Interaction,Long>{

}
