package com.gym.general.form;


import com.formdev.flatlaf.FlatIntelliJLaf;
import com.gym.general.dialouge.Message;
import com.gym.general.main.Main;
import com.gym.general.model.ModelCard;
import com.gym.general.model.ModelMember;
import com.gym.general.swing.icon.GoogleMaterialDesignIcons;
import com.gym.general.swing.icon.IconFontSwing;
import com.gym.general.swing.noticeboard.ModelNoticeBoard;
import com.gym.general.table.EventAction;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import net.proteanit.sql.DbUtils;

public class Form_Home extends javax.swing.JPanel {

     double daily_attendance_count;
    double total_members_count;
    double percentage;
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    int count;
    Statement st;
    
    
    
   
    
    public Form_Home() throws SQLException {
       //FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
        //FlatIntelliJLaf.setup();
        
        initComponents();
        table1.fixTable(jScrollPane1);
        table3.fix_secondTable(jScrollPane1);
        
        
        setOpaque(false);
        initData();
        
        
        Timer timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
               updatedatetimeLabel();
            }
        });
        timer.start();
       
    }

    private void initData() throws SQLException {
        initCardData();
         //   initNoticeBoard();
        initTableData();
    }
    
     public void show_workouts_by_day(){
        
         String daychosen="monday";
         
         LocalDate today=LocalDate.now();
         DayOfWeek day=today.getDayOfWeek();
         
         String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
        String query="select day as Day,level_type as Level,Body_Part as Body_Part ,exercise as Exercise,equipment as Equipment,sets as Sets,reps as Reps,rest as Rest from dbo.workout where day='"+daychosen+"'";
        
        
        try {
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            rs=st.executeQuery(query);
            
            table3.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(),"DATA FETCH ERROR","Inquiry History",JOptionPane.ERROR_MESSAGE);
        
        }
        
    }
    
    
    
      public void Get_Daily_Attendance() throws SQLException{
        String sql="select cardNo , punchdatetime from dbo.Tran_MachineRawPunch";
       
        /*String sql_query_join="select dbo.mst_employee.EmpName,dbo.mst_employee.Empcode, dbo.tran_machinerawpunch.cardno,\n" +
"dbo.tran_machinerawpunch.punchdatetime from dbo.mst_employee \n" +
"INNER JOIN dbo.tran_machinerawpunch on dbo.mst_employee.cardno=dbo.tran_machinerawpunch.cardno order by punchdatetime";*/
       /* String sql_query_join="select dbo.Mst_Employee.empname ,dbo.Tran_Attendance.empid,dbo.Tran_Attendance.DateOFFICE as Date,convert(char(5), dbo.Tran_Attendance.Punch1 , 108) [punch1] ,convert(char(5), dbo.Tran_Attendance.Punch2 , 108) [punch2],dbo.Tran_Attendance.allpunchs from dbo.Mst_Employee \n" +
"inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId where convert(varchar(10), DateOFFICE, 102) \n" +
"    = convert(varchar(10), getdate(), 102) order by DateOFFICE";*/
        String sql_query_join="select dbo.Mst_Employee.empname ,convert(date,dbo.Tran_Attendance.DateOFFICE,104)[Date],convert(char(5), dbo.Tran_Attendance.Punch1 , 108) [punch1] ,convert(char(5), dbo.Tran_Attendance.Punch2 , 108) [punch2],dbo.Tran_Attendance.allpunchs from dbo.Mst_Employee \n" +
"inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId where convert(varchar(10), DateOFFICE, 102) \n" +
"    = convert(varchar(10), getdate(), 102) order by DateOFFICE";
        
        String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username="sa";
        String password="Dhaval@7869";
        try {
            con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(sql_query_join);
            rs=pst.executeQuery();
           table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Form_Home.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    public void updatedatetimeLabel() {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        formatDate.setTimeZone(TimeZone.getTimeZone("IST")); 
        
        Date currentDate = new Date();
        String formattedDate = formatDate.format(currentDate);
        date_time_Label.setText(formattedDate);
    
    }    
      
  public void get_daily_attendance_count(){
        String sql="select count(*) from dbo.Tran_Attendance where convert(varchar(10), DateOFFICE, 102) \n" +
"    = convert(varchar(10), getdate(), 102)";
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
            System.out.println("Daily Attendance count"+daily_attendance_count);
            //table1.setModel(DbUtils.resultSetToTableModel(rs));
            
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
          //  table1.setModel(DbUtils.resultSetToTableModel(rs));
            
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
            //get_total_members_count();
       //get_daily_attendance_count();
       Get_Daily_Attendance();
       show_workouts_by_day();
      // get_attendance_percentage(total_members_count, daily_attendance_count);
       
    }

    private void initCardData() {
       get_total_members_count();
       get_daily_attendance_count();
        
         try {
             Get_Daily_Attendance();
         } catch (SQLException ex) {
             Logger.getLogger(Form_Home.class.getName()).log(Level.SEVERE, null, ex);
         }
        
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
        date_time_Label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.gym.general.table.Table();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new com.gym.general.table.Table();
        jLabel7 = new javax.swing.JLabel();

        card1.setColorGradient(new java.awt.Color(211, 28, 215));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Dashboard / Home");

        card2.setBackground(new java.awt.Color(10, 30, 214));
        card2.setColorGradient(new java.awt.Color(72, 111, 252));

        card3.setBackground(new java.awt.Color(194, 85, 1));
        card3.setColorGradient(new java.awt.Color(255, 212, 99));

        card4.setBackground(new java.awt.Color(60, 195, 0));
        card4.setColorGradient(new java.awt.Color(208, 255, 90));

        date_time_Label.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        date_time_Label.setForeground(new java.awt.Color(51, 51, 51));
        date_time_Label.setText("Dashboard / Home");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(476, 452));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Today's Workout Plan");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "empname", "empid", "Date Office", "Punch 1", "Punch2", "All Punch"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(table3);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(76, 76, 76));
        jLabel7.setText("Daily Attendance Record");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
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
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(date_time_Label))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(date_time_Label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.gym.general.component.Card card1;
    private com.gym.general.component.Card card2;
    private com.gym.general.component.Card card3;
    private com.gym.general.component.Card card4;
    private javax.swing.JLabel date_time_Label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.gym.general.table.Table table1;
    private com.gym.general.table.Table table3;
    // End of variables declaration//GEN-END:variables
}
