# Hospital Management System

## Overview
This **Hospital Management System** is a software application designed to manage patients, doctors, and appointments in a hospital setting. It allows for CRUD (Create, Read, Update, Delete) operations for both patients and doctors. Additionally, the system facilitates appointment scheduling, viewing, and management.

The project is built using **Java** and **SQLite** as the database, ensuring a lightweight and portable solution for managing hospital data.

## Features

- **Patient Management:**
  - Add new patients.
  - View all patients.
  - Search for a patient by ID.
  - Update patient information.
  - Delete patient records.
  
- **Doctor Management:**
  - Add new doctors.
  - View all doctors.
  - Search for a doctor by ID.
  - Update doctor information.
  - Delete doctor records.

- **Appointment Management:**
  - Add new appointments for patients.
  - View all appointments.
  - View appointments by doctor.
  - View appointments by patient.
  - Update appointment details.
  - Delete appointments.

## Technologies Used

- **Java** - Core language for the application logic.
- **SQLite** - Lightweight, serverless database for storing patient, doctor, and appointment records.
- **JDBC** - Java Database Connectivity for interaction between Java application and SQLite database.

## Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/Junaid-Ashraf-56/hospital-management-system.git
   cd hospital-management-system
   ```

2. **Setup SQLite Database:**
   - Ensure you have **SQLite** installed on your system.
   - The database file `hospital.db` should already be present in the project directory after running the application for the first time, but if not, it can be manually created.

3. **Build the Project:**
   - Open the project in your favorite IDE or text editor (e.g., **IntelliJ IDEA**, **Eclipse**, **VS Code**).
   - If using **Maven** or **Gradle**, import dependencies.
   - Otherwise, ensure **JDBC** and **SQLite JDBC drivers** are included in your build path.

4. **Run the Application:**
   - Run the `Main.java` file, and follow the on-screen instructions to manage patients, doctors, and appointments.

## Usage

Once the program runs, you will see a menu with various options to manage patients, doctors, and appointments. You can perform actions like:

- Add new patients and doctors.
- View all records or search by ID.
- Schedule, view, or update appointments.
- Delete records when necessary.

### Example Menu
```
=======Hospital Management System========
1. Add Patient 
2. View all Patients
3. Get Patient by ID 
4. Update Patients 
5. Delete Patients 
6. Add Doctor 
7. View all Doctors
8. Get Doctor by ID 
9. Update Doctor 
10. Delete Doctor 
11. Add Appointment
12. View all Appointments 
13. View all Appointments by Doctor
14. View all Appointments by Patient 
15. Update Appointment by Id 
16. Delete Appointment by Id
17. Exit
============================================
```

## File Structure

```
src/
├── dao/
│   ├── AppointmentDAO.java
│   ├── DoctorDAO.java
│   ├── PatientDAO.java
│   └── DBConnection.java
├── models/
│   ├── Appointment.java
│   ├── Doctor.java
│   └── Patient.java
└── Main.java
```

## Contributing

1. Fork this repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature/your-feature`).
6. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
