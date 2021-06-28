package com.product.management.ProductManagement.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.product.management.ProductManagement.dto.UserRegistrationDto;
import com.product.management.ProductManagement.entities.User;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto userRegistrationDto);
	
	User findUserByUsername(String username);

}
