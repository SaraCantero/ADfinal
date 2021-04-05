package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity


public class mascota {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column (length=30)
	private String nombre;
	
	@Column(length=30)
	private String tipo;
	
	@Column(length=30)
	private String raza;
	
	@Column
	private Date fechaNacimiento;
	
	@Column(length=100)
	private String foto;
	
	@Column(length=11)
	private int idCliente;
	

}
