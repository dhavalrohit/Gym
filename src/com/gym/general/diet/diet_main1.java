/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gym.general.diet;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class diet_main1 extends javax.swing.JFrame {

   private static enterdiet dietentrypage;
   String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
   int currentday=0;
    
   ArrayList<Diet_Model> weeklydietplan=new ArrayList<>();
    
   public diet_main1() {
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dayLabel.setText(days[currentday]);
        
    
   }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane31 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane32 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        dayLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        breakfastTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        lunchTextArea = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        dinnerTextArea = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        snacksTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();
        pdfButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane31.setViewportView(jTextArea4);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane32.setViewportView(jTextArea5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));

        dayLabel.setBackground(new java.awt.Color(32, 161, 93));
        dayLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dayLabel.setForeground(java.awt.Color.white);
        dayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel.setText("Monday");
        dayLabel.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(32, 161, 93));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WEEKLY DIET PLAN");
        jLabel2.setOpaque(true);

        breakfastTextArea.setColumns(20);
        breakfastTextArea.setRows(5);
        jScrollPane1.setViewportView(breakfastTextArea);

        lunchTextArea.setColumns(20);
        lunchTextArea.setRows(5);
        jScrollPane2.setViewportView(lunchTextArea);

        dinnerTextArea.setColumns(20);
        dinnerTextArea.setRows(5);
        jScrollPane7.setViewportView(dinnerTextArea);

        snacksTextArea.setColumns(20);
        snacksTextArea.setRows(5);
        jScrollPane8.setViewportView(snacksTextArea);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Breakfast");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Lunch");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Dinner");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Snacks");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addComponent(jScrollPane8))
                        .addGap(6, 6, 6)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(dayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(473, Short.MAX_VALUE)))
        );

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        pdfButton.setText("Save PDF");

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next Day");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setText("Previous Day");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(509, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previousButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addGap(18, 18, 18)
                .addComponent(pdfButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printButton)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton)
                    .addComponent(pdfButton)
                    .addComponent(closeButton)
                    .addComponent(nextButton)
                    .addComponent(previousButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
      
    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
 
            boolean check=false;
            String daylabel=dayLabel.getText();
        
        if (breakfastTextArea.getText().isBlank()) {
            if (lunchTextArea.getText().isBlank()) {
                if (dinnerTextArea.getText().isBlank()) {
                    JOptionPane.showMessageDialog(new JFrame(), "No Data to Print", "Print Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
         if(weeklydietplan.size()>0)
         {
            for (Diet_Model day : weeklydietplan) {
            if (day.getDay().equalsIgnoreCase(daylabel)) {
                diet_print printpage=new diet_print();
                printpage.setVisible(true);
                printpage.setdaylabel(day.getDay());
                printpage.setbreakfasttextarea_text(day.getBreakfast());
                printpage.setlunchtextarea_text(day.getLunch());
                printpage.setdinnertextarea_text(day.getDinner());
                printpage.setsnackstextarea_text(day.getSnacks());
                
            }
            }
        
        }
        else{
                   Diet_Model newDiet = new Diet_Model(daylabel, breakfastTextArea.getText(), lunchTextArea.getText(), dinnerTextArea.getText(), snacksTextArea.getText());
                weeklydietplan.add(newDiet);
                for (Diet_Model day1 : weeklydietplan) {
            if (day1.getDay().equalsIgnoreCase(daylabel)) {
                diet_print printpage=new diet_print();
                printpage.setVisible(true);
                printpage.setdaylabel(day1.getDay());
                printpage.setbreakfasttextarea_text(day1.getBreakfast());
                printpage.setlunchtextarea_text(day1.getLunch());
                printpage.setdinnertextarea_text(day1.getDinner());
                printpage.setsnackstextarea_text(day1.getSnacks());
            }
            }
        }
         
       
    }//GEN-LAST:event_printButtonActionPerformed
        
    
    
    
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        
        
    String currentDay = dayLabel.getText();
    saveDataForDay(currentDay);

    
    currentday = (currentday + 1) % days.length;
    dayLabel.setText(days[currentday]);

    
    currentDay = dayLabel.getText();
    fetchDataForDay(currentDay); 
        
        
        for (Diet_Model day : weeklydietplan) {
            System.out.println(day.getDay());
        }
    
            
    }//GEN-LAST:event_nextButtonActionPerformed

    private void saveDataForDay(String day) {
   
    for (Diet_Model diet : weeklydietplan) {
        if (diet.getDay().equalsIgnoreCase(day)) {
        
            diet.setBreakfast(breakfastTextArea.getText());
            diet.setLunch(lunchTextArea.getText());
            diet.setDinner(dinnerTextArea.getText());
            diet.setSnacks(snacksTextArea.getText());
            return;
        }
    }

   
    Diet_Model newDiet = new Diet_Model(day, breakfastTextArea.getText(), lunchTextArea.getText(), dinnerTextArea.getText(), snacksTextArea.getText());
    weeklydietplan.add(newDiet);
    }
    
    private void fetchDataForDay(String day) {
    
    for (Diet_Model diet : weeklydietplan) {
        if (diet.getDay().equalsIgnoreCase(day)) {
            breakfastTextArea.setText(diet.getBreakfast());
            lunchTextArea.setText(diet.getLunch());
            dinnerTextArea.setText(diet.getDinner());
            snacksTextArea.setText(diet.getSnacks());
            return; 
        }
    }

    
    breakfastTextArea.setText("");
    lunchTextArea.setText("");
    dinnerTextArea.setText("");
    snacksTextArea.setText("");
}
    
    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        // TODO add your handling code here:
       
     
    String currentDay = dayLabel.getText();
    saveDataForDay(currentDay);

    
    currentday = (currentday - 1 + days.length) % days.length;
    dayLabel.setText(days[currentday]);

    
    currentDay = dayLabel.getText();
    fetchDataForDay(currentDay);   
           
    }//GEN-LAST:event_previousButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed
    
    
    
    
    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(diet_main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(diet_main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(diet_main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(diet_main1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new diet_main1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea breakfastTextArea;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JTextArea dinnerTextArea;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea lunchTextArea;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton pdfButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton printButton;
    private javax.swing.JTextArea snacksTextArea;
    // End of variables declaration//GEN-END:variables
}
