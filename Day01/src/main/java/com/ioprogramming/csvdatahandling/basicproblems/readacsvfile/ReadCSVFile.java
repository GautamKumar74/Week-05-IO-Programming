package com.ioprogramming.csvdatahandling.basicproblems.readacsvfile;

import java.io.*;
import java.util.*;

public class ReadCSVFile {
    public static void main(String[] args) {
        String filePath= "src/main/resources/employees.csv";
        try(BufferedReader br= new BufferedReader(new FileReader(filePath))){
            String line;

            while ((line= br.readLine()) != null){
                String[] columns= line.split(",");
                System.out.println("ID: " + columns[0] + ", Name:" + columns[1]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
