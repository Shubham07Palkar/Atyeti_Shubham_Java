package com.Collections.BehavioralQuestions.ExceptionHandling;

public class ExceptionMaskingDemo {
    public static void main(String[] args) {
        try {
            methodWithExceptionMasking();
        }catch(Exception e){
            System.out.println("Caught exception: "+ e.getClass().getSimpleName()+" "+e.getMessage());
        }finally {
            System.out.println("Main finally block Executed");
        }
    }

    static void methodWithExceptionMasking() throws Exception {
        Exception primaryException = null;

        try {
            System.out.println("Inside try Block");
            throw new RuntimeException("Exception from try catch Block");
        }catch (RuntimeException e){
            primaryException = e;
            throw e;
        }finally {
            System.out.println("Inside Finaly block");
            Exception finallyException = new IllegalStateException("Exception from finnaly block");

            if(primaryException !=null){
                primaryException.addSuppressed(finallyException);
            }else {
                throw finallyException;
            }

        }
    }
}
