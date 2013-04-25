package com.tutos.dao;

import com.tutos.model.Estudiante;

public class EstudianteDAO extends BaseDAO<Estudiante>{

	private static EstudianteDAO estudianteDAO = new EstudianteDAO();
	
	public static EstudianteDAO getInstance(){
		return estudianteDAO;
	}
	
}
