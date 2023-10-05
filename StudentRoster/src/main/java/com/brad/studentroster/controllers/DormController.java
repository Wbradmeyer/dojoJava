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
import org.springframework.web.bind.annotation.RequestParam;

import com.brad.studentroster.models.Dorm;
import com.brad.studentroster.models.Student;
import com.brad.studentroster.services.DormService;
import com.brad.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dorms")
public class DormController {
	
	@Autowired
	private DormService dormServ;
	
	@Autowired
	private StudentService studentServ;
	
	@PostMapping("/new")
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm d, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		
		dormServ.create(d);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model) {
		
		Dorm thisDorm = dormServ.find(id);
		model.addAttribute("dorm", thisDorm);
		model.addAttribute("allStudents", studentServ.allStudents());
		model.addAttribute("assigned", thisDorm.getStudents());
		
		return "dorm.jsp";
	}
	
	@PostMapping("/add-student")
	public String addStudent(@RequestParam("dormId") Long dormId, @RequestParam("studentId") Long studentId) {
		
		Dorm thisDorm = dormServ.find(dormId);
		Student studentToAdd = studentServ.find(studentId);
		studentToAdd.setDorm(thisDorm);
		thisDorm.getStudents().add(studentToAdd);
		
		return "redirect:/dorms/" + dormId;
	}
}
