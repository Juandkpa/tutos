package com.tutos.dao;

import com.tutos.model.Monitor;

public class MonitorDAO extends BaseDAO<Monitor>{

	private static MonitorDAO monitorDAO = new MonitorDAO();
	
	public static MonitorDAO getInstance(){
		return monitorDAO;
	}
	
}
