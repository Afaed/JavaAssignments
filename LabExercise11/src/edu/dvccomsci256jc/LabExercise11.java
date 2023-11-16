/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256jc;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LabExercise11 {
	
	public static void main (String [] args) throws Exception {
	
	Scanner input = new Scanner(System.in);
	System.out.println("Enter a text file: ");
	String fileName = input.nextLine();
	
	File file = new File(fileName);
	
	if(file.exists()) {
		System.out.println("The number of vowels and consonants in " + fileName + " is " + countVowels(file) + " and " + countConsonants(file));
	} else {
		System.out.println("File " + fileName + " does not exsist");
	}
	input.close();
}
	
	public static int countVowels (File file) throws Exception{
		// TODO Auto-generated method stub
		
		char [] vowels = {'a', 'e', 'i', 'o', 'u'};
		
		Set<Character> vowelSet = new HashSet<>();
		for (char vowel : vowels) {
			vowelSet.add(vowel);
		}
		
		int count = 0;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(file);
		
		while(input.hasNext()){
			String word = input.next().toLowerCase();
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if(vowelSet.contains(c)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static int countConsonants (File file) throws Exception{
		// TODO Auto-generated method stub
		
		char [] consonants = {
				'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k',
				'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 
				'v', 'w', 'x', 'y', 'z'};
		
		Set<Character> consonantSet = new HashSet<>();
		for(char c :consonants) {
			consonantSet.add(c);
		}
		
		int count = 0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(file);
		
		while(input.hasNext()){
			String word = input.next().toLowerCase();

			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if(consonantSet.contains(c)) {
					count++;
				}
			}
		}
		return count;
	}
	
}
