import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import java.lang.Math; 

public class Q2Calculator extends Application {
    private TextField InvestAmount = new TextField(); // four fields
    private TextField Year = new TextField();
    private TextField AnnualRate = new TextField();
    private TextField result = new TextField();

  public void start(Stage primaryStage) {
    // Create a pane and set its properties
    GridPane pane = new GridPane();
    
    InvestAmount.setAlignment(Pos.CENTER_RIGHT); // setting the alignment of textfield to the right
    Year.setAlignment(Pos.CENTER_RIGHT);
    AnnualRate.setAlignment(Pos.CENTER_RIGHT);
    result.setAlignment(Pos.CENTER_RIGHT);

    Label label1 = new Label("Investment Amount");
    Label label2 = new Label("Years");
    Label label3 = new Label("Annual Interest Rate");
    Label label4 = new Label("Future Value");

    label1.setStyle("-fx-font-weight: bold;"); // making the label bold
    label2.setStyle("-fx-font-weight: bold;");
    label3.setStyle("-fx-font-weight: bold;");
    label4.setStyle("-fx-font-weight: bold;");
    result.setEditable(false);

    pane.add(label1, 1, 0); // adding labels 
    pane.add(label2, 1, 1); 
    pane.add(label3, 1, 2);
    pane.add(label4,1,3);

    Button calculate = new Button("Calculate"); // new button 
    pane.add(calculate, 2,4);
    pane.setHalignment(calculate, HPos.RIGHT);

    calculate.setOnAction(e -> futureValue()); // when the calculate button is pressed, it will output the future value on to the screen

    pane.add(InvestAmount, 2, 0); // adding textfields
    pane.add(Year, 2, 1); 
    pane.add(AnnualRate, 2, 2);
    pane.add(result, 2,3);

    pane.setPadding(new Insets(1, 1, 1, 1));
    pane.setHgap(5); //vertical spacing
    pane.setVgap(5); //horizontal spacing 


    Scene scene = new Scene(pane, 350, 165); // Create a scene and place it in the stage
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
    private void futureValue() {
        double investmentAmount = Double.parseDouble(InvestAmount.getText()); // gettting the input from textfield and converting it to double
        int years = Integer.parseInt(Year.getText()); // gettting the input from textfield and converting it to integer
        double monthlyInterestRate = Double.parseDouble(AnnualRate.getText()) / 1200;
        result.setText(String.format("$%.2f", (investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12)))); // calculating the future value with equation
    }
  public static void main(String[] args) {
    launch(args); // lauching the program 
  }
}
