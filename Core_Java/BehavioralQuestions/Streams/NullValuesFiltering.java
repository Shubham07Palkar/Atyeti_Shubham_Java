package com.Collections.BehavioralQuestions.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NullValuesFiltering {
    public static void main(String[] args) {
        String[] names = {"Apple", "Microsoft", null, "Google"};

        List<String> nonnull = Arrays.stream(names)
                .filter(name-> name !=  null)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(nonnull);

        // stream handles null if you only guard them  e.g with filter

        List<String> upperNames = Arrays.stream(names)
                .map(String::toUpperCase)  // will give NullPointerException
                .collect(Collectors.toList());

    }
}
