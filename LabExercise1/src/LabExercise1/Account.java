/*
 * Justin Choy
 * Student ID: 1731686 
 * */

package LabExercise1;

public class Account {
	private int id = 0;
	private double balance = 0.0;
	private java.util.Date dateCreated;
	private double annualInterestRate = 0.0;
	
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
	
	public String getDate() {
		
		return this.dateCreated.toString();
		
	}
	
	public double setBalance(double balance) {
		
		return this.balance = balance;

	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		
		this.annualInterestRate = annualInterestRate;
		
	}
	
	 void Withdraw(double amount){
		
		this.balance -= amount;
	
	}
	
	void Deposit(double amount) {
		
		this.balance += amount;
		
	}
}
