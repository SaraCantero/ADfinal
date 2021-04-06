package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity


public class Cita {

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idMascota", 
				foreignKey= @ForeignKey(name="mascota_id_fk"),
				nullable=false)
	private Mascota mascota;
	
	@ManyToOne
	@JoinColumn (name="idVeterinario",
				foreignKey=@ForeignKey(name="veterinario_id_fk"),
				nullable=false)
	
	private Veterinario veterinario;
	
	@Column
	private Date fecha;
	
	@Column(length=100)
	private String motivo;
	
	@Column
	private String informe;
	
	@Column
	private boolean realizada;

}
