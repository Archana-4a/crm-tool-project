/*
 * package com.example.demo.service;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.example.demo.model.User; import
 * com.example.demo.repository.UserRepository; import
 * com.example.demo.security.CustomUserDetails;
 * 
 * @Service public class CustomUserDetailsService implements UserDetailsService{
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException { Optional<User> userOptional =
 * userRepository.findByEmail(email);
 * 
 * User user = userOptional.orElseThrow(() -> new
 * UsernameNotFoundException("User not found with email: " + email));
 * 
 * return new CustomUserDetails(user); // Wrap it into UserDetails }
 * 
 * }
 */