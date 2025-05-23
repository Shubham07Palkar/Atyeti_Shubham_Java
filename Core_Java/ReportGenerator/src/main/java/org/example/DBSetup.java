package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSetup {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "springstudent";
        String password = "springstudent";

        try {
            //establishing connection
            Connection conn = DriverManager.getConnection(url,username, password);

            //create statement
            Statement stmt = conn.createStatement();

            //execute query

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
