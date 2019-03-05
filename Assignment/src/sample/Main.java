package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Main extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        //generate random number between 1 and 54
        Random rand = new Random();
        int x = rand.nextInt(54) + 1;
        int y = rand.nextInt(54) + 1;
        int z = rand.nextInt(54) + 1;

        pane.setPadding(new Insets(5, 5, 5, 5));

        //import images
        Image card1 = new Image("file:///C:/Users/Garry/Downloads/Cards/" + x + ".png");
        Image card2 = new Image("file:///C:/Users/Garry/Downloads/Cards/" + y + ".png");
        Image card3 = new Image("file:///C:/Users/Garry/Downloads/Cards/" + z + ".png");

        //add images to pane
        pane.add(new ImageView(card1),0,0);
        pane.add(new ImageView(card2),1,0);
        pane.add(new ImageView(card3),2,0);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane,250,250);
        primaryStage.setTitle("ShowGridPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
