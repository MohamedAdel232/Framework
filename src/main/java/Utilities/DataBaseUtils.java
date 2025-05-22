package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtils {

    private static String DB_URL;
    private static String USER;
    private static String PASS;

    private static Connection connection = null;

    // Set DB connection parameters dynamically
    public static void configure(String dbUrl, String user, String password) {
        DB_URL = dbUrl;
        USER = user;
        PASS = password;
    }
    
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            }
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }

    // SELECT query - returns list of rows (each row is a list of column values)
    public static List<List<Object>> executeSelect(String query) {
        List<List<Object>> results = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                results.add(row);
            }

        } catch (SQLException e) {
            LogsUtils.error("Error executing select: " + e.getMessage());
        }
        return results;
    }

    // INSERT, UPDATE, DELETE queries
    public static int executeUpdate(String query) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            LogsUtils.error("Error executing update: " + e.getMessage());
            return -1;
        }
    }


    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                LogsUtils.info("Database connection closed successfully.");
            }
        } catch (SQLException e) {
            LogsUtils.error("Failed to close database connection: " + e.getMessage());
        }
    }
}
