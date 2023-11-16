/* 
 * Justin Choy
 * Student ID: 1731686 
 */
package LabExercise1;


public class TestAccount {
	
	public static void main(String [] args) {
		
		
		Account[] account = new Account[5];
		int id = 1000;
		double balance = 1000;
		
	        for(int i = 0; i < account.length; i++) {
				
					
					double withdraw = 500;
					double deposit = 1000;

					account[i] = new Account(id, balance);
					account[i].setAnnualInterestRate(3);
					
					System.out.println("Account ID: " + account[i].getID());
					System.out.println("Initial Balance: $" + account[i].getBalance());
					
					account[i].Deposit(deposit);
					account[i].Withdraw(withdraw);
				
	        		System.out.println("Monthly Interest: " + account[i].getMonthlyInterest());
	        		
	        		System.out.println("New Balance: $" + (account[i].getBalance() + account[i].getMonthlyInterest()));
	        		System.out.println("Date Created: " + account[i].getDate());
	        		
	        		System.out.println();
	        		
	        		id += 1000;
	        		balance += 1000;        		
			}
		}
    }
