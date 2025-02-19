package com.ioprogramming.csvdatahandling.advancedproblems.readlargecsvfile;

import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "src/main/resources/large_file.csv";
        int batchSize = 100; // Read 100 lines at a time
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int batchCount = 0;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header
                    continue;
                }

                // Process the line (Here, we just count it)
                batchCount++;
                totalRecords++;

                // Process in batches
                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                    batchCount = 0; // Reset batch counter
                }
            }

            System.out.println("Total Records Processed: " + totalRecords);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
