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
	@JoinColumn (name="idUser",
				foreignKey=@ForeignKey(name="user_id_fk"),
				nullable=false)
	
	private User user;
	
	@Column
	private Date fecha;
	
	@Column(length=100)
	private String motivo;
	
	@Column
	private String informe;
	
	@Column
	private boolean realizada;

	public Cita(int id, Mascota mascota, User user, Date fecha, String motivo, String informe,
			boolean realizada) {
		super();
		this.id = id;
		this.mascota = mascota;
		this.user= user;
		this.fecha = fecha;
		this.motivo = motivo;
		this.informe = informe;
		this.realizada = realizada;
	}

	public Cita() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
