package com.ioprogramming.csvdatahandling.advancedproblems.encryptanddecrypt;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class EncryptDecryptCSV {
    private static final String CSV_FILE = "src/main/resources/employees.csv";
    private static final String DECRYPTED_CSV_FILE = "src/main/resources/decrypted_employees.csv";

    public static void main(String[] args) {
        try {
            // Write Encrypted Data to CSV
            writeEncryptedCSV();

            // Read and Decrypt Data from CSV
            readAndDecryptCSV();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Writing Encrypted Data to CSV
    public static void writeEncryptedCSV() throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE));
             CSVWriter csvWriter = new CSVWriter(writer)) {

            // Header
            csvWriter.writeNext(new String[]{"ID", "Name", "Department", "Salary", "Email"});

            // Employee Data (Encrypting Salary & Email)
            String[][] employees = {
                    {"1", "Alice", "HR", AESUtil.encrypt("50000"), AESUtil.encrypt("alice@example.com")},
                    {"2", "Bob", "IT", AESUtil.encrypt("75000"), AESUtil.encrypt("bob@example.com")},
                    {"3", "Charlie", "Finance", AESUtil.encrypt("60000"), AESUtil.encrypt("charlie@example.com")}
            };

            for (String[] employee : employees) {
                csvWriter.writeNext(employee);
            }
            System.out.println("✅ Encrypted data written to CSV.");
        }
    }

    // Reading & Decrypting CSV Data
    public static void readAndDecryptCSV() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE));
             CSVReader csvReader = new CSVReader(reader);
             BufferedWriter writer = new BufferedWriter(new FileWriter(DECRYPTED_CSV_FILE));
             CSVWriter csvWriter = new CSVWriter(writer)) {

            String[] nextRecord;
            csvWriter.writeNext(new String[]{"ID", "Name", "Department", "Salary", "Email"}); // Write header

            csvReader.readNext(); // Skip header
            while ((nextRecord = csvReader.readNext()) != null) {
                // Decrypt sensitive fields
                nextRecord[3] = AESUtil.decrypt(nextRecord[3]); // Decrypt Salary
                nextRecord[4] = AESUtil.decrypt(nextRecord[4]); // Decrypt Email

                csvWriter.writeNext(nextRecord);
                System.out.println("Decrypted: " + String.join(", ", nextRecord));
            }
            System.out.println("Decrypted data written to new CSV file.");
        }
    }
}