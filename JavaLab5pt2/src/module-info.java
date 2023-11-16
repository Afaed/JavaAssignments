module JavaLab5pt2 {
	requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    
	
	opens application to javafx.graphics, javafx.fxml;
}
