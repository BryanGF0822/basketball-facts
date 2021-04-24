package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.BasketballAgency;

public class GUIController {


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
	
	public GUIController() throws IOException {
		
		ba = new BasketballAgency();
		ba.importPlayers("data/players.csv");
		
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
