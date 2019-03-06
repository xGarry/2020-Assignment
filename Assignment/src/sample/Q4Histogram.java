package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import java.lang.Math; 
import javafx.scene.shape.Line;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.FileNotFoundException;
import javafx.scene.Node;
import javafx.beans.value.ObservableValue;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class Q4Histogram extends Application
{
	VBox vbox = new VBox();
    HBox hbox = new HBox();
    CategoryAxis xAxis = new CategoryAxis(); // making xAxis
    NumberAxis yAxis = new NumberAxis(); // making yAxis
   	BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);      // Create a BarChart
    XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>(); // making a series in a bar graph
    TextField fileinput = new TextField(); // textfield for the filename;


	char current; 
	int number=0;
	int ascii=65; // used for ascii character

	public void start(Stage primaryStage){

	    Label filename = new Label("Filename ");
	    fileinput.setPrefWidth(680); // setting a prefix size of textfield
	    Button view = new Button("View");
	    hbox.getChildren().addAll(filename,fileinput,view); // adding the label, textfield and button to the pane
	  	
	 
	  	if(fileinput.getText().trim().isEmpty()){ // if the fileinput textfield is empty 
	  		while (ascii <=90){
	  			char c = (char)ascii; // converting number to character
	  			dataSeries1.getData().add(new XYChart.Data<String, Number>(String.valueOf(c), 0)); // making data to plot on the graph 
	  			ascii++;
	  		}
	  	}
	

	  	view.setOnAction(new EventHandler<ActionEvent>() {
      		@Override // Override the handle method
      		public void handle(ActionEvent e) {
        		action();

      		}
    	});
	  	fileinput.setOnKeyPressed(new EventHandler<KeyEvent>() { // if the enter key is pressed in textfield, update the graph
		    @Override
		    public void handle(KeyEvent keyEvent) {
        		if (keyEvent.getCode() == KeyCode.ENTER)  {
            		action();
            	}
    		}
		});
  
		changes(); // visual changes to the graph


	  	barChart.getData().add(dataSeries1); // adding the dataset to the barchart
		vbox.getChildren().add(barChart);    // adding the barchart to vbox pane
		hbox.setAlignment(Pos.CENTER); 
		vbox.getChildren().add(hbox); // adding hbox to vbox pane

	

	    Scene scene = new Scene(vbox, 800, 800); 
	    primaryStage.setScene(scene);
	    primaryStage.setHeight(400);
	    primaryStage.setWidth(800);

	    primaryStage.show();  
	
  }
	public void changes(){
		barChart.setVerticalGridLinesVisible(false); // remove the vertical grid lines 
	    barChart.setHorizontalGridLinesVisible(false); // remove the horizontal grid lines 
	    barChart.getYAxis().setTickLabelsVisible(false); // remove the y tick labels
	    barChart.getYAxis().setOpacity(0); // remove the y line 
	    barChart.setLegendVisible(false); // remove the legend
	}
	public static void main(String args[]){
      launch(args); // launch the program
   	}
   	public void action(){
   		int ascii=65; // reintilize the ascii value
   		try{
      		while (ascii <=90){
        		char c = (char)ascii;
        		FileInputStream fis = new FileInputStream(fileinput.getText()); // read in the file as fis
        		while (fis.available() > 0) {
          			current = (char) fis.read(); // reading in character by character
          			if (current == c){ // if the character from ascii and the file are same
            			number =number+1; // increment the number
          			}
          		dataSeries1.getData().add(new XYChart.Data<String, Number>(String.valueOf(c), number)); // add the data 
        		}
        	ascii ++;
        	number =0;
      		}
      		for(Node n:barChart.lookupAll(".default-color0.chart-bar")){ // used to change the color of the bars 
           			n.setStyle("-fx-bar-fill: red");
            }


      	}catch(FileNotFoundException fnfe){ // if file doesn't exist, then give an error on the console
      		System.out.println(fnfe.getMessage());
      	}catch(IOException fefe){
      		fefe.printStackTrace();
      	}
   	}
}
