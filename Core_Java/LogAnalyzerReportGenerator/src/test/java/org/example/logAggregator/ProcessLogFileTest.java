package org.example.logAggregator;

import org.example.db.DBManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ProcessLogFileTest {

    @Mock
    ProcessLogFile processLogFile = new ProcessLogFile();
    String sampleFile = "src/main/java/org/example/utils";

    @Test
    void logProcessor() {
        processLogFile.logProcessor(sampleFile);

        Map<String, AtomicInteger> counts = processLogFile.getLogCountMap();
        assertEquals(3,counts.get("WARNING").get());
        assertEquals(3,counts.get("ERROR").get());
        assertEquals(8,counts.get("INFO").get());

    }


}