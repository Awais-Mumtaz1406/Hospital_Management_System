package src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver"); // <-- Add this line for PostgreSQL driver
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/hospital",  // database URL
                        "junaid",                                      // your username
                        "77335566"                                     // your password
                );
                System.out.println("PostgreSQL Database Connected Successfully");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database Connection Closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
