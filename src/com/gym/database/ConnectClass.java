/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class ConnectClass {
    //Class Global area 
    Connection xc;
    Statement st;        
    
    //ConnectClass Constructor
    public ConnectClass() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            /**
             * ODBC Name = attend
             */
            
            xc = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "root");
            
            st = xc.createStatement();
        }
        catch(Exception ex) {
             System.out.println(ex.toString());
        }
    }
}
