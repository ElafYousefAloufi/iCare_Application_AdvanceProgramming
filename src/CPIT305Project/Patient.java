// Group Names:
// Shuruq Baabdullah 1906284 VBR
// Rahaf Dawoud 1911088 VBR
// Elaf Yousef Aloufi 1911265
// Manar Mutlaq Altaiary 1906775
package CPIT305Project;

import java.util.*;

public class Patient extends User {

    private String medicalStatus = "No medical status";

    private ArrayList<Appointment> Appointments = new ArrayList<Appointment>();

    private String note = "no notes";

    public Patient() {

    }

    public Patient(String firstName, String lastName, String phoneNumber, String SSN, String gender, String Email, String city, String birthDate, String password) {
        super(firstName, lastName, phoneNumber, SSN, gender, Email, city, birthDate, password);

    }

    @Override
    public String toString() {
        return "medicalStatus: " + medicalStatus + ", note: " + note;
    }

    public void setMedicalStatus(String MedicalStatus) {
        this.medicalStatus = MedicalStatus;
    }

    public ArrayList<Appointment> getAppointments() {
        return Appointments;
    }

    public void setAppointment(ArrayList<Appointment> Appointments) {
        this.Appointments = Appointments;
    }

    public void setNote(String Note) {
        this.note = Note;
    }

    public String getNote() {
        return note;
    }

    public void MakeAppointment(Appointment appointment) {
        boolean found = false;
        for (int i = 0; i < Appointments.size(); i++) {
            if (Appointments.get(i).getID() == appointment.getID()) {
                System.out.println("we found");
                found = true;
            }

        }
        if (!found) {
            Appointments.add(appointment);
        }

    }

    public void deleteAppointment(Appointment appointment) {
        boolean found = false;
        for (int i = 0; i < Appointments.size(); i++) {
            if (Appointments.get(i).getID() == appointment.getID()) {
                Appointments.remove(appointment);
                found = true;
            }

        }
        if (!found) {
            System.out.println("Sorry");
        }
    }

    public Appointment searchForAppointment(Appointment appointment) {
        for (int i = 0; i < Appointments.size(); i++) {
            if (Appointments.get(i).getID() == appointment.getID()) {
                return Appointments.get(i);
            }
        }
        return null;
    }

    public String getMedicalStatus() {
        return medicalStatus;
    }
}
