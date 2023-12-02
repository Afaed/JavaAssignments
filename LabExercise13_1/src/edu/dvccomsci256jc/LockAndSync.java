/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256jc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndSync {
	Integer sum = 0;
	private static Lock lock = new ReentrantLock();

	public Integer getSum () {
		return sum;
	}
	
	public synchronized void add(int amount) {
		lock.lock();
		
		try 
		{
    	Integer newSum = sum+amount;
		Thread.sleep(5);
		sum = newSum; 	 
		}catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
    }
}

