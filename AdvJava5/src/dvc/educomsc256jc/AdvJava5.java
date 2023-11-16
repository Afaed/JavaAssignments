
/*
 * Justin Choy
 * Student ID: 1731686 
 * */
package dvc.educomsc256jc;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class AdvJava5 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hangman");

        Pane pane = new Pane();

        Line gallows = new Line(100, 10, 100, 250);
        Line horizontalBeam = new Line(100, 10, 200, 10);

        Line verticalBeam = new Line(200, 10, 200, 50);

        Path curvedLine = new Path();
        curvedLine.setStroke(Color.BLACK);
        curvedLine.setStrokeWidth(2);

        MoveTo moveTo = new MoveTo(200, 50);
        CubicCurveTo cubicCurveTo = new CubicCurveTo(100, 200, 300, 200, 200, 250);
        curvedLine.getElements().addAll(moveTo, cubicCurveTo);

        Circle head = new Circle(200, 75, 25);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);

        Line body = new Line(200, 100, 200, 175);
        body.setStroke(Color.GREEN);

        Line leftArm = new Line(100, 250, 160, 200);
        Line rightArm = new Line(200, 250, 240, 200);

        Line leftLeg = new Line(200, 175, 160, 200);
        Line rightLeg = new Line(200, 175, 240, 200);

        pane.getChildren().addAll(gallows, horizontalBeam, verticalBeam, curvedLine, head, body, leftArm, rightArm, leftLeg, rightLeg);

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
