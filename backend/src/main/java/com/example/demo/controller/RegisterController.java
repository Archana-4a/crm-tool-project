package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.payload.RegisterRequest;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/")
public class RegisterController {
	@Autowired
    private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {
	   

	    // Step 2: Create and save new user
	    User user = new User();
	    user.setUsername(request.getUsername());
	    user.setEmail(request.getEmail());
	    user.setPassword(request.getPassword());
	    user.setRole(request.getRole());

	    userService.saveUser(user);
	    return ResponseEntity.ok("User registered successfully!");
	}

}
