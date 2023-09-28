package com.brad.savetravels.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brad.savetravels.models.Expense;
import com.brad.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository repo;

//	Create Service
	public Expense createExpense(Expense expense) {
		return repo.save(expense);
	}
	
//	Read Services
	public ArrayList<Expense> getAllExpenses() {
		return repo.findAll();
	}
	
	public Expense getOneExpenseById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
//	Update Service
	public Expense updateExpense(Expense expense) {
		return repo.save(expense);
	}
	
//	Delete Service
	public void deleteExpenseById(Long id) {
		repo.deleteById(id);
	}
}
