/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gym.general.bmi;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.raven.datechooser.DateChooser;

import java.awt.Frame;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Body_Measurment_Card extends javax.swing.JFrame {

    Connection con=null;
      ResultSet rs=null;
      Statement st=null;
      PreparedStatement pst=null;
     int measurmentid=0;
     private DateChooser date_dc;
    
    public Body_Measurment_Card() {
       FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
       FlatIntelliJLaf.setup();
         date_dc=new DateChooser();
        date_dc.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
      
       initComponents();
        
       this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         idSearchComboBox.setVisible(false);
         namesearchComboBox.setVisible(false);
         get_measurment_id();
         jt.setVisible(false);
    }

    
     public void show_members_details_by_name() throws SQLException{
    
        System.out.println("show members details by name");
        
        memberidTextField.setEditable(true);
        nameTextField.setEditable(true);
        
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        String membership_id_rs;
        String dateofjoin_rs;
        String member_name_rs;
        String mobile_no_rs;
        
        String mem_name=nameTextField.getText();
        
        String query="select * from dbo.Mst_Employee where EmpName='"+mem_name+"'";
        
        try {
             con=DriverManager.getConnection(url, username, password);
             st=con.createStatement();
             rs=st.executeQuery(query);
             
             if (rs.next()) {                
                 membership_id_rs=rs.getString("EmpId");
                 mobile_no_rs=rs.getString("phoneno");
                dateofjoin_rs=rs.getDate("DateofJoin").toString();
                String membership_start_date_rs=rs.getDate("ShiftStartDate").toString();
                String membership_end_date_rs=rs.getString("ReginDate");
                
                memberidTextField.setText(membership_id_rs);
                memberidTextField.setEditable(false);
                
                
                nameTextField.setText(mem_name);
                nameTextField.setEditable(false);
                
                
               // mem_end_date_TextField.setText(membership_end_date_rs);
                //mem_end_date_TextField.setEditable(false);
                
             }     
                 }catch(NullPointerException e){
                      JOptionPane.showMessageDialog(new Frame(), "SQL EXCEPTION");
                      e.printStackTrace();
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                 }
                
        finally{
            con.close();
            memberidTextField.setEditable(false);
        
        }
    }

     public  void get_measurment_id(){
            String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
           String username = "sa";
           String password = "Dhaval@7869";
           String query="select IDENT_CURRENT('bodymeasurment')";

        try {
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            rs=st.executeQuery(query);
            if (rs.next()) {
                measurmentid=rs.getInt(1);
                System.out.println("Last measurment ID:"+measurmentid);
                
                
                System.out.println("Current measurment ID"+measurmentid);
                
                measurmentIDTextField.setText(String.valueOf(measurmentid));
                measurmentIDTextField.setEditable(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "SQL ERROR");
        }
    
    }
    
     public void reset(){
         memberidTextField.setText("");
         nameTextField.setText("");
         bodyfatTextField.setText("");
         bmiTextField.setText("");
         bmrTextField.setText("");
         visceralfatTextField.setText("");
         dateTextField.setText("");
         ageTextField.setText("");
         hieghtTextField.setText("");
         neckTextField.setText("");
         wieghtTextField.setText("");
         ankleTextField.setText("");
         calfTextField.setText("");
         hipTextField.setText("");
         forearmTextField.setText("");
         upperabsTextField.setText("");
         lowerabsTextField.setText("");
         upperthighsTextField.setText("");
         lowerthighsTextField.setText("");
         shoulderTextField.setText("");
         chestTextField.setText("");
         armTextField.setText("");
         waistTextField.setText("");
     
     }
     
     public void add_body_measurment(){
     
         String mem_id=memberidTextField.getText();
         String mem_name=nameTextField.getText();
         String age=ageTextField.getText();
         String gender=buttonGroup1.getSelection().getActionCommand();
         String date=dateTextField.getText();
         String hieght=hieghtTextField.getText();
         String wieght=wieghtTextField.getText();
         String bmi=bmiTextField.getText();
         String bodyfat=bodyfatTextField.getText();
         String muscles=musclesTextField.getText();
         String bmr=bmrTextField.getText();
         String visceralfat=visceralfatTextField.getText();
         String ankle=ankleTextField.getText();
         String neck=neckTextField.getText();
         String Shoulder=shoulderTextField.getText();
         String chest=chestTextField.getText();
         String arm=armTextField.getText();
         String wrist=wristTextField.getText();
         String forearm=forearmTextField.getText();
         String upperabs=upperabsTextField.getText();
         String lowerabs=lowerabsTextField.getText();
         String waist=waistTextField.getText();
         String hips=hipTextField.getText();
         String upper_thigh=upperthighsTextField.getText();
         String lower_thigh=lowerthighsTextField.getText();
         String calf=calfTextField.getText();
         
         
         System.out.println(gender);
         
         try {
             
          String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
          String username = "sa";
          String password = "Dhaval@7869";
          
          String query="INSERT INTO [dbo].[BodyMeasurment]\n" +
"           ([Member_ID]\n" +
"           ,[Name]\n" +
"           ,[Age]\n" +
"           ,[Gender]\n" +
"           ,[Date]\n" +
"           ,[Hieght]\n" +
"           ,[Wieght]\n" +
"           ,[BMI]\n" +
"           ,[Bodyfat]\n" +
"           ,[Muscles]\n" +
"           ,[BMR]\n" +
"           ,[Visceral_Fat]\n" +
"           ,[Ankle]\n" +
"           ,[Neck]\n" +
"           ,[Shoulder]\n" +
"           ,[Chest]\n" +
"           ,[Arm]\n" +
"           ,[Wrist]\n" +
"           ,[Forearm]\n" +
"           ,[Upper_ABS]\n" +
"           ,[Lower_ABS]\n" +
"           ,[Waist]\n" +
"           ,[Hip]\n" +
"           ,[Upper_thighs]\n" +
"           ,[lower_thighs]\n" +
"           ,[calf])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
           con=DriverManager.getConnection(url, username, password);
              pst=con.prepareStatement(query);
              pst.setString(1, mem_id);
              pst.setString(2, mem_name);
              pst.setString(3, age);
              pst.setString(4, gender);
              pst.setString(5, date);
              pst.setString(6, hieght);
              pst.setString(7, wieght);
              pst.setString(8, bmi);
              pst.setString(9, bodyfat);
              pst.setString(10, muscles);
              pst.setString(11, bmr);
              pst.setString(12, visceralfat);
              pst.setString(13, ankle);
              pst.setString(14, neck);
              pst.setString(15, Shoulder);
              pst.setString(16, chest);
              pst.setString(17, arm);
              pst.setString(18, wrist);
              pst.setString(19, forearm);
              pst.setString(20, upperabs);
              pst.setString(21, lowerabs);
              pst.setString(22, waist);
              pst.setString(23, hips);
              pst.setString(24, upper_thigh);
              pst.setString(25, lower_thigh);
              pst.setString(26, calf);
              
              int count=pst.executeUpdate();
              
              if (count>0) {
                  System.out.println("success");
                  JOptionPane.showMessageDialog(new JFrame(), "Body Measurements Added Successfully");
                  reset();
              } else {
                  System.out.println("failure");
                  JOptionPane.showMessageDialog(new JFrame(), "ERROR!:OPERATION FAILED");
              }
              
              
          
         } catch (Exception e) {
                   e.printStackTrace();
              JOptionPane.showMessageDialog(new JFrame(), "ERROR!:OPERATION FAILED");
          
         }
     }
    
   public void show_members_details_by_id() throws SQLException{
    
        memberidTextField.setEditable(true);
        nameTextField.setEditable(true);
        
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        String membership_id_rs;
        String dateofjoin_rs;
        String member_name_rs;
        String mobile_no_rs;
        
        String mem_id=memberidTextField.getText();
        
        String query="select * from dbo.Mst_Employee where Empid='"+mem_id+"'";
        
        try {
             con=DriverManager.getConnection(url, username, password);
             st=con.createStatement();
             rs=st.executeQuery(query);
             
             if (rs.next()) {    
                 member_name_rs=rs.getString("EmpName");
                // membership_id_rs=rs.getString("EmpCode");
                 mobile_no_rs=rs.getString("phoneno");
                dateofjoin_rs=rs.getDate("DateofJoin").toString();
                String membership_start_date_rs=rs.getDate("ShiftStartDate").toString();
                String membership_end_date_rs=rs.getString("ReginDate");
                
                memberidTextField.setText(mem_id);
                memberidTextField.setEditable(false);
                
                
                nameTextField.setText(member_name_rs);
                nameTextField.setEditable(false);
                
                
               // mem_end_date_TextField.setText(membership_end_date_rs);
                //mem_end_date_TextField.setEditable(false);
                
             }     
                 }catch(NullPointerException e){
                      JOptionPane.showMessageDialog(new Frame(), "SQL EXCEPTION");
                      e.printStackTrace();
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                 }
                
        finally{
            con.close();
            nameTextField.setEditable(false);
        
        }
    }
   
     private List<String> namesearchresult(String prefix) {
   
          String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        List<String> list = new ArrayList<>();
    String query = "SELECT empname FROM dbo.mst_employee WHERE empname LIKE ?";
    try {
       con=DriverManager.getConnection(url,username,password);
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, prefix + "%");  
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            list.add(rs.getString("empname"));
        }
        rs.close();
        pst.close();
        
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(new JFrame(), "SEARCH ERROR");
        e.printStackTrace();
    }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
            
        }
    return list;
    
    
    
}
    
    
    private List<String> idsearchresult(String prefix) {
   
          String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        List<String> list = new ArrayList<>();
    String query = "SELECT empid FROM dbo.mst_employee WHERE empid LIKE ?";
    try {
       con=DriverManager.getConnection(url,username,password);
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, prefix + "%");  
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            list.add(rs.getString("empid"));
        }
        rs.close();
        pst.close();
        
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(new JFrame(), "SEARCH ERROR");
        e.printStackTrace();
    }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
            
        }
    return list;
    
    
    
}
  
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        memberidTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        measurmentIDTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        hieghtTextField = new javax.swing.JTextField();
        wieghtTextField = new javax.swing.JTextField();
        bmiTextField = new javax.swing.JTextField();
        bodyfatTextField = new javax.swing.JTextField();
        musclesTextField = new javax.swing.JTextField();
        bmrTextField = new javax.swing.JTextField();
        visceralfatTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lowerabsTextField = new javax.swing.JTextField();
        upperabsTextField = new javax.swing.JTextField();
        forearmTextField = new javax.swing.JTextField();
        wristTextField = new javax.swing.JTextField();
        armTextField = new javax.swing.JTextField();
        chestTextField = new javax.swing.JTextField();
        shoulderTextField = new javax.swing.JTextField();
        neckTextField = new javax.swing.JTextField();
        waistTextField = new javax.swing.JTextField();
        upperthighsTextField = new javax.swing.JTextField();
        hipTextField = new javax.swing.JTextField();
        lowerthighsTextField = new javax.swing.JTextField();
        calfTextField = new javax.swing.JTextField();
        ankleTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        generaterecieptButton = new javax.swing.JButton();
        printrecieptButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        idSearchComboBox = new javax.swing.JComboBox<>();
        namesearchComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Measurment Card");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Member ID");

        memberidTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                memberidTextFieldKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Measurment ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Name");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Age");

        ageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Gender");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.setActionCommand("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("female");
        jRadioButton2.setActionCommand("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Date");

        date_dc.setTextField(dateTextField);
        dateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Hieght");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Wieght");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("BMI");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Body Fat");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Muscles");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("BMR");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Visceral Fat");

        hieghtTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hieghtTextFieldActionPerformed(evt);
            }
        });

        wieghtTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wieghtTextFieldActionPerformed(evt);
            }
        });

        bmiTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmiTextFieldActionPerformed(evt);
            }
        });

        bodyfatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bodyfatTextFieldActionPerformed(evt);
            }
        });

        musclesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musclesTextFieldActionPerformed(evt);
            }
        });

        bmrTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmrTextFieldActionPerformed(evt);
            }
        });

        visceralfatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visceralfatTextFieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Neck");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Chest");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Shoulder");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Arm");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Wrist");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Forearm");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Upper ABS");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Waist");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Lower ABS");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Hip");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Upper Thighs");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Lower Thighs");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Calf");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Ankle");

        lowerabsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowerabsTextFieldActionPerformed(evt);
            }
        });

        upperabsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upperabsTextFieldActionPerformed(evt);
            }
        });

        forearmTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forearmTextFieldActionPerformed(evt);
            }
        });

        wristTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wristTextFieldActionPerformed(evt);
            }
        });

        armTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                armTextFieldActionPerformed(evt);
            }
        });

        chestTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chestTextFieldActionPerformed(evt);
            }
        });

        shoulderTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoulderTextFieldActionPerformed(evt);
            }
        });

        neckTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neckTextFieldActionPerformed(evt);
            }
        });

        waistTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waistTextFieldActionPerformed(evt);
            }
        });

        upperthighsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upperthighsTextFieldActionPerformed(evt);
            }
        });

        hipTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hipTextFieldActionPerformed(evt);
            }
        });

        lowerthighsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowerthighsTextFieldActionPerformed(evt);
            }
        });

        calfTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calfTextFieldActionPerformed(evt);
            }
        });

        ankleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ankleTextFieldActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(32, 161, 93));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");
        saveButton.setBorderPainted(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        generaterecieptButton.setBackground(new java.awt.Color(32, 161, 93));
        generaterecieptButton.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        generaterecieptButton.setForeground(new java.awt.Color(255, 255, 255));
        generaterecieptButton.setText("Generate Reciept");
        generaterecieptButton.setBorderPainted(false);
        generaterecieptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaterecieptButtonActionPerformed(evt);
            }
        });

        printrecieptButton.setBackground(new java.awt.Color(32, 161, 93));
        printrecieptButton.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        printrecieptButton.setForeground(new java.awt.Color(255, 255, 255));
        printrecieptButton.setText("Print Reciept");
        printrecieptButton.setBorderPainted(false);
        printrecieptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printrecieptButtonActionPerformed(evt);
            }
        });

        resetButton.setBackground(new java.awt.Color(32, 161, 93));
        resetButton.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("Reset");
        resetButton.setBorderPainted(false);
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        idSearchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idSearchComboBoxActionPerformed(evt);
            }
        });
        idSearchComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idSearchComboBoxKeyPressed(evt);
            }
        });

        namesearchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namesearchComboBoxActionPerformed(evt);
            }
        });
        namesearchComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namesearchComboBoxKeyPressed(evt);
            }
        });

        jt.setColumns(20);
        jt.setRows(5);
        jScrollPane1.setViewportView(jt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(44, 44, 44)
                                .addComponent(memberidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel28))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ankleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jRadioButton1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jRadioButton2))
                                        .addComponent(measurmentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateTextField)
                                        .addComponent(nameTextField)
                                        .addComponent(ageTextField)
                                        .addComponent(hieghtTextField)
                                        .addComponent(wieghtTextField)
                                        .addComponent(bmiTextField)
                                        .addComponent(bodyfatTextField)
                                        .addComponent(musclesTextField)
                                        .addComponent(bmrTextField)
                                        .addComponent(visceralfatTextField))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(resetButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(generaterecieptButton))
                                    .addComponent(idSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namesearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel23))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lowerabsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(upperthighsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(waistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(neckTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(shoulderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(upperabsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(forearmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(wristTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(armTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel24)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel27)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(calfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel26)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lowerthighsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(printrecieptButton)
                                .addGap(18, 18, 18)
                                .addComponent(saveButton))))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(memberidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(neckTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(measurmentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(shoulderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(chestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namesearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(armTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel19)
                            .addComponent(wristTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(forearmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(hieghtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(upperabsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(wieghtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(lowerabsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(bmiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(waistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(bodyfatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(hipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(musclesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(upperthighsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(bmrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(lowerthighsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(visceralfatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(calfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(ankleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton)
                            .addComponent(generaterecieptButton)
                            .addComponent(printrecieptButton)
                            .addComponent(resetButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void ageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTextFieldActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void dateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTextFieldActionPerformed

    private void hieghtTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hieghtTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hieghtTextFieldActionPerformed

    private void wieghtTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wieghtTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wieghtTextFieldActionPerformed

    private void bmiTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmiTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bmiTextFieldActionPerformed

    private void bodyfatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bodyfatTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bodyfatTextFieldActionPerformed

    private void musclesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musclesTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_musclesTextFieldActionPerformed

    private void bmrTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmrTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bmrTextFieldActionPerformed

    private void visceralfatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visceralfatTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_visceralfatTextFieldActionPerformed

    private void lowerabsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowerabsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lowerabsTextFieldActionPerformed

    private void upperabsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upperabsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_upperabsTextFieldActionPerformed

    private void forearmTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forearmTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forearmTextFieldActionPerformed

    private void wristTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wristTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wristTextFieldActionPerformed

    private void armTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_armTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_armTextFieldActionPerformed

    private void chestTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chestTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chestTextFieldActionPerformed

    private void shoulderTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoulderTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shoulderTextFieldActionPerformed

    private void neckTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neckTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_neckTextFieldActionPerformed

    private void waistTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waistTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_waistTextFieldActionPerformed

    private void upperthighsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upperthighsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_upperthighsTextFieldActionPerformed

    private void hipTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hipTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hipTextFieldActionPerformed

    private void lowerthighsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowerthighsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lowerthighsTextFieldActionPerformed

    private void calfTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calfTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calfTextFieldActionPerformed

    private void ankleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ankleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ankleTextFieldActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        add_body_measurment();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void printrecieptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printrecieptButtonActionPerformed
        try {
            // TODO add your handling code here:
            jt.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Body_Measurment_Card.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printrecieptButtonActionPerformed

    private void generaterecieptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaterecieptButtonActionPerformed
        // TODO add your handling code here:
        jt.setVisible(true);
       
                   jt.setText(" ********************************************************************************** \n");
                                jt.setText(jt.getText()+" *                            Fitness Hub || Measurement Card                * \n");
                                jt.setText(jt.getText()+" **************************************************************************************** \n");	
                                Date obj= new Date();
                                String feedate=obj.toString();
                                jt.setText(jt.getText()+"\n     "+feedate+"            Receipt no:  "+measurmentIDTextField.getText()+"\n\n");
                                jt.setText(jt.getText()+"       Membership_No:              "+memberidTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Age:                                  "+ageTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Height:                              "+hieghtTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Weight:                              "+wieghtTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Date:                                "+dateTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       BMI:                                  "+bmiTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Body Fat:                          "+bodyfatTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Muscles:                            "+musclesTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       BMR:                                 "+bmrTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Visceral Fat:                     "+visceralfatTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Neck:                                 "+neckTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Shoulder:                          "+shoulderTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Chest:                                "+chestTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Arm:                                  "+armTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Wrist:                                "+wristTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       ForeArms:                        "+forearmTextField.getText()+"\n                                  ---------------------------------------\n");       
                                jt.setText(jt.getText()+"       Upper ABS:                       "+upperabsTextField.getText()+"\n                                  ---------------------------------------\n");     
                                jt.setText(jt.getText()+"       Lower ABS:                       "+lowerabsTextField.getText()+"\n                                  ---------------------------------------\n");   
                                jt.setText(jt.getText()+"       Hip:                                   "+hipTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Upper Thighs:                   "+upperthighsTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Lower Thighs:                   "+lowerthighsTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       calf:                                  "+calfTextField.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Ankle:                               "+ankleTextField.getText()+"\n                                  ---------------------------------------");               
                                jt.setText(jt.getText()+"\n\n                                                                        Signature");
    }//GEN-LAST:event_generaterecieptButtonActionPerformed

    private void idSearchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idSearchComboBoxActionPerformed
        // TODO add your handling code here:

        String selectedResult = (String) idSearchComboBox.getSelectedItem();
        if (selectedResult != null) {
            // Set the selected result to the searchTextField
            memberidTextField.setText(selectedResult);
            idSearchComboBox.setVisible(false);
            try {
                show_members_details_by_id();
            } catch (SQLException ex) {
                Logger.getLogger(Body_Measurment_Card.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_idSearchComboBoxActionPerformed

    private void idSearchComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idSearchComboBoxKeyPressed
        // TODO add your handling code here:
        String result=idSearchComboBox.getSelectedItem().toString();
        memberidTextField.setText(result);

        idSearchComboBox.setVisible(false);

    }//GEN-LAST:event_idSearchComboBoxKeyPressed

    private void memberidTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memberidTextFieldKeyReleased
        // TODO add your handling code here:
        String searchstring = memberidTextField.getText();
      idSearchComboBox.setVisible(true);
      idSearchComboBox.setEnabled(true);
      
        try {
            List<String> idsearchresult_list=idsearchresult(searchstring);
            idSearchComboBox.setModel(new DefaultComboBoxModel<>(idsearchresult_list.toArray(new String[0])));
            //namesearchComboBox.requestFocusInWindow();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Search ERROR");
        }
    }//GEN-LAST:event_memberidTextFieldKeyReleased

    private void namesearchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namesearchComboBoxActionPerformed
        // TODO add your handling code here:
        String selectedResult = (String) namesearchComboBox.getSelectedItem();
        if (selectedResult != null) {
            // Set the selected result to the searchTextField
            nameTextField.setText(selectedResult);
            namesearchComboBox.setVisible(false);
            try {
                show_members_details_by_name();
            } catch (SQLException ex) {
                Logger.getLogger(Body_Measurment_Card.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_namesearchComboBoxActionPerformed

    private void namesearchComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namesearchComboBoxKeyPressed
        // TODO add your handling code here:
        String result=namesearchComboBox.getSelectedItem().toString();
        nameTextField.setText(result);

        namesearchComboBox.setVisible(false);

    }//GEN-LAST:event_namesearchComboBoxKeyPressed

    private void nameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyReleased
        // TODO add your handling code here:
        String searchstring = nameTextField.getText();
      namesearchComboBox.setVisible(true);
      namesearchComboBox.setEnabled(true);
      
        try {
            List<String> namesearchresult_list=namesearchresult(searchstring);
            namesearchComboBox.setModel(new DefaultComboBoxModel<>(namesearchresult_list.toArray(new String[0])));
            //namesearchComboBox.requestFocusInWindow();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Search ERROR");
        }
        
    
    }//GEN-LAST:event_nameTextFieldKeyReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Body_Measurment_Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Body_Measurment_Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Body_Measurment_Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Body_Measurment_Card.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Body_Measurment_Card().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageTextField;
    private javax.swing.JTextField ankleTextField;
    private javax.swing.JTextField armTextField;
    private javax.swing.JTextField bmiTextField;
    private javax.swing.JTextField bmrTextField;
    private javax.swing.JTextField bodyfatTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField calfTextField;
    private javax.swing.JTextField chestTextField;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JTextField forearmTextField;
    private javax.swing.JButton generaterecieptButton;
    private javax.swing.JTextField hieghtTextField;
    private javax.swing.JTextField hipTextField;
    private javax.swing.JComboBox<String> idSearchComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jt;
    private javax.swing.JTextField lowerabsTextField;
    private javax.swing.JTextField lowerthighsTextField;
    private javax.swing.JTextField measurmentIDTextField;
    private javax.swing.JTextField memberidTextField;
    private javax.swing.JTextField musclesTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox<String> namesearchComboBox;
    private javax.swing.JTextField neckTextField;
    private javax.swing.JButton printrecieptButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField shoulderTextField;
    private javax.swing.JTextField upperabsTextField;
    private javax.swing.JTextField upperthighsTextField;
    private javax.swing.JTextField visceralfatTextField;
    private javax.swing.JTextField waistTextField;
    private javax.swing.JTextField wieghtTextField;
    private javax.swing.JTextField wristTextField;
    // End of variables declaration//GEN-END:variables
}
