package ui;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import model.BasketballAgency;
import model.Player;
import customExceptions.*;

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

	// ********** Id Window consultarJugadores **********
	@FXML
	private HBox windowCosultarJugadores;
	
	
	// ********** Window informacinJugadores **********
	@FXML
	private TableView<Player> playersTable;
	
	@FXML
	private TableColumn<Player, String> columnName;

	@FXML
	private TableColumn<Player, Integer> columnAge;

	@FXML
	private TableColumn<Player, String> columnTeam;

	@FXML
	private TableColumn<Player, Double> columnScore;

	@FXML
	private TableColumn<Player, Double> columnRebounds;

	@FXML
	private TableColumn<Player, Double> columnAssists;
    
	@FXML
	private TableColumn<Player, Double> columnSteals;
	
	@FXML
	private TableColumn<Player, Double> columnBlocks;
	
	@FXML
	private TableColumn<Player, Double> columnFouls;
    
    // ********** model atributes **********
	private static BasketballAgency ba ;
	
	// ********** import csv path **********
	private final String CSV_PATH =  "data/players.csv";
	
	// ********** range limits **********
	private final int AGE_RANGE_MIN = 18; 
	private final int AGE_RANGE_MAX = 45; 
	
	private final int SCORE_ASSISTANCE_RANGE_MIN = 1; 
	private final int SCORE_ASSISTANCE_RANGE_MAX = 80; 

	private final int BLOCKS_STEALS_RANGE_MIN = 1; 
	private final int BLOCKS_STEALS_RANGE_MAX = 60; 
	
	private final int REBOUNDS_RANGE_MIN = 1; 
	private final int REBOUNDS_RANGE_MAX = 90; 
	
	private final int FOULS_RANGE_MIN = 1; 
	private final int FOULS_RANGE_MAX = 30; 
	
	// ********** controller atributes **********
	private boolean isSearching;
	private List<Player> filteredPlayers;
	
	public GUIController() {
		ba = new BasketballAgency();
		isSearching = false;
		filteredPlayers = new ArrayList<>();
		
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
			unespectedErrorAlert(ioException.getStackTrace().toString(),(Stage) windowCosultarJugadores.getScene().getWindow() );
			
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
			loadPlayersTable(filteredPlayers);
			
		} catch (IOException ioException) {
			unespectedErrorAlert(ioException.getStackTrace().toString(),(Stage) playersTable.getScene().getWindow() );
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
			unespectedErrorAlert(ioException.getStackTrace().toString(),(Stage) filterByNameLabel.getScene().getWindow() );
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
			unespectedErrorAlert(ioException.getStackTrace().toString(),(Stage) filterByRangeLabel.getScene().getWindow() );
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
				unespectedErrorAlert(ioException.getStackTrace().toString(),(Stage) logoAP.getScene().getWindow() );
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
    		
		}
    }

    @FXML
    void filterByAssistance(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Asistencias");
    		
		}
    }

    @FXML
    void filterByBlocks(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Bloqueos");
    		
		}
    }

    @FXML
    void filterByFouls(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Faltas");
    		
		}
    }

    @FXML
    void filterByName(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByNameWindow("Nombre del jugador");
    		
		}
    }

    @FXML
    void filterByRebounds(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Rebotes");
    		
		}
    }

    @FXML
    void filterByScore(ActionEvent event) {	
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Puntos");
    		
		}
    }

    @FXML
    void filterBySteal(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByRangeWindow("Robos");
    		
		}
    }

    @FXML
    void filterByTeam(ActionEvent event) {
    	if (!isSearching) {
    		LoadSearchByNameWindow("Nombre del Equipo");
    		
		}
    }
	
	// ********** search name window action **********
    @FXML
    void searchByName(ActionEvent event) {
    	try {
    		String name = nameToSearch.getText();
        	
        	if (name.equals("") || name.equals(null)) {
        		throw new InvalidNameException(filterByNameLabel.getText());
    		}
        	
        	filteredPlayers = ba.linearSearchNombre(name);
        	if (filteredPlayers.size() == 0) {
				throw new playersNotFoundException();
			}
        	
        	Stage stage = (Stage) nameToSearch.getScene().getWindow();
            stage.close();
            
            stage = (Stage) windowCosultarJugadores.getScene().getWindow();
            stage.close();
            
            isSearching = false;
            
    		LoadInfoWindow();
    		
		} catch (InvalidNameException iNE) {
			invalidNameAlert(iNE.getMessage());
		}catch (playersNotFoundException pNFE) {
			playersNotFoundAlert(pNFE.getMessage(),"name");
		}
    	
    }
    
    private void invalidNameAlert(String message) {
    	Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Error");
		error.setHeaderText("Invalid Name to Search");
		error.setContentText(message);
		error.initOwner(nameToSearch.getScene().getWindow());
		error.showAndWait();
    }
    
    // ********** search range action **********
    @FXML
    void searchByRange(ActionEvent event) {
    	try {
    		double min = Integer.parseInt(minRange.getText());
    		double max = Integer.parseInt(maxRange.getText());
    		
    		validateRange(min,max,filterByRangeLabel.getText());
    		
    		Stage stage = (Stage) filterByRangeLabel.getScene().getWindow();
            stage.close();
            
            stage = (Stage) windowCosultarJugadores.getScene().getWindow();
            stage.close();
    		
            isSearching = false;
            
    		LoadInfoWindow();
    		
		} catch (InvalidRangeException iRE) {
			invalidRangeAlert(iRE.getMessage());
			
		} catch (NumberFormatException nFE) {
			invalidRangeAlert("Invalid number format, Check that the entered data is a number.");
			
		} catch (playersNotFoundException pNFE) {
			playersNotFoundAlert(pNFE.getMessage(),"range");
			
		}
		
    }
    
    private void validateRange(double min, double max, String name) throws InvalidRangeException, playersNotFoundException{
   
    	if (name.equals("Asistencias") || name.equals("Puntos")) {
			if (SCORE_ASSISTANCE_RANGE_MIN > min || SCORE_ASSISTANCE_RANGE_MAX < min || SCORE_ASSISTANCE_RANGE_MAX < max || SCORE_ASSISTANCE_RANGE_MIN > max) {
				throw new InvalidRangeException(SCORE_ASSISTANCE_RANGE_MIN, SCORE_ASSISTANCE_RANGE_MAX, name);
			}else {
				if (name.equals("Asistencias")) {
					filteredPlayers = ba.aVLSearchAsistencias(min, max);
		
				}else {
					filteredPlayers = ba.aVLSearchPuntos(min, max);
					
				}
				
				if (filteredPlayers.size() == 0) {
					throw new playersNotFoundException();
				}
				return;
				
			}
		}
    	
    	if (name.equals("Robos") || name.equals("Bloqueos")) {
			if (BLOCKS_STEALS_RANGE_MIN > min || BLOCKS_STEALS_RANGE_MAX < min || BLOCKS_STEALS_RANGE_MAX < max || BLOCKS_STEALS_RANGE_MIN > max) {
				throw new InvalidRangeException(BLOCKS_STEALS_RANGE_MIN, BLOCKS_STEALS_RANGE_MAX, name);
			}else {
				if (name.equals("Robos")) {
					filteredPlayers = ba.redBlackSearchRobos(min, max);
				}else {
					filteredPlayers = ba.binarySearchBloqueos(min, max);
				}
				
				if (filteredPlayers.size() == 0) {
					throw new playersNotFoundException();
				}
				
				return;
			}
		}
    	
    	if (name.equals("Edad")) {
			if (AGE_RANGE_MIN > min || AGE_RANGE_MAX < min || AGE_RANGE_MAX < max || AGE_RANGE_MIN > max) {
				throw new InvalidRangeException(AGE_RANGE_MIN, AGE_RANGE_MAX, name);
			}else {
				filteredPlayers = ba.linearSearchEdad(min, max);
				if (filteredPlayers.size() == 0) {
					throw new playersNotFoundException();
				}
				return;
			}
		}
    	
    	
    	if (name.equals("Rebotes")) {
			if (REBOUNDS_RANGE_MIN > min || REBOUNDS_RANGE_MAX < min || REBOUNDS_RANGE_MAX < max || REBOUNDS_RANGE_MIN > max) {
				throw new InvalidRangeException(REBOUNDS_RANGE_MIN, REBOUNDS_RANGE_MAX, name);
			}else {
				filteredPlayers = ba.aVLSearchRebotes(min, max);
				if (filteredPlayers.size() == 0) {
					throw new playersNotFoundException();
				}
				return;
			}
		}
    	
    	if (name.equals("Faltas")) {
			if (FOULS_RANGE_MIN > min || FOULS_RANGE_MAX < min || FOULS_RANGE_MAX < max || FOULS_RANGE_MIN > max) {
				throw new InvalidRangeException(FOULS_RANGE_MIN, FOULS_RANGE_MAX, name);
			}else {
				filteredPlayers = ba.linearSearchFaltas(min, max);
				if (filteredPlayers.size() == 0) {
					throw new playersNotFoundException();
				}
				return;
			}
		}
    	
    }
    
    private void invalidRangeAlert(String message) {
    	Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Error");
		error.setHeaderText("Invalid range to Search");
		error.setContentText(message);
		error.initOwner(filterByRangeLabel.getScene().getWindow());
		error.showAndWait();
    }
    
    private void playersNotFoundAlert(String message, String nameOrRange) {
    	Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Error");
		error.setHeaderText("Ningun jugador encontrado.");
		error.setContentText(message);
		
		if (nameOrRange.equals("name")) {
			error.initOwner(filterByNameLabel.getScene().getWindow());
			
		}else {
			error.initOwner(filterByRangeLabel.getScene().getWindow());
			
		}

		error.showAndWait();
    }
    
	// ********** Back to window Initial **********
	@FXML
	void backWindowInicio(ActionEvent event) {
		Stage stage = (Stage) playersTable.getScene().getWindow();
		stage.close();
		LoadMainWindow();
		
	}
	
	
	private void loadPlayersTable(List<Player> playersList) {
		ObservableList<Player> observableList;
		observableList = FXCollections.observableArrayList(playersList);
		playersTable.setItems(observableList);

		columnName.setCellValueFactory(new PropertyValueFactory<Player, String>("nombre"));
		columnTeam.setCellValueFactory(new PropertyValueFactory<Player, String>("equipo"));
		columnAge.setCellValueFactory(new PropertyValueFactory<Player, Integer>("edad"));
		columnAssists.setCellValueFactory(new PropertyValueFactory<Player, Double>("asistenciasPorPartido"));
		columnBlocks.setCellValueFactory(new PropertyValueFactory<Player, Double>("bloqueosPorPartido"));
		columnFouls.setCellValueFactory(new PropertyValueFactory<Player, Double>("faltasPorPartido"));
		columnRebounds.setCellValueFactory(new PropertyValueFactory<Player, Double>("rebotesPorPartido"));
		columnScore.setCellValueFactory(new PropertyValueFactory<Player, Double>("puntosPorPartido"));
		columnSteals.setCellValueFactory(new PropertyValueFactory<Player, Double>("robosPorPartido"));
	}
	
	
	private void unespectedErrorAlert(String message, Window window) {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Error");
		error.setHeaderText("Un error inesperado ha ocurrido.");
		error.setContentText(message);
		error.initOwner(window);
		error.showAndWait();
		
	}
}

