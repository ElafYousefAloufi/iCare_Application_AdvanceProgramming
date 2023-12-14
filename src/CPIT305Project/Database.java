// Group Names:
// Shuruq Baabdullah 1906284 VBR
// Rahaf Dawoud 1911088 VBR
// Elaf Yousef Aloufi 1911265
// Manar Mutlaq Altaiary 1906775
package CPIT305Project;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Database {

    static String url;
    static String dbURL;
    static Connection con;
    static Statement st;
    private static Database connection = null;

    public void DBCreation() throws SQLException {

//                st.executeUpdate("CREATE TABLE Patient "
//                        + "(FirstName VARCHAR(100) not NULL, "
//                        + " LastName  VARCHAR(100) not NULL, "
//                        + "PhoneNumber VARCHAR(10) not NULL,"
//                        + "SSN VARCHAR(10) not NULL,"
//                        + "Gender VARCHAR(7) not NULL,"
//                        + "Email VARCHAR(100) not NULL,"
//                        + "City VARCHAR(100) not NULL,"
//                        + "Age VARCHAR(10) not NULL,"
//                        + "PassWord VARCHAR(100) not NULL, "
//                        + "PRIMARY KEY (SSN))");
//
//                st.executeUpdate("CREATE TABLE Medical_Employee "
//                        + "(FirstName VARCHAR(100) not NULL, "
//                        + " LastName  VARCHAR(100) not NULL, "
//                        + "PhoneNumber VARCHAR(10) not NULL,"
//                        + "SSN VARCHAR(10) not NULL,"
//                        + "Gender VARCHAR(7) not NULL,"
//                        + "Email VARCHAR(100) not NULL,"
//                        + "City VARCHAR(100) not NULL,"
//                        + "Age VARCHAR(10) not NULL,"
//                        + "PassWord VARCHAR(100) not NULL, "
//                        + "User_Type VARCHAR(100) not NULL, "
//                        + "PRIMARY KEY (SSN))");
//                st.executeUpdate("CREATE TABLE Appointment "
//                        + "(appointmentID INT not NULL, "
//                        + " appointmentDate VARCHAR(100) not NULL, "
//                        + " available BOOLEAN not NULL,"
//                        + " MedicalEmployee_SSN VARCHAR(10) not NULL,"
//                        + " Patient_SSN VARCHAR(10) not NULL, "
//                        + " PRIMARY KEY (appointmentID))");
//
//st.executeUpdate("CREATE TABLE Available_Appointment "
//                        + "(appointmentID INT not NULL, "
//                        + " appointmentDate VARCHAR(100) not NULL, "
//                        + " available BOOLEAN not NULL,"
//                        + " MedicalEmployee_SSN VARCHAR(10) not NULL,"
//                        + " PRIMARY KEY (appointmentID))");
    }

    public void InsertPatientToDB(Patient p) throws SQLException {
        String sql = "INSERT INTO Patient" + " VALUES(" + "'" + p.getFirstName() + "'" + ","
                + "'" + p.getLastName() + "'" + "," + "'" + p.getPhoneNumber() + "'" + "," + "'" + p.getSSN() + "'" + ","
                + "'" + p.getGender() + "'" + ","
                + "'" + p.getEmail() + "'" + ","
                + "'" + p.getCity() + "'" + "," + "'" + p.getBirthDate() + "'" + "," + "'" + p.getPassword() + "'" + ")";
        st.executeUpdate(sql);
         JOptionPane.showMessageDialog(null, "Patient table is affected!");
      
    }

    public void InsertMedicalEmployeeToDB(MedicalEmployee p) throws SQLException {
        st.executeUpdate("INSERT INTO Medical_Employee" + " VALUES(" + "'" + p.getFirstName() + "'" + ","
                + "'" + p.getLastName() + "'" + "," + "'" + p.getPhoneNumber() + "'" + "," + "'" + p.getSSN() + "'" + ","
                + "'" + p.getGender() + "'" + ","
                + "'" + p.getEmail() + "'" + ","
                + "'" + p.getCity() + "'" + "," + "'" + p.getBirthDate() + "'" + "," + "'" + p.getPassword() + "'" + "," + "'"
                + p.getType() + "'" + ")");
         JOptionPane.showMessageDialog(null, "MedicalEmployee table is affected!");
        

    }

    public void InsertAppoentmentToDB(Appointment app) throws SQLException {

        st.executeUpdate("INSERT INTO Appointment" + " VALUES(" + "'" + app.getID() + "'" + ","
                + "'" + app.getAppointmentDate() + "'" + "," + "'" + app.getAvailable() + "'" + "," + "'" + app.getMedicalEmployee().getSSN() + "'" + ","
                + "'" + app.getPatient().getSSN() + "'" + ")");
        JOptionPane.showMessageDialog(null, "Appoentment table is affected!");
        

    }

    public void InsertAvailable_AppointmentToDB(Appointment app) throws SQLException {

        st.executeUpdate("INSERT INTO Available_Appointment" + " VALUES(" + "'" + app.getID() + "'" + ","
                + "'" + app.getAppointmentDate() + "'" + "," + "'" + app.getAvailable() + "'" + "," + "'" + app.getMedicalEmployee().getSSN() + "'" + ")");
        JOptionPane.showMessageDialog(null, "Available_Appointment table is affected!");
        
        
    }

    public static Database getInastance() throws SQLException {

        if (connection == null) {
            url = "CPIT305Project.accdb";
            dbURL = "jdbc:ucanaccess://" + url;
            con = DriverManager.getConnection(dbURL);
            st = (Statement) con.createStatement();
            connection = new Database();
            JOptionPane.showMessageDialog(null, "Initialization went successfully");
        
        }
        return connection;
    }

    public ResultSet executeQuery(String sqlQuery) throws SQLException {

        ResultSet ResultSet = st.executeQuery(sqlQuery);
        return ResultSet;
    }

    public static Statement getSt() {
        return st;
    }

    public void closeConnection() throws SQLException {
        con.close();

    }

}
