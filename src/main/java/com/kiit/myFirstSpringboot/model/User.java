package com.kiit.myFirstSpringboot.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	String username;
	String password;
	
	LocalDate accountExpiryDate;
	int accountLockedStatus;
	LocalDate credentialsExpiryDate;
	int accountEnableStatus;
	
	@ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name = "fkuser_id"),
			inverseJoinColumns = @JoinColumn(name = "fkrole_id")
			)
	List<Role>  roles;
	
}
