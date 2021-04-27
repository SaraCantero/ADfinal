package com.example.demo.model;

import java.sql.Date;
import com.example.demo.entity.User;

public class mascotaModel {
	
	private int id;
	private String nombre;
	private String tipo;
	private String raza;
	private Date fechaNacimiento;
	private String foto;
	private User user;

	public mascotaModel() {
		// TODO Auto-generated constructor stub
	}



	public mascotaModel(int id, String nombre, String tipo, String raza, Date fechaNacimiento, String foto,
			User idUser) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.raza = raza;
		this.fechaNacimiento = fechaNacimiento;
		this.foto = foto;
		this.user = user;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}





	
	

}
