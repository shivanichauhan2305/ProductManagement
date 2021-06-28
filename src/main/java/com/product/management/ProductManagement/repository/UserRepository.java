package com.product.management.ProductManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.management.ProductManagement.entities.Product;
import com.product.management.ProductManagement.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	User findByEmail(String email);
	
	@Query(value="SELECT u FROM User u WHERE u.email=?1")
	User findUserByUsername(String username);
}
