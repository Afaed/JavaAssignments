package edu.dvccomsci256jc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class SongStructure extends Stage {
    Scene scene;
    BorderPane mainPane;

    public SongStructure() {
        mainPane = new BorderPane();

        VBox buttonSection = createButtonSection();

        mainPane.setLeft(buttonSection);

        scene = new Scene(mainPane, 800, 600);
        setTitle("Song Structure");
        setScene(scene);
    }

    private VBox createButtonSection() {
        VBox buttonSection = new VBox(10);

        // Buttons for generating labels
        Button verseBtn = createButton("Verse");
        Button chorusBtn = createButton("Chorus");
        Button bridgeBtn = createButton("Bridge");
        Button songBreakBtn = createButton("Break");
        Button dalSegnoBtn = createButton("Dal Segno");
        Button codaBtn = createButton("Coda");
        Button saveBtn = createButton("Save");

    	Label [] labels = {new Label("Label 1"), new Label("Label 2")};
        ObservableList<Label> prevStructure = FXCollections.observableArrayList(labels);
    	ComboBox<Label> cbo = new ComboBox<>(prevStructure);

    	cbo.setOnAction(e -> {
    		previous();
    	});
        // Adding functionality to the buttons
        verseBtn.setOnAction(e -> generateAndMakeDraggableLabel("Verse"));
        chorusBtn.setOnAction(e -> generateAndMakeDraggableLabel("Chorus"));
        bridgeBtn.setOnAction(e -> generateAndMakeDraggableLabel("Bridge"));
        songBreakBtn.setOnAction(e -> generateAndMakeDraggableLabel("Break"));
        dalSegnoBtn.setOnAction(e -> generateAndMakeDraggableLabel("Dal Segno"));
        codaBtn.setOnAction(e -> generateAndMakeDraggableLabel("Coda"));
      
        buttonSection.getChildren().addAll(verseBtn, chorusBtn, 
        		bridgeBtn, songBreakBtn,
        		dalSegnoBtn, codaBtn, cbo);
        
        return buttonSection;
    }

    private Button createButton(String text) {
        return new Button(text);
    }

    private void generateAndMakeDraggableLabel(String labelText) {
        Label newLabel = createLabel(labelText);
        makeDraggable(newLabel);
        
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(newLabel);
        mainPane.setCenter(flowPane);
    }

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-background-color: lightblue; -fx-padding: 10;");
        return label;
    }
    private void makeDraggable(Label label) {
        final double[] xOffset = new double[1];
        final double[] yOffset = new double[1];

        label.setOnMousePressed(e -> {
            xOffset[0] = e.getSceneX();
            yOffset[0] = e.getSceneY();
        });

        label.setOnMouseDragged(e -> {
            double xOffsetDelta = e.getSceneX() - xOffset[0];
            double yOffsetDelta = e.getSceneY() - yOffset[0];
            label.setLayoutX(label.getLayoutX() + xOffsetDelta);
            label.setLayoutY(label.getLayoutY() + yOffsetDelta);
            xOffset[0] = e.getSceneX();
            yOffset[0] = e.getSceneY();
        });
    }
    
    private void previous() {
    	
    }
}
