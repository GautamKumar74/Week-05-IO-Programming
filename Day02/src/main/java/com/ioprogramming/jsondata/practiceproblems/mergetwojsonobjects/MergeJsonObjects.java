package com.ioprogramming.jsondata.practiceproblems.mergetwojsonobjects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper= new ObjectMapper();

            String json1 = "{ \"name\": \"John Doe\", \"email\": \"john.doe@example.com\" }";
            JsonNode jsonNode1= objectMapper.readTree(json1);

            String json2 = "{ \"age\": 30, \"city\": \"New York\" }";
            JsonNode jsonNode2= objectMapper.readTree(json2);

            ObjectNode mergedJson= objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) jsonNode1);
            mergedJson.setAll((ObjectNode) jsonNode2);

            String mergedJsonString= objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson);
            System.out.println("Merged JSON: \n" + mergedJsonString);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
