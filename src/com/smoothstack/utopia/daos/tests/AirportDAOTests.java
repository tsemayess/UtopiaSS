package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.AirportDAO;
import com.smoothstack.utopia.domains.Airport;

public class AirportDAOTests {
	AirportDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new AirportDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
	
	@Test
	public void readAllHP() throws ClassNotFoundException, SQLException {
		List<Airport> airports = dao.listAll();
		airports.forEach(a -> {
			try {
				System.out.println(dao.read(a));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	
		
	}
	
	@Test
	public void deleteHP() throws ClassNotFoundException, SQLException {
		Airport a  = new Airport();
		a.setAirportCode("PPP");
		dao.delete(a);
		conn.commit();
		System.out.println("Delete Successful\n");
	}
	
	@Test
	public void updateHP() throws ClassNotFoundException, SQLException {
		Airport a  = new Airport();
		a.setAirportCode("PPX");
		a.setCity("Practice Point");
		
		System.out.println(dao.read(a));
		dao.update(a);
		conn.commit();
		
		System.out.println(dao.read(a));
	}
	
	@Test
	public void addHP() throws ClassNotFoundException, SQLException {
		Airport a = new Airport();
		a.setAirportCode("PPP");
		a.setCity("Practice Point");
		dao.add(a);
		conn.commit();
		
		
		System.out.println(dao.read(a));	
	}
	
	@Test
	public void readHP() throws SQLException {
		Airport a = new Airport();;
		a.setAirportCode("ATL");
		System.out.println(dao.read(a));
	}
	
	

}
