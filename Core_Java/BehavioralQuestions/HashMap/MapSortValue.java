package com.Collections.BehavioralQuestions.HashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortValue {
    public static void main(String[] args) {
        Map<String, Integer> scores = Map.of(
                "Apple", 85,
                "Blog", 75,
                "charlie", 90,
                "David", 70);


        Map<String, Integer> sortedAsc = scores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));
        System.out.println("Sorted Acsending: " + sortedAsc);

        Map<String, Integer> sortedDesc = scores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));
        System.out.println("sorted Descending: "+sortedDesc);
    }
}
