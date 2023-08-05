/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.form;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author DELL
 */
public class MainForm extends javax.swing.JPanel{
    
    public MainForm() {
        initComponents();
        setOpaque(true);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 20, 10, 20));
    }

    public void showForm(Component form) {
        removeAll();
        add(form);
        repaint();
        revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    // End of variables declaration
}
