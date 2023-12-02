/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256jc;

public class NoSync {
	private Integer sum = 0;
	
	public Integer getSum() {
		return sum;
	}
	
public void add(Integer amount) {
		Integer newSum = sum + amount;
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sum = newSum;
	}
}
