package testJavaFX;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class MusicAlbumPane extends BorderPane{
	
    Button addBtn = new Button("Add");
    Button firstBtn = new Button("First");
    Button lastBtn = new Button("Last");
    Button nextBtn = new Button("Next");
    Button previousBtn = new Button("Previous");
    Button updateBtn = new Button("Update");
    Button clearBtn = new Button("Clear");

    TextField tfAlbumName = new TextField();
    TextField tfArtistName = new TextField();
    TextField tfFormatType = new TextField();
    TextField tfNumberOfTracks = new TextField();
    TextField tfDuration = new TextField();
    TextField tfYear = new TextField();

    Label albumLabel = new Label("Album");
    Label artistLabel = new Label("Artist");
    Label formatLabel = new Label("Format");
    Label trackLabel = new Label("Tracks");
    Label durationLabel = new Label("Length");
    Label yearLabel = new Label("Year");

    HBox buttonBox = new HBox(5);
    FlowPane mainPane = new FlowPane(5, 5);
	
    public MusicAlbumPane(){
		drawAlbumPane();
	}
	    // All of our buttons
    public void drawAlbumPane() {
        tfAlbumName.setPrefColumnCount(32);
        tfArtistName.setPrefColumnCount(32);
        tfFormatType.setPrefColumnCount(8);
        tfDuration.setPrefColumnCount(6);
        tfYear.setPrefColumnCount(3);

        buttonBox.getChildren().addAll(addBtn, firstBtn, nextBtn, previousBtn, lastBtn, updateBtn, clearBtn);
        buttonBox.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(albumLabel, 0, 0);
        gridPane.add(tfAlbumName, 1, 0);

        gridPane.add(artistLabel, 0, 1);
        gridPane.add(tfArtistName, 1, 1);

        gridPane.add(formatLabel, 2, 1);
        gridPane.add(tfFormatType, 3, 1);
        
        gridPane.add(trackLabel, 0, 2);

        HBox tracksSection = new HBox(5); // Create an HBox for tracks section
        tracksSection.getChildren().addAll(tfNumberOfTracks, durationLabel, tfDuration, yearLabel, tfYear);
        tfNumberOfTracks.setMaxWidth(35);
        gridPane.add(tracksSection, 1, 2, 4, 1); // Span multiple columns

        // Align the "tfNumberOfTracks" text field to the left
        GridPane.setHalignment(tfNumberOfTracks, HPos.LEFT);

        mainPane.setPadding(new Insets(10, 10, 0, 10));
        mainPane.getChildren().addAll(gridPane);

        setCenter(mainPane);
        setBottom(buttonBox);
    }


}

