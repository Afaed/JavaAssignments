/*
 * Justin Choy
 * Student ID: 1731686 
 * */

package dvc.educomsci256jc;

import javafx.application.Application;
import javafx.stage.Stage;

public class MVCCalculator extends Application{
@Override
public void start(Stage primaryStage) {
CalculatorView theView = new CalculatorView();
CalculatorModel theModel = new CalculatorModel();

new CalculatorController(theView,theModel);

primaryStage.setTitle("JavaFX MVC Demo");
primaryStage.setScene(theView.getScene());
primaryStage.show();
}
public static void main(String[] args) {
Application.launch(args);
}
}