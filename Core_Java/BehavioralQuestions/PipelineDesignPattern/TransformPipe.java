package com.Collections.BehavioralQuestions.PipelineDesignPattern;

public class TransformPipe implements Pipe{

    @Override
    public String process(String input) {
        //Transforming
        return input.toUpperCase();
    }
}

