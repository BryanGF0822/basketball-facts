package ui;

import java.io.FileReader;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class Main {

	public static void main(String[] args) {
		
		readDataLineByLine("f.csv");
		System.out.println("Lo lei ");
	}

	// Java code to illustrate reading a
	// CSV file line by line
	public static void readDataLineByLine(String file)
	{
	  
	    try {
	  
	        // Create an object of filereader
	        // class with CSV file as a parameter.
	        FileReader filereader = new FileReader(file);
	  
	        // create csvReader object passing
	        // file reader as a parameter
	        CSVReader csvReader = 
	        		new CSVReaderBuilder(filereader).withSkipLines(1).build();
	        String[] nextRecord;
	  
	        // we are going to read data line by line
	        while ((nextRecord = csvReader.readNext()) != null) {
	            for (String cell : nextRecord) {
	                System.out.print(cell + "\t");
	            }
	            System.out.println();
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
