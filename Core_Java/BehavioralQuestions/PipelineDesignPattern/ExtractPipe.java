package com.Collections.BehavioralQuestions.PipelineDesignPattern;

public class ExtractPipe implements Pipe{

    public String process(String input) {
        //Extracting
       return input!=null?input.trim():"";
    }
}

