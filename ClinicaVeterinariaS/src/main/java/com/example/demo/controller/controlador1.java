package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controlador1 {

	@GetMapping("/inicio")
	public String index() {
		return "index";
	}
	
	@GetMapping("/infoClinica")
	public String infoClini() {
		return "infoClinica";
	}
	
	@GetMapping("/clinicaZarpas")
	public String clinica() {
		return "clinicaZarpas";
	}
	
}
