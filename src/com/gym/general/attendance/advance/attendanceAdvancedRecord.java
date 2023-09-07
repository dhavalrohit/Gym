/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.gym.general.attendance.advance;

import com.gym.general.attendance.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatPanelUI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

import com.raven.datechooser.*;
import com.raven.datechooser.DateBetween;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.ui.FlatLineBorder;
import com.formdev.flatlaf.ui.FlatTableUI;
import com.gym.general.swing.RoundBorder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class attendanceAdvancedRecord extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    double x = 50;
    double y = 50;
    private DateChooser startdate;

    private DateChooser enddate;

    public attendanceAdvancedRecord() {

        FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
        FlatIntelliJLaf.setup();
        initComponents();
        jTable1.setBackground(Color.WHITE);
        jTable1.getTableHeader().setBackground(Color.WHITE);

        
        
        startdate = new DateChooser();
        enddate = new DateChooser();

        startdate.setTextField(datetextfield1);
        startdate.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));

        enddate.setTextField(datetextfield2);
        enddate.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
        
    }

    public void getdatabymID_Date() throws SQLException {
        System.out.println("Get Member Data by ID and Date");
        String datefrom = datetextfield1.getText().toString();
        String datetodate = datetextfield2.getText().toString();
        System.out.println(datefrom);
        System.out.println(datetodate);
        String midNO = mno.getText();
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
        String midNOdate = mno.getText();
        String sql_query_by_mid_date = "select  dbo.Mst_Employee.empname as " + "'Member Name'" + ",dbo.Tran_Attendance.empid as" + "'Member ID'" + ",dbo.Tran_Attendance.DateOFFICE as " + "'Date'" + ",dbo.Tran_Attendance.Punch1 as " + "'IN-Punch'" + ",dbo.Tran_Attendance.Punch2 as " + "'OUT-Punch'" + ",dbo.Tran_Attendance.allpunchs as " + "'All Punch'" + "from dbo.Mst_Employee"
                + " inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId   WHERE dbo.Tran_Attendance.EmpId=" + midNOdate + "and DateOFFICE between '" + datefrom + "' and '" + datetodate + "'";

        try {
            con = DriverManager.getConnection(url, username, password);
            pst = con.prepareStatement(sql_query_by_mid_date);
            rs = pst.executeQuery();
            System.out.println(startdate);
            System.out.println(enddate);
            /* while (rs.next()) {                
                System.out.println("Emp Name"+rs.getString("empname"));
                System.out.println("Emp ID"+rs.getInt("empid"));
            }*/
            jTable1.setUI(new FlatTableUI());
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(attendanceAdvancedRecord.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            pst.close();
            rs.close();
            con.close();
        }
        jLabel4.setText("Records Shown According To Member ID and Date Selected");
    }

    public void getdatabymemberid() throws SQLException {
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
        String midNO = mno.getText();
        String sql_query_by_mid = "select  dbo.Mst_Employee.empname as " + "'Member Name'" + ",dbo.Tran_Attendance.empid as" + "'Member ID'" + ",dbo.Tran_Attendance.DateOFFICE as " + "'Date'" + ",dbo.Tran_Attendance.Punch1 as " + "'IN-Punch'" + ",dbo.Tran_Attendance.Punch2 as " + "'OUT-Punch'" + ",dbo.Tran_Attendance.allpunchs as " + "'All Punch'" + "from dbo.Mst_Employee"
                + " inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId  WHERE  dbo.Tran_Attendance.EmpId=" + midNO;

        try {
            con = DriverManager.getConnection(url, username, password);
            pst = con.prepareStatement(sql_query_by_mid);
            rs = pst.executeQuery();
            System.out.println(startdate);
            System.out.println(enddate);
            /* while (rs.next()) {                
                System.out.println("Emp Name"+rs.getString("empname"));
                System.out.println("Emp ID"+rs.getInt("empid"));
            }*/
            jTable1.setUI(new FlatTableUI());
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            Logger.getLogger(attendanceAdvancedRecord.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            pst.close();
            rs.close();
            con.close();

        }
        jLabel4.setText("Records Shown According to Member ID");
    }

    public void getattendancebydate() throws SQLException, SQLException, ParseException {
        //table1.addRow(new ModelMember(new ImageIcon(getClass().getResource("/com/gym/general/icon/profile.jpg")), "Jonh", "Male", "Java", 300).toRowTable(eventAction));
        //Get_Data();
        jLabel4.setText("Data Shown According to Date Range");
        System.out.println("Get attendance data by date method");

        /*String sql_query_join="select dbo.mst_employee.EmpName,dbo.mst_employee.Empcode, dbo.tran_machinerawpunch.cardno,\n" +
"dbo.tran_machinerawpunch.punchdatetime from dbo.mst_employee \n" +
"INNER JOIN dbo.tran_machinerawpunch on dbo.mst_employee.cardno=dbo.tran_machinerawpunch.cardno order by punchdatetime";*/
        String sql_query_join = "select dbo.Mst_Employee.empname ,dbo.Tran_Attendance.empid,dbo.Tran_Attendance.DateOFFICE,dbo.Tran_Attendance.Punch1,dbo.Tran_Attendance.Punch2,dbo.Tran_Attendance.allpunchs from dbo.Mst_Employee\n"
                + "inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId order by DateOFFICE";

        String datefrom = datetextfield1.getText().toString();
        String datetodate = datetextfield2.getText().toString();
        System.out.println(datefrom);
        System.out.println(datetodate);

        String sqlquerybydate = "select  dbo.Mst_Employee.empname as " + "'Member Name'" + ",dbo.Tran_Attendance.empid as" + "'Member ID'" + ",dbo.Tran_Attendance.DateOFFICE as " + "'Date'" + ",dbo.Tran_Attendance.Punch1 as " + "'IN-Punch'" + ",dbo.Tran_Attendance.Punch2 as " + "'OUT-Punch'" + ",dbo.Tran_Attendance.allpunchs as " + "'All Punch'" + "from dbo.Mst_Employee"
                + " inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId  WHERE  DateOFFICE between '" + datefrom + "' and '" + datetodate + "'";

        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
        try {
            con = DriverManager.getConnection(url, username, password);
            pst = con.prepareStatement(sqlquerybydate);
            rs = pst.executeQuery();
            System.out.println(startdate);
            System.out.println(enddate);
            /* while (rs.next()) {                
                System.out.println("Emp Name"+rs.getString("empname"));
                System.out.println("Emp ID"+rs.getInt("empid"));
            }*/
            jTable1.setUI(new FlatTableUI());
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            Logger.getLogger(attendanceAdvancedRecord.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            pst.close();
            rs.close();
            con.close();
        }
        jLabel4.setText("Records Shown According To Date Range");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        srchbutton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        mno = new javax.swing.JTextField();
        m_and_d_s = new javax.swing.JButton();
        datetextfield1 = new javax.swing.JTextField();
        datetextfield2 = new javax.swing.JTextField();
        search_Button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        jButton2.setText("Search");

        jButton3.setText("Search By Date");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Search By Date");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(32, 161, 93));
        jPanel1.setBorder(new com.formdev.flatlaf.ui.FlatRoundBorder());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Start Date");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("End Date");

        srchbutton.setBackground(java.awt.Color.white);
        srchbutton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        srchbutton.setText("Search By Date");
        srchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchbuttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Search By Membership No");

        m_and_d_s.setBackground(java.awt.Color.white);
        m_and_d_s.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        m_and_d_s.setText("Search By Date and M No.");
        m_and_d_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_and_d_sActionPerformed(evt);
            }
        });

        search_Button.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\search.png")); // NOI18N
        search_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datetextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datetextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(mno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_and_d_s, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(search_Button)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(m_and_d_s, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(datetextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(datetextfield2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(srchbutton)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE))))
        );

        jTable1.setBorder(new com.formdev.flatlaf.ui.FlatRoundBorder());
        jTable1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member Name", "Member ID", "Date", "IN-Punch", "OUT-Punch", "All Punch"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(java.awt.Color.white);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel4.setText("Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void srchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchbuttonActionPerformed
        try {
            getattendancebydate();
        } catch (SQLException ex) {
            Logger.getLogger(attendanceAdvancedRecord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(attendanceAdvancedRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_srchbuttonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void m_and_d_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_and_d_sActionPerformed
        try {
            // TODO add your handling code here:
            getdatabymID_Date();
        } catch (SQLException ex) {
            Logger.getLogger(attendanceAdvancedRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_m_and_d_sActionPerformed

    private void search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_ButtonActionPerformed
        if (mno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Search Error: Please Enter Member ID to Search");
        }else{
            try {
                getdatabymemberid();
            } catch (SQLException ex) {
                Logger.getLogger(attendanceAdvancedRecord.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(new JFrame(), "SQL Error");
            }
        }

    }//GEN-LAST:event_search_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField datetextfield1;
    private javax.swing.JTextField datetextfield2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton m_and_d_s;
    private javax.swing.JTextField mno;
    private javax.swing.JButton search_Button;
    private javax.swing.JButton srchbutton;
    // End of variables declaration//GEN-END:variables
}
