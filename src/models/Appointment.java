package src.models;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private String date;
    private String time;
    private AppointmentStatus status;

    public Appointment(){}
    public Appointment(int id, int patientId, int doctorId, String date, String time, AppointmentStatus status){
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.status = status;
    }
    public Appointment(int patientId, int doctorId, String date, String time, AppointmentStatus status){
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    //Setters for the Appointment
    public void setId(int id) {
        this.id = id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    //Getters for the Appointment
    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public AppointmentStatus getStatus() {
        return status;
    }


}