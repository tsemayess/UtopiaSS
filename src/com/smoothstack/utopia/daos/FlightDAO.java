package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.domains.Airplane;
import com.smoothstack.utopia.domains.Flight;
import com.smoothstack.utopia.domains.Route;

public class FlightDAO extends DAO<Flight> {

	Connection c;

	public FlightDAO(Connection c) {
		super(c);
		this.c = c;
	}
	
	public void add(Flight f) throws ClassNotFoundException, SQLException {
		Airplane a = new Airplane();
		a.setAirplaneID(f.getAirplane());
		
		AirplaneDAO dao = new AirplaneDAO(c);
		AirplaneTypeDAO typedao = new AirplaneTypeDAO(c);
		
		
		save("insert into flight values (?, ?, ?, ?, ?, ?)", 
				new Object[] {f.getiD(), f.getRoute(), f.getAirplane(), f.getDeparture(), 
						typedao.getById(dao.getById(f.getAirplane()).getType()).getCapacity(), f.getPrice()});
	}
	
	public void updateRoute(Flight f) throws ClassNotFoundException, SQLException {
		save("update flight set route_id = ? where id = ?", new Object[] {f.getRoute(), f.getiD()});
	}
	
	public void updateAirplane(Flight f) throws ClassNotFoundException, SQLException {
		save("update flight set airplane_id = ? where id = ?", new Object[] {f.getAirplane(), f.getiD()});
	}
	
	public void updateDeparture(Flight f) throws ClassNotFoundException, SQLException {
		save("update flight set departure_time = ? where id = ?", new Object[] {f.getDeparture(), f.getiD()});
	}
	
	public void updateSeats(Flight f) throws ClassNotFoundException, SQLException {
		save("update flight set reserved_seats = ? where id = ?", new Object[] {f.getSeats(), f.getiD()});
	}
	
	public void updatePrice(Flight f) throws ClassNotFoundException, SQLException {
		save("update flight set seat_price = ? where id = ?", new Object[] {f.getPrice(), f.getiD()});
	}

	public void delete(Flight f) throws ClassNotFoundException, SQLException {
		save("delete from flight where id = ?", new Object[] {f.getiD()});
	}

	public List<Flight> listAll() throws ClassNotFoundException, SQLException {
		return super.listAll("select * from flight", new Object[] {});
	}
	
	

	@Override
	public List<Flight> extractList(ResultSet resultSet) throws SQLException {
		List<Flight> flights = new ArrayList<>();

		while (resultSet.next()) {
			Flight a = new Flight();
			a.setiD(resultSet.getInt("id"));
			a.setRoute(resultSet.getInt("route_id"));
			a.setAirplane(resultSet.getInt("airplane_id"));
			a.setDeparture(resultSet.getString("departure_time"));
			a.setSeats(resultSet.getInt("reserved_seats"));
			a.setPrice(resultSet.getFloat("seat_price"));
			flights.add(a);
		}
		return flights;
	}

	public String read(Flight f) throws SQLException {
		// TODO Auto-generated method stub
		return super.read("select * from flight where id = ?", new Object[] { f.getiD() });
	}

	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		while (resultSet.next()) {
			result += "Flight " + resultSet.getString("id") + "\n";

			Route r = new Route();
			r.setRouteId(resultSet.getInt("route_id"));
			RouteDAO routeDAO = new RouteDAO(c);
			result += routeDAO.read(r) + "\n";

			Airplane a = new Airplane();
			a.setAirplaneID(resultSet.getInt("airplane_id"));
			AirplaneDAO airplaneDAO = new AirplaneDAO(c);
			result += airplaneDAO.read(a) + "\n";

			result += "Departure: " + resultSet.getString("departure_time") + "\nReserved Seats: "
					+ resultSet.getInt("reserved_seats") + "\nPrice: $" + resultSet.getFloat("seat_price");

		}
		return result;
	}

}
