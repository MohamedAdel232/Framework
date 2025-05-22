package Utilities;

import java.sql.*;

public class DataBaseUtils {

    private static final String DB_URL = "jdbc:postgresql://192.168.2.97:5432/icode-tfs";
    private static final String USER = "postgres";
    private static final String PASS = "P@ssw0rd@Lotus";

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
        String query = "SELECT id, username FROM users";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id") +
                        ", Username: " + rs.getString("username"));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Better for debugging
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
