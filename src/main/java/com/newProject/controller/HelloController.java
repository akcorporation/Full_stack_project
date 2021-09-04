package com.newProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.newProject.model.Product;
import com.newProject.service.HelloServices;

@RestController
public class HelloController {
 
	@GetMapping("/hello")
	public String message() {
		return "Hello world";
	}
	
	@Autowired
	HelloServices helloservice;
	
	@GetMapping("/Product/{id}")
	public String getProduct(@PathVariable Long id) {
		Product product = helloservice.fetch(id);
		return product.toString();
	}
}

