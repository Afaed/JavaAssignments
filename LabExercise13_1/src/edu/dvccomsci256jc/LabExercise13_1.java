/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256jc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LabExercise13_1 {
	private static NoSync noSync = new NoSync();
	private static Sync sync = new Sync();
	private static LockAndSync lock = new LockAndSync();
	
	public static void main (String [] args) {
		ExecutorService execute = Executors.newCachedThreadPool();
	
		for(int i = 0; i < 1000; i++) {
			execute.execute(new Task());
			execute.execute(new SyncTask());
			execute.execute(new lockTask());
		}
		
		execute.shutdown();
		while(!execute.isTerminated());
		
		System.out.println("What is sum (Without sync)? " + noSync.getSum());
		System.out.println("What is sum1 (With sync)? " + sync.getSum());
		System.out.println("What is sum2 (With Lock and Sync)? " + lock.getSum());
	}
	
	private static class Task implements Runnable{
		public void run() {
			noSync.add(1);
		}
	}
	
	private static class SyncTask implements Runnable {
		public void run() {
			sync.add(1);
		}
	}
	
	private static class lockTask implements Runnable{
		public void run() {
			lock.add(1);
		}
	}
}
