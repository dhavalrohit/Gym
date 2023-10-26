/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//constarint and search added on 07/09/23

package com.gym.general.members;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.gym.general.fees.TextPrompt;
import com.itextpdf.text.log.Logger;
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.gym.connection.connection;

/**
 *
 * @author DELL
 */
public class Edit_Update_Member extends javax.swing.JFrame {

    private DateChooser dateofbith_dc;
    private DateChooser dateofjoin_dc;
    private DateChooser membership_start_date;
    private DateChooser membership_end_date;
    private int total_members_count;

    String profile_pic_path;

    Connection con = null;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;

    private TableRowSorter<TableModel> rowSorter;

    TextPrompt searchprompt;

    ImageIcon profileimg;

    public Edit_Update_Member() {
        FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
        FlatIntelliJLaf.setup();
        total_member_count();
        dateofbith_dc = new DateChooser();
        dateofjoin_dc = new DateChooser();

        dateofbith_dc.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
        dateofjoin_dc.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));

        membership_start_date = new DateChooser();
        membership_start_date.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));

        membership_end_date = new DateChooser();
        membership_end_date.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
        this.setResizable(false);

        initComponents();
        showall_members();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

    public void total_member_count() {

        
        String query = "select count(empname) from dbo.Mst_Employee";

        try {
            con = connection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                total_members_count = rs.getInt(1);

            }
            memberscount_Label.setText(total_members_count + "");

        } catch (Exception e) {
        }
        System.out.println("total count:" + total_members_count);

    }

    public void edit() {

        name_TextField.setEditable(true);
        mobileno_TextField.setEditable(true);
        email_TextField.setEditable(true);
        dateofbirth_TextField.setEditable(true);
        fathername_TextField.setEditable(true);
        membership_id_TextField.setEditable(false);
        biometric_id_TextField.setEditable(false);
        dateofjoin_TextField.setEditable(true);
        timimg_ComboBox.setEnabled(true);
        timimg_ComboBox.setEditable(true);
        membership_start_TextField.setEditable(true);
        membership_end_TextField.setEditable(true);
        id_TextField.setEditable(true);
    }

    public boolean check_alphabetic_fields(String text, String fieldname) {
        text = text.replaceAll("\\s", "");
        boolean result = true;
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), fieldname + " Field is Empty", fieldname + " Field Error", JOptionPane.ERROR_MESSAGE);
            result = false;
        }

        if (text.length() > 0) {
            for (int i = 0; i < text.length(); i++) {
                if (Character.toString(text.charAt(i)).matches("^[a-zA-Z]+$")) {

                } else {
                    result = false;
                    JOptionPane.showMessageDialog(new JFrame(), fieldname + " Field contains Numeric value", fieldname + " Field Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }

        return result;
    }

    public boolean check_numericfields(String text, String fieldname) {
        text = text.replaceAll("\\s", "");
        text = text.replace("-", "");
        boolean res = true;
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), fieldname + " Field is Empty", fieldname + " Field Error", JOptionPane.ERROR_MESSAGE);
            res = false;
        } else if (text.length() > 0) {
            for (int i = 0; i < text.length(); i++) {
                if (Character.toString(text.charAt(i)).matches("^[0-9]+$")) {

                } else {
                    JOptionPane.showMessageDialog(new JFrame(), fieldname + " Field contains Alphabetic value", fieldname + " Field Error", JOptionPane.ERROR_MESSAGE);
                    res = false;
                    break;
                }
            }
        }

        return res;
    }

    public boolean checkallfields(boolean[] fields) {
        boolean res = true;

        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
            if (fields[i] == false) {
                res = false;
                break;
            } else {
                res = true;

            }
        }
        return res;

    }

    public void update_details() {

        String empcode = membership_id_TextField.getText().toString();
        if (empcode.isEmpty()) {
            JOptionPane.showMessageDialog(new Frame(), "Please Select Member to Update");
        }

        String name = name_TextField.getText();
        String mobileno = mobileno_TextField.getText();
        String email = email_TextField.getText();
        String dateofbirth = dateofbirth_TextField.getText();
        String fathername = fathername_TextField.getText();
        String membership_id = membership_id_TextField.getText();
        String biometric_id = biometric_id_TextField.getText();
        String id = id_TextField.getText();
        String dateofjoin = dateofjoin_TextField.getText();
        String timing = timimg_ComboBox.getSelectedItem().toString();
        String membership_start_date = membership_start_TextField.getText();
        String membership_end_date = membership_end_TextField.getText();

        //String query="update dbo.Mst_Employee where emcode='"+empcode+"'";
        String mainquery = "update dbo.Mst_Employee set EmpName=?, fathername=? ,validityend=?,DateofJoin=?,ShiftType=?"
                + ",EmailAddress=?,PhoneNo=?,DateofBirth=?,ShiftStartDate=?,ShiftCode=?,Bank_Ifsc_Code=? where empcode=" + empcode;

        try {
            con = connection.getConnection();
            pst = con.prepareStatement(mainquery);

            pst.setString(1, name);
            pst.setString(2, fathername);
            pst.setString(3, membership_end_date);
            pst.setString(4, dateofjoin);
            pst.setString(5, timing);
            pst.setString(6, email);
            pst.setString(7, mobileno);
            pst.setString(8, dateofbirth);
            pst.setString(9, membership_start_date);
            pst.setString(10, timing);
            pst.setString(11, id);

            int count = pst.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(new Frame(), "Member Updated Succesfully");
                System.out.println("Member Updated Succesfully");
                showall_members();
                total_member_count();
                reset();
            } else {
                System.out.println("Member Updation failed");
                JOptionPane.showMessageDialog(new Frame(), "ERROR:Member Updation Failed");
            }

        } catch (SQLException e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(new Frame(), "SQL Exception");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new Frame(), "ERROR:Updation Failed");
        }

    }

    public void view_selected_member() throws SQLException {


        int selectedrow = jTable1.getSelectedRow();
        String name = (String) jTable1.getModel().getValueAt(selectedrow, 1);
        System.out.println(selectedrow + " " + name);

        String query = "select * from dbo.Mst_Employee where EmpName='" + name + "'";

        try {
            con = connection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String name_rs = rs.getString("Empname");
                String mobileno_rs = rs.getString("PhoneNo");
                String email_rs = rs.getString("EmailAddress");
                String dateofbirth_rs = rs.getDate("DateofBirth").toString();
                String fathername_rs = rs.getString("FatherName");
                String membership_id_rs = rs.getString("EmpCode");
                String biometric_id_rs = rs.getString("CardNo");

                String dateofjoin_rs = rs.getDate("DateofJoin").toString();
                String timing_rs = rs.getString("ShiftCode");
                String membership_start_date_rs = rs.getDate("ShiftStartDate").toString();
                String membership_end_date_rs = rs.getString("validityend");
                String id_rs = rs.getString("Bank_Ifsc_Code");

                try {
                    Blob blobdata = rs.getBlob("profilepic");
                    if (blobdata != null) {

                        InputStream input = blobdata.getBinaryStream();
                        BufferedImage imageicon = ImageIO.read(input);

                        Image dimg = imageicon.getScaledInstance(profilepic.getWidth(), profilepic.getHeight(),
                                Image.SCALE_SMOOTH);

                        profileimg = new ImageIcon(dimg);
                        profilepic.setIcon(profileimg);
                    } else {
                        JOptionPane.showMessageDialog(new Frame(), "Details Shown Without Image");
                        profilepic.setIcon(null);
                        profilepic.revalidate();

                    }

                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(new Frame(), "Image Not Found");
                    e.printStackTrace();
                } catch (Exception e) {
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

                membership_end_TextField.setText(membership_end_date_rs.substring(0, 10));
                membership_end_TextField.setEditable(false);

                id_TextField.setText(id_rs);
                id_TextField.setEditable(false);

            } else {
                System.out.println("No member found");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(new Frame(), "Please Select Member");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }

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

    public void reset() {

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

    public void showall_members() {
        initializerowsorter();
        jTable1.setRowSorter(rowSorter);
        

        String query = "select empid as Member_ID,empname as Name,phoneno as Mobile_No from dbo.mst_employee";

        try {
            con = connection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        edit_Button = new javax.swing.JButton();
        update_Button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        dateofjoin_TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        membership_start_TextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        membership_end_TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        timimg_ComboBox = new javax.swing.JComboBox<>();
        select_Button = new javax.swing.JButton();
        cancel_Button = new javax.swing.JButton();
        close_Button = new javax.swing.JButton();

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
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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

        update_Button.setBackground(new java.awt.Color(32, 161, 93));
        update_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        update_Button.setForeground(java.awt.Color.white);
        update_Button.setText("UPDATE");
        update_Button.setBorderPainted(false);
        update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_ButtonActionPerformed(evt);
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

        select_Button.setBackground(new java.awt.Color(32, 161, 93));
        select_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        select_Button.setForeground(java.awt.Color.white);
        select_Button.setText("SELECT");
        select_Button.setBorderPainted(false);
        select_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_ButtonActionPerformed(evt);
            }
        });

        cancel_Button.setBackground(new java.awt.Color(32, 161, 93));
        cancel_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cancel_Button.setForeground(java.awt.Color.white);
        cancel_Button.setText("CANCEL");
        cancel_Button.setBorderPainted(false);
        cancel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_ButtonActionPerformed(evt);
            }
        });

        close_Button.setBackground(new java.awt.Color(32, 161, 93));
        close_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        close_Button.setForeground(java.awt.Color.white);
        close_Button.setText("CLOSE");
        close_Button.setBorderPainted(false);
        close_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_ButtonActionPerformed(evt);
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
                        .addGap(39, 39, 39)
                        .addComponent(close_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancel_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(select_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update_Button)
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
                    .addComponent(edit_Button)
                    .addComponent(update_Button)
                    .addComponent(select_Button)
                    .addComponent(cancel_Button)
                    .addComponent(close_Button))
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
        ImageIcon profileimg = new ImageIcon(profile_pic_path);
        profilepic.setIcon(profileimg);
    }//GEN-LAST:event_browseActionPerformed

    private void membership_id_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membership_id_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_membership_id_TextFieldActionPerformed

    private void edit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_ButtonActionPerformed
        // TODO add your handling code here:
        if (membership_id_TextField.getText().toString().isEmpty()) {
            JOptionPane.showMessageDialog(new Frame(), "Please Select Member");
        } else {
            edit();
        }
    }//GEN-LAST:event_edit_ButtonActionPerformed

    private void update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_ButtonActionPerformed
        // TODO add your handling code here:
        boolean membername = check_alphabetic_fields(name_TextField.getText(), "Member Name");
        boolean fathername = check_alphabetic_fields(fathername_TextField.getText(), "Father Name");
        boolean checkmobile = check_numericfields(mobileno_TextField.getText(), "Mobile No");
        boolean checkdateofbirth = check_numericfields(dateofbirth_TextField.getText(), "Date of Birth");
        boolean dateofjoin = check_numericfields(dateofjoin_TextField.getText(), "Date of Join");
        boolean memstart = check_numericfields(membership_start_TextField.getText(), "Membership Start Date");
        boolean memend = check_numericfields(membership_end_TextField.getText(), "Membership End Date");

        boolean[] checkallfield_forpayments = {membername, fathername, checkmobile, checkdateofbirth, dateofjoin, memstart, memend};
        boolean check_constraints = checkallfields(checkallfield_forpayments);

        if (check_constraints == true) {
            update_details();

        } else {
            System.out.println("Invalid Fields");
            JOptionPane.showMessageDialog(new JFrame(), "Error:Fields are Empty or Invalid", "Add Payment Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_update_ButtonActionPerformed

    private void dateofjoin_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateofjoin_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateofjoin_TextFieldActionPerformed

    private void select_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_ButtonActionPerformed

        try {
            // TODO add your handling code here:

            view_selected_member();

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(new Frame(), "Please Select Member");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new Frame(), "SQL Exception");
            ex.printStackTrace();
        }

    }//GEN-LAST:event_select_ButtonActionPerformed

    private void name_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_TextFieldKeyReleased
        // TODO add your handling code here:
        String text = name_TextField.getText();
        int len = text.length();
        for (int i = 0; i < len; i++) {
            if (Character.toString(text.charAt(i)).matches("^[a-zA-Z]+$")) {
                continue;
            } else {

                JOptionPane.showMessageDialog(new JFrame(), "Name Field Contains Number", "Name Field Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Contains number");
                name_TextField.setText(null);
            }
        }

    }//GEN-LAST:event_name_TextFieldKeyReleased

    private void mobileno_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileno_TextFieldKeyReleased

        String text = mobileno_TextField.getText();
        for (int i = 0; i < text.length(); i++) {
            int len = 0;

            if (mobileno_TextField.getText().length() > 0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
                len = text.length();

            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed", "Hieght Field Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Contains Alphabet");
            }

        }

    }//GEN-LAST:event_mobileno_TextFieldKeyReleased

    private void cancel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_ButtonActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_cancel_ButtonActionPerformed

    private void close_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_ButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_close_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Edit_Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Update_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel biometric_id;
    private javax.swing.JTextField biometric_id_TextField;
    private javax.swing.JButton browse;
    private javax.swing.JButton cancel_Button;
    private javax.swing.JButton close_Button;
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
    private javax.swing.JButton select_Button;
    private javax.swing.JComboBox<String> timimg_ComboBox;
    private javax.swing.JButton update_Button;
    // End of variables declaration//GEN-END:variables
}
