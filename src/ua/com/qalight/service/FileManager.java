package ua.com.qalight.service;

import java.util.Map;

import ua.com.qalight.entity.CurrencyEntity;

public class FileManager {

	private static final String INPUT_FILE_PATH = 
			System.getProperty("user.dir") + 
			System.getProperty("file.separator") + 
			"files" + 
			System.getProperty("file.separator") + 
			"inputFile.txt";	
	
	private static final String OUTPUT_FILE_PATH = 
			System.getProperty("user.dir") + 
			System.getProperty("file.separator") + 
			"files" + 
			System.getProperty("file.separator") + 
			"outputFile.txt";	
	
	public static Map<String, Double> readInputCurrencyValues(){
		
		return null;
	}
	
	public static void writeCurrencyValuesToFile(CurrencyEntity currency) {
		
		// call calculted methods
		
	}
	
}
