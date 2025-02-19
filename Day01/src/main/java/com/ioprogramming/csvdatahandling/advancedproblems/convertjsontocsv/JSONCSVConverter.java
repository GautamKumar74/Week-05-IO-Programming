package com.ioprogramming.csvdatahandling.advancedproblems.convertjsontocsv;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONCSVConverter {
    private static final String JSON_FILE = "src/main/resources/students.json";
    private static final String CSV_FILE = "src/main/resources/students.csv";
    private static final String OUTPUT_JSON_FILE = "src/main/resources/students_output.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        try {
            // Convert JSON to CSV
            convertJsonToCsv(JSON_FILE, CSV_FILE);

            // Convert CSV back to JSON
            convertCsvToJson(CSV_FILE, OUTPUT_JSON_FILE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Convert JSON to CSV
    public static void convertJsonToCsv(String jsonFilePath, String csvFilePath) throws IOException {
        // Read JSON file into List<Student>
        List<Student> students = Arrays.asList(objectMapper.readValue(new File(jsonFilePath), Student[].class));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));
             CSVWriter csvWriter = new CSVWriter(writer)) {

            // Write Header
            csvWriter.writeNext(new String[]{"ID", "Name", "Age", "Marks"});

            // Write Data
            for (Student student : students) {
                csvWriter.writeNext(new String[]{
                        String.valueOf(student.id),
                        student.name,
                        String.valueOf(student.age),
                        String.valueOf(student.marks)
                });
            }

            System.out.println("JSON converted to CSV successfully!");

        }
    }

    // Convert CSV back to JSON
    public static void convertCsvToJson(String csvFilePath, String outputJsonFilePath) throws IOException, CsvValidationException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
             CSVReader csvReader = new CSVReader(reader)) {

            String[] nextRecord;
            csvReader.readNext(); // Skip header

            while ((nextRecord = csvReader.readNext()) != null) {
                students.add(new Student(
                        Integer.parseInt(nextRecord[0]),
                        nextRecord[1],
                        Integer.parseInt(nextRecord[2]),
                        Double.parseDouble(nextRecord[3])
                ));
            }

            // Write JSON output
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputJsonFilePath), students);
            System.out.println("CSV converted back to JSON successfully!");
        }
        catch (IOException e) {
            System.err.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
}