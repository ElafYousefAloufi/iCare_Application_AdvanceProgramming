// Group Names:
// Shuruq Baabdullah 1906284 VBR
// Rahaf Dawoud 1911088 VBR
// Elaf Yousef Aloufi 1911265
// Manar Mutlaq Altaiary 1906775
package CPIT305Project;

import java.util.ArrayList;
import java.util.Date;

public abstract class User {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String SSN;

    private int ID;

    private String gender;

    private String Email;

    private String city;

    private String age;

    private String password;

    ArrayList<User> Users = new ArrayList<User>();

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBirthDate(String age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSSN() {
        return SSN;
    }

    public int getID() {
        return ID;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return Email;
    }

    public String getCity() {
        return city;
    }

    public String getBirthDate() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public User(String firstName, String lastName, String phoneNumber, String SSN, String gender, String Email, String city, String birthDate, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.SSN = SSN;
        this.ID = generateID();
        this.gender = gender;
        this.Email = Email;
        this.city = city;
        this.age = birthDate;
        this.password = password;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "The User Information is: \n" + "firstName: " + firstName + ", lastName: " + lastName + ", phoneNumber: " + phoneNumber + ", SSN: " + SSN + ", ID: " + ID + ", gender: " + gender + ", Email: " + Email + ", city: " + city + ", Age: " + age + ", password: " + password;
    }

    public void createAccount(User person, Admin admin) {
        ArrayList<MedicalEmployee> MedicalEmployees = admin.getMedicalEmployees();
        ArrayList<Patient> Patients = admin.getPatients();
        boolean found = false;
        if (person instanceof MedicalEmployee) {
            for (int i = 0; i < Users.size(); i++) {
                for (int j = 0; j < MedicalEmployees.size(); j++) {
                    if (Users.get(i).getID() == MedicalEmployees.get(j).getID()) {
                        found = true;
                    }
                }

            }

        } else if (person instanceof Patient) {
            for (int i = 0; i < Users.size(); i++) {
                for (int j = 0; j < Patients.size(); j++) {
                    if (Users.get(i).getID() == Patients.get(j).getID()) {
                        found = true;
                    }
                }

            }

        }
        if (!found) {
            Users.add(person);
        }

    }

    public int generateID() {
        return (int) (Math.random() * 100000);
    }

    public void deleteAccount(User person, Admin admin) {
        ArrayList<MedicalEmployee> MedicalEmployees = admin.getMedicalEmployees();
        ArrayList<Patient> Patients = admin.getPatients();

        boolean found = false;
        if (person instanceof MedicalEmployee) {
            for (int i = 0; i < Users.size(); i++) {
                for (int j = 0; j < MedicalEmployees.size(); j++) {
                    if (Users.get(i).getID() == MedicalEmployees.get(j).getID()) {
                        Users.remove(person);
                        MedicalEmployees.remove(MedicalEmployees.get(j));
                        found = true;
                    }
                }

            }

        } else if (person instanceof Patient) {
            for (int i = 0; i < Users.size(); i++) {
                for (int j = 0; j < Patients.size(); j++) {
                    if (Users.get(i).getID() == Patients.get(j).getID()) {
                        found = true;
                    }
                }

            }

            if (!found) {
                System.out.println("Sorry");
            }
        }
    }

    public User searchForAccount(User person, Admin admin) {
        ArrayList<MedicalEmployee> MedicalEmployees = admin.getMedicalEmployees();
        ArrayList<Patient> Patients = admin.getPatients();

        if (person instanceof MedicalEmployee) {
            for (int i = 0; i < Users.size(); i++) {
                for (int j = 0; j < MedicalEmployees.size(); j++) {
                    if (Users.get(i).getID() == MedicalEmployees.get(j).getID()) {
                        return MedicalEmployees.get(j);

                    }
                }

            }

        } else if (person instanceof Patient) {
            for (int i = 0; i < Users.size(); i++) {
                for (int j = 0; j < Patients.size(); j++) {
                    if (Users.get(i).getID() == Patients.get(j).getID()) {
                        return Patients.get(j);
                    }
                }

            }

        }
        return null;
    }

}
