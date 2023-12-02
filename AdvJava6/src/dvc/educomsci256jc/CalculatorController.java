/*
 * Justin Choy
 * Student ID: 1731686 
 * */

package dvc.educomsci256jc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CalculatorController {
private CalculatorView theView;
private CalculatorModel theModel;
public CalculatorController(CalculatorView theView, CalculatorModel theModel)
{
this.theView = theView;
this.theModel = theModel;
this.theView.addCalculateListener(new calculateListener());
}
private class calculateListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
        double firstNumber, secondNumber = 0;
        String operator;

        try {

            firstNumber = theView.getFirstNumber();
            secondNumber = theView.getSecondNumber();
            operator = theView.getOperator();


            if (operator == null) {
                throw new NoOperandSelectedException("No operator selected.");
            }

            switch(operator){
                case "+":
                    theModel.addTwoNumbers(firstNumber, secondNumber);
                    break;
                case "-":
                    theModel.subtractTwoNumbers(firstNumber, secondNumber);
                    break;
                case "*":
                    theModel.multiplyTwoNumbers(firstNumber, secondNumber);
                    break;
                case "÷":
                    theModel.divideTwoNumbers(firstNumber, secondNumber);
                    break;
            }

            theView.setCalcSolution(theModel.getCalculationValue());
        } catch(NoOperandSelectedException ex) {
            theView.displayErrorMessage("You Need To Pick An Operand");
        } catch (NumberFormatException ex) {
            theView.displayErrorMessage("You Need to Enter 2 Integers");
        }
    }
	}
}
