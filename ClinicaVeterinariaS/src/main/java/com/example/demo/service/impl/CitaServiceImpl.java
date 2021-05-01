package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cita;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.User;
import com.example.demo.repository.CitaRepository;
import com.example.demo.services.citaService;

@Service("citaService")
public class CitaServiceImpl implements citaService {
	
	@Autowired
	@Qualifier("citaRepository")
	private CitaRepository citaRepository;

	@Override
	public List<Cita> listarCitas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita añadirCita(Cita cita) {
		// TODO Auto-generated method stub
		return citaRepository.save(cita);
	}


	@Override
	public List<Cita> listarCitasPorVet(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cita> listarCitasPorMascota(Mascota mascota) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
