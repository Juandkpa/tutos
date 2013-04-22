package com.tutos.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
public class Monitor extends Persona{
	
	@Column(name ="infoAcademica")
	private String infoAcademica;
	
	@Column(name ="calificacion")
	private Calificacion calificacion;
	
	@Column(name ="ubicacion")
	private String ubicacion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "monitor_materia", joinColumns = @JoinColumn(name = "monitor"), inverseJoinColumns = @JoinColumn(name = "materia"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"monitor", "materia" }))
	private List<Materia> materias;
	
//	@OneToMany(mappedBy = "monitor", fetch = FetchType.LAZY)
	@Transient
	private List<Tutoria> tutorias; 
	
	@ElementCollection
	@CollectionTable(name = "horario_monitor", joinColumns = @JoinColumn(name = "monitor"))
	private List<Date> horario;
	
	public List<Date> getHorario() {
		return horario;
	}

	public void setHorario(List<Date> horario) {
		this.horario = horario;
	}

	public String getInfoAcademica() {
		return infoAcademica;
	}
	public void setInfoAcademica(String infoAcademica) {
		this.infoAcademica = infoAcademica;
	}
	public Calificacion getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}
	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
}
