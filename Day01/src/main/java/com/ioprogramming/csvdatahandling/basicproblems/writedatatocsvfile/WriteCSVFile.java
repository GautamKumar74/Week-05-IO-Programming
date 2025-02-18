package com.ioprogramming.csvdatahandling.basicproblems.writedatatocsvfile;

import java.io.*;
public class WriteCSVFile {
    public static void main(String[] args) {
        String filePath= "src/main/resources/employees.csv";

        String[] employees = {
                "101,John Doe,Engineering,75000",
                "102,Jane Smith,Marketing,68000",
                "103,Emily Johnson,HR,72000",
                "104,Michael Brown,Finance,80000",
                "105,David Wilson,IT,77000"
        };

        try( BufferedWriter writer= new BufferedWriter(new FileWriter(filePath))){
            writer.write("ID,Name,Department,Salary");
            writer.newLine();

            for (String emp: employees){
                writer.write(emp);
                writer.newLine();
            }

            System.out.println("CSV file written successfully: " + filePath);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
