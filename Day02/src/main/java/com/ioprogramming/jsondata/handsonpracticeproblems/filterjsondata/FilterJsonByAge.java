package com.ioprogramming.jsondata.handsonpracticeproblems.filterjsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;

public class FilterJsonByAge {
    public static void main(String[] args) {
        try {
            // Load JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/persons.json"));

            // Iterate and filter users with age > 25
            System.out.println("Users older than 25:");
            for (JsonNode user : rootNode) {
                int age = user.get("age").asInt();
                if (age > 25) {
                    System.out.println(user);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
