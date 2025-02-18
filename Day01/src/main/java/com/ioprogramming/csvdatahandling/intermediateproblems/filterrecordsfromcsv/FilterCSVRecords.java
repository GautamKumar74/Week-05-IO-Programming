package com.ioprogramming.csvdatahandling.intermediateproblems.filterrecordsfromcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = "src/main/resources/students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            System.out.println("Students who scored more than 80 marks:");
            System.out.println("--------------------------------------");

            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split CSV line into fields
                String[] fields = line.split(",");
                if (fields.length < 4) continue; // Skip if data is incomplete

                // Extract details
                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                int age = Integer.parseInt(fields[2].trim());
                double marks = Double.parseDouble(fields[3].trim());

                // Filter students with marks > 80
                if (marks > 80) {
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in file.");
        }
    }
}
