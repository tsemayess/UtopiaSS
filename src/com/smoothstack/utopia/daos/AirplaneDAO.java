package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.domains.Airplane;
import com.smoothstack.utopia.domains.AirplaneType;


public class AirplaneDAO extends DAO<Airplane> {
	
	private Connection c;

	public AirplaneDAO(Connection c) {
		super(c);
		this.c = c;
	}

	
	public void add(Airplane a) throws ClassNotFoundException, SQLException {
		save("insert into airplane (type_id) values (?)", new Object[] {a.getType()});
	}
	
	
	public void delete(Airplane a) throws ClassNotFoundException, SQLException {
		save("delete from airplane where id = ?", new Object[] {a.getAirplaneID()});
	}

	public List<Airplane> listAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return super.listAll("select * from airplane", new Object[] {});
	}

	public Airplane getById(int id) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from airplane where id = ?", new Object[] {id}).get(0);
	}
	@Override
	public List<Airplane> extractList(ResultSet resultSet) throws SQLException {
		List<Airplane> airplanes = new ArrayList<>();

		while (resultSet.next()) {
			Airplane a = new Airplane();
			a.setAirplaneID(resultSet.getInt("id"));
			a.setType(resultSet.getInt("type_id"));
			
			airplanes.add(a);
		}
		return airplanes;
	}

	public String read(Airplane a) throws SQLException {
		// TODO Auto-generated method stub
		return super.read("select * from airplane where id = ?", new Object[] {a.getAirplaneID()});
	}
	
	
	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		while(resultSet.next()) {
			result += "Plane ID: " + resultSet.getString("id") + "\n";
			
			AirplaneTypeDAO typeDAO = new AirplaneTypeDAO(c);
			AirplaneType type = new AirplaneType();
			type.setAirplaneID(resultSet.getInt("type_id"));
			result +=  typeDAO.read(type);
			
		}
		return result;
	}

	

}
