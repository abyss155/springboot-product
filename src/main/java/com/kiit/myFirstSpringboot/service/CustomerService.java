package com.kiit.myFirstSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiit.myFirstSpringboot.model.Customer;
import com.kiit.myFirstSpringboot.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
