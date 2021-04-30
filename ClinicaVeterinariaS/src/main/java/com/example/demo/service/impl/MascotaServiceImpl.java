package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Mascota;
import com.example.demo.entity.User;
import com.example.demo.model.mascotaModel;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.services.mascotaService;

@Service("mascotaService")
public class MascotaServiceImpl implements mascotaService {
	
	@Autowired
	@Qualifier("mascotaRepository")
	private MascotaRepository mascotaRepository;
	
	@Autowired 
	private DozerBeanMapper dozer;

	
	/*@Override
	public Mascota añadirMascota(mascotaModel mascotaModel) {
		return mascotaRepository.save(transform(mascotaModel));
	}*/

	@Override
	public int eliminarMascota(int id) {
		mascotaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Mascota editarMascota(mascotaModel mascotaModel) {
		return mascotaRepository.save(transform(mascotaModel));
	}

	/*@Override
	public List<mascotaModel> listarMascotas() {
		return mascotaRepository.findAll().stream().
				map(c->transform(c)).collect(Collectors.toList());
	}*/
	
	@Override
	public List<Mascota> listarMascotas(){
		return mascotaRepository.findAll();
	}
	
	@Override
	public List<Mascota> listarMascotasPorCliente(User user){
		return mascotaRepository.findByUser(user);
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
	public Mascota findById(int id) {
		return mascotaRepository.findById(id);
	}


	@Override
	public Mascota añadirMascota(Mascota mascota) {
		return mascotaRepository.save(mascota);
		
	}

	@Override
	public mascotaModel buscaMascota(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
