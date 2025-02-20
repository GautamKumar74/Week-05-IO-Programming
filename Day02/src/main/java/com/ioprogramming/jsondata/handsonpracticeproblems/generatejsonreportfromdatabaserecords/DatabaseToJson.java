package com.ioprogramming.jsondata.handsonpracticeproblems.generatejsonreportfromdatabaserecords;

import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DatabaseToJson {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "root";
        String password = "your_password";

        String query = "SELECT id, name, email, age FROM users"; // Modify table & columns

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            List<Map<String, Object>> userList = new ArrayList<>();

            while (rs.next()) {
                Map<String, Object> userMap = new HashMap<>();
                userMap.put("id", rs.getInt("id"));
                userMap.put("name", rs.getString("name"));
                userMap.put("email", rs.getString("email"));
                userMap.put("age", rs.getInt("age"));

                userList.add(userMap);
            }

            // Convert List to JSON
            ObjectMapper mapper = new ObjectMapper();
            String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userList);

            // Save JSON to a file
            try (FileWriter file = new FileWriter("src/main/resources/user_report.json")) {
                file.write(jsonOutput);
                System.out.println("JSON report generated successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
