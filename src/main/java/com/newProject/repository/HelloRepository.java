package com.newProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.newProject.model.Product;

public interface HelloRepository extends CrudRepository<Product, Long> {

	Product getProductById(Long id);
	Product save(Product value);
	

	List<Product> findAll();
	
	 
}
