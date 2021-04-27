package com.example.demo.controller;



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
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	
	
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
	
	@GetMapping({"/newCliente", "/newCliente/{id}"})
	public String agregar(@PathVariable(name="id", required=false) User id, Model model) {
		if(id==null)
			model.addAttribute("user", new User());
		else
			model.addAttribute("user", userService.findUserId(id));
		return FORMCLI_VIEW;
	}
	
	@PostMapping("/addCliente")
	public String guardar(@ModelAttribute("user") User user, BindingResult bindingResult
			,RedirectAttributes flash, Model model) {
		if(bindingResult.hasErrors())
			return FORMCLI_VIEW;
		else {
			if(user.getId()==0) {
				userService.añadirCliente(user);
				flash.addFlashAttribute("success", "Cliente registrado correctamente");
			}
			else {
				userService.modificarCliente(user);
				flash.addFlashAttribute("success", "Cliente modificado");			}
		}
		return "redirect:/admin/listaClientes";
		
	}
	
	@GetMapping("/activarCli/{id}")
	public String activar(@ModelAttribute("user") User user) {
		user.setEnabled(true);
		return "redirect:/admin/listaClientes";
		
	}

	@GetMapping({"/newVeterinario", "/newVeterinario/{id}"})
	public String agregarVet(Model model) {
		model.addAttribute("user", new User());
		return FORMVET_VIEW;
	}
	
	@PostMapping("/addVeterinario")
		public String guardarVet(@ModelAttribute("user") User user, BindingResult bindingResult
				,RedirectAttributes flash, Model model) {
			if(bindingResult.hasErrors())
				return FORMVET_VIEW;
			else {
				if(user.getId()==0) {
					userService.añadirVeterinario(user);
					flash.addFlashAttribute("success", "Veterinario registrado correctamente");
				}
				else {
					userService.modificarVeterinario(user);
					flash.addFlashAttribute("success", "Veterinario modificado");			}
			}
			return "redirect:/admin/listaVeterinarios";
			
		}	
	
	@GetMapping("/deletedCli/{id}")
	public String deleteCliente(@PathVariable("id") int id,
			RedirectAttributes flash) {
		if(userService.borrarCliente(id)==0)
			flash.addFlashAttribute("success", "Usuario eliminado");
		else
			flash.addFlashAttribute("error", "No se ha podido eliminar el suaurio");
		return "redirect:/admin/listaClientes";
	}
	
	@GetMapping("/deletedVet/{id}")
	public String deleteVeterinario(@PathVariable("id") int id,
			RedirectAttributes flash) {
		if(userService.borrarVeterinario(id)==0)
			flash.addFlashAttribute("success", "Usuario eliminado");
		else
			flash.addFlashAttribute("error", "No se ha podido eliminar el suaurio");
		return "redirect:/admin/listaVeterinarios";
	}


	

}
