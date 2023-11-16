/*
 * Justin Choy
 * Student ID: 1731686 
 * */

package dvc.educomsc256jc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.math.*;
import java.math.RoundingMode;

public class LabExercise6_1 extends Application{
	TextField integerOne = new TextField();
	TextField integerTwo = new TextField();
	TextField output = new TextField();
	
	Button add = new Button("Addition");
	Button subtract = new Button("Subtract");
	Button multiply = new Button("Multiply");
	Button divide = new Button("Divide");
	

	public void add() {
	    double a = Double.parseDouble(integerOne.getText());
	    double b = Double.parseDouble(integerTwo.getText());

	    BigDecimal sum = BigDecimal.valueOf(a + b);
	    sum = sum.stripTrailingZeros();

	    String formattedOutput = (sum.scale() <= 0) ? String.valueOf(sum.intValue()) : sum.setScale(2, RoundingMode.HALF_UP).toPlainString();
	    output.setText(formattedOutput);
	}
	public void subtract() {
	    double a = Double.parseDouble(integerOne.getText());
	    double b = Double.parseDouble(integerTwo.getText());

	    BigDecimal difference = BigDecimal.valueOf(a - b);
	    difference = difference.stripTrailingZeros();

		String formattedOutput = (difference.scale() <= 0) ? String.valueOf(difference.intValue()) : difference.setScale(2, RoundingMode.HALF_UP).toPlainString();
		output.setText(formattedOutput);
	}
	
	public void multiply() {
	    double a = Double.parseDouble(integerOne.getText());
	    double b = Double.parseDouble(integerTwo.getText());

	    BigDecimal product = BigDecimal.valueOf(a * b);
	    product = product.stripTrailingZeros();

	    String formattedOutput = (product.scale() <= 0) ? String.valueOf(product.intValue()) : product.setScale(2, RoundingMode.HALF_UP).toPlainString();
	    output.setText(formattedOutput);
	}
	
	public void divide() {
	    double first = Double.parseDouble(integerOne.getText());
	    double second = Double.parseDouble(integerTwo.getText());

	    BigDecimal quotient = BigDecimal.valueOf(first / second);
	    quotient = quotient.stripTrailingZeros();

	    String formattedOutput = (quotient.scale() <= 0) ? String.valueOf(quotient.intValue()) : quotient.setScale(2, RoundingMode.HALF_UP).toPlainString();
	    output.setText(formattedOutput);
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Lab 6-1");
		HBox pane = new HBox();
		
		integerOne.setPrefWidth(60);  // Set the preferred width for integerOne text field
		integerTwo.setPrefWidth(60);  // Set the preferred width for integerTwo text field
		output.setPrefWidth(60);     // Set the preferred width for output text field

		Label label1 = new Label("Number 1:");
		Label label2 = new Label("Number 2:");
		Label result = new Label("Result:");
		
		pane.getChildren().addAll(
				label1, integerOne, 
				label2, integerTwo, 
				result, output
		);

		output.setEditable(false);
		
		//Calculations fields.
		add.setOnAction( e -> {
			add();
		});
		subtract.setOnAction(e->{
			subtract();
		});
		multiply.setOnAction(e -> {
			multiply();
		});
		divide.setOnAction(e-> {
			divide();
		});
		
		 HBox operator = new HBox();
	     operator.setSpacing(10);
	     operator.setAlignment(Pos.CENTER);
	     operator.getChildren().addAll(add, subtract, multiply, divide);

	     BorderPane borderPane = new BorderPane(pane);
	     BorderPane.setMargin(pane, new Insets(10, 10, 10, 10));

	      borderPane.setBottom(operator);
	      BorderPane.setMargin(operator, new Insets(10, 10, 10, 10));
	      primaryStage.setScene(new Scene(borderPane, borderPane.getPrefWidth(),borderPane.getPrefWidth()));
	        primaryStage.show();
	}
	
	public static void main (String [] args) {
		launch(args);
	}
}
