/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsc256jc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class BinaryMatrix {

	int random, input;
	ArrayList <Integer> row = new ArrayList<Integer>();
	ArrayList <Integer> column = new ArrayList<Integer>();
	int arr[][] = new int[input + 1][input + 1];
	
	public BinaryMatrix(int input, int [][] arr, ArrayList <Integer> row, ArrayList<Integer> column) {
		
		this.input = input;
		//this.random = random;
		this.row = row;
		this.column = column;
		this.arr = arr;
		
	}
	
	public void generateArr(int input) {
		for (int i = 0; i < arr.length; i ++) {
			 for (int j = 0; j < arr[i].length; j++) {
	                arr[i][j] = (int) (Math.random() * 2);
	            }
		}
		for(int[] x : arr) 
		{
			for(int y : x) 
			{
				System.out.print(y +  "");
			}
		System.out.println();
		}
		
	}

	
	public void colCount(int [][] arr, ArrayList<Integer> column){
		int max = 0;
		for(int i = 0; i < arr.length; i++) 
		{
			int ones = 0;
				for(int j = 0; j < arr[i].length; j++) 
				{
					if(arr[i][j] == 1) {
						ones++;
					}
				}
			if(max < ones){
				max = ones;
				column.clear();
				column.add(i);
			} else if(max == ones) {
				column.add(i);
			}
		}
	}
	
	public void rowCount(int [][] arr, ArrayList<Integer> row) {
		int max = 0;
		for(int i = 0; i < arr.length; i++) 
		{
			int ones = 0;
				for(int j = 0; j < arr[i].length; j++) 
				{
					if(arr[i][j] == 1) {
						ones++;
					}
				}
			if(max < ones){
				max = ones;
				row.clear();
				row.add(i);
			} else if(max == ones) {
				row.add(i);
			}
		}
	}
}