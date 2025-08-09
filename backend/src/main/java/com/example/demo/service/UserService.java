package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	// Create and save a new user
    User saveUser(User user);

    // Get all users
    List<User> getAllUsers();

    // Get a specific user by ID
    User getUserById(Long id);

    // Delete a user by ID
    void deleteUser(Long id);

    // Authenticate user for login
    User loginUser(User user);

    // Check if email is already registered
    boolean emailExists(String email);
    
    long countUsers();
   
	

}
