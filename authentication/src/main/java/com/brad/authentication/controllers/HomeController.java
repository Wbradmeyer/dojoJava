package com.brad.authentication.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brad.authentication.models.LoginUser;
import com.brad.authentication.models.User;
import com.brad.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}
	
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {
		
		Boolean isValid = userServ.isValid(result, newUser);
		
		if(result.hasErrors() || isValid != true) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		userServ.createUser(newUser);
		
		session.setAttribute("loggedIn", newUser.getId());
		
		return "redirect:/home";
	}
	
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
			BindingResult result, Model model, HttpSession session) {
		
		Boolean validUser = userServ.validLogin(result, newLogin, session);
		
		if(result.hasErrors() || !validUser) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		return "redirect:/home";
	}
	
	
	@GetMapping("/home")
	public String success(HttpSession session, Model model, RedirectAttributes flash) {
		
		if(session.getAttribute("loggedIn") == null) {
			flash.addFlashAttribute("error", "Please log in.");
			return "redirect:/";			
		}
		
		User loggedIn = userServ.findUser((Long)session.getAttribute("loggedIn"));
		
		model.addAttribute("loggedInUser", loggedIn);
		
		return "welcome.jsp";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
}
