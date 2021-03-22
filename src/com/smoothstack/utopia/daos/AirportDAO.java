package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.domains.Airport;

public class AirportDAO extends DAO<Airport> {
	
	public AirportDAO(Connection c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	public void add(Airport a) throws ClassNotFoundException, SQLException {
		save("insert into airport values (?, ?)", new Object[] {a.getAirportCode(), a.getCity()});
	}
	
	public void update(Airport a) throws ClassNotFoundException, SQLException {
		save("update airport set city = ? where iata_id = ?", new Object[] {a.getCity(), a.getAirportCode()});
	}

	public void delete(Airport a) throws ClassNotFoundException, SQLException {
		save("delete from airport where iata_id = ?", new Object[] {a.getAirportCode()});
	}
	
	public Airport getById(String id) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from airport where iata_id = ?", new Object[] {id}).get(0);
	}

	public List<Airport> listAll() throws ClassNotFoundException, SQLException {
		return super.listAll("select * from airport", new Object[] {});
	}
	
	
	@Override
	public List<Airport> extractList(ResultSet resultSet) throws SQLException {
		List<Airport> airports = new ArrayList<>();
		
		while(resultSet.next()) {
			Airport a = new Airport();
			a.setAirportCode((resultSet.getString("iata_id")));
			a.setCity((resultSet.getString("city")));
			airports.add(a);
		}
		return airports;
	}

	
	public String read(Airport a) throws SQLException {
		// TODO Auto-generated method stub
		return super.read("select * from airport where iata_id = ?", new Object[] {a.getAirportCode()});
	}

	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		while(resultSet.next()) {
			result += resultSet.getString("iata_id") + ", " + resultSet.getString("city");		
		}
		return result;
	}
	
	
 }
