package com.ioprogramming.jsondata.handsonpracticeproblems.convertcsvdataintojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFilePath = "src/main/resources/input.csv";
        String jsonFilePath = "src/main/resources/output.json";

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
             FileWriter fileWriter = new FileWriter(jsonFilePath)) {

            // Read all rows from CSV
            List<String[]> allRows = csvReader.readAll();
            if (allRows.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            // Extract header row (column names)
            String[] headers = allRows.get(0);
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            // Convert each row to JSON object
            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);
                ObjectNode jsonObject = objectMapper.createObjectNode();
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], row[j]);
                }
                jsonArray.add(jsonObject);
            }

            // Write JSON to file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileWriter, jsonArray);
            System.out.println("CSV successfully converted to JSON. Check output.json file.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
