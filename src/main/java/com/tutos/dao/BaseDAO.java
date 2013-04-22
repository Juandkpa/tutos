package com.tutos.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.tutos.model.Persona;

public class BaseDAO<T> {
	
	static EntityManagerFactory emf = EMF.get();
	
	public void insertEntity(T entity){
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction();
		
		entityManager.persist(entity);
		
		entityManager.close();
	}
	
	public T getEntity(Object key){
		EntityManager entityManager = emf.createEntityManager();
		
		
		return (T) entityManager.find(Persona.class, key);
	}
 
	
}
