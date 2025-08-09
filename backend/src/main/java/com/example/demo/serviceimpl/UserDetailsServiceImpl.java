/*
 * package com.example.demo.serviceimpl;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.*; import
 * org.springframework.stereotype.Service;
 * 
 * import com.example.demo.model.User; import
 * com.example.demo.repository.UserRepository; import
 * com.example.demo.security.CustomUserDetails;
 * 
 * @Service public class UserDetailsServiceImpl implements UserDetailsService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException { Optional<User> user =
 * userRepository.findByEmail(email);
 * 
 * if (!user.isPresent()) { throw new
 * UsernameNotFoundException("User not found with email: " + email); }
 * 
 * return new CustomUserDetails(user.get()); // <-- pass actual User here } }
 */