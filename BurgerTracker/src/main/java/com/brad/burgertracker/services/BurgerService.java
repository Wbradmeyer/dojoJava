package com.brad.burgertracker.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brad.burgertracker.models.Burger;
import com.brad.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	@Autowired
	private BurgerRepository burgerRepository;
	
	public ArrayList<Burger> getAllBurgers() {
		return burgerRepository.findAll();
	}
	
	public Burger getOneBurger(Long id) {
		return burgerRepository.findById(id).orElse(null);
	}
	
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
}
