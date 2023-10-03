package com.brad.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brad.productsandcategories.models.Category;
import com.brad.productsandcategories.models.Product;
import com.brad.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cRepo;
	
	public Category findCategory(Long id) {
		return cRepo.findById(id).orElse(null);
	}
	
	public List<Category> findAllCategories() {
		return cRepo.findAll();
	}
	
	public Category create(Category category) {
		return cRepo.save(category);
	}
	
	public List<Category> unassigned(Product product) {
		return cRepo.findByProductsNotContains(product);
	}
	
	public void addProduct(Category category, Product product) {
		category.getProducts().add(product);
		cRepo.save(category);
	}
}
