package com.Collections.BehavioralQuestions.MultiThreadingAndConcurrency;

import java.util.Collections;

class Counter {
    int count=0;

    synchronized void increment(){
        count++;
    }
}

class CounterTask extends Thread{
    Counter counter;

    public CounterTask(Counter counter){
        this.counter=counter;
    }


    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            counter.increment();
        }
    }
}


public class SharedResource {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterTask task1 = new CounterTask(counter);
        CounterTask task2 = new CounterTask(counter);

        task1.start();
        task2.start();

        task1.join();
        task2.join();

        System.out.println("Final Output: "+counter.count);

    }
}
