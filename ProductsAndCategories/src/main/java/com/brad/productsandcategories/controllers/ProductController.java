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
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@Autowired
	private CategoryService cService;
	
	@GetMapping("/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}
	
	@PostMapping("/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "product.jsp";
		}
		pService.create(product);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		
		Product product = pService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categoryList", cService.unassigned(product));
		
		return "showProduct.jsp";
	}
	
	@PostMapping("/add-category")
	public String addCategory(@RequestParam("productId") Long productId, @RequestParam("categoryId") Long categoryId) {
		
		Product thisProduct = pService.findProduct(productId);
		Category categoryToAdd = cService.findCategory(categoryId);
		pService.addCategory(thisProduct, categoryToAdd);
		
		return "redirect:/products/" + productId;
	}
}
