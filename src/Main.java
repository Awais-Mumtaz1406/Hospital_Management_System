package src;

import src.dao.DoctorDAO;
import src.dao.PatientDAO;
import src.dao.AppointmentDAO;
import src.models.Doctor;
import src.models.Patient;
import src.models.Appointment;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner abc = new Scanner(System.in);

        while (true){
            System.out.println("=======Hospital Management System========");
            System.out.println("1. Add Patient ");
            System.out.println("2. View all Patients");
            System.out.println("3. Add Doctor ");
            System.out.println("4. View all Doctors");
            System.out.println("5. Add Appointment");
            System.out.println("6. View all Appointments ");
            System.out.println("7. View all Appointments by Doctor");
            System.out.println("8. View all Appointments by Patient ");
            System.out.println("9. Update Appointment by Id ");
            System.out.println("10. Delete Appointment by Id");
            System.out.println("11. Exit");
            System.out.println("============================================");

            int choice = abc.nextInt();
            abc.nextLine(); // consume the newline character left by nextInt
            switch (choice){
                case 1:
                    System.out.println("Enter Patient Details");
                    System.out.println("Enter patient name");
                    String name = abc.nextLine();
                    System.out.println("Enter patient age");
                    int age = abc.nextInt();
                    abc.nextLine();
                    System.out.println("Enter patient gender");
                    String gender = abc.nextLine();
                    System.out.println("Enter patient Phone");
                    String phone = abc.nextLine();

                    Patient patient = new Patient(name, age, gender, phone);
                    PatientDAO.addPatient(patient);
                    break;

                case 2:
                    List<Patient> patients = PatientDAO.getAllPatients();
                    if (patients.isEmpty()) {
                        System.out.println("No patients found");
                    } else {
                        System.out.println("Patient List");
                        for (Patient p : patients) {
                            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() +
                                    ", Age: " + p.getAge() + ", Gender: " + p.getGender() +
                                    ", Contact: " + p.getPhone());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Doctor Details");
                    System.out.println("Enter doctor name");
                    name = abc.nextLine();
                    System.out.println("Enter doctor specialization");
                    String specialization = abc.nextLine();
                    System.out.println("Enter doctor Phone");
                    phone = abc.nextLine();
                    System.out.println("Enter doctor email");
                    String email = abc.nextLine();
                    System.out.println("Enter doctor experience");
                    int experience = abc.nextInt();
                    abc.nextLine(); // consume the newline character

                    Doctor doctor = new Doctor(name, specialization, phone, email, experience);
                    DoctorDAO.addDoctor(doctor);
                    break;

                case 4:
                    List<Doctor> doctors = DoctorDAO.getAllDoctor();
                    if (doctors.isEmpty()) {
                        System.out.println("No doctors found");
                    } else {
                        System.out.println("Doctor List");
                        for (Doctor d : doctors) {
                            System.out.println("ID: " + d.getId() + ", Name: " + d.getName() +
                                    ", Specialization: " + d.getSpecialization() + ", Phone: " + d.getPhone() +
                                    ", Email: " + d.getEmail() + ", Experience: " + d.getExperience());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Enter Appointment Details");
                    System.out.println("Enter patient Id");
                    int patientId = abc.nextInt();
                    System.out.println("Enter doctor Id");
                    int doctorId = abc.nextInt();
                    abc.nextLine(); // consume the newline character
                    System.out.println("Enter appointment date (yyyy-mm-dd)");
                    String date = abc.nextLine();
                    System.out.println("Enter appointment time (hh:mm)");
                    String time = abc.nextLine();
                    System.out.println("Enter appointment status");
                    String status = abc.nextLine();

                    Appointment appointment = new Appointment(patientId, doctorId, date, time, status);
                    AppointmentDAO.addAppointment(appointment);
                    break;

                case 6:
                    List<Appointment> appointments = AppointmentDAO.getAllAppointments();
                    if (appointments.isEmpty()) {
                        System.out.println("No appointments found");
                    } else {
                        System.out.println("Appointments List");
                        for (Appointment app : appointments) {
                            System.out.println("ID: " + app.getId() + ", Patient ID: " + app.getPatientId() +
                                    ", Doctor ID: " + app.getDoctorId() + ", Date: " + app.getDate() +
                                    ", Time: " + app.getTime() + ", Status: " + app.getStatus());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Enter Doctor ID to view appointments");
                    doctorId = abc.nextInt();
                    List<Appointment> doctorAppointments = AppointmentDAO.getAppointmentsByDoctorId(doctorId);
                    if (doctorAppointments.isEmpty()) {
                        System.out.println("No appointments found for this doctor");
                    } else {
                        for (Appointment app : doctorAppointments) {
                            System.out.println("ID: " + app.getId() + ", Patient ID: " + app.getPatientId() +
                                    ", Date: " + app.getDate() + ", Time: " + app.getTime() +
                                    ", Status: " + app.getStatus());
                        }
                    }
                    break;

                case 8:
                    System.out.println("Enter Patient ID to view appointments");
                    patientId = abc.nextInt();
                    List<Appointment> patientAppointments = AppointmentDAO.getAppointmentsByPatientId(patientId);
                    if (patientAppointments.isEmpty()) {
                        System.out.println("No appointments found for this patient");
                    } else {
                        for (Appointment app : patientAppointments) {
                            System.out.println("ID: " + app.getId() + ", Doctor ID: " + app.getDoctorId() +
                                    ", Date: " + app.getDate() + ", Time: " + app.getTime() +
                                    ", Status: " + app.getStatus());
                        }
                    }
                    break;

                case 9:
                    System.out.println("Enter Appointment ID to update");
                    int id = abc.nextInt();
                    System.out.println("Enter patient Id");
                     patientId = abc.nextInt();
                    System.out.println("Enter doctor Id");
                     doctorId = abc.nextInt();
                    abc.nextLine(); // consume the newline character
                    System.out.println("Enter new appointment date (yyyy-mm-dd)");
                    date = abc.nextLine();
                    System.out.println("Enter new appointment time (hh:mm)");
                    time = abc.nextLine();
                    System.out.println("Enter new appointment status");
                    status = abc.nextLine();

                    Appointment updatedAppointment = new Appointment(id,patientId,doctorId,date, time, status);
                    boolean updated = AppointmentDAO.updateAppointment(updatedAppointment);
                    if (updated) {
                        System.out.println("Appointment updated successfully!");
                    } else {
                        System.out.println("Failed to update appointment");
                    }
                    break;

                case 10:
                    System.out.println("Enter Appointment ID to delete");
                    id = abc.nextInt();
                    boolean deleted = AppointmentDAO.deleteById(id);
                    if (deleted) {
                        System.out.println("Appointment deleted successfully!");
                    } else {
                        System.out.println("Failed to delete appointment");
                    }
                    break;

                case 11:
                    System.out.println("Good Bye");
                    return;

                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
