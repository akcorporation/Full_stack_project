package com.newProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newProject.model.Product;
import com.newProject.repository.HelloRepository;

@Service
public class HelloServices {

	@Autowired
	HelloRepository hellorepository;
	
	public Product fetch(Long id) {
		Product result = hellorepository.getProductById(id);
		return result;
	}
	public void insert(String name) {
		Product result = new Product();
				
				result.setName(name);
				hellorepository.save(result); 
				System.out.println("Hello Services");
				System.out.println("id ----" + result.toString());
	}
	public List<Product> fetchall(){
		List<Product> result = hellorepository.findAll();
		System.out.println("fetchAll------"+result);
		return result;
	}
}
