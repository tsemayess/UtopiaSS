package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.domains.Airport;
import com.smoothstack.utopia.domains.Route;

public class RouteDAO extends DAO<Route> {
	
	private Connection c;
	
	public RouteDAO(Connection c) {
		super(c);
		this.c = c;
		// TODO Auto-generated constructor stub
	}
	
	public void add(Route r) throws ClassNotFoundException, SQLException {
		save("insert into route (origin_id, destination_id) values (?, ?)", new Object[] {r.getOrigin(), r.getDestination()});
	}
	
	public void updateOrigin(Route r) throws ClassNotFoundException, SQLException {
		save("update route set origin_id = ? where id = ?", new Object[] {r.getOrigin(), r.getRouteId()});
	}
	
	public void updateDestination(Route r) throws ClassNotFoundException, SQLException {
		save("update route set destination_id = ? where id = ?", new Object[] {r.getDestination(), r.getRouteId()});
	}
	
	public void delete(Route r) throws ClassNotFoundException, SQLException {
		save("delete from route where id = ?", new Object[] {r.getRouteId()});
	}

	public List<Route> listAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return super.listAll("select * from route", new Object[] {});
	}


	public List<Route> listAllByOrigin(Airport a) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return super.listAll("select * from route where origin_id = ?", new Object[] {a.getAirportCode()});
	}


	@Override
	public List<Route> extractList(ResultSet resultSet) throws SQLException {
		List<Route> routes = new ArrayList<>();

		while (resultSet.next()) {
			Route r = new Route();
			r.setRouteId(resultSet.getInt("id"));
			r.setOrigin(resultSet.getString("origin_id"));
			r.setDestination(resultSet.getString("destination_id"));
			
			routes.add(r);
		}
		return routes;

	}
	
	public String read(Route r) throws SQLException {
		// TODO Auto-generated method stub
		return super.read("select * from route where id = ?", new Object[] {r.getRouteId()});
	}

	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		while(resultSet.next()) {
			result += "Route: " + resultSet.getInt("id") + "\n";
			
			AirportDAO aDAO = new AirportDAO(c);
			Airport o = new Airport();
			o.setAirportCode(resultSet.getString("origin_id"));
			result += aDAO.read(o) + " ---> ";
			
			Airport d = new Airport();
			d.setAirportCode(resultSet.getString("destination_id"));
			result += aDAO.read(d);
			
		}
		return result;
	}

}
