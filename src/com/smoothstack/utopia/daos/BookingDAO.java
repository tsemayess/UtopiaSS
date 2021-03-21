package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.smoothstack.utopia.domains.Booking;
import com.smoothstack.utopia.domains.Flight;

public class BookingDAO extends DAO<Booking> {

	Connection c;

	public BookingDAO(Connection c) {
		super(c);
		this.c = c;
	}
	
	public int add(Booking r) throws ClassNotFoundException, SQLException {
		FlightDAO flight = new FlightDAO(c);
		Flight f = new Flight();
		f.setiD(r.getFlight());
		if (flight.read(f).equals("")) {
			throw new InputMismatchException();
		}
		
		return savePK("insert into booking (is_active, confirmation_code, flight_id) values (?, ?, ?)", new Object[] {r.getIsActive(), r.getConfirmationCode(), r.getFlight()});
	}
	public void delete(Booking r) throws ClassNotFoundException, SQLException {
		save("delete from booking where id = ?", new Object[] {r.getBookingID()});
	}
	public void updateIsActive(Booking r) throws ClassNotFoundException, SQLException {
		save("update booking set is_active = ? where id = ?", new Object[] {r.getIsActive(), r.getBookingID()});
	}
	

	public List<Booking> listAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return super.listAll("select * from booking", new Object[] {});
	}
	
	public Booking getById(int id) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from booking where id = ?", new Object[] {id}).get(0);
	}

	@Override
	public List<Booking> extractList(ResultSet resultSet) throws SQLException {
		List<Booking> bookings = new ArrayList<>();
		while (resultSet.next()) {
			Booking b = new Booking();

			b.setBookingID(resultSet.getInt("id"));
			b.setFlight(resultSet.getInt("flight_id"));
			b.setIsActive(resultSet.getInt("is_active"));
			b.setConfirmationCode(resultSet.getString("confirmation_code"));
			bookings.add(b);
		}
		return bookings;
	}

	public String read(Booking b) throws SQLException {
		// TODO Auto-generated method stub
		return super.read("select * from booking where id = ?", new Object[] { b.getBookingID() });
	}
	
	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";

		while (resultSet.next()) {
			FlightDAO f = new FlightDAO(c);
			Booking b = new Booking();
			b.setIsActive(resultSet.getInt("is_active"));
			try {
				result += "Booking: " + resultSet.getInt("id") + "\n"
						+ f.shortRead(f.getById(resultSet.getInt("flight_id"))) + "\nStatus: " + b.isActiveString()
						+ "\nConfirmation Code: " + resultSet.getString("confirmation_code");
			} catch (ClassNotFoundException e) {}
		}
		return result;
	}

}
