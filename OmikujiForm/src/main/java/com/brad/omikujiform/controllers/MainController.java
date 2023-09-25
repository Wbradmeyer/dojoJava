package com.brad.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String displayForm() {
		return "index.jsp";
	}
	
	@PostMapping("/omikuji/collect")
	public String collectData(@RequestParam("quantity") Integer quantity,
							@RequestParam("city") String city,
							@RequestParam("person") String person,
							@RequestParam("hobby") String hobby,
							@RequestParam("thing") String thing,
							@RequestParam("nice") String nice, HttpSession session) {
		session.setAttribute("quantity", quantity);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String displayFortune() {
		return "fortune.jsp";
	}
}
