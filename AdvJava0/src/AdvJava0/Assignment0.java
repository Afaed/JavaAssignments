/* 
 * Justin Choy
 * Student ID: 1731686 
 */

package AdvJava0;

import javax.swing.JOptionPane;

//import java.util.Scanner;
public class Assignment0  {
	
	public static void main (String [] args) {
	
	String in, out;

	in = JOptionPane.showInputDialog("Enter your name");
	
	out = in + ", Welcome To Java";

	JOptionPane.showMessageDialog(null, out, "Assignment 0", 1);
}
}
