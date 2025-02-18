package com.ioprogramming.csvdatahandling.intermediateproblems.searchrecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployeeCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employees.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim(); // Get input and trim spaces

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

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
                String name = fields[1].trim();
                String department = fields[2].trim();
                String salary = fields[3].trim();

                // Check if name matches searchName
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found!");
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}

