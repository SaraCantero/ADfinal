package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Veterinario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column (length=30)
	private String nombre;
	
	@Column(length=50)
	private String apellidos;
	
	@Column(length=10)
	private String telefono;
	
	@Column(length=30)
	private String username;
	
	@Column(length=40)
	private String password;
	

}
