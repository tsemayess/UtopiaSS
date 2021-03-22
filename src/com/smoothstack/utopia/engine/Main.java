package com.smoothstack.utopia.engine;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner k = new Scanner(System.in)) {
			AdministratorEngine a = new AdministratorEngine();
			EmployeeEngine e = new EmployeeEngine();
			TravellerEngine t = new TravellerEngine();

			while (true) {
				System.out.println("Welcome to Utopia Airlines Management System. Which Category Of A User Are You?");
				System.out.println("1) Employee\n2) Administrator\n3) Traveller\n4) Quit");
				String s = k.nextLine();
				try {
					switch (Integer.parseInt(s)) {
					case 1:
						e.run();
						break;
					case 2:
						a.run();
						break;
					case 3:
						t.run();
					case 4:
						System.exit(0);
						break;
					default:
						System.out.println("\nPlease Enter Input Again.\n");
					}
				} catch (NumberFormatException r) {
					System.out.println("\nPlease Enter Input Again.\n");
				}
			}
		}
	}

}
