package ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private GUIController gc;
	
	public Main() {
		gc = new GUIController();
		
	}
	
	public static void main(String[] args) {
		
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

	
	
}
