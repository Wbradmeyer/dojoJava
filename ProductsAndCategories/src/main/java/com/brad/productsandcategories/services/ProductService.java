package com.brad.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brad.productsandcategories.models.Category;
import com.brad.productsandcategories.models.Product;
import com.brad.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pRepo;
	
	public Product findProduct(Long id) {
		return pRepo.findById(id).orElse(null);
	}
	
	public List<Product> findAllProducts() {
		return pRepo.findAll();
	}
	
	public Product create(Product product) {
		return pRepo.save(product);
	}
	
	public List<Product> unassigned(Category category) {
		return pRepo.findByCategoriesNotContaining(category);
	}
	
	public void addCategory(Product product, Category category) {
		product.getCategories().add(category);
		pRepo.save(product);
	}
}
