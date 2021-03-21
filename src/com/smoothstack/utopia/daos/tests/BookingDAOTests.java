package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.BookingDAO;
import com.smoothstack.utopia.domains.Booking;

public class BookingDAOTests {

	BookingDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new BookingDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
	
	@Test
	public void readAllHP() throws ClassNotFoundException, SQLException {
		List<Booking> routes = dao.listAll();
		routes.forEach(a -> {
			try {
				System.out.println(dao.read(a));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	
		
	}
	
	@Test
	public void updateIsActiveHP() throws ClassNotFoundException, SQLException {
		Booking r  = new Booking();
		r.setBookingID(1112);
		r.setIsActive(2);
	
		System.out.println(dao.read(r));
		System.out.println("read?");
		
		dao.updateIsActive(r);
		conn.commit();
		
		System.out.println(dao.read(r));
	}
	
	@Test
	public void addHP() throws ClassNotFoundException, SQLException {
		Booking r = new Booking();
		r.setConfirmationCode("67498234A");
		r.setFlight(2);
		r.setIsActive(1);
		dao.add(r);
		conn.commit();
		
		System.out.println("Booking Completed");
		
	}
	
	@Test(expected  = InputMismatchException.class)
	public void addFP() throws ClassNotFoundException, SQLException {
		Booking r = new Booking();
		r.setConfirmationCode("67498234A");
		r.setFlight(34);
		r.setIsActive(1);
		dao.add(r);
		conn.commit();
		
		System.out.println("Booking Completed");
		
	}
	
	@Test
	public void readHP() throws SQLException {
		Booking r = new Booking();
		r.setBookingID(1112);
		System.out.println(dao.read(r));
	}

}
