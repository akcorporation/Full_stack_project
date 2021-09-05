package com.newProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/Product/insert")
	public void saveProduct( @RequestParam String name) {
		helloservice.insert(name); 
		System.out.println("Hello controller");
		System.out.println( "---name------" + name);
		
	}
	@GetMapping("/Product/All")
	public String getAllProduct( ) {
		List<Product> result = helloservice.fetchall();
		System.out.println("fetchAll------"+result);
		String resultActual = "";
		for(Product list : result) {
			resultActual = resultActual + list.toString() +" \n";
		}
		
		return resultActual;
		
	}
}

