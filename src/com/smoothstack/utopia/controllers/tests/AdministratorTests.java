package com.smoothstack.utopia.controllers.tests;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.smoothstack.utopia.controllers.Administrator;
import com.smoothstack.utopia.domains.Airport;

public class AdministratorTests {
	Administrator admin = new Administrator();

//	@Test
//	public void airportCheck() throws ClassNotFoundException, SQLException {
//		Airport a = new Airport();
//		a.setAirportCode("JFK");
//		assertEquals(true, admin.airportCheck(a));
//	}
//
//	@Test
//	public void readAllAirports() throws SQLException {
//		admin.readAllAirports();
//	}
//
//	@Test
//	public void deleteAirport() {
//		try {
//			admin.deleteAirport();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Airport Delete Fail");
//		}
//	}
//
//	@Test
//	public void updateAirport() {
//		try {
//			admin.updateAirport();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void addAirport() {
//		try {
//			admin.addAirport();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Airport Add Fail");
//		}
//	}
//	
//	@Test
//	public void readAirport() {
//		try {
//			System.out.println(admin.readAirport());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Airport Add Fail");
//		}
//	}
//	
//	@Test
//	public void addFlight() {
//			admin.addFlight();
//	}
//	
//	@Test
//	public void updateFlightPrice() {
//			admin.updateFlightPrice();
//	}
//	
//	@Test
//	public void addUpdateFlightPlane() {
//			admin.updateFlightPlane();
//	}
//
//	@Test
//	public void addUpdateFlightDeparture() {
//			admin.updateFlightDeparture();
//	}
//
//	@Test
//	public void addUpdateFlightSeats() {
//			admin.updateFlightSeats();
//	}
//
//	@Test
//	public void addBooking() {
//			admin.addBooking();
//	}
	
	@Test
	public void cancelBooking() {
			admin.cancelBooking();
	}
}
