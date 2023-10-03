package com.brad.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brad.productsandcategories.models.Category;
import com.brad.productsandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	List<Product> findAll();
	
	List<Product> findAllByCategories(Category category);
	
	List<Product> findByCategoriesNotContaining(Category category);
}
