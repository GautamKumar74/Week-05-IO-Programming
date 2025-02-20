package com.ioprogramming.jsondata.handsonpracticeproblems.convertlistofjavaobjectsintojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ConvertListToJson {
    public static void main(String[] args) {
        try {
            // Create a list of Car objects
            List<Car> cars = Arrays.asList(
                    new Car("Toyota", "Camry", 2020),
                    new Car("Honda", "Civic", 2019),
                    new Car("Ford", "Mustang", 2021)
            );

            // Convert List to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(cars);

            // Print JSON array
            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
