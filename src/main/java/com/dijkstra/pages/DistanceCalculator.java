package com.dijkstra.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceCalculator {

	// Assuming these are your distance values
	private static final Map<String, Integer> distances = new HashMap<>();
	static {
		distances.put("A-B", 4);
		distances.put("A-C", 6);
		distances.put("B-F", 2);
		distances.put("C-D", 8);
		distances.put("D-C", 8);
		distances.put("D-E", 4);
		distances.put("D-G", 1);
		distances.put("E-B", 2);
		distances.put("E-F", 3);
		distances.put("E-I", 8);
		distances.put("E-D", 4);
		distances.put("F-B", 2);
		distances.put("F-E", 3);
		distances.put("F-G", 4);
		distances.put("G-D", 1);
		distances.put("G-F", 4);
		distances.put("G-I", 5);
		distances.put("I-E", 8);
		distances.put("I-G", 5);
	}

	public int calculateDistance(String path) {
		String[] nodes = path.split("\\+\\s*");
		int totalDistance = 0;

		for (int i = 0; i < nodes.length - 1; i++) {
			String key = nodes[i] + "-" + nodes[i + 1];
			if (distances.containsKey(key)) {
				totalDistance += distances.get(key);
			} else {
				// Handle missing distance value, if necessary
				System.out.println("Distance not found for path: " + key);
			}
		}

		return totalDistance;
	}

	public int processResultsList(List<String> resultsList) {
		int calculateDistance = 0;
		String pathInfo = null;
		String resultsText = resultsList.get(0);

		// Extract the path part
		pathInfo = resultsText.split(":")[1].split(",")[0].trim();
		pathInfo = pathInfo.replace(".", "+");

		// Calculate the distance
		calculateDistance = calculateDistance(pathInfo);
		System.out.println("Path: " + pathInfo + ", Calculated Distance: " + calculateDistance);

		return calculateDistance;
	}

}
