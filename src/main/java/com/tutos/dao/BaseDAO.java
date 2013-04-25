package com.tutos.dao;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//import com.tutos.model.Persona;
//
//public class BaseDAO<T> {
//	
//	static EntityManagerFactory emf = EMF.get();
//	
//	public void insertEntity(T entity){
//		EntityManager entityManager = emf.createEntityManager();
//		entityManager.getTransaction();
//		
//		entityManager.persist(entity);
//		
//		entityManager.close();
//	}
//	
//	public T getEntity(Object key){
//		EntityManager entityManager = emf.createEntityManager();
//		
//		
//		return (T) entityManager.find(Persona.class, key);
//	}
// 
//	
//}

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class BaseDAO<T> {
	
	private HashMap<Key, T> map = new HashMap<Key, T>();
	private HashMap<Class<?>, Long> currentId = new HashMap<Class<?>, Long>();
	
	private static class Key {
		Class<?> clazz;
		Object id;
		
		@Override
		public boolean equals(Object obj) {
			
			if(!(obj instanceof Key))
				return false;

			Key key = (Key) obj;
			
			if(key.clazz.equals(clazz) && key.id.equals(id))
				return true;
				
			return false;
		}
	}
	
	public Long insertEntity(T entity){
		Key  key = new Key();
		key.clazz = entity.getClass();
		
		Long currentId = this.currentId.get(key.clazz);
		
		if(currentId == null){
			currentId = Long.valueOf(1);
		}else{
			currentId++;
		}
		
		key.id = currentId;
		
		this.currentId.put(key.clazz, currentId);
		
		this.map.put(key, entity);
		
		return currentId;
	}
	
	public T getEntity(Class<T> clazz, Object id){
		
		Key  key = new Key();
		key.clazz = clazz;
		key.id = id;
		
		T value = this.map.get(key);
		
		return value;
	}
	
//	public T findEntity(Class<T> clazz, String property){
//		Collection<T> entities = map.values();
//				
//		for(T obj: entities){
//			
//		}
//				
//		return;
//	}
	
	public Collection<T> getAll(){			
		return map.values();
}
 
	
}
