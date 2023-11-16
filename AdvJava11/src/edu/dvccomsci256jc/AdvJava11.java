/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256jc;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class AdvJava11 extends Application {
	private static final int Boy_Names = 1;
	private static final int Girl_Names = 3;
	static String [] gender = {"Male" , "Female"};
	static String [] years = {"2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"};
	TextField nameTf = new TextField();
	static ObservableList<String> genderOptions = FXCollections.observableArrayList(gender);
	static ComboBox<String> genderBox = new ComboBox<String>(genderOptions);
	static ObservableList<String> yearOptions = FXCollections.observableArrayList(years);
	Label resultsLbl = new Label();
	ComboBox<String> yearBox = new ComboBox<String>(yearOptions);
	@SuppressWarnings("rawtypes")
	Map [] boys = getNames(Boy_Names);
	@SuppressWarnings("rawtypes")
	Map [] girls = getNames(Girl_Names);
	
	@Override
	public void start(Stage primaryStage) {

	    BorderPane root = new BorderPane();
	    Scene scene = new Scene(root, 300, 160);

	    GridPane grid = new GridPane();
	    grid.setVgap(2);
	    grid.setHgap(10);
	    Label yearLbl = new Label("Select Year: ");
	    Label genderLbl = new Label("Boy or Girl");
	    Label nameLbl = new Label("Enter a name: ");
	    Button rankBtn = new Button("Find Ranking");  
	    
		grid.setPadding(new Insets(5, 0, 5, 0));
	    grid.setAlignment(Pos.CENTER);
	    grid.add(yearLbl, 0, 0);
	    grid.add(yearBox, 1, 0);
	    grid.add(genderLbl, 0, 1);
	    grid.add(genderBox, 1, 1);
	    grid.add(nameLbl, 0, 2);
	    grid.add(nameTf, 1, 2);
	    grid.add(rankBtn, 1, 3);
	    
	    // Add the button to the bottom of the BorderPane
	    root.setBottom(resultsLbl);
	    root.setCenter(grid);
	    
	    BorderPane.setAlignment(resultsLbl, Pos.CENTER);
	    
	    rankBtn.setOnAction(e -> displayRank());
	    
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Advanced Java 11");
	    primaryStage.show();
	}
	
	@SuppressWarnings("rawtypes")
	private Map[] getNames(int gender) {
		// TODO Auto-generated method stub
		Map[] mapArray = new Map[10];
		for (int year = 2001, i = 0; year <= 2010 && i < 10; year++, i++) {
			Map<String, String> map = new HashMap<>();
			try {
				//Note you will need to replace the file name with your own directory
				File file = new File("/Users/macbook/Documents/JavaAssignments-main/AdvJava11/bin/babynamesranking" + year + ".txt");
				@SuppressWarnings("resource")
				Scanner input = new Scanner(file);
				if(file.exists()) {
					while(input.hasNext()) {
						ArrayList<String> list = new ArrayList<>();
						for (int j = 0; j < 5; j++) {
							list.add(j, input.next());
						}
						map.put(list.get(gender), list.get(0));
					}
				}
			} catch(FileNotFoundException ex) {
				displayErrorMessage("File not found");
			}
			mapArray[i] = map;
		}
		return mapArray;
	}

	private void displayRank() {
		
		resultsLbl.setText(getGender() + " name " 
			+ nameTf.getText() + "" + getRank()
			+ " in year " + yearBox.getValue());
	}
	

	private String getRank() {
	    int year = Integer.parseInt(yearBox.getValue());

	    if (genderBox.getValue().equals("Male")) {
	        @SuppressWarnings("unchecked")
			Map<String, String> boysMap = boys[year - 2001];
	        String name = nameTf.getText();
	        if (boysMap != null && boysMap.containsKey(name)) {
	            return " is ranked # " + boysMap.get(name);
	        } else {
	        	return " is not ranked ";
	        }
	    } else {
	        @SuppressWarnings("unchecked")
			Map<String, String> girlsMap = girls[year - 2001];
	        String name = nameTf.getText();
	        if (girlsMap != null && girlsMap.containsKey(name)) {
	            return " is raned #" + girlsMap.get(name);
	        } else {
	        	return " is not ranked ";
	        	}
	    }
	}


	private static String getGender() {
		return genderBox.getValue().equals("Male") ? "Boys": "Girls";
	}

	void displayErrorMessage(String errorMessage){
		new Alert(Alert.AlertType.ERROR, errorMessage).showAndWait();
		}
	public static void main(String[] args) {
		launch(args);
	}
}
