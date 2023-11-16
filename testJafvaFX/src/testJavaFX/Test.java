package testJavaFX;
/*********************************************************************************
* (Address book) Write a program that stores, retrieves, adds, and updates       *
* addresses as shown in Figure 17.20. Use a fixed-length string for storing each *
* attribute in the address. Use random access file for reading and writing an    *
* address. Assume that the size of name, street, city, state, and zip is 32, 32, * 
* 20, 2, 5 bytes, respectively.                                                  *
*********************************************************************************/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test extends Application {
	  @Override // Override the start method in the Application class
	  public void start(Stage primaryStage) {    
	    StackPane pane = new StackPane();
	    Button bt1 = new Button("Java");
	    Button bt2 = new Button("Java");
	    Button bt3 = new Button("Java");
	    Button bt4 = new Button("Java");
	    pane.getChildren().addAll(bt1, bt2, bt3, bt4);
	    
	    Scene scene = new Scene(pane, 200, 250);
	    primaryStage.setTitle("Test"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	  }


  /**
   * The main method is only needed for the IDE with limited JavaFX
   * support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}