package com.brad.studentroster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brad.studentroster.models.Student;
import com.brad.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentServ;
	
	@PostMapping("/new")
	public String createStudent(@Valid @ModelAttribute("student") Student s, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		
		studentServ.create(s);
		return "redirect:/";
	}
}
