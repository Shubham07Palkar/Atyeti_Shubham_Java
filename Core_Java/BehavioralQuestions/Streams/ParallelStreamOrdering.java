package com.Collections.BehavioralQuestions.Streams;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamOrdering {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,2,1,4,5,6,7,8,9);

        System.out.println("Using forEach() with parallel stream: ");
        numbers.parallelStream()
                .forEach(n -> System.out.println(n+" "));

        System.out.println("\nUsing forEachOrdered() with parallel stream: ");
        numbers.parallelStream()
                .forEachOrdered(n-> System.out.println(n+" "));

//        preserves encounter order — but sacrifices performance

    }
}
