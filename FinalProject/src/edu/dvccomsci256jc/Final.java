package edu.dvccomsci256jc;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Final extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FinalView view = new FinalView();
			
			primaryStage.setScene(view.getScene());
			primaryStage.show();
			primaryStage.setTitle("Pleasantries");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
