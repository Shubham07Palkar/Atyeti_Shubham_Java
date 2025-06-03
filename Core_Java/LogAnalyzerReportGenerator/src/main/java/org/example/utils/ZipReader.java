package org.example.utils;

import org.example.logAggregator.ProcessLogFile;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipReader {

    public static void readZipFile(String zipFilePath) {
        ProcessLogFile processLogFile = new ProcessLogFile();
        try {
            InputStream input = new FileInputStream(zipFilePath);
            ZipInputStream zip = new ZipInputStream(input);
            ZipEntry entry = zip.getNextEntry();
            processLogFile.readAndAggregate(String.valueOf(entry));

//            while (entry != null) {
//                if (entry.getName().endsWith(".txt")
//                        || entry.getName().endsWith(".log") || entry.getName().endsWith(".docx")
//                ) {
////                    processLogFile.readAndAggregate(String.valueOf(entry));
//                }
//
//            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
