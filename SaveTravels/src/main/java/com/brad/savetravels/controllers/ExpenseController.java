package com.brad.savetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.brad.savetravels.models.Expense;
import com.brad.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService service;
	
//	Create Controller
	@PostMapping("/expenses/new")
	public String newExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "index.jsp";
		}
		service.createExpense(expense);
		return "redirect:/expenses";
	}
	
//	Read Controllers
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String displayDashboard(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expenses", service.getAllExpenses());
		return "index.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String displayOneExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", service.getOneExpenseById(id));
		return "show.jsp";
	}
	
//	Update Controllers
	@GetMapping("/expenses/{id}/edit")
	public String displayEdit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", service.getOneExpenseById(id));
		return "edit.jsp";
	}
	
	@PutMapping("expenses/edit")
	public String editExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "edit.jsp";
		}
		service.updateExpense(expense);
		return "redirect:/expenses";
	}
	
//	Delete Controller
	@DeleteMapping("/expenses/{id}/delete")
	public String destroyExpense(@PathVariable("id") Long id) {
		service.deleteExpenseById(id);
		return "redirect:/expenses";
	}
}
