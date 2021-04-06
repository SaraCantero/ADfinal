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
public class Mascota {

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
	
	@ManyToOne
	@JoinColumn(name="idCliente",
			foreignKey=@ForeignKey(name="cliente_id_fk"),
			nullable=false)
	private Cliente cliente;
	

}
