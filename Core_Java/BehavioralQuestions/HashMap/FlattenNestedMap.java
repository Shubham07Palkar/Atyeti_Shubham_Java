package com.Collections.BehavioralQuestions.HashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlattenNestedMap {
    public static void main(String[] args) {
        Map<String, List<String>> map = Map.of(
                "India", List.of("Delhi", "Mumbai"),
                "USA", List.of("NYC", "LA"),
                "UK", List.of("London")
        );
        List<String> cities = map.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("All Cities: " + cities);
    }
}
