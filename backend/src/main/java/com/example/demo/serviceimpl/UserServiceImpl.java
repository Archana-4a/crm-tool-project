package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

     
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		 userRepository.deleteById(id);
	}


	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}


	// Check if email is already registered
    @Override
    public boolean emailExists(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }
    public long countUsers() {
        return (int) userRepository.count();  // returns total number of users
    }


}
