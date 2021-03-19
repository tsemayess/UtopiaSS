package com.smoothstack.utopia.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import com.smoothstack.utopia.daos.AirportDAO;
import com.smoothstack.utopia.domains.Airport;

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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
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
	 * @return String will all theAirPort Info
	 * @throws SQLException if something goes wrong with getting info from SQL Database
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
			e.printStackTrace();
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
			e.printStackTrace();
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

}
