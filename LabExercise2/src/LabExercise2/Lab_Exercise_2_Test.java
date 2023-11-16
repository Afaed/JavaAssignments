/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package LabExercise2;

public class Lab_Exercise_2_Test {

    public static void main(String[] args) {
        CDAccount[] cdAccounts = new CDAccount[5];
        
        double baseBalance = 1000.00;
        double annualInterestRate = 3.0;
        int id = 1000;
        // Create CD accounts with different durations
        for (int i = 0; i < cdAccounts.length; i++) {
        	
            int duration = (i + 1) * 3; // Duration from 3 to 15 months
            double balance = baseBalance + (i * 1000.00); // Increment balance by 1000 for each account
            
            // Create a CD account
            cdAccounts[i] = new CDAccount(id, balance, duration, annualInterestRate);

            // Display account information
            
            cdAccounts[i].toString();
//            System.out.println("Account ID: " + cdAccounts[i].getID());
//            System.out.println("Initial Balance: $" + cdAccounts[i].getBalance());
//            System.out.println("Rate: " + annualInterestRate + "%");
//            System.out.println("Date Created: " + cdAccounts[i].getDate());
//            System.out.println("Mature Balance: $" + cdAccounts[i].getMatureBalance());

            // Calculate and print monthly interest for each month during the saving period
            for (int month = 1; month <= duration; month++) {
                double monthlyInterest = cdAccounts[i].getBalance() * (cdAccounts[i].getMonthlyInterestRate());
                double newBal = monthlyInterest + balance; 
                //cdAccounts[i].Deposit(monthlyInterest) Add monthly interest to the balance
                System.out.println("Month " + month + " " + newBal);
                
                if (month >= duration) {
                	
                	cdAccounts[i].Deposit(newBal);
                	cdAccounts[i].Withdraw(newBal);
                	
                }
            }
            System.out.println();
            annualInterestRate += .5;
            id += 1000;
        }
    }
}
