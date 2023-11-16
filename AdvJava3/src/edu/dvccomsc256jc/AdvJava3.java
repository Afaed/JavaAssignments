/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsc256jc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AdvJava3 {
	
	public static void main (String [] args) {
		
		String fileName;
		File myFile;
		
		Scanner in = new Scanner(System.in);
		
		String depositAmt ="Enter the initial deposit amount:", accountDuration = "Enter account duration in months or 0 for a normal account.";
		
		System.out.println("Enter the file name");
		fileName = in.nextLine();
		myFile = new File(fileName);
		
		PrintWriter out;
		
		try {
		    out = new PrintWriter(new FileWriter(myFile, true));
		} catch (IOException e) {
		    e.printStackTrace();
		    return; 
		}
		
		out.printf("%-15s %-25s %25s %-20s%n", "Account_Number",  "Initial_Balance($)", "Annual_Interest_Rate(%)", "Account_Type");
		out.println("==============================================================================");
		
		
		double interest = 3.0;
		double cdInterest = 3.0;
		
		Account.setAnnualInterestRate(interest);
		
		int id = 1000;
		
		while(true) 
		{
			
			double initialDeposit = getDouble(in, depositAmt);
			
			int duration = getNonNegativeInt(in, accountDuration);
			
			if(duration != 0) {
				CDAccount cdAccount = new CDAccount(id, initialDeposit, duration);
				String fileType = "CDAccount";
				//cdAccount.writeAccountToFile(myFile, "CDAccount");
				
				for (int i = 1; i <= duration; i++)
				{
					if(i % 3 == 0) {
						cdInterest += 0.5;
						cdAccount.setCDAnnualInterestRate(cdInterest);
					}
				}
				
				out.printf("%10d %20.2f %20.2f %24s%n", id, initialDeposit, cdAccount.getCDAnnualInterestRate(cdInterest), fileType);
				id++;
			} else {
				Account account = new Account(id, initialDeposit);
				String accountType = "Account";
				Account.setAnnualInterestRate(interest);
				
				out.printf("%10d %20.2f %20.2f %24s%n", id, initialDeposit, 
				account.getAnnualInterestRate(), accountType);
				id++;
			}
			
			int choice = getNonNegativeInt(in, "Press 1 to conitnue");
			if(choice != 1) {
				System.out.println("Program terminated");
				break;
			}
			
		}
		in.close();
		out.close();
	}
 
	private static double getDouble(Scanner scanner, String prompt) {
        double d = 0.0;
        boolean isValid = false;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                d = Double.parseDouble(input);
                if(d >= 0) {
                isValid = true;
                } else {
                	System.out.println("You must enter a valid double number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a valid double number.");
            }
        } while (!isValid);
        return d;
    }

    // Method to validate user input for a non-negative integer
    private static int getNonNegativeInt(Scanner scanner, String prompt) {
        int d = 0;
        boolean isValid = false;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                d = Integer.parseInt(input);
                if ( d >= 0) {
                    isValid = true;
                } else{System.out.println("You must enter a non-negative integer number:");};
            } catch (NumberFormatException e) {
                System.out.println("You must enter a non-negative integer number:");
            }
        } while (!isValid);
        return d;
    }
}
