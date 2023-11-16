package edu.dvccomsc256jc;

public class Lab_Exercise_1_2 {
	
	public static void main (String [] args) {
		
		Course course = new Course("Comsci");
		
		course.addInstructor("David Lai");
		

		course.addStudent("Rod");
	
		course.addStudent("Leo");
	
		course.addStudent("Joey");

		course.addStudent("Timmy");

		course.addStudent("James Bonham");

		course.addStudent("Mick Fleetwood");

		course.addStudent("Seline");
	
		course.addStudent("Britanny");
		course.addStudent("Bowser");
		course.addStudent("Robert Plant");
		course.addStudent("Tyler");
		course.addStudent("Boston");
		
		course.addStudent("Santos");
		course.addStudent("Mikey");
		course.addStudent("Rebecca");
		course.addStudent("Sam");
		course.addStudent("Claude");
		
		course.dropStudent("Joey");
		
		
		System.out.println();
		course.print();
		
		System.out.println();
		
		System.out.println("List of students after calling clear()");
		
		course.clear();
}
}
