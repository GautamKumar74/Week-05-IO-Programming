package com.ioprogramming.jsondata.handsonpracticeproblems.readajsonfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonKeysValues {
    public static void main(String[] args) {
        try {
            // Load JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/data.json"));

            // Print keys and values
            printJson(rootNode, "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Recursive method to print all keys and values
    private static void printJson(JsonNode node, String parentKey) {
        if (node.isObject()) {
            // Iterate through object fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJson(field.getValue(), parentKey + field.getKey() + ".");
            }
        } else if (node.isArray()) {
            // Print array elements
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), parentKey + i + ".");
            }
        } else {
            // Print key-value pair
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " : " + node.asText());
        }
    }
}
