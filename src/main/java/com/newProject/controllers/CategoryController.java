package com.newProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newProject.services.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
//	
//	@PostMapping("/saveOffer")
//	public ResponseEntity<String> saveCategory(@RequestParam int prdId, @RequestParam String prdName,
//			@RequestParam String prdDesc, @RequestParam int prdRate, @RequestParam int prdAvail,
//			@RequestParam int prdCatId) {
//		//String response = categoryService.saveCategoryDetails(prdId, prdName, prdDesc, prdRate, prdAvail, prdCatId);
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
}
