package com.newProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newProject.models.Product;

@Repository
public interface CategoryRepository  extends JpaRepository<Product, Long> {
	

}
