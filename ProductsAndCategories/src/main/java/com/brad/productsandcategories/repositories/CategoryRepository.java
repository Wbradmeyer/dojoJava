package com.brad.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brad.productsandcategories.models.Category;
import com.brad.productsandcategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findAll();
	
	List<Category> findAllByProducts(Product product);
	
	List<Category> findByProductsNotContains(Product product);
}
