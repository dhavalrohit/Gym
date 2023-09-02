/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gym.general.workout;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Workout_Creator extends javax.swing.JFrame {

    Connection con=null;
      ResultSet rs=null;
      Statement st=null;
      PreparedStatement pst=null;
     
    
    
    public Workout_Creator() {
         FlatMacDarkLaf.registerCustomDefaultsSource("Flatlab.propeties");
        FlatMacDarkLaf.setup();
        
        initComponents();
        this.setResizable(false);
        jPanel2.setVisible(false);
        pack();
        setLocationRelativeTo(null);
     
    }

  public void reset(){
  
      levelComboBox.setSelectedIndex(0);
        dayComboBox.setSelectedIndex(0);
        body_part_ComboBox.setSelectedIndex(0);
        exercise_TextField.setText("");
        equipment_TextField.setText("");
        sets_TextField.setText("");
        reps_TextField.setText("");
        rest_TextField.setText("");
        
        
  }
     
  public void add_workout(){
      String level=(String) levelComboBox.getSelectedItem();
      String day=(String) dayComboBox.getSelectedItem();
      String bodypart=(String) body_part_ComboBox.getSelectedItem();
      String exercise=exercise_TextField.getText();
      String equipment=equipment_TextField.getText();
      int reps=Integer.valueOf(reps_TextField.getText());
      int sets=Integer.valueOf(sets_TextField.getText());
      int rest=Integer.valueOf(rest_TextField.getText());
      
      try {
           String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
          String username = "sa";
          String password = "Dhaval@7869";
       
          String query="INSERT INTO [dbo].[workout]\n" +
"           ([Day]\n" +
"           ,[Body_Part]\n" +
"           ,[level_type]\n" +
"           ,[exercise]\n" +
"           ,[equipment]\n" +
"           ,[sets]\n" +
"           ,[reps]\n" +
"           ,[rest])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?)";
          
          con=DriverManager.getConnection(url, username, password);
          pst=con.prepareStatement(query);
          pst.setString(1, day);
          pst.setString(2, bodypart);
          pst.setString(3, level);
          pst.setString(4, exercise);
          pst.setString(5, equipment);
          pst.setInt(6, sets);
          pst.setInt(7, reps);
          pst.setInt(8, rest);
          
          int count=pst.executeUpdate();
          
          if (count>0) {
                  System.out.println("success");
                  JOptionPane.showMessageDialog(new JFrame(), "Workout Added Successfully");
              } else {
                  System.out.println("failure");
                  JOptionPane.showMessageDialog(new JFrame(), "ERROR!:OPERATION FAILED");
              }
          
          
          
      } catch (Exception e) {
                e.printStackTrace();
              JOptionPane.showMessageDialog(new JFrame(), "ERROR!:OPERATION FAILED");
          
      }
  
  }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        levelComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        body_part_ComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        exercise_TextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        equipment_TextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sets_TextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        reps_TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rest_TextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        resetjButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        dayComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(42, 42, 42));
        setForeground(java.awt.Color.white);

        jLabel1.setBackground(new java.awt.Color(243, 66, 66));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Workout Creator");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("LEVEL");

        levelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginner", "Intermediate", "Advanced", " " }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("BODY PART");

        body_part_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chest", "Back", "Shoulder", "Legs", "Bicep", "Tricep", "Arms " }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("EXERCISE");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("EQUIPMENT");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("SETS");

        sets_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sets_TextFieldKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("REPS");

        reps_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reps_TextFieldKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("REST");

        rest_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rest_TextFieldKeyReleased(evt);
            }
        });

        addButton.setText("ADD ");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        resetjButton.setText("RESET");
        resetjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetjButtonActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Level", "Body Part", "Exercise", "Equipment", "Sets", "Reps", "Rest"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("DAY");

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Friday", "Saturday" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 109, Short.MAX_VALUE))
                            .addComponent(exercise_TextField))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(equipment_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resetjButton)
                                .addGap(18, 18, 18)
                                .addComponent(addButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(sets_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(reps_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(rest_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(levelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(body_part_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(levelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(body_part_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exercise_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(equipment_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sets_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reps_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rest_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(resetjButton))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
      
        add_workout();
      
        jPanel2.setVisible(true);
        pack();
        setLocationRelativeTo(null);
        
        DefaultTableModel tabel=(DefaultTableModel) jTable2.getModel();
            String Day=(String) dayComboBox.getSelectedItem();
            String level=(String) levelComboBox.getSelectedItem();
            String bodypart=(String) body_part_ComboBox.getSelectedItem();
            String equipment=equipment_TextField.getText();
            String sets=sets_TextField.getText();
            String exercise=exercise_TextField.getText();
            String reps=reps_TextField.getText();
            String rest=rest_TextField.getText();
            
            tabel.addRow(new Object[]{Day,level,bodypart,exercise,equipment,sets,reps,rest});
        
            reset();
     
    }//GEN-LAST:event_addButtonActionPerformed

    private void resetjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetjButtonActionPerformed
        
        reset();
        
    }//GEN-LAST:event_resetjButtonActionPerformed

    private void sets_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sets_TextFieldKeyReleased
        // TODO add your handling code here:
                               String text=sets_TextField.getText();
      for(int i=0;i<text.length();i++){
         
        if (sets_TextField.getText().length()>0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
            
        }else{
             JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","Hieght Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabet");
                   sets_TextField.setText(null);
        }
 
        
    }
     
    }//GEN-LAST:event_sets_TextFieldKeyReleased

    private void reps_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reps_TextFieldKeyReleased
        // TODO add your handling code here:
                                   String text=reps_TextField.getText();
      for(int i=0;i<text.length();i++){
         
        if (reps_TextField.getText().length()>0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
            
        }else{
             JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","Hieght Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabet");
                   reps_TextField.setText(null);
        }
 
        
    }
    }//GEN-LAST:event_reps_TextFieldKeyReleased

    private void rest_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rest_TextFieldKeyReleased
        // TODO add your handling code here:
      String text=rest_TextField.getText();
      for(int i=0;i<text.length();i++){
         
        if (rest_TextField.getText().length()>0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
            
        }else{
             JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","Hieght Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabet");
                   rest_TextField.setText(null);
        }
 
        
    }
    }//GEN-LAST:event_rest_TextFieldKeyReleased

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
            java.util.logging.Logger.getLogger(Workout_Creator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Workout_Creator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Workout_Creator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Workout_Creator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Workout_Creator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> body_part_ComboBox;
    private javax.swing.JComboBox<String> dayComboBox;
    private javax.swing.JTextField equipment_TextField;
    private javax.swing.JTextField exercise_TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> levelComboBox;
    private javax.swing.JTextField reps_TextField;
    private javax.swing.JButton resetjButton;
    private javax.swing.JTextField rest_TextField;
    private javax.swing.JTextField sets_TextField;
    // End of variables declaration//GEN-END:variables
}
