package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.AirplaneTypeDAO;
import com.smoothstack.utopia.domains.AirplaneType;

public class AirPlaneTypeDAOTests {

	AirplaneTypeDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new AirplaneTypeDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
	
	@Test
	public void readAllHP() throws ClassNotFoundException, SQLException {
		List<AirplaneType> types = dao.listAll();
		types.forEach(a -> {
			try {
				System.out.println(dao.read(a));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	
		
	}
	
	@Test
	public void deleteHP() throws ClassNotFoundException, SQLException {
		AirplaneType a = new AirplaneType();
		a.setAirplaneID(9);
		dao.delete(a);
		conn.commit();
		
		System.out.println("Delete Succesful");
	}
	
	@Test
	public void updateHP() throws ClassNotFoundException, SQLException {
		AirplaneType a = new AirplaneType();
		a.setAirplaneID(9);
		a.setCapacity(400);
		dao.updateCapacity(a);
		conn.commit();
		
		System.out.println(dao.read(a));
	}
	
	@Test
	public void addHP() throws ClassNotFoundException, SQLException {
		AirplaneType a = new AirplaneType();
		a.setAirplaneID(9);
		a.setCapacity(0);
		dao.add(a);
		conn.commit();
		
		System.out.println(dao.read(a));
		
	}
	
	@Test
	public void readHP() throws SQLException {
		AirplaneType a = new AirplaneType();
		a.setAirplaneID(122737700);
		System.out.println(dao.read(a));
	}

}
