/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author DELL
 */
public class ProgressBarCustom extends JProgressBar{
    public Color getColorString() {
        return colorString;
    }

    public void setColorString(Color colorString) {
        this.colorString = colorString;
    }

    private Color colorString = new Color(200, 200, 200);

    public ProgressBarCustom() {
        setPreferredSize(new Dimension(100, 5));
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(69, 124, 235));
        setUI(new BasicProgressBarUI() {
            @Override
            protected void paintString(Graphics grphcs, int i, int i1, int i2, int i3, int i4, Insets insets) {
                grphcs.setColor(getColorString());
                super.paintString(grphcs, i, i1, i2, i3, i4, insets);
            }
        });
    }
}
