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

import com.example.demo.entity.Mascota;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.services.mascotaService;

@Controller
@RequestMapping("/cli")
public class mascotaController {
	
	private static final String MASCOTAS_VIEW="listaMascotas";
	private static final String FORMMASC_VIEW="formMasc";


	@Autowired
	@Qualifier("mascotaService")
	private mascotaService mascotaService;
	
	@Autowired
	@Qualifier("mascotaRepository")
	private MascotaRepository mascotaRepository;
	
	@GetMapping("/listaMascotas")
	public ModelAndView listaMascotas() {
		ModelAndView mav=new ModelAndView(MASCOTAS_VIEW);
		mav.addObject("listaMascotas", mascotaService.listAllMascotas());
		return mav;
	}
	
	@GetMapping({"/newMascota", "/newMascota/{id}"})
	public String añadir(Model model) {
		model.addAttribute("mascota", new Mascota());
		return FORMMASC_VIEW;
	}

	
	@PostMapping("/addMascota")
	public String guardar(@ModelAttribute("mascota") Mascota mascota, BindingResult bindingResult
			,RedirectAttributes flash, Model model) {
		if(bindingResult.hasErrors())
			return FORMMASC_VIEW;
		else {
			if(mascota.getId()==0) {
				mascotaService.añadirMascota(mascota);
				flash.addFlashAttribute("success", "Mascota registrada correctamente");
			}
			else {
				mascotaService.editarMascota(mascota);
				flash.addFlashAttribute("success", "Mascota modificada");			}
		}
		return "redirect:/cli/listaMascotas";
		
	}
	
	@GetMapping("/deletedMasc/{id}")
	public String deleteMAscota(@PathVariable("id") int id,
			RedirectAttributes flash) {
		if(mascotaService.eliminarMascota(id)==0)
			flash.addFlashAttribute("success", "Mascota eliminada");
		else
			flash.addFlashAttribute("error", "No se ha podido eliminar la mascota");
		return "redirect:/cli/listaMascotas";
	}
	
}

