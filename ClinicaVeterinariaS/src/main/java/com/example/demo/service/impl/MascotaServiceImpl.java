package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.DozerConfig;
import com.example.demo.entity.Mascota;
import com.example.demo.model.mascotaModel;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.services.mascotaService;

@Service("mascotaService")
public class MascotaServiceImpl implements mascotaService {
	
	@Autowired
	@Qualifier("mascotaRepository")
	private MascotaRepository mascotaRepository;
	
	@Autowired 
	@Qualifier("dozer")
	private DozerConfig dozer;

	
	@Override
	public Mascota añadirMascota(mascotaModel mascotaModel) {
		return mascotaRepository.save(transform(mascotaModel));
	}

	@Override
	public int eliminarMascota(int id) {
		mascotaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Mascota editarMascota(mascotaModel mascotaModel) {
		return mascotaRepository.save(transform(mascotaModel));
	}

	@Override
	public List<mascotaModel> listarMascotas() {
		return mascotaRepository.findAll().stream().map(c->transform(c)).collect(Collectors.toList());
	}


	@Override
	public mascotaModel transform(Mascota mascota) {
		return dozer.map(mascota, mascotaModel.class);
	}


	@Override
	public Mascota transform(mascotaModel mascotaModel) {
		return dozer.map(mascotaModel, Mascota.class);
	}
	
	@Override
	public mascotaModel buscaMascota(int id) {
		return transform(mascotaRepository.findById(id).orElse(null));
	}


}
