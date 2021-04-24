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
import javafx.stage.StageStyle;
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
	
	// ********** controller atributes **********
	private boolean isSearching;
	
	public GUIController() {
		ba = new BasketballAgency();
		isSearching = false;
	}
	
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
			stage.setResizable(false);
			stage.show();

		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		} 
	}
// Ventana Informacion jugadores
	public void LoadInfoWindow() {
		try {
			FXMLLoader fxmll = new FXMLLoader(getClass().getResource("fxml/informacionJugadores.fxml"));
			fxmll.setController(this);
			Parent root = fxmll.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Basketball Facts!");
			stage.setResizable(false);
			stage.show();

		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		}
	}
	
	
	private void LoadSearchByNameWindow(String nameToDisplay) {
		try {
			FXMLLoader fxmll = new FXMLLoader(getClass().getResource("fxml/nombre.fxml"));
			fxmll.setController(this);
			Parent root = fxmll.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Basketball Facts!");
			stage.setResizable(false);
			stage.setAlwaysOnTop(true);
			stage.initStyle(StageStyle.UTILITY);
			stage.show();
			stage.setOnCloseRequest(e -> closeSearchStage() );
			
			isSearching = true;
			filterByNameLabel.setText(nameToDisplay);
			
			
		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		} 
		
	}
	
	private void LoadSearchByRangeWindow(String nameToDisplay) {
		try {
			FXMLLoader fxmll = new FXMLLoader(getClass().getResource("fxml/rango.fxml"));
			fxmll.setController(this);
			Parent root = fxmll.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Basketball Facts!");
			stage.setResizable(false);
			stage.setAlwaysOnTop(true);
			stage.initStyle(StageStyle.UTILITY);
			stage.show();
			stage.setOnCloseRequest(e -> closeSearchStage() );
			
			isSearching = true;
			filterByRangeLabel.setText(nameToDisplay);
			
			
		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		} 
		
	}
	
	// ********** logo Window Action **********
	@FXML
	void load(ActionEvent event) {
		try {
			ba.importPlayers(CSV_PATH);
			ba.addPlayersStatics();
				
			//Closes logo loading window.
			Stage logoStage = (Stage) logoAP.getScene().getWindow();
			logoStage.close();
				
			LoadMainWindow();
			    
		} catch (IOException ioException) {
				// TODO: handle exception with an alert that displays the content of the error.
		}
		
		
	}
	
	
	 private void closeSearchStage() {
		 isSearching = false;
	}
	 
    // ********** Principal Windows Actions **********
    @FXML
    void filterByAge(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Edad");
    		
		}else {
			//TODO
		}
    	
    }

    @FXML
    void filterByAssistance(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("asistencias");
    		
		}else {
			//TODO
		}
    	
    }

    @FXML
    void filterByBlocks(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Bloqueos");
    		
		}else {
			//TODO
		}
    	
    }

    @FXML
    void filterByFouls(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Faltas");
    		
		}else {
			//TODO
		}
    	
    }

    @FXML
    void filterByName(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByNameWindow("Nombre del jugador");
    		
		}else {
			//TODO
		}
    	
    }

    @FXML
    void filterByRebounds(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Rebotes");
    		
		}else {
			//TODO
		}
    	
    }

    @FXML
    void filterByScore(ActionEvent event) {	
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Puntos");
    		
		}else {
			//TODO
		}
    	
    }

    @FXML
    void filterBySteal(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Robos");
    		
		}else {
			//TODO
		}
    	
    }

    @FXML
    void filterByTeam(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByNameWindow("Nombre del Equipo");
    		
		}else {
			//TODO
		}
    	
    }
	
	// ********** search name window action **********
    @FXML
    void searchByName(ActionEvent event) {
		LoadInfoWindow();
    }
    
    // ********** search range action **********
    @FXML
    void searchByRange(ActionEvent event) {
		LoadInfoWindow();
    }
	// ********** Back to window Initial **********
	@FXML
	void backWindowInicio(ActionEvent event) {
		LoadMainWindow();
	}
	
	
}

