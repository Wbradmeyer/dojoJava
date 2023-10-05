package com.brad.studentroster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.brad.studentroster.models.ClassEx;
import com.brad.studentroster.models.Dorm;
import com.brad.studentroster.models.Student;
import com.brad.studentroster.services.DormService;

@Controller
public class MainController {
	
	@Autowired
	private DormService dormServ;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("dorms", dormServ.allDorms());
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String newEntry(@ModelAttribute("dorm") Dorm d, @ModelAttribute("student") Student s, @ModelAttribute("classEx") ClassEx c) {
		return "new.jsp";
	}
}
