// Group Names:
// Shuruq Baabdullah 1906284 VBR
// Rahaf Dawoud 1911088 VBR
// Elaf Yousef Aloufi 1911265
// Manar Mutlaq Altaiary 1906775
package CPIT305Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.*;

public class nurses extends javax.swing.JFrame {

    Patient p;
    String MedicalEmployee_SSN;
    String appointmentDate;
    int appointmentID;
    boolean available;
    String appointments;

    public nurses() {
        initComponents();
        jLabel4.setIcon(new ImageIcon("src\\image\\background.png"));
        jLabel1.setIcon(new ImageIcon("src\\image\\back.png"));
        jLabel3.setIcon(new ImageIcon("src\\image\\nurse1.png"));
        // jLabel5.setIcon(new ImageIcon("src\\image\\nurse2.png"));
        //jLabel6.setIcon(new ImageIcon("src\\image\\nurse3.png"));
        Database instance;
        try {
            instance = Database.getInastance();
            ResultSet res2 = instance.executeQuery("SELECT * FROM Available_Appointment");
            if (!res2.wasNull()) {
                while (res2.next()) {
                    appointmentID = res2.getInt("appointmentID");
                    appointmentDate = res2.getString("appointmentDate");

                    available = res2.getBoolean("available");
                    MedicalEmployee_SSN = res2.getString("MedicalEmployee_SSN");
                    String state;
                    if (available == true) {
                        state = "Available";
                    } else {
                        state = "Not Available";
                    }
                    appointments = appointmentID + " " + appointmentDate + " " + state + " " + MedicalEmployee_SSN;
                    jLabel5.setText(appointments);
                    jButton1.setText("Book");
//                    jTextPane1.setText(jTextPane1.getText()
//                            + appointmentID + " " + appointmentDate + " " + available + " " + MedicalEmployee_SSN);
                }

            }
        } catch (SQLException ex) {
            
        }

    }

    public nurses(Patient patient) {
        initComponents();
        jLabel4.setIcon(new ImageIcon("src\\image\\background.png"));
        jLabel1.setIcon(new ImageIcon("src\\image\\back.png"));
        jLabel3.setIcon(new ImageIcon("src\\image\\nurse1.png"));
        // jLabel5.setIcon(new ImageIcon("src\\image\\nurse2.png"));
        //jLabel6.setIcon(new ImageIcon("src\\image\\nurse3.png"));
        Database instance;
        this.p = patient;
        try {
            instance = Database.getInastance();
            ResultSet res2 = instance.executeQuery("SELECT * FROM Available_Appointment");
            if (!res2.wasNull()) {
                while (res2.next()) {
                    appointmentID = res2.getInt("appointmentID");
                    appointmentDate = res2.getString("appointmentDate");
                    available = res2.getBoolean("available");
                    MedicalEmployee_SSN = res2.getString("MedicalEmployee_SSN");
                    jTextPane1.setText(jTextPane1.getText()
                            + appointmentID + " " + appointmentDate + " " + available + " " + MedicalEmployee_SSN);
                }
            }
        } catch (SQLException ex) {
            new ErrorMessagge(ex.toString()).setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        call1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 100));

        call1.setBackground(new java.awt.Color(255, 255, 255));
        call1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        call1.setForeground(new java.awt.Color(153, 124, 168));
        call1.setText("Call");
        call1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(112, 112, 112))); // NOI18N
        call1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                call1ActionPerformed(evt);
            }
        });
        jPanel2.add(call1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 70, 30));

        jButton1.setBackground(new java.awt.Color(153, 124, 168));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 100, -1));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 250, 50));

        jScrollPane1.setViewportView(jTextPane1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 270, 360));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 390, 490));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(112, 112, 112));
        jLabel2.setText("Nurses");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 414, 896));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        new home(p).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void call1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_call1ActionPerformed
        // TODO add your handling code here:
       new clientChat().setVisible(true);
        

    }//GEN-LAST:event_call1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new payment(MedicalEmployee_SSN, p, appointmentDate, appointmentID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(nurses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nurses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nurses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nurses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nurses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton call1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
