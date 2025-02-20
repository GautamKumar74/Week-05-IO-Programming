package com.ioprogramming.jsondata.handsonpracticeproblems.mergetwojsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            // Initialize ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON files
            JsonNode json1 = objectMapper.readTree(new File("src/main/resources/file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("src/main/resources/file2.json"));

            // Merge JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            // Write merged JSON to file
            objectMapper.writeValue(new File("src/main/resources/merged.json"), mergedJson);

            System.out.println("JSON files merged successfully! Check merged.json file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
