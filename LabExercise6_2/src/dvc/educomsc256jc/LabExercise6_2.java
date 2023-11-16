/*
 * Justin Choy
 * Student ID: 1731686 
	*
 * */
package dvc.educomsc256jc;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LabExercise6_2 extends Application{

	@Override
    public void start(Stage primaryStage) {
        Pane root = new StackPane();

        // Create a Circle with radius 100 (circular path)
        Circle circle = new Circle(100);
        circle.setFill(Color.TRANSPARENT);
        circle.centerXProperty().bind(root.widthProperty().divide(2));
        circle.centerYProperty().bind(root.heightProperty().divide(2));
        circle.setRotate(180);
        // Create a Text node
        Text message = new Text("Programming is fun");
        message.setStyle("-fx-font-size: 12; -fx-fill: black");
       
        Path path = new Path();
        path.getElements().addAll(
        		new javafx.scene.shape.MoveTo(100, 100),  // Start point
                new javafx.scene.shape.ArcTo(100, 100, 0, 300, 200, false, false)
        		);
        // Create a PathTransition for the text
        PathTransition pt = new PathTransition(Duration.seconds(5), circle, message);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        pt.play();
        // Reset the circle's radius to 0 when the animation finishes
        pt.setOnFinished(event -> {
            circle.setRadius(0);
            pt.playFromStart();
        });

        // Create a FadeTransition for the text
        FadeTransition ft = new FadeTransition(Duration.seconds(2.5), message);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);  // Set to fully opaque when reaching the end
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        root.getChildren().addAll(circle, message);
        
        // Start the animation
        
        root.setOnMousePressed(e -> {pt.pause(); ft.pause();});
        root.setOnMouseReleased(e -> {pt.play(); ft.play();});
        // Set up the scene and display it
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Lab 6-2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
