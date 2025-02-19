package com.ioprogramming.jsondata.practiceproblems.validatejsonstructure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static void main(String[] args) {
        String validJson= "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}";
        String invalidJson= "{\"name\": \"John Doe\", \"email\": }";

        System.out.println("Valid JSON: " + isValidJson(validJson));
        System.out.println("Invalid JSON: " + isValidJson(invalidJson));
    }

    public static boolean isValidJson(String json){
        try{
            ObjectMapper objectMapper= new ObjectMapper();
            objectMapper.readTree(json);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
