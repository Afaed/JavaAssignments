/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsc256jc;

import java.util.Scanner;

public class Course implements CourseConstants, Displayable, Inputable {

		
		private String courseName, instructorName;
		  private Instructor instructor; 
		private int capacity, numberOfStudents;
		private String [] studentList;
		private int z = 0;
		
		public Course() {
			
			courseName = "";

			numberOfStudents = 0;

			capacity = MAX_COURSE_STUDENT;

			studentList = new String[capacity];
			
		}
//		
//		public Course(String name) {
//			
//			courseName = name;
//			
//			capacity = 16;
//			
//			numberOfStudents = 0;
//
//			studentList = new String[16];
//		}
		
		public Course(String name, String instructor) {
			
			this.instructorName = instructor;
			
			courseName = name;
			
			numberOfStudents = 0;
			
			capacity = 16;
		    studentList = new String[capacity];
;
			
		}
		
		public String getInstructor() {
			return this.instructorName;
		}
		
		public String getCourseName() {
			return this.courseName;
		}
		
		public int getNumberOfStudents() {
			
			return this.numberOfStudents;
			
		}
		
		private void increaseSize() {
		    String[] temp = new String[capacity *= 2];
		    System.arraycopy(studentList, 0, temp, 0, numberOfStudents);  // Copy only the current students
		    studentList = temp;
		    capacity = capacity * 2;
		}
		
		public void addStudent(String student) {
			
			if(numberOfStudents < capacity)
			{
				
				studentList[numberOfStudents] = student;
				numberOfStudents+=1;
	
				}
			else
			{
				increaseSize();
			}
				
		}
		
		public void dropStudent(String student) {

		int i = -1;

		if(numberOfStudents == 0)
		System.out.print("\n No students available to drop");
		
		else
		{

			for(int c = 0; c < numberOfStudents; c++)
				{

				if(studentList[c].compareTo(student) == 0) {

		for(int d = c; d < numberOfStudents; d++) {

			studentList[d] = studentList[d + 1];
			
//			studentList[d] = "";

			numberOfStudents--;

			i = c;
					}

				}	
		}

		if(i == -1) {

		System.out.print("\nNo students available with name "

		+ student);

			}
		}
	}
		public void clear() {

				System.out.println("====================================");
				System.out.println("Course Name: " + courseName);
				System.out.println("Taught by: " + instructor);
				System.out.println("There are/is: " + 0 + " students enrolled in the course");
				
				System.out.println("This is the list of students: " );
				for(int i = 0; i < studentList.length; i++) {
					if (studentList[i] != null) {
					studentList[i] = "";
					System.out.print(studentList[i] + " ");
					}
				}
		}

		@Override
		public void display() {
			// TODO Auto-generated method stub
			if(numberOfStudents == 0) {
				System.out.println("No students in the list.");
			} else {
				System.out.println("====================================");
				System.out.println("Course Name: " + courseName);
				System.out.println("Taught by: " + instructorName);
				System.out.println("There are/is: " + numberOfStudents + " enrolled in the course");
				
				
				System.out.println("This is the list of students: ");
				for(int i = 0; i < numberOfStudents; i++) {
					if (studentList[i] != null) {
					
					System.out.print(studentList[i] + " ");
					}
				}
			}	
			
		}
		
		 public void setInstructor(Instructor instructor) {
		        if (z < MAX_COURSE_INSTRUCTOR) {
		            this.instructor = instructor;
		            this.instructorName = instructor.getName();
		            z++;
		        } else {
		            System.out.println("Course has reached the maximum number of instructors.");
		        }
		    }
		
		@Override
		public void getInput() {
			// TODO Auto-generated method stub

			Scanner sc = new Scanner(System.in);
			
//			Student newStudent = new Student();
//			newStudent.getInput();
//						
//			Instructor newInstructor = new Instructor();
//			newInstructor.getInput();
//			this.setInstructor(newInstructor);
			
		    // Create the Instructor object and set the instructor for this course
			
			System.out.println("Please enter name of course: ");
			
			this.courseName = sc.nextLine();
			
//			Course course = new Course(this.courseName, newInstructor.getName());
//			Course courseTwo = new Course("Science", "Rocha");
//			
//			//To add all the student info
//			newStudent.addCourse(course);
//			newStudent.addCourse(courseTwo);
//			
//			//To add all the instructor infor
//			  
//			
//			//Adds student to course
//			course.addStudent(newStudent.getName());
//			
//			//Displays Instructor and student info
//			newStudent.display();
			
			sc.close();
		}
}