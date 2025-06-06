package com.Collections.BehavioralQuestions.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByInitial {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Arjun", "Bob", "Benny", "Charlie");

        Map<Character, List<String>> grouped = new HashMap<>();

        for(String name : names ){
            char initial = name.charAt(0);
            grouped.computeIfAbsent(initial, k -> new ArrayList<>()).add(name);
        }

        grouped.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
