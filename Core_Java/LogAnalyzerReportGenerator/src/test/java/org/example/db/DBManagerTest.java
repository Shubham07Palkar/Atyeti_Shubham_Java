package org.example.db;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.AnnotatedType;
import java.sql.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Class.forName;
import static org.junit.jupiter.api.Assertions.*;

class DBManagerTest {
    @Mock
    private static DBManager dbManager;
    private static Connection connection;

    @BeforeAll
    static void setupDatabase() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbManager = new DBManager();
        connection = DriverManager.getConnection(dbManager.URL, dbManager.USERNAME, dbManager.PASSWORD);
    }

    @Test
    void testLogDataThrowsSQLException(){
        DBManager manager =  new DBManager(){
            @Override
            public void logData(Map<String, AtomicInteger> logData) throws SQLException {
                DriverManager.getConnection("jdbc:mysql://invalid-url","User", "pass");
            }
        };
        Map<String, AtomicInteger> counts = new ConcurrentHashMap<>();
        counts.put("INFO", new AtomicInteger(8));
        counts.put("WARNING", new AtomicInteger(3));
        counts.put("ERROR", new AtomicInteger(3));

        assertThrows(SQLException.class,()-> manager.logData(counts));
    }


    @Test
    void logData() throws SQLException {

        Map<String, AtomicInteger> counts = new ConcurrentHashMap<>();
        counts.put("INFO", new AtomicInteger(8));
        counts.put("WARNING", new AtomicInteger(3));
        counts.put("ERROR", new AtomicInteger(3));

        dbManager.logData(counts);

        String query = "SELECT * FROM logs_analyzer";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            assertTrue(rs.next(), "No data inserted into the database");

            assertEquals(3, rs.getInt("warn_count"));
            assertEquals(3, rs.getInt("error_count"));
            assertEquals(8, rs.getInt("info_count"));
        }
    }


    @AfterAll
    static void closeConnection() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}