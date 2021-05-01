package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.services.userService;

@Controller
public class controlador1 {
	
	@Autowired
	@Qualifier("userService")
	private userService userService;

	@GetMapping("/")
	public String index() {
		return "redirect:/clinicaZarpas";
	}
	
	@GetMapping("/infoClinica")
	public String infoClini() {
		return "infoClinica";
	}
	
	@GetMapping("/perfilCliente")
	public String editarPerfil() {
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
	
//    //Ir a formulario editar cliente
//    @GetMapping("/perfilCliente/{id}")
//    public String editarPerfil(Model model,@PathVariable(name="id")int id) {
//        User user=userService.findByUserId(id);
//        model.addAttribute("user", user);
//        return "formCli";
//    }
    
    //guardar cambios
	@PostMapping("/addCliente")
	public String guardar(@ModelAttribute("user") User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "formCli";
		else {
		userService.añadirCliente(user);
		return "redirect:/listaMascotas";

		}
	}
	
	
	
}
