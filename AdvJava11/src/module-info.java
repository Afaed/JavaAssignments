module AdvJava11 {
	requires javafx.controls;
	requires javafx.base;
	requires javafx.graphics;
	
	opens edu.dvccomsci256jc to javafx.graphics, javafx.fxml;
}
