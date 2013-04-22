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
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


@Entity
public class Estudiante extends Persona{
	
//	@OneToMany(fetch = FetchType.LAZY, targetEntity = Materia.class)
//	@JoinColumn(name = "materia")
	@Transient
	private List<Materia> materias;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "monitor_estudiante", joinColumns = @JoinColumn(name = "monitor"), inverseJoinColumns = @JoinColumn(name = "estudiante"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"monitor", "estudiante" }))
	private List<Monitor> monitores;
	
	public List<Monitor> getMonitores() {
		return monitores;
	}
	public void setMonitores(List<Monitor> monitores) {
		this.monitores = monitores;
	}
	
	public List<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
}
