package com.ioprogramming.jsondata.handsonpracticeproblems.validateanemail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileInputStream;

public class ValidateEmailJson {
    public static void main(String[] args) {
        try {
            // Load JSON Schema
            FileInputStream schemaStream = new FileInputStream("src/main/resources/schema.json");
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(rawSchema);

            // Load JSON Data
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(new File("src/main/resources/email.json"));

            // Validate JSON against Schema
            schema.validate(new JSONObject(jsonData.toString()));

            System.out.println("JSON is valid!");

        } catch (Exception e) {
            System.out.println("JSON validation failed: " + e.getMessage());
        }
    }
}
