package javafxtestProj;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FanApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Fan fan = new Fan();

        Pane pane = new Pane();
        pane.getChildren().addAll(fan);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Fan Display");
        primaryStage.setScene(scene);
        primaryStage.show();

        fan.playAnimation();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Fan extends Pane {
    private Circle baseCircle;
    private Arc[] blades;
    private double bladeAngle;

    public Fan() {
        baseCircle = new Circle(200, 200, 100, Color.WHITE);
        baseCircle.setStroke(Color.BLACK);

        blades = new Arc[4];
        bladeAngle = 0;

        for (int i = 0; i < 4; i++) {
            blades[i] = new Arc(200, 200, 80, 80, bladeAngle, 30);
            blades[i].setType(ArcType.ROUND);
            blades[i].setFill(Color.RED);
            blades[i].setStroke(Color.RED);
            bladeAngle += 90;
        }
        getChildren().addAll(baseCircle);
        getChildren().addAll(blades);
    }

    public void playAnimation() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), e -> rotateBlades()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void rotateBlades() {
        for (Arc blade : blades) {
            blade.setStartAngle(blade.getStartAngle() + 1);
        }
    }
}