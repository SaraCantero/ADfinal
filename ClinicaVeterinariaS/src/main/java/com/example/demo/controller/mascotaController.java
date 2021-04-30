package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

import com.example.demo.entity.Cita;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.User;
import com.example.demo.services.mascotaService;
import com.example.demo.services.userService;

@Controller
@RequestMapping("/cli")
public class mascotaController {
	
	private static final String MASCOTAS_VIEW="listaMascotas";
	private static final String FORMMASC_VIEW="formMasc";
	private static final String FORMCITA_VIEW="formCita";


	@Autowired
	@Qualifier("mascotaService")
	private mascotaService mascotaService;
	
	@Autowired
	@Qualifier("userService")
	private userService userService;
	
	//listar Mascotas
	@GetMapping("/listaMascotas")
	public ModelAndView listaMascotas() {
		UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user =  userService.findByUsername(username);
		ModelAndView mav=new ModelAndView(MASCOTAS_VIEW);
		mav.addObject("listaMascotas", mascotaService.listarMascotasPorCliente(user));
		return mav;
	}
	
	//Ir a formulario de nueva mascota
    @PostMapping("/newMascota")
    public String agregar(Model model, @RequestParam(name="error",required=false) String error,RedirectAttributes flash){
        model.addAttribute("mascota",new Mascota());
        model.addAttribute("error",error);
        flash.addFlashAttribute("success", "Mascota registrado");
        return FORMMASC_VIEW;
    }
    
    //Ir a formulario editar mascota
    @GetMapping("/newMascota/{id}")
    public String editar(Model model,@PathVariable(name="id")int id) {
        Mascota mascota=mascotaService.findById(id);
        model.addAttribute("mascota", mascota);
        return FORMMASC_VIEW;
    }
	
	//guardar mascota
		@PostMapping("/addMascota")
		public String guardar(@ModelAttribute("mascota") Mascota mascota, BindingResult bindingResult) {
			if(bindingResult.hasErrors())
				return FORMMASC_VIEW;
			else {
				UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		        String username = userDetails.getUsername();
		        User user =  userService.findByUsername(username);
		        mascota.setUser(user);
		        mascotaService.añadirMascota(mascota);
		        return "redirect:/cli/listaMascotas";
			}
			
		}
	 //borrar mascota
	@GetMapping("/deletedMasc/{id}")
	public String deleteMascota(@PathVariable("id") int id,
			RedirectAttributes flash) {
		if(mascotaService.eliminarMascota(id)==0)
			flash.addFlashAttribute("success", "Mascota eliminada");
		else
			flash.addFlashAttribute("error", "No se ha podido eliminar la mascota");
		return "redirect:/cli/listaMascotas";
	}
	
	//pedir cita
	@PostMapping("/pedirCita/{id}")
	public String pedirCita(@ModelAttribute("cita") Cita cita, BindingResult bindingResult) {
			if(bindingResult.hasErrors())
				return FORMCITA_VIEW;
			else {;
		        
			}
		return null;}
	
	
	
}

