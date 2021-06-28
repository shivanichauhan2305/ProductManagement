package com.product.management.ProductManagement.service;

import java.util.List;

import com.product.management.ProductManagement.entities.Product;

public interface ProductService {

	List<Product> getAllProducts(long userid);
	void saveProduct(Product product);
	Product getProductById(long id);
	void deleteProductById(long id);
}
