package com.brad.studentroster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brad.studentroster.models.ClassEx;
import com.brad.studentroster.services.ClassService;
import com.brad.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/classes")
public class ClassController {

	@Autowired
	private ClassService classServ;
	
	@Autowired
	private StudentService studentServ;
	
	@PostMapping("/new")
	public String createClass(@Valid @ModelAttribute("classEx") ClassEx c, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		
		classServ.create(c);
		return "redirect:/";
	}
	
	@GetMapping("")
	public String showClasses(Model model) {
		
		model.addAttribute("classes", classServ.allClasses());
		return "classes.jsp";
	}
	
	@GetMapping("/{id}")
	public String showOneClass(@PathVariable("id") Long id, Model model) {
		
		ClassEx thisClass = classServ.find(id);
		model.addAttribute("thisClass", thisClass);
		model.addAttribute("students", studentServ.studentsByClass(thisClass));
		return "roster.jsp";
	}
}
