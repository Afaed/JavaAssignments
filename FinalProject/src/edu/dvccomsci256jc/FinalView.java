package edu.dvccomsci256jc;

import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class FinalView implements viewInterface{
	
	private Scene scene;
	BorderPane borderPane = new BorderPane();
	StackPane stack = new StackPane();
	
	private int pos = 0;
	FinalModel model = new FinalModel();
	RecomendationView recView = new RecomendationView("");
	SongStructure songStruct = new SongStructure();
	
	public FinalView() {

	//Buttons
	Button saveBtn = new Button("Save");
	Button LoadLastBtn = new Button("Last Record");
	Button recBtn = new Button("Recommended Progression");
	Button nextBtn = new Button("Next Prog");
	Button songStructBtn = new Button("Song Structure");
	Button deleteBtn = new Button("Delete");
	
	nextBtn.setOnAction(e ->{
		 pos++;
         model.next(pos);
         clearTextFields();
	});
	
	saveBtn.setOnAction(e -> {
		model.save();
	});
	
	LoadLastBtn.setOnAction(e -> {
		pos--;
		model.loadLast(pos); // Load the previous progression
	});
	
	recBtn.setOnAction(e -> {
	   openRec();
	});
	
	songStructBtn.setOnAction(e ->{
		openSongStructure();
	});
	
	deleteBtn.setOnAction(e -> {
		model.delete(pos);
		clearTextFields();
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
    String s;
    // User TextFields in the next column
    gridPane.add(userRootChordTf, col, 1);
    gridPane.add(createPlaySoundButton(s = userRootChordTf.getText()), col + 1, 1);
    gridPane.add(userSecondTf, col, 2);
    gridPane.add(createPlaySoundButton(s = userSecondTf.getText()), col + 1, 2);
    gridPane.add(userThirdTf, col, 3);
    gridPane.add(createPlaySoundButton(s = userThirdTf.getText()), col + 1, 3);
    gridPane.add(userFourthTf, col, 4);
    gridPane.add(createPlaySoundButton(s = userFourthTf.getText()), col + 1, 4);
    gridPane.add(userFifthTf, col, 5);
    gridPane.add(createPlaySoundButton(s = userFifthTf.getText()), col + 1, 5);
    gridPane.add(userSixthTf, col, 6);
    gridPane.add(createPlaySoundButton(s = userSixthTf.getText()), col + 1, 6);
    gridPane.add(userSeventhTf, col, 7);
    gridPane.add(createPlaySoundButton(s = userSeventhTf.getText()), col + 1, 7);
    
 
    VBox buttonSection = new VBox(5);
    buttonSection.setPadding(new Insets(10));
    
    buttonSection.setSpacing(8);
    buttonSection.setAlignment(Pos.CENTER);
    buttonSection.setStyle("-fx-background-color: #5C5CFF;");
    buttonSection.getChildren().addAll(saveBtn, nextBtn, LoadLastBtn, deleteBtn, recBtn, songStructBtn);
    
    //The scene building here
	borderPane.setLeft(buttonSection);
	borderPane.setCenter(gridPane);
    gridPane.setAlignment(Pos.CENTER);
	scene = new Scene(borderPane, 1000, 400);
	
	}

	private Button createPlaySoundButton(String chord) {
	    Button playSoundBtn = new Button("Play Sound");
	    playSoundBtn.setOnAction(e -> model.playSound(chord));
	    return playSoundBtn;
	}


	private void clearTextFields() {
		// TODO Auto-generated method stub
		userRootChordTf.clear();
		userSecondTf.clear();
		userThirdTf.clear();
		userFourthTf.clear();
		userFifthTf.clear();
		userSixthTf.clear();
		userSeventhTf.clear();
		
	}

	public Scene getScene() {
		// TODO Auto-generated method stub
		return scene;
	}
	
	public void openRec() {
		String userRootChord = model.getUserRootChord();
        recView = new RecomendationView(userRootChord);
        recView.show();
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
