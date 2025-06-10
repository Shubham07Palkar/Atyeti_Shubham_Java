package com.Collections.BehavioralQuestions.HashSet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FailfastDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> integers = Collections.synchronizedSet(set);
        for (int i = 0; i < 5; i++) {
            integers.add(i);
        }

        Thread reader = new Thread(() -> {
            try {
                synchronized (integers) {
                    Iterator<Integer> it = integers.iterator();
                    while (it.hasNext()) {
                        System.out.println("Read " + it.next());
                        Thread.sleep(100);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Reader Caught: " + e);
            }
        });

        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(200);
                integers.add(99);
                System.out.println("Writer added 99");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        reader.start();
        writer.start();
    }
}
