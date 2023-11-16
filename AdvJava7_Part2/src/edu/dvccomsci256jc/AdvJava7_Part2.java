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

public class AdvJava7_Part2 extends Application {
	Button btPause1 = new Button("Pause");
    Button btResume1 = new Button("Resume");
    Button btReverse1 = new Button("Reverse");
    HBox boxPane1 = new HBox(5);
    
    Button btPause2 = new Button("Pause");
    Button btResume2 = new Button("Resume");
    Button btReverse2 = new Button("Reverse");
    HBox boxPane2 = new HBox(5);
    
    Button btPause3 = new Button("Pause");
    Button btResume3 = new Button("Resume");
    Button btReverse3 = new Button("Reverse");
    HBox boxPane3 = new HBox(5);
    
    FlowPane spane1 = new FlowPane();
    FlowPane spane2 = new FlowPane();
    FlowPane spane3 = new FlowPane();
    
    Fan fan1 = new Fan();
	Fan fan2 = new Fan();
	Fan fan3 = new Fan();
	
	Slider slider1 = new Slider(1, 10, 3);
    Slider slider2 = new Slider(1, 10, 3);
    Slider slider3 = new Slider(1, 10, 3);
    
    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        // Create a FanPane instance
    	
    	
    	fan1.setWidth(300.0);  // Set an appropriate width
    	fan1.setHeight(400.0);
    	fan1.displayFan();
    	fan1.setAnimation(fan1);
    	
    	fan2.setWidth(300.0);  // Set an appropriate width
    	fan2.setHeight(400.0);
    	fan2.displayFan();
    	fan2.setAnimation(fan2);
    	
    	fan3.setWidth(300.0);  // Set an appropriate width
    	fan3.setHeight(400.0);
    	fan3.displayFan();
    	fan3.setAnimation(fan3);
    	
    	
        // Create a FlowPane and add the FanPane to it
        
        fan1.setWidth(300);  // Set an appropriate width
        fan1.setHeight(400);
        fan2.setWidth(300);
        fan2.setHeight(400);
        fan3.setWidth(300);
        fan3.setHeight(400);
        
        spane1.getChildren().addAll(fan1);
        spane2.getChildren().addAll(fan2);
        spane3.getChildren().addAll(fan3);

        // Create buttons and slider
        
        
        boxPane1.getChildren().addAll(btPause1, btResume1, btReverse1);
        boxPane1.setAlignment(Pos.CENTER);
        boxPane2.getChildren().addAll(btPause2, btResume2, btReverse2);
        boxPane2.setAlignment(Pos.CENTER); 
        boxPane3.getChildren().addAll(btPause3, btResume3, btReverse3);
        boxPane3.setAlignment(Pos.CENTER);
        
        
        // Set actions for the buttons and slider
        btPause1.setOnAction(e -> fan1.getAnimation().pause());
        btResume1.setOnAction(e -> fan1.getAnimation().play());
        btReverse1.setOnAction(e -> fan1.reverse());

        btPause2.setOnAction(e -> fan2.getAnimation().pause());
        btResume2.setOnAction(e -> fan2.getAnimation().play());
        btReverse2.setOnAction(e -> fan2.reverse());

        btPause3.setOnAction(e -> fan3.getAnimation().pause());
        btResume3.setOnAction(e -> fan3.getAnimation().play());
        btReverse3.setOnAction(e -> fan3.reverse());
        
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            fan1.increaseSpeed(slider1.getValue());
        });
        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            fan2.increaseSpeed(slider2.getValue());
        });
        slider3.valueProperty().addListener((observable, oldValue, newValue) -> {
            fan3.increaseSpeed(slider3.getValue());
        });
        
        
        
        BorderPane fan1Pane = createFanBorderPane(fan1, btPause1, btResume1, btReverse1, slider1);
        BorderPane fan2Pane = createFanBorderPane(fan2, btPause2, btResume2, btReverse2, slider2);
        BorderPane fan3Pane = createFanBorderPane(fan3, btPause3, btResume3, btReverse3, slider3);
        
        HBox mainBox = new HBox(20);
        mainBox.getChildren().addAll(fan1Pane, fan2Pane, fan3Pane);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.getChildren().add(createMasterButtonsBox());
        // Create a scene and add it to the stage
        Scene scene = new Scene(mainBox, 1200, 600);
        primaryStage.setTitle("AdvJava-7 Part Two");
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.widthProperty().addListener(e -> {
            fan1.setWidth(fan1.getWidth());
            fan2.setWidth(fan2.getWidth());
            fan3.setWidth(fan3.getWidth());
        });
        scene.heightProperty().addListener(e -> {
            fan1.setHeight(fan1.getHeight());
            fan2.setHeight(fan2.getHeight());
            fan3.setHeight(fan3.getHeight());
        });
    }
    
    public static void main (String [] args) {
    	launch(args);
    }
    
    private BorderPane createFanBorderPane(Fan fan, Button pauseBtn, Button resumeBtn, Button reverseBtn, Slider slider) {
        BorderPane borderPane = new BorderPane();

        // Create a VBox to hold buttons and add buttons to it
        HBox buttonBox = new HBox(10, pauseBtn, resumeBtn, reverseBtn);
        buttonBox.setAlignment(Pos.TOP_CENTER);

        // Set the preferred size for the HBox
        buttonBox.setPrefHeight(80);  // Adjust the height as needed

        // Set the preferred size for the Slider
        slider.setPrefHeight(40);  // Adjust the height as needed

        // Add fan to the center of the BorderPane
        borderPane.setCenter(fan);

        // Add buttonBox to the top of the BorderPane
        borderPane.setTop(buttonBox);

        // Add slider to the bottom of the BorderPane
        borderPane.setBottom(slider);
        BorderPane.setAlignment(slider, Pos.CENTER);

        // Style the BorderPane with a black border
        borderPane.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 10px;");

        return borderPane;
    }
  
 
        private HBox createMasterButtonsBox() {
        	 Button startAllBtn = new Button("Start all");
             Button stopAllBtn = new Button("Stop all");
             
             startAllBtn.setOnAction(e -> {
             	fan1.getAnimation().play();
             	fan2.getAnimation().play();
             	fan3.getAnimation().play();
             });
             
             stopAllBtn.setOnAction(e -> {
             	fan1.getAnimation().pause();
             	fan2.getAnimation().pause();
             	fan3.getAnimation().pause();
             });
             
            HBox masterButtonsBox = new HBox(startAllBtn, stopAllBtn);
            masterButtonsBox.setAlignment(Pos.CENTER);
            masterButtonsBox.setSpacing(10);

            return masterButtonsBox;
        }

}
