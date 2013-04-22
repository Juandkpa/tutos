package com.tutos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Tutoria {

	
	public enum Estado{
		ACTIVO
	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="costo")	
	private Integer costo;
	
	@Column(name ="informacion")
	private String informacion;
	
	@Enumerated(EnumType.STRING)	
	private Estado estado;
	
	@Column(name="calificacion")
	private Calificacion calificacion;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "monitor")
	@Transient
	private Monitor monitor;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Calificacion getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}
	public Monitor getMonitor() {
		return monitor;
	}
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	
}
