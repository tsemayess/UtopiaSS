package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.domains.Airplane;
import com.smoothstack.utopia.domains.BookingPayment;
import com.smoothstack.utopia.domains.Flight;
import com.smoothstack.utopia.domains.BookingPayment;
import com.smoothstack.utopia.domains.Route;

public class BookingPaymentDAO extends DAO<BookingPayment> {

	public BookingPaymentDAO(Connection c) {
		super(c);
	}

	public void add(BookingPayment b) throws ClassNotFoundException, SQLException {
		save("insert into booking_payment values (?, ?, ?)",
				new Object[] {b.getBooking(), b.getPayment(), b.getRefunded()});
	}
	
	public void updatePayment(BookingPayment f) throws ClassNotFoundException, SQLException {
		save("update booking_payment set payment = ? where booking_id = ?", new Object[] { f.getPayment(), f.getBooking() });
	}

	public void updateRefunded(BookingPayment f) throws ClassNotFoundException, SQLException {
		save("update booking_payment set refunded = ? where booking_id = ?", new Object[] { f.getRefunded(), f.getBooking() });
	}

	public void delete(BookingPayment f) throws ClassNotFoundException, SQLException {
		save("delete from booking_payment where id = ?", new Object[] { f.getBooking() });
	}

	public BookingPayment getById(int id) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from booking_payment where id = ?", new Object[] { id }).get(0);
	}
	
	@Override
	public List<BookingPayment> extractList(ResultSet resultSet) throws SQLException {
		List<BookingPayment> payments = new ArrayList<>();

		while (resultSet.next()) {
			BookingPayment p = new BookingPayment();
			p.setBooking(resultSet.getInt("booking_id"));
			p.setPayment(resultSet.getString("stripe_id"));
			p.setRefunded(resultSet.getInt("refunded"));
			payments.add(p);
		}
		return payments;
	}

	public String read(BookingPayment b) throws SQLException {
		return super.read("select * from booking_payment where booking_id = ?", new Object[] {b.getBooking() });
	}
	
	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		while (resultSet.next()) {

			BookingPayment b = new BookingPayment();
			b.setRefunded(resultSet.getInt("refunded"));
			
			result += "Booking ID: " + resultSet.getString("booking_id") + "\nPayment: " + resultSet.getString("stripe_id") + "\nRefunded: "
					+ b.refundedString();

		}
		return result;
	}

}
