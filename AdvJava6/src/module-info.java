/*
 * Justin Choy
 * Student ID: 1731686 
 * */

module AdvJava6 {
	requires javafx.controls;
	requires javafx.base;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    
	
	opens dvc.educomsci256jc to javafx.graphics, javafx.fxml;
}
