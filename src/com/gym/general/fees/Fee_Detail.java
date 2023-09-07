/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gym.general.fees;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ButtonUI;
import net.proteanit.sql.DbUtils;


public class Fee_Detail extends javax.swing.JFrame {

    Connection con=null;
      ResultSet rs=null;
      Statement st=null;
      PreparedStatement pst=null;
      
      int selectedrow;
      
    
    public Fee_Detail() {
         FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
        FlatIntelliJLaf.setup();
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     
    }
    
    public void showFeesDetails(){
    
          String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        
         selectedrow= jTable1.getSelectedRow();
        String selectedfeeID=  jTable1.getModel().getValueAt(selectedrow, 1).toString();
        System.out.println(selectedfeeID);
        
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        update_Button = new javax.swing.JButton();
        updateALL_Button = new javax.swing.JButton();
        view_Button = new javax.swing.JButton();
        new_Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fee Managment");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(32, 161, 93));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FEE MANAGEMENT");
        jLabel1.setOpaque(true);

        update_Button.setBackground(new java.awt.Color(32, 161, 93));
        update_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        update_Button.setForeground(java.awt.Color.white);
        update_Button.setText("UPDATE");
        update_Button.setBorderPainted(false);
        update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_ButtonActionPerformed(evt);
            }
        });

        updateALL_Button.setBackground(new java.awt.Color(32, 161, 93));
        updateALL_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        updateALL_Button.setForeground(java.awt.Color.white);
        updateALL_Button.setText("UPDATE ALL");
        updateALL_Button.setBorderPainted(false);

        view_Button.setBackground(new java.awt.Color(32, 161, 93));
        view_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        view_Button.setForeground(java.awt.Color.white);
        view_Button.setText("VIEW");
        view_Button.setBorderPainted(false);
        view_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_ButtonActionPerformed(evt);
            }
        });

        new_Button.setBackground(new java.awt.Color(32, 161, 93));
        new_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        new_Button.setForeground(java.awt.Color.white);
        new_Button.setText("NEW");
        new_Button.setBorderPainted(false);
        new_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_ButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FEE ID", "DURATION(MONTHS)", "AMOUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(new_Button)
                        .addGap(18, 18, 18)
                        .addComponent(update_Button)
                        .addGap(18, 18, 18)
                        .addComponent(updateALL_Button)
                        .addGap(18, 18, 18)
                        .addComponent(view_Button))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_Button)
                    .addComponent(update_Button)
                    .addComponent(updateALL_Button)
                    .addComponent(view_Button))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void new_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_ButtonActionPerformed
        // TODO add your handling code here:
        new add_new_fees().setVisible(true);
        
        
        
    }//GEN-LAST:event_new_ButtonActionPerformed

    private void view_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_ButtonActionPerformed
        // TODO add your handling code here:
        view_added_fees();
    }//GEN-LAST:event_view_ButtonActionPerformed

    private void update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_ButtonActionPerformed
        // TODO add your handling code here:
        showFeesDetails();
        new update_fees().setVisible(true);
        
        
    }//GEN-LAST:event_update_ButtonActionPerformed

    public void view_added_fees(){
          String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
         String query="select feeid as FEE_ID,duration as DURATION_MONTHS,amount as AMOUNT from dbo.fees";
         
         try {
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            rs=st.executeQuery(query);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
             JOptionPane.showMessageDialog(new JFrame(),"ERROR" );
             e.printStackTrace();
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
            java.util.logging.Logger.getLogger(Fee_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fee_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fee_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fee_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fee_Detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton new_Button;
    private javax.swing.JButton updateALL_Button;
    private javax.swing.JButton update_Button;
    private javax.swing.JButton view_Button;
    // End of variables declaration//GEN-END:variables
}
