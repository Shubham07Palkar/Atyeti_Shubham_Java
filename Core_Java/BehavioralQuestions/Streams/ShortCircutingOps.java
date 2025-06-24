package com.Collections.BehavioralQuestions.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShortCircutingOps {
    public static void main(String[] args) {
        int[] largeArray = IntStream.range(1, 10_000_000).toArray();

        boolean result = Arrays.stream(largeArray).peek(y-> System.out.println("Checking.."+y))
                .anyMatch(i -> i==3);
            //streams short-circuits when 3 is found stops earlier boosting performance
        System.out.println(result);

        findFirstDemo();
        limitDemo();
    }

    private static void limitDemo() {
        int[] largeArray = IntStream.rangeClosed(1,100).toArray();

        List<Integer> firstFive = Arrays.stream(largeArray).boxed()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(firstFive);
    }

    private static void findFirstDemo() {
        int[] largeArray = IntStream.range(1, 1000).toArray();

        int firstEven = IntStream.of(largeArray)
                .filter(i-> i%2==0)
                .findFirst()
                .orElse(-1);

        System.out.println(firstEven);
    }

}
