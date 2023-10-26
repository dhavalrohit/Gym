/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//Constraints set on 06-09-2023
package com.gym.general.fees;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.gym.connection.connection;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class add_new_fees extends javax.swing.JFrame {

    
    
    Connection con=null;
      ResultSet rs=null;
      Statement st=null;
      PreparedStatement pst=null;
     
      int total=0;
    
    public add_new_fees() throws IOException {
        FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
        FlatIntelliJLaf.setup();
        
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        get_fee_id();
        
    }

    public void get_fee_id() throws IOException{
      
         String query="select feeid from attendance_manager_new.dbo.fees ";
        try {
            con=connection.getConnection();
            st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=st.executeQuery(query);
            if(rs.last()){
                System.out.println(rs.getInt("feeid"));
                //total=rs.getInt("lastid");
                //System.out.println(total+1);
                total=rs.getInt("feeid");
                System.out.println(total);
                total=total+1;
                fee_id_TextField.setText(String.valueOf(total));
                fee_id_TextField.setEditable(false);
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(),"ERROR");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(),"SQL ERROR");
            ex.printStackTrace();
            Logger.getLogger(add_new_fees.class.getName()).log(Level.SEVERE, null, ex);
            dispose();
        }
         
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
    
   public void clear(){
       amount_TextField.setText("");
       duration_TextField.setText("");
   
   }
      
      
    public void add_fee() throws IOException{
      
        String query="insert into fees values(?,?)";
        
        
        
        if (amount_TextField.getText().isEmpty() && duration_TextField.getText().isEmpty()) {
            System.out.println("empty");
            JOptionPane.showMessageDialog(new JFrame(), "Amount/Duration fields empty");
        }
        else{
            System.out.println("not empty");
            int duration=Integer.parseInt(duration_TextField.getText());
            int amount=Integer.parseInt(amount_TextField.getText());
            try{
            
            con=connection.getConnection();
            pst=con.prepareStatement(query);
            pst.setInt(1, duration);
            pst.setInt(2, amount);
            int count=pst.executeUpdate();
            
                if (count>0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Added Succesfully"); 
                    clear();
                    get_fee_id();
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "Operation Failed"); 
                }
            
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(new JFrame(), "SQL Exception"); 
                e.printStackTrace();
            }
        
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        amount_TextField = new javax.swing.JTextField();
        fee_id_TextField = new javax.swing.JTextField();
        duration_TextField = new javax.swing.JTextField();
        add_Button = new javax.swing.JButton();
        clear_Button = new javax.swing.JButton();
        close_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(32, 161, 93));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD/UPDATE FESS");
        jLabel1.setOpaque(true);

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

        add_Button.setBackground(new java.awt.Color(32, 161, 93));
        add_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        add_Button.setForeground(new java.awt.Color(255, 255, 255));
        add_Button.setText("ADD");
        add_Button.setBorderPainted(false);
        add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ButtonActionPerformed(evt);
            }
        });

        clear_Button.setBackground(new java.awt.Color(32, 161, 93));
        clear_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        clear_Button.setForeground(new java.awt.Color(255, 255, 255));
        clear_Button.setText("CLEAR");
        clear_Button.setBorderPainted(false);
        clear_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_ButtonActionPerformed(evt);
            }
        });

        close_Button.setBackground(new java.awt.Color(32, 161, 93));
        close_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        close_Button.setForeground(new java.awt.Color(255, 255, 255));
        close_Button.setText("CLOSE");
        close_Button.setBorderPainted(false);
        close_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_ButtonActionPerformed(evt);
            }
        });

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
                        .addComponent(add_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clear_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(close_Button)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fee_id_TextField)
                            .addComponent(duration_TextField))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_Button)
                    .addComponent(clear_Button)
                    .addComponent(close_Button))
                .addContainerGap(17, Short.MAX_VALUE))
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fee_id_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fee_id_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fee_id_TextFieldActionPerformed

    private void duration_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duration_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duration_TextFieldActionPerformed

    private void add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ButtonActionPerformed
        // TODO add your handling code here:
         boolean checkdur=check_numericfields(duration_TextField.getText(),"Dration");
         boolean checkamount=check_numericfields(amount_TextField.getText(),"Amount");
         System.out.println(checkdur);
         System.out.println(checkamount);
        boolean[] fields={checkdur,checkamount};
        boolean finalres=checkallfields(fields);
         if (finalres==true) {
             try {
                 add_fee();
             } catch (IOException ex) {
                 Logger.getLogger(add_new_fees.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(new JFrame(), "Connection File Error");
             }
        }
         else{
             JOptionPane.showMessageDialog(new JFrame(), "Constraint Error");
         }
         
    }//GEN-LAST:event_add_ButtonActionPerformed

   
    
    private void duration_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duration_TextFieldKeyReleased
        // TODO add your handling code here:
           
                    String text=String.valueOf(duration_TextField.getText());
      for(int i=0;i<text.length();i++){
         
        if (duration_TextField.getText().length()>0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
            
        }else{
             JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","Hieght Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabet");
                   amount_TextField.setText(null);
        }
 
        
    }
      
    }//GEN-LAST:event_duration_TextFieldKeyReleased

    private void amount_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amount_TextFieldKeyReleased
        
              
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

    private void clear_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_ButtonActionPerformed
        // TODO add your handling code here:
        duration_TextField.setText("");
        amount_TextField.setText("");
    }//GEN-LAST:event_clear_ButtonActionPerformed

    private void close_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_ButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_close_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(add_new_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_new_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_new_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_new_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new add_new_fees().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(add_new_fees.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(new JFrame(), "Connection File Error");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_Button;
    private javax.swing.JTextField amount_TextField;
    private javax.swing.JButton clear_Button;
    private javax.swing.JButton close_Button;
    private javax.swing.JTextField duration_TextField;
    private javax.swing.JTextField fee_id_TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
