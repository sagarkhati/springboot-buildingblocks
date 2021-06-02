package com.sagarkhati.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagarkhati.restservices.entities.Order;
import com.sagarkhati.restservices.entities.User;
import com.sagarkhati.restservices.exceptions.UserNotFoundException;
import com.sagarkhati.restservices.repositories.OrderRepository;
import com.sagarkhati.restservices.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class OrderController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrder(@PathVariable Long userid) throws UserNotFoundException {

		Optional<User> optionalUser = userRepository.findById(userid);

		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		return optionalUser.get().getOrders();
	}

	@PostMapping("/{userid}/orders")
	public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {

		Optional<User> optionalUser = userRepository.findById(userid);

		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		order.setUser(optionalUser.get());

		return orderRepository.save(order);
	}

	@GetMapping("/{userid}/orders/{orderid}")
	public Order getOrderByOrderId(@PathVariable("userid") Long userid, @PathVariable("orderid") Long orderid)
			throws UserNotFoundException {

		Optional<User> optionalUser = userRepository.findById(userid);

		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		List<Order> orders = optionalUser.get().getOrders();

		boolean flag = false;
		for (Order order : orders) {
			if (order.getOrderid().equals(orderid)) {
				return order;
			}
		}

		if (!flag)
			throw new UserNotFoundException("Order Not Found");

		return null;
	}
}
