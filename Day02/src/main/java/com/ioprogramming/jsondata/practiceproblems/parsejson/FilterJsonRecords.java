package com.ioprogramming.jsondata.practiceproblems.parsejson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FilterJsonRecords {
    public static void main(String[] args) {
        try {
            String path= "src/main/resources/persons.json";
            // Load JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            List<Person> persons = objectMapper.readValue(new File(path), new TypeReference<List<Person>>() {});

            // Filter records where age > 25
            List<Person> filteredPersons = persons.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            // Print filtered records
            System.out.println("Filtered Persons (Age > 25):");
            filteredPersons.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
