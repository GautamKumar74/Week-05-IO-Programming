package com.ioprogramming.jsondata.handsonpracticeproblems.convertjsontoxmlformat;

import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            // Read JSON file as a String
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/input.json")));

            // Convert JSON String to JSONObject
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Convert JSONObject to XML format
            String xmlContent = XML.toString(jsonObject, "root"); // "root" is the root element

            // Write XML to file
            FileWriter writer = new FileWriter(new File("src/main/resources/output.xml"));
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xmlContent);
            writer.close();

            System.out.println("JSON successfully converted to XML. Check output.xml file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
