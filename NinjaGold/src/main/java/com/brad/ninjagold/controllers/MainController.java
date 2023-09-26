package com.brad.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String showGameboard(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", new ArrayList<String>());
		}
		return "index.jsp";
	}
	
	@PostMapping("/count_gold")
	public String countGold(@RequestParam("id") String id, HttpSession session) {
		
		Integer count = (Integer) session.getAttribute("gold");
		ArrayList<String> logs = (ArrayList<String>) session.getAttribute("activities");
		SimpleDateFormat logTime = new SimpleDateFormat("MMMM d Y h:mm a");
		String dateLog = logTime.format(new Date());
		
		switch(id) {
		case "farm":
			Integer change = new Random().nextInt(11) + 10;
			count += change;
			logs.add(0, String.format(" <p style='color: green;'> You entered a farm and earned %d gold. %s </p>", change, dateLog));
			break;
			
		case "cave":
			change = new Random().nextInt(6) + 5;
			count += change;
			logs.add(0, String.format(" <p style='color: green;'> You entered a cave and earned %d gold. %s </p>", change, dateLog));
			break;
			
		case "house":
			change = new Random().nextInt(3) + 3;
			count += change;
			logs.add(0, String.format(" <p style='color: green;'> You entered a house and earned %d gold. %s </p>", change, dateLog));
			break;
			
		case "spa":
			change = new Random().nextInt(16) + 5;
			count -= change;
			if(count < -50) {
				return "redirect:/prison";
			}
			
			logs.add(0, String.format(" <p style='color: red;'> You entered a spa and lost %d gold. %s </p>", change, dateLog));
			break;
			
		default:
			change = new Random().nextInt(101) - 50;
			count += change;
			if(count < -50) {
				return "redirect:/prison";
			}
			
			if(change >= 0) {
				logs.add(0, String.format(" <p style='color: green;'> You went on a quest and earned %d gold. %s </p>", change, dateLog));
			} else {
				logs.add(0, String.format(" <p style='color: red;'> You went on a quest and lost %d gold. %s </p>", Math.abs(change), dateLog));
			}
		}
		
		session.setAttribute("gold", count);
		return "redirect:/";
	}
	
	
	@GetMapping("/restart")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/prison")
	public String prison() {
		return "prison.jsp";
	}
}
