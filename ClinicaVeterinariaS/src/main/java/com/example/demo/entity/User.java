package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	private boolean enabled=false;
	
	private String role;

//	@OneToMany( cascade=CascadeType.ALL)
//	private List<Mascota>mascotas;

	public User(int id, String username, String password, String apellidos, String telefono, String nombre,
			boolean enabled, String role, List<Mascota> mascotas) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.nombre = nombre;
		this.enabled = enabled;
		this.role = role;
//		this.mascotas = mascotas;
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
	
//	public List<Mascota> getMascotas() {
//		return mascotas;
//	}
//
//	public void setMascotas(List<Mascota> mascotas) {
//		this.mascotas = mascotas;
//	}

	
	



}
