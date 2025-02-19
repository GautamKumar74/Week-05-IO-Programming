package com.ioprogramming.jsondata.practiceproblems.ConvertlistofJavaobjectsintojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ConvertListToJson {
    public static void main(String[] args) {
        try{
            List<Car> cars= Arrays.asList(
                    new Car("Toyota", "Camry", 2022),
                    new Car("Honda", "Civic", 2021),
                    new Car("Ford", "Mustang", 2023)
            );

            ObjectMapper objectMapper= new ObjectMapper();
            String jsonArray= objectMapper.writeValueAsString(cars);

            System.out.println("JSON Array:\n" + jsonArray);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
