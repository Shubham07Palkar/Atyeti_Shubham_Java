package com.Collections.BehavioralQuestions.PipelineDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class PipelineExecutor {
    private List<Pipe> stages = new ArrayList<>();

    public PipelineExecutor addStage(Pipe stage){
        stages.add(stage);
        return this;
    }

    public String execute(String input){
        String result = input;
        for(Pipe stage:stages){
           result = stage.process(result);
        }
        return result;
    }
}
