package com.ioprogramming.jsondata.practiceproblems.createjsonobject;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJSON {
    public static void main(String[] args) {
        JSONObject jsonObject= new JSONObject();

        jsonObject.put("name", "John Doe");
        jsonObject.put("age", 20);

        JSONArray subjects= new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Physics");
        subjects.put("Computer Science");

        jsonObject.put("subjects",subjects);

        System.out.println(jsonObject.toString(4));
    }
}
