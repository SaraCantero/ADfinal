package com.example.demo.model;
import java.sql.Date;

import javax.persistence.ManyToOne;

import com.example.demo.entity.mascota;
import com.example.demo.entity.veterinario;



public class citaModel {
	
	private int id;
	private mascota idMascota;
	private veterinario idVeterinario;
	private Date fecha;
	private String motivo;
	private String informe;
	private boolean realizada;
	

	

	public citaModel() {
		// TODO Auto-generated constructor stub
	}


	public citaModel(int id, mascota idMascota, veterinario idVeterinario, Date fecha, String motivo, String informe,
			boolean realizada) {
		super();
		this.id = id;
		this.idMascota = idMascota;
		this.idVeterinario = idVeterinario;
		this.fecha = fecha;
		this.motivo = motivo;
		this.informe = informe;
		this.realizada = realizada;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public mascota getIdMascota() {
		return idMascota;
	}


	public void setIdMascota(mascota idMascota) {
		this.idMascota = idMascota;
	}


	public veterinario getIdVeterinario() {
		return idVeterinario;
	}


	public void setIdVeterinario(veterinario idVeterinario) {
		this.idVeterinario = idVeterinario;
	}


	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getMotivo() {
		return motivo;
	}



	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}



	public String getInforme() {
		return informe;
	}



	public void setInforme(String informe) {
		this.informe = informe;
	}



	public boolean isRealizada() {
		return realizada;
	}



	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}
	
	

}
