package edu.dvccomsci256jc;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Fan extends Pane {
    private double position = 0;
    private int direction = -1;
    private Timeline animation;
    private double speed;

    public Fan() {
        displayFan();  // Call the displayFan method to set up the fan

    }

    public void displayFan() {
        double fanRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Circle circle = new Circle(centerX, centerY, fanRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        getChildren().clear();
        getChildren().add(circle);

        double angleIncrement = 360.0 / 4;
        
        for (int i = 0; i < 4; i++) {
            Arc blade = new Arc(centerX, centerY, fanRadius - 5, fanRadius - 5, i * angleIncrement, 30);
            blade.setFill(Color.RED);
            blade.setType(ArcType.ROUND);
            getChildren().add(blade);
        }
      
    }



public void reverse() {
    direction = -direction;
}

double startAngle= 30;

public void move() {
    for (Node node : getChildren()) {
        if (node instanceof Arc) {
            Arc blade = (Arc) node;
            double newStartAngle = blade.getStartAngle() + (direction * speed);
            blade.setStartAngle(newStartAngle);
        }
    }
}

public void setStartAngle(double angle) {
    startAngle = angle;
}

public Timeline getAnimation() {
    
	return animation;
}

public void setAnimation(Fan fan) {
    this.animation = new Timeline(new KeyFrame(Duration.millis(50), e -> {
        fan.move(); // Call the move() method to update the fan position
    }));
    animation.setCycleCount(Timeline.INDEFINITE);
    
    animation.play();
}

public double getPosition() {
return position;
}
public void setPosition(double p) {
position = p;
}
public int getDirection() {
return direction;
}
public void setDirection(int d) {
direction = d;
}
public void increaseSpeed(double speed) {
	this.speed = speed;
}

public double getSpeed() {
	return speed;
}
@Override
public void setWidth(double width) {
super.setWidth(width);

}
@Override
public void setHeight(double height) {
super.setHeight(height);

}
}
