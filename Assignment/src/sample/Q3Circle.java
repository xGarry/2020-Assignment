package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Point2D;
import java.util.Random;

public class Q3Circle extends Application {
    //Circle that will determine path of the points
    private double r = 100.0;  //radius
    private Circle c = new Circle(250, 250, r);

    Random rand = new Random();
    //Random starting positions for the 3 points
    private int theta1 = rand.nextInt(360);
    private int theta2 = rand.nextInt(360);
    private int theta3 = rand.nextInt(360);
    private double x1 = 250 + r*Math.cos(theta1);
    private double y1 = 250 + r*Math.sin(theta1);
    private double x2 = 250 + r*Math.cos(theta2);
    private double y2 = 250 + r*Math.sin(theta2);
    private double x3 = 250 + r*Math.cos(theta3);
    private double y3 = 250 + r*Math.sin(theta3);

    //Making the points
    private double pointRadius = 10.0;
    private Circle[] circle = {new Circle(x1, y1, pointRadius), new Circle(x2, y2, pointRadius), new Circle(x3, y3, pointRadius)};

    //Lines connecting the three points
    private Line line1 = new Line();
    private Line line2 = new Line();
    private Line line3 = new Line();
    private Text[] text = {new Text(), new Text(), new Text()};


    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setResizable(false);

        //set properties of main circle
        c.setFill(null);
        c.setStroke(Color.BLACK);

        //set properties of the 3 points
        circle[0].setFill(Color.BLUE);
        circle[1].setFill(Color.RED);
        circle[2].setFill(Color.GREEN);
        
        //Keep points on circle while they are dragged, and update their positions and angles
        circle[0].setOnMouseDragged((MouseEvent me) -> {
            if (circle[0].contains(me.getX(), me.getY())) {
                Point2D redCenter = new Point2D(c.getCenterX(), c.getCenterY());
                Point2D mouse = new Point2D(me.getX(), me.getY());
                Point2D centerToMouse = mouse.subtract(redCenter);
                Point2D centerToNewPoint = centerToMouse.normalize().multiply(c.getRadius());
                Point2D newPoint = centerToNewPoint.add(redCenter);
                circle[0].setCenterX(newPoint.getX());
                circle[0].setCenterY(newPoint.getY());
                updateLines();
            }
        });

        circle[1].setOnMouseDragged((MouseEvent me) -> {
            if (circle[1].contains(me.getX(), me.getY())) {
                Point2D redCenter = new Point2D(c.getCenterX(), c.getCenterY());
                Point2D mouse = new Point2D(me.getX(), me.getY());
                Point2D centerToMouse = mouse.subtract(redCenter);
                Point2D centerToNewPoint = centerToMouse.normalize().multiply(c.getRadius());
                Point2D newPoint = centerToNewPoint.add(redCenter);
                circle[1].setCenterX(newPoint.getX());
                circle[1].setCenterY(newPoint.getY());
                updateLines();
            }
        });

        circle[2].setOnMouseDragged((MouseEvent me) -> {
            if (circle[2].contains(me.getX(), me.getY())) {
                Point2D redCenter = new Point2D(c.getCenterX(), c.getCenterY());
                Point2D mouse = new Point2D(me.getX(), me.getY());
                Point2D centerToMouse = mouse.subtract(redCenter);
                Point2D centerToNewPoint = centerToMouse.normalize().multiply(c.getRadius());
                Point2D newPoint = centerToNewPoint.add(redCenter);
                circle[2].setCenterX(newPoint.getX());
                circle[2].setCenterY(newPoint.getY());
                updateLines();
            }
        });
        
        pane.getChildren().addAll(c, circle[0], circle[1], circle[2], line1, line2, line3, text[0], text[1], text[2]);
        primaryStage.setTitle("Question 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Updates the angles and line positions
    private void updateLines() {
        //Find starting and ending positions of all lines
        line1.setStartX(circle[0].getCenterX());
        line1.setStartY(circle[0].getCenterY());
        line1.setEndX(circle[1].getCenterX());
        line1.setEndY(circle[1].getCenterY());
        line2.setStartX(circle[0].getCenterX());
        line2.setStartY(circle[0].getCenterY());
        line2.setEndX(circle[2].getCenterX());
        line2.setEndY(circle[2].getCenterY());
        line3.setStartX(circle[1].getCenterX());
        line3.setStartY(circle[1].getCenterY());
        line3.setEndX(circle[2].getCenterX());
        line3.setEndY(circle[2].getCenterY());

        //Update angles
        double x = new Point2D(circle[2].getCenterX(), circle[2].getCenterY()).
                distance(circle[1].getCenterX(), circle[1].getCenterY());
        double y = new Point2D(circle[2].getCenterX(), circle[2].getCenterY()).
                distance(circle[0].getCenterX(), circle[0].getCenterY());
        double z = new Point2D(circle[1].getCenterX(), circle[1].getCenterY()).
                distance(circle[0].getCenterX(), circle[0].getCenterY());
        double[] angle = new double[3];
        
        angle[0] = Math.acos((x * x - y * y - z * z) / (-2 * y * z));
        angle[1] = Math.acos((y * y - x * x - z * z) / (-2 * x * z));
        angle[2] = Math.acos((z * z - y * y - x * x) / (-2 * x * y));

        //Update text positions
        for (int i = 0; i < 3; i++) {
            text[i].setX(circle[i].getCenterX());
            text[i].setY(circle[i].getCenterY());
            text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
