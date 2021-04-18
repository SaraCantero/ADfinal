package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserService;

@Controller
public class controladorUser {

	
	@Autowired
	private UserService userService;
	private User user;
	
	@RequestMapping("/list")
	public String index(Model model) {
		model.addAttribute(userService.listAllUser());
		return "lista";
	}
	
	@GetMapping("/guardar/{id}")
	public String guardar(@PathVariable("id") Long id, Model model) {
		if (id != null ) {
			model.addAttribute("user", user.getId());
		}else
		{
			model.addAttribute("user", new User());
		}
		return "guardar";
	}
	
	

}
