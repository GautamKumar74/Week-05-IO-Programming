package com.ioprogramming.csvdatahandling.advancedproblems.detectduplicates;

import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employees.csv";
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String[] values = line.split(",");
                if (values.length > 0) {
                    String id = values[0].trim(); // Get ID column

                    if (!uniqueIds.add(id)) {
                        duplicateRecords.add(line); // Add to duplicate list if ID exists
                    }
                }
            }

            // Print duplicate records
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
