/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class connection {
    
    Connection con=null;
    
    public static void main(String[] args) throws IOException {
        connection.getConnection();
    }

    
    
    
    
    public static Connection getConnection() throws FileNotFoundException, IOException{
     
        FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Documents\\NetBeansProjects\\Gym\\src\\com\\gym\\connection\\connection.properties");
        PropertyResourceBundle bundle=new PropertyResourceBundle(fis);
        
        String url=bundle.getString("URL");
        String username=bundle.getString("Username");
        String password=bundle.getString("password");
        Connection con=null;
        
        
        try {
             con=DriverManager.getConnection(url, username, password);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Database Connection Error", "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return con;
        
        
    }
}
