package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity


public class cita {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(length=11)
	private int idMascota;
	
	@Column(length=11)
	private int idVeterinario;
	
	@Column
	private Date fecha;
	
	@Column(length=100)
	private String motivo;
	
	@Column
	private String informe;
	
	@Column
	private boolean realizada;

}
