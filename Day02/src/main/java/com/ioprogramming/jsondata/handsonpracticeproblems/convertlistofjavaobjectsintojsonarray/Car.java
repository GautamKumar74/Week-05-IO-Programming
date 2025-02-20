package com.ioprogramming.jsondata.handsonpracticeproblems.convertlistofjavaobjectsintojsonarray;

public class Car {
    private String brand;
    private String model;
    private int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters (Jackson requires getters to serialize objects)
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}
