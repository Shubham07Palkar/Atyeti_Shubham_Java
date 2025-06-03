package org.example;

import org.example.db.DBManager;
import org.example.logAggregator.ProcessLogFile;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        try {
            String dir = "log";
            String towriteFile = "log/CopiedLogs";
            String zipDir = "ZipLogs.zip";

            DBManager manager = new DBManager();
            ProcessLogFile processLogFile = new ProcessLogFile();

            processLogFile.logProcessor(dir);
            manager.logData(processLogFile.getLogCountMap());

//          LogsWriter.writeLogs(dir, towriteFile);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}