package com.sagarkhati.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

	//Simple Method
	//URI - /helloWorld
	//GET
	@GetMapping("/helloworld1")
	public String hellowWorld() {
		return "Hello World";
	}
	
	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Sagar","Khati","Khatima");
	}
}
