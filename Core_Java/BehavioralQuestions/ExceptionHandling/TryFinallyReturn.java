package com.Collections.BehavioralQuestions.ExceptionHandling;

public class TryFinallyReturn {
    public static void main(String[] args) {
        int result = compute();
        System.out.println(result);
    }

    private static int compute() {
        try {
            System.out.println("In a try Block");
            return 10;
        }finally {
            System.out.println("In a finally Block");
            return 20;
        }
    }
}
