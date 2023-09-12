/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//constarint and search added on 07/09/23
package com.gym.general.members;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.gym.general.fees.TextPrompt;
import com.raven.datechooser.DateChooser;
import java.awt.Color;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DELL
 */
public class Delete_Member extends javax.swing.JFrame {

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
      
       private TableRowSorter<TableModel> rowSorter;

    TextPrompt searchprompt;
  
       public Delete_Member() {
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
       
        initComponents();
        showall_members();
        total_member_count();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
         searchprompt=new TextPrompt("Search by Name,Mobile No,ID...", searchTextField);
          searchprompt.setForeground(Color.GRAY);
        searchprompt.setHorizontalAlignment((int) LEFT_ALIGNMENT);
        searchprompt.changeStyle(Font.BOLD+Font.ITALIC);
       
        
         initializerowsorter();
        jTable1.setRowSorter(rowSorter);
        searchTextField.getDocument().addDocumentListener(new DocumentListener(){

             @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchTextField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

             @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchTextField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

             @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

             

        });

        
    }
       
           public void initializerowsorter() {
        rowSorter = new TableRowSorter<TableModel>(jTable1.getModel());

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
            
        } catch (Exception e) {
        }
        System.out.println("total count:"+total_members_count);
        
        
        
        
        
    }
     
 

 
    
    
    
       public void selectFile() {
        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            profile_pic_path = chooser.getSelectedFile().getAbsolutePath();
            // read  and/or display the file somehow. ....
        } else {
            // user changed their mind
        }
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
                String membership_id_rs=rs.getString("EmpCode");
                String biometric_id_rs=rs.getString("CardNo");
                
                String dateofjoin_rs=rs.getDate("DateofJoin").toString();
                String timing_rs=rs.getString("ShiftCode");
                String membership_start_date_rs=rs.getDate("ShiftStartDate").toString();
                String membership_end_date_rs = rs.getString("validityend");
                String id_rs = rs.getString("Bank_Ifsc_Code");
 
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
                 timimg_ComboBox.setEditable(false);
                 timimg_ComboBox.setEnabled(false);
                 
                 membership_start_TextField.setText(membership_start_date_rs);
                 membership_start_TextField.setEditable(false);
                 
                 membership_end_TextField.setText(membership_end_date_rs.substring(0, 10));
                 membership_end_TextField.setEditable(false);
                 
                 id_TextField.setText(id_rs);
                id_TextField.setEditable(false);

                 
            }
             else{
                 System.out.println("No member found");
             }
             
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            con.close();
        }
        
    }
  
  public void delete() throws SQLException{
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        
        int selectedrow= jTable1.getSelectedRow();
        String name= (String) jTable1.getModel().getValueAt(selectedrow, 1);
        System.out.println(selectedrow+" "+name);
        
        String query="delete from dbo.Mst_Employee where EmpName='"+name+"'";
        
      try {
          con=DriverManager.getConnection(url, username, password);
          st=con.createStatement();
            
          int i=st.executeUpdate(query);
          if (i>0) {
            JOptionPane.showMessageDialog(new Frame(), "Member Deleted Succesfully");
            showall_members();
            total_member_count();
          }else{
              JOptionPane.showMessageDialog(new Frame(), "Member Deletion Failed");
          }
      } catch(ArrayIndexOutOfBoundsException e){
           JOptionPane.showMessageDialog(new Frame(), "Please Select Member");
      }catch(SQLException e){
          JOptionPane.showMessageDialog(new Frame(), "SQL Exception");
          e.printStackTrace();
      }
        
      catch (Exception e) {
          e.printStackTrace();
      }finally{
          con.close();
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
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        memberscount_Label = new javax.swing.JLabel();
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
        delete_Button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        dateofjoin_TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        membership_start_TextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        membership_end_TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        timimg_ComboBox = new javax.swing.JComboBox<>();
        view_Button = new javax.swing.JButton();
        back_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(33, 161, 93));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Members List");
        jLabel1.setOpaque(true);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButton1.setText("Show All Members");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                        .addComponent(searchTextField))
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
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(memberscount_Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );

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

        mobileno.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        mobileno.setText("Mobile No");

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

        delete_Button.setBackground(new java.awt.Color(32, 161, 93));
        delete_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        delete_Button.setForeground(java.awt.Color.white);
        delete_Button.setText("DELETE");
        delete_Button.setBorderPainted(false);
        delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_ButtonActionPerformed(evt);
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

        back_Button.setBackground(new java.awt.Color(32, 161, 93));
        back_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        back_Button.setForeground(java.awt.Color.white);
        back_Button.setText("BACK");
        back_Button.setBorderPainted(false);
        back_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_ButtonActionPerformed(evt);
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
                        .addGap(32, 32, 32)
                        .addComponent(back_Button)
                        .addGap(18, 18, 18)
                        .addComponent(view_Button)
                        .addGap(18, 18, 18)
                        .addComponent(delete_Button)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete_Button)
                    .addComponent(view_Button)
                    .addComponent(back_Button))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        selectFile();
        ImageIcon profileimg=new ImageIcon(profile_pic_path);
        profilepic.setIcon(profileimg);
    }//GEN-LAST:event_browseActionPerformed

    private void membership_id_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membership_id_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_membership_id_TextFieldActionPerformed

    private void delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_ButtonActionPerformed
        // TODO add your handling code here:
        try {
            delete();
        }catch(ArrayIndexOutOfBoundsException e){
           JOptionPane.showMessageDialog(new Frame(), "Please Select Member");
      } 
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            showall_members();
            total_member_count();
            
        }
    }//GEN-LAST:event_delete_ButtonActionPerformed

    private void dateofjoin_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateofjoin_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateofjoin_TextFieldActionPerformed

    private void view_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_ButtonActionPerformed

        try {
            view_selected_member();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_view_ButtonActionPerformed

    private void back_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_ButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_back_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Delete_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delete_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delete_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delete_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Delete_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JButton back_Button;
    private javax.swing.JLabel biometric_id;
    private javax.swing.JTextField biometric_id_TextField;
    private javax.swing.JButton browse;
    private javax.swing.JLabel dateofbirth;
    private javax.swing.JTextField dateofbirth_TextField;
    private javax.swing.JTextField dateofjoin_TextField;
    private javax.swing.JButton delete_Button;
    private javax.swing.JTextField email_TextField;
    private javax.swing.JLabel fathername;
    private javax.swing.JTextField fathername_TextField;
    private javax.swing.JTextField id_TextField;
    private javax.swing.JLabel id_aadhar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
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
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> timimg_ComboBox;
    private javax.swing.JButton view_Button;
    // End of variables declaration//GEN-END:variables
}
