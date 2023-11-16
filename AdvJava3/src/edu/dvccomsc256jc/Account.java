/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsc256jc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class Account {
	
	protected int id = 0;
	private double balance = 0.0;
	private java.util.Date dateCreated;
	private static double annualInterestRate = 0.0;
	 private double initialBalance;
	private ArrayList <Account> arr = new ArrayList<Account>(); 
	
	public Account(){
		 id = 0;
	        balance = 0;
	        initialBalance = 0;
	        dateCreated = new Date();
	        annualInterestRate = 0.0;
		dateCreated = new java.util.Date();
		
	}
	
	public Account(int id, double balance) {
		this.id = id;
        this.balance = balance;
        initialBalance = balance;
        dateCreated = new Date();
        annualInterestRate = 0.0;
		
	}
	
	public int getID() {
		
		return this.id;
		
	}
	
	public double getBalance() {
		
		return this.balance;
		
	}
	
	public double getMonthlyInterestRate() {
		
		double monthlyInterestRate = (annualInterestRate / 100) / 12;
	    
		return monthlyInterestRate;
	}
	
	public double getAnnualInterestRate() {
		
		return annualInterestRate;
		
	}
	
	public double getMonthlyInterest() {
		
		double monthlyInterest = getMonthlyInterestRate() 
				* balance;
		
		return monthlyInterest;
		
	}
	
	public static void setAnnualInterestRate(double rate) {
		annualInterestRate = rate;
	}
	
	public String getDate() {
		
		return this.dateCreated.toString();
		
	}
	
	void Withdraw(double amount){
		
		this.balance -= amount;
	
	}
	
	void Deposit(double amount) {
		
		this.balance += amount;
		
	}


	@Override
	
	public String toString() {
	    return "Balance: " + this.balance + "\n";
	           
	}
	
	@Override
	
	public boolean equals(Object o) {
		// If the object is compared with itself then return true 
		
		if (o == this) {
			getID();
            setAnnualInterestRate(3.0);
            Deposit(100);
            Withdraw(1000);
            System.out.println("Account found");
            return true;
          
        } else {
        	
            return false;
        }
		
	}
//	
}
	
