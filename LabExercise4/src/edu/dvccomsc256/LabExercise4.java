	/*
	 * Justin Choy
	 * Student ID: 1731686 
	 * 
	 * TO DO:
	 * 
	 * 1) Write A driver program to:
	 * 		make two savingAccount Objects with $2000 and $8000 initial balance
	 * 		interestRate is 3.0% and one checking with 1000 initial balance;
	 * 
	 * 2) Make a checking value to check how many times an account has had money withdrawn.
	 * */
package edu.dvccomsc256;

import java.util.ArrayList;

public class LabExercise4 {

	public static void main (String [] args) {
		
		ArrayList <Account> accounts = new ArrayList<Account>();
		accounts.add(new SavingAccount(1000, 2000, 3.0));
		accounts.add(new SavingAccount(1001, 800, 3.0));
		accounts.add(new CheckingAccount(1002, 1000));
		
		for(int i = 0; i < 5; i++) 
		{
			
			for(Account elements: accounts) 
			{
				elements.Withdraw(300);
				accounts.get(2).getBalance();
			}
		}
	}
}
