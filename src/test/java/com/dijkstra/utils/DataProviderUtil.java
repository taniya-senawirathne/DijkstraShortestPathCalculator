package com.dijkstra.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class DataProviderUtil {

	@DataProvider(name = "TestDataProvider")
	public static Object[][] getDataFromCsv() throws IOException, CsvException {
		String path = "./src/test/resources/data/testData.csv";
		CSVReader reader = new CSVReader(new FileReader(path));
		List<String[]> data = reader.readAll();
		reader.close();

		// List to hold valid data rows
		List<String[]> validData = new ArrayList<>();

		// Skip the header row and validate data
		for (int i = 1; i < data.size(); i++) {
			String[] row = data.get(i);
			if (row.length >= 2) {
				validData.add(row);
			}
		}

		// Convert List<String[]> to Object[][]
		Object[][] dataArray = new Object[validData.size()][2];
		for (int i = 0; i < validData.size(); i++) {
			dataArray[i][0] = validData.get(i)[0]; // fromNode
			dataArray[i][1] = validData.get(i)[1]; // toNode
		}
		return dataArray;
	}

}
