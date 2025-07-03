package com.Collections.BehavioralQuestions.MultiThreadingAndConcurrency;
class PrintTask extends Thread{
    private String message;

    public PrintTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("From Thread: "+message);
    }
}

public class ThreadOrderTest {
    public static void main(String[] args) {
       PrintTask task1 = new PrintTask("A");
       PrintTask task2 = new PrintTask("B");
       PrintTask task3 = new PrintTask("C");

       task1.start();
       task2.start();
       task3.start();

    }

}
