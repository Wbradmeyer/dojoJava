package com.brad.productsandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.brad.productsandcategories.services.CategoryService;
import com.brad.productsandcategories.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private CategoryService cService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", pService.findAllProducts());
		model.addAttribute("categories", cService.findAllCategories());		
		return "index.jsp";
	}
}
