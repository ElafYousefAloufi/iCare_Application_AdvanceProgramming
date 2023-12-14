// Group Names:
// Shuruq Baabdullah 1906284 VBR
// Rahaf Dawoud 1911088 VBR
// Elaf Yousef Aloufi 1911265
// Manar Mutlaq Altaiary 1906775
package CPIT305Project;

import java.io.FileNotFoundException;
import java.io.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Application {

    static BufferedReader readPatien;
    static BufferedReader readAdmin;
    static BufferedReader readAppointment;
    static BufferedReader readMedicalEmployee;

    static BufferedWriter writePatient;
    static BufferedWriter writeAdmin;
    static BufferedWriter writeAppointment;
    static BufferedWriter writeMedicalEmployee;

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        readPatien = new BufferedReader(new FileReader("Patient.txt"));
        readAdmin = new BufferedReader(new FileReader("Admin.txt"));
        readAppointment = new BufferedReader(new FileReader("Appointment.txt"));
        readMedicalEmployee = new BufferedReader(new FileReader("MedicalEmployee.txt"));
        writePatient = new BufferedWriter(new FileWriter("Patient.txt"));
        writeAdmin = new BufferedWriter(new FileWriter("Admin.txt"));
        writeAppointment = new BufferedWriter(new FileWriter("Appointment.txt"));
        writeMedicalEmployee = new BufferedWriter(new FileWriter("MedicalEmployee.txt"));

        try {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new start().setVisible(true);

                }
            });

        } catch (Exception x) {
            new ErrorMessagge(x.toString()).setVisible(true);

        }
    }

    public static void addToWrite(BufferedWriter write, String string) throws IOException {
        write.append(string);
    }

    public static void close(BufferedWriter write) throws IOException {

        write.close();

    }

    //         public static void addToDB(BufferedWriter write,String string) throws IOException{
//           
//             while(readPatien.ready()!=false){
//                 String[] FS= readPatien.readLine().split(" ");
//                 System.out.println(FS[0]);
//                 Paitent p1=new Paitent{}
//             
//             
//             }
}
