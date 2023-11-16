package edu.dvccomsci256jc;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RecomendationView extends Stage implements viewInterface{
	Scene scene;
	public RecomendationView() {
		
		//User fields and labels.
		rootChordTf.setEditable(false);
		secondTf.setEditable(false);
		thirdTf.setEditable(false);
		fourthTf.setEditable(false);
		fifthTf.setEditable(false);
		sixthTf.setEditable(false);
		seventhTf.setEditable(false);
		
		GridPane gridPane =  new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		
		int col = 0;
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		
	    gridPane.add(recLbl, col, 0);
	    gridPane.add(recRootLbl, col, 1);
	    gridPane.add(recSecondLbl, col, 2);
	    gridPane.add(recThirdLbl, col, 3);
	    gridPane.add(recFourthLbl, col, 4);
	    gridPane.add(recFifthLbl, col, 5);
	    gridPane.add(recSixthLbl, col, 6);
	    gridPane.add(recSeventhLbl, col, 7);

	    col++; // Move to the next column for the fields

	    // Recommended TextFields in the next column
	    gridPane.add(rootChordTf, col, 1);
	    gridPane.add(secondTf, col, 2);
	    gridPane.add(thirdTf, col, 3);
	    gridPane.add(fourthTf, col, 4);
	    gridPane.add(fifthTf, col, 5);
	    gridPane.add(sixthTf, col, 6);
	    gridPane.add(seventhTf, col, 7);
	    
	    scene = new Scene(gridPane, 200, 400);
	    setTitle("Recommended Chords");
	    setScene(scene);
	}
	
}
