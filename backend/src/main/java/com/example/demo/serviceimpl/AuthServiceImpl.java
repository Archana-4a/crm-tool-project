/*
 * package com.example.demo.serviceimpl;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Service;
 * 
 * import com.example.demo.model.User; import
 * com.example.demo.payload.LoginRequest; import
 * com.example.demo.payload.LoginResponse; import
 * com.example.demo.repository.UserRepository; import
 * com.example.demo.service.AuthService;
 * 
 * @Service public class AuthServiceImpl implements AuthService{
 * 
 * @Autowired private PasswordEncoder passwordEncoder;
 * 
 * @Autowired private AuthenticationManager authenticationManager;
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Override public LoginResponse login(LoginRequest loginRequest) {
 * Authentication authentication = authenticationManager.authenticate( new
 * UsernamePasswordAuthenticationToken( loginRequest.getEmail(),
 * loginRequest.getPassword() ) );
 * 
 * SecurityContextHolder.getContext().setAuthentication(authentication);
 * 
 * Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
 * 
 * return new LoginResponse("Login successful", user.get().getEmail()); }
 * 
 * @Override public User register(User user) { // 1. Encode the raw password
 * user.setPassword(passwordEncoder.encode(user.getPassword()));
 * 
 * // 2. Save user to DB return userRepository.save(user); }
 * 
 * }
 */