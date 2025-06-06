package com.Collections.BehavioralQuestions.HashMap;

public class ConcurrentHashMap {
    static java.util.concurrent.ConcurrentHashMap<String, Integer> cache = new java.util.concurrent.ConcurrentHashMap<>();

    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            int result = cache.computeIfAbsent("Key", k->{
                System.out.println(threadName + " Computing...");
                return 42;
            });
            System.out.println(threadName + " got: "+result);
        };
        new Thread(task).start();
        new Thread(task).start();
    }
}
