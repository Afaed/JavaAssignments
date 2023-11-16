package edu.dvccomsc256jc;

public class AdvJava4_test {
	
	public static void main(String[] args) {
	    Student student = new Student();
	    student.getInput();

	    Instructor instructor = new Instructor();
	    instructor.getInput();
	    
	    Course course = new Course();
	    course.getInput();
	    
	    Instructor englishTeach = new Instructor(102, "Davy Jones");
		Student newStudent = new Student (103, "George");
		
		Course englishCourse = new Course("Pirate English", englishTeach.getName());
		
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
		
	    // Associate the student and instructor with the course
	    course.addStudent(student.getName());
	    course.setInstructor(instructor);
	    instructor.addCourse(course);
	    student.addCourse(course);
	    
	    

	    // Display student, instructor, and course information
	    student.display();
	    instructor.display();
	    course.display();
	    
		
		//Second example's output
		
		newStudent.addCourse(course);
		newStudent.addCourse(englishCourse);
		
		englishCourse.addStudent(newStudent.getName());
		englishCourse.addStudent("Britanny");
		englishCourse.addStudent("Bowser");
		englishCourse.addStudent("Robert Plant");
		englishCourse.addStudent("Tyler");
		englishCourse.addStudent("Boston");
		
		englishCourse.addStudent("Santos");
		englishCourse.addStudent("Mikey");
		englishCourse.addStudent("Rebecca");
		
		englishCourse.setInstructor(englishTeach);
		
		englishTeach.addCourse(englishCourse);
		englishTeach.addCourse(course);
		
		newStudent.display();
		englishTeach.display();
		englishCourse.display();
		
		student.display();
		student.getBill(180.00);
		instructor.display();
		instructor.getPay(1800.00);
		
		newStudent.display();
		newStudent.getBill(20000.00);
		englishTeach.display();
		englishTeach.getPay(5600.00);
	}
	
}
