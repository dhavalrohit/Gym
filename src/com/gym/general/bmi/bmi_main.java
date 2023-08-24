/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gym.general.bmi;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.gym.buiseness.PrintBMIReport;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class bmi_main extends javax.swing.JFrame {

    String gender;
    float bmiindex;
    
    public bmi_main() {
       FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
       FlatIntelliJLaf.setup();
        
        initComponents();
        
        bmi_result_TextField.setEnabled(false);
        Fat_Perc_ResultLabel.setEnabled(false);
        
        
    }

    
    
    public void calculateBMI()
    {
        float hieght_feet=Float.parseFloat(feet_TextField.getText());
        float hieght_in=Float.parseFloat(inches_TextField.getText());
      // float hieght_cm=Float.parseFloat(hieght_cm_TextField.getText());
      
      
      
        float wieght=Float.parseFloat(wieght_TextField.getText());
        
        float hieght_meters=(float) (hieght_feet*0.3048+hieght_in*0.0254);
        
         float square_root=(float)Math.pow(hieght_meters, 2);
         float bmi=wieght/square_root;
        
        if(bmi>=18.5 && bmi<=24.9)
        {
            System.out.println(bmi);
            bmi_result_TextField.setEnabled(true);
            bmi_result_TextField.setText(String.valueOf(bmi));
            
            bmiindex=bmi;
            JOptionPane.showMessageDialog(rootPane, "you are under Normal weight","BMI Chart Message",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(bmi>24.9)
        {
            if(bmi>29.9)
            {
             System.out.println(bmi);
           bmi_result_TextField.setEnabled(true);
            bmi_result_TextField.setText(String.valueOf(bmi));
             bmiindex=bmi;
            JOptionPane.showMessageDialog(rootPane, "Obese","BMI Chart Message",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                System.out.println(bmi);
           bmi_result_TextField.setEnabled(true);
            bmi_result_TextField.setText(String.valueOf(bmi));
             bmiindex=bmi;
                System.out.println(bmi);
                JOptionPane.showMessageDialog(rootPane, "Overweight","BMI Chart Message",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(bmi < 18.5)
        {
            System.out.println(bmi);
            bmi_result_TextField.setEnabled(true);
            bmi_result_TextField.setText(String.valueOf(bmi));
            bmiindex=bmi;
            System.out.println(bmi);
            JOptionPane.showMessageDialog(rootPane, "Underweight", "BMI Chart Message",JOptionPane.ERROR_MESSAGE);
        }
        
             
             
     }
    
     public void calculateFatForMan()
    {
        
        float kg,pound;
        kg=Float.parseFloat(wieght_TextField.getText());
        pound=kg*2.2046f;
        float waist=Float.parseFloat(waist_TextField.getText());
        float val1=(pound*1.082f)+94.42f;
        float val2=(waist*4.15f);
        float lbm=val1-val2;
        float val3=pound-lbm;
        float bmass=val3/pound*100;
        fat_result_TextField.setEnabled(true);
        fat_result_TextField.setText(String.valueOf(bmass));
        
    }
       public void calculateFatForWoman()
    {
        float kg,pound,
        value1,value2,value3,value4,value5,value6,value7,value8,value9,value10;
        
        kg=Float.parseFloat(wieght_TextField.getText());
        float waist=Float.parseFloat(waist_TextField.getText());
        float hips=Float.parseFloat(hips_TextField.getText());
        float forearm=Float.parseFloat(forearm_TextField.getText());
        pound=kg*2.2046f;
        value1=pound*0.732f;
        value2=value1+8.987f;
        value3=waist/3.14f;
        value4=waist*0.157f;
        value5=hips*0.249f;
        value6=forearm*0.434f;
        value7=value2+value3;
        value8=value7-value4;
        value9=value8-value5;
        float lbm=value6+value9;
        value10=pound-lbm;
        float fat=value10/pound*100;
        fat_result_TextField.setEnabled(true);
        fat_result_TextField.setText(String.valueOf(fat));
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderbuttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        feet_TextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inches_TextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hieght_cm_TextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        wieght_TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BMI_ResultLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        waist_TextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        wrist_TextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        forearm_TextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        hips_TextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        print_report_Button = new javax.swing.JButton();
        Fat_Perc_ResultLabel = new javax.swing.JLabel();
        bmi_result_TextField = new javax.swing.JTextField();
        fat_result_TextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BMI_Button = new javax.swing.JButton();
        calculate_fat_Button = new javax.swing.JButton();
        reset_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("NAME");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("ENTER HIEGHT");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("feet");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("In");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setText("cm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setText("ENTER WEIGHT");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setText("Kg");

        BMI_ResultLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        BMI_ResultLabel.setText("FAT%");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setText("GENDER");

        genderbuttonGroup.add(maleRadioButton);
        maleRadioButton.setText("Male");
        maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButtonActionPerformed(evt);
            }
        });

        genderbuttonGroup.add(femaleRadioButton);
        femaleRadioButton.setText("Female");
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setText("ENTER WAIST");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel12.setText("WRIST");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel13.setText("(In)");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel14.setText("(In)");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel15.setText("FOREARM");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel16.setText("(In)");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel17.setText("HIPS");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel18.setText("(In)");

        print_report_Button.setBackground(new java.awt.Color(32, 161, 93));
        print_report_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        print_report_Button.setForeground(java.awt.Color.white);
        print_report_Button.setText("PRINT REPORT");
        print_report_Button.setBorderPainted(false);
        print_report_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_report_ButtonActionPerformed(evt);
            }
        });

        Fat_Perc_ResultLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Fat_Perc_ResultLabel.setText("BMI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(print_report_Button)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(waist_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wrist_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fat_result_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(forearm_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hips_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(64, 64, 64)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(feet_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(inches_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(wieght_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)))
                                .addGap(22, 22, 22)
                                .addComponent(hieght_cm_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(37, 37, 37)
                                .addComponent(maleRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(femaleRadioButton)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Fat_Perc_ResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bmi_result_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BMI_ResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(feet_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(inches_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(hieght_cm_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(wieght_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(maleRadioButton)
                    .addComponent(femaleRadioButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(waist_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(wrist_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(forearm_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(hips_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BMI_ResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fat_Perc_ResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bmi_result_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fat_result_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(print_report_Button))
        );

        jLabel9.setBackground(new java.awt.Color(32, 161, 93));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("BMI CALCULATOR");
        jLabel9.setOpaque(true);

        BMI_Button.setBackground(new java.awt.Color(32, 161, 91));
        BMI_Button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BMI_Button.setForeground(java.awt.Color.white);
        BMI_Button.setText("CALCULATE BMI");
        BMI_Button.setBorderPainted(false);
        BMI_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMI_ButtonActionPerformed(evt);
            }
        });

        calculate_fat_Button.setBackground(new java.awt.Color(32, 161, 91));
        calculate_fat_Button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        calculate_fat_Button.setForeground(java.awt.Color.white);
        calculate_fat_Button.setText("CALCULATE FAT %");
        calculate_fat_Button.setBorderPainted(false);
        calculate_fat_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate_fat_ButtonActionPerformed(evt);
            }
        });

        reset_Button.setBackground(new java.awt.Color(32, 161, 91));
        reset_Button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reset_Button.setForeground(java.awt.Color.white);
        reset_Button.setText("RESET");
        reset_Button.setBorderPainted(false);
        reset_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(BMI_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calculate_fat_Button)
                        .addGap(9, 9, 9)
                        .addComponent(reset_Button)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BMI_Button)
                    .addComponent(calculate_fat_Button)
                    .addComponent(reset_Button))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void BMI_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMI_ButtonActionPerformed
        // TODO add your handling code here:
        calculateBMI();
    }//GEN-LAST:event_BMI_ButtonActionPerformed

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButtonActionPerformed
        // TODO add your handling code here:
        gender="male";
        wrist_TextField.setEnabled(false);
        hips_TextField.setEnabled(false);
        forearm_TextField.setEnabled(false);
        
    }//GEN-LAST:event_maleRadioButtonActionPerformed

    private void calculate_fat_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculate_fat_ButtonActionPerformed
        // TODO add your handling code here:
        if (gender.equalsIgnoreCase("male")) {
            calculateFatForMan();
        }else{
            calculateFatForWoman();
        }
        
        
    }//GEN-LAST:event_calculate_fat_ButtonActionPerformed

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioButtonActionPerformed
        // TODO add your handling code here:
         gender="female";
        wrist_TextField.setEnabled(true);
        hips_TextField.setEnabled(true);
        forearm_TextField.setEnabled(true);
        
    }//GEN-LAST:event_femaleRadioButtonActionPerformed

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
        nameTextField.setText("");
        hieght_cm_TextField.setText("");
        feet_TextField.setText("");
        inches_TextField.setText("");
        wieght_TextField.setText("");
        hips_TextField.setText("");
        forearm_TextField.setText("");
        waist_TextField.setText("");
        wrist_TextField.setText("");
        genderbuttonGroup.clearSelection();
        BMI_ResultLabel.setVisible(false);
    }//GEN-LAST:event_reset_ButtonActionPerformed

    private void print_report_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_report_ButtonActionPerformed
        // TODO add your handling code here:
        
          try{
            String name,gender,height,weight,bmi,fat,category = null,waist,wrist,forearm,hips;
            gender=this.gender;
            name=nameTextField.getText();
            height=(feet_TextField.getText()+"Ft ")+(inches_TextField.getText()+"In");
            weight=wieght_TextField.getText();
            bmi=String.valueOf(bmiindex);
            waist=waist_TextField.getText();
            wrist=wrist_TextField.getText();
            hips=hips_TextField.getText();
            forearm=forearm_TextField.getText();
            fat=fat_result_TextField.getText();
            float f=Float.parseFloat(fat);
            if(gender.equals("male"))
            {
                if(f>=2 && f<=4)
                {
                    category="Essential Fat";
                }
                else if(f>=6 && f<=13)
                {
                    category="Athletic";
                }
                else if(f>=14 && f<=17)
                {
                    category="Fitness";
                }
                else if(f>=18 && f<=25)
                {
                    category="average";
                }
                else if(f>=26)
                {
                    category="Obese";
                }
            }
            else
            {
                if(f>=10 && f<=12)
                {
                    category="Essential Fat";
                }
                else if(f>=14 && f<=20)
                {
                    category="Athletic";
                }
                else if(f>=21 && f<=24)
                {
                    category="Fitness";
                }
                else if(f>=25 && f<=31)
                {
                    category="average";
                }
                else if(f>=32)
                {
                    category="Obese";
                }
            }
            PrintBMIReport pbm=new PrintBMIReport();
            pbm.jLabel12.setText(name);
            pbm.jLabel13.setText(gender);
            pbm.jLabel14.setText(weight);
            pbm.jLabel15.setText(height);
            pbm.jLabel16.setText(bmi);
            pbm.jLabel17.setText(waist);
            pbm.jLabel18.setText(wrist);
            pbm.jLabel19.setText(forearm);
            pbm.jLabel20.setText(hips);
            pbm.jLabel21.setText(fat);
            pbm.jLabel22.setText(category);
            pbm.setVisible(rootPaneCheckingEnabled);
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
        
    }//GEN-LAST:event_print_report_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(bmi_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bmi_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bmi_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bmi_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bmi_main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BMI_Button;
    private javax.swing.JLabel BMI_ResultLabel;
    private javax.swing.JLabel Fat_Perc_ResultLabel;
    private javax.swing.JTextField bmi_result_TextField;
    private javax.swing.JButton calculate_fat_Button;
    private javax.swing.JTextField fat_result_TextField;
    private javax.swing.JTextField feet_TextField;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JTextField forearm_TextField;
    private javax.swing.ButtonGroup genderbuttonGroup;
    private javax.swing.JTextField hieght_cm_TextField;
    private javax.swing.JTextField hips_TextField;
    private javax.swing.JTextField inches_TextField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton print_report_Button;
    private javax.swing.JButton reset_Button;
    private javax.swing.JTextField waist_TextField;
    private javax.swing.JTextField wieght_TextField;
    private javax.swing.JTextField wrist_TextField;
    // End of variables declaration//GEN-END:variables
}
