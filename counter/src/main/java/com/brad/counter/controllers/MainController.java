package com.brad.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	int count = 0;
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") != null) {
			count++;
		}
		session.setAttribute("count", count);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String displayCounter() {
		return "counter.jsp";
	}
	
	@RequestMapping("/clear")
	public String clearSession(HttpSession session) {
		count = 0;
		session.setAttribute("count", count);
		return "counter.jsp";
	}
	
	@RequestMapping("/addtwo")
	public String addTwo(HttpSession session) {
		count += 2;
		session.setAttribute("count", count);
		return "bytwo.jsp";
	}
}
