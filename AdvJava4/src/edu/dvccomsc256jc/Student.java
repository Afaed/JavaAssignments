/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsc256jc;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Student implements Chargeable, Inputable, Displayable, CourseConstants {
	private int id;
	private String name;
	java.util.Date dateEnrolled = new java.util.Date();
	private int limit;
	private ArrayList<Course> courseList;
	private Course course;
	int MAX_SECTIONS = 0;
	
	
	public Student(int id, String name) {
		
		  this.id = id;
          this.name = name;
	        this.dateEnrolled = new java.util.Date();
	        this.courseList = new ArrayList<>();
	        this.limit = 5;
		
	}
	
	public Student() {
		this.courseList = new ArrayList<>();
        this.dateEnrolled = new java.util.Date();
        this.limit = 5;
		// TODO Auto-generated constructor stub
	}

	public void addCourse(Course course) {
		if(courseList.size() < limit) {
			courseList.add(course);
		} else {
			System.out.println("Limit on courses taken reached.");
		}
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String setName(String name) {
		
		return this.name = name;
	}
	
	 public void setCourse(Course course) {
	        this.course = course;
	    }
	
	public void dropCourse(Course course) {
		if(courseList.contains(course)){
			courseList.remove(course);
		} else {
			System.out.println("Course not found");
		}
	}
	
	
	@Override
	
	public void display() {

        System.out.println("\n*********** Student Information ***********");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Enrolled Date: " + dateEnrolled);
        System.out.println("Courses Enrolled:");
       
        for (Course course : courseList) {
            System.out.print(course.getCourseName() + " ");
        }
        
        System.out.println();
	}
	@Override
	
	public void getBill(double payment) {
		
		System.out.print("Course Rate: $");
		System.out.printf("%.2f\n", payment);		
		
		double cost = payment * courseList.size();
		System.out.print("Total Balance: $");
		System.out.printf("%.2f\n", cost);
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Enter the student's ID: ");
	    this.id = sc.nextInt();

	    System.out.println("Please Enter the student's name: ");
	    sc.nextLine();  // Consume the newline character
	    this.name = sc.nextLine();

	}

}
