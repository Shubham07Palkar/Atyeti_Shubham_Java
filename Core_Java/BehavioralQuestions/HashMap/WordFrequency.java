package com.Collections.BehavioralQuestions.HashMap;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        List<String> words = List.of("Apple", "Banana", "Apple", "Orange", "Banana", "Apple");

        Map<String, Long> freq = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
        System.out.println(freq);
    }

}
