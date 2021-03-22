package com.smoothstack.utopia.controllers.tests;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.smoothstack.utopia.controllers.Controller;
import com.smoothstack.utopia.domains.Airport;

public class ControllerTests {
	Controller admin = new Controller();

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
//	public void readAllFlights() {
//			admin.readAllFlights();
//	}
//	@Test
//	public void addBooking() {
//			admin.addBooking();
//	}
//	
//	@Test
//	public void cancelBooking() {
//			admin.cancelBooking();
//	}
//	
//	@Test
//	public void updatePassengerFirst() {
//			admin.updatePassengerFirst();
//	}
//	
//	@Test
//	public void updatePassengerLast() {
//			admin.updatePassengerLast();
//	}
//	
//	@Test
//	public void updatePassengerGender() {
//			admin.updatePassengerGender();
//	}
//	@Test
//	public void updatePassengerAddress() {
//			admin.updatePassengerAddress();
//	}
//	@Test
//	public void readAllPassengers() {
//		admin.readAllPassengers();
//	}
//	@Test
//	public void overrideCancel() {
//		admin.cancelBooking();
//	}
//	@Test
//	public void addUser() {
//		admin.addUser(1);
//	}
//	
//	@Test
//	public void updateUserFirst() {
//		admin.updateUserFirst(2);
//	}
//	@Test
//	public void updateUserLast() {
//		admin.updateUserLast(2);
//	}
//	@Test
//	public void updateUserEmail() {
//		admin.updateUserEmail(2);
//	}
//	@Test
//	public void updateUserPhone() {
//		admin.updateUserPhone(2);
//	}
//	@Test
//	public void updateUserPassword() {
//		admin.updatePassword(2);
//	}
//	@Test
//	public void readEmployees() {
//		admin.readAllEmployees();
//	}
//	@Test
//	public void readTraveller() {
//		admin.readAllTravellers();
//	}
	@Test
	public void readBookingsByUser() {
		admin.readBookingsByUser(2);
	}
}
