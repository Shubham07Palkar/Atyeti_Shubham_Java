package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/logAnalyzerDb";
    private static final String USERNAME= "springstudent";
    private static final String PASSWORD = "springstudent";

    public static void logData(Map<String, Integer> logData) throws SQLException {
        String query ="INSERT INTO logs_analyzer(timestamp, error_count, warn_count, info_count) VALUES (?,?,?,?)";
        Connection connection= DriverManager.getConnection(URL,USERNAME, PASSWORD);
        System.out.println("Connection Established");
//        PreparedStatement statement = connection.prepareStatement(query);
//
//        statement.executeUpdate();
    }

}
