package com.newProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.newProject.models.Product;
import com.newProject.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public String saveProductDetails(String prdName, String prdDesc, int prdRate, int prdAvail, int prdCatId) {
		Product productDetail = new Product();
		productDetail.setPrdName(prdName);
		productDetail.setPrdDesc(prdDesc);
		productDetail.setPrdRate(prdRate);
		productDetail.setPrdAvail(prdAvail);
		productDetail.setPrdCatId(prdCatId);

		try {
			productRepository.save(productDetail);
			return "Data Saved Successfully ........";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<Product> getAllProducts() {
		List<Product> productDetails = productRepository.getAllProducts();
		return productDetails;

	}

	public Optional<Product> getProductById(int prdId) {
		Optional<Product> productDetails = productRepository.findById(prdId);
		return productDetails;
	}

	public String updateProductDetails(int prdId, String prdName, String prdDesc, int prdRate, int prdAvail,
			int prdCatId) {

		Optional<Product> optional = productRepository.findById(prdId);
		if (optional.isPresent()) {
			Product productDetail = optional.get();
			productDetail.setPrdId(prdId);
			productDetail.setPrdName(prdName);
			productDetail.setPrdDesc(prdDesc);
			productDetail.setPrdRate(prdRate);
			productDetail.setPrdAvail(prdAvail);
			productDetail.setPrdCatId(prdCatId);
			try {
				productRepository.save(productDetail);
				return "Data Updated Successfully ........";
			} catch (Exception e) {
				return e.getMessage();
			}
		} else {
			return "No Data Found with Id :" + prdId;
		}
	}

	public String deleteProductById(int prdId) {
		Optional<Product> optional = productRepository.check(prdId);
		if (optional.isPresent()) {
			productRepository.deleteProductById(prdId);
			return "Offer Deleted Successfully .......";
		} else {
			return "No Data Found with Id : " + prdId;
		}
	}

}
