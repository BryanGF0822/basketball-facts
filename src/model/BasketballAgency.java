package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasketballAgency {
	
	private List<Player> playersList;
	
	public BasketballAgency() {
		
		playersList = new ArrayList<Player>();
	}
	
	public void importDataBooksList(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] split = line.split(",");
			Player newPlayer = new Player(split[0], Integer.parseInt(split[1]), split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]),
					Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7]),Integer.parseInt(split[8]));
			
			playersList.add(newPlayer);
			line = br.readLine();
			
			System.out.println(newPlayer + "");

		}
		
	}
}
