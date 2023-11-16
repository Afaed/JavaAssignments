/*
 * Justin Choy
 * Student ID: 1731686 
	*
 * */
package edu.dvccomsci256jc;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Lab_Exercise_7_2 extends Application {
    private String[] countries = {"United States", "China", "Canada", "Mexico", "India"};

    String x = " ";

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();

            ComboBox<String> cbo = new ComboBox<>();
            cbo.getItems().addAll("SINGLE", "MULTIPLE");
            cbo.getSelectionModel().selectFirst();
            Label info = new Label("Selection Mode: ");
            Label selectionLabel = new Label("Selected items are ");

            BorderPane selectionBox = new BorderPane();
            selectionBox.setLeft(info);
            selectionBox.setCenter(cbo);
            root.setTop(selectionBox);

            VBox box = new VBox();

            ListView<String> lv = new ListView<>();
            lv.getItems().addAll(countries);

            cbo.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                if (newValue.equals("MULTIPLE")) {
                    lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                } else if (newValue.equals("SINGLE")) {
                    lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                }
                updateSelectionLabel(lv, selectionLabel);
            });

            lv.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                updateSelectionLabel(lv, selectionLabel);
            });

            box.getChildren().addAll(lv, selectionLabel);
            root.setCenter(box);
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setTitle("Lab Exercise 7-2");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateSelectionLabel(ListView<String> lv, Label selectionLabel) {
        ObservableList<String> selectedItems = lv.getSelectionModel().getSelectedItems();
        StringBuilder selectedText = new StringBuilder("Selected items are");
        for (String s : selectedItems) {
            selectedText.append(" ").append(s);
        }
        selectionLabel.setText(selectedText.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
