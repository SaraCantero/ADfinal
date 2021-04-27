package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Mascota;
import com.example.demo.model.mascotaModel;

@Configuration
@Component("dozer")
public class DozerConfig {

	public mascotaModel map(Mascota mascota, Class<mascotaModel> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Mascota map(mascotaModel mascotaModel, Class<Mascota> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
