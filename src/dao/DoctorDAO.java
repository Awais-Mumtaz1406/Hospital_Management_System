package src.dao;

import src.models.Doctor;
import src.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DoctorDAO {
    //Add a new doctor to a database
    public void addDoctor(Doctor doctor){
        String sql = "INSERT INTO doctors(name,specialization,phone,email,experience) VALUES(?,?,?,?,?)";
        try(Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try(PreparedStatement stmt = conn.prepareStatement(sql)){

                stmt.setString(1, doctor.getName());
                stmt.setString(2, doctor.getSpecialization());
                stmt.setString(3, doctor.getPhone());
                stmt.setString(4, doctor.getEmail());
                stmt.setInt(5,doctor.getExperience());

                stmt.executeUpdate();
                System.out.println("Doctor added Successfully!");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //Get All Doctors
    public List<Doctor> getAllDoctor(){
        List <Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";

        try(Connection conn = DBConnection.getConnection()) {
            assert conn!= null;
            try(PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)){
                    while (rs.next()){
                        Doctor d = new Doctor();
                        d.setId(rs.getInt("id"));
                        d.setName(rs.getString("name"));
                        d.setSpecialization(rs.getString("specialization"));
                        d.setPhone(rs.getString("phone"));
                        d.setEmail(rs.getString("email"));
                        d.setExperience(rs.getInt("experience"));
                        doctors.add(d);
                    }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return doctors;
    }

    // Get a doctor by ID
    public Doctor getDoctorById(int id) {
        String sql = "SELECT * FROM doctors WHERE id = ?";
        Doctor doctor = null;

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Database connection failed!");
                return null;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        doctor = new Doctor();
                        doctor.setId(rs.getInt("id"));
                        doctor.setName(rs.getString("name"));
                        doctor.setSpecialization(rs.getString("specialization"));
                        doctor.setPhone(rs.getString("phone"));
                        doctor.setEmail(rs.getString("email"));
                        doctor.setExperience(rs.getInt("experience"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctor;
    }

    //Delete Doctor Info by id
    public boolean deleteDoctorById(int id) {
        String sql = "DELETE FROM doctors WHERE id = ?";
        boolean deleted = false;

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Database connection failed!");
                return false;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int affectedRows = stmt.executeUpdate();
                deleted = affectedRows > 0;

                if (deleted) {
                    System.out.println("Doctor deleted successfully.");
                } else {
                    System.out.println("Doctor not found with ID: " + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleted;
    }

    // Update doctor details
    public boolean updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctors SET name = ?, specialization = ?, phone = ?, email = ?, experience = ? WHERE id = ?";
        boolean updated = false;

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Database connection failed!");
                return false;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, doctor.getName());
                stmt.setString(2, doctor.getSpecialization());
                stmt.setString(3, doctor.getPhone());
                stmt.setString(4, doctor.getEmail());
                stmt.setInt(5, doctor.getExperience());
                stmt.setInt(6, doctor.getId());

                int affectedRows = stmt.executeUpdate();
                updated = affectedRows > 0;

                if (updated) {
                    System.out.println("Doctor updated successfully.");
                } else {
                    System.out.println("Doctor not found with ID: " + doctor.getId());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

}