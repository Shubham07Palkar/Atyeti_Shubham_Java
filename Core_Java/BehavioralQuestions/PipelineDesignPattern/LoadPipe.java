package com.Collections.BehavioralQuestions.PipelineDesignPattern;

public class LoadPipe implements Pipe{

    @Override
    public String process(String input) {
        System.out.println("Loaded: "+input);
        return input;
    }
}
