package com.example.demo.model;
import java.sql.Date;

import com.example.demo.entity.Mascota;
import com.example.demo.entity.User;




public class citaModel {
	
	private int id;
	private Mascota idMascota;
	private User idUser;
	private Date fecha;
	private String motivo;
	private String informe;
	private boolean realizada;
	private User User;
	

	

	public citaModel() {
		// TODO Auto-generated constructor stub
	}


	public citaModel(int id, Mascota idMascota, User idUser, Date fecha, String motivo, String informe,
			boolean realizada) {
		super();
		this.id = id;
		this.idMascota = idMascota;
		this.User = idUser;
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


	public Mascota getIdMascota() {
		return idMascota;
	}


	public void setIdMascota(Mascota idMascota) {
		this.idMascota = idMascota;
	}


	public User getIdUser() {
		return idUser;
	}


	public void setIdUser(User idUser) {
		this.idUser = idUser;
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
