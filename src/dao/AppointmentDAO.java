package src.dao;

import src.db.DBConnection;
import src.models.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    // Add Appointment
    public void addAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (patientId, doctorId, date, time, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, appointment.getPatientId());
                stmt.setInt(2, appointment.getDoctorId());
                stmt.setString(3, appointment.getDate());
                stmt.setString(4, appointment.getTime());
                stmt.setString(5, appointment.getStatus());
                stmt.executeUpdate();
                System.out.println("Appointment added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all Appointments
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";

        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    appointments.add(mapRowToAppointment(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    // Get Appointment by ID (single)
    public Appointment getAppointmentById(int id) {
        String sql = "SELECT * FROM appointments WHERE id = ?";
        Appointment appointment = null;

        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        appointment = mapRowToAppointment(rs);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointment;
    }

    // Get Appointments by Doctor ID
    public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE doctorId = ?";

        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, doctorId);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        appointments.add(mapRowToAppointment(rs));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    // Get Appointments by Patient ID
    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE patientId = ?";

        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, patientId);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        appointments.add(mapRowToAppointment(rs));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    // Delete Appointment by ID
    public boolean deleteById(int id) {
        String sql = "DELETE FROM appointments WHERE id = ?";
        boolean deleted = false;

        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int affectedRows = stmt.executeUpdate();
                deleted = affectedRows > 0;
                System.out.println(deleted ? "Appointment deleted successfully." : "Appointment not found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deleted;
    }

    // Update Appointment by ID
    public boolean updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointments SET patientId = ?, doctorId = ?, date = ?, time = ?, status = ? WHERE id = ?";
        boolean updated = false;

        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, appointment.getPatientId());
                stmt.setInt(2, appointment.getDoctorId());
                stmt.setString(3, appointment.getDate());
                stmt.setString(4, appointment.getTime());
                stmt.setString(5, appointment.getStatus());
                stmt.setInt(6, appointment.getId());
                int affectedRows = stmt.executeUpdate();
                updated = affectedRows > 0;
                System.out.println(updated ? "Appointment updated successfully." : "Appointment not found with ID: " + appointment.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

    // Utility method to map ResultSet to Appointment
    private Appointment mapRowToAppointment(ResultSet rs) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setId(rs.getInt("id"));
        appointment.setPatientId(rs.getInt("patientId"));
        appointment.setDoctorId(rs.getInt("doctorId"));
        appointment.setDate(rs.getString("date"));
        appointment.setTime(rs.getString("time"));
        appointment.setStatus(rs.getString("status"));
        return appointment;
    }
}
