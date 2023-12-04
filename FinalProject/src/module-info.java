module FinalProject {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	
	opens edu.dvccomsci256jc to javafx.graphics, javafx.fxml;
}
