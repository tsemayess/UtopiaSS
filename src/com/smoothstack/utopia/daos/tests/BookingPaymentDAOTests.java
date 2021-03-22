package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.BookingPaymentDAO;
import com.smoothstack.utopia.domains.BookingPayment;

public class BookingPaymentDAOTests {

	BookingPaymentDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new BookingPaymentDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
	
	@Test
	public void addHP() throws ClassNotFoundException, SQLException {
		BookingPayment a = new BookingPayment();
		a.setBooking(1123);
		a.setPayment("453719784384");
		a.setRefunded(1);
		dao.add(a);
		conn.commit();
		
		System.out.println("Added Successfully");
		
	}
	
//	@Test
//	public void readHP() throws SQLException {
//		BookingPayment a = new BookingPayment();
//		a.setBookingPaymentID(1);
//		System.out.println(dao.read(a));
//	}

}
