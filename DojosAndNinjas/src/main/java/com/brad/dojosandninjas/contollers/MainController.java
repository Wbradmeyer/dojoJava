package com.brad.dojosandninjas.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brad.dojosandninjas.models.Dojo;
import com.brad.dojosandninjas.models.Ninja;
import com.brad.dojosandninjas.services.DojoService;
import com.brad.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "dojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "dojo.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "ninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "ninja.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model ) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "show.jsp";
	}
}
