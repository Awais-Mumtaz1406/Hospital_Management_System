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
    //Add Appointment
    public void addAppointment(Appointment appointment){
        String sql = "INSERT INTO appointments (patientId,doctorId,date,time,status) VALUES(?,?,?,?,?)";
        try(Connection conn = DBConnection.getConnection()){
            assert conn!=null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1,appointment.getPatientId());
                stmt.setInt(2,appointment.getDoctorId());
                stmt.setString(3,appointment.getDate());
                stmt.setString(4,appointment.getTime());
                stmt.setString(5,appointment.getStatus());

                stmt.executeUpdate();
                System.out.println("Appointment Added Successfully!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Get all Appointments
    public List<Appointment> getAppointments() {
        List <Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try(Connection conn = DBConnection.getConnection()){
           assert  conn!=null;
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    Appointment a = new Appointment();
                    a.setId(rs.getInt("id"));
                    a.setPatientId(rs.getInt("patientId"));
                    a.setDoctorId(rs.getInt("doctorId"));
                    a.setDate(rs.getString("date"));
                    a.setTime(rs.getString("time"));
                    a.setStatus(rs.getString("status"));
                    appointments.add(a);

                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return appointments;
    }

    //Get an Appointment by id
    public Appointment getAppointmentById(int id){
        String sql = "SELECT * FROM appointments WHERE id = ?";
        Appointment appointment = null;

        try(Connection conn = DBConnection.getConnection()){
            assert conn != null;
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet rs =stmt.executeQuery()){
                if (rs.next()){
                    appointment = new Appointment();
                    appointment.setId(rs.getInt("id" ));
                    appointment.setPatientId(rs.getInt("patientId"));
                    appointment.setDoctorId(rs.getInt("doctorId"));
                    appointment.setDate(rs.getString("date"));
                    appointment.setTime(rs.getString("time"));
                    appointment.setStatus(rs.getString("status"));
                }
             }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return appointment;
    }

    //Get an Appointment by Doctor id
    public Appointment getAppointmentByDoctorId(int doctorId){
        String sql = "SELECT * FROM appointments WHERE doctorId = ?";
        Appointment appointment = null;

        try(Connection conn = DBConnection.getConnection()){
            assert conn != null;
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1,doctorId);
                try(ResultSet rs =stmt.executeQuery()){
                    if (rs.next()){
                        appointment = new Appointment();
                        appointment.setId(rs.getInt("id" ));
                        appointment.setPatientId(rs.getInt("patientId"));
                        appointment.setDoctorId(rs.getInt("doctorId"));
                        appointment.setDate(rs.getString("date"));
                        appointment.setTime(rs.getString("time"));
                        appointment.setStatus(rs.getString("status"));
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return appointment;
    }

    //Get an Appointment by Patient id
    public Appointment getAppointmentByPatientId(int patientId){
        String sql = "SELECT * FROM appointments WHERE patientId = ?";
        Appointment appointment = null;

        try(Connection conn = DBConnection.getConnection()){
            assert conn != null;
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1,patientId);
                try(ResultSet rs =stmt.executeQuery()){
                    if (rs.next()){
                        appointment = new Appointment();
                        appointment.setId(rs.getInt("id" ));
                        appointment.setPatientId(rs.getInt("patientId"));
                        appointment.setDoctorId(rs.getInt("doctorId"));
                        appointment.setDate(rs.getString("date"));
                        appointment.setTime(rs.getString("time"));
                        appointment.setStatus(rs.getString("status"));
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return appointment;
    }

//Delete Appointment by ID
    public boolean deleteById(int id){
        String sql = "DELETE FROM appointment WHERE id = ?";
        boolean deleted = false;

        try(Connection conn = DBConnection.getConnection()){
            assert conn!= null;
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1,id);
                int affectedRows = stmt.executeUpdate();
                deleted = affectedRows>0;
                if (deleted){
                    System.out.println("Doctor deleted Successfully");
                }
                else {
                    System.out.println("Doctor not found by id"+id);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return deleted;
    }

    //Update by id
    public boolean updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointment SET patientId = ?, doctorId = ?, date = ?, time = ?, status = ? WHERE id = ?";
        boolean updated = false;

        try (Connection conn = DBConnection.getConnection()) {
            if (conn == null) {
                System.out.println("Database connection failed!");
                return false;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, appointment.getPatientId());
                stmt.setInt(2, appointment.getDoctorId());
                stmt.setString(3, appointment.getDate());
                stmt.setString(4, appointment.getTime());
                stmt.setString(5, appointment.getStatus());

                int affectedRows = stmt.executeUpdate();
                updated = affectedRows > 0;

                if (updated) {
                    System.out.println("Doctor updated successfully.");
                } else {
                    System.out.println("Doctor not found with ID: " + appointment.getId());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }
}