package com.gym.general.attendance.week;


import com.gym.general.dialouge.Message;
import com.gym.general.main.Main;
import com.gym.general.model.ModelCard;
import com.gym.general.model.ModelMember;
import com.gym.general.swing.icon.GoogleMaterialDesignIcons;
import com.gym.general.swing.icon.IconFontSwing;
import com.gym.general.table.EventAction;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.Icon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class attendanceWeekRecord extends javax.swing.JPanel {

     double daily_attendance_count;
    double total_members_count;
    double percentage;
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    int count;
   
    
    public attendanceWeekRecord() throws SQLException {
        initComponents();
        table1.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
        jPanel1.setVisible(false);
        getweekRecord();
    }

    private void initData() throws SQLException {
        initCardData();
         //   initNoticeBoard();
        initTableData();
    }
   
        public void getweekRecord() throws SQLException{
          
        //table1.addRow(new ModelMember(new ImageIcon(getClass().getResource("/com/gym/general/icon/profile.jpg")), "Jonh", "Male", "Java", 300).toRowTable(eventAction));
       //Get_Data();
         System.out.println("Get week record method");
       String sql="select cardNo , punchdatetime from dbo.Tran_MachineRawPunch";
        System.out.println("Get Daily Attendance Method ");
        /*String sql_query_join="select dbo.mst_employee.EmpName,dbo.mst_employee.Empcode, dbo.tran_machinerawpunch.cardno,\n" +
"dbo.tran_machinerawpunch.punchdatetime from dbo.mst_employee \n" +
"INNER JOIN dbo.tran_machinerawpunch on dbo.mst_employee.cardno=dbo.tran_machinerawpunch.cardno order by punchdatetime";*/
       
        String sql_query_join="select dbo.Mst_Employee.empname ,dbo.Tran_Attendance.empid,dbo.Tran_Attendance.DateOFFICE,dbo.Tran_Attendance.Punch1,dbo.Tran_Attendance.Punch2,dbo.Tran_Attendance.allpunchs from dbo.Mst_Employee\n" +
"inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId order by DateOFFICE";
        
        String sqlqueryweek="select dbo.Mst_Employee.empname ,dbo.Tran_Attendance.empid,dbo.Tran_Attendance.DateOFFICE,dbo.Tran_Attendance.Punch1,dbo.Tran_Attendance.Punch2,dbo.Tran_Attendance.allpunchs from dbo.Mst_Employee\n" +
"inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId WHERE  DateOFFICE BETWEEN GETDATE()-7 AND GETDATE()";
        
        String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username="sa";
        String password="Dhaval@7869";
        try {
            con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(sqlqueryweek);
            rs=pst.executeQuery();
            
           /* while (rs.next()) {                
                System.out.println("Emp Name"+rs.getString("empname"));
                System.out.println("Emp ID"+rs.getInt("empid"));
            }*/
            table1.setModel(DbUtils.resultSetToTableModel(rs));
             
            
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
    
    
      public void Get_Daily_Attendance() throws SQLException{
        String sql="select cardNo , punchdatetime from dbo.Tran_MachineRawPunch";
       
        /*String sql_query_join="select dbo.mst_employee.EmpName,dbo.mst_employee.Empcode, dbo.tran_machinerawpunch.cardno,\n" +
"dbo.tran_machinerawpunch.punchdatetime from dbo.mst_employee \n" +
"INNER JOIN dbo.tran_machinerawpunch on dbo.mst_employee.cardno=dbo.tran_machinerawpunch.cardno order by punchdatetime";*/
       
        String sql_query_join="select dbo.Mst_Employee.empname ,dbo.Tran_Attendance.empid,dbo.Tran_Attendance.DateOFFICE,dbo.Tran_Attendance.Punch1,dbo.Tran_Attendance.Punch2,dbo.Tran_Attendance.allpunchs from dbo.Mst_Employee\n" +
"inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId order by DateOFFICE";
        
        String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username="sa";
        String password="Dhaval@7869";
        try {
            con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(sql_query_join);
            rs=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(attendanceWeekRecord.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        finally{
            pst.close();
            rs.close();
            con.close();
        }
    }
    
  /*  public void Get_Daily_Attendance(){
        String sql="Select * From RawPunchDetail";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          //  rs.next();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
 		    rs.close();
 		    con.close();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
       finally{
    	   try {
    		   pst.close();
    		   rs.close();
    		   con.close();
    	   }
        	catch(Exception e){
        		
        	}
        }
    }*/
    
    
    public void get_daily_attendance_count(){
        String sql="select count(*) from dbo.tran_machinerawpunch where punchdatetime=getdate()";
        String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username="sa";
        String password="Dhaval@7869";
        
        try{
        	con=DriverManager.getConnection(url , username, password);
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          //  rs.next()
            while (rs.next()) {                
                daily_attendance_count=rs.getInt(1);
            }
            System.out.println(daily_attendance_count);
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
 		    rs.close();
 		    con.close();
                   
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
       finally{
    	   try {
    		   pst.close();
    		   rs.close();
    		   con.close();
    	   }
        	catch(Exception e){
        		e.printStackTrace();
        	}
        }
       
    }
    
    public void get_total_members_count(){
         String sql="select count(*) from dbo.mst_employee";
      String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username="sa";
        String password="Dhaval@7869";
        
         try{
        	con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          //  rs.next()
            while (rs.next()) {                
                total_members_count=rs.getInt(1);
            }
            System.out.println(total_members_count);
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            pst.close();
 		    rs.close();
 		    con.close();
                   
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
       finally{
    	   try {
    		   pst.close();
    		   rs.close();
    		   con.close();
    	   }
        	catch(Exception e){
        		
        	}
        }
       
    }
    
     public void get_attendance_percentage(double total_members,double daily_attendance){
        percentage =(daily_attendance/total_members)*100;
        int perc=(int) percentage;
        System.out.println(perc);
    }
     
     
    
    /*
    method to show all members data
    public void Get_Data(){
        	String sql="Select id as'ID',membership_no as 'Membership No',full_name as 'Full Name',gender as 'Gender',reg_date as 'Registered Date',total_fee as 'Total Fee',contact_no as 'Contact No',area as 'Area',address as 'Address',email as 'Email' from members";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          //  rs.next();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
 		    rs.close();
 		    con.close();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
       finally{
    	   try {
    		   pst.close();
    		   rs.close();
    		   con.close();
    	   }
        	catch(Exception e){
        		
        	}
        }
    }*/


    private void initTableData() throws SQLException {
        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelMember student) {
                if (showMessage("Delete Student : " + student.getName())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelMember student) {
                if (showMessage("Update Student : " + student.getName())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
       
    }

    private void initCardData() {
             get_total_members_count();
       get_daily_attendance_count();
      
       get_attendance_percentage(total_members_count, daily_attendance_count);
         
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card1.setData(new ModelCard("Total Members", total_members_count, 20, icon1));
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card2.setData(new ModelCard("Daily Attendance", daily_attendance_count, (int)percentage, icon2));
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_BASKET, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card3.setData(new ModelCard("Active Members", 800, 80, icon3));
        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card4.setData(new ModelCard("Other Income", 550, 95, icon4));

    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new com.gym.general.component.Card();
        jLabel1 = new javax.swing.JLabel();
        card2 = new com.gym.general.component.Card();
        card3 = new com.gym.general.component.Card();
        card4 = new com.gym.general.component.Card();
        jPanel1 = new javax.swing.JPanel();
        noticeBoard = new com.gym.general.swing.noticeboard.NoticeBoard();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.gym.general.table.Table();

        card1.setColorGradient(new java.awt.Color(211, 28, 215));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Home");

        card2.setBackground(new java.awt.Color(10, 30, 214));
        card2.setColorGradient(new java.awt.Color(72, 111, 252));

        card3.setBackground(new java.awt.Color(194, 85, 1));
        card3.setColorGradient(new java.awt.Color(255, 212, 99));

        card4.setBackground(new java.awt.Color(60, 195, 0));
        card4.setColorGradient(new java.awt.Color(208, 255, 90));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Notice Board");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Simple Miglayout API Doc");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noticeBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 257, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(noticeBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Weekly Attendance Record");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "Course", "Fees", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.gym.general.component.Card card1;
    private com.gym.general.component.Card card2;
    private com.gym.general.component.Card card3;
    private com.gym.general.component.Card card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.gym.general.swing.noticeboard.NoticeBoard noticeBoard;
    private com.gym.general.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
