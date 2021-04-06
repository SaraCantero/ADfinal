package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
//Esta anotación no es necesaria, así como la anotación Column si no tengo que asignar propiedades.
public class Cliente {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(length=30)
	private String nombre;
	
	@Column(length=50)
	private String apellidos;
	
	@Column(length=10)
	private int telefono;
	
	@Column(length=30)
	private String username;
	
	@Column(length=40)
	private String password;
}