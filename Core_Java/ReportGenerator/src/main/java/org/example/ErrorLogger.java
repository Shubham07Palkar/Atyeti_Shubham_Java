package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class ErrorLogger {
    private static final String ERROR_LOG_FILE = "src/main/java/org/example/logging/error_log.txt";

    public static void log(String message){
        try(FileWriter fw = new FileWriter(ERROR_LOG_FILE,true)){
            fw.write((message + "\n"));
        } catch (IOException e) {
            System.out.println("Error Writing to error log: "+ e.getMessage());
        }
    }
}

