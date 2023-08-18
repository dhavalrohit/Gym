/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.addmember;

import com.formdev.flatlaf.ui.FlatLabelUI;
import com.gym.general.attendance.attendanceWeekRecord;
import com.gym.general.login.Button;
import com.gym.general.login.Message;
import com.gym.general.login.MyPasswordField;
import com.gym.general.login.MyTextField;
import com.gym.general.login.PanelLoginAndRegister;
import com.gym.general.main.Main;
import com.raven.datechooser.DateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author DELL
 */
public class AddMemberLayeredPanel extends javax.swing.JLayeredPane implements ItemListener{
    
    private AddMemberTextField timeslot;
     // Variables declaration - do not modify                     
    private javax.swing.JPanel login;
    //private javax.swing.JPanel register;
    private Message message=new Message();
    // End of variables declaration     
   private javax.swing.JPanel textFieldPanel;
  private JComboBox combo;
   
   
    private MyTextField txtusername;
    private MyPasswordField txtPass;
     private javax.swing.JTextField dateofjointextfield;
    
      Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    private Main main;
    
    public AddMemberLayeredPanel() {
        initComponents();
        initRegister();
        initAddMember();
        login.setVisible(false);
       // textFieldPanel.setVisible(false);
        //register.setVisible(true);
    }

    private void initRegister() {
       // register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        //register.add(label);
        AddMemberTextField txtmembername = new AddMemberTextField();
        txtmembername.setPrefixIcon(new ImageIcon(getClass().getResource("user.png")));
        txtmembername.setHint("Name");
       //register.add(txtUser, "w 60%");
        AddMemberTextField txtmobileno = new AddMemberTextField();
        txtmobileno.setPrefixIcon(new ImageIcon(getClass().getResource("mail.png")));
        txtmobileno.setHint("Mobile No:");
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
    
 private void initAddMember() {
      
     login.setLayout(new MigLayout("wrap 2, fillx, gapy 10", "[left][right]", "push[5][5][5][5][5]push"));
    
    JLabel label = new JLabel("Registration Form");
    label.setFont(new Font("sansserif", 1, 30));
    label.setForeground(new Color(7, 164, 121));
    login.add(label, "span 2, align center, wrap");

    AddMemberTextField MemberID = new AddMemberTextField();
    MemberID.setPrefixIcon(new ImageIcon(getClass().getResource("mail.png")));
    MemberID.setHint("Member ID");
    MemberID.setEditable(false);
    login.add(MemberID, "width 40%, grow, align left");

    AddMemberTextField membercardno = new AddMemberTextField();
    membercardno.setPrefixIcon(new ImageIcon(getClass().getResource("mail.png")));
    membercardno.setHint("Member Card NO");
    login.add(membercardno, "width 40%, grow, align right");
    
    AddMemberTextField txtmobileno = new AddMemberTextField();
    txtmobileno.setPrefixIcon(new ImageIcon(getClass().getResource("mail.png")));
    txtmobileno.setHint("Mobile No:");
    login.add(txtmobileno, "width 40%, grow, align left");
    
    DateChooser dateofbirthdate=new DateChooser();
    
    
    AddMemberTextField dateofbirth = new AddMemberTextField();
    dateofbirth.setPrefixIcon(new ImageIcon(getClass().getResource("mail.png")));
    dateofbirth.setHint("Date of Birth");
    dateofbirthdate.setTextField(dateofbirth);
    dateofbirthdate.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
    login.add(dateofbirth, "width 40%, grow, align right");
        
   //dateofjointextfield=new javax.swing.JTextField();
   DateChooser joindatechooser=new DateChooser();
   
    AddMemberTextField dateofjoin = new AddMemberTextField();
    dateofjoin.setPrefixIcon(new ImageIcon(getClass().getResource("user.png")));
    dateofjoin.setHint("Date Of Joining");
    joindatechooser.setTextField(dateofjoin);
    joindatechooser.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
    login.add(dateofjoin, "width 40%, grow, align left");
   
     AddMemberTextField txtmembername = new AddMemberTextField();
     txtmembername.setPrefixIcon(new ImageIcon(getClass().getResource("user.png")));
     txtmembername.setHint("Name");
     login.add(txtmembername, "width 40%, grow, align right");
       
        
      AddMemberTextField address = new AddMemberTextField();
      address.setPrefixIcon(new ImageIcon(getClass().getResource("mail.png")));
      address.setHint("Address:");
      login.add(address, "width 40%, grow, align left");
       
      String timeing[]={"Morning","Evening"};
       combo=new JComboBox(timeing);
      combo.addItemListener(this);
      
       timeslot = new AddMemberTextField();
      timeslot.setPrefixIcon(new ImageIcon(getClass().getResource("mail.png")));
      timeslot.setHint("Time Slot:");
      timeslot.add(combo);
      login.add(timeslot, "width 40%, grow, align right");
       
       
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("ADD");
        login.add(cmd, "span 2, align center, width 40%, height 40");

        
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
            textFieldPanel.setVisible(false);
            
        } else {
            //register.setVisible(false);
            login.setVisible(true);
            //textFieldPanel.setVisible(true);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        login = new javax.swing.JPanel();
        //register = new javax.swing.JPanel();
        //textFieldPanel = new  javax.swing.JPanel(); // 2 columns, 10px horizontal and vertical gap
        
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
        
        //add(textFieldPanel,"card3");

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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==combo) {
            timeslot.setText(combo.getSelectedItem()+"selected");
        }
    }

    
 
    
    

}
   

