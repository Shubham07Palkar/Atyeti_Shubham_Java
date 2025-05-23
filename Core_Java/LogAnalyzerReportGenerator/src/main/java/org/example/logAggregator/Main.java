package org.example.logAggregator;

import org.example.writer.LogsWriter;
import org.example.db.DBManager;
import org.example.reader.ProcessLogFile;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String dir = "log";
        String towriteFile = "log/CopiedLogs";
        Map<String, Integer> logLevels = new HashMap<>();
        DBManager.logData(logLevels);
        ProcessLogFile processLogFile = new ProcessLogFile();
        processLogFile.readAndAggregate(dir);
        LogsWriter.writeLogs(dir, towriteFile);

    }
}