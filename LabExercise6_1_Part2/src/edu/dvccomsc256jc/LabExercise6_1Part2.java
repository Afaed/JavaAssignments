/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsc256jc;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class LabExercise6_1Part2 extends Application {
	Pane pane = new Pane();
	
    @Override
    public void start(Stage primaryStage) {
        
    	  pane.setOnMouseClicked(e-> {
              double x = e.getX();
              double y = e.getY();

              if (e.getButton() == MouseButton.PRIMARY) {
            	  Circle circle = new Circle(x, y, 10, Color.TRANSPARENT);
              	circle.setStroke(Color.BLACK);
              	
                  pane.getChildren().add(circle);
              } else if (e.getButton() == MouseButton.SECONDARY) {
            	  ObservableList<Node> list = pane.getChildren();
                  for (int i = list.size() - 1; i >= 0; i--) 
                  {
                      Node c = list.get(i);

                      if (c instanceof Circle && c.contains(x, y)) {
                          pane.getChildren().remove(c);
                          break;
                      }
                  }
              }
    	  });
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Lab 6-1 part 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
