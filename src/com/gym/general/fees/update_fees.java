/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

//constraiints added on 07/09/2023

package com.gym.general.fees;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.gym.general.fees.Fee_Details;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.gym.connection.connection;

public class update_fees extends javax.swing.JFrame {

    Connection con=null;
      ResultSet rs=null;
      Statement st=null;
      PreparedStatement pst=null;
     
      Fee_Details fee=new Fee_Details();
      
    
    public update_fees() {
         FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
        FlatIntelliJLaf.setup();
       
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        feeidTextField.setEditable(false);
        feeidTextField.setFocusable(false);
        oldamountTextField.setEditable(false);
        durationTextField.setEditable(false);
        
        //get_fee_details();
        newamountTextField.requestFocusInWindow();
        
    }
    
    
    public void set_fee_id(int fee_id){
        feeidTextField.setText(String.valueOf(fee_id));
    }
    
    public void update_fee_value(){
        
        String query="UPDATE [dbo].[fees]\n" +
"   SET \n" +
"      [Amount] = ?\n" +
" WHERE feeID=?";
        int newamount=Integer.valueOf(newamountTextField.getText());
        int feeid=Integer.valueOf(feeidTextField.getText());
        try {
            con=connection.getConnection();
            pst=con.prepareStatement(query);
            pst.setInt(1,newamount );
            pst.setInt(2, feeid);
            int count=pst.executeUpdate();
            if (count>0) {
                System.out.println("Success");
                JOptionPane.showMessageDialog(new JFrame(), "Fee Values Updated Successfully");
                
                
                fee.refersh();
                fee.view_added_fees();
             
                Thread.sleep(500);
                
                dispose();
                
                
                
                
            }
        } catch (Exception e) {
                e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "SQL Exception:Error While Fetching Fee Values");
        
        }
      
    }
    
    public void get_fee_details(){
        System.out.println("Fee Id Value"+feeidTextField.getText());
        int feeid=Integer.valueOf(feeidTextField.getText());
        
        String query="select * from dbo.fees where feeId="+feeid;
      
        try {
            con=connection.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {
                durationTextField.setText(String.valueOf(rs.getInt("Duration")));
                System.out.println(String.valueOf(rs.getInt("Duration")));
                oldamountTextField.setText(String.valueOf(rs.getInt("Amount")));
                System.out.println(String.valueOf(rs.getInt("Amount")));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "SQL Exception:Error While Fetching Fee Values");
        
        }
        
    }
    
    public void clear(){
       oldamountTextField.setText("");
       newamountTextField.setText("");
       durationTextField.setText("");
   
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
  
    
    
  
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        newamountTextField = new javax.swing.JTextField();
        oldamountTextField = new javax.swing.JTextField();
        durationTextField = new javax.swing.JTextField();
        feeidTextField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(310, 310));

        jLabel1.setBackground(new java.awt.Color(32, 161, 93));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UPDATE FESS");
        jLabel1.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("FEE ID");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Duration (Months)");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Old Amount");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("New Amount");

        newamountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newamountTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(durationTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(feeidTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newamountTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(oldamountTextField))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(feeidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(oldamountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(newamountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        updateButton.setBackground(new java.awt.Color(32, 161, 93));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("UPDATE");
        updateButton.setBorderPainted(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(32, 161, 93));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CLOSE");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        boolean checknewamount=check_numericfields(newamountTextField.getText(), "New Amount TextField");
        boolean[] fields={checknewamount};
        boolean checkall=checkallfields(fields);
        if (checkall==true) {
            update_fee_value();
            
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Fields are Empty or Invalid");
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void newamountTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newamountTextFieldKeyReleased
        // TODO add your handling code here:
               String text=String.valueOf(newamountTextField.getText());
      for(int i=0;i<text.length();i++){
         
        if (newamountTextField.getText().length()>0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
            
        }else{
             JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","New Amount Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabet");
                   newamountTextField.setText(null);
        }
 
        
    }
    }//GEN-LAST:event_newamountTextFieldKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JTextField durationTextField;
    private javax.swing.JTextField feeidTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField newamountTextField;
    private javax.swing.JTextField oldamountTextField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
