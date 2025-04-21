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

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return appointment;
    }
}