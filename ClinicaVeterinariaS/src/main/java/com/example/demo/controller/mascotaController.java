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

import com.example.demo.entity.Mascota;
import com.example.demo.entity.User;
import com.example.demo.model.mascotaModel;
import com.example.demo.services.mascotaService;
import com.example.demo.services.userService;

@Controller
@RequestMapping("/cli")
public class mascotaController {
	
	private static final String MASCOTAS_VIEW="listaMascotas";
	private static final String FORMMASC_VIEW="formMasc";


	@Autowired
	@Qualifier("mascotaService")
	private mascotaService mascotaService;
	
	@Autowired
	@Qualifier("userService")
	private userService userService;
	
	//listar Mascotas
	@GetMapping("/listaMascotas")
	public ModelAndView listaMascotas() {
		ModelAndView mav=new ModelAndView(MASCOTAS_VIEW);
		mav.addObject("listaMascotas", mascotaService.listarMascotas());
		return mav;
	}
	
	@GetMapping({"/newMascota", "/newMascota/{id}"})
	public String añadirMasc(@PathVariable(name="id", required=false) Integer id, 
			Model model) {
		model.addAttribute("users", userService.listarClientes() );
		if(id==null)
			model.addAttribute("mascota", new mascotaModel());
		else
			model.addAttribute("mascota", mascotaService.buscaMascota(id));
		return FORMMASC_VIEW;
	}

	
	/*@PostMapping("/addMascota")
	public String guardar( @ModelAttribute("mascota") mascotaModel mascotaModel, BindingResult bindingResult
			,RedirectAttributes flash, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("users", userService.listarClientes());
			return FORMMASC_VIEW;}
		else {
			if(mascotaModel.getId()==0) {
				mascotaService.añadirMascota(mascotaModel);
				flash.addFlashAttribute("success", "Mascota registrada correctamente");
			}
			else {
				mascotaService.editarMascota(mascotaModel);
				flash.addFlashAttribute("success", "Mascota modificada");			}
		}
		return "redirect:/cli/listaMascotas";
		
	}
	*/
	//guardar mascota
		@PostMapping("/addMascota")
		public String guardar(@ModelAttribute("mascota") Mascota mascota, BindingResult bindingResult) {
			if(bindingResult.hasErrors())
				return FORMMASC_VIEW;
			else {
			mascotaService.añadirMascota(mascota);
			return "redirect:/cli/listaMascotas";

			}
		}
	
	@GetMapping("/deletedMasc/{id}")
	public String deleteMascota(@PathVariable("id") int id,
			RedirectAttributes flash) {
		if(mascotaService.eliminarMascota(id)==0)
			flash.addFlashAttribute("success", "Mascota eliminada");
		else
			flash.addFlashAttribute("error", "No se ha podido eliminar la mascota");
		return "redirect:/cli/listaMascotas";
	}
	
	//No guarda nuevas marcotas ARREGLAR!
}

