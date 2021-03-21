package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.PassengerDAO;
import com.smoothstack.utopia.domains.Passenger;

public class PassengerDAOTests {
	PassengerDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new PassengerDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
	

	@Test
	public void getByiDHP() throws ClassNotFoundException, SQLException {
		System.out.println(dao.read(dao.getById(4)));
	}

	@Test
	public void listAll() throws ClassNotFoundException, SQLException {
		dao.readAll();
	}
	

	@Test
	public void updateAddress() throws ClassNotFoundException, SQLException {
		Passenger u  = new Passenger();
		u.setiD(3);
		u.setAddress("52 Frost Lane, Central City, VA, USA");
		
		System.out.println(dao.read(u));
		dao.updateAddress(u);
		conn.commit();
		System.out.println(dao.read(u));
	}
	
	@Test
	public void updateGender() throws ClassNotFoundException, SQLException {
		Passenger u  = new Passenger();
		u.setiD(3);
		u.setGender("Female");
		
		System.out.println(dao.read(u));
		dao.updateGender(u);
		conn.commit();
		
	}
	
	@Test
	public void updateDOB() throws ClassNotFoundException, SQLException {
		Passenger u  = new Passenger();
		u.setiD(3);
		u.setDob("1986-12-24");
		
		System.out.println(dao.read(u));
		dao.updateDOB(u);
		conn.commit();
		
		System.out.println(dao.read(u));
	}
	
	
	@Test
	public void updateLastHP() throws ClassNotFoundException, SQLException {
		Passenger u  = new Passenger();
		u.setiD(3);
		u.setLastName("Snow");
		
		System.out.println(dao.read(u));
		dao.updateLast(u);
		conn.commit();
		
		System.out.println(dao.read(u));
	}
	
	@Test
	public void updateFirstHP() throws ClassNotFoundException, SQLException {
		Passenger u  = new Passenger();
		u.setiD(3);
		u.setFirstName("Caitlin");
		
		System.out.println(dao.read(u));
		dao.updateFirst(u);
		conn.commit();
		
		System.out.println(dao.read(u));
	}
	
	@Test
	public void addHP() throws ClassNotFoundException, SQLException {
		Passenger u = new Passenger();
		
		u.setFirstName("Dick");
		u.setLastName("Grayson");
		u.setGender("Male");
		u.setBooking(1113);
		u.setDob("1987-09-21");
		u.setAddress("591 Wayne Manors Estate, Gotham, NY, USA");
		
		dao.add(u);
		conn.commit();
	}
	
	@Test
	public void readHP() throws SQLException {
		Passenger p = new Passenger();
		p.setiD(1);
		System.out.println(dao.read(p));
	}


}
