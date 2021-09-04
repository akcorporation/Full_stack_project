package com.newProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newProject.model.Product;

public interface HelloRepository extends JpaRepository<Product, Long> {

	Product getProductById(Long id);
}
