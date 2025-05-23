package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class logProcessing {
    public Map<String, Integer> logLevelCount = new HashMap<>();

    public void processLogs(String dir){

        File folder = new File(dir);
        File[] files = folder.listFiles((dir1, name) -> name.endsWith(".log"));

            for (File file1:files){
                try(BufferedReader br = new BufferedReader(new FileReader(file1))){
                    String line;
                    while ((line = br.readLine())!=null){
                        if (line.contains("INFO")){
                            logLevelCount.merge("INFO",1,Integer::sum);
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

    }
}
