package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Mascota;

public class userModel {
	
	private int id;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String username;
	private String password;
	private boolean enabled;
	private String role;
	private List<Mascota>mascotas;
	
	public userModel() {
		super();
	}

	

	public userModel(int id, String nombre, String apellidos, int telefono, String username, String password,
			boolean enabled, String role, List<Mascota> mascotas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.mascotas = mascotas;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public List<Mascota> getMascotas() {
		return mascotas;
	}



	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	
	
	

}
