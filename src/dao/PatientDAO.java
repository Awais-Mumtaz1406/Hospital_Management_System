package src.dao;


import src.models.Patient;
import src.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    //  Add a new patient to the database
    public void addPatient(Patient patient) {
        String sql = "INSERT INTO patients(name, age, gender, phone) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, patient.getName());
                stmt.setInt(2, patient.getAge());
                stmt.setString(3, patient.getGender());
                stmt.setString(4, patient.getPhone());

                stmt.executeUpdate();
                System.out.println("✅Patient added successfully!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  Get all patients
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";

        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Patient p = new Patient();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setAge(rs.getInt("age"));
                    p.setGender(rs.getString("gender"));
                    p.setPhone(rs.getString("phone"));
                    patients.add(p);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }

    //Get a patient by id
    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE id = ?";

        Patient patient = null;
        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Database connection failed!");
                return null;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        patient = new Patient();
                        patient.setId(rs.getInt("id"));
                        patient.setName(rs.getString("name"));
                        patient.setAge(rs.getInt("age"));
                        patient.setGender(rs.getString("gender"));
                        patient.setPhone(rs.getString("phone"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patient;
    }

    //Update Patient info
    public boolean updateDoctor(Patient patient) {
        String sql = "UPDATE patients SET name = ?, age = ?, gender = ?, phone = ? WHERE id = ?";
        boolean updated = false;

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Database connection failed!");
                return false;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, patient.getName());
                stmt.setInt(2, patient.getAge());
                stmt.setString(3, patient.getGender());
                stmt.setString(4,patient.getPhone());
                stmt.setInt(5, patient.getId());

                int affectedRows = stmt.executeUpdate();
                updated = affectedRows > 0;

                if (updated) {
                    System.out.println("Patient updated successfully.");
                } else {
                    System.out.println("Patient not found with ID: " + patient.getId());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

}
