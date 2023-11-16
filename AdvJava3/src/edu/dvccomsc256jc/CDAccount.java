/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsc256jc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import edu.dvccomsc256jc.Account;

public class CDAccount extends Account {
	
	private int duration;
	private double CDAnnualInterestRate;
	
	public CDAccount() {
		super();
	}
	
	
	public CDAccount(int id, double balance, int duration) {
		super(id, balance);
		this.duration = duration;
	}
	
	public int getDuration(int duration) {
		
		 return this.duration = duration;
		
	}
	
	public double getCDAnnualInterestRate(double CDAnnualInterestRate){
		
		return this.CDAnnualInterestRate = CDAnnualInterestRate;
		
	}
	public int setDuration(int duration) {
		
		return this.duration = duration;
		
	}
	
	public void setCDAnnualInterestRate(double CDAnnualInterestRate) {
		
		 double cDannualInterestRateCalculated = 0;
	        int multiplier = (this.duration - 1 % 3) / 3;
	        cDannualInterestRateCalculated = this.getAnnualInterestRate() + 0.5 * multiplier;
	        this.CDAnnualInterestRate = cDannualInterestRateCalculated;
	}
	
	@Override
	
	public double getMonthlyInterestRate() {
		
		return (CDAnnualInterestRate / 100) / 12;
	}
	
	
	@Override
	
	public double getMonthlyInterest() {
		
		return super.getMonthlyInterest();
				
	}
	
	@Override
	
	final void Withdraw(double amount) {
		
		System.out.println("A CD account does not allow withdraws. "
				+ "You need to close this CD account.");
	}
	
	@Override
	
	final void Deposit(double amount) {
		
		System.out.println("You cannot make any additional deposits to a CD account. "
				+ "You may open a new one.");
	}
	
	public double getMatureBalance() {
        double matureBalance = getBalance() * Math.pow((1 + this.getMonthlyInterestRate() / 100), duration);
        return matureBalance;
	}
	
	  public void displayMonthlyInterests() {
	        double matureBalance = 0;
	        System.out.println();
	        for (int i = 1; i <= this.duration; i++) {
	            matureBalance = this.getBalance() * Math.pow((1 + this.getMonthlyInterestRate()), i);
	            System.out.printf("Month %d \t\t %.2f\n", i, matureBalance);
	        }
	    }
	  
	@Override
	
	public String toString(){
		
		return "Account ID: " + this.id + "\n" 
		+ "Initial Balance: " +  this.getBalance() + "\n"
		+ "Mature Balance: " + this.getMatureBalance() + "\n"
		+ "Rate: " + this.CDAnnualInterestRate  + "\n"
		+ "Date Created: " + getDate();
		
	}

	public void writeAccountToFile(File myFile, String accountType) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(myFile, true))) {
	        writer.printf("%10d %20.2f %20.2f %20s\n", id, getBalance(), getCDAnnualInterestRate(CDAnnualInterestRate), accountType);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}
