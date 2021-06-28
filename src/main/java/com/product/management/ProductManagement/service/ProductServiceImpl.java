package com.product.management.ProductManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.management.ProductManagement.entities.Product;
import com.product.management.ProductManagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts(long userid) {
		return productRepository.findProductByUsername(userid);
	}
	
	@Override
	public 	void saveProduct(Product product) {
		this.productRepository.save(product);
	}

	@Override
	public Product getProductById(long id) {
		Optional<Product> optional = productRepository.findById(id);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			throw new RuntimeException(" product not found for id :: " + id);
		}
		return product;
	}
	
	@Override
	public void deleteProductById(long id) {
		this.productRepository.deleteById(id);
	}

	
	
	}
