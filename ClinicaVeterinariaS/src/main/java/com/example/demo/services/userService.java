package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public interface userService {

		
		public abstract List<User> listarClientes();
		public abstract void borrarCliente(int id);
		public abstract User modificarCliente(User user);
	
		
		public abstract List<User> listarVeterinarios();
		public abstract void borrarVeterinario(int id);
		public abstract User modificarVeterinario(User user);
		
		public abstract User registrar(User user);
		//
		
		}
		
		
		
		
		
		
	

