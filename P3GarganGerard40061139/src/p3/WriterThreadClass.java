package p3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author GarganGerard - 40061139
 */
public class WriterThreadClass implements Runnable {

	private Map<String, Double> uniqueCitiesAvgPrice;
	private String fileName;

	/**
	 * @param uniqueCitiesAvgPrice
	 */
	public WriterThreadClass(Map<String, Double> uniqueCitiesAvgPrice, String fileName) {
		this.uniqueCitiesAvgPrice = uniqueCitiesAvgPrice;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		System.out.println("Writing file");
		File file = new File(fileName);

		try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {

			for (String city : uniqueCitiesAvgPrice.keySet()) {
				String toWrite = String.format("%s,%.2f", city, uniqueCitiesAvgPrice.get(city));
				bw.write(toWrite);
				bw.newLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("File writing finished");

	}

}
