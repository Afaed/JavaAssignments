/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsc256jc;

import java.util.ArrayList;

public class Account {
	
	protected int id = 0;
	private double balance = 0.0;
	private java.util.Date dateCreated;
	private double annualInterestRate = 0.0;
	private ArrayList <Account> arr = new ArrayList<Account>(); 
	
	public Account(){
		
		dateCreated = new java.util.Date();
		
	}
	
	public Account(int id, double balance) {
		
		this();
		this.id = id;
		this.balance = balance;
		
		
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
	
	public void setAnnualInterestRate(double rate) {
		this.annualInterestRate = rate;
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
		return "Account ID: " + this.id + "\n" 
				+ "Initial Balance: " +  this.getBalance() + "\n"
				+ "Interest: " + this.getAnnualInterestRate() + "\n"
				+ "Date Created: " + getDate();
	           
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
	
