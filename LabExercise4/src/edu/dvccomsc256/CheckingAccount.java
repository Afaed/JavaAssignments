	/*
	 * Justin Choy
	 * Student ID: 1731686 
	 * 
	 * */
package edu.dvccomsc256;

public class CheckingAccount extends Account{
	
	private double minBalance;
	
	public CheckingAccount(int id, double balance) 
	{
		super(id, balance);
		minBalance = 300.00;
	}
	public double getMonthlyInterestRate(){
		
		double rate = 0.0;
		
		double annualInterstRate = 3.0; //change once the methods in abstract account are changed
		
		rate = annualInterstRate / 12;
		
		return rate;
	}
	
	
	
@Override
	
	void Withdraw(double amount) {
		
		double testBal = getBalance() - amount;
		
		if(getBalance() > amount) {
			setBalance(testBal);
			System.out.println("Withdraw complete");
			System.out.println(toString());
		} else if(getBalance() < amount || getBalance() < minBalance) {
//			testBal = 300.00;
//			setBalance(testBal);
			System.out.println("Unable to withdraw as it won't meet the minimum balance requirement");
			System.out.println(toString());
		} 
	}
	@Override
	
	 public double value() {
		
		return getBalance();
		
	}
	@Override
	
	public String toString() {
		
		return "Account Type: Checking, Account Number " + id + ", Account Value is: " + value() + "\n";
	}
}
