package com.brad.daikichipathvariables.controllers;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FruitController {
	@RequestMapping("/")
	public String index(Model model) {
		ArrayList<String> teams = new ArrayList<>();
		teams.add("Georgia");
		teams.add("Kentucky");
		teams.add("Florida");
		teams.add("Tennessee");
		
		model.addAttribute("teamsFromController", teams);
		
		return "demo.jsp";
	}
}
