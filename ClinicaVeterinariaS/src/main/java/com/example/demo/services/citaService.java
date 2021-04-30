package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Cita;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.User;

public interface citaService {

	
	public abstract List<Cita> listarCitas();
	public abstract Cita añadirCita(Cita cita);
	List<Cita> listarCitasPorVet(User user);
	List<Cita> listarCitasPorMascota(Mascota mascota);
	Cita findById(int id);
}
