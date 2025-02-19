package com.ioprogramming.jsondata.practiceproblems.convertajavaobject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJson {
    public static void main(String[] args) {
        try{
            Car car= new Car("Toyota","Corolla", 2023);

            ObjectMapper objectMapper= new ObjectMapper();
            String jsonString= objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);

            System.out.println(jsonString);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
