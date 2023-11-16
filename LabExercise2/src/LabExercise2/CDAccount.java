package LabExercise2;

public class CDAccount extends Account {
	
	private int duration;
	private double CDAnnualInterestRate;
	
	public CDAccount() {
		super();
	}
	
	
	public CDAccount(int id, double balance, int duration, double CDAunnualInterestRate) {
		super(id, balance);
		this.duration = duration;
		this.CDAnnualInterestRate = CDAunnualInterestRate;
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
		
		this.CDAnnualInterestRate = CDAnnualInterestRate;
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
        double matureBalance = getBalance() * Math.pow((1 + getMonthlyInterestRate() / 100), duration);
        return matureBalance;
	}
	
	@Override
	
	public String toString(){
		
		return "Account ID: " + this.id + "\n" 
		+ "Initial Balance: " +  this.getBalance() + "\n"
		+ "Mature Balance: " + this.getMatureBalance() + "\n"
		+ "Rate: " + this.CDAnnualInterestRate  + "\n"
		+ "Date Created: " + getDate();
		
	}
	
	public void displayMonthlyInterests() {
		
		
	}
}
