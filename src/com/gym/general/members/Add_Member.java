


//constraints added on 07/09/2023
package com.gym.general.members;
import com.gym.general.main.*;
import com.formdev.flatlaf.FlatIntelliJLaf;

import com.raven.datechooser.DateChooser;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import javax.swing.plaf.FileChooserUI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;


/*changes made on 26-08-2023
1.created method to fetch memeber id and autoincrement member id
2.To get biometric id value and autoincrement it and set it to textfield
3.Add functionality to add member without photo
*/

/*
Task remaning-
*/

public class Add_Member extends javax.swing.JFrame {

       private DateChooser dateofbith_dc;
       private DateChooser dateofjoin_dc;
       private DateChooser membership_start_date;
       private DateChooser membership_end_date;
       private int total_members_count;

      String profile_pic_path;
      
      Connection con=null;
      ResultSet rs=null;
      Statement st=null;
      PreparedStatement pst=null;
      
      ImageIcon profileimg;
      int memberid=0;
      String biometricid="";
    
    public Add_Member() {
        FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
        FlatIntelliJLaf.setup();
        total_member_count();
         dateofbith_dc=new DateChooser();
         dateofjoin_dc=new DateChooser();
         
         dateofbith_dc.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
         dateofjoin_dc.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
         
         membership_start_date=new DateChooser();
         membership_start_date.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
         
         membership_end_date=new DateChooser();
         membership_end_date.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
         this.setResizable(false);
         this.setTitle("Add Member Window");
         
        initComponents();
        
        add_new_member_Button.setVisible(false);
        get_biometric_id();
        get_member_id();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void total_member_count(){
        
        
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
        String query="select count(empname) from dbo.Mst_Employee";
        
        try {
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {                
               total_members_count=rs.getInt(1);
               
               
            }
            memberscount_Label.setText(total_members_count+"");
            
        } catch (Exception e) {
        }
        System.out.println("total count:"+total_members_count);
        
    }
    
    
    public  void get_biometric_id() {
        
        String query="SELECT TOP 1 cardno FROM dbo.Mst_Employee ORDER BY empid DESC";
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
           
          try {
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            rs=st.executeQuery(query);
            if (rs.next()) {
                biometricid=rs.getString(1);
                System.out.println("Last Biometric ID:"+biometricid);
                
                char lastChar = biometricid.charAt(biometricid.length() - 1);
                int lastDigit = Character.getNumericValue(lastChar);
                lastDigit = (lastDigit + 1) % 10;
                biometricid= biometricid.substring(0, biometricid.length() - 1) + lastDigit;
        
                
                System.out.println("Current Biometric ID:"+biometricid);
                
                biometric_id_TextField.setText(String.valueOf(biometricid));
                biometric_id_TextField.setEditable(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "SQL ERROR");
        }
        
        
        
    }
    
    
     public boolean check_numericfields(String text,String fieldname){
        text=text.replaceAll("\\s", "");
        text=text.replace("-", "");
          boolean res=true;
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), fieldname+" Field is Empty", fieldname+" Field Error",JOptionPane.ERROR_MESSAGE);
            res=false;
        }
        else if(text.length()>0)
            for(int i=0;i<text.length();i++){
                if (Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
                    
                }
                else{
                     JOptionPane.showMessageDialog(new JFrame(), fieldname+" Field contains Alphabetic value", fieldname+" Field Error",JOptionPane.ERROR_MESSAGE);
                    res=false;
                    break;
                }
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
              
        if(text.length()>0)
            for(int i=0;i<text.length();i++){
                if (Character.toString(text.charAt(i)).matches("^[a-zA-Z]+$")) {
                    
                }
                else{
                    result=false;
                    JOptionPane.showMessageDialog(new JFrame(), fieldname+" Field contains Numeric value", fieldname+" Field Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        
        return result;
    }
    
    
    
    
    
    public void view_selected_member() throws SQLException{
        
         String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
        int selectedrow= jTable1.getSelectedRow();
        String name= (String) jTable1.getModel().getValueAt(selectedrow, 1);
        System.out.println(selectedrow+" "+name);
        String query="select * from dbo.Mst_Employee where EmpName='"+name+"'";
        
        
        try {
            
             con=DriverManager.getConnection(url, username, password);
             st=con.createStatement();
             rs=st.executeQuery(query);
             if (rs.next()) {                
                 String name_rs=rs.getString("Empname");
                 String mobileno_rs=rs.getString("PhoneNo");
                String email_rs=rs.getString("EmailAddress");
                String dateofbirth_rs=rs.getDate("DateofBirth").toString();
                String fathername_rs=rs.getString("FatherName");
                String membership_id_rs=rs.getString("Empid");
                String biometric_id_rs=rs.getString("CardNo");
                
                String dateofjoin_rs=rs.getDate("DateofJoin").toString();
                String timing_rs=rs.getString("ShiftCode");
                String membership_start_date_rs=rs.getDate("ShiftStartDate").toString();
                String membership_end_date_rs=rs.getString("validityend");
                
                 try {
                     Blob blobdata=rs.getBlob("profilepic");
                     if (blobdata!=null) {
                         
                 InputStream input=blobdata.getBinaryStream();
                 BufferedImage imageicon=ImageIO.read(input);
                
                Image dimg = imageicon.getScaledInstance(profilepic.getWidth(), profilepic.getHeight(),
                Image.SCALE_SMOOTH);
                
                  profileimg=new ImageIcon(dimg);
                  profilepic.setIcon(profileimg);
                     }
                     else{
                         JOptionPane.showMessageDialog(new Frame(), "Details Shown Without Image");
                         profilepic.setIcon(null);
                         profilepic.revalidate();
                         
                     }
                     
                 
                 }catch(NullPointerException e){
                      JOptionPane.showMessageDialog(new Frame(), "Image Not Found");
                      e.printStackTrace();
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                 }
                
                
                 System.out.println(name_rs);
                 System.out.println(mobileno_rs);
                 System.out.println(email_rs);
                 System.out.println(dateofbirth_rs);
                 System.out.println(fathername_rs);
                 System.out.println(membership_id_rs);
                 System.out.println(biometric_id_rs);
                 System.out.println(dateofjoin_rs);
                 System.out.println(timing_rs);
                 System.out.println(membership_start_date_rs);
                 System.out.println(membership_end_date_rs);
                 
                 name_TextField.setText(name_rs);
                 name_TextField.setEditable(false);
                 
                 mobileno_TextField.setText(mobileno_rs);
                 mobileno_TextField.setEditable(false);
                 
                 email_TextField.setText(email_rs);
                 email_TextField.setEditable(false);
                 
                 dateofbirth_TextField.setText(dateofbirth_rs);
                 dateofbirth_TextField.setEditable(false);
                 
                 fathername_TextField.setText(fathername_rs);
                 fathername_TextField.setEditable(false);
                 
                 membership_id_TextField.setText(membership_id_rs);
                 membership_id_TextField.setEditable(false);
                 
                 biometric_id_TextField.setText(biometric_id_rs);
                 biometric_id_TextField.setEditable(false);
                 
                 dateofjoin_TextField.setText(dateofjoin_rs);
                 dateofjoin_TextField.setEditable(false);
                 
                 timimg_ComboBox.setSelectedItem(timing_rs);
                 timimg_ComboBox.setEnabled(false);
                 timimg_ComboBox.setEditable(false);
                 
                 membership_start_TextField.setText(membership_start_date_rs);
                 membership_start_TextField.setEditable(false);
                 
                 membership_end_TextField.setText(membership_end_date_rs);
                 membership_end_TextField.setEditable(false);
                 
                 

            }
             else{
                 System.out.println("No member found");
             }
             
        }catch (ArrayIndexOutOfBoundsException e) {
             JOptionPane.showMessageDialog(new Frame(), "Please Select Member");
             
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            con.close();
        }
        
    }
    
      public  void get_member_id(){
            String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
           String username = "sa";
           String password = "Dhaval@7869";
           String query="select IDENT_CURRENT('Mst_Employee')";

        try {
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            rs=st.executeQuery(query);
            if (rs.next()) {
                memberid=rs.getInt(1);
                System.out.println("Last Inquiry ID:"+memberid);
                memberid=memberid+1;
                System.out.println("Current Inquiry ID"+memberid);
                
                membership_id_TextField.setText(String.valueOf(memberid));
                membership_id_TextField.setEditable(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "SQL ERROR");
        }
    
    }
      
     
    public void reset(){
        
        name_TextField.setText("");
        membership_id_TextField.setText("");
        biometric_id_TextField.setText("");
        membership_start_TextField.setText("");
        membership_end_TextField.setText("");
        dateofjoin_TextField.setText("");
        dateofbirth_TextField.setText("");
        mobileno_TextField.setText("");
        email_TextField.setText("");
        fathername_TextField.setText("");
        id_TextField.setText("");
        
        
    }
    
    
    
  
    public void add_member_db() throws SQLException {
    
        String name=name_TextField.getText();
        String mobileno=mobileno_TextField.getText();
        String email=email_TextField.getText();
        String dateofbirth=dateofbirth_TextField.getText();
        String fathername=fathername_TextField.getText();
        String membership_id=membership_id_TextField.getText();
        String biometric_id=biometric_id_TextField.getText();
        String id=id_TextField.getText();
        String dateofjoin=dateofjoin_TextField.getText();
        String timing=timimg_ComboBox.getSelectedItem().toString();
        String membership_start_date=membership_start_TextField.getText();
        String membership_end_date=membership_end_TextField.getText();
       
        String regindate="";
        
        System.out.println(dateofbirth);
        System.out.println(membership_start_date);
        System.out.println(membership_end_date);
        System.out.println(dateofjoin);
        
        if (profile_pic_path==null) {
            
             String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
             String username = "sa";
             String password = "Dhaval@7869";
      
            
        String query="INSERT INTO [dbo].[Mst_Employee]\n" +
"           ([EmpName],\n" +
"		   [FatherName]\n" +
"		   ,[CompanyId]\n" +
"		   ,[DeptId],\n" +
"		   [DesigId]\n" +
"		   ,[BranchId]\n" +
"		   ,[OTimePoliceId]\n" +
"		   ,[ReginDate]\n" +
"		   ,[CorpPolicyid]\n" +
"            ,[EmpCode]\n" +
"           ,[CardNo]\n" +
"           ,[DateofJoin]\n" +
"           ,[ShiftType]\n" +
"           ,[EmailAddress]\n" +
"           ,[PhoneNo]\n" +
"           ,[DateofBirth],[ShiftStartDate],[Validityend],[ShiftCode],[Bank_Ifsc_Code])" +
  
"	 VALUES \n" +
"            \n" +
"			(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        
            try {
                con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, fathername);
            pst.setInt(3, 1);
            pst.setInt(4,1);
            pst.setInt(5,1);
            pst.setInt(6, 1);
            pst.setInt(7, 1);
            pst.setString(8, regindate);
            pst.setInt(9, 1);
            pst.setString(10, membership_id);
            pst.setString(11, biometric_id);
            pst.setString(12, dateofjoin);
            pst.setString(13, timing);
            pst.setString(14, email);
            pst.setString(15, mobileno);
            pst.setString(16, dateofbirth);
            pst.setString(17, membership_start_date);
            pst.setString(18, membership_end_date);
            pst.setString(19, timing);
            pst.setString(20, id);
           
            
            
            
            //pst.execute();
            
            int count=pst.executeUpdate();
            if (count>0) {
                JOptionPane.showMessageDialog(new Frame(), "Member Added Succesfully");
                System.out.println("Member Inserted Succesfully");
                JOptionPane.showMessageDialog(new Frame(), "Profile Pic Insertion Pending");
                showall_members();
                total_member_count();
                reset();
                
            }else{
                System.out.println("Member Insertion failed");
                JOptionPane.showMessageDialog(new Frame(), "Member Insertion failed");  
            }
            
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(new Frame(), "SQL Exception");  
            }finally{
                con.close();
            total_member_count();
            showall_members();
            
        
                
            }
        }
        else{
        
        
            FileInputStream fis=null;
            try {
               
                fis = new FileInputStream(profile_pic_path);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Add_Member.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        
        String query="INSERT INTO [dbo].[Mst_Employee]\n" +
"           ([EmpName],\n" +
"		   [FatherName]\n" +
"		   ,[CompanyId]\n" +
"		   ,[DeptId],\n" +
"		   [DesigId]\n" +
"		   ,[BranchId]\n" +
"		   ,[OTimePoliceId]\n" +
"		   ,[ReginDate]\n" +
"		   ,[CorpPolicyid]\n" +
"            ,[EmpCode]\n" +
"           ,[CardNo]\n" +
"           ,[DateofJoin]\n" +
"           ,[ShiftType]\n" +
"           ,[EmailAddress]\n" +
"           ,[PhoneNo]\n" +
"           ,[DateofBirth],[ShiftStartDate],[Validityend],[ShiftCode],[ImagePath],[Profilepic])\n" +
  
"	 VALUES  \n" +
"            \n" +
"			(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        try {
            con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, fathername);
            pst.setInt(3, 1);
            pst.setInt(4,1);
            pst.setInt(5,1);
            pst.setInt(6, 1);
            pst.setInt(7, 1);
            pst.setString(8, regindate);
            pst.setInt(9, 1);
            pst.setString(10, membership_id);
            pst.setString(11, biometric_id);
            pst.setString(12, dateofjoin);
            pst.setString(13, timing);
            pst.setString(14, email);
            pst.setString(15, mobileno);
            pst.setString(16, dateofbirth);
            pst.setString(17, membership_start_date);
            pst.setString(18, membership_end_date);
            pst.setString(19, timing);
            pst.setString(20,profile_pic_path.toString());
            pst.setBinaryStream(21, fis);
           
            //pst.execute();
            
            int count=pst.executeUpdate();
            if (count>0) {
                JOptionPane.showMessageDialog(new Frame(), "Member Added Succesfully");
                System.out.println("Member Inserted Succesfully");
                showall_members();
                total_member_count();
                
            }else{
                System.out.println("Member Insertion failed");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new Frame(), "SQL Exception");  
        }
        finally{
        con.close();
        total_member_count();
        profilepic.setText("");
            
        }
        }
        
        /*System.out.println(name);
        System.out.println(address);
        System.out.println(gender);
        System.out.println(dateofbirth);*/
        
              /*  USE [attendance_manager]
GO

INSERT INTO [dbo].[Mst_Employee]
           ([EmpName],
		   [FatherName]
		   ,[CompanyId]
		   ,[DeptId],
		   [DesigId]
		   ,[BranchId]
		   ,[OTimePoliceId]
		   ,[ReginDate]
		   ,[CorpPolicyid]
            ,[EmpCode]
           ,[CardNo]
           ,[DateofJoin]
           ,[ShiftType]
           ,[EmailAddress]
           ,[PhoneNo]
           ,[DateofBirth])
     
	 VALUES  
            
			('Raj','',1,1,1,1,1,0,1,05,005,'2023-01-01 00:00:00','Fixed','aa','1234','2018-12-02 00:00:00.000')
           GO
                   */


    }
    
    public void showall_members(){
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        String query="select empid as Member_ID,empname as Name,phoneno as Mobile_No from dbo.mst_employee";
        
        try {
            con=DriverManager.getConnection(url,username,password);
            st=con.createStatement();
            rs=st.executeQuery(query);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        profilepic = new javax.swing.JLabel();
        browse = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        name_TextField = new javax.swing.JTextField();
        mobileno = new javax.swing.JLabel();
        mobileno_TextField = new javax.swing.JTextField();
        address = new javax.swing.JLabel();
        email_TextField = new javax.swing.JTextField();
        dateofbirth = new javax.swing.JLabel();
        dateofbirth_TextField = new javax.swing.JTextField();
        biometric_id = new javax.swing.JLabel();
        biometric_id_TextField = new javax.swing.JTextField();
        membership_id = new javax.swing.JLabel();
        membership_id_TextField = new javax.swing.JTextField();
        id_aadhar = new javax.swing.JLabel();
        id_TextField = new javax.swing.JTextField();
        fathername = new javax.swing.JLabel();
        fathername_TextField = new javax.swing.JTextField();
        add_Button = new javax.swing.JButton();
        edit_Button = new javax.swing.JButton();
        reset_Button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        dateofjoin_TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        membership_start_TextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        membership_end_TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        timimg_ComboBox = new javax.swing.JComboBox<>();
        view_Button = new javax.swing.JButton();
        add_new_member_Button = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        memberscount_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(33, 161, 93));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Members List");
        jLabel1.setOpaque(true);

        profilepic.setBackground(java.awt.Color.white);
        profilepic.setOpaque(true);

        browse.setBackground(new java.awt.Color(32, 161, 93));
        browse.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        browse.setForeground(java.awt.Color.white);
        browse.setText("Browse");
        browse.setBorderPainted(false);
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        name.setText("Name");

        name_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                name_TextFieldKeyReleased(evt);
            }
        });

        mobileno.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        mobileno.setText("Mobile No");

        mobileno_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobileno_TextFieldKeyReleased(evt);
            }
        });

        address.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        address.setText("Email");

        dateofbirth.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        dateofbirth.setText("Date Of Birth");

        dateofbith_dc.setTextField(dateofbirth_TextField);
        dateofbith_dc.setBackground(new java.awt.Color(255, 255, 255));

        biometric_id.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        biometric_id.setText("Biometric ID");

        membership_id.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        membership_id.setText("Membership ID");

        membership_id_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membership_id_TextFieldActionPerformed(evt);
            }
        });

        id_aadhar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        id_aadhar.setText("ID Card/Aadhar");

        fathername.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        fathername.setText("Father/Guardian Name");

        fathername_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fathername_TextFieldKeyReleased(evt);
            }
        });

        add_Button.setBackground(new java.awt.Color(32, 161, 93));
        add_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        add_Button.setForeground(java.awt.Color.white);
        add_Button.setText("ADD");
        add_Button.setBorderPainted(false);
        add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ButtonActionPerformed(evt);
            }
        });

        edit_Button.setBackground(new java.awt.Color(32, 161, 93));
        edit_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        edit_Button.setForeground(java.awt.Color.white);
        edit_Button.setText("EDIT");
        edit_Button.setBorderPainted(false);
        edit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_ButtonActionPerformed(evt);
            }
        });

        reset_Button.setBackground(new java.awt.Color(32, 161, 93));
        reset_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        reset_Button.setForeground(java.awt.Color.white);
        reset_Button.setText("RESET");
        reset_Button.setBorderPainted(false);
        reset_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_ButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setText("Date Of Join");

        dateofjoin_dc.setTextField(dateofjoin_TextField);
        dateofjoin_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateofjoin_TextFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setText("Membership Start Date");

        membership_start_date.setTextField(membership_start_TextField);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setText("Membership End Date");

        membership_end_date.setTextField(membership_end_TextField);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Timing");

        timimg_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MOR", "EVE" }));

        view_Button.setBackground(new java.awt.Color(32, 161, 93));
        view_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        view_Button.setForeground(java.awt.Color.white);
        view_Button.setText("VIEW");
        view_Button.setBorderPainted(false);
        view_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_ButtonActionPerformed(evt);
            }
        });

        add_new_member_Button.setBackground(new java.awt.Color(32, 161, 93));
        add_new_member_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        add_new_member_Button.setForeground(java.awt.Color.white);
        add_new_member_Button.setText("ADD NEW MEMBER");
        add_new_member_Button.setBorderPainted(false);
        add_new_member_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_member_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browse)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(profilepic, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mobileno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mobileno_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timimg_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(membership_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(email_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(membership_id_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(dateofbirth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(biometric_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(dateofbirth_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(biometric_id_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(fathername)
                                        .addGap(33, 33, 33)
                                        .addComponent(id_aadhar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(fathername_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(id_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7)
                                        .addComponent(dateofjoin_TextField)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(membership_start_TextField))
                                    .addComponent(membership_end_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(add_new_member_Button)
                        .addGap(44, 44, 44)
                        .addComponent(view_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reset_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(add_Button)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(browse)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profilepic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mobileno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mobileno_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timimg_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(membership_id, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(membership_id_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateofjoin_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateofbirth, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(biometric_id, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateofbirth_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(biometric_id_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(membership_start_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fathername, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fathername_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(membership_end_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(id_aadhar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add_Button)
                        .addComponent(edit_Button)
                        .addComponent(reset_Button)
                        .addComponent(view_Button))
                    .addComponent(add_new_member_Button))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButton1.setText("Show All Members");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\search.png")); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member ID", "Name", "Mobile No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel10.setText("Total Members:");

        String countn=Integer.toString(total_members_count);
        memberscount_Label.setText(countn);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(memberscount_Label)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(memberscount_Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        showall_members();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dateofjoin_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateofjoin_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateofjoin_TextFieldActionPerformed

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
        
        name_TextField.setText("");
        membership_id_TextField.setText("");
        biometric_id_TextField.setText("");
        membership_start_TextField.setText("");
        membership_end_TextField.setText("");
        dateofjoin_TextField.setText("");
        dateofbirth_TextField.setText("");
        mobileno_TextField.setText("");
        email_TextField.setText("");
        fathername_TextField.setText("");
        id_TextField.setText("");
        
    }//GEN-LAST:event_reset_ButtonActionPerformed

    private void edit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_ButtonActionPerformed

    private void add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ButtonActionPerformed
        boolean membername=check_alphabetic_fields(name_TextField.getText(),"Member Name");
        boolean fathername=check_alphabetic_fields(fathername_TextField.getText(),"Father Name");
        boolean checkmobile=check_numericfields(mobileno_TextField.getText(),"Mobile No");
        boolean checkdateofbirth=check_numericfields(dateofbirth_TextField.getText(), "Date of Birth");
        boolean dateofjoin=check_numericfields(dateofjoin_TextField.getText(), "Date of Join");
        boolean memstart=check_numericfields(membership_start_TextField.getText(), "Membership Start Date");
        boolean memend=check_numericfields(membership_end_TextField.getText(), "Membership End Date");
        
        boolean[] checkallfield_forpayments={membername,fathername,checkmobile,checkdateofbirth,dateofjoin,memstart,memend};
         boolean check_constraints=checkallfields(checkallfield_forpayments);
        
         if (check_constraints==true) {
            try {
            // TODO add your handling code here:
                add_member_db();
        } catch (SQLException ex) {
            Logger.getLogger(Add_Member.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new Frame(), "SQL Exception");  
        }
        }
        else{
            System.out.println("Invalid Fields");
            JOptionPane.showMessageDialog(new JFrame(), "Error:Fields are Empty or Invalid","Add Payment Error",JOptionPane.ERROR_MESSAGE);
        }
         
         
        

        
    }//GEN-LAST:event_add_ButtonActionPerformed

    private void membership_id_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membership_id_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_membership_id_TextFieldActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        selectFile();
       
    }//GEN-LAST:event_browseActionPerformed

    private void view_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_ButtonActionPerformed
        add_Button.setVisible(false);
        add_new_member_Button.setVisible(true);
        
        
        try {
            // TODO add your handling code here:
            
            view_selected_member();
            
        }
        catch (ArrayIndexOutOfBoundsException e) {
             JOptionPane.showMessageDialog(new Frame(), "Please Select Member");
             add_new_member_Button.setVisible(false);
             add_Button.setVisible(true);
        }
        catch (SQLException ex) {
            Logger.getLogger(Add_Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_view_ButtonActionPerformed

    private void add_new_member_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_member_ButtonActionPerformed
    
        // TODO add your handling code here:
        add_new_member_Button.setVisible(false);
        add_Button.setVisible(true);
        
        name_TextField.setText("");
        name_TextField.setEditable(true);
        
        email_TextField.setText("");
        email_TextField.setEditable(true);
        
        mobileno_TextField.setText("");
        mobileno_TextField.setEditable(true);
        
        timimg_ComboBox.setSelectedItem(null);
        timimg_ComboBox.setEnabled(true);
        timimg_ComboBox.setEditable(true);
        
        dateofbirth_TextField.setText("");
        dateofbirth_TextField.setEditable(true);
        
        biometric_id_TextField.setText("");
        biometric_id_TextField.setEditable(true);
        
        fathername_TextField.setText("");
        fathername_TextField.setEditable(true);
        
        dateofjoin_TextField.setText("");
        dateofjoin_TextField.setEditable(true);
        
        membership_start_TextField.setText("");
        membership_start_TextField.setEditable(true);
        
        membership_end_TextField.setText("");
        membership_end_TextField.setEditable(true);
        
        membership_id_TextField.setText("");
        membership_id_TextField.setEditable(true);
        
        profilepic.setIcon(null);
        profilepic.revalidate();
        
        
                 
    }//GEN-LAST:event_add_new_member_ButtonActionPerformed

    private void name_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_TextFieldKeyReleased
        // TODO add your handling code here:
        
        String text=name_TextField.getText();
         text=text.replaceAll("\\s", "");
          int len=text.length();
            for (int i = 0; i < len; i++) {
                if(Character.toString(text.charAt(i)).matches("^[a-zA-Z]+$")){
                    continue;
                    
            }else{
                    
                    JOptionPane.showMessageDialog(new JFrame(), "Name Field Contains Number","Name Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains number");
                     name_TextField.setText(null);
                     break;
                    
                }
            }
    }//GEN-LAST:event_name_TextFieldKeyReleased

    private void mobileno_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileno_TextFieldKeyReleased
        // TODO add your handling code here:
       String text=mobileno_TextField.getText();
        text=text.replaceAll("\\s", "");
      for(int i=0;i<text.length();i++){
         
        if (mobileno_TextField.getText().length()>0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
            
        }else{
             JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","Hieght Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabet");
                   mobileno_TextField.setText(null);
        }
 
        
    }
     
    }//GEN-LAST:event_mobileno_TextFieldKeyReleased

    private void fathername_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fathername_TextFieldKeyReleased
        // TODO add your handling code here:
        String text=name_TextField.getText();
         text=text.replaceAll("\\s", "");
          int len=text.length();
            for (int i = 0; i < len; i++) {
                if(Character.toString(text.charAt(i)).matches("^[a-zA-Z]+$")){
                    continue;
                    
            }else{
                    
                    JOptionPane.showMessageDialog(new JFrame(), "Father Name Field Contains Number","Father Name Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains number");
                     name_TextField.setText(null);
                     break;
                    
                }
            }
    }//GEN-LAST:event_fathername_TextFieldKeyReleased

    
    
    public void selectFile() {
        
        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            profile_pic_path = chooser.getSelectedFile().getAbsolutePath();
            System.out.println(profile_pic_path);
            
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(profile_pic_path));
                
                Image dimg = img.getScaledInstance(profilepic.getWidth(), profilepic.getHeight(),
                Image.SCALE_SMOOTH);
                
                  profileimg=new ImageIcon(dimg);
                  profilepic.setIcon(profileimg);
                
            }catch (IOException e) {
               
                e.printStackTrace();
                JOptionPane.showMessageDialog(new Frame(), "ERROR:Can't Upload Selected Image");
        }
            
        } else {
            System.out.println("Image not found");
            JOptionPane.showMessageDialog(new Frame(), "ERROR:Can't Upload Selected Image");
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_Button;
    private javax.swing.JButton add_new_member_Button;
    private javax.swing.JLabel address;
    private javax.swing.JLabel biometric_id;
    private javax.swing.JTextField biometric_id_TextField;
    private javax.swing.JButton browse;
    private javax.swing.JLabel dateofbirth;
    private javax.swing.JTextField dateofbirth_TextField;
    private javax.swing.JTextField dateofjoin_TextField;
    private javax.swing.JButton edit_Button;
    private javax.swing.JTextField email_TextField;
    private javax.swing.JLabel fathername;
    private javax.swing.JTextField fathername_TextField;
    private javax.swing.JTextField id_TextField;
    private javax.swing.JLabel id_aadhar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel memberscount_Label;
    private javax.swing.JTextField membership_end_TextField;
    private javax.swing.JLabel membership_id;
    private javax.swing.JTextField membership_id_TextField;
    private javax.swing.JTextField membership_start_TextField;
    private javax.swing.JLabel mobileno;
    private javax.swing.JTextField mobileno_TextField;
    private javax.swing.JLabel name;
    private javax.swing.JTextField name_TextField;
    private javax.swing.JLabel profilepic;
    private javax.swing.JButton reset_Button;
    private javax.swing.JComboBox<String> timimg_ComboBox;
    private javax.swing.JButton view_Button;
    // End of variables declaration//GEN-END:variables
}
