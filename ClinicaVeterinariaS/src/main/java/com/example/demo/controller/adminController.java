package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.userService;

@Controller
@RequestMapping("/admin")
public class adminController {
	
	private static final String CLIENTES_VIEW="listaClientes";
	private static final String VETERINARIOS_VIEW="listaVeterinarios";
	private static final String FORMCLI_VIEW="formCli";
	private static final String FORMVET_VIEW="formVet";
	
	@Autowired
	@Qualifier("userService")
	private userService userService;
	
	
	@GetMapping("/listaClientes")
	public ModelAndView listaClientes() {
		ModelAndView mav=new ModelAndView(CLIENTES_VIEW);
		mav.addObject("listaClientes", userService.listarClientes());
		return mav;
	}
	
	@GetMapping("/listaVeterinarios")
	public ModelAndView listaVeterinarios() {
		ModelAndView mav=new ModelAndView(VETERINARIOS_VIEW);
		mav.addObject("listaVeterinarios", userService.listarVeterinarios());
		return mav;
	}
	
	@GetMapping("/newCliente")
	public String agregar(Model model) {
		model.addAttribute("user", new User());
		return FORMCLI_VIEW;
	}
	
	@PostMapping("/addCliente")
	public String guardar(@ModelAttribute("user") User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return FORMCLI_VIEW;
		else {
		userService.añadirCliente(user);
		return "redirect:/admin/listaClientes";
		}
	}

	@GetMapping("/newVeterinario")
	public String agregarVet(Model model) {
		model.addAttribute("user", new User());
		return FORMVET_VIEW;
	}
	
	@PostMapping("/addVeterinario")
	public String guardarVet(@ModelAttribute User user, RedirectAttributes flash) {
		userService.añadirVeterinario(user);
		return "redirect:/admin/listaVeterinarios";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		UserRepository userRepository = null;
		List<User>user=userRepository.findById(id);
		model.addAttribute("user", user);
		return "formCli";
	}


	

}
