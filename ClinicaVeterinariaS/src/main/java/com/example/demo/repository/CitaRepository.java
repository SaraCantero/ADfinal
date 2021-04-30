package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cita;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.User;

@Repository("citaRepository")
public interface CitaRepository {
	
	public abstract Cita findById(int id);
	public abstract List<Cita> findByIdUser(User user);
	public abstract List<Cita> findByIdMascota(Mascota mascota);

}
