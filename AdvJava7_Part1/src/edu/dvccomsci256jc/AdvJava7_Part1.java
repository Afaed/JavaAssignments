/*
 * Justin Choy
 * Student ID: 1731686 
	*
 * */
package edu.dvccomsci256jc;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AdvJava7_Part1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a FanPane instance
    	Fan fanPane = new Fan();
    	fanPane.setWidth(300);  // Set an appropriate width
    	fanPane.setHeight(400);
    	fanPane.displayFan();
    	fanPane.setAnimation(fanPane);
        // Create a FlowPane and add the FanPane to it
        FlowPane spane = new FlowPane();
        fanPane.setWidth(300);  // Set an appropriate width
        fanPane.setHeight(400);
        
        spane.getChildren().addAll(fanPane);
        

        // Create buttons and slider
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");
        HBox boxPane = new HBox(5);
        boxPane.getChildren().addAll(btPause, btResume, btReverse);
        boxPane.setAlignment(Pos.CENTER);
        Slider slider = new Slider(1, 10, 3);
        
        
        // Set actions for the buttons and slider
        btPause.setOnAction(e -> fanPane.getAnimation().pause());
        btResume.setOnAction(e -> fanPane.getAnimation().play());
        btReverse.setOnAction(e -> fanPane.reverse());

        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            fanPane.increaseSpeed(slider.getValue());
        });

        // Create a BorderPane to arrange the UI components
        BorderPane pane = new BorderPane();
        pane.setCenter(spane);
        pane.setTop(boxPane);
        pane.setBottom(slider);

        // Create a scene and add it to the stage
        Scene scene = new Scene(pane, 300, 400);
        primaryStage.setTitle("AdvJava-7 Part One");
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.widthProperty().addListener(e -> fanPane.setWidth(fanPane.getWidth()));
        scene.heightProperty().addListener(e -> fanPane.setHeight(fanPane.getHeight()));
    }
}
