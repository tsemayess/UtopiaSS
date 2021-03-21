package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.daos.DAO;
import com.smoothstack.utopia.daos.UserDAO;
import com.smoothstack.utopia.domains.BookingUser;
import com.smoothstack.utopia.domains.User;

public class BookingUserDAO extends DAO<BookingUser> {
	Connection c;
	public BookingUserDAO(Connection c) {
		super(c);
		this.c = c;
	}
	
	public void add(BookingUser u) throws ClassNotFoundException, SQLException {
		save("insert into booking_user values (?, ?)", new Object[] {u.getBooking(), u.getUser()});
	}
	
	public BookingUser getById(int id) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from booking_user where booking_id = ?", new Object[] {id}).get(0);
	}
	
	public void readAll() throws ClassNotFoundException, SQLException {
		listAll().forEach(a -> {
			try {
				System.out.println(read(a));
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	public List<BookingUser> listAll() throws ClassNotFoundException, SQLException {
		return super.listAll("select * from booking_user", new Object[] {});
	}
	public List<BookingUser> listAllByUser(int id) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from booking_user where user_id = ?", new Object[] {id});
	}

	@Override
	public List<BookingUser> extractList(ResultSet resultSet) throws SQLException {
		List<BookingUser> users = new ArrayList<>();
		while (resultSet.next()) {
			BookingUser u = new BookingUser();

			u.setBooking(resultSet.getInt("booking_id"));
			u.setUser(resultSet.getInt("user_id"));
			users.add(u);
		}
		return users;
	}

	public String read(BookingUser u) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.read("select * from booking_user where booking_id = ?", new Object[] { u.getBooking() });
	}
	
	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		UserDAO udao = new UserDAO(c);
		User u = null;
		
		
		while (resultSet.next()) {
			try {
				u = udao.getById(resultSet.getInt("user_id"));
			} catch (ClassNotFoundException e) {}

			result += "Booking ID Number: " + resultSet.getInt("booking_id") + "\nBooking User: " + u.getFirstName() + " " + u.getLastName() 
			+"\n";
		}
		return result;
	}

}
