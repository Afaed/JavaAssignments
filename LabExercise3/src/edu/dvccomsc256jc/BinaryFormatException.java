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

public class BinaryFormatException extends Exception{
	BinaryFormatException(){
		super("Illegal binary character");
	}
	
	BinaryFormatException(String message){
		super(message);
	}

	
}
