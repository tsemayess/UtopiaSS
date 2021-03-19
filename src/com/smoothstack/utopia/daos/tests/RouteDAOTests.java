package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.RouteDAO;
import com.smoothstack.utopia.domains.Route;

public class RouteDAOTests {
	
	RouteDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new RouteDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
	
	@Test
	public void readAllHP() throws ClassNotFoundException, SQLException {
		List<Route> routes = dao.listAll();
		routes.forEach(a -> {
			try {
				System.out.println(dao.read(a));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	
		
	}
	
	@Test
	public void deleteHP() throws ClassNotFoundException, SQLException {
		Route r  = new Route();
		r.setRouteId(21);
		dao.delete(r);
		conn.commit();
		System.out.println("Delete Successful\n");
	}
	
	@Test
	public void updateHP() throws ClassNotFoundException, SQLException {
		Route r  = new Route();
		r.setRouteId(21);
		r.setOrigin("LAX");
		r.setDestination("BOS");
		
		System.out.println(dao.read(r));
		dao.updateOrigin(r);
		dao.updateDestination(r);
		conn.commit();
		
		System.out.println(dao.read(r));
	}
	
	@Test
	public void addHP() throws ClassNotFoundException, SQLException {
		Route r = new Route();
		r.setOrigin("HNL");
		r.setDestination("IAH");
		dao.add(r);
		conn.commit();
		
		
		System.out.println(dao.read(r));
		
	}
	
	@Test
	public void readHP() throws SQLException {
		Route r = new Route();
		r.setRouteId(3);
		System.out.println(dao.read(r));
	}
	

}
