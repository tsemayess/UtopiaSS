package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.AirplaneDAO;
import com.smoothstack.utopia.domains.Airplane;

public class AirplaneDAOTests {

	AirplaneDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new AirplaneDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
	
	@Test
	public void getById() throws ClassNotFoundException, SQLException {
		System.out.println(dao.read(dao.getById(8)));
	}
	
	@Test
	public void readAllHP() throws ClassNotFoundException, SQLException {
		List<Airplane> types = dao.listAll();
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
		Airplane a = new Airplane();
		a.setAirplaneID(9);
		dao.delete(a);
		conn.commit();
		
		System.out.println("Delete Succesful");
	}
	
	
	@Test
	public void addHP() throws ClassNotFoundException, SQLException {
		Airplane a = new Airplane();
		a.setType(122737800);
		dao.add(a);
		conn.commit();
		
		System.out.println("Added Successfully");
		
	}
	
	@Test
	public void readHP() throws SQLException {
		Airplane a = new Airplane();
		a.setAirplaneID(1);
		System.out.println(dao.read(a));
	}

}
