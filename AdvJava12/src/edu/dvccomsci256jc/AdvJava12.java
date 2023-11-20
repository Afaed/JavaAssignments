/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package edu.dvccomsci256jc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdvJava12 extends Application {

	 @Override
	    public void start(Stage primaryStage) {

	        PieChart pieChart = new PieChart();
	        CategoryAxis xAxis = new CategoryAxis();       
	        NumberAxis yAxis = new NumberAxis(); 
	        
	        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
	        pieChart.setTitle("Class Pie Chart");
	        xAxis.setLabel("Department");  
	        yAxis.setLabel("Persons");
	        Series<String, Number> series = new XYChart.Series<>();
	        
	        try {
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabook", "root", "Test1234!");
	            Statement statement = connection.createStatement();
	            ResultSet results = statement.executeQuery("select deptId, count(*) as count from Student where deptId is not null group by deptId;");

	            	while (results.next()) {
		                String category = results.getString("deptId");
		                Number count = (Number) results.getInt("count");
		                pieChart.getData().add(new PieChart.Data(category, (int) count));
		                series.getData().add(new XYChart.Data<>(category, count));
		                series.setName("Class Bar Chart");
		            }
	        	} catch (SQLException e) {
	            e.printStackTrace();
	        }

	        barChart.getData().add(series);

	        BorderPane root = new BorderPane();
	        root.setLeft(pieChart);
	        root.setRight(barChart);

	        Scene scene = new Scene(root, 1000, 900);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Assignment 12");
	        primaryStage.show();
	    }

    public static void main(String[] args) {
        launch(args);
    }
}

