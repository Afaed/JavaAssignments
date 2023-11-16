/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsc256jc;
import java.util.Date;
import java.lang.Cloneable;

public class ComparableAccount extends Account implements Comparable<ComparableAccount>, Cloneable {
	
	java.util.Date dateCreated;
	
	public ComparableAccount(int id, double balance){
		super(id, balance);
		dateCreated = new java.util.Date();
	};
	
	@Override
	
	public String toString() {
	
	return "Account number: " + id + "  "
			+ "Balance: " + balance + "  "
			+ "Date Created: " + dateCreated;
	
	}
	
	@Override
	
	public ComparableAccount clone() throws CloneNotSupportedException{
		ComparableAccount clonedAccount = (ComparableAccount) super.clone();
		clonedAccount.dateCreated = (Date) this.dateCreated.clone();
		
		return clonedAccount;
	}
	

	@Override
	public int compareTo(ComparableAccount o) {
		// TODO Auto-generated method stub
		return Double.compare(this.getBalance(), o.getBalance());
	}
}
