package com.ioprogramming.csvdatahandling.intermediateproblems.modifycsvfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSVFile {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/employees.csv";
        String outputFile = "src/main/resources/updated_employees.csv";
        List<String> updatedRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Add header row directly
                if (isHeader) {
                    updatedRecords.add(line);
                    isHeader = false;
                    continue;
                }

                // Split CSV line into fields
                String[] fields = line.split(",");
                if (fields.length < 4) continue; // Skip if data is incomplete

                String department = fields[2].trim();
                double salary = Double.parseDouble(fields[3].trim());

                // Increase salary by 10% if department is IT
                if (department.equalsIgnoreCase("IT")) {
                    salary *= 1.10; // Increase by 10%
                }

                // Format the new line and add to the list
                String updatedLine = fields[0] + "," + fields[1] + "," + department + "," + String.format("%.2f", salary);
                updatedRecords.add(updatedLine);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Write updated records back to a new file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String record : updatedRecords) {
                bw.write(record);
                bw.newLine();
            }
            System.out.println("Updated salaries saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
