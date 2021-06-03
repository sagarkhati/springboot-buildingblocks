package com.sagarkhati.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagarkhati.restservices.entities.Order;
import com.sagarkhati.restservices.entities.User;
import com.sagarkhati.restservices.exceptions.UserNotFoundException;
import com.sagarkhati.restservices.repositories.OrderRepository;
import com.sagarkhati.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/hateoas/users")
public class OrderHateoasController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	//getAllOrder
	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrder(@PathVariable Long userid) throws UserNotFoundException {

		Optional<User> optionalUser = userRepository.findById(userid);

		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		return optionalUser.get().getOrders();
	}
	
}
