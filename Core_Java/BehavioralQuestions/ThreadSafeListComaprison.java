package com.Collections.BehavioralQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeListComaprison {
    public static void main(String[] args) {
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList cowList = new CopyOnWriteArrayList<>();

        Runnable task1 = ()->{
          for (int i = 0; i<5; i++){
              syncList.add("Sync-" + i);
              cowList.add("Cow" + i);
          }
        };

        Runnable task2 = () ->{
            for(String s: syncList){
                System.out.println("Reading From syncList: "+ s);
            }
            for(Object s: cowList){
                System.out.println("Reading from cowList: "+ s);
            }
        };

        Thread writer = new Thread(task1);
        Thread reader = new Thread(task2);

        writer.start();
        reader.start();

        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
