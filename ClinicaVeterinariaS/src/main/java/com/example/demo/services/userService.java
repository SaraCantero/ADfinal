package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public interface userService {

		
		public abstract List<User> listarClientes();
		public abstract int borrarCliente(int id);
		public abstract User modificarCliente(User user);
		public abstract User añadirCliente(User user);
		
		public abstract List<User> listarVeterinarios();
		public abstract int borrarVeterinario(int id);
		public abstract User modificarVeterinario(User user);
		public abstract User añadirVeterinario(User user);
		
		public abstract User registrar(User user);
		List<User> listarId(User user);
		
		
		}
		
		
		
		
		
		
	

