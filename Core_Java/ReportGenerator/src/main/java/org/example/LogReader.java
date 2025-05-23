package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LogReader {
    private final Map<String,Integer> logLevelCount = new HashMap<>();
    
    public void processLogs(String directoryPath){
        try{
            Files.list(Paths.get(directoryPath))
                    .filter(path -> path.toString().endsWith(".log"))
                    .forEach(this::readFile);
        }catch (IOException e){
            System.out.println("Directory reading failed" + e.getMessage());
        }
    }

    private void readFile(Path filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(filePath)))) {
            String line;
            while((line = reader.readLine())!=null){
                processLine(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ; 
    }

    private void processLine(String line) {
        if(line.contains("INFO")){
            String message = extractMessage(line);
            logLevelCount.merge(("INFO : "+message), 1, Integer::sum);
        } else if (line.contains("WARNING")) {
            String message = extractMessage(line);
            logLevelCount.merge(("WARNING: "+message), 1, Integer::sum);
        }else if (line.contains("ERROR")){
            String message = extractMessage(line);
            logLevelCount.merge(("ERROR: "+message),1, Integer::sum);
        }
    }

    public String extractMessage(String line){
        int idxStart = line.indexOf("[");
        int idxEnd = line.indexOf("]");
        if(idxStart!=-1 && idxEnd != -1 && idxEnd>idxStart){
            return line.substring(idxStart + 1, idxEnd);
        }
        return "fail";
    }

    public Map<String,Integer> getLogLevelCount(){
        return logLevelCount;
    }
}
