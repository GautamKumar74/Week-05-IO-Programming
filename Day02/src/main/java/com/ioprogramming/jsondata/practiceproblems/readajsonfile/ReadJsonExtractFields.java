package com.ioprogramming.jsondata.practiceproblems.readajsonfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadJsonExtractFields {
    public static void main(String[] args) {
        try{
            String path= "src/main/resources/data.json";

            ObjectMapper objectMapper= new ObjectMapper();

            JsonNode rootNode= objectMapper.readTree(new File(path));

            String name= rootNode.get("name").asText();
            String email= rootNode.get("email").asText();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
