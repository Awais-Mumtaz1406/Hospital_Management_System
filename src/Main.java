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
            System.out.println("3. Get Patient by ID ");
            System.out.println("4. Update Patient ");
            System.out.println("5. Delete Patient ");
            System.out.println("6. Add Doctor ");
            System.out.println("7. View all Doctors");
            System.out.println("8. Get Doctor by ID ");
            System.out.println("9. Update Doctor ");
            System.out.println("10. Delete Doctor ");
            System.out.println("11. Add Appointment");
            System.out.println("12. View all Appointments ");
            System.out.println("13. View all Appointments by Doctor");
            System.out.println("14. View all Appointments by Patient ");
            System.out.println("15. Update Appointment by Id ");
            System.out.println("16. Delete Appointment by Id");
            System.out.println("17. Exit");
            System.out.println("============================================");

            System.out.println("Enter Valid Number");
            int choice = abc.nextInt();
            abc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Patient Details");
                    System.out.print("Name: ");
                    String name = abc.nextLine();
                    System.out.print("Age: ");
                    int age = abc.nextInt();
                    abc.nextLine();
                    System.out.print("Gender: ");
                    String gender = abc.nextLine();
                    System.out.print("Phone: ");
                    String phone = abc.nextLine();

                    Patient patient = new Patient(name, age, gender, phone);
                    PatientDAO.addPatient(patient);
                    break;

                case 2:
                    List<Patient> patients = PatientDAO.getAllPatients();
                    if (patients.isEmpty()) {
                        System.out.println("No patients found");
                    } else {
                        for (Patient patientById : patients) {
                            System.out.println("--------------------------------------------------------------------------");
                            System.out.println("ID: " + patientById.getId() + ", Name: " + patientById.getName() +
                                    ", Age: " + patientById.getAge() + ", Gender: " + patientById.getGender() +
                                    ", Contact: " + patientById.getPhone());
                            System.out.println("---------------------------------------------------------------------------");
                        }
                    }

                    break;

                case 3:
                    System.out.print("Enter Patient ID: ");
                    int patientId = abc.nextInt();
                    Patient patientById = PatientDAO.getPatientById(patientId);
                    if (patientById == null) {
                        System.out.println("No patient found with this ID");
                    } else {
                        System.out.println("---------------------------------------------------------------------------");
                            System.out.println("ID: " + patientById.getId() + ", Name: " + patientById.getName() +
                                    ", Age: " + patientById.getAge() + ", Gender: " + patientById.getGender() +
                                    ", Phone: " + patientById.getPhone());
                        System.out.println("---------------------------------------------------------------------------");
                    }
                    break;

                case 4:
                    System.out.print("Enter Patient Details to update: ");
                    System.out.print("New Name: ");
                    name = abc.nextLine();
                    System.out.print("New Age: ");
                    age = abc.nextInt();
                    abc.nextLine();
                    System.out.print("New Gender: ");
                    gender = abc.nextLine();
                    System.out.print("New Phone: ");
                    phone = abc.nextLine();
                    Patient updatedPatient = new Patient(name, age, gender, phone);
                    boolean updatedP = PatientDAO.updatePatient(updatedPatient);
                    System.out.println(updatedP ? "Patient updated successfully" : "Failed to update patient");
                    break;

                case 5:
                    System.out.print("Enter Patient ID to delete: ");
                    int deletePatientId = abc.nextInt();
                    boolean deletedP = PatientDAO.deletePatientById(deletePatientId);
                    System.out.println(deletedP ? "Patient deleted successfully" : "Failed to delete patient");
                    break;

                case 6:
                    System.out.println("Enter Doctor Details");
                    System.out.print("Name: ");
                    name = abc.nextLine();
                    System.out.print("Specialization: ");
                    String specialization = abc.nextLine();
                    System.out.print("Phone: ");
                    phone = abc.nextLine();
                    System.out.print("Email: ");
                    String email = abc.nextLine();
                    System.out.print("Experience: ");
                    int experience = abc.nextInt();
                    abc.nextLine();
                    Doctor doctor = new Doctor(name, specialization, phone, email, experience);
                    DoctorDAO.addDoctor(doctor);
                    break;

                case 7:
                    List<Doctor> doctors = DoctorDAO.getAllDoctor();
                    if (doctors.isEmpty()) {
                        System.out.println("No patients found");
                    } else {
                        for (Doctor doctor1 : doctors) {  // Iterate over each patient
                            System.out.println("---------------------------------------------------------------------------");
                            System.out.println("ID: " + doctor1.getId() + ", Name: " + doctor1.getName() +
                                    ", Specialization: " + doctor1.getSpecialization() + ", Phone: " + doctor1.getPhone() +
                                    ", Email: " + doctor1.getEmail() + ", Experience: " + doctor1.getExperience());
                            System.out.println("---------------------------------------------------------------------------");
                        }
                    }
                    break;

                case 8:
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = abc.nextInt();
                    Doctor doctorById = DoctorDAO.getDoctorById(doctorId);
                    if (doctorById == null) {
                        System.out.println("No doctor found with this ID");
                    } else {
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.println("ID: " + doctorById.getId() + ", Name: " + doctorById.getName() +
                                ", Specialization: " + doctorById.getSpecialization() + ", Phone : " + doctorById.getPhone() +
                                ", Email : " + doctorById.getEmail() + " Experience :"+ doctorById.getExperience());
                        System.out.println("---------------------------------------------------------------------------");
                    }
                    break;

                case 9:
                    System.out.print("Enter Doctor Details to update: ");
                    System.out.print("New Name: ");
                    name = abc.nextLine();
                    System.out.print("New Specialization: ");
                    specialization = abc.nextLine();
                    System.out.print("New Phone: ");
                    phone = abc.nextLine();
                    System.out.print("New Email: ");
                    email = abc.nextLine();
                    System.out.print("New Experience: ");
                    experience = abc.nextInt();
                    abc.nextLine();
                    Doctor updatedDoc = new Doctor(name, specialization, phone, email, experience);
                    boolean updatedDoctor = DoctorDAO.updateDoctor(updatedDoc);
                    System.out.println(updatedDoctor ? "Doctor updated successfully" : "Failed to update doctor");
                    break;

                case 10:
                    System.out.print("Enter Doctor ID to delete: ");
                    int deleteDocId = abc.nextInt();
                    boolean deletedDoctor = DoctorDAO.deleteDoctorById(deleteDocId);
                    System.out.println(deletedDoctor ? "Doctor deleted successfully" : "Failed to delete doctor");
                    break;

                case 11:
                    System.out.print("Enter Patient ID: ");
                    patientId = abc.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    doctorId = abc.nextInt();
                    abc.nextLine();
                    System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
                    String date = abc.nextLine();
                    System.out.print("Enter Appointment Time (hh:mm): ");
                    String time = abc.nextLine();
                    System.out.print("Enter Status: ");
                    String status = abc.nextLine();
                    Appointment appointment = new Appointment(patientId, doctorId, date, time, status);
                    AppointmentDAO.addAppointment(appointment);
                    break;

                case 12:
                    List<Appointment> appointments = AppointmentDAO.getAllAppointments();
                    if (appointments.isEmpty()) {
                        System.out.println("No appointments found");
                    } else {
                        for (Appointment app : appointments) {
                            System.out.println("---------------------------------------------------------------------------");
                            System.out.println("ID: " + app.getId() + ", Patient ID: " + app.getPatientId() +
                                    ", Doctor ID: " + app.getDoctorId() + ", Date: " + app.getDate() +
                                    ", Time: " + app.getTime() + ", Status: " + app.getStatus());
                            System.out.println("---------------------------------------------------------------------------");
                        }
                    }
                    break;

                case 13:
                    System.out.print("Enter Doctor ID: ");
                    doctorId = abc.nextInt();
                    List<Appointment> docAppointments = AppointmentDAO.getAppointmentsByDoctorId(doctorId);
                    if (docAppointments.isEmpty()) {
                        System.out.println("No appointments for this doctor");
                    } else {
                        for (Appointment app : docAppointments) {
                            System.out.println("---------------------------------------------------------------------------");
                            System.out.println("ID: " + app.getId() + ", Patient ID: " + app.getPatientId() +
                                    ", Date: " + app.getDate() + ", Time: " + app.getTime() +
                                    ", Status: " + app.getStatus());
                            System.out.println("---------------------------------------------------------------------------");
                        }
                    }
                    break;

                case 14:
                    System.out.print("Enter Patient ID: ");
                    patientId = abc.nextInt();
                    List<Appointment> patAppointments = AppointmentDAO.getAppointmentsByPatientId(patientId);
                    if (patAppointments.isEmpty()) {
                        System.out.println("No appointments for this patient");
                    } else {
                        for (Appointment app : patAppointments) {
                            System.out.println("---------------------------------------------------------------------------");
                            System.out.println("ID: " + app.getId() + ", Doctor ID: " + app.getDoctorId() +
                                    ", Date: " + app.getDate() + ", Time: " + app.getTime() +
                                    ", Status: " + app.getStatus());
                            System.out.println("---------------------------------------------------------------------------");
                        }
                    }
                    break;

                case 15:
                    System.out.print("Enter Appointment ID: ");
                    int appId = abc.nextInt();
                    System.out.print("Enter Patient ID: ");
                    patientId = abc.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    doctorId = abc.nextInt();
                    abc.nextLine();
                    System.out.print("Enter Date (yyyy-mm-dd): ");
                    date = abc.nextLine();
                    System.out.print("Enter Time (hh:mm): ");
                    time = abc.nextLine();
                    System.out.print("Enter Status: ");
                    status = abc.nextLine();
                    Appointment updatedApp = new Appointment(appId, patientId, doctorId, date, time, status);
                    boolean appUpdated = AppointmentDAO.updateAppointment(updatedApp);
                    System.out.println(appUpdated ? "Appointment updated" : "Failed to update");
                    break;

                case 16:
                    System.out.print("Enter Appointment ID: ");
                    int deleteAppId = abc.nextInt();
                    boolean appDeleted = AppointmentDAO.deleteById(deleteAppId);
                    System.out.println(appDeleted ? "Appointment deleted" : "Failed to delete");
                    break;

                case 17:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid input, try again.");
            }
        }
    }
}
