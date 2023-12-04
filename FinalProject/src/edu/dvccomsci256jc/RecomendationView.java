package edu.dvccomsci256jc;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RecomendationView extends Stage implements viewInterface{
	Scene scene;
	Chords chord;
	String key;
	public RecomendationView(String userRoot) {
		key = userRoot;
	}
	public RecomendationView() {
		 generateProg();
		//User fields and labels.
		rootChordTf.setEditable(false);
		secondTf.setEditable(false);
		thirdTf.setEditable(false);
		fourthTf.setEditable(false);
		fifthTf.setEditable(false);
		sixthTf.setEditable(false);
		seventhTf.setEditable(false);
		
		rootChordTf.setText(key);
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
	
	public void generateProg() {
		Chords chord = new Chords(key);
		ArrayList<String> prog = chord.generateChordProg();
		if (prog.size() >= 7) {
            rootChordTf.setText(prog.get(0));
            secondTf.setText(prog.get(1));
            thirdTf.setText(prog.get(2));
            fourthTf.setText(prog.get(3));
            fifthTf.setText(prog.get(4));
            sixthTf.setText(prog.get(5));
            seventhTf.setText(prog.get(6));
        } else {
        	FinalModel m = new FinalModel();
        	m.displayErrorMessage("Not enough chords in progression");
        }
    }
}
