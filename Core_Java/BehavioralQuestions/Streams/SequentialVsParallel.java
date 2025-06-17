package com.Collections.BehavioralQuestions.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequentialVsParallel {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1,10_00_000)
                .boxed()
                .collect(Collectors.toList());

        long start = System.currentTimeMillis();

        long sum = numbers.stream().mapToLong(n->n*2)
                .sum();

        System.out.println("sequential Sum: "+sum);
        System.out.println("Time: "+(System.currentTimeMillis()-start)+"ms");

        long newstart = System.currentTimeMillis();

        long sumOfNums = numbers.parallelStream()
                .mapToLong(n-> n*2)
                .sum();
        System.out.println("Parallel sum: "+sumOfNums);
        System.out.println("Time: "+(System.currentTimeMillis()-newstart)+"ms");
    }
}
