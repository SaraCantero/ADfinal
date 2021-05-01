package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cita;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.User;

@Repository("citaRepository")
public interface CitaRepository extends JpaRepository <Cita, Serializable>{
	
	public abstract Cita findById(int id);
	

}
