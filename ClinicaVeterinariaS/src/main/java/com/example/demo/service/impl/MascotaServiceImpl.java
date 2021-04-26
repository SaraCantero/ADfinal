package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Mascota;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.services.mascotaService;

@Service("mascotaService")
public class MascotaServiceImpl implements mascotaService {
	
	@Autowired
	@Qualifier("mascotaRepository")
	private MascotaRepository mascotaRepository;

	@Override
	public List<Mascota> listAllMascotas() {
		return mascotaRepository.findAll();
	}

	@Override
	public Mascota añadirMascota(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}

	@Override
	public int eliminarMascota(int id) {
		mascotaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Mascota editarMascota(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}

	
}
