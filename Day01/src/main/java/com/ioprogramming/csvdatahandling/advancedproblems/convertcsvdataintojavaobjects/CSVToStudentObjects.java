package com.ioprogramming.csvdatahandling.advancedproblems.convertcsvdataintojavaobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudentObjects {
    public static void main(String[] args) {
        String filePath = "src/main/resources/students.csv";
        List<Student> students = new ArrayList<>();

        // Read CSV file and create Student objects
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split CSV line into fields
                String[] fields = line.split(",");
                if (fields.length < 4) continue; // Skip if data is incomplete

                // Create Student object
                Student student = new Student(fields[0].trim(), fields[1].trim(),
                        Integer.parseInt(fields[2].trim()),
                        Double.parseDouble(fields[3].trim()));

                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Print all Student objects
        System.out.println("Student Records:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
