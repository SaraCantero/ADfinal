package com.example.demo.controller;

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
import com.example.demo.services.citaService;
import com.example.demo.services.mascotaService;
import com.example.demo.services.userService;

@Controller
@RequestMapping("/cli")
public class mascotaController {
	
	private static final String MASCOTAS_VIEW="listaMascotas";
	private static final String FORMMASC_VIEW="formMasc";
	private static final String FORMCITA_VIEW="formCita";
	private static final String FORMCLI_VIEW="formCli";


	@Autowired
	@Qualifier("mascotaService")
	private mascotaService mascotaService;
	
	@Autowired
	@Qualifier("userService")
	private userService userService;
	
	@Autowired
	@Qualifier("citaService")
	private citaService citaService;
	
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
		public String guardar(RedirectAttributes flash, @ModelAttribute("mascota") Mascota mascota, BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				flash.addFlashAttribute("error", "Error en el formulario, no se ha añadido la mascota");
				return FORMMASC_VIEW;}
			
			else {
				UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		        String username = userDetails.getUsername();
		        User user =  userService.findByUsername(username);
		        mascota.setUser(user);
		        mascotaService.añadirMascota(mascota);
		        flash.addFlashAttribute("success", "Mascota añadida o editada correctamente");
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
	
	
	//ir a formulario de citas
	   @PostMapping("/newCita")
	    public String nuevaCita(Model model, @RequestParam(name="error",required=false) String error,RedirectAttributes flash){
		      	model.addAttribute("cita",new Cita());
		        model.addAttribute("users", userService.listarVeterinarios());
		        model.addAttribute("mascotas", mascotaService.listarMascotas());
		      	model.addAttribute("error",error);
		        flash.addFlashAttribute("success", "Cita guardada");
		        return FORMCITA_VIEW;
	    }
	   
	   
	@PostMapping("/addCita")
	public String pedirCita(RedirectAttributes flash, @ModelAttribute("cita") Cita cita, BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				flash.addFlashAttribute("error", "Error al pedir esta cita");
				return FORMCITA_VIEW;}
			else {
				citaService.añadirCita(cita);
				return "redirect:/cli/listaMascotas";
			}
	}
	
	

	
}

