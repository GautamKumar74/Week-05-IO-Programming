package com.ioprogramming.csvdatahandling.intermediateproblems.sortcsvrecords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortCSVRecords {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employees.csv";
        List<Employee> employees = new ArrayList<>();

        // Read CSV file and store records
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split CSV line into fields
                String[] fields = line.split(",");
                if (fields.length < 4) continue; // Skip if data is incomplete

                // Create Employee object
                Employee emp = new Employee(fields[0].trim(), fields[1].trim(), fields[2].trim(),
                        Double.parseDouble(fields[3].trim()));
                employees.add(emp);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort employees by salary in descending order
        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        // Print top 5 highest-paid employees
        System.out.println("Top 5 Highest-Paid Employees:");
        System.out.println("ID\tName\t\tDepartment\tSalary");

        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee emp = employees.get(i);
            System.out.println(emp.id + "\t" + emp.name + "\t" + emp.department + "\t" + emp.salary);
        }
    }
}