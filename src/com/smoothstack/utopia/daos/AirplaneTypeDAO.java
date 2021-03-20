package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.daos.DAO;
import com.smoothstack.utopia.domains.AirplaneType;

public class AirplaneTypeDAO extends DAO<AirplaneType> {

	public AirplaneTypeDAO(Connection c) {
		super(c);
	}
	
	public void add(AirplaneType a) throws ClassNotFoundException, SQLException {
		save("insert into airplane_type values (?, ?)", new Object[] {a.getAirplaneID(), a.getCapacity()});
	}
	
	public void updateCapacity(AirplaneType a) throws ClassNotFoundException, SQLException {
		save("update airplane_type set max_capacity = ? where id = ?", new Object[] {a.getCapacity(), a.getAirplaneID()});
	}
	
	
	public void delete(AirplaneType a) throws ClassNotFoundException, SQLException {
		save("delete from airplane_type where id = ?", new Object[] {a.getAirplaneID()});
	}

	public List<AirplaneType> listAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return super.listAll("select * from airplane_type", new Object[] {});
	}
	
	public AirplaneType getById(int id) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from airplane_type where id = ?", new Object[] {id}).get(0);
	}

	@Override
	public List<AirplaneType> extractList(ResultSet resultSet) throws SQLException {
		List<AirplaneType> airplanes = new ArrayList<>();

		while (resultSet.next()) {
			AirplaneType a = new AirplaneType();
			a.setAirplaneID(resultSet.getInt("id"));
			a.setCapacity(resultSet.getInt("max_capacity"));
			
			airplanes.add(a);
		}
		return airplanes;
	}

	public String read(AirplaneType a) throws SQLException {
		// TODO Auto-generated method stub
		return super.read("select * from airplane_type where id = ?", new Object[] {a.getAirplaneID()});
	}
	
	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		while(resultSet.next()) {
			result += "Plane Type: " + resultSet.getString("id") + "\tMaxCapacity: " + resultSet.getString("max_capacity");		
		}
		return result;
	}
	
	

}
