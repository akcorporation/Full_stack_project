package com.newProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.newProject.models.Product;
import com.newProject.repositories.CategoryRepository;

@Service
public class CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository; 
}
