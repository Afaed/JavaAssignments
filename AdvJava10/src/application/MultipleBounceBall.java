package application;

import java.util.ArrayList;
import java.util.Collections;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Comparator;
import java.util.Random;

public class MultipleBounceBall extends Application {
	@Override
	public void start(Stage primaryStage) {
		MultipleBallPane ballPane = new MultipleBallPane();
		ballPane.setStyle("-fx-border-color: yellow");
		
		Button btAdd = new Button("+");
		Button btSubtract = new Button("-");
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(btAdd, btSubtract);
		hBox.setAlignment(Pos.CENTER);
		
		// Add or remove a ball
		btAdd.setOnAction(e -> ballPane.add());
		btSubtract.setOnAction(e -> ballPane.subtract());
		
		//Pause and resume animation
		ballPane.setOnMousePressed(e -> ballPane.pause());
		ballPane.setOnMouseReleased(e -> ballPane.play());
		
		//Use a scroll bar to control animation speed
		ScrollBar sbSpeed = new ScrollBar();
		sbSpeed.setMax(20);
		sbSpeed.setValue(10);
		ballPane.rateProperty().bind(sbSpeed.valueProperty());
		
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);
		pane.setTop(sbSpeed);
		pane.setBottom(hBox);
		
		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setTitle("MultipleBounceBall");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	class BallRadiusComparator implements Comparator<MultipleBounceBall.Ball>{

		@Override
		public int compare(MultipleBounceBall.Ball o1, MultipleBounceBall.Ball o2) {
			// TODO
			return Double.compare(o1.getRadius(), o2.getRadius());
		}
		
		
	}
	private class MultipleBallPane extends Pane {
		private Timeline animation;
		
		public MultipleBallPane() {
			// create an animation for moving the ball
			animation = new Timeline(
					new KeyFrame(Duration.millis(50), e -> moveBall()));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		}
		
		public void add() {
			Random random = new Random();
			int low = 2;
			int high = 20;
			int value = random.nextInt(high - low) + low;
			Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
			getChildren().add(new Ball(30, 30, value, color));
		}
		
		public void subtract() {
			if (getChildren().size() > 0) {
				
				@SuppressWarnings({ "rawtypes", "unchecked" })
				ArrayList<Node> nodes = new ArrayList(getChildren());
				@SuppressWarnings({ "rawtypes", "unchecked" })
				ArrayList<Ball> balls = new ArrayList(nodes);
				
					if(!balls.isEmpty()) {
						Ball largestBall = Collections.max(balls, new BallRadiusComparator());
						getChildren().remove(largestBall);
				}
			}
		}
		
		public void play() {
			animation.play();
		}
		
		public void pause() {
			animation.pause();
		}
		
		public DoubleProperty rateProperty() {
			return animation.rateProperty();
		}
		
		protected void moveBall() {
			for (Node node: this.getChildren()) {
				Ball ball = (Ball) node;
				//check boundaries
				if (ball.getCenterX() < ball.getRadius() || 
					ball.getCenterX() > getWidth() - ball.getRadius()) {
					ball.dx *= -1;
				}
				if (ball.getCenterY() < ball.getRadius() ||
						ball.getCenterY() > getHeight() - ball.getRadius()) {
					ball.dy *= -1;
				}
				
				//Adjust ball position
				ball.setCenterX(ball.dx + ball.getCenterX());
				ball.setCenterY(ball.dy + ball.getCenterY());
			}
		}
	}
	
	class Ball extends Circle {
		private double dx = 1, dy = 1;
		
		Ball(double x, double y, double radius, Color color) {
			super(x, y, radius);
			setFill(color);
		}
	}

	public static void main(String[] args) {
        Application.launch(args);
    }
}
