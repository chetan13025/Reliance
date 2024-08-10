package web;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class Over_Write_PRD extends Properties {
	static String filePath = ".\\csv_file\\RL_PRD.csv";
	static String IRD;
	static Set<String> usedValues = new HashSet<>();
	public static ArrayList<String> tagList = new ArrayList<>();
	// ArrayLists to store data from the 11th and 28th columns
	public static ArrayList<String> Article_IDS = new ArrayList<>();
	public static ArrayList<String> Serial1 = new ArrayList<>();

	public static void write() throws CsvException {
//    public static void main(String[] args) throws CsvException {
		// Original functionality
		overwriteColumns();
		Properties.pro();

		// New functionality: Store and print the 11th and 28th columns
		storeSelectedColumns(filePath, 11, 28);

		// Print the collected data from the 11th and 28th columns
		System.out.println("Data from the Article_ID");
		for (String article_ID : Article_IDS) {
			System.out.println(article_ID);
		}

		System.out.println("Data from the Serial_Number1");
		for (String serial1 : Serial1) {
			System.out.println(serial1);
		}
	}

	// Original overwrite functionality
	public static void overwriteColumns() throws CsvException {
		try {
			int columnToOverwrite = 0;
			int columnToOverwrite1 = 4;
			int columnToOverwrite2 = 28;
			int columnToOverwrite3 = 46;
			CSVReader csvReader = new CSVReader(new FileReader(filePath));
			List<String[]> records = csvReader.readAll();
			csvReader.close();

			// Generate a new value for the columns
			IRD = generateNewValue();
			String CRN = generateNewValue1();

			for (int i = 1; i < records.size(); i++) {
				String[] record = records.get(i);
				if (record.length > columnToOverwrite) {
					record[columnToOverwrite] = IRD;
				}
			}
			for (int i = 1; i < records.size(); i++) {
				String[] record = records.get(i);
				if (record.length > columnToOverwrite1) {
					record[columnToOverwrite1] = getIRD();
				}
			}
			for (int i = 1; i < records.size(); i++) {
				String[] record = records.get(i);
				if (record.length > columnToOverwrite2) {
					record[columnToOverwrite2] = generateUniqueRandomValue(usedValues);
				}
			}
			for (int i = 1; i < records.size(); i++) {
				String[] record = records.get(i);
				if (record.length > columnToOverwrite3) {
					record[columnToOverwrite3] = generateUniqueRandomValue(usedValues);
				}
			}

			CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath));
			csvWriter.writeAll(records);
			csvWriter.close();

			System.out.println("Data in the IRRD column overwritten successfully with: " + IRD);
			System.out.println("Data in the IRD column overwritten successfully with: " + getIRD());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Function to store data from the 11th and 28th columns into separate
	// ArrayLists
	public static void storeSelectedColumns(String filePath, int col1Index, int col2Index) {
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<String[]> allData = reader.readAll();

			// Store data from the specified columns
			for (int i = 1; i < allData.size(); i++) { // Start from 1 to skip header
				String[] row = allData.get(i);
				if (row.length > col1Index) {
					Article_IDS.add(row[col1Index]);
				}
				if (row.length > col2Index) {
					Serial1.add(row[col2Index]);
				}
			}
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
	}

	// Helper functions to generate new values
	private static String generateNewValue() {
		Random random = new Random();
		return "1000" + random.nextInt(10000);
	}

	private static String generateNewValue1() {
		Random random1 = new Random();
		return "1000" + random1.nextInt(10000);
	}

	private static String generateUniqueRandomValue(Set<String> usedValues) {
		Random random = new Random();
		String uniqueValue;
		do {
			uniqueValue = "06ML4PA000" + random.nextInt(10000);
		} while (!usedValues.add(uniqueValue));
		return uniqueValue;
	}

	// Getter and Setter for IRD
	public static String getIRD() {
		return IRD;
	}

	public static void setIRD(String iRD) {
		IRD = iRD;
	}
}