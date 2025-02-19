package com.ioprogramming.csvdatahandling.advancedproblems.mergecsvfiles;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "src/main/resources/students1.csv"; // ID, Name, Age
        String file2 = "src/main/resources/students2.csv"; // ID, Marks, Grade
        String outputFile = "src/main/resources/merged_students.csv";

        Map<String, Student> studentMap = new HashMap<>();

        // Read students1.csv (ID, Name, Age)
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length < 3) continue;

                String id = fields[0].trim();
                String name = fields[1].trim();
                int age = Integer.parseInt(fields[2].trim());

                studentMap.put(id, new Student(id, name, age, 0.0, ""));
            }
        } catch (IOException e) {
            System.out.println("Error reading file1: " + e.getMessage());
        }

        // Read students2.csv (ID, Marks, Grade)
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length < 3) continue;

                String id = fields[0].trim();
                double marks = Double.parseDouble(fields[1].trim());
                String grade = fields[2].trim();

                if (studentMap.containsKey(id)) {
                    Student student = studentMap.get(id);
                    student.marks = marks;
                    student.grade = grade;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file2: " + e.getMessage());
        }

        // Write merged data to merged_students.csv
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (Student student : studentMap.values()) {
                bw.write(student.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing merged file: " + e.getMessage());
        }

        System.out.println("Merging completed! Check merged_students.csv");
    }
}