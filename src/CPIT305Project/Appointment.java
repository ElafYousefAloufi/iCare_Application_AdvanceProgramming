// Group Names:
// Shuruq Baabdullah 1906284 VBR
// Rahaf Dawoud 1911088 VBR
// Elaf Yousef Aloufi 1911265
// Manar Mutlaq Altaiary 1906775
package CPIT305Project;

import java.util.Date;

public class Appointment {

    private Patient Patient;

    private MedicalEmployee MedicalEmployee;

    private String appointmentDate;

    private int appointmentID;

    private boolean available = true;

    public Appointment(Patient Patient, MedicalEmployee MedicalEmployee, String appointmentDate) {
        this.Patient = Patient;
        this.MedicalEmployee = MedicalEmployee;
        this.appointmentDate = appointmentDate;
        this.appointmentID = generateID();
    }
    
    public Appointment(MedicalEmployee MedicalEmployee, String appointmentDate) {
        this.MedicalEmployee = MedicalEmployee;
        this.appointmentDate = appointmentDate;
        this.appointmentID = generateID();
    }

    Appointment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPatient(Patient Patient) {
        this.Patient = Patient;
    }

    public void setMedicalEmployee(MedicalEmployee MedicalEmployee) {
        this.MedicalEmployee = MedicalEmployee;
    }

    public void setAppointmentDate(String AppointmentDate) {
        this.appointmentDate = AppointmentDate;
    }

    public void setAppointmentID(int ID) {
        this.appointmentID = ID;
    }

    public void setAvailable(boolean Available) {
        this.available = Available;

    }

    public boolean getAvailable() {
        return available;
    }

    public boolean isAvailable() {
        return available == true;
    }

    public int generateID() {
        return (int) (Math.random() * 100000);
    }

    public Patient getPatient() {
        return Patient;
    }

    public MedicalEmployee getMedicalEmployee() {
        return MedicalEmployee;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public int getID() {
        return appointmentID;
    }
}
