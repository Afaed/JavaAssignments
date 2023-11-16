/**
 * 
 */
/**
 * 
 */
module Main{
	
	requires javafx.controls;
	requires javafx.base;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    
	
	opens javafxtestProj to javafx.graphics, javafx.fxml;
}