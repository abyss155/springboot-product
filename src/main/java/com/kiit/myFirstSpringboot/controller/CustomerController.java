package com.kiit.myFirstSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiit.myFirstSpringboot.model.Customer;
import com.kiit.myFirstSpringboot.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/registerCustomer")
	public Customer registerCustomer(@RequestBody Customer customer)
	{
		return customerService.registerCustomer(customer);
	}
}
