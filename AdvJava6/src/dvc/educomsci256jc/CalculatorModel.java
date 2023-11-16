/*
 * Justin Choy
 * Student ID: 1731686 
 * */

package dvc.educomsci256jc;

public class CalculatorModel  {
	
	private double result;
	

	public  void addTwoNumbers(double firstNumber, double secondNumber) {

	    result = firstNumber + secondNumber;
	    
	}
	
	public void subtractTwoNumbers(double firstNumber, double secondNumber) {
	   
		result = firstNumber - secondNumber;
	    
	}
	
	public void multiplyTwoNumbers(double firstNumber, double secondNumber) {
	   
	    result = firstNumber * secondNumber;
	}
	
	public void divideTwoNumbers(double firstNumber, double secondNumber) {
	   result = firstNumber / secondNumber;
	}
	
	public double getCalculationValue() {
		// TODO Auto-generated method stub
		return result;
	}

}
