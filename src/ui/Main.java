package ui;

import java.io.FileReader;

import java.io.IOException;
import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
*/
public class Main extends Application{
	
	private GUIController gc;
	
	public Main() {
		gc = new GUIController();
		
	}
	
	public static void main(String[] args) {
		//readDataLineByLine("f.csv");
		//System.out.println("Lo lei +  ");
		//GUI
		launch(args);

		
		
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException{
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("fxml/logo.fxml")); 
		fxmll.setController(gc);
		Parent root = fxmll.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Basketball Facts!");
		primaryStage.setResizable(false);
		
		
	}

	// Java code to illustrate reading a
	// CSV file line by line
	public static void readDataLineByLine(String file)
	{
	  /*
	    try {
	  
	        // Create an object of filereader
	        // class with CSV file as a parameter.
	        FileReader filereader = new FileReader(file);
	  
	        // create csvReader object passing
	        // file reader as a parameter
	        CSVReader csvReader = 
	        		new CSVReaderBuilder(filereader).withSkipLines(1).build();
	        String[] nextRecord;
	  
	        // we are going to read data line by line
	        while ((nextRecord = csvReader.readNext()) != null) {
	            for (String cell : nextRecord) {
	                System.out.print(cell + "\t");
	            }
	            System.out.println();
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    */
	}
	
	
	
}
