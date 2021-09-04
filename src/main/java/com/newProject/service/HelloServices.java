package com.newProject.service;

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
}
