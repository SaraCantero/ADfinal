package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserService;

@Controller
public class adminController {
	
	@Autowired
	private UserService userService;
	private User user;
	
	@GetMapping("/listaClientes")
	public String index(Model model) {
		List<User>user=userService.listarClientes();
		model.addAttribute("user", user);
		return "listaClientes";
	}
	
	@GetMapping("/listaVeterinarios")
	public String indexVet(Model model) {
		List<User>user=userService.listarVeterinarios();
		model.addAttribute("user", user);
		return "listaVeterinarios";
	}
	

	@GetMapping("/newCliente")
	public String agregar(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}
	
	@PostMapping("/addCliente")
	public String guardar(@ModelAttribute User user, RedirectAttributes flash) {
		user.setRole("ROLE_CLIENTE");
		userService.registrar(user);
		return "redirect:/admin/listaClientes";
		
	}
	
	


	@GetMapping("/newVeterinario")
	public String agregarVet(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}
	
	@PostMapping("/añadirVeterinario")
	public String guardarVet(@ModelAttribute User user, RedirectAttributes flash) {
		user.setRole("ROLE_VETERINARIO");
		userService.registrar(user);
		return "redirect:/admin/listaVeterinarios";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		UserRepository userRepository = null;
		List<User>user=userRepository.findById(id);
		model.addAttribute("user", user);
		return "form";
	}


	

}
