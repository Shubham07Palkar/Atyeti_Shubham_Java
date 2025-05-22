package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class LogDBSaver {
    private static final String URL = "logsdb";
    private static final String USER = "springstudent";
    private static final String PASSWORD = "springstudent";

    public void saveLogData(Map<String, Integer> logData) {
        String query = "INSERT INTO error_logs(error_message, frequency) VALUES (?,?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            for (Map.Entry<String, Integer> entry : logData.entrySet()) {
                System.out.println("");
                stmt.setString(1, entry.getKey());
                stmt.setInt(2, entry.getValue());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}