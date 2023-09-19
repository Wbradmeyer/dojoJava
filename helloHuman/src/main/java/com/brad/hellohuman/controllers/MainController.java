package com.brad.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String searchQuery, String last_name, Integer times) {
		String greeting = "";
		if(searchQuery == null && last_name == null) {
			greeting = "Hello human.";
		} else if (last_name == null){
			greeting = "Hello " + searchQuery;
		} else {
			greeting = String.format("Hello %s %s", searchQuery, last_name);
		}
		if(times != null) {
			greeting = (greeting + " ").repeat(times);
		}
		return greeting;
	}
}
