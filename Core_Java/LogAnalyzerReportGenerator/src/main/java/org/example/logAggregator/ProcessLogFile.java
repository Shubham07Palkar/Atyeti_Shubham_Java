package org.example.logAggregator;

import org.example.logger.ErrorLogger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcessLogFile {
    private ErrorLogger errorLogger = new ErrorLogger();
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    public Map<String, Integer> logCountMap = new HashMap<>();
    public Map<String, AtomicInteger> logsCountMap = new ConcurrentHashMap<>();

public void logProcessor(String fileDirectory){
    File folder = new File(fileDirectory);
    File[] files = folder.listFiles((dir,name)-> name.endsWith(".log")||name.endsWith(".txt"));
    for (File file:files){
        executorService.submit(()-> readAndAggregate(String.valueOf(file)));
    }
    executorService.shutdown();
    try {
        if(!executorService.awaitTermination(60, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

    public synchronized void readAndAggregate(String file){
//        File folder = new File(fileDirectory);
//        File[] files = folder.listFiles((dir,name)-> name.endsWith(".log"));
//        for (File file:files){
            try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine())!=null){
                    if(line.contains("INFO")){
                        logsCountMap.computeIfAbsent("INFO",k-> new AtomicInteger(0)).incrementAndGet();
//                        logCountMap.merge("INFO",1,Integer::sum);
                    } else if (line.contains("WARNING")) {
                        logsCountMap.computeIfAbsent("WARNING",k-> new AtomicInteger(0)).incrementAndGet();
//                        logCountMap.merge("WARNING",1,Integer::sum);
                    }else if (line.contains("ERROR")){
                        logsCountMap.computeIfAbsent("ERROR",k->new AtomicInteger(0)).incrementAndGet();
//                        logCountMap.merge("ERROR", 1, Integer::sum);
                    }
                }
            } catch (FileNotFoundException e) {
               errorLogger.errorLog("File not found."+ e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//        }
    }

    public Map<String, AtomicInteger> getLogCountMap(){
        return logsCountMap;
    }
}
