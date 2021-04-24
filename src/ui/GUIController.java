package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.BasketballAgency;

public class GUIController {
	
	// ********** Logo window **********
	@FXML
    private AnchorPane logoAP;
	
    // ********** search name window **********
	@FXML
    private Label filterByNameLabel;

    @FXML
    private TextField nameToSearch;
    
    // ********** search range window **********
    @FXML
    private Label filterByRangeLabel;

    @FXML
    private TextField minRange;

    @FXML
    private TextField maxRange;
    
    // ********** model atributes **********
	private static BasketballAgency ba ;
	
	// ********** import csv path **********
	private final String CSV_PATH =  "data/players.csv";
	
	public GUIController() {
		ba = new BasketballAgency();
	}
	
	public void initialize() {
		/*if (ba == null) {
			ba = new BasketballAgency();

			// import player information before opening the principal window.
			try {
				ba.importPlayers(CSV_PATH);
				
				LoadMainWindow();
				
				//Closes logo loading window.
				Stage logoStage = (Stage) logoAP.getScene().getWindow();
			    logoStage.close();
			    
			} catch (IOException ioException) {
				// TODO: handle exception with an alert that displays the content of the error.
			} 
			
		}*/
	}
	/*
	public void importData() {
		try {
			ba.importPlayers(CSV_PATH);
			
			//Closes logo loading window.
			Stage logoStage = (Stage) logoAP.getScene().getWindow();
		    logoStage.close();
			
			LoadMainWindow();
		    
		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		} 
		
	}
	*/
	
	// ********** load fxml **********
	
	public void LoadMainWindow() {
		try {
			FXMLLoader fxmll = new FXMLLoader(getClass().getResource("fxml/consultarJugadores.fxml"));
			fxmll.setController(this);
			Parent root = fxmll.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Basketball Facts!");
			stage.show();

		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		} 
	}
	
	@FXML
    void load(ActionEvent event) {
		try {
			ba.importPlayers(CSV_PATH);
			
			//Closes logo loading window.
			Stage logoStage = (Stage) logoAP.getScene().getWindow();
		    logoStage.close();
			
			LoadMainWindow();
		    
		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		} 
    }

    // ********** Principal Windows Actions **********
    @FXML
    void filterByAge(ActionEvent event) {

    }

    @FXML
    void filterByAssistance(ActionEvent event) {

    }

    @FXML
    void filterByBlocks(ActionEvent event) {

    }

    @FXML
    void filterByFouls(ActionEvent event) {

    }

    @FXML
    void filterByName(ActionEvent event) {

    }

    @FXML
    void filterByRebounds(ActionEvent event) {

    }

    @FXML
    void filterByScore(ActionEvent event) {

    }

    @FXML
    void filterBySteal(ActionEvent event) {

    }

    @FXML
    void filterByTeam(ActionEvent event) {

    }
	
	// ********** search name window action **********
    @FXML
    void searchByName(ActionEvent event) {

    }
    
    // ********** search range action **********
    @FXML
    void searchByRange(ActionEvent event) {

    }
	
	
}
