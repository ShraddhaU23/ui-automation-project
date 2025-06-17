package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVReaderUtility {

	public static void main(String[] args)  {
		File file = new File(System.getProperty("user.dir") + "\\testdata\\logindata.csv");
		FileReader fileReader=null;
		String[] line;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		CSVReader csvReader = new CSVReader(fileReader);
		 try {
			csvReader.readNext();
		} catch (CsvValidationException | IOException e) {
			
			e.printStackTrace();
		}
		 
		 try {
			while((line= csvReader.readNext())!=null) {
				 
			 }
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
