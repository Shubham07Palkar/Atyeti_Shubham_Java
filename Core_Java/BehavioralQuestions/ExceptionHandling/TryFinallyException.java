package com.Collections.BehavioralQuestions.ExceptionHandling;

public class TryFinallyException {
    public static void main(String[] args) {
        riskyoperation();
    }

    private static void riskyoperation() {
        try {
            System.out.println("In a try block");
            throw new RuntimeException("From Try Block");
        }finally {
            System.out.println("In a finally Block");
            throw new RuntimeException("Exception From Finally");
        }
    }
}
