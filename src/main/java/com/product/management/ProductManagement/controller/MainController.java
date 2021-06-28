package com.product.management.ProductManagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.product.management.ProductManagement.entities.Product;
import com.product.management.ProductManagement.entities.User;
import com.product.management.ProductManagement.service.ProductService;
import com.product.management.ProductManagement.service.UserService;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		username = principal.toString();
		}
		User u=userService.findUserByUsername(username);
		long userid=u.getId();
		model.addAttribute("listProducts", productService.getAllProducts(userid));
		return "index";
	}
	
	//this request come from index.html home page to add new product
	@GetMapping("/showNewProductForm")
	public String showNewProductForm(Model model) {

		Product product = new Product();
		model.addAttribute("product", product);
		return "newproduct";
	}
	
	@PostMapping("/saveProduct")
	public String saveEmployee(@ModelAttribute("product") Product product) {
		// save employee to database
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		username = principal.toString();
		}
		User u=userService.findUserByUsername(username);
		product.setUserid(u.getId());
		productService.saveProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Product product = productService.getProductById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("product", product);
		return "updateproduct";
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.productService.deleteProductById(id);
		return "redirect:/";
	}
}
