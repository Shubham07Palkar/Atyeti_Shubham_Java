package com.Collections.BehavioralQuestions.Streams;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class TaskScheduler {
    public static void main(String[] args) {
        String[] workers = {"A", "B", "C"};

        AtomicInteger taskCounter = new AtomicInteger(1);

        Stream.generate(() -> taskCounter.getAndIncrement())
                .map(taskId -> {
                    String assignedWorker = workers[(taskId-1)% workers.length];
                    return "Task-"+taskId+"-> Worker-"+assignedWorker;
                })
                .skip(3)
                .limit(7)
                .forEach(System.out::println);
    }
}
