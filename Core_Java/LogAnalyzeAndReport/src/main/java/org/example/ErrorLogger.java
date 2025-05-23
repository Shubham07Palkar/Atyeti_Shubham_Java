package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ErrorLogger {
    private static final String Error_LOG_FILE = "error_logs.txt";

    public static void log(String message) throws IOException {
        try(FileWriter fw = new FileWriter(Error_LOG_FILE,true)){
            fw.write(LocalDateTime.now()+" - "+message+"\n");
        }catch (IOException e){
            System.out.println("unable to log error: "+e.getMessage());
        }
    }
}
