package com.comp645.atm.resource;

import java.util.Scanner;

public class AtmController {
	
	private static Scanner kbd = new Scanner(System.in);

	public void accountOptions() {

		int menuOption = 0;
		while (menuOption != 4) {
			System.out.print("\nPlease Choose From the Following Options:" + "\n 1. Display Balance \n 2. Deposit"
					+ "\n 3. Withdraw\n 4. Log Out\n\n");

			menuOption = kbd.nextInt();

			if (menuOption < 1 || menuOption > 4) {
				System.out.println("error");
			}

			switch (menuOption) {
			case 1:
				break;
			case 2:
				System.out.print("\nEnter Amount You Wish to Deposit: $ ");
				System.out.print(kbd.nextDouble());
				break;
			case 3:
				System.out.print("\nEnter Amount You Wish to Withdrawl: $ ");
				System.out.print(kbd.nextDouble());
				break;
			case 4:
				System.out.print("\nThank For Using My ATM.  Have a Nice Day.  Good-Bye!");
				System.exit(0);
				break;
			}
		}

	}

	public void customerOptions() {
//		Scanner sc =new Scanner(System.in);
//		   
//	    System.out.println("Enter the name of the Bank");
//	    String bank=sc.nextLine();
//	    Bank theBank= new Bank(bank);
//	    System.out.println("Enter user First Name");
//	    String Fname=sc.nextLine();
//	    System.out.println("Enter user last Name");
//	    String Lname=sc.nextLine();
//	    System.out.println("Enter user Social Security Number");
//	    String SSN=sc.nextLine();
//	    System.out.println("Enter user Pin Number");
//	    String pin=sc.nextLine();

	}

}
