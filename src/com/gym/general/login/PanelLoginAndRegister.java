/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.login;

import com.gym.general.attendance.week.attendanceWeekRecord;
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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import com.gym.general.main.Main;
import com.gym.general.login.Message;
import com.gym.general.trainer.TrainerMain;
import com.gym.general.workout.added_workouts;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.FileHandler;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;





public class PanelLoginAndRegister extends javax.swing.JLayeredPane{
    
     // Variables declaration - do not modify                     
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    private Message message=new Message();
    // End of variables declaration     
    
    
    private MyTextField txtusername;
    private MyPasswordField txtPass;
    
    JComboBox<String> typeforlogin;
    JComboBox<String> typeforregister;
    
    private MyTextField reg_username;
    private MyPasswordField reg_userpass;
    private MyTextField reg_name;
    private MyPasswordField confirmtxtPass;
    
    String access_check_db;
    
      java.util.logging.Logger logger=java.util.logging.Logger.getLogger(added_workouts.class.getName());
      FileHandler fileHandler;
    
    
      Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    Statement st=null;
    private Main main;
    
    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
       
       
       
    }

    
    private void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]10[]10[]10[]push"));
        JLabel label = new JLabel("Add User");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
         reg_username = new MyTextField();
        reg_username.setPrefixIcon(new ImageIcon(getClass().getResource("user.png")));
        reg_username.setHint("UserName");
       register.add(reg_username, "w 60%");
       
       reg_name=new MyTextField();
       reg_name.setPrefixIcon(new ImageIcon(getClass().getResource("user.png")));
        reg_name.setHint("Name");
       register.add(reg_name, "w 60%");
       
       
         reg_userpass = new MyPasswordField();
        reg_userpass.setPrefixIcon(new ImageIcon(getClass().getResource("pass.png")));
        reg_userpass.setHint("Password");
        register.add(reg_userpass, "w 60%");
        
         confirmtxtPass = new MyPasswordField();
        confirmtxtPass.setPrefixIcon(new ImageIcon(getClass().getResource("pass.png")));
        confirmtxtPass.setHint("Confirm Password");
        register.add(confirmtxtPass, "w 60%");
        
        JLabel label1=new JLabel();
        label1.setText("User Type");
        label1.setFont(new Font("sansserif", 1, 14));
        label1.setForeground(new Color(7, 164, 121));
       
        register.add(label1);
        
        
         typeforregister=new JComboBox<String>();
        typeforregister.addItem("Admin");
        typeforregister.addItem("Trainer");
        register.add(typeforregister);
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("Add User");
        register.add(cmd, "w 40%, h 40");
        Button close = new Button();
        close.setBackground(new Color(7, 164, 121));
        close.setForeground(new Color(250, 250, 250));
        close.setText("Close");
        register.add(close, "w 20%, h 20");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Window parentwindow=SwingUtilities.getWindowAncestor(PanelLoginAndRegister.this);
                parentwindow.dispose();;
            }
        });
        
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         //       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    boolean checkname=check_alphabetic_fields(reg_name.getText(), "Name");
                    boolean checkusername=check_alphabetic_fields(reg_username.getText(), "UserName");
                    boolean checkpassfield=check_alphabetic_fields(reg_userpass.getText(), "Password");
                    boolean checkpass=checkpass(reg_userpass.getText(), confirmtxtPass.getText());
                     boolean[] checkall={checkusername,checkname,checkpassfield,checkpass};
                     boolean checkconstraints=checkallfields(checkall);
                     if (checkconstraints==true) {
                            try {
                             add_user();
                         } catch (Exception ex) {
                             ex.printStackTrace();
                             JOptionPane.showMessageDialog(new JFrame(), "SQL Error","Database Error",JOptionPane.ERROR_MESSAGE);
                         }
                }else{
                         System.out.println("Invalid Fields");
                        JOptionPane.showMessageDialog(new JFrame(), "Error:Fields are Empty or Invalid","Add Payment Error",JOptionPane.ERROR_MESSAGE);
        
                     }
                
         
                    
            }
        });
    }
   
    
    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]10[]10[]10[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
         typeforlogin=new JComboBox<String>();
        
        typeforlogin.addItem("Admin");
        typeforlogin.addItem("Trainer");
        
        login.add(label);
         txtusername = new MyTextField();
        txtusername.setPrefixIcon(new ImageIcon(getClass().getResource("mail.png")));
        txtusername.setHint("UserName");
        login.add(txtusername, "w 60%");
         txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
        
         JLabel label1=new JLabel();
        label1.setText("User Type");
        label1.setFont(new Font("sansserif", 1, 14));
        label1.setForeground(new Color(7, 164, 121));
        
        login.add(label1);
        login.add(typeforlogin);
        
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
        Button close = new Button();
        close.setBackground(new Color(7, 164, 121));
        close.setForeground(new Color(250, 250, 250));
        close.setText("Close");
        login.add(close,"w 20%, h 20");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Window parentwindow=SwingUtilities.getWindowAncestor(PanelLoginAndRegister.this);
                parentwindow.dispose();;
            }
        });
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login Button Pressed");
                System.out.println(txtusername.getText());
                System.out.println(txtPass.getText());
                
                boolean checkusername=check_alphabetic_fields(txtusername.getText(), "Username");
                boolean checkpass=check_alphabetic_fields(txtPass.getText(), "Password");
                boolean[] checkall={checkusername,checkpass};
                boolean checkconstraints=checkallfields(checkall);
                
                if (checkconstraints==true) {
                            try {

                            login_method();



                        } catch (SQLException ex) {
                            Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
                        }

                }
                
                else{
            System.out.println("Invalid Fields");
            JOptionPane.showMessageDialog(new JFrame(), "Error:Fields are Empty or Invalid","Add Payment Error",JOptionPane.ERROR_MESSAGE);
        
                }
        
                
                
                
            }
        });
    }
    
    
    public boolean checkpass(String pass,String confirmpass){
        boolean res=true;    
        if (pass.equals(confirmpass)) {
                res=true;
        }else{
            res=false;
            JOptionPane.showMessageDialog(new JFrame(), "Password and Confirm Password do no match");
        }
        return res;
    
    }
    
       public boolean checkallfields(boolean [] fields){
        boolean res=true;
        
        for(int i=0;i<fields.length;i++){
                System.out.println(fields[i]);
            if (fields[i]==false) {
                res=false;
                break;
            }
            else{
                res=true;
                
            }
        }
        return res;
    
    }
  
    
      public boolean check_alphabetic_fields(String text,String fieldname){
         text=text.replaceAll("\\s", "");
          boolean result=true;
         if (text.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), fieldname+" Field is Empty", fieldname+" Field Error",JOptionPane.ERROR_MESSAGE);
            result=false;
        }
              
        
        
        return result;
    }
    
    
    public void check_access_type(){
        String type_check=typeforlogin.getSelectedItem().toString();
        
        System.out.println("access_check_db:"+access_check_db);
        System.out.println(type_check);
        TrainerMain trainermain=null;
        Main main=null;
        if (type_check.equalsIgnoreCase("trainer")) {
            if (access_check_db.equalsIgnoreCase("0")) {
                    trainermain=new TrainerMain();
                    trainermain.setVisible(true);
                    trainermain.setroletext("Trainer");
                    trainermain.setusernametest(txtusername.getText());
                    JOptionPane.showMessageDialog(new JFrame(), "Login Success");
                    JOptionPane.showMessageDialog(new JFrame(), "Logged in as Trainer");
                    logger.info("Trainer Logged In");
                    logging_log_entry();
        
            }else{
                
                JOptionPane.showMessageDialog(new JFrame(), "User Type Mismatch");   
            }
            
        
        }
        if (type_check.equalsIgnoreCase("admin")) {
            if (access_check_db.equalsIgnoreCase("1")) {
                    main=new Main();
                    
                    main.setVisible(true);
                    main.setroletext("Admin");
                    main.setusernametest(txtusername.getText());
                    JOptionPane.showMessageDialog(new JFrame(), "Login Success");
                    JOptionPane.showMessageDialog(new JFrame(), "Logged in as Admin");
                    logger.info("Admin Logged In");
                    logging_log_entry();
                    
        
            }
            else{
                
                JOptionPane.showMessageDialog(new JFrame(), "User Type Mismatch");
                logger.warning("User Type Miscmatch Occured While Logging");
            }
            
        
        }
        
    
    }
    
    
    public void get_access_type(){
        String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username="sa";
        String password="Dhaval@7869";
           
        String username_login=txtusername.getText();
         access_check_db="";
        
         
        String query="select AllowAccess from dbo.mst_user where user_name='"+username_login+"'";
        try {
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            rs=st.executeQuery(query);
            if (rs.next()) {
                access_check_db=rs.getString(1);
                System.out.println("Access check from Db"+access_check_db);
                    check_access_type();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "username or password incorrect");
            logger.warning("");
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(PanelLoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(new JFrame(), "SQL Error");
            }
           
        }
        
        
    }
    
    public void add_user(){
           String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
          String username="sa";
            String password="Dhaval@7869";
            
            String uname=reg_username.getText();
            String pass=reg_userpass.getText();
            
        SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-MM-dd  HH:mm:ss");
        formatDate.setTimeZone(TimeZone.getTimeZone("IST")); 
        Date currentDate = new Date();
        
        String formattedDate = formatDate.format(currentDate);
        
       String res=typeforregister.getSelectedItem().toString();
       String type="";
       
        if (res.equalsIgnoreCase("admin")) {
            type="1";
        }
        if (res.equalsIgnoreCase("trainer")) {
            type="0";
        }
    
            
      String sqlquery="INSERT INTO [dbo].[Mst_User]\n" +
"           ([User_Login_Id]\n" +
"           ,[User_Name]\n" +
"           ,[User_Password]\n" +
"           ,[Parent_User_Id]\n" +
"           ,[User_Enabled]\n" +
"           ,[email]\n" +
"           ,[Mobile]\n" +
"           ,[On_Date]\n" +
"           ,[Per]\n" +
"           ,[Branch_per]\n" +
"           ,[Company_per]\n" +
"           ,[Dept_per]\n" +
"           ,[AllowAccess])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
            
                con=DriverManager.getConnection(url, username, password);
                 pst=con.prepareStatement(sqlquery);
                 pst.setString(1, uname);
                 pst.setString(2, uname);
                 pst.setString(3, pass);
                 pst.setInt(4, 1);
                 pst.setInt(5, 1);
                 pst.setString(6, "");
                 pst.setString(7, "");
                 pst.setString(8, formattedDate);
                 pst.setString(9, "");
                 pst.setString(10, "1");
                 pst.setString(11, "1");
                 pst.setString(12, type);
                 pst.setString(13, type);
                 int count=pst.executeUpdate();
                 if (count>0) {
                     if (res.equalsIgnoreCase("trainer")) {
                         System.out.println("success");
                        JOptionPane.showMessageDialog(new JFrame(), "Trainer Added Successfully");
                        registration_log_entry();
                        clear();
              
                     }else{
                        System.out.println("success");
                        JOptionPane.showMessageDialog(new JFrame(), "Admin Added Successfully");
                        registration_log_entry();
                        clear();
              
                     }
                 
                 } else {
                  System.out.println("failure");
                  JOptionPane.showMessageDialog(new JFrame(), "ERROR!:OPERATION FAILED");
              }
                 
                 
                 
                 
        } catch (Exception e) {
                  e.printStackTrace();
              JOptionPane.showMessageDialog(new JFrame(), "ERROR!:OPERATION FAILED");
          
        }
    
    }
    
    public void registration_log_entry(){
              Date date=new Date();
	SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	String datetoday=format.format(date);
			
        String message="Registraion of User: "+reg_name.getText()+" Successfull as  "+typeforregister.getSelectedItem().toString();
        String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username="sa";
        String password="Dhaval@7869";
      
        String query="INSERT INTO [dbo].[history]\n" +
"           ([Date]\n" +
"           ,[Message])\n" +
"     VALUES\n" +
"           (?,?)";
        
        try {
             con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(query);
           
            pst.setString(1, datetoday);
            pst.setString(2, message);
            int count=pst.executeUpdate();
            if (count>0) {
                System.out.println("Log Saved Successfully");
            }
            else{
             JOptionPane.showMessageDialog(new JFrame(),"Log Error", "Logged in as Admin",JOptionPane.ERROR_MESSAGE);   
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(),"Log Error", "Logged in as Admin",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void logging_log_entry(){
        
        Date date=new Date();
	SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	String datetoday=format.format(date);
			
        String message="Logged in by: "+txtusername.getText();
        String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username="sa";
        String password="Dhaval@7869";
      
        String query="INSERT INTO [dbo].[history]\n" +
"           ([Date]\n" +
"           ,[Message])\n" +
"     VALUES\n" +
"           (?,?)";
        
        try {
             con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(query);
           
            pst.setString(1, datetoday);
            pst.setString(2, message);
            int count=pst.executeUpdate();
            if (count>0) {
                System.out.println("Log Saved Successfully");
            }
            else{
             JOptionPane.showMessageDialog(new JFrame(),"Log Error", "Logged in as Admin",JOptionPane.ERROR_MESSAGE);   
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(),"Log Error", "Logged in as Admin",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void clear(){
        reg_name.setText("");
        reg_username.setText("");
        reg_userpass.setText("");
        confirmtxtPass.setText("");
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
                   
                   get_access_type();
                   
                   
                   
                   
                 }
                    
                
                else{
                    //logintext.setText("Incorrect Username/Password");
                     System.out.println("Login Failed");
                      JOptionPane.showMessageDialog(new JFrame(), "Username or Password Incorrect");
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
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

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

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        
        add(register, "card2");
    }// </editor-fold>                        

                 
}
