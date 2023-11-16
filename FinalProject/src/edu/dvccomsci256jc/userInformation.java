package edu.dvccomsci256jc;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class userInformation extends Stage implements viewInterface {
	Scene scene;
	public userInformation () {
		BorderPane manual = new BorderPane();
		ScrollBar scroll = new ScrollBar();
		TextArea information = new TextArea();
		
		information.setText(write());
		information.setEditable(false);
		manual.setPrefHeight(600);
		
		manual.getChildren().addAll(information);
		manual.setAlignment(information, Pos.CENTER);
		scene = new Scene(manual, 600, 500);
		setScene(scene);
		setTitle("User information guide");
	}
	
	public String write() {
		String guide = ""
				+ "This is the music making information guide.\n"
				+ "User specific information:\n"
				+ "/nHow to save your progression:\n"
				+ "To save a progression you have made, press the \"save button\".\n"
				+ "If you weant to navigate to a previous progression, use the combo box to access a specific progression.\n"
				+ "If you want to access one Porgression and only one-just press the \"Last Record\" Button";
		return guide;
	}
}
