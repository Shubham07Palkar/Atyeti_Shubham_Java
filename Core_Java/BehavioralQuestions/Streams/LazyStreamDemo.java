package com.Collections.BehavioralQuestions.Streams;

import java.util.Arrays;
import java.util.List;

public class LazyStreamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Apple", "Bank Of America", "Citi Bank", "Dutsche Bank");

        names.stream()
                .peek(name -> System.out.println("Peeked "+ name))
                .filter(name -> name.startsWith("C"))
                .map(String::toUpperCase);

        System.out.println("Stream pipeline created, but no terminal operation yet.");
    }
}
