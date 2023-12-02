/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256jc;

import java.util.Random;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

@SuppressWarnings("rawtypes")
public class AdvJava13 extends RecursiveTask{
	private static final long serialVersionUID = 1L;
	private static final int LIMIT = 10000000;
	double list[];
	private int start, end;
	private Random random;
	
	AdvJava13(double[] list, int start, int end, Random random){
		this.list = list;
		this.start = start;
		this.end = end;
		this.random = random;
	}
	public static void main (String [] args) {
		  final int n = 9000000;
		  double [] list = new double[n];
		  
		  long start = System.currentTimeMillis();
		  sequentialAssignValues(list);
		  long end = System.currentTimeMillis();
		  
		  System.out.println("Sequential time is " + (end - start) + " milliseconds");
		  
		  start = System.currentTimeMillis();
		  parallelAssignValues(list);
		  end = System.currentTimeMillis();
		  
		  System.out.println("Parallel time with " + Runtime.getRuntime().availableProcessors() + " processors is " + (end - start) + " milliseconds");
	  }
	
	@SuppressWarnings("unchecked")
	public static void parallelAssignValues(double[] list) {
		  try (ForkJoinPool pool = new ForkJoinPool()) {
			Random r = new Random();
			  AdvJava13 task = new AdvJava13(list, 0, list.length, r);
			  pool.invoke(task);
		}
	  }
	
	@Override
    protected Integer compute() {
        if (end - start <= LIMIT) {
            for (int i = start; i < end; i++) {
                list[i] =  random.nextDouble();
            };
        } else {
            int mid = (start + end) / 2;
            invokeAll(
                new AdvJava13(list, start, mid, random),
                new AdvJava13(list, mid, end, random)
            );
        }
        return null;
    }
	  public static void sequentialAssignValues(double[] list) {
	        Random random = new Random();
	        for (int i = 0; i < list.length; i++) {
	            list[i] = random.nextDouble();
	        }
	    }
}
