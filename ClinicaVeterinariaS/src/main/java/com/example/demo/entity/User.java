package com.example.demo.entity;

import java.util.Collection;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class User {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="username", nullable=false, length=30)
	private String username;
	
	@Column(name="password", nullable=false, length=100)
	private String password;
	
	@Column(name="apellidos", nullable=false, length=50)
	private String apellidos;
	
	@Column(name="telefono", nullable=false, length=100)
	private String telefono;
	
	@Column(name="nombre", nullable=false, length=100)
	private String nombre;
	
	private boolean enabled;
	
	private String role;

	public User(int id, String username, String password, String apellidos, String telefono, String nombre,
			boolean enabled, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.nombre = nombre;
		this.enabled = enabled;
		this.role = role;
	}

	public User() {
		super();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	



}
