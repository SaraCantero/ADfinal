package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserService;

@Controller
public class LoginController {

	
	@GetMapping("/auth/registerForm")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	
	private UserService userService;
	
	@PostMapping("/auth/register")
	public String register(@ModelAttribute User user, RedirectAttributes flash) {
		userService.registrar(user);
		flash.addFlashAttribute("success", "Usuario registrado correctamente");
		return "redirect:/auth/login";
	}
	
	
	@GetMapping("/auth/login")
	public String login (Model model, @RequestParam(name="error", required=false)String error,
				@RequestParam(name="logout", required=false) String logout)
	{
		model.addAttribute("user", new User());
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "login";
	}
	
	@GetMapping("/login-post")
	public String loginPost() {
		return "redirect:/clinicaZarpas";
	}
	
	
	

}
