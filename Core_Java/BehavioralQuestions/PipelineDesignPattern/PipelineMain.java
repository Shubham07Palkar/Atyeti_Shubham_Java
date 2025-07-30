package com.Collections.BehavioralQuestions.PipelineDesignPattern;

public class PipelineMain {
    public static void main(String[] args) {
        PipelineExecutor etlPipeline = new PipelineExecutor();
        etlPipeline
                .addStage(new ExtractPipe())
                .addStage(new TransformPipe())
                .addStage(new LoadPipe());

        String rawData = "   some Raw input  ";
        etlPipeline.execute(rawData);
    }

}
