	/*
	 * Justin Choy
	 * Student ID: 1731686 
	 * 
	 * */
package edu.dvccomsc256;

import java.time.LocalDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.time.Period;
import java.time.ZoneId;

public class SavingAccount extends Account{

	private double minBalance = 300.00;
	private int numberWithdraw = 0; 
	private int maxWithdraw = 3;
	private double interestRate;
	
	public SavingAccount( int id, double balance, double rate){
		super(id, balance);
		minBalance = 300.00;
		interestRate = rate;
	}
	public int getNumberWithdraw() {
		return numberWithdraw;
		}
	
	public void setNumberWithdraw(int numberWithdraw) {
		if (this.numberWithdraw < 3) {
			this.numberWithdraw++;
		} else if(this.numberWithdraw >= maxWithdraw) {
			System.out.println("You have reached your withdraw limit this month.");
		}
	}
	
	private double getInterestRate(double rate) {
		
		return this.interestRate;
	}
	@Override
	
	void Withdraw(double amount) {
		
		double testBal = getBalance() - amount;
		
		if(testBal > minBalance) {
			if(numberWithdraw < maxWithdraw) {
				setBalance(testBal);
				System.out.println("Withdraw Complete");
				System.out.println(toString());
			}
			setNumberWithdraw(numberWithdraw);
		}
		else if (testBal < minBalance){
			System.out.println("Unable to withdraw as it won't meet the minimum balance requirement");
			setBalance(minBalance);
			System.out.println(toString());
			numberWithdraw++;
		}
		
	}
	
	@Override
	
	public String toString() {
		
		return "Account type: Savings, Acccount Number: " + id + ", Annual Interest Rate: " 
		+ getInterestRate(interestRate) + ", Account balance: " + value() + "\n";
	}

	// Other imports...

	public double value() {
	    // Assuming the date format is "yyyy-MM-dd"
	    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	    
	        // Parse the date string to a Date object
	    

	    LocalDate today = LocalDate.now();
	    LocalDate createDate = this.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

	    Period timeBetween = Period.between(createDate, today);
	    
	    int months = timeBetween.getMonths();

	    return this.getBalance() + getAnnualInterestRate() / 12 * months;
	}
}
