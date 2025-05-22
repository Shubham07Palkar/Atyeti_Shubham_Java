package org.example.writer;

import java.io.*;

public class LogsWriter {
    public static void writeLogs(String fileDirectory, String writerFilePath) throws FileNotFoundException {
        File folder = new File(fileDirectory);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".log"));
        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line=reader.readLine())!=null){
                    try(BufferedWriter wr = new BufferedWriter(new FileWriter(writerFilePath,true))){
                        wr.write(line+"\n");

                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
