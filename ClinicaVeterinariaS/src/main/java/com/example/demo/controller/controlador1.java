package com.example.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controlador1 {

	@GetMapping("/")
	public String index() {
		return "redirect:/clinicaZarpas";
	}
	
	@GetMapping("/infoClinica")
	public String infoClini() {
		return "infoClinica";
	}
	
	@GetMapping("/perfilCliente")
	public String editarPerfil(Principal principal) {
		System.out.println(principal.getName());
		return "editarCliente";
	}
	
	@GetMapping("/clinicaZarpas")
	public String clinica() {
		return "clinicaZarpas";
	}
	
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
	
	@GetMapping("/admin")
	public String sitioAdmin() {
		return "admin";
	}

	@GetMapping("/cli")
	public String listaMasc() {
		return "listaMascotas";
	}
	
	
}
