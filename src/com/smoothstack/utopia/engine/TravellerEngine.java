package com.smoothstack.utopia.engine;

import java.sql.SQLException;
import java.util.Scanner;

import com.smoothstack.utopia.controllers.Controller;
import com.smoothstack.utopia.domains.User;

public class TravellerEngine {

	private Scanner keyboard = new Scanner(System.in);
	private Controller admin = new Controller();
	private User user = null;

	public void run() {
		login();
		return;
	}

	public void allActions() {
		boolean q = true;

		while (q) {
			try {
				System.out.println("\n1) Book A Flight \n2) Update Or Cancel A Flight Booking"
						+ "\n3) Update Account Information \n4) Log Out And Return to Previous Screen\n");
				System.out.println("Enter An Option Number");
				String s = keyboard.nextLine();
				int a = Integer.parseInt(s);

				switch (a) {
				case 1:
					getFlight();
					break;
				case 2:
					bookingMenu();
					break;
				case 3:
					updateTravellerMenu(user.getiD());
					break;
				case 4:
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

	private void passengerMenu() {
		while (true) {
			try {

				System.out.println(
						"\n1) Update Passenger First Name \n2) Update Passenger Last Name\n3) Update Passenger Date Of Birth"
								+ "\n4) Update Passenger Gender \n5) Update Passenger Address \n6) Return To Previous Screen");
				System.out.println("\nEnter An Option Number");

				String s = keyboard.nextLine();
				int c = Integer.parseInt(s);

				switch (c) {
				case 1:
					admin.updatePassengerFirst();
					break;
				case 2:
					admin.updatePassengerLast();
					break;
				case 3:
					admin.updatePassengerDOB();
					break;
				case 4:
					admin.updatePassengerGender();
					break;
				case 5:
					admin.updatePassengerAddress();
					break;
				case 6:
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

	private void getFlight() {
		while (true) {
			admin.readAllFlightsShort();
			admin.addBooking(user.getiD());
			return;

		}
	}

	private void updateTravellerMenu(int id) {
		while (true) {
			try {

				System.out.println(
						"\n1) Update Traveller First Name \n2) Update Traveller Last Name\n3) Update Traveller Email"
								+ "\n4) Update Traveller Phone Number \n5) Update Password \n6) Return To Previous Screen");
				System.out.println("\nEnter An Option Number");

				String s = keyboard.nextLine();
				int c = Integer.parseInt(s);

				switch (c) {
				case 1:
					admin.updateUserFirst(id);
					break;
				case 2:
					admin.updateUserLast(id);
					break;
				case 3:
					admin.updateUserEmail(id);
					break;
				case 4:
					admin.updateUserPhone(id);
					break;
				case 5:
					admin.updatePassword(id);
					break;
				case 6:
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

	private void bookingMenu() {
		while (true) {
			try {

				System.out.println(
						"\n1) View Booking(s) \n2) Update Booking Passenger \n3) Cancel Booking \n4) Return to Previous Screen");
				System.out.println("\nEnter An Option Number");

				String s = keyboard.nextLine();
				int c = Integer.parseInt(s);

				switch (c) {
				case 1:
					admin.readBookingsByUser(user.getiD());
					break;
				case 2:
					if (!admin.readBookingsByUser(user.getiD()).equalsIgnoreCase("fail")) {
						passengerMenu();
					}
					break;
					
				case 3:
					if (!admin.readBookingsByUser(user.getiD()).equalsIgnoreCase("fail")) {
						admin.cancelBooking();
					}
					break;
				case 4:
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
				user = admin.login(3, username, password);

				allActions();
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Username Or Password Is Incorrect. Try Again");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Something Went Wrong. Please Try Again");
			}
		}
	}

}
