package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.domains.Passenger;

public class PassengerDAO extends DAO<Passenger> {
	
	Connection c;

	public PassengerDAO(Connection c) {
		super(c);
		this.c = c;
	}
	
	public void add(Passenger u) throws ClassNotFoundException, SQLException {
		save("insert into passenger (booking_id, given_name, family_name, dob, gender, address) values (?, ?, ?, ?, ?, ?)", 
				new Object[] {u.getBooking(), u.getFirstName(),u.getLastName(), u.getDob(),
				u.getGender(), u.getAddress()});
	}
	
	public void updateFirst(Passenger u) throws ClassNotFoundException, SQLException {
		save("update passenger set given_name = ? where id = ?", new Object[] {u.getFirstName(), u.getiD()});
	}
	
	public void updateLast(Passenger u) throws ClassNotFoundException, SQLException {
		save("update passenger set family_name = ? where id = ?", new Object[] {u.getLastName(), u.getiD()});
	}
	public void updateDOB(Passenger u) throws ClassNotFoundException, SQLException {
		save("update passenger set dob = ? where id = ?", new Object[] {u.getDob(), u.getiD()});
	}
	
	public void updateGender(Passenger u) throws ClassNotFoundException, SQLException {
		save("update passenger set gender = ? where id = ?", new Object[] {u.getGender(), u.getiD()});
	}
	public void updateAddress(Passenger u) throws ClassNotFoundException, SQLException {
		save("update passenger set address = ? where id = ?", new Object[] {u.getAddress(), u.getiD()});
	}
	
	public List<Passenger> listAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return super.listAll("select * from passenger", new Object[] {});
	}
	
	
	public Passenger getById(int u) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from passenger where id = ?", new Object[] {u}).get(0);
	}
	
	public Passenger getByBookingId(int u) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from passenger where booking_id = ?", new Object[] {u}).get(0);
	}

	public void readAll() throws ClassNotFoundException, SQLException {
		listAll().forEach(p -> {
			try {
				System.out.println(read(p) + "\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	@Override
	public List<Passenger> extractList(ResultSet resultSet) throws SQLException {
		List<Passenger> passengers = new ArrayList<>();
		while (resultSet.next()) {
			Passenger u = new Passenger();

			u.setiD(resultSet.getInt("id"));
			u.setBooking(resultSet.getInt("booking_id"));
			u.setFirstName(resultSet.getString("given_name"));
			u.setLastName(resultSet.getString("family_name"));
			u.setDob(resultSet.getString("dob"));
			u.setGender(resultSet.getString("gender"));
			u.setAddress(resultSet.getString("address"));
			passengers.add(u);
		}
		return passengers;
	}

	public String read(Passenger p) throws SQLException {
		// TODO Auto-generated method stub
		return super.read("select * from passenger where id = ?", new Object[] { p.getiD() });
	}
	
	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		while (resultSet.next()) {
			
			result += "Passenger ID Number: " + resultSet.getInt("id") + "\nBooking\t\t" + resultSet.getInt("booking_id") + "\nFirst Name:\t"
					+ resultSet.getString("given_name") + "\nLast Name:\t" + resultSet.getString("family_name")
					+ "\nDate of Birth:\t" + resultSet.getString("dob") + "\nGender:\t\t" + resultSet.getString("gender")
					+ "\nAddress:\t" + resultSet.getString("address");
			
		}
		return result;
	}

}
