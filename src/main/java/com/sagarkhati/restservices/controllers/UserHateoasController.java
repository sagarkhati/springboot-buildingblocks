package com.sagarkhati.restservices.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sagarkhati.restservices.entities.Order;
import com.sagarkhati.restservices.entities.User;
import com.sagarkhati.restservices.exceptions.UserNotFoundException;
import com.sagarkhati.restservices.repositories.UserRepository;
import com.sagarkhati.restservices.services.UserService;

@RestController
@RequestMapping(value = "/hateoas/users")
@Validated
public class UserHateoasController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	// getUserById method
	@GetMapping("/{id}")
	public EntityModel<User> getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<User> optionalUser = userService.getUserById(id);
			User user = optionalUser.get();
			Long userid = user.getUserid();
			// Link selfLink =
			// ControllerLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
			Link selflink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();
			user.add(selflink); // common for both
			// Resource<User> finalResource = new Resource<User>(user);
			EntityModel<User> finalResource = new EntityModel<User>(user);

			return finalResource;
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	// getAllUsers method
	@GetMapping
	public CollectionModel<User> getAllUsers() throws UserNotFoundException {
		List<User> allusers = userService.getAllUsers();

		for (User user : allusers) {

			Long userid = user.getUserid();

			Link selflink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userid).withSelfRel();

			user.add(selflink);

			List<Order> orders = WebMvcLinkBuilder.methodOn(OrderHateoasController.class).getAllOrder(userid);

			Link orderlink = WebMvcLinkBuilder.linkTo(orders).withRel("all-orders");
			user.add(orderlink);

		}

		Link link = WebMvcLinkBuilder.linkTo(this.getClass()).withSelfRel();

		CollectionModel<User> finalResource = CollectionModel.of(allusers, link);

		return finalResource;
	}
}
