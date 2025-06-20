package com.Collections.BehavioralQuestions.Streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsWithDuplicateKeys {
    public static void main(String[] args) {
        List<String> words = List.of("Apple", "Banana", "Apple");

        Map<String, Integer> wordMap = words.stream().collect(Collectors.toMap(
                word -> word,
                word -> 1,
                Integer::sum
        ));//will throw duplicate key exception coz
        // by default .toMap doesn’t allow duplicate keys.

        System.out.println(wordMap);
    }
}
