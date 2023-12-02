/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256jc;

public class Sync {
   
    private Integer sum = 0;

    public Integer getSum() {
        return sum;
    }
    public synchronized void add(int amount) {
    	Integer newSum = sum + amount;
    	try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	sum = newSum;
    	
	}
}

