package com.sagarkhati.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagarkhati.restservices.dto.UserMsDto;
import com.sagarkhati.restservices.entities.User;
import com.sagarkhati.restservices.mapper.UserMapper;
import com.sagarkhati.restservices.repositories.UserRepository;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

	@Autowired
	UserRepository userRepository;

//	@Autowired
//	UserMapper userMapper = UserMapper.INSTANCE;
//
//	@GetMapping
//	public List<UserMsDto> getAllUserDtos() {
//		return userMapper.usersToUserDto(userRepository.findAll());
//	}
//
//	@GetMapping("/{id}")
//	public UserMsDto getUserById(@PathVariable Long id) {
//		Optional<User> userOptional = userRepository.findById(id);
//		User user = userOptional.get();
//		return userMapper.userToUserMsDto(user);
//	}
}
