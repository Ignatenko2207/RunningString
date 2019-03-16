package ua.com.qalight.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.qalight.entity.CurrencyEntity;

public class FileManager {

	private static final String INPUT_FILE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "files" + System.getProperty("file.separator") + "inputFile.txt";

	private static final String OUTPUT_FILE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "files" + System.getProperty("file.separator") + "outputFile.txt";

	public static Map<String, Double> readInputCurrencyValues() {

		Map<String, Double> currencyMap = new HashMap<String, Double>();

		try (FileReader fileReader = new FileReader(INPUT_FILE_PATH);
				BufferedReader bufReader = new BufferedReader(fileReader)) {
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				String[] values = line.split("," + " ");
				currencyMap.put(values[0], Double.valueOf(values[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return currencyMap;
	}

	public static void writeCurrencyValuesToFile(List<CurrencyEntity> currencies) {
		try (FileWriter writer = new FileWriter(OUTPUT_FILE_PATH, false)) {
			String outText = "";
			for (CurrencyEntity currencyEntity : currencies) {
				outText += currencyEntity.getCurrency().getShortName() + "(" + currencyEntity.getCurrency().getSymbol()
						+ ")" + " - " + CalculationService.getBuyPrice(currencyEntity) + "/"
						+ CalculationService.getSellPrice(currencyEntity) + " - " + currencyEntity.getValue() + "\n";
			}
			writer.write(outText);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
