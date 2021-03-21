package com.smoothstack.utopia.engine;

import java.util.Scanner;
import com.smoothstack.utopia.controllers.Controller;
import com.smoothstack.utopia.domains.User;

public class AdministratorEngine {

	private Scanner keyboard = new Scanner(System.in);
	private Controller admin = new Controller();
	private User user = null;

	public void run() {

	}

	public void allActions() {
		boolean q = true;

		while (q) {
			try {
				System.out.println("\n1) Add/Update/Read Flights \n3) Add/Update/Cancel/Read Bookings And/Or Passengers"
						+ "\n4) Add/Update/Read Airports \n5) Add/Update/Delete/Read Travellers "
						+ "\n6) Add/Update/Delete/Read Employees \n7) Override Trip Cancellation For A Booking\n");
				System.out.println("Enter An Option Number");
				String s = keyboard.nextLine();
				int a = Integer.parseInt(s);

				switch (a) {
				case 1:
					flightMenu();
					break;
				case 3:
					bookingMenu();
					break;
				case 4:
					airportMenu();
					break;
				case 5:
					getUserIdRole(3);
					break;
				case 6:
					getUserIdRole(1);
					break;
				case 7:
					overrideCancellation();
					break;
				default:
					System.out.println("That Is Not a Valid Option. Please Enter A Valid Option.\n");
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("That Is Not a Valid Option. Please Enter A Valid Option.\n");
			}

		}

	}

	public void flightMenu() {
		while (true) {
			try {
			

				System.out.println(
						"1) Add Flight \n2) Update Flight \n3) Read All Flights \n4) Return to Previous Screen");
				System.out.println("\nEnter An Option Number");

				String s = keyboard.nextLine();
				int c = Integer.parseInt(s);

				switch (c) {
				case 1:
					admin.addFlight();
					break;
				case 2:
					updateFlightMenu();
					break;
				case 3:
					admin.readAllFlights();
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
	
	public void updateFlightMenu() {
		while (true) {
			try {

				System.out.println(
						"\n1) Update Flight Aircraft \n2) Update Flight Departure\n3) Update Reserved Seats"
								+ "\n4) Update Price\n5) Return To Previous Screen");
				System.out.println("\nEnter An Option Number");

				String s = keyboard.nextLine();
				int c = Integer.parseInt(s);

				switch (c) {
				case 1:
					admin.updateFlightPlane();
					break;
				case 2:
					admin.updateFlightDeparture();
					break;
				case 3:
					admin.updateFlightSeats();
					break;
				case 4:
					admin.updateFlightPrice();
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
	
	public void airportMenu() {
		while (true) {
			try {
			

				System.out.println(
						"\n1) Add Airport \n2) Update Airport \n3) Read All Airports \n4) Return to Previous Screen");
				System.out.println("\nFEnter An Option Number");

				String s = keyboard.nextLine();
				int c = Integer.parseInt(s);

				switch (c) {
				case 1:
					admin.addAirport();
					break;
				case 2:
					admin.updateAirport();
					break;
				case 3:
					admin.readAllAirports();
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
	
	public void travellerMenu() {
		while (true) {
			try {
				
				System.out.println("\n1) Add Travellers \n2) Update Travellers \n3) Read Travellers \n4) Return to Previous Screen");
				System.out.println("\nEnter An Option Number");

				String s = keyboard.nextLine();
				int c = Integer.parseInt(s);

				switch (c) {
				case 1:
					admin.addUser(3);
					break;
				case 2:
					break;
				case 3:
					admin.readAllAirports();
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

	public void getUserIdRole(int role) {
		while (true) {
			try {

				System.out.println("Enter the Id of The User Your Would Like Update or Enter \"R\" To Return To The Previous Screen." );
				String s = keyboard.nextLine();
				
				if(s.equalsIgnoreCase("R")) {
					return;
				}
				
				int c = Integer.parseInt(s);
				
				try {
					admin.userCheck(c, role);
					
					switch(role) {
						case 1:
							updateEmployeeMenu(c);
							break;
						case 3:
							updateTravellerMenu(c);
							break;
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("\nUser Could Not Be Found\n");
				}
				
				

			} catch (NumberFormatException e) {
				System.out.println("That Is Not a Valid Option. Please Enter A Valid Option.\n");
			}
		}
	}

	public void updateTravellerMenu(int id) {
		while (true) {
			try {

				System.out.println(
						"\n1) Update Traveller First Name \n2) Update Traveller Last Name\n3) Update Traveller Email"
								+ "\n4) Update Traveller Phone Number \n5) Update Different Traveller");
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

	public void updateEmployeeMenu(int id) {
		while (true) {
			try {

				System.out.println(
						"\n1) Update Employee First Name \n2) Update Employee Last Name\n3) Update Employee Email"
								+ "\n4) Update Employee Phone Number \n5) Update Different Employee");
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

	public void bookingMenu() {
		while (true) {
			try {

				System.out.println(
						"\n1) Add Booking \n2) Update Booking Passenger\n3) Read Booking\n4) Cancel Booking \n5) Return to Previous Screen");
				System.out.println("\nEnter An Option Number");

				String s = keyboard.nextLine();
				int c = Integer.parseInt(s);

				switch (c) {
				case 1:
					admin.addBooking(user.getiD());
					break;
				case 2:
					passengerMenu();
					break;
				case 3:
					admin.readAllBookings();
					break;
				case 4:
					admin.cancelBooking();
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

	public void passengerMenu() {
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

	public void overrideCancellation() {
		admin.overrideCancel();
	}

}
