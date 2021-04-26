package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Mascota;

public interface mascotaService {

	public abstract List<Mascota> listAllMascotas();
	public abstract Mascota añadirMascota(Mascota mascota);
	public abstract int eliminarMascota(int id);
	public abstract Mascota editarMascota(Mascota mascota);
	
	
	
}
