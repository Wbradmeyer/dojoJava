package com.brad.productsandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brad.productsandcategories.models.Category;
import com.brad.productsandcategories.models.Product;
import com.brad.productsandcategories.services.CategoryService;
import com.brad.productsandcategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService cService;
	
	@Autowired
	private ProductService pService;
	
	@GetMapping("/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	
	@PostMapping("/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "category.jsp";
		}
		cService.create(category);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		
		Category category = cService.findCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("productList", pService.unassigned(category));
		
		return "showCategory.jsp";
	}
	
	@PostMapping("/add-product")
	public String addProduct(@RequestParam("categoryId") Long categoryId, @RequestParam("productId") Long productId) {
		
		Category thisCategory = cService.findCategory(categoryId);
		Product productToAdd = pService.findProduct(productId);
		cService.addProduct(thisCategory, productToAdd);
		
		return "redirect:/categories/" + categoryId;
	}
}
