package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class InventoryReader {
	private static Map<String, Stack<Items>> inventoryMap = new TreeMap<>();
	
	public Map inventoryImport() {
		File inventoryCSV = new File("vendingmachine.csv");
		int counter = 0;
		try (Scanner inventoryReader = new Scanner(inventoryCSV)) {

			while (inventoryReader.hasNextLine()) {
				String line = inventoryReader.nextLine();
				String lineArray[] = line.split("\\|");
				counter++;
				Stack<Items> itemStack = new Stack<>();
				
				if (lineArray[0].contains("A")) {
					for (int i = 0; i < 5; i++) {
						itemStack.push(new ChipsItem(lineArray[1], new BigDecimal(lineArray[2])));
					}
				} else if (lineArray[0].contains("B")) {
					for (int i = 0; i < 5; i++) {
						itemStack.push(new CandiesItem(lineArray[1], new BigDecimal(lineArray[2])));
					}
				} else if (lineArray[0].contains("C")) {
					for (int i = 0; i < 5; i++) {
						itemStack.push(new DrinksItem(lineArray[1], new BigDecimal(lineArray[2])));
					}
				} else if (lineArray[0].contains("D")) {
					for (int i = 0; i < 5; i++) {
						itemStack.push(new GumsItem(lineArray[1], new BigDecimal(lineArray[2])));
					}
				}
				inventoryMap.put(lineArray[0], itemStack);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventoryMap;
	}

	public static Map<String, Stack<Items>> getInventoryMap() {
		return inventoryMap;
	}
	


	public static void setInventoryMap(Map<String, Stack<Items>> inventoryMap) {
		InventoryReader.inventoryMap = inventoryMap;
	}
}
