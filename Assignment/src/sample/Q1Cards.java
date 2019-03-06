import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Q1Cards extends Application {
  
  public HBox pane = new HBox();
  String source = "file:/home/hanan/Desktop/Assignment1- CSCI2020U/Cards/"; // destination to the images
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    
    Random rand = new Random();

    for(int i=0;i<=2;i++){
      pane.setAlignment(Pos.CENTER); // positioning to the center 

      int n = rand.nextInt(59);
      if(n<55){
        String end = n + ".png"; 
        imageFix(end);
      }
      if(n==55){
        String end = "b1fh.png";
        imageFix(end);
      }
      if(n==56){
        String end = "b2fh.png";
        imageFix(end);
      }
      if(n==57){
        String end = "b2fv.png";
        imageFix(end);
      }
      if(n==58){
        String end = "backcard.png";
        imageFix(end);
      }
    }

    Scene scene = new Scene(pane,300,100); // Create a scene and place it in the stage
    primaryStage.setTitle("Cards"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  public void imageFix (String ending){
    String finalo = source + ending; // adding the entension with the destination
    ImageView imageView = new ImageView(finalo); // making a new image view
    pane.getChildren().add(imageView); // adding the image view to the pane 
    pane.setSpacing(10); // spacing between each imageview

  }

  public static void main(String[] args) {
    launch(args);
  }
} 
