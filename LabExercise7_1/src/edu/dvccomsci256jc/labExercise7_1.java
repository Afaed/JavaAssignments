/*
 * Justin Choy
 * Student ID: 1731686 
	*
 * */
package edu.dvccomsci256jc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class labExercise7_1 extends Application {
	
	protected class TrafficLight extends Pane {
		
		private TrafficLight(){
		//stoplight
		Rectangle rec = new Rectangle(300/3.0, 300/6.0, 300/3, 300/1.5);
		rec.setFill(Color.TRANSPARENT);
		rec.setStroke(Color.BLACK);
		getChildren().add(rec);
		
		
		//Pane for buttons
		String [] colorNames = {"Red", "Yellow", "Green"};
		Circle [] lights = new Circle[3];
		Color[] colors = new Color[] {Color.RED, Color.YELLOW, Color.GREEN};
		double [] circleMeas = new double[] {0.3, 0.5, 0.7};
		RadioButton [] rbOptions = new RadioButton[lights.length];
		
		ToggleGroup group = new ToggleGroup();
		
		for(int i = 0; i < lights.length; i++) {
			lights[i] = new Circle(300/2, 300 * circleMeas[i], 300 * 0.09);
			lights[i].setFill(Color.TRANSPARENT);
			lights[i].setStroke(Color.BLACK);
			rbOptions[i] = new RadioButton(colorNames[i]);
			
			final int index = i;
			rbOptions[i].setOnAction(e -> {
				resetColors(lights);
				lights[index].setFill(colors[index]);
			});
			rbOptions[i].setToggleGroup(group);
		}
		
		
		HBox radioButtonPane = new HBox(10);
		radioButtonPane.getChildren().addAll(rbOptions);
		radioButtonPane.setAlignment(Pos.CENTER);
		radioButtonPane.setLayoutX(300* 0.2);
        radioButtonPane.setLayoutY(300 - 30);
		
		getChildren().addAll(lights);
		getChildren().addAll(radioButtonPane);
		}

		private void resetColors(Circle[] lights) {
			// TODO Auto-generated method stub
			for(Shape s: lights) {
				s.setFill(Color.TRANSPARENT);
			}
		}
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Event handler to handle when option is picked.
			
			//if() {}
			Pane pane = new TrafficLight();
			
			primaryStage.setTitle("Lab Exercise 7-1");
			primaryStage.setScene(new Scene(pane));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

