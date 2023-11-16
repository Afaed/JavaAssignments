/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package dvc.educomsc256jc;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Point2D;

public class Lab5Part1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        String[] array = "Welcome To JavaFX".split("");

        Pane pane = new Pane();
        Point2D center = new Point2D(200.0, 200.0);
        double radius = 100;

        // Calculate the angle per character (including the spaces between words)
        double anglePerChar = -360.0 / array.length+1;
        
        Font font = Font.font("Times New Roman", FontWeight.MEDIUM, 24);
        
        double rotate = 90;  // Start rotation angle
        double angle = 0;
        
        for (int i = 0; i < array.length; i++, angle += anglePerChar, rotate -= anglePerChar) {
        	
            double x = center.getX() + radius * Math.cos(Math.toRadians(angle));
            double y = center.getY() - radius * Math.sin(Math.toRadians(angle));
            Text text = new Text(x, y, array[i]);
            text.setFont(font);
            text.setRotate(rotate);
            pane.getChildren().add(text);
        }

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Lab Exercise 5-1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
