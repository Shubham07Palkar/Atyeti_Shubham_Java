package org.example.logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ErrorLogger {
    private static final String ERROR_LOG_FILE = "ErrorLogs/Errorlog.txt";

    public void errorLog(String message){
            try(BufferedWriter brw = new BufferedWriter(new FileWriter(ERROR_LOG_FILE,true))) {
                brw.write(LocalDateTime.now()+ "Error: "+ message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
