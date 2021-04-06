package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity


public class cita {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn
	private mascota idMascota;
	
	@ManyToOne
	@JoinColumn
	private veterinario idVeterinario;
	
	@Column
	private Date fecha;
	
	@Column(length=100)
	private String motivo;
	
	@Column
	private String informe;
	
	@Column
	private boolean realizada;

}
