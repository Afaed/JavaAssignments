/*
 * Justin Choy
 * Student ID: 1731686 
 * 
 * To do:
 * 	1) Write the try catch statement
 * 	2) Use PrintStackTrace()
 *  3) Write method bin2dec-which converts binary to integer.
 *  	a) returns the Binary format exception when a non 0/1 is encountered
 *  	b) make sure it returns the first illegal character found
 *  	- Output is "Illegal character: " + first illegal character.
 *  	
 * */
package edu.dvccomsc256jc;

import java.util.Scanner;

public class Lab3Exercise {
	
	public static int bin2dec(String myObj) throws BinaryFormatException {
		
		char [] objArr = myObj.toCharArray();
		
			for(char c : objArr)
			{
				if(c != '0' && c != '1') {
				throw new BinaryFormatException("Illegal character at: " + c);
				}
			}
		
		int binaryNumber = Integer.parseInt(myObj, 2);
		return binaryNumber;
}


	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Binary number:");
	
		String input = in.nextLine();
		
			try {
				
		        bin2dec(input);
		        
		        System.out.println("Decimal equivalent: " + bin2dec(input));
		    } catch (BinaryFormatException e) {
		        e.printStackTrace();
		    }
			
		in.close();	
	}
}
			
