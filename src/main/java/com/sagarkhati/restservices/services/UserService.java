package com.sagarkhati.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sagarkhati.restservices.entities.User;
import com.sagarkhati.restservices.exceptions.UserExistsException;
import com.sagarkhati.restservices.exceptions.UserNotFoundException;
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
	public User createUser(User user) throws UserExistsException {

		User userExist = userRepository.findByUsername(user.getUsername());

		if (userExist != null) {
			throw new UserExistsException("User already exists in repositry");
		}

		return userRepository.save(user);
	}

	// getUserById method
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			throw new UserNotFoundException("User not found in User Repository");

		return user;
	}

	// updateUserById method
	public User updateUserById(Long id, User user) throws UserNotFoundException {

		Optional<User> opUser = userRepository.findById(id);

		if (!opUser.isPresent())
			throw new UserNotFoundException("User not found in User Repository, Provide the correct User Id");

		user.setUserid(id);
		return userRepository.save(user);
	}

	// deleteUserById Method
	public void deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent())
			userRepository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"User not found in User Repository, Provide the correct User Id");
	}

	// getUserByUsername
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
