package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/loganalysisdb";
    private static final String USERNAME = "springstudent";
    private static final String PASSWORD = "springstudent";

    public void saveLog(Map<String, Integer> logData) throws SQLException {
        String query = "INSERT INTO logs_count(timestamp, error_count, warning_count, info_count) VALUES (?,?,?,?)";

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            PreparedStatement ps = connection.prepareStatement(query)){
            LocalDateTime date = LocalDateTime.now();

                ps.setString(1, String.valueOf(date));
                ps.setInt(2,logData.get("ERROR"));
                ps.setInt(3,logData.get("WARNING"));
                ps.setInt(4,logData.get("INFO"));
                ps.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
