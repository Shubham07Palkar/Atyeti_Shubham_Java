package org.example.reader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ProcessLogFile {
    public Map<String, Integer> logCountMap = new HashMap<>();

    public void readAndAggregate(String fileDirectory){
        File folder = new File(fileDirectory);
        File[] files = folder.listFiles((dir,name)-> name.endsWith(".log"));
        for (File file:files){
            try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine())!=null){
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
