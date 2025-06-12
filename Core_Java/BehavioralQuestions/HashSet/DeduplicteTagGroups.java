package com.Collections.BehavioralQuestions.HashSet;

import java.util.*;

public class DeduplicteTagGroups {
    public static void main(String[] args) {
        List<List<String>> tagGroups = List.of(
                List.of("Java", "Spring", "API"),
                List.of("api", "Spring", "java"),
                List.of("Python", "AI"),
                List.of("ai", "PYTHON")
        );

        Map<Set<String>,List<String>> normalizedMap = new LinkedHashMap<>();

        for(List<String> group: tagGroups){
            Set<String> normalizedSet = new HashSet<>();
            for (String tag:group){
                normalizedSet.add(tag.toLowerCase());
            }
            normalizedMap.putIfAbsent(normalizedSet, group);
        }
        List<List<String>> result = new ArrayList<>(normalizedMap.values());

        result.forEach(System.out::println);
    }
}
