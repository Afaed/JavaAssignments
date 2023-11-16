/**
 * 
 */
/**
 * 
 */
module LabExercise6_1 {
	requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    
	
	opens dvc.educomsc256jc to javafx.graphics, javafx.fxml;
}