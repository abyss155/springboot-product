package com.kiit.myFirstSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiit.myFirstSpringboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
	public User	findByUsername(String x);
}
