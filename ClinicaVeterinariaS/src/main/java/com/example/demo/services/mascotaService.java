package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Mascota;
import com.example.demo.entity.User;
import com.example.demo.model.mascotaModel;

public interface mascotaService {

	public abstract List<Mascota> listarMascotas();
	//public abstract Mascota añadirMascota(mascotaModel mascotaModel);
	public abstract int eliminarMascota(int id);
	public abstract Mascota editarMascota(mascotaModel mascotaModel);
	public abstract Mascota transform (mascotaModel mascotaModel);
	public abstract mascotaModel transform(Mascota mascota);
	public abstract mascotaModel buscaMascota(int id);
	public abstract Mascota añadirMascota(Mascota mascota);
	
	
	
	
}
