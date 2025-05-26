package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/logAnalyzerDb";
    private static final String USERNAME= "springstudent";
    private static final String PASSWORD = "springstudent";

    public void logData(Map<String, AtomicInteger> logData) throws SQLException {
        String query ="INSERT INTO logs_analyzer(timestamp, error_count, warn_count, info_count) VALUES (?,?,?,?)";
        Connection connection= DriverManager.getConnection(URL,USERNAME, PASSWORD);
        System.out.println("Connection Established");

        LocalDateTime localDateTime = LocalDateTime.now();
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(localDateTime));
        statement.setInt(2,logData.get("ERROR").get());
        statement.setInt(3,logData.get("WARNING").get());
        statement.setInt(4,logData.get("INFO").get());

        statement.executeUpdate();
    }

}
