/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.swing.icon;

/**
 *
 * @author DELL
 */
public class DefaultIconCode implements IconCode{
    private final char unicode;
    private final String fontFamily;

    public DefaultIconCode(String fontFamily, char unicode) {
        this.fontFamily = fontFamily;
        this.unicode = unicode;
    }

    @Override
    public String name() {
        return "[" + getUnicode() + "]";
    }

    @Override
    public char getUnicode() {
        return unicode;
    }

    @Override
    public String getFontFamily() {
        return fontFamily;
    }
}
