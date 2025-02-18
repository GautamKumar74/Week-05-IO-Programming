package com.ioprogramming.csvdatahandling.advancedproblems.validatecsvdata;

import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employeesdata.csv";

        // Define regex patterns
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            System.out.println("Validating CSV Data...\n");

            while ((line = br.readLine()) != null) {
                // Skip header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split CSV line into fields
                String[] fields = line.split(",");
                if (fields.length < 5) {
                    System.out.println("Invalid row (Missing fields): " + line);
                    continue;
                }

                String id = fields[0].trim();
                String name = fields[1].trim();
                String department = fields[2].trim();
                String email = fields[3].trim();
                String phone = fields[4].trim();

                boolean isValid = true;
                StringBuilder errorMessage = new StringBuilder("Invalid row: " + line + " -> ");

                // Validate Email
                if (!emailPattern.matcher(email).matches()) {
                    errorMessage.append("[Invalid Email] ");
                    isValid = false;
                }

                // Validate Phone Number
                if (!phonePattern.matcher(phone).matches()) {
                    errorMessage.append("[Invalid Phone Number] ");
                    isValid = false;
                }

                // Print errors
                if (!isValid) {
                    System.out.println(errorMessage.toString());
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
