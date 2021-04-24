package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import collections.*;

public class BasketballAgency {

	private List<Player> playersList;
    private AVLBSTree<Double, Integer> puntosPorPartido;
    private AVLBSTree<Double, Integer> rebotesPorPartido;
    private AVLBSTree<Double, Integer> asistenciasPorPartido;
    
	public BasketballAgency() {

		playersList = new ArrayList<Player>();
		puntosPorPartido = new AVLBSTree<Double, Integer>();
		rebotesPorPartido = new AVLBSTree<Double, Integer>();
		asistenciasPorPartido = new AVLBSTree<Double, Integer>();
	}
	
	public void addPlayersStatics() {
		Node<Double, Integer> toAdd;
		for (int i = 0; i < playersList.size(); i++) {
			//Agregar puntos por partido
			if(puntosPorPartido.searchNode(playersList.get(i).getPuntosPorPartido())==null) {
			    
			    toAdd = puntosPorPartido.add(playersList.get(i).getPuntosPorPartido(), i); 
			    toAdd.getPlayers().add(playersList.get(i));
			    System.out.println(toAdd + "   ");
			}else {
				puntosPorPartido.searchNode(playersList.get(i).getPuntosPorPartido()).getPlayers().add(playersList.get(i));
			}
			
			//Agregar rebotes por partido
          if(puntosPorPartido.searchNode(playersList.get(i).getRebotesPorPartido())==null) {
			    
			    toAdd = puntosPorPartido.add(playersList.get(i).getRebotesPorPartido(), i); 
			    toAdd.getPlayers().add(playersList.get(i));
			}else {
				puntosPorPartido.searchNode(playersList.get(i).getRebotesPorPartido()).getPlayers().add(playersList.get(i));
			}
          
          //Agregar asistencias por partido
          if(puntosPorPartido.searchNode(playersList.get(i).getAsistenciasPorPartido())==null) {
			    
			    toAdd = puntosPorPartido.add(playersList.get(i).getAsistenciasPorPartido(), i); 
			    toAdd.getPlayers().add(playersList.get(i));
			}else {
				puntosPorPartido.searchNode(playersList.get(i).getAsistenciasPorPartido()).getPlayers().add(playersList.get(i));
			}
          
          //Agregar robos por partido
          
          
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
		
		br.close();
	}
}
