package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;

@Controller
public class LoginController {
	
	@GetMapping("/auth/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/auth/register")
	public String register() {
		return "register";
	}
	
	
	/*@GetMapping("/auth/login")
	public String login (Model model, @RequestParam(name="error", required=false)String error,
				@RequestParam(name="logout", required=false) String logout)
	{
		model.addAttribute("user", new User());
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "login";
	}*/
	
	@GetMapping("/login-post")
	public String loginPost() {
		return "redirect:/clinicaZarpas/";
	}
	
	
	

}
