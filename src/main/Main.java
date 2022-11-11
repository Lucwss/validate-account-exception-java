package main;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountException;

public class Main {

	public static void main(String[] args)  {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data : ");
			System.out.print("Number : ");
			Integer number = input.nextInt();
			System.out.print("Holder: ");
			input.nextLine();
			String holder = input.nextLine();
			System.out.print("Initial Balance : ");
			Double balance = input.nextDouble();
			System.out.print("Withdraw limit : ");
			Double withdrawLimit = input.nextDouble();
			
			System.out.println();
			
			Account acc = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println(acc);
			
			System.out.println();
			
			System.out.print("Would you like to make a deposit ? ");
			Character choice = input.next().charAt(0);
			
			System.out.println();
			
			if(choice == 'y' || choice == 'Y') {
				System.out.print("How much would you like to deposit ? ");
				acc.deposit(input.nextDouble());
			}
			
			System.out.println();
			
			System.out.print("Would you like to make a withdraw ? ");
			choice = input.next().charAt(0);
			
			System.out.println();
			
			if(choice == 'y' || choice == 'Y') {
				System.out.print("How much would you like to withdraw ? ");
				acc.withdraw(input.nextDouble());
			}
			
			System.out.println(acc);
			
		} catch (AccountException e) {
			System.out.println("Account Error : " + e.getMessage());
		}
		input.close();
	}
}
