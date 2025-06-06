package com.Collections.BehavioralQuestions.HashMap;

import java.util.HashMap;
import java.util.Map;

public class PutIfAbsent {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Apple", null);

        map.putIfAbsent("Apple","Hello");

        System.out.println("Value :" + map.get("Apple"));
    }
}
