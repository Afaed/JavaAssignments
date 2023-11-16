/**
 * 
 */
/**
 * 
 */
module testJavaFX{
	
	requires javafx.controls;
	requires javafx.base;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    
	
	opens testJavaFX to javafx.graphics, javafx.fxml;
}