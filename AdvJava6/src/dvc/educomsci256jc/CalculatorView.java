/*
 * Justin Choy
 * Student ID: 1731686 
 * */

package dvc.educomsci256jc;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class CalculatorView {
	
private TextField firstNumber;
private TextField secondNumber;
private TextField calSolution;
private Button calculateButton;
private Scene scene;
private String operator = null;

public CalculatorView() {
	firstNumber = new TextField();
	secondNumber = new TextField();
	calSolution = new TextField();
	
	calculateButton = new Button("Calculate");
	firstNumber.setPrefWidth(200);
	
	Font font = Font.font("Arial", 12);
	
	Label additionLabel = new Label("+");
	Label subtraction = new Label ("-");
	Label multiplication = new Label("*");
	Label division = new Label("÷");
	
	secondNumber.setPrefWidth(200);
	calSolution.setPrefWidth(200);
	calculateButton.setPrefWidth(200);
	HBox boxForButtons = new HBox(30);
	boxForButtons.setAlignment(Pos.CENTER);
	
	Label [] operators = {additionLabel, subtraction, multiplication, division};
	
	for(Label l : operators) {
		l.setFont(font);
		l.setTextFill(Color.BLACK);
	}
	
	ObservableList<Label> items = FXCollections.observableArrayList(operators);
	
	ComboBox<Label> combo = new ComboBox<>(items);
	
	combo.setPrefWidth(50);
	
	boxForButtons.getChildren().addAll(firstNumber, combo, secondNumber,
	calculateButton, calSolution);
	
	combo.setOnAction(e ->{
		
		Label selected = combo.getValue();
	
		operator = selected.getText();
		setOperator(operator);
		 
		});
	
	scene = new Scene(boxForButtons, 1000, 100);
}

public Scene getScene() {
return scene;
}

public double getFirstNumber() {
return Double.parseDouble(firstNumber.getText());
}

public double getSecondNumber() {
return Double.parseDouble(secondNumber.getText());
}

public void setOperator(String operator) {
	
        this.operator = operator;
    }

public String getOperator() {
    return operator;
}

public void setCalcSolution(double solution){
calSolution.setText(Double.toString(solution));
}

void addCalculateListener(EventHandler<ActionEvent> calculateListener) {
calculateButton.setOnAction(calculateListener);
}

void displayErrorMessage(String errorMessage){
new Alert(Alert.AlertType.ERROR, errorMessage).showAndWait();
}
}
