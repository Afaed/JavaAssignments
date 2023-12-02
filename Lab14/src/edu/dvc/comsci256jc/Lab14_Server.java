package edu.dvc.comsci256jc;

import java.awt.TextArea;
import java.net.ServerSocket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Lab14_Server extends Application{
	ServerSocket serverSocket;
	@Override
	
	public void start(Stage primaryStage) {
		TextArea ta = new TextArea();
		Scene scene = new Scene(new ScrollPane(), 450, 250);
		primaryStage.setTitle("Lab_14 Server");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new Thread(() -> {
			
			serverSocket = new ServerSocket(8000);
			Platform.runLater(() ->{
				ta.append("Server started at "  + new Date() + '\n');
			});
		});
	}
}
