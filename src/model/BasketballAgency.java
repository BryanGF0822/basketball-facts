package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import collections.*;

public class BasketballAgency {

	private List<Player> playersList;
    private AVLTree<Double, Integer> puntosPorPartido;
	public BasketballAgency() {

		playersList = new ArrayList<Player>();
		puntosPorPartido = new AVLTree<>();
		
	}
	
	public void addPlayersStatics() {
		for (int i = 0; i < playersList.size(); i++) {
			//syso()
		}
	}

	public void importPlayers(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();

		String line = br.readLine();

		while (line != null) {
			String[] split = line.split(",");
			Player newPlayer = new Player(split[0], Integer.parseInt(split[1]), split[2], Double.parseDouble(split[3]),
					Double.parseDouble(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]),
					Double.parseDouble(split[7]), Double.parseDouble(split[8]));
			playersList.add(newPlayer);
			line = br.readLine();

		}
		
		for (int i = 0; i < playersList.size(); i++) {
			
			System.out.println(playersList.get(i));
		}
	}
}
