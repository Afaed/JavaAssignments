package application;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LabExercise5_1_test extends Application{

	@Override
	public void start(Stage newStage) throws Exception {
		// TODO Auto-generated method stub
		
		String[] text = "Welome To Java".split("");
		Circle circle = new Circle();
		
		StackPane pane = new StackPane();
		Point2D center = new Point2D(200, 200);
		double xCoord = center.getX() + 50 * Math.cos(Math.toRadians(40));
		double yCoord = center.getY() + 50 * Math.cos(Math.toRadians(50));
		
		Font font = Font.font("Cambria", FontWeight.SEMI_BOLD, 40);
		
		Text text1 = new Text(90, 90, text[0]);
		
		
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setFill(new Color(0, 0, 0, 0.1));;
		
		
		Label label = new Label("Wecome to java");
		label.setLabelFor(label);
		pane.setRotate(45);
		pane.getChildren().addAll(circle, text1, label);
		
		Scene scene = new Scene (pane, 350, 270);
		newStage.setTitle("LabExercise 5-1");
		newStage.setScene(scene);
		newStage.show();
		
	}
	
	public static void main (String [] args) {
		
		Application.launch(args);
	}

}
