package ex;
import javax.swing.*;

public class example {
	

		public static void main(String [] args) {
		String in, name;
		double salary, pctBonus, bonus, travelExpense;
	    int optionCount;
	    
	    int empIndex = 0;
	    
		in = JOptionPane.showInputDialog("Enter the number of workers");
		int workers = Integer.parseInt(in);
		in = JOptionPane.showInputDialog("Enter the number of managers");
		int managers = Integer.parseInt(in);
		in = JOptionPane.showInputDialog("Enter the number of executives");
		int execs = Integer.parseInt(in);
		
		//Initializes the array for the number of workers and it's length.
	    Employee [] work = new Employee[workers];
	    Employee[] manage = new Employee[managers];
	    Employee[] executives = new Employee[execs];
	    
	    //Calculates total employees.
		int totalEmployees = workers + managers + execs;
		Employee[] emp = new Employee[totalEmployees];
		
		for(int i = 0; i < work.length; i++) {
			
			name = JOptionPane.showInputDialog("Enter the worker's name.");
			in = JOptionPane.showInputDialog("Enter the worker'ssalary.");
			salary = Double.parseDouble(in);
			in = JOptionPane.showInputDialog("Enter the worker's bonus percentage.");
			pctBonus = Double.parseDouble(in);
			
			emp[empIndex] = new Worker(name, salary, pctBonus);
			empIndex++;
					
		}
		
		for (int i = 0; i < manage.length; i++) {
			
			name = JOptionPane.showInputDialog("Enter the Manager's name.");
			in = JOptionPane.showInputDialog("Enter the Manager's salary.");
			salary = Double.parseDouble(in);
			in = JOptionPane.showInputDialog("Enter the Manager's bonus percentage.");
			pctBonus = Double.parseDouble(in);
			in = JOptionPane.showInputDialog("Enter the Manager's travel expenses.");
			travelExpense = Double.parseDouble(in);
			
			emp[empIndex] = new Manager(name, salary, pctBonus, travelExpense);
			empIndex++;
			
		}
		
		for (int i = 0; i < executives.length; i++) {
			
			name = JOptionPane.showInputDialog("Enter Executive's name.");
			in = JOptionPane.showInputDialog("Enter Executive's salary.");
			salary = Double.parseDouble(in);
			in = JOptionPane.showInputDialog("Enter Executive's bonus percentage.");
			pctBonus = Double.parseDouble(in);
			in = JOptionPane.showInputDialog("Enter the Executive's travel expenses.");
			travelExpense = Double.parseDouble(in);
			in = JOptionPane.showInputDialog("Enter the Executive's stock options.");
			optionCount = Integer.parseInt(in);
			
			emp[empIndex] = new Executive (name, salary, pctBonus, travelExpense, optionCount);
			empIndex++;
			
		}
		
		String out = "";
		
		String outAll, outW="", outM = "", outE="";
		
		for (int i = 0; i < emp.length; i++) {
			
			//Methods in employee class can be accessed using 
			//typecasting(normally in a if statement with
			//instanceof to ensure safe down casting.
			
			name= emp[i].getName();
			salary=emp[i].getSalary();
			//polymorphic call
			bonus=emp[i].computeBonus();
			
			if(emp[i] instanceof Worker) {
				
				pctBonus = ((Worker) emp[i]).getPctBonus();
				outW += "Name: " + name + "\n";
				outW += "Salary: " + salary + "\n";
				outW += "Percent Bonus: " + pctBonus + "\n";
				outW += "Bonus: " + bonus +"\n";
				
			}
			
			if(emp[i] instanceof Manager) {
				
				pctBonus = ((Manager) emp[i]).getPctBonus();
				travelExpense = ((Manager) emp[i]).getTravelExpense();
				outM += "Name: " + name + "\n";
				outM += "Salary: " + salary + "\n";
				outM += "Percent Bonus: " + pctBonus + "\n";
				outM += "Travel Expenses: " + travelExpense + "\n";
				outM += "Bonus: " + bonus + "\n";
				
			}
			
			if(emp[i] instanceof Executive) {
				
				pctBonus = ((Executive) emp[i]).getPctBonus();
				travelExpense = ((Executive) emp[i]).getTravelExpense();
				optionCount = ((Executive) emp[i]).getOptionsCount();
				outM += "Name: " + name + "\n";
				outM += "Salary: " + salary + "\n";
				outM += "Percent Bonus: " + pctBonus + "\n";
				outM += "Travel Expenses: " + travelExpense + "\n";
				outM += "Option Count: " + optionCount + "\n";
				outM += "Bonus: " + bonus + "\n";
				
			}
			
		}
		
		outAll = outW + outM + outE;
		JOptionPane.showMessageDialog(null, outAll);
		}

}
