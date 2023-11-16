package edu.dvccomsc256jc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.text.DecimalFormat;

public class LabExercise4_2_test {
	
	public static void main(String [] args) {
		
		int i;
		double withdraw = 100;
		
		DecimalFormat df = new DecimalFormat("0.00");
		ArrayList<ComparableAccount> accounts = new ArrayList<>(Arrays.asList(
		
		new ComparableAccount(1001, 1000.00),
		new ComparableAccount(1002, 1000.00),
		new ComparableAccount(1003, 1000.00),
		new ComparableAccount(1004, 1000.00),
	    new ComparableAccount(1005, 1000.00)
		
		));
		
		accounts.forEach(account -> account.Deposit(500.00));
		
		//before sorting
		
		System.out.println("Before sorting: ");
		
		//handles the withdrawing of money
		
		for(ComparableAccount a : accounts) {
			
			String amountFormatted = df.format(withdraw);
			
			double amount = Double.parseDouble(amountFormatted);
			
			a.Withdraw(amount);
			
			withdraw += 100;
			
		}
		
		//prints the original array
		
		for(i = 0; i < 5; i++) {
			System.out.println(accounts.get(i));
		}
		
		//clones the arraylist for comaparisons
		
		List<ComparableAccount> cloneAccounts = new ArrayList<>();
		
		for(ComparableAccount a : accounts) {
			cloneAccounts.add(a);
		}
		
		for(i = 0; i < 5; i++) {
			
			//String arrayName = "cloneAccounts.dateCreated==accounts.dateCreated["+ i + "]: ";
			//System.out.print(arrayName);

            ComparableAccount cloneAccount = cloneAccounts.get(i);
            ComparableAccount originalAccount = accounts.get(i);
            
			System.out.println("CloneArray.dateCreated==OriginalArray.dateCreated[" + i + "]: " + 
					(cloneAccount.getDate() == originalAccount.getDate()));
		}
		
		//compaares the dates created in clone array to the new original-hence 0;)
		 for (i = 0; i < 5; i++) {
	            ComparableAccount cloneAccount = cloneAccounts.get(i);
	            ComparableAccount originalAccount = accounts.get(i);
	            
	            System.out.println("CloneArray.dateCreated.compareTo(OriginalArray.dateCreated)): " +
	                    cloneAccount.getDate().compareTo(originalAccount.getDate()));
	        }
		 
		 
		
		//Sorting the original arraay
		System.out.println("After sorting: ");
		Collections.sort(accounts);
		
		for(ComparableAccount a : accounts) {
			System.out.println(a);
		}
		
		
	}
}
