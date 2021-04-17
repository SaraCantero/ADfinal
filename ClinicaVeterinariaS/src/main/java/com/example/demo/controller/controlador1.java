package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controlador1 {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/infoClinica")
	public String infoClini() {
		return "infoClinica";
	}
	
	@GetMapping("/perfilCliente")
	public String editarPerfil() {
		return "perfilCliente";
	}
	
	@GetMapping("/clinicaZarpas")
	public String clinica() {
		return "clinicaZarpas";
	}
	
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}

	
	
}
