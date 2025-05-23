package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LogsProcessorAggregator {
    public Map<String, Integer> logLevelCount = new HashMap<>();

    public void processLogs(String directoryPath){
        try {
            Files.list(Paths.get(directoryPath))
                    .filter(path -> path.toString()
                            .endsWith(".log"))
                    .forEach(filePath -> {
                        try {
                            readFile(filePath);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFile(Path filePath) throws IOException {
        try(BufferedReader brw = new BufferedReader(new FileReader(String.valueOf(filePath)))) {
            String line;
            while((line = brw.readLine())!=null){
                if(line.contains("INFO")){
                    logLevelCount.merge("INFO",1,Integer::sum);
                } else if (line.contains("WARNING")) {
                    logLevelCount.merge("WARNING", 1, Integer::sum);
                } else if (line.contains("ERROR")) {
                    logLevelCount.merge("ERROR", 1, Integer::sum);
                }
            }
        } catch (FileNotFoundException e) {
            ErrorLogger.log("File not found :");
        } catch (IOException e) {
            ErrorLogger.log("Failed to read file :");
        }
    }

    public Map<String, Integer> getLogLevelCount(){
        return logLevelCount;
    }
}
