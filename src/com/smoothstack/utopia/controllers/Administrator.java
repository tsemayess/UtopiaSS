package com.smoothstack.utopia.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Scanner;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import com.smoothstack.utopia.daos.AirplaneDAO;
import com.smoothstack.utopia.daos.AirplaneTypeDAO;
import com.smoothstack.utopia.daos.AirportDAO;
import com.smoothstack.utopia.daos.BookingDAO;
import com.smoothstack.utopia.daos.FlightDAO;
import com.smoothstack.utopia.daos.PassengerDAO;
import com.smoothstack.utopia.daos.UserDAO;
import com.smoothstack.utopia.domains.Airport;
import com.smoothstack.utopia.domains.Booking;
import com.smoothstack.utopia.domains.Flight;
import com.smoothstack.utopia.domains.Passenger;
import com.smoothstack.utopia.domains.User;

public class Administrator {
	Util util = new Util();
	Scanner keyboard = new Scanner(System.in);

	public String addAirport() throws SQLException {
		Connection c = null;
		try {
			c = util.getConnection();

			// probably use scanner class to get info to add new airport
			Airport a = new Airport();

			System.out.println("New Airport Code");
			a.setAirportCode(keyboard.nextLine().toUpperCase());

			System.out.println("New Airport City");
			a.setCity(keyboard.nextLine());

			AirportDAO dao = new AirportDAO(c);
			dao.add(a);
			c.commit();
			System.out.println("Airport Added Successfully");
			return "Airport Added Successfully";

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("The Airport Code You Have Entered Is Already in the Database");
			return "The Airport Code You Have Entered Is Already in the Database";
		} catch (MysqlDataTruncation e) {
			System.out.println("The Airport Code Has Been Formatted Incorrectly. Airport Could Not Be Added.");
			return "The Airport Code Has Been Formatted Incorrectly. Airport Could Not Be Added.";
		} catch (Exception e) {

			// all does not got well rollback changes to prevent update
			
			c.rollback();
			System.out.println("Airport Could Not Be Added");
			return "Airport Could Not Be Added";

		} finally {
			if (c != null) {
				c.close();
			}
		}
	}

	/**
	 * If airport code entered does not exist it will still update "successfully"
	 * because SQL does not throw an error, however entered values will not be added
	 * to the table. Find way to fix manually.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String updateAirport() throws SQLException {
		Connection c = null;
		try {
			c = util.getConnection();

			// probably use scanner class to get info to add new airport
			Airport a = new Airport();

			System.out.println("Type Code of Airport You Want to Update");
			a.setAirportCode(keyboard.nextLine());

			if (airportCheck(a)) {
				System.out.println("Type City You Would Like To Update Airport Location To");
				a.setCity(keyboard.nextLine());

				AirportDAO dao = new AirportDAO(c);
				dao.update(a);
				c.commit();
				System.out.println("Airport Updated Successfully");
				return "Airport Updated Successfully";
			} else {
				System.out.println("Airport Could Not Be Found. Airport Could Not Be Updated");
				return "Airport Could Not Be Found. Airport Could Not Be Updated";
			}

		} catch (Exception e) {

			// all does not got well rollback changes to prevent update
			
			c.rollback();
			return "Airport Could Not Be Updated";

		} finally {
			if (c != null) {
				c.close();
			}
		}
	}

	/**
	 * If airport code entered does not exist it will still update "successfully"
	 * because SQL does not throw an error, however entered values will not be added
	 * to the table. Find way to fix manually.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String deleteAirport() throws SQLException {
		Connection c = null;
		try {
			c = util.getConnection();

			// probably use scanner class to get info to add new airport
			Airport a = new Airport();

			System.out.println("Type Code of Airport You Want to Delete");
			a.setAirportCode(keyboard.next());

			if (airportCheck(a)) {
				AirportDAO dao = new AirportDAO(c);
				dao.delete(a);
				c.commit();
				System.out.println("Airport Deleted Successfully");
				return "Airport Deleted Successfully";
			} else {
				System.out.println("Airport does not Exist. Airport Could Not Be Deleted");
				return "Airport does not Exist. Airport Could Not Be Deleted";
			}

		} catch (Exception e) {

			// all does not got well rollback changes to prevent update
			
			c.rollback();
			System.out.println("Airport Could Not Be Deleted");
			return "Airport Could Not Be Deleted";

		} finally {
			if (c != null) {
				c.close();
			}
		}

	}

	/**
	 * Gets information of Airport specified by Airport Code
	 * 
	 * @return String will all theAirPort Info
	 * @throws SQLException if something goes wrong with getting info from SQL
	 *                      Database
	 */
	public String readAirport() throws SQLException {
		Connection c = null;

		try {
			c = util.getConnection();

			// probably use scanner class to get info to add new airport
			Airport a = new Airport();
			AirportDAO dao = new AirportDAO(c);

			System.out.println("Type Code of Airport To See");
			a.setAirportCode(keyboard.nextLine());

			String result = dao.read(a);

			if (!result.equalsIgnoreCase("")) {
				return "Airport Details \n" + result;
			} else {
				return "Airport Could Not Be Found";
			}

		} catch (Exception e) {

			// all does not got well rollback changes to prevent update
			c.rollback();
			return "Airport Could Not Be Found";

		} finally {
			if (c != null) {
				c.close();

			}
		}
	}

	/**
	 * Prints string of all the airports and their locations
	 * 
	 * @return String which lists every single airport in the Database
	 * @throws SQLException
	 */
	public String readAllAirports() throws SQLException {
		Connection c = null;

		try {
			c = util.getConnection();

			AirportDAO dao = new AirportDAO(c);
			String result = "All Airports\n";
			List<Airport> a = dao.listAll();
			for (int i = 0; i < a.size(); i++) {
				result += "\n" + dao.read(a.get(i)) + "\n";
			}
			System.out.print(result);
			return result;

		} catch (Exception e) {

			// all does not got well rollback changes to prevent update
			
			c.rollback();
			return "All Airports Could Not Be Read";

		} finally {
			if (c != null) {
				c.close();

			}
		}
	}

	public boolean airportCheck(Airport a) throws SQLException, ClassNotFoundException {
		Connection c = null;
		c = util.getConnection();
		AirportDAO dao = new AirportDAO(c);
		if (dao.listAll().contains(a)) {
			return true;
		}
		return false;
	}

	public String addFlight() {
		Connection c = null;

		try {
			c = util.getConnection();
			Flight f = new Flight();
			FlightDAO dao = new FlightDAO(c);

			System.out.println("Enter New Flight ID");
			f.setiD(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter Flight Route ID Number");
			f.setRoute(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter Flight Aircraft By ID Number");
			f.setAirplane(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter Departure Time in the Format YYYY-MM-DD HH:MM:00");
			f.setDeparture(keyboard.nextLine());

			System.out.println("Enter Seat Price: ");
			f.setPrice(keyboard.nextFloat());
			keyboard.nextLine();

			f.setSeats(0);

			dao.add(f);
			c.commit();
			System.out.println("\n" + dao.read(f) + "\n\nFlight Added Successfully");
			return dao.read(f);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Flight Could Not Be Added");
			return "Flight Could Not Be Added";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String updateFlightPrice() {
		Connection c = null;

		try {
			c = util.getConnection();
			Flight f = new Flight();
			FlightDAO dao = new FlightDAO(c);

			System.out.println("Enter ID of Flight You Want To Update");
			f.setiD(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter New Seat Price: ");
			f.setPrice(keyboard.nextFloat());
			keyboard.nextLine();

			dao.updatePrice(f);
			c.commit();
			System.out.println("\n" + dao.read(f) + "\n\nFlight Updates Successfully");
			return dao.read(f);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Flight Could Not Be Updated");
			return "Flight Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String updateFlightPlane() {
		Connection c = null;

		try {
			c = util.getConnection();
			Flight f = new Flight();
			FlightDAO dao = new FlightDAO(c);

			System.out.println("Enter ID of Flight You Want To Update");
			f.setiD(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter New Aircraft ID: ");
			f.setAirplane(keyboard.nextInt());
			keyboard.nextLine();

			dao.updateAirplane(f);
			c.commit();
			System.out.println("\n" + dao.read(f) + "\n\nFlight Aircraft Updated Successfully");
			return dao.read(f);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Aircraft Could Not Be Updated");
			return "Aircraft Could Not Be Updated";
		}

	}

	public String updateFlightDeparture() {
		Connection c = null;

		try {
			c = util.getConnection();
			Flight f = new Flight();
			FlightDAO dao = new FlightDAO(c);

			System.out.println("Enter ID of Flight You Want To Update");
			f.setiD(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter New Departure Date and Time: ");
			f.setDeparture(keyboard.nextLine());

			dao.updateDeparture(f);
			c.commit();
			System.out.println("\n" + dao.read(f) + "\n\nFlight Date and Time Successfully");
			return dao.read(f);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Flight Date And Time Could Not Be Updated");
			return "Flight Date And Time Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String updateFlightSeats() {
		Connection c = null;

		try {
			c = util.getConnection();
			Flight f = new Flight();
			FlightDAO dao = new FlightDAO(c);
			AirplaneDAO airdao = new AirplaneDAO(c);
			AirplaneTypeDAO typedao = new AirplaneTypeDAO(c);

			System.out.println("Enter ID of Flight You Want To Update");
			f.setiD(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter Number of Seats to Reserve: ");
			int add = keyboard.nextInt();
			keyboard.nextLine();

			int now = dao.getById(f.getiD()).getSeats();
			int sum = add + now;
			int max = typedao.getById(airdao.getById(dao.getById(f.getiD()).getAirplane()).getType()).getCapacity();

			if (now == max) {
				System.out.println("Sorry, Could Not Add Seats. This Flight is Full");
				return "Sorry, Could Not Add Seats. This Flight is Full";
			} else if (sum > max) {
				System.out.println("Seats Could Not Be Added. There are only " + (max - now) + " Seats Left");
				return "Seats Could Not Be Added. There are only " + (max - now) + " Seats Left";
			}

			f.setSeats(add + now);

			dao.updateSeats(f);
			c.commit();
			System.out.println("\n" + dao.read(f) + "\n\nFlight's Reserved Seats Update Successfully");
			return dao.read(f);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Flight's Reserved Seats Could Not Be Updated");
			return "Flight's Reserved Seats Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String readAllFlights() {
		Connection c = null;

		try {
			c = util.getConnection();
			FlightDAO dao = new FlightDAO(c);
			System.out.println(dao.readAll());
			return dao.readAll();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Could Not List All Flights");
			return "Something Went Wrong. Could Not List All Flights";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	private boolean flightFull(Flight f, Connection c) throws ClassNotFoundException, SQLException {
		FlightDAO dao = new FlightDAO(c);
		AirplaneDAO airdao = new AirplaneDAO(c);
		AirplaneTypeDAO typedao = new AirplaneTypeDAO(c);

		if (dao.getById(f.getiD()).getSeats() >= typedao
				.getById(airdao.getById(dao.getById(f.getiD()).getAirplane()).getType()).getCapacity()) {

			return true;
		}
		return false;
	}

	public String addBooking() {
		Connection c = null;

		try {
			c = util.getConnection();

			Booking b = new Booking();
			BookingDAO dao = new BookingDAO(c);
			FlightDAO fdao = new FlightDAO(c);

			System.out.println("Enter ID Of Flight You Want To Book");
			b.setFlight(keyboard.nextInt());
			keyboard.nextLine();

			if (flightFull(fdao.getById(b.getFlight()), c)) {
				System.out.println("Sorry You Cannot Book This Flight. Flight is Full");
				return "Sorry You Cannot Book This Flight. Flight is Full";
			}

			b.setConfirmationCode("65738938H");
			b.setIsActive(1);

			Passenger p = new Passenger();
			PassengerDAO pdao = new PassengerDAO(c);

			System.out.println("Enter Passenger First Name");
			p.setFirstName(keyboard.nextLine());

			System.out.println("Enter Passenger Last Name");
			p.setLastName(keyboard.nextLine());

			System.out.println("Enter Passenger DOB");
			p.setDob(keyboard.nextLine());

			System.out.println("Enter Passenger Gender");
			p.setGender(keyboard.nextLine());

			System.out.println("Enter Passenger Address");
			p.setAddress(keyboard.nextLine());

			int pk = dao.add(b);
			c.commit();

			try {
				System.out.println();
				p.setBooking(pk);
				pdao.add(p);
				Flight f = fdao.getById(b.getFlight());
				f.setSeats(f.getSeats() + 1);
				fdao.updateSeats(f);
				c.commit();

			} catch (SQLException | ClassNotFoundException e) {
				
				dao.delete(dao.getById(pk));
				System.out.println("Something Went Wrong. Flight Could Not Be Booked");
				return "Flight Could Not Be Booked";
			}

			System.out.println("\n" + dao.read(b) + "\n\nFlight Booked Successfully");
			return dao.read(b);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Flight Could Not Be Booked");
			
			return "Flight Could Not Be Booked";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String cancelBooking() {
		Connection c = null;

		try {
			c = util.getConnection();

			Booking b = new Booking();
			BookingDAO dao = new BookingDAO(c);
			String booking = "";
			String ps = "";
			FlightDAO fdao = new FlightDAO(c);
			Flight f;

			try {
				System.out.println("Enter ID Of Booking You Want To Cancel");
				int id = keyboard.nextInt();
				keyboard.nextLine();
				b = dao.getById(id);
				booking = dao.read(b);
				
				PassengerDAO pDAO = new PassengerDAO(c);
				Passenger p = pDAO.getByBookingId(id);
				ps = "\nPassenger: " + p.getFirstName() + " " + p.getLastName() + "\n";
				
				f = fdao.getById(b.getFlight());

				if (b.getIsActive() == 2) {
					System.out.println(booking + ps);
					System.out.println("Booking " + b.getBookingID() + " Has Already Been Cancelled");
					return "fail";
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("This Booking Does Not Exist");
				return "fail";
			}

			boolean q = true;

			while (q) {
				System.out.println(booking + ps);
				System.out.println("Is This The Flight Booking You Would Like To Cancel? Enter Y Or N");
				String a = keyboard.nextLine();

				if (a.equalsIgnoreCase("y")) {
					b.setIsActive(2);
					dao.updateIsActive(b);
					f.setSeats(f.getSeats() - 1);
					fdao.updateSeats(f);

					q = false;
				} else if (a.equalsIgnoreCase("n")) {
					return "no";
				} else {
					System.out.println("Input Formatted Incorrectly. Try Again\n");
				}
			}
			c.commit();
			System.out.println("Booking " + b.getBookingID() + " Has Been Cancelled");
			return "Booking " + b.getBookingID() + " Has Been Cancelled";

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Flight Booking Could Not Be Cancelled");
			
			return "Something Went Wrong. Flight Booking Could Not Be Cancelled";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String overrideCancel() {
		Connection c = null;

		try {
			c = util.getConnection();

			Booking b = new Booking();
			BookingDAO dao = new BookingDAO(c);
			String booking = "";
			String ps = "";

			try {
				System.out.println("Enter ID Of Booking You Want To Override Cancel");
				int id = keyboard.nextInt();
				keyboard.nextLine();
				b = dao.getById(id);
				booking = dao.read(b);
				PassengerDAO pDAO = new PassengerDAO(c);
				Passenger p = pDAO.getByBookingId(id);
				ps = "\nPassenger: " + p.getFirstName() + " " + p.getLastName() + "\n";

				if (b.getIsActive() == 1) {
					System.out.println(booking + ps);
					System.out.println("Booking " + b.getBookingID() + " Is Active And Not Cancelled");
					return "fail";
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("This Booking Does Not Exist");
				return "fail";
			}

			boolean q = true;

			while (q) {
				System.out.println(booking + ps);
				System.out.println("Is This The Flight Booking You Would Like To Cancel Override? Enter Y Or N");
				String a = keyboard.nextLine();
				FlightDAO fdao = new FlightDAO(c);
				if (a.equalsIgnoreCase("y")) {
					Flight f = fdao.getById(b.getFlight());

					if (flightFull(f, c)) {
						System.out.println("This Flight Is Full. Booking Could Not Be Renewed");
						return "fail";
					}

					b.setIsActive(1);
					dao.updateIsActive(b);
					f.setSeats(f.getSeats() + 1);
					fdao.updateSeats(f);
					q = false;
				} else if (a.equalsIgnoreCase("n")) {
					return "no";
				} else {
					System.out.println("Input Formatted Incorrectly. Try Again\n");
				}
			}
			c.commit();
			System.out.println("Booking " + b.getBookingID() + " Cancel Has Been Overriden.");
			return "Booking " + b.getBookingID() + " Has Been Cancelled";

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Flight Booking Could Not Be Uncancelled");
			
			return "Something Went Wrong. Flight Booking Could Not Be Uncancelled";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String updatePassengerFirst() {
		Connection c = null;

		try {
			c = util.getConnection();
			PassengerDAO dao = new PassengerDAO(c);
			Passenger p;

			System.out.println("Enter ID of Passenger You Want To Update");
			p = dao.getById(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter New First Name: ");
			p.setFirstName(keyboard.nextLine());

			dao.updateFirst(p);
			c.commit();
			System.out.println("\n" + dao.read(p) + "\n\nPassenger First Name Update Successfully");
			return dao.read(p);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Passenger First Name Could Not Be Updated");
			return "Passenger First Name Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String updatePassengerLast() {
		Connection c = null;

		try {
			c = util.getConnection();
			PassengerDAO dao = new PassengerDAO(c);
			Passenger p;

			System.out.println("Enter ID of Passenger You Want To Update");
			p = dao.getById(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter New Last Name: ");
			p.setLastName(keyboard.nextLine());

			dao.updateLast(p);
			c.commit();
			System.out.println("\n" + dao.read(p) + "\n\nPassenger Last Name Update Successfully");
			return dao.read(p);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Passenger Last Name Could Not Be Updated");
			return "Passenger Last Name Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String updatePassengerGender() {
		Connection c = null;

		try {
			c = util.getConnection();
			PassengerDAO dao = new PassengerDAO(c);
			Passenger p;

			System.out.println("Enter ID of Passenger You Want To Update");
			p = dao.getById(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter New Gender: ");
			p.setGender(keyboard.nextLine());

			dao.updateGender(p);
			c.commit();
			System.out.println("\n" + dao.read(p) + "\n\nPassenger Last Name Update Successfully");
			return dao.read(p);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Passenger Last Name Could Not Be Updated");
			return "Passenger Last Name Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String updatePassengerAddress() {
		Connection c = null;

		try {
			c = util.getConnection();
			PassengerDAO dao = new PassengerDAO(c);
			Passenger p;

			System.out.println("Enter ID of Passenger You Want To Update");
			p = dao.getById(keyboard.nextInt());
			keyboard.nextLine();

			System.out.println("Enter New Address: ");
			p.setAddress(keyboard.nextLine());

			dao.updateAddress(p);
			c.commit();
			System.out.println("\n" + dao.read(p) + "\n\nPassenger Address Update Successfully");
			return dao.read(p);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Passenger Address Could Not Be Updated");
			return "Passenger Address Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public String readAllPassengers() {
		Connection c = null;

		try {
			c = util.getConnection();
			PassengerDAO dao = new PassengerDAO(c);
			dao.readAll();
			return "success";

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Could Not List All Passengers");
			return "Something Went Wrong. Could Not List All Passengers";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}

	}
	
	public String addUser(int userType) {
		Connection c = null;

		try {
			c = util.getConnection();
			
			User u = new User();
			UserDAO dao = new UserDAO(c);
			
			String t = "";
			
			if (userType == 1) {
				t = "Employee";
			} else if (userType == 3) {
				t = "Traveller";
			} else if (userType == 2) {
				t = "Administrator";
			}

			u.setRole(userType);

			System.out.println("Enter New " + t + " First Name");
			u.setFirstName(keyboard.nextLine());

			System.out.println("Enter New " + t + " Last Name");
			u.setLastName(keyboard.nextLine());

			System.out.println("Enter New " + t + " Email");
			u.setEmail(keyboard.nextLine());

			System.out.println("Enter New " + t + " Phone Number");
			u.setPhone(keyboard.nextLine());

			System.out.println("Enter New " + t + " Username");
			u.setUsername(keyboard.nextLine());
			
			System.out.println("Enter New " + t + " Password");
			u.setPassword(keyboard.nextLine());

			int pk = dao.add(u);
			c.commit();

			
			System.out.println("\n" + dao.read(dao.getById(pk)) + "\n\nNew Account Successfully Created!");
			return dao.read(dao.getById(pk));

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. User Could Not Be Added");
			return "Something Went Wrong. User Could Not Be Added";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public String updateUserFirst(int id) {
		Connection c = null;

		try {
			c = util.getConnection();
			
			UserDAO dao = new UserDAO(c);
			User u = dao.getById(id);

			System.out.println("Enter New First Name");
			u.setFirstName(keyboard.nextLine());

			dao.updateFirst(u);
			c.commit();

			
			System.out.println("\n" + dao.read(u) + "\n\nAccount Successfully Updated");
			return dao.read(u);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Account Could Not Be Updated");
			return "Something Went Wrong. Account Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {}
			}
		}
	}

	public String updateUserLast(int id) {
		Connection c = null;

		try {
			c = util.getConnection();
			
			UserDAO dao = new UserDAO(c);
			User u = dao.getById(id);

			System.out.println("Enter New Last Name");
			u.setLastName(keyboard.nextLine());

			dao.updateLast(u);
			c.commit();

			
			System.out.println("\n" + dao.read(u) + "\n\nAccount Successfully Updated");
			return dao.read(u);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Account Could Not Be Updated");
			return "Something Went Wrong. Account Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {}
			}
		}
	}

	public String updateUserEmail(int id) {
		Connection c = null;

		try {
			c = util.getConnection();
			
			UserDAO dao = new UserDAO(c);
			User u = dao.getById(id);

			System.out.println("Enter New Email Address");
			u.setEmail(keyboard.nextLine());

			dao.updateEmail(u);
			c.commit();

			
			System.out.println("\n" + dao.read(u) + "\n\nAccount Successfully Updated");
			return dao.read(u);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Account Could Not Be Updated");
			return "Something Went Wrong. Account Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {}
			}
		}
	}

	public String updateUserPhone(int id) {
		Connection c = null;

		try {
			c = util.getConnection();
			
			UserDAO dao = new UserDAO(c);
			User u = dao.getById(id);

			System.out.println("Enter New Phone Number");
			u.setPhone(keyboard.nextLine());

			dao.updatePhone(u);
			c.commit();

			
			System.out.println("\n" + dao.read(u) + "\n\nAccount Successfully Updated");
			return dao.read(u);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Account Could Not Be Updated");
			return "Something Went Wrong. Account Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {}
			}
		}
	}

	public String updatePassword(int id) {
		Connection c = null;

		try {
			c = util.getConnection();
			
			UserDAO dao = new UserDAO(c);
			User u = dao.getById(id);
			
			boolean b = true;
			while(b) {
				System.out.println("Enter Current Password Or Enter \"C\" To Cancel Password Change.");
				String pass = keyboard.nextLine();
				
				if (pass.equals(u.getPassword())) {
					b = false;
				} else if(pass.equalsIgnoreCase("c")) {
					return "fail";	
				} else {
					System.out.println("Password Incorrect. Please Try Again\n");
				}
			}
			
			System.out.println("\nEnter New Password");
			u.setPassword(keyboard.nextLine());

			dao.updatePassword(u);
			c.commit();

			
			System.out.println("\nPassword Successfully Updated\n");
			return dao.read(u);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Password Could Not Be Updated");
			return "Something Went Wrong. Password Could Not Be Updated";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public String readAllEmployees() {
		Connection c = null;

		try {
			c = util.getConnection();
			UserDAO dao = new UserDAO(c);
			dao.readAllEmployees();
			return "success";

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Could Not List All Passengers");
			return "Something Went Wrong. Could Not List All Passengers";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
		
	}
	
	public String readAllTravellers() {
		Connection c = null;

		try {
			c = util.getConnection();
			UserDAO dao = new UserDAO(c);
			dao.readAllTravellers();
			return "success";

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Something Went Wrong. Could Not List All Passengers");
			return "Something Went Wrong. Could Not List All Passengers";
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
		
	}
}
