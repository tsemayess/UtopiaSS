package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.BookingUserDAO;
import com.smoothstack.utopia.domains.BookingUser;

public class BookingUserDAOTests {

	BookingUserDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new BookingUserDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
	
	@Test
	public void readAllHP() throws ClassNotFoundException, SQLException {
		List<BookingUser> routes = dao.listAll();
		routes.forEach(a -> {
			try {
				System.out.println(dao.read(a));
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		});
	
		
	}

	@Test
	public void addHP() throws ClassNotFoundException, SQLException {
		BookingUser r = new BookingUser();
		r.setBooking(1125);
		r.setUser(1);
		dao.add(r);
		conn.commit();
		
		System.out.println("Booking User Completed");
		
	}
		
	@Test
	public void readHP() throws SQLException, ClassNotFoundException {
		BookingUser r = new BookingUser();
		r.setBooking(1112);
		System.out.println(dao.read(r));
	}

}
