/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gym.general.fees;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author DELL
 */
public class payment_history extends javax.swing.JFrame {
     
     Connection con=null;
      ResultSet rs=null;
      Statement st=null;
      PreparedStatement pst=null;
      
      TextPrompt memberid_prompt;
     TextPrompt membername_prompt;
     TextPrompt mobileno_prompt;
     
      
    public payment_history() {
         FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
         FlatIntelliJLaf.setup();
  
        initComponents();
        show_payment_history();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        memberid_prompt=new TextPrompt("Enter Member ID to Search", member_id_no_search_TextField);
        memberid_prompt.setForeground(Color.GRAY);
        memberid_prompt.setHorizontalAlignment((int) LEFT_ALIGNMENT);
        memberid_prompt.changeStyle(Font.BOLD+Font.ITALIC);
        memberid_prompt.setShowPromptOnce(true);
        
        membername_prompt=new TextPrompt("Enter Name to Search", name_search_TextField);
        membername_prompt.setForeground(Color.GRAY);
        membername_prompt.setHorizontalAlignment((int) LEFT_ALIGNMENT);
        membername_prompt.changeStyle(Font.BOLD+Font.ITALIC);
        membername_prompt.setShowPromptOnce(true);
        
        mobileno_prompt=new TextPrompt("Enter Mobile No to Search", mobile_no_search_TextField);
        mobileno_prompt.setForeground(Color.GRAY);
        mobileno_prompt.setHorizontalAlignment((int) LEFT_ALIGNMENT);
        mobileno_prompt.changeStyle(Font.BOLD+Font.ITALIC);
        mobileno_prompt.setShowPromptOnce(true);
        
    }
    


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        name_search_TextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search_Button = new javax.swing.JButton();
        refershButton = new javax.swing.JButton();
        mobile_no_search_TextField = new javax.swing.JTextField();
        member_id_no_search_TextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(32, 161, 91));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Payment History");
        jLabel1.setOpaque(true);

        name_search_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                name_search_TextFieldFocusGained(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PAYMENT ID", "DATE", "MEMBER ID", "NAME", "DURATION", "TOTAL FEES", "PAID AMOUNT", "PENDING AMOUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        search_Button.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\search.png")); // NOI18N
        search_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_ButtonActionPerformed(evt);
            }
        });

        refershButton.setText("Refresh");
        refershButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refershButtonActionPerformed(evt);
            }
        });

        mobile_no_search_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mobile_no_search_TextFieldFocusGained(evt);
            }
        });

        member_id_no_search_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                member_id_no_search_TextFieldFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(name_search_TextField)
                        .addGap(18, 18, 18)
                        .addComponent(mobile_no_search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(member_id_no_search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refershButton)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refershButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobile_no_search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(member_id_no_search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(search_Button))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void name_search_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_name_search_TextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_name_search_TextFieldFocusGained

    private void refershButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refershButtonActionPerformed
        // TODO add your handling code here:
        show_payment_history();
    }//GEN-LAST:event_refershButtonActionPerformed

    private void mobile_no_search_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobile_no_search_TextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile_no_search_TextFieldFocusGained

    private void member_id_no_search_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_member_id_no_search_TextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_member_id_no_search_TextFieldFocusGained

    private void search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_ButtonActionPerformed
       String nameSearch = name_search_TextField.getText();
    String mobileSearch = mobile_no_search_TextField.getText();
    String memberIdSearch = member_id_no_search_TextField.getText();

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
     int rowCount = model.getRowCount();
    for (int i = rowCount - 1; i >= 0; i--) {
        String name = model.getValueAt(i, 3).toString(); 
        String mobile = model.getValueAt(i, 2).toString(); 
        String memberId = model.getValueAt(i, 3).toString(); 

        if (!name.toLowerCase().contains(nameSearch.toLowerCase()) ||
            !mobile.toLowerCase().contains(mobileSearch.toLowerCase()) ||
            !memberId.toLowerCase().contains(memberIdSearch.toLowerCase())) {
            model.removeRow(i);
        }
    }







    }//GEN-LAST:event_search_ButtonActionPerformed

    public void show_payment_history(){
        
         String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
        
        String query="select payment_id as PAYMENT_ID,payment_date as DATE,member_ID as MEMBER_ID,dbo.Mst_Employee.EmpName as NAME, \n" +
"DURATION as DURATION, total_fees as TOTAL_FESS,current_payment as PAID_AMOUNT,balance as PENDING_AMOUNT\n" +
" from attendance_manager.dbo.payments inner join dbo.Mst_Employee\n" +
" on attendance_manager.dbo.payments.member_id=attendance_manager.dbo.Mst_Employee.EmpId";
        
        try {
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            rs=st.executeQuery(query);
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "SQL ERROR");
        }
        
        
        
        
    }
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
            java.util.logging.Logger.getLogger(payment_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payment_history().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField member_id_no_search_TextField;
    private javax.swing.JTextField mobile_no_search_TextField;
    private javax.swing.JTextField name_search_TextField;
    private javax.swing.JButton refershButton;
    private javax.swing.JButton search_Button;
    // End of variables declaration//GEN-END:variables
}
