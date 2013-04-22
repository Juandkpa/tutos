package com.tutos.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;


@Entity
public class Materia {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="nombre")	
	private String nombre;
	
	@Column(name ="descripcion")
	private String descripcion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "monitor_materia", joinColumns = @JoinColumn(name = "materia"), inverseJoinColumns = @JoinColumn(name = "monitor"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"monitor", "materia" }))
	private List<Monitor> monitores;
	
	public Long getId() {
		return id;
	}
	public List<Monitor> getMonitores() {
		return monitores;
	}
	public void setMonitores(List<Monitor> monitores) {
		this.monitores = monitores;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
