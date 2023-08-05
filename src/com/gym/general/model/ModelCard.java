/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.model;

import javax.swing.Icon;

/**
 *
 * @author DELL
 */
public class ModelCard {
    private String title;
    private double values;
    private int percentage;
    private Icon icon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public ModelCard(String title, double values, int percentage, Icon icon) {
        this.title = title;
        this.values = values;
        this.percentage = percentage;
        this.icon = icon;
    }

    public ModelCard() {
    }

}
