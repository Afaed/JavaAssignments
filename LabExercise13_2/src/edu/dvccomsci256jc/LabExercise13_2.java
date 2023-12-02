/*
 * Justin Choy
 * Student ID: 1731686 
/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256jc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LabExercise13_2 {
	
private static Set <Integer> numbers = new HashSet<>();

	public static void main(String [] args) {
		ExecutorService e = Executors.newFixedThreadPool(2);
		Thread thread1 = new Thread(new add());
		Thread thread2 = new Thread(new iterator());
		e.execute(thread1);
		e.execute(thread2);
		e.shutdown();
	}

	private static class add implements Runnable {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Thread 1");
			int i = 0;
			while(i <= 70) {
				try {
					Thread.sleep(1000);
					numbers.add(i++);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				numbers.add(i);
				
				System.out.println(i);
				
			}
			
		}
	}
	
	private static class iterator implements Runnable {
		@Override
		public void run() {
		System.out.println("Thread 2");
		
				while(true) {
				try {
					Thread.sleep(1000);

					Iterator<Integer> iterator = numbers.iterator();
					Integer num = iterator.next();
					System.out.println(num);
					Thread.sleep(10);
				} catch(InterruptedException e){
					e.printStackTrace();
				}
				
					}
				}
		}
}