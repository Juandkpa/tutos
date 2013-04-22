package com.tutos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "edad")
	private Date edad;
	
	@Column(name = "telefono")
	private Integer telefono;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "centroEducativo")
	private String centroEducativo;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Long getId() {
		return id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getEdad() {
		return edad;
	}
	public void setEdad(Date edad) {
		this.edad = edad;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCentroEducativo() {
		return centroEducativo;
	}
	public void setCentroEducativo(String centroEducativo) {
		this.centroEducativo = centroEducativo;
	}
}
