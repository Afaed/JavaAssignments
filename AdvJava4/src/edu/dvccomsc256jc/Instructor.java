/*
 * Justin Choy
 * Student ID: 1731686 
 * */

package edu.dvccomsc256jc;
import java.util.ArrayList;
import java.util.Scanner;

public class Instructor implements Displayable, Inputable, Payable, CourseConstants {
	
	private String name;
	java.util.Date dateHired = new java.util.Date();
	private int id;
	private ArrayList<Course> coursesTeaching;
	
	
	public Instructor(int id, String name) {
	        this.id = id;
	        this.name = name;
	        this.coursesTeaching = new ArrayList<>(10);
	}
	
	public Instructor(){
		this.dateHired = new java.util.Date();
        
        this.coursesTeaching = new ArrayList<>(10);
	}
	
	public String getName() {
        return this.name;
    }

	 public void addCourse(Course course) {
	        if (coursesTeaching.size() < MAX_SECTIONS) {
	            coursesTeaching.add(course);
	        } else {
	            System.out.println("Cannot add more courses. Teaching limit reached.");
	        }
	    }
	 
	  public ArrayList<Course> getCoursesTeaching() {
	        return coursesTeaching;
	    }
	  
	public void dropCourse(Course course) {
		if(coursesTeaching.contains(course)){
			coursesTeaching.remove(course);
		} else {
			System.out.println("Course not found");
		}
	}
	
	
	@Override
	public void display() {
        System.out.println("\n*********** Instructor Information ***********");
        System.out.println("Name: " + name);
        System.out.println("Instructor ID: " + id);
        System.out.println("Hired Date: " + dateHired);
        System.out.println("Courses Taught:");
        for (Course c : coursesTeaching) {
            System.out.print(c.getCourseName() + " ");
        }
        System.out.println();
    }
	
	@Override
	public void getPay(double payment) {
		
		System.out.print("Course Rate: $");
		System.out.printf("%.2f\n", payment);
		
		double salary = payment * coursesTeaching.size();
		
		System.out.print( "Total Salary: $");
		System.out.printf("%.2f\n", salary);
	}
	
	@Override
	public void getInput() {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Please enter the instructor's id: ");
	    this.id = sc.nextInt();

	    System.out.println("Please enter the instructor's name: ");
	    sc.nextLine();  // Consume the newline character
	    this.name = sc.nextLine();
	}
}