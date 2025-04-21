package src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String URL = "jdbc:sqlite:hospital.db"; // SQLite file

    public DBConnection() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL)) {
            Statement stmt = conn.createStatement();

            // Create Patients table
            String createPatientsTable = "CREATE TABLE IF NOT EXISTS patients ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name TEXT NOT NULL,"
                    + "age INTEGER NOT NULL,"
                    + "gender TEXT NOT NULL,"
                    + "phone TEXT NOT NULL"
                    + ");";
            stmt.execute(createPatientsTable);

            // Check if Patients table exists
            String checkPatientsTable = "SELECT name FROM sqlite_master WHERE type='table' AND name='patients';";
            ResultSet rs = stmt.executeQuery(checkPatientsTable);
            if (rs.next()) {
                System.out.println("Patients table exists.");
            } else {
                System.out.println("Patients table does not exist.");
            }

            // Create Doctor's table
            String createDoctorsTable = "CREATE TABLE IF NOT EXISTS doctors ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name TEXT NOT NULL,"
                    + "specialization TEXT NOT NULL,"
                    + "phone TEXT NOT NULL,"
                    + "email TEXT NOT NULL,"
                    + "experience INTEGER NOT NULL"
                    + ");";
            stmt.execute(createDoctorsTable);

            // Create Appointments table
            String createAppointmentsTable = "CREATE TABLE IF NOT EXISTS appointments ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "patient_id INTEGER NOT NULL,"
                    + "doctor_id INTEGER NOT NULL,"
                    + "date TEXT NOT NULL,"
                    + "time TEXT NOT NULL,"
                    + "status TEXT NOT NULL,"
                    + "FOREIGN KEY(patient_id) REFERENCES patients(id),"
                    + "FOREIGN KEY(doctor_id) REFERENCES doctors(id)"
                    + ");";
            stmt.execute(createAppointmentsTable);

            System.out.println("Tables created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
