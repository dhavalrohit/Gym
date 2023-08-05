/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.database;

import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DELL
 */
public class Test extends JFrame{
    private Cursor cur=new Cursor(Cursor.HAND_CURSOR);

	private JPanel contentPane;
        Connection conn;
        Statement stmt,stmtdel;
        ResultSet rs;
        String url;     
        private JDateChooser dailydate,dailydate_S,dailydate_E;
        Connection con=null;
	 
	 PreparedStatement pst=null;
        
        int nrows,reply,response,stmtval,flag;

        Border border;
        private JTable Member_Table;
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
        ViewRecrdclasses vrd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*Look and Feel*/
	    try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
        
        public Test() {
                
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Main_Window.class.getResource("/images/trans1.png")));
		setTitle("Shape UP Management System");
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
                
                
		setBounds(0, 0, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                
                JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 200, 1000, 522);
		contentPane.add(scrollPane);
		
                Member_Table = new JTable();
		Member_Table.setShowGrid(false);
		Member_Table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(Member_Table);
		Member_Table.setModel(new DefaultTableModel(
			new Object[][] {
				/*{new Integer(1), new Integer(310), "Teja J Patel", "Male", null, new Integer(60), new Double(9.809522227E9), "India", "Vapi", "Txxx@gmail.com"},*/
				/*{new Integer(2), new Integer(21564), "Bhupal Singh", "Male", null, new Integer(454), new Double(8956424.0), "Nepal", "Karnali", "dgd@gmail.com"},
				{new Integer(3), new Integer(24445), "Rajan Dangi", "Female", null, new Integer(454), new Double(8956424.0), "Nepal", "Salyan", "dgd@gmail.com"},
				{new Integer(4), new Integer(8965), "Hari Bahadur", "Male", null, new Integer(60), new Double(9.847562145E9), "China", "Pune", "hari@gmail.com"},
				{new Integer(5), new Integer(454), "Polo", "Male", null, new Integer(45), new Double(9.8561204E7), "Nepal", "Pyuthan", "polo@gmail.com"},
				{new Integer(10), new Integer(800), "Giriraj Basel", "Male", null, new Integer(70), new Double(9.809865145E9), "Nepal", "Butwal", "giriraj701@gmail.com"},
				{new Integer(7), new Integer(101), "santosh", "Male", null, new Integer(56), new Double(9.809522227E9), "Nepal", "Pyuthan", "dip@gmail.com"},*/
			},
			new String[] {
				"ID", "EnrollCode", "CardNo", "Datetrn", "InTime", "OutTime", "McNo"
			}
		));
                
                
                
                
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1354, 33);
		menuBar.setMargin(new Insets(0, 0, 0, 0));
		menuBar.setBackground(Color.CYAN);
		menuBar.setForeground(Color.ORANGE);
		contentPane.add(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.setFont(new Font("Dialog", Font.BOLD, 12));
		mnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
			}
		});
		//mnHome.setIcon(new ImageIcon(Main_Window.class.getResource("/images/home.png")));
		menuBar.add(mnHome);
                
                JButton btnSearch = new JButton(" Date Search");
                btnSearch.setToolTipText("search by Date");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail where EmpCode='"+txtSearch.getText()+"' GROUP BY ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo";
                                //String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail GROUP BY ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo HAVING Datetrn='"+txtdate.getText()+"' And EmpCode='"+txtSearch.getText()+"'";
                                     //String sql="Select EmpCode,Datetrn,McNo From RawPunchDetail where Datetrn='"+txtdate.getText()+"'";                        
                                 //String sql= "SELECT * FROM RawPunchDetail WHERE EmpCode='"+txtSearch.getText()+"' OR Datetrn='"+txtdate.getText()+"' in (SELECT ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo FROM RawPunchDetail GROUP BY ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo HAVING COUNT(*) > 1)";
                                 //String sql= "SELECT * FROM RawPunchDetail WHERE EmpCode='"+txtSearch.getText()+"' and Datetrn>='"+txtdate.getText()+"'";
  String sql="Select ID, EmpCode, CardNo, Datetrn, InTime, OutTime, McNo From RawPunchDetail WHERE (Datetrn between '"+txtdate.getText()+"' and  '"+txtenddate.getText()+"')";


       
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
                           //int rowCount = rs.getInt(1);
                            //System.out.println("\nrow count:"+rowCount);

                    //Member_Table.setModel(DbUtils.resultSetToTableModel(rs));
               // }
		            
                            
                            
		           		        // }
		          //else {
		        	  //JOptionPane.showMessageDialog(null, "There is no any data having Membership_No:"+txtSearch.getText()+"");
		          // }
                           int a = 0;
                      do 
                      {   
                        //System.out.println("hello# "+a);
                       
                       Member_Table.setModel(DbUtils.resultSetToTableModel(rs));
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
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(600, 100, 130, 30);
		contentPane.add(btnSearch);
		
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
                       
                       Member_Table.setModel(DbUtils.resultSetToTableModel(rs));
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
		contentPane.add(btnSearchM);
                /**------------------------**/
                
                txtdate = new JTextField();
		txtdate.setBounds(350, 60, 120, 30);
		contentPane.add(txtdate);
		txtdate.setColumns(20);
                
                JLabel lblStartdate = new JLabel("Start Date");
		//lblStartdate.setForeground(Color.ORANGE);
		//lblStartdate.setBackground(Color.WHITE);
		lblStartdate.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblStartdate.setBounds(20, 60, 127, 14);
		contentPane.add(lblStartdate);
                
                  
                 dailydate_S = new JDateChooser();
                
		
		dailydate_S.setDateFormatString("yyyy-MM-dd");
               
		dailydate_S.getCalendarButton().setForeground(Color.BLACK);
		dailydate_S.setToolTipText("");
		dailydate_S.getCalendarButton().setToolTipText("");
		dailydate_S.getCalendarButton().setBackground(Color.WHITE);
		dailydate_S.setBounds(135, 60, 181, 20);
		contentPane.add(dailydate_S);
               
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
		contentPane.add(btn_sdate);
                
                /***End date ***/
                 txtenddate = new JTextField();
		txtenddate.setBounds(350, 100, 120, 30);
		contentPane.add(txtenddate);
		txtenddate.setColumns(20);
                
                 JLabel lblEnddate = new JLabel("End Date");
		//lblStartdate.setForeground(Color.ORANGE);
		//lblStartdate.setBackground(Color.WHITE);
		lblEnddate.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblEnddate.setBounds(20, 100, 127, 14);
		contentPane.add(lblEnddate);
                
                  
                 dailydate_E = new JDateChooser();
                
		
		dailydate_E.setDateFormatString("yyyy-MM-dd");
               
		dailydate_E.getCalendarButton().setForeground(Color.BLACK);
		dailydate_E.setToolTipText("");
		dailydate_E.getCalendarButton().setToolTipText("");
		dailydate_E.getCalendarButton().setBackground(Color.WHITE);
		dailydate_E.setBounds(135, 100, 181, 20);
		contentPane.add(dailydate_E);
               
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
		contentPane.add(btn_edate);
                   
		
		JLabel lblMembershipNo = new JLabel("Membership No:");
		lblMembershipNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMembershipNo.setBounds(650, 60, 110, 14);
		contentPane.add(lblMembershipNo);
                
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
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
                
                
                btn_view_all=new JButton("View Records");
                btn_view_all.setMnemonic(KeyEvent.VK_V);
                btn_view_all.setToolTipText("View Records");
                btn_view_all.setMnemonic('v');
		//btn_view.setIcon(new ImageIcon(Add_Member.class.getResource("/images/save.png")));
                btn_view_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
                            if(ae.getSource()==btn_view_all)
                {
                        vrd=new ViewRecrdclasses("View Records");
                        //vrd.View_Records_seven();
                       vrd.View_ClassesRecords();
                        vrd.setSize(800,600);
                        vrd.setVisible(true);
                        vrd.setLocation(50,50);
                        vrd.setBackground(c5);                        
                }	
                        }
                        });
		btn_view_all.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_view_all.setBounds(25,140,130,30);
		contentPane.add(btn_view_all);
                
                //7 days views data
                btn_view_sev=new JButton("View 7 days Records");
                btn_view_sev.setMnemonic(KeyEvent.VK_V);
                btn_view_sev.setToolTipText("View 7 days Records");
                btn_view_sev.setMnemonic('v');
		//btn_view.setIcon(new ImageIcon(Add_Member.class.getResource("/images/save.png")));
                btn_view_sev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
                            if(ae.getSource()==btn_view_sev)
                {
                        vrd=new ViewRecrdclasses("View 7 days Records");
                        vrd.View_Records_seven();
                      // vrd.View_ClassesRecords();
                        vrd.setSize(800,600);
                        vrd.setVisible(true);
                        vrd.setLocation(50,50);
                        vrd.setBackground(c5);                        
                }	
                        }
                        });
		btn_view_sev.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_view_sev.setBounds(180,140,180,30);
		contentPane.add(btn_view_sev);
                
		
                
                 //month
                 btn_view_mn=new JButton("View month Records");
                btn_view_mn.setMnemonic(KeyEvent.VK_V);
                btn_view_mn.setToolTipText("View month Records");
                btn_view_mn.setMnemonic('v');
		//btn_view.setIcon(new ImageIcon(Add_Member.class.getResource("/images/save.png")));
                btn_view_mn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
                            if(ae.getSource()==btn_view_mn)
                {
                        vrd=new ViewRecrdclasses("View month Records");
                        //vrd.View_Records_seven();
                       vrd.View_Records_month();
                        vrd.setSize(800,600);
                        vrd.setVisible(true);
                        vrd.setLocation(50,50);
                        vrd.setBackground(c5);                        
                }	
                        }
                        });
		btn_view_mn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_view_mn.setBounds(385, 140, 181, 30);
		contentPane.add(btn_view_mn);
		
                
              
		
		// 3 month
                btn_view_tmn=new JButton("View 3 month Records");
                btn_view_tmn.setMnemonic(KeyEvent.VK_V);
                btn_view_tmn.setToolTipText("View 3 month Records");
                btn_view_tmn.setMnemonic('v');
		//btn_view.setIcon(new ImageIcon(Add_Member.class.getResource("/images/save.png")));
                btn_view_tmn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
                            if(ae.getSource()==btn_view_tmn)
                {
                        vrd=new ViewRecrdclasses("View 3 month Records");
                        //vrd.View_Records_seven();
                       vrd.View_Records_ThreeMonth();
                        vrd.setSize(800,600);
                        vrd.setVisible(true);
                        vrd.setLocation(50,50);
                        vrd.setBackground(c5);                        
                }	
                        }
                        });
		btn_view_tmn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_view_tmn.setBounds(590,140,180,30);
		contentPane.add(btn_view_tmn);
		
                
                //
                
                
                
                 btn_exit=new JButton("Exit");                                                
                //btn_exit.setBackground(c5);
                btn_exit.setFont(new Font("Tahoma", Font.BOLD, 14));
                btn_exit.setBounds(800,140,100,30);
                btn_exit.setMnemonic(KeyEvent.VK_X);
                btn_exit.setToolTipText("Exit");
                btn_exit.setMnemonic('x');
                btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
                            if(ae.getSource()==btn_exit)
               {
                        reply=JOptionPane.showConfirmDialog(null,"Do you Quit the Application ?");
                        if(reply==JOptionPane.YES_OPTION)
                        {                                                       
                                //System.exit(0);   
                                dispose();
                        }                                       
                        if(reply==JOptionPane.NO_OPTION)
                        {                                               
                                return;
                        }       
                }
                            
                        }
                        }
                
                );
                contentPane.add(btn_exit);                                                                

                
                        
        }
        
}
