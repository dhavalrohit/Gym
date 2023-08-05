/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.attendance;

import com.gym.database.Connect;
import com.gym.database.Show_All;
import com.gym.general.model.ModelCard;
import com.gym.general.swing.icon.GoogleMaterialDesignIcons;
import com.gym.general.swing.icon.IconFontSwing;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DELL
 */
public class attendanceAdvancedRecord extends javax.swing.JPanel{
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
    private com.gym.general.swing.table.Table table4;
    private Show_All showall;
    
    
      double daily_attendance_count;
    double total_members_count;
    double percentage;
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    int count;
    attendanceMonthMenu menu;
    
     private Cursor cur=new Cursor(Cursor.HAND_CURSOR);
     private JDateChooser dailydate,dailydate_S,dailydate_E;
     int nrows,reply,response,stmtval,flag;

        Border border;
         private JTextField txtSearch;
         private JTextField txtdate,txtenddate;
          Color c1=new Color(255,146,34);
        Color c2=new Color(251,254,120);//yellow
        Color c3=new Color(140,140,255);//Sky blue
        Color c4=new Color(120,120,230);
        Color c5=new Color(190,190,240);
        Color c6=new Color(147,255,174);//Light Green
        
        Font f1=new Font("Times New Roman",Font.BOLD,40);
        Font f2=new Font("Times New Roman",Font.BOLD,14);
        Font f3=new Font("Times New Roman",Font.BOLD,18);
        Font f4=new Font("Times New Roman",Font.BOLD,12);
        Font f5=new Font("Times New Roman",Font.BOLD,11);
        Font f6=new Font("COMIC SANS MS",Font.BOLD,22);
        Font fp=new Font("Times New Roman",Font.BOLD,45);
        Font fp1=new Font("COMIC SANS SERIF",Font.BOLD,30);
        
        JPanel pa,p1,p2;
        JButton btn_view_all,btn_view_sev,btn_view_mn,btn_view_tmn,btn_exit,btn_sdate,btn_edate;
        CardLayout cardView;
        String strview,strsel,strviewval;
        
         
        
    
      public attendanceAdvancedRecord() throws SQLException {
          System.out.println("Past month Attendance Form/Table Opened");  
        initComponents();
        table4.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
        //initTableData();
        getmonthRecord();
        
        
    }
    
    
    
    
    
     private void initData() throws SQLException {
        //initCardData();
       // initTableData();
      //    initNoticeBoard();
     }
    
     public void getmonthRecord() throws SQLException{
          
        //table1.addRow(new ModelMember(new ImageIcon(getClass().getResource("/com/gym/general/icon/profile.jpg")), "Jonh", "Male", "Java", 300).toRowTable(eventAction));
       //Get_Data();
         System.out.println("Get past month record method");
       String sql="select cardNo , punchdatetime from dbo.Tran_MachineRawPunch";
        System.out.println("Get Daily Attendance Method ");
        /*String sql_query_join="select dbo.mst_employee.EmpName,dbo.mst_employee.Empcode, dbo.tran_machinerawpunch.cardno,\n" +
"dbo.tran_machinerawpunch.punchdatetime from dbo.mst_employee \n" +
"INNER JOIN dbo.tran_machinerawpunch on dbo.mst_employee.cardno=dbo.tran_machinerawpunch.cardno order by punchdatetime";*/
       
        String sql_query_join="select dbo.Mst_Employee.empname ,dbo.Tran_Attendance.empid,dbo.Tran_Attendance.DateOFFICE,dbo.Tran_Attendance.Punch1,dbo.Tran_Attendance.Punch2,dbo.Tran_Attendance.allpunchs from dbo.Mst_Employee\n" +
"inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId order by DateOFFICE";
        
        String sqlquerymonth="select dbo.Mst_Employee.empname ,dbo.Tran_Attendance.empid,dbo.Tran_Attendance.DateOFFICE,dbo.Tran_Attendance.Punch1,dbo.Tran_Attendance.Punch2,dbo.Tran_Attendance.allpunchs from dbo.Mst_Employee\n" +
"inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId  WHERE  DATEPART(m, dbo.Tran_Attendance.DateOFFICE) = DATEPART(m, DATEADD(m, -1, getdate())) AND DATEPART(yy, dbo.Tran_Attendance.DateOFFICE) = DATEPART(yy, DATEADD(m, -1, getdate()))";
        
        String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username="sa";
        String password="Dhaval@7869";
        try {
            con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(sqlquerymonth);
            rs=pst.executeQuery();
            
           /* while (rs.next()) {                
                System.out.println("Emp Name"+rs.getString("empname"));
                System.out.println("Emp ID"+rs.getInt("empid"));
            }*/
            table4.setModel(DbUtils.resultSetToTableModel(rs));
             
            
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
     
       public void get_daily_attendance_count(){
        String sql="select count(*) from rawpunchdetail";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          //  rs.next()
            while (rs.next()) {                
                daily_attendance_count=rs.getInt("count(*)");
            }
            System.out.println(daily_attendance_count);
            table4.setModel(DbUtils.resultSetToTableModel(rs));
            
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
    
    
 
    
    
    
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        
        this.setLayout(null);
        
        JButton btnSearch = new JButton(" Date Search");
                btnSearch.setToolTipText("search by Date");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail where EmpCode='"+txtSearch.getText()+"' GROUP BY ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo";
                                //String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail GROUP BY ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo HAVING Datetrn='"+txtdate.getText()+"' And EmpCode='"+txtSearch.getText()+"'";
                                     //String sql="Select EmpCode,Datetrn,McNo From RawPunchDetail where Datetrn='"+txtdate.getText()+"'";                        
                                 //String sql= "SELECT * FROM RawPunchDetail WHERE EmpCode='"+txtSearch.getText()+"' OR Datetrn='"+txtdate.getText()+"' in (SELECT ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo FROM RawPunchDetail GROUP BY ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo HAVING COUNT(*) > 1)";
                                 //String sql= "SELECT * FROM RawPunchDetail WHERE EmpCode='"+txtSearch.getText()+"' and Datetrn>='"+txtdate.getText()+"'";
  //String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail WHERE (Datetrn between '"+txtdate.getText()+"' and  '"+txtenddate.getText()+"')";

String sqlbydate="select dbo.Mst_Employee.empname ,dbo.Tran_Attendance.empid,dbo.Tran_Attendance.DateOFFICE,dbo.Tran_Attendance.Punch1,dbo.Tran_Attendance.Punch2,dbo.Tran_Attendance.allpunchs from dbo.Mst_Employee\n" +
"inner join dbo.Tran_Attendance on dbo.Mst_Employee.EmpId=dbo.Tran_Attendance.EmpId  where dateoffice between '"+txtdate.getText()+"' and '"+txtenddate.getText()+"'";
       
//String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail where (EmpCode='"+txtSearch.getText()+"' AND Datetrn='"+txtdate.getText()+"') OR Datetrn='"+txtdate.getText()+"'";
                                //SELECT id, datefield, count(*) FROM tablename GROUP BY datefield HAVING count(*) > 1
  
                                //String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail where EmpCode='"+txtSearch.getText()+"'AND  Datetrn=DATE_SUB('"+txtdate.getText()+"', INTERVAL 1 MONTH)";
		       // String sql="Select CardNo, punchdate, punchtime, In_out From Tran_punch where cardNo='"+txtSearch.getText()+"',punchdate='"+dailydate.getDateFormatString()+"'";
		         String url="jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
                        String username="sa";
                         String password="Dhaval@7869";
        
                                
                                try{
		        	con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(sqlbydate);
            rs=pst.executeQuery();
            
                          // ResultSetMetaData rsmd = rs.getMetaData();
                           //rs.next();
		          // if( rs.next()){
                           //int rowCount = rs.getInt(1);
                            //System.out.println("\nrow count:"+rowCount);

                    //Member_Table.setModel(DbUtils.resultSetToTableModel(rs));
               // }
		            
                            
                            
		           		        // }
		          //else {
		        	  //JOptionPane.showMessageDialog(null, "There is no any data having Membership_No:"+txtSearch.getText()+"");
		          // }
                           int a = 0;
                         
                        //System.out.println("hello# "+a);
                       
                       table4.setModel(DbUtils.resultSetToTableModel(rs));
                        
                     
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
		});
		//btnSearch.setIcon(new ImageIcon(Show_All.class.getResource("/images/search member.png")));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(600, 100, 130, 30);
		this.add(btnSearch);
		
        /** SEARCH by Membership no**/
                 JButton btnSearchM = new JButton("M-Search");
                 btnSearchM.setEnabled(false);
                 btnSearchM.setToolTipText("search by Membership no.");
		btnSearchM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail where EmpCode='"+txtSearch.getText()+"' GROUP BY ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo";
                                //String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail GROUP BY ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo HAVING Datetrn='"+txtdate.getText()+"' And EmpCode='"+txtSearch.getText()+"'";
                                     //String sql="Select EmpCode,Datetrn,McNo From RawPunchDetail where Datetrn='"+txtdate.getText()+"'";                        
                                 //String sql= "SELECT * FROM RawPunchDetail WHERE EmpCode='"+txtSearch.getText()+"' OR Datetrn='"+txtdate.getText()+"' in (SELECT ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo FROM RawPunchDetail GROUP BY ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo HAVING COUNT(*) > 1)";
                                 //String sql= "SELECT * FROM RawPunchDetail WHERE EmpCode='"+txtSearch.getText()+"' and Datetrn>='"+txtdate.getText()+"'";
  String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail WHERE  EmpCode='"+txtSearch.getText()+"' and (Datetrn between '"+txtdate.getText()+"' and  '"+txtenddate.getText()+"')";


       
//String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail where (EmpCode='"+txtSearch.getText()+"' AND Datetrn='"+txtdate.getText()+"') OR Datetrn='"+txtdate.getText()+"'";
                                //SELECT id, datefield, count(*) FROM tablename GROUP BY datefield HAVING count(*) > 1
  
                                //String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail where EmpCode='"+txtSearch.getText()+"'AND  Datetrn=DATE_SUB('"+txtdate.getText()+"', INTERVAL 1 MONTH)";
		       // String sql="Select CardNo, punchdate, punchtime, In_out From Tran_punch where cardNo='"+txtSearch.getText()+"',punchdate='"+dailydate.getDateFormatString()+"'";
		         
                                
                                try{
		        	con=Connect.connectaccessDb();
                                
		            pst=con.prepareStatement(sql);
		           rs=pst.executeQuery();
                          // ResultSetMetaData rsmd = rs.getMetaData();
                           //rs.next();
		          // if( rs.next()){
                          // int rowCount = rs.getInt(1);
                           // System.out.println("\nrow count:"+rowCount);

                   // Member_Table.setModel(DbUtils.resultSetToTableModel(rs));
                //}	        // }
		          //else {
		        	  //JOptionPane.showMessageDialog(null, "There is no any data having Membership_No:"+txtSearch.getText()+"");
		          // }
                      int a = 0;
                      do 
                      {   
                        System.out.println("hello# "+a);
                       
                       table4.setModel(DbUtils.resultSetToTableModel(rs));
                        a++;
                      } while (rs.next());
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
		});
		//btnSearch.setIcon(new ImageIcon(Show_All.class.getResource("/images/search member.png")));
		btnSearchM.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearchM.setBounds(870, 60, 100, 30);
		this.add(btnSearchM);
                /**------------------------**/
               
                
         txtdate = new JTextField();
		txtdate.setBounds(350, 60, 120, 30);
		this.add(txtdate);
		txtdate.setColumns(20);
                
                JLabel lblStartdate = new JLabel("Start Date");
		//lblStartdate.setForeground(Color.ORANGE);
		//lblStartdate.setBackground(Color.WHITE);
		lblStartdate.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblStartdate.setBounds(20, 60, 127, 14);
		this.add(lblStartdate);
                
                  
                 dailydate_S = new JDateChooser();
                
		
		dailydate_S.setDateFormatString("yyyy-MM-dd");
               
		dailydate_S.getCalendarButton().setForeground(Color.BLACK);
		dailydate_S.setToolTipText("");
		dailydate_S.getCalendarButton().setToolTipText("");
		dailydate_S.getCalendarButton().setBackground(Color.WHITE);
		dailydate_S.setBounds(135, 60, 181, 20);
		this.add(dailydate_S);
               
                 btn_sdate=new JButton("Select Date");
                btn_sdate.setMnemonic(KeyEvent.VK_V);
                btn_sdate.setToolTipText(" click to Select Date");
                btn_sdate.setMnemonic('v');
		//btn_view.setIcon(new ImageIcon(Add_Member.class.getResource("/images/save.png")));
                btn_sdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
                           String selectdate =((JTextField)dailydate_S.getDateEditor().getUiComponent()).getText();
                   
                   txtdate.setText(selectdate +" 00:00:00.000000");
                        }
                        });
		btn_sdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_sdate.setBounds(450,60,130,30);
		        this.add(btn_sdate);
                
                /***End date ***/
                 txtenddate = new JTextField();
		txtenddate.setBounds(350, 100, 120, 30);
		this.add(txtenddate);
		txtenddate.setColumns(20);
                
                 JLabel lblEnddate = new JLabel("End Date");
		//lblStartdate.setForeground(Color.ORANGE);
		//lblStartdate.setBackground(Color.WHITE);
		lblEnddate.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblEnddate.setBounds(20, 100, 127, 14);
		this.add(lblEnddate);
                
                  
                 dailydate_E = new JDateChooser();
                
		
		dailydate_E.setDateFormatString("yyyy-MM-dd");
               
		dailydate_E.getCalendarButton().setForeground(Color.BLACK);
		dailydate_E.setToolTipText("");
		dailydate_E.getCalendarButton().setToolTipText("");
		dailydate_E.getCalendarButton().setBackground(Color.WHITE);
		dailydate_E.setBounds(135, 100, 181, 20);
		this.add(dailydate_E);
               
                 btn_edate=new JButton("Select Date");
                btn_edate.setMnemonic(KeyEvent.VK_V);
                btn_edate.setToolTipText("Click to Select Date");
                btn_edate.setMnemonic('v');
		//btn_view.setIcon(new ImageIcon(Add_Member.class.getResource("/images/save.png")));
                btn_edate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
                           String selectdate =((JTextField)dailydate_E.getDateEditor().getUiComponent()).getText();
                   
                   txtenddate.setText(selectdate +" 00:00:00.000000");
                        }
                        });
		btn_edate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_edate.setBounds(450,100,130,30);
		this.add(btn_edate);
                   
		
		JLabel lblMembershipNo = new JLabel("Membership No:");
		lblMembershipNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMembershipNo.setBounds(650, 60, 110, 14);
		this.add(lblMembershipNo);
                
                txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent arg0) {
					//DefaultTableModel table = (DefaultTableModel)Member_Table.getModel();
			        String search = txtSearch.getText();
			        //TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
			        //Member_Table.setRowSorter(tr);
                                //btnSearchM.setEnabled(true);
			        //tr.setRowFilter(RowFilter.regexFilter(search));
                                //if (search.getText().equals("")) 
                                    if(search==null|| search.equals(""))
                                {
                                         
                                         btnSearchM.setEnabled(false);
                                } else {
                                    btnSearchM.setEnabled(true);
                                }
					
			}
		});
		txtSearch.setBounds(760, 60, 100, 30);
		this.add(txtSearch);
		txtSearch.setColumns(10);
                
                       
        
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        noticeBoard = new com.gym.general.swing.noticeboard.NoticeBoard();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table4 = new com.gym.general.swing.table.Table();


        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Home");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));


        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Simple Miglayout API Doc");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setOpaque(true);
        
//-======--Noticboard Implementation=======================================================================================================
       /* javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
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
        );*/
        /*jPanel1Layout.setVerticalGroup(
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
        );*/
   //==================NoticeBoard Implementation=================================================================================================     

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        this.add(table4);
        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Past Month Attendance Data");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        table4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table4);
        if (table4.getColumnModel().getColumnCount() > 0) {
            table4.getColumnModel().getColumn(0).setPreferredWidth(150);
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

        
    }
}
