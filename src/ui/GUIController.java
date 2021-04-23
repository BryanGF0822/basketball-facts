package ui;

import java.io.IOException;

import model.BasketballAgency;

public class GUIController {
	
	private static BasketballAgency ba ;
	
	public GUIController() throws IOException {
		
		ba = new BasketballAgency();
		ba.importPlayers("data/players.csv");
		
	}
	
}
