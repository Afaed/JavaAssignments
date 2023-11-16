package edu.dvccomsci256jc;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class FinalView implements viewInterface{
	
	private Scene scene;
	BorderPane borderPane = new BorderPane();
	StackPane stack = new StackPane();
	Label [] list = new Label[4];
	FinalModel model = new FinalModel();
	RecomendationView recView = new RecomendationView();
	userInformation userInfo = new userInformation();
	SongStructure songStruct = new SongStructure();
	
	public FinalView() {

	Label[] generatedLabels = generateLabels(list, list.length);
	ObservableList<Label> prevProgressions = FXCollections.observableArrayList(generatedLabels);
	ComboBox<Label> cbo = new ComboBox<>(prevProgressions);

	//Buttons
	Button saveBtn = new Button("Save");
	Button LoadLastBtn = new Button("Last Record");
	Button recBtn = new Button("Recommended Progression");
	Button helpBtn = new Button("User Information");
	Button songStructBtn = new Button("Song Structure");
	
	helpBtn.setPrefWidth(300);
	helpBtn.setPrefHeight(60);
	saveBtn.setOnAction(e -> {
		model.saveProgression();
	});
	
	LoadLastBtn.setOnAction(e -> {
	    model.loadProgression(); // Load the previous progression

	    // Assuming your model has a method to get the updated list of progressions:
	    List<Label> updatedProgressions = model.getUpdatedProgressions();

	    // Clear the existing items in the observable list
	    prevProgressions.clear();

	    // Add the updated progressions to the observable list
	    prevProgressions.addAll(updatedProgressions);
	});
	
	recBtn.setOnAction(e -> {
	   openRec();
	});
	
	helpBtn.setOnAction(e -> {
		openManual();
	});
	
	songStructBtn.setOnAction(e ->{
		openSongStructure();
	});
	GridPane gridPane = new GridPane();
	
	int col = 0; // Start from column 0

     // Recommended Labels in a column
	gridPane.setHgap(10);
	gridPane.setVgap(10);
	gridPane.setPadding(new Insets(10, 10, 10, 10));
	
     // Recommended Fields in the next column-for users
    gridPane.add(userLbl, col, 0);
    gridPane.add(userRootLbl, col, 1);
    gridPane.add(userSecondLbl, col, 2);
    gridPane.add(userThirdLbl, col, 3);
    gridPane.add(userFourthLbl, col, 4);
    gridPane.add(userFifthLbl, col, 5);
    gridPane.add(userSixthLbl, col, 6);
    gridPane.add(userSeventhLbl, col, 7);

    col++; // Move to the next column for the user text fields

    // User TextFields in the next column
    gridPane.add(userRootChordTf, col, 1);
    gridPane.add(userSecondTf, col, 2);
    gridPane.add(userThirdTf, col, 3);
    gridPane.add(userFourthTf, col, 4);
    gridPane.add(userFifthTf, col, 5);
    gridPane.add(userSixthTf, col, 6);
    gridPane.add(userSeventhTf, col, 7);
    
    //Panes for the help pane, buttonSection.
    HBox homePane = new HBox(5);
    
    homePane.getChildren().addAll(helpBtn);
    
    VBox buttonSection = new VBox(5);
    buttonSection.setPadding(new Insets(10));
    
    buttonSection.setSpacing(8);
    buttonSection.setAlignment(Pos.CENTER);
    buttonSection.setStyle("-fx-background-color: #5C5CFF;");
    buttonSection.getChildren().addAll(saveBtn, LoadLastBtn, cbo, recBtn, songStructBtn);
    
    //The scene building here
	borderPane.setLeft(buttonSection);
	borderPane.setCenter(gridPane);
	borderPane.setRight(homePane);
    gridPane.setAlignment(Pos.CENTER);
	scene = new Scene(borderPane, 1000, 400);
	
	}

	public Scene getScene() {
		// TODO Auto-generated method stub
		return scene;
	}
	
	public void openRec() {
		recView.show();
	}
	
	public void openManual() {
		userInfo.show();
	}
	
	public void openSongStructure() {
		songStruct.show();
	}
	public Label[] generateLabels(Label list[], int n) {
	    Label[] newArr = new Label[n + 1];
	    //replace this with the real number of progressions saved
	    for (int i = 1; i <= list.length; i++) {
	        Label addLabel = new Label("Prog #" + i);
	        newArr[i] = addLabel;
	        if (newArr[i] != null) {
	            newArr[i].setStyle("-fx-font-size: 12pt; -fx-text-fill: black;");
	        }
	    }

	    return newArr;
	}
	
}
