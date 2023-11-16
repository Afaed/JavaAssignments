package edu.dvccomsc256jc;

public class Course {

		
		private String courseName, instructor;
		private int capacity, numberOfStudents;
		private String [] studentList;
		
		public Course() {
			
			courseName = "";

			numberOfStudents = 0;

			capacity = 16;

			studentList = new String[16];
			
		}
		
		public Course(String name) {
			
			courseName = name;
			
			capacity = 16;
			
			numberOfStudents = 0;

			studentList = new String[16];
		}
		
		public Course(String name, String instructor) {
			
			this.instructor = instructor;
			
			courseName = name;
			
			numberOfStudents = 0;

			studentList = new String[16];
			
		}
		
		public String getInstructor() {
			return this.instructor;
		}
		
		public String getCourseName() {
			return this.courseName;
		}
		
		public int getNumberOfStudents() {
			
			return this.numberOfStudents;
			
		}
		
		public void addInstructor(String instructor) {
			this.instructor = instructor;
		}
		
		private void increaseSize()
		{
		     String[] temp = new String[capacity *= 2];
		     System.arraycopy(studentList, 0, temp, 0, studentList.length);
		     studentList = temp;
		     capacity = capacity * 2;
		     numberOfStudents++;
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

		public void print(){	
			if(numberOfStudents == 0) {
				System.out.println("No students in the list.");
			} else {
				System.out.println("====================================");
				System.out.println("Course Name: " + courseName);
				System.out.println("Taught by: " + instructor);
				System.out.println("There are/is: " + numberOfStudents + " enrolled in the course");
				
				
				System.out.println("This is the list of students: ");
				for(int i = 0; i < studentList.length; i++) {
					if (studentList[i] != null) {
					
					System.out.print(studentList[i] + " ");
					}
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
}
	
