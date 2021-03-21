package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.FlightDAO;
import com.smoothstack.utopia.domains.Flight;

public class FlightDAOTests {

	FlightDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new FlightDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
	
	@Test
	public void getByIdHP() throws ClassNotFoundException, SQLException {
		
		System.out.println(dao.shortRead(dao.getById(2)));
	}
	
	@Test
	public void readAllHP() throws ClassNotFoundException, SQLException {
		List<Flight> airports = dao.listAll();
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
		Flight f  = new Flight();
		f.setiD(2);
		dao.delete(f);
		conn.commit();
		System.out.println("Delete Successful\n");
	}
	
	
	@Test
	public void updateRouteHP() throws ClassNotFoundException, SQLException {
		Flight f  = new Flight();
		f.setiD(1);
		System.out.println(dao.read(f));
		f.setRoute(5);
		dao.updateRoute(f);
		conn.commit();
		
		System.out.println(dao.read(f));
	}
	
	@Test
	public void updateAirplaneHP() throws ClassNotFoundException, SQLException {
		Flight f  = new Flight();
		f.setiD(1);
		System.out.println(dao.read(f));
		f.setAirplane(5);
		dao.updateAirplane(f);
		conn.commit();
		
		System.out.println(dao.read(f));
	}
	
	@Test
	public void updateDepartureHP() throws ClassNotFoundException, SQLException {
		Flight f  = new Flight();
		f.setiD(1);
		System.out.println(dao.read(f));
		f.setDeparture("2021-03-20 04:15:00");
		dao.updateDeparture(f);
		conn.commit();
		
		System.out.println(dao.read(f));
	}
	
	@Test
	public void updateSeatsHP() throws ClassNotFoundException, SQLException {
		Flight f  = new Flight();
		f.setiD(1);
		System.out.println(dao.read(f));
		f.setSeats(110);
		dao.updateSeats(f);
		conn.commit();
		
		System.out.println(dao.read(f));
	}
	
	@Test
	public void updatePriceHP() throws ClassNotFoundException, SQLException {
		Flight f  = new Flight();
		f.setiD(1);
		System.out.println("Before\n" + dao.read(f));
		f.setPrice((float) 86.49);
		dao.updatePrice(f);
		conn.commit();
		
		System.out.println("After\n" + dao.read(f));
	}
	
	@Test
	public void addHP() throws ClassNotFoundException, SQLException {
		Flight f = new Flight();
		f.setiD(2);
		f.setRoute(11);
		f.setAirplane(4);
		f.setDeparture("2021-04-22 20:45:00");
		f.setPrice((float) 154.99);
		
		dao.add(f);
		conn.commit();
		
		
		System.out.println(dao.read(f));
		
	}
	
	@Test
	public void readHP() throws SQLException {
		Flight f = new Flight();
		f.setiD(1);
		System.out.println(dao.read(f));
	}

}
