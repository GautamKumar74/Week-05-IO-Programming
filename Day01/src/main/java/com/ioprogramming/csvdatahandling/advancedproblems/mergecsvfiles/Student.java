package com.ioprogramming.csvdatahandling.advancedproblems.mergecsvfiles;

class Student {
    String id, name;
    int age;
    double marks;
    String grade;

    public Student(String id, String name, int age, double marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}