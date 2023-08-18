/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.login;

import com.gym.general.attendance.attendanceWeekRecord;
import com.gym.general.main.Login_Main;
import com.gym.general.main.Main;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import com.gym.general.main.Main;
import com.gym.general.login.Message;

/**
 *
 * @author DELL
 */
public class PanelLoginAndRegister extends javax.swing.JLayeredPane{
    
     // Variables declaration - do not modify                     
    private javax.swing.JPanel login;
    //private javax.swing.JPanel register;
    private Message message=new Message();
    // End of variables declaration     
    
    
    private MyTextField txtusername;
    private MyPasswordField txtPass;
    
      Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    private Main main;
    
    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        login.setVisible(false);
        //register.setVisible(true);
    }

    private void initRegister() {
       // register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        //register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("user.png")));
        txtUser.setHint("Name");
       // register.add(txtUser, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("mail.png")));
        txtEmail.setHint("Email");
        //register.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("pass.png")));
        txtPass.setHint("Password");
        //register.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        //register.add(cmd, "w 40%, h 40");
    }
    
    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
         txtusername = new MyTextField();
        txtusername.setPrefixIcon(new ImageIcon(getClass().getResource("mail.png")));
        txtusername.setHint("UserName");
        login.add(txtusername, "w 60%");
         txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login Button Pressed");
                System.out.println(txtusername.getText());
                System.out.println(txtPass.getText());
                try {
                    login_method();
                } catch (SQLException ex) {
                    Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    
    public void login_method() throws SQLException, SQLException, SQLException, SQLException{
         String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username="sa";
        String password="Dhaval@7869";
        String sqlquery="select USER_NAME,user_password from dbo.Mst_User where user_name=? and User_Password=?";
        
        String uname=txtusername.getText();
        String pass=txtPass.getText();
        
        try {
            con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(sqlquery);
           
            pst.setString(1, uname);
            pst.setString(2, pass);
            
            rs=pst.executeQuery();
            /*if (uname.isEmpty()) {
                logintext.setText("Please Enter Required Fields");
                System.out.println(logintext.getText());
            }
            if (pass.isEmpty()) {
                logintext.setText("Please Enter Required Fields");
                System.out.println(logintext.getText());
            }*/
            
                 if (rs.next()) {
                    //logintext.setText("Login Sucees");
                     //logintext.setForeground(Color.green);
                     
                 
                System.out.println("Login Success");
                   
                   main=new Main();
                   main.setVisible(true);
                   
                   
                   
                   
                 }
                    
                
                else{
                    //logintext.setText("Incorrect Username/Password");
                     System.out.println("Login Failed");
                     message.showMessage(Message.MessageType.ERROR, "Username or Password Incorrect");
                     
                 }
            
            
            
            
           
           /* while (rs.next()) {                
                System.out.println("Emp Name"+rs.getString("empname"));
                System.out.println("Emp ID"+rs.getInt("empid"));
            }*/
           
             
            
       }   catch (SQLException ex) {
            Logger.getLogger(attendanceWeekRecord.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        finally{
              pst.close();
             rs.close();
             con.close();
        }
    } 

    
    public void showRegister(boolean show) {
        if (show) {
            //register.setVisible(true);
            login.setVisible(false);
        } else {
            //register.setVisible(false);
            login.setVisible(true);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        login = new javax.swing.JPanel();
        //register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        //register.setBackground(new java.awt.Color(255, 255, 255));

        /*javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        //register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        */
        //add(register, "card2");
    }// </editor-fold>                        

                 
}
