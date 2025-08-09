package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.payload.LoginRequest;
import com.example.demo.payload.LoginResponse;

public interface AuthService {
	
	    LoginResponse login(LoginRequest loginRequest);

		User register(User user);
	}

