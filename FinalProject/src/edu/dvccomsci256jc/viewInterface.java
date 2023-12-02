package edu.dvccomsci256jc;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public interface viewInterface {
	Label recLbl = new Label("Reccomended: ");
	Label recRootLbl = new Label("Key: ");
	Label recSecondLbl = new Label("II: ");
	Label recThirdLbl = new Label("III: ");
	Label recFourthLbl = new Label("IV: ");
	Label recFifthLbl = new Label("V: ");
	Label recSixthLbl = new Label("VI: ");
	Label recSeventhLbl = new Label("VII: ");
	
	TextField rootChordTf = new TextField();
	TextField secondTf = new TextField();
	TextField thirdTf = new TextField();
	TextField fourthTf = new TextField();
	TextField fifthTf = new TextField();
	TextField sixthTf = new TextField();
	TextField seventhTf = new TextField();;
	
	Label userLbl = new Label("Your Progression");
	
	Label userRootLbl = new Label("Key: ");
	Label userSecondLbl = new Label("II: ");
	Label userThirdLbl = new Label("III: ");
	Label userFourthLbl = new Label("IV: ");
	Label userFifthLbl = new Label("V: ");
	Label userSixthLbl = new Label("VI: ");
	Label userSeventhLbl = new Label("VII: ");
	
	TextField userRootChordTf = new TextField();
	TextField userSecondTf = new TextField();
	TextField userThirdTf = new TextField();
	TextField userFourthTf = new TextField();
	TextField userFifthTf = new TextField();
	TextField userSixthTf = new TextField();
	TextField userSeventhTf = new TextField();
	
	
}
