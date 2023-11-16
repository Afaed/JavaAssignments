/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsc256jc;

import java.util.Scanner;
import java.util.ArrayList;

public class Assignement2 {
	
	public static void main (String [] args) {
	
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("Enter the array size n: ");
		int input = myObj.nextInt();
		
		ArrayList <Integer> row = new ArrayList<Integer>();
		ArrayList <Integer> column = new ArrayList<Integer>();

		int arr[][] = new int[input + 1][input + 1];
		//This is the for loop for the top row
		
		
		BinaryMatrix system = new BinaryMatrix(input, arr, row, column);
		
		system.generateArr(input);
		system.rowCount(arr, row);
		system.colCount(arr, column);
		
		System.out.println("The index of the biggest row is " + row);
		System.out.println("The index of the biggest column is " + column);
	}
}

