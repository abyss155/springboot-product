package com.kiit.myFirstSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kiit.myFirstSpringboot.model.User;
import com.kiit.myFirstSpringboot.repository.UserRepository;
import com.kiit.myFirstSpringboot.security.MyUserDecorator;


@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{

	User user = userRepository.findByUsername(username);
	
	if(user==null)
		throw new UsernameNotFoundException("User does not Exists");
	
	return new MyUserDecorator(user);
	}

}
