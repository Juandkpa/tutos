package com.tutos.model;

public enum Genero {
	MASCULINO("Masculino"), FEMENINO("Femenino");
	
	private Genero(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String name;
	
	@Override
	public String toString() {
		return getName();
	}
}
