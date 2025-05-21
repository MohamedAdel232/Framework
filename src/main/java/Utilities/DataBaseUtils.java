package Utilities;

import java.sql.*;

public class DataBaseUtils {

    private static final String DB_URL = "jdbc:postgresql://192.168.1.50:5432/your_database";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    private static Connection connection = null;

    // Establish connection
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

    // Example: Fetch test data
    public static void fetchTestData() {
        String query = "SELECT * FROM test_data LIMIT 10";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
    }

    // Close connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Closing connection failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        fetchTestData();
        closeConnection();
    }
}
