package edu.dvccomsci256;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JPasswordField;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class LabExercise12_2 extends Application {
	BorderPane root = new BorderPane();
	GridPane grid = new GridPane();
	TextField usernameTf = new TextField();
	PasswordField passwordTf = new PasswordField();
	Label usernameLbl = new Label("User Name ");
	Label passwordLbl = new Label("Password ");
	Label databaseLbl = new Label("Database URL ");
	Button connectBtn = new Button("Connect to database");
	Label outputLbl;
	private ComboBox<String> urlBox;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			usernameTf.setEditable(true);
			passwordTf.setEditable(true);
			
			urlBox = new ComboBox<>();
			urlBox.getItems().addAll(
		            "jdbc:mysql://tigerking/dummydb1",
		            "jdbc:mysql://strawhatpirates/db2",
		            "jdbc:mysql://localhost:3306/javabook"
					);
			grid.setPadding(new Insets(5, 5, 5, 5));
			grid.setVgap(5);
			grid.add(databaseLbl, 0, 0);
			grid.add(urlBox, 1,	0);
			grid.add(usernameLbl, 0, 1);
			grid.add(usernameTf, 1, 1);
			grid.add(passwordLbl, 0, 2);
			grid.add(passwordTf, 1, 2);
			grid.add(connectBtn, 1, 3);
			
			outputLbl = new Label(); // Initialize outputTextArea
			
			root.setBottom(outputLbl);
			connectBtn.setOnAction(e -> connectToDatabase());
			root.setCenter(grid);
			BorderPane.setAlignment(outputLbl, Pos.CENTER);
			Scene scene = new Scene(root, 500, 150);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Lab Exercise 12-2");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void connectToDatabase() {
		// TODO Auto-generated method stub
		String url = urlBox.getValue();
		String username = usernameTf.getText();
		String password = passwordTf.getText();
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			outputLbl.setText("Connected to " + url);
			connection.close();
		} catch (SQLException e) {
			 outputLbl.setText("DB not connected \n"); 
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
