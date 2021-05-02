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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//CLIENTES
	//listar Clientes
	@GetMapping("/listaClientes")
	public ModelAndView listaClientes() {
		ModelAndView mav=new ModelAndView(CLIENTES_VIEW);
		mav.addObject("listaClientes", userService.listarClientes());
		return mav;
	}
	
	//guardar un nuevo cliente
	@PostMapping("/addCliente")
	public String guardar(@ModelAttribute("user") User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return FORMCLI_VIEW;
		else {
		userService.añadirCliente(user);
		return "redirect:/admin/listaClientes";

		}
	}
	
	//Ir a formulario de nuevo cliente
    @PostMapping("/newCliente")
    public String agregar(Model model, @RequestParam(name="error",required=false) String error,RedirectAttributes flash){
        model.addAttribute("user",new User());
        model.addAttribute("error",error);
        flash.addFlashAttribute("success", "Usuario registrado");
        return FORMCLI_VIEW;
    }
    
    //Ir a formulario editar cliente
    @GetMapping("/newCliente/{id}")
    public String editar(Model model,@PathVariable(name="id")int id) {
        User user=userService.findByUserId(id);
        model.addAttribute("user", user);
        return FORMCLI_VIEW;
    }
	
    //Activar cliente
	@PostMapping("/activarCli/{id}")
	public String activar(Model model, @PathVariable(name="id")int id, RedirectAttributes flash) {
		User user=userService.findByUserId(id);
		user.setEnabled(true);
		model.addAttribute("user", user);
		userService.añadirCliente(user);
		return "redirect:/admin/listaClientes";
		
	}
	

	//Borrar cliente
	@GetMapping("/deletedCli/{id}")
	public String deleteCliente(@PathVariable("id") int id,
			RedirectAttributes flash) {
		if(userService.borrarCliente(id)==0)
			flash.addFlashAttribute("success", "Usuario eliminado");
		else
			flash.addFlashAttribute("error", "No se ha podido eliminar el suaurio");
		return "redirect:/admin/listaClientes";
	}
	
	//VETERINARIOS
	
	//listar veterinarios
	@GetMapping("/listaVeterinarios")
	public ModelAndView listaVeterinarios() {
		ModelAndView mav=new ModelAndView(VETERINARIOS_VIEW);
		mav.addObject("listaVeterinarios", userService.listarVeterinarios());
		return mav;
	}

	//guardar un nuevo veterinario
	@PostMapping("/addVeterinario")
	public String guardarVet(@ModelAttribute("user") User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return FORMVET_VIEW;
		else {
		userService.añadirVeterinario(user);
		return "redirect:/admin/listaVeterinarios";

		}
	}
	
	//Ir a formulario de nuevo veterinario
    @PostMapping("/newVeterinario")
    public String agregarVet(Model model, @RequestParam(name="error",required=false) String error,RedirectAttributes flash){
        model.addAttribute("user",new User());
        model.addAttribute("error",error);
        flash.addFlashAttribute("success", "Usuario registrado");
        return FORMVET_VIEW;
    }
    
  
    
    //Ir a formulario editar veterinario
    @GetMapping("/newVeterinario/{id}")
    public String editarVet(Model model,@PathVariable(name="id")int id) {
        User user=userService.findByUserId(id);
        model.addAttribute("user", user);
        return FORMVET_VIEW;
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
