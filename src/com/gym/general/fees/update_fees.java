/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

//constraiints added on 07/09/2023

package com.gym.general.fees;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.gym.general.fees.Fee_Detail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class update_fees extends javax.swing.JFrame {

    Connection con=null;
      ResultSet rs=null;
      Statement st=null;
      PreparedStatement pst=null;
     
    
    public update_fees() {
         FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
        FlatIntelliJLaf.setup();
       
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    public void clear(){
       amount_TextField.setText("");
       duration_TextField.setText("");
   
   }
    
    
     public boolean check_numericfields(String text,String fieldname){
        text=text.replaceAll("\\s", "");
          boolean res=true;
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), fieldname+" Field is Empty", fieldname+" Field Error",JOptionPane.ERROR_MESSAGE);
            res=false;
        }
        else if(text.length()>0)
            for(int i=0;i<text.length();i++){
                if (Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
                    
                }
                else{
                     JOptionPane.showMessageDialog(new JFrame(), fieldname+" Field contains Alphabetic value", fieldname+" Field Error",JOptionPane.ERROR_MESSAGE);
                    res=false;
                    break;
                }
            }
        
        return res;
    }
    
       public boolean checkallfields(boolean [] fields){
        boolean res=true;
        
        for(int i=0;i<fields.length;i++){
            if (fields[i]==false) {
                res=false;
                break;
            }
            else{
                res=true;
                
            }
        }
        return res;
    
    }
  
    
    
public void get_fees_details(){
    String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
        //String query=""
        
        try {
            con=DriverManager.getConnection(url, username, password);
            
        
    } catch (Exception e) {
    }
    
}
    
    public void update_fees(){
    String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
      // String query="select feeid as FEE_ID,duaration as DURATION,amount as AMOUNT from dbo.fees";
         
    
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        amount_TextField = new javax.swing.JTextField();
        fee_id_TextField = new javax.swing.JTextField();
        duration_TextField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(290, 240));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("FEE ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("DURATION");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("AMOUNT");

        amount_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amount_TextFieldKeyReleased(evt);
            }
        });

        fee_id_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fee_id_TextFieldActionPerformed(evt);
            }
        });

        duration_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duration_TextFieldActionPerformed(evt);
            }
        });
        duration_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                duration_TextFieldKeyReleased(evt);
            }
        });

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jButton3.setText("CANCEL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(amount_TextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fee_id_TextField)
                            .addComponent(duration_TextField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fee_id_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(duration_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amount_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(clearButton)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(32, 161, 93));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UPDATE FESS");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(67, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fee_id_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fee_id_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fee_id_TextFieldActionPerformed

    private void duration_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duration_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duration_TextFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        boolean checkdur=check_numericfields(duration_TextField.getText(),"Dration");
         boolean checkamount=check_numericfields(amount_TextField.getText(),"Amount");
         System.out.println(checkdur);
         System.out.println(checkamount);
        boolean[] fields={checkdur,checkamount};
        boolean finalres=checkallfields(fields);
         if (finalres==true) {
            update_fees();
        }
         else{
             JOptionPane.showMessageDialog(new JFrame(), "Constraint Error");
         }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void duration_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duration_TextFieldKeyReleased
        // TODO add your handling code here:
        
                        String text=String.valueOf(duration_TextField.getText());
      for(int i=0;i<text.length();i++){
         
        if (duration_TextField.getText().length()>0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
            
        }else{
             JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","Hieght Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabet");
                   duration_TextField.setText(null);
        }
 
        
    }
    }//GEN-LAST:event_duration_TextFieldKeyReleased

    private void amount_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amount_TextFieldKeyReleased
        // TODO add your handling code here:
                        String text=String.valueOf(amount_TextField.getText());
      for(int i=0;i<text.length();i++){
        
          
        if (amount_TextField.getText().length()>0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
            
        }
        else{
             JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","Hieght Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabet");
                   amount_TextField.setText(null);
        }
 
        
    }
    }//GEN-LAST:event_amount_TextFieldKeyReleased

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

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
            java.util.logging.Logger.getLogger(update_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(update_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(update_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(update_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new update_fees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount_TextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField duration_TextField;
    private javax.swing.JTextField fee_id_TextField;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
