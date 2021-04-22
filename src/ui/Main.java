package ui;

import java.io.FileReader;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class Main {

	public static void main(String[] args) {
		
		try {
			CSVReader reader = new CSVReader(new FileReader("/data/PlayersList.csv"));
			String[] nextLine;
			while((nextLine = reader.readNext()) != null) {
				if(nextLine != null) {
					System.out.println(Arrays.toString(nextLine));
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println("Lo lei ");
	}

}
