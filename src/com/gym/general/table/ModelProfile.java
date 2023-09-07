/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.table;

import javax.swing.Icon;

/**
 *
 * @author DELL
 */
public class ModelProfile {
     public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelProfile(Icon icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public ModelProfile() {
    }

    private Icon icon;
    private String name;
}
