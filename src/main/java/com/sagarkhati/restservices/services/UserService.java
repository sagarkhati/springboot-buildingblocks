package com.sagarkhati.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagarkhati.restservices.entities.User;
import com.sagarkhati.restservices.repositories.UserRepository;

//Service
@Service
public class UserService {

	// Autowire the UserRepository
	@Autowired
	UserRepository userRepository;

	// getAllUsers method
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// CreateUser method
	public User createUser(User user) {
		return userRepository.save(user);
	}

	// getUserById method
	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}

	// updateUserById method
	public User updateUserById(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	//deleteUserById Method
	public void deleteUserById(Long id) {
		if(userRepository.findById(id).isPresent())
		userRepository.deleteById(id);
	}
	
	//getUserByUsername
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
