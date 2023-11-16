/*
 * Justin Choy
 * Student ID: 1731686 
 * 
 * TO DO: 
 * 	1) Print account details.
 * */

package edu.dvccomsc256jc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LabExcercise2_2 {
	
	public static void main (String [] args) {
		
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("Enter account id: ");
		
		double balance = 1000.0;
		int i;
		
		int id = myObj.nextInt();
		
		ArrayList <Account> accountList = new ArrayList<Account>();
		
		Account searchAccount = new Account(id, 0);
		Account newAccount = new Account(id, balance);
		int index = accountList.indexOf(searchAccount);
		
		for(i = 0; i < 100; i++) {
			
			newAccount = new Account(i, balance);

			accountList.add(newAccount);
			
			balance += 1000.0;

		}
		
//		for ( i = 100; i < 200; i++) {
//			int duration = 3;
//			CDAccount newCD = new CDAccount(i, balance, duration, 3.0);
//
//			accountList.add(newCD);
//			
//			balance += 1000.0;
//			
//			++duration;
//		}
		
		
		while (id != 101) {
			if (accountList.contains(searchAccount)){
				Account account = accountList.get(accountList.indexOf(searchAccount));
			    account.setAnnualInterestRate(3.0);
			    account.Deposit(100);
			    account.Withdraw(1000);
			    System.out.println("Account found");
			    System.out.println(account.toString());
			} else {
			    System.out.println("Account not found");
			}

            System.out.println("Enter account id (enter 101 to escape): ");
            id = myObj.nextInt();
        }
		
	}
}
