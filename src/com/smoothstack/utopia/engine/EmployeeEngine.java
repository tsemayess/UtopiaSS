package com.smoothstack.utopia.engine;

import java.sql.SQLException;
import java.util.Scanner;

import com.smoothstack.utopia.controllers.Controller;
import com.smoothstack.utopia.domains.User;

public class EmployeeEngine {

	private Scanner keyboard = new Scanner(System.in);
	private Controller admin = new Controller();
	private User user = null;

	public void run() {
		login();
		return;
	}

	
	private void updateFlightMenu(int id) {
		while (true) {
			try {

				System.out.println("\n1) View Flight Details \n2) Update Flight Departure\n3) Update Reserved Seats"
						+ "\n4) Update Price\n5) Return To Previous Screen");
				System.out.println("\nEnter An Option Number");
				String s = keyboard.nextLine();
				int c = Integer.parseInt(s);
				if (c == 5) {
					return;
				}

				switch (c) {
				case 1:
					admin.readFlight(id);
					break;
				case 2:
					admin.updateFlightDeparture(id);
					break;
				case 3:
					admin.updateFlightSeats(id);
					break;
				case 4:
					admin.updateFlightPrice(id);
					break;
				case 5:
					return;
				default:
					System.out.println("That Is Not a Valid Option. Please Enter A Valid Option.\n");
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("That Is Not a Valid Option. Please Enter A Valid Option.\n");
			}
		}
	}

	private void allActions() {
		while (true) {
			admin.readAllFlightsShort();
			System.out.println("Enter ID of Flight You Want To Update Or Enter \"R\" To Return To Previous Screen And Logout.");
			String s = keyboard.nextLine();
			if (s.equalsIgnoreCase("R")) {
				return;
			}

			int id = Integer.parseInt(s);

			try {
				if (admin.flightCheck(id)) {
					updateFlightMenu(id);
				}
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Something Went Wrong. Please Try Again.");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("No Flight Matching That ID Exists");
			}
		}
	}

	private void login() {
		while (true) {
			try {
			System.out.println("\nEnter Username. Or Enter \"R\" To Return To Previous Screen");
			String username = keyboard.nextLine();
			
			if (username.equalsIgnoreCase("r")) {
				return;
			}
			System.out.println("Enter Password");
			String password = keyboard.nextLine();
			user = admin.login(1, username, password);
			
			allActions();
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Username Or Password Is Incorrect. Try Again");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Something Went Wrong. Please Try Again");
			} 
		}
	}

}
