package com.ioprogramming.csvdatahandling.advancedproblems.generateacsvreport;

import java.io.*;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        // Database connection details (Modify as needed)
        String url = "jdbc:mysql://localhost:3306/company_db"; // database name
        String user = "root"; // username
        String password = "password"; // password
        String csvFile = "employee_report.csv";

        String query = "SELECT id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            // Writing headers to CSV
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Writing data rows
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                // Format CSV row
                writer.write(id + "," + name + "," + department + "," + salary);
                writer.newLine();
            }

            System.out.println("CSV file '" + csvFile + "' has been generated successfully!");

        } catch (SQLException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
