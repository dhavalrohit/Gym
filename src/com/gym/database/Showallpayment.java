/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.database;

import com.gym.controller.Add_Fees;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DELL
 */
public class Showallpayment extends JFrame{
    Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	 
	public JButton btnUpdate1,btnNew1,btnDelete1;
	private JPanel contentPanePay;
	private JTable Payment_Table;
	private JTextField txtSearch1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Showallpayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Showallpayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Showallpayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Showallpayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Showallpayment frame = new Showallpayment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void Get_Data_fee()
	{
		String sql="Select id payment as'ID',membership_no_fee as 'Membership No',full_name as 'Full Name',reg_date as 'Registered Date',total_fee as 'Total Fee',paid_fee as 'Paid Fee',contact as 'Contact No',start_date as 'Start Date',end_date as 'End Date',nowpaid as 'Now Paid', discount as 'Discount',duration as 'Duration' from payment";
        try{
        	con=Connect.connectDb();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
          //  rs.next();
            Payment_Table.setModel(DbUtils.resultSetToTableModel(rs));
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
	public Showallpayment() {
		setTitle("Fitness Hub || Show All Members");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(5, 60, 1350, 600);
		setResizable(false);
		contentPanePay = new JPanel();
		contentPanePay.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanePay);
		contentPanePay.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 49, 1344, 522);
		contentPanePay.add(scrollPane);
		
	
		
		Payment_Table = new JTable();
		Payment_Table.setShowGrid(false);
		Payment_Table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setViewportView(Payment_Table);
		Payment_Table.setModel(new DefaultTableModel(
			new Object[][] {
                                
				{new Integer(1), new Integer(310), "caspher", "2019-08-21", "7000", new Integer(60), new Double(9.809522227E9), "2019-08-22", "2019-08-30", "100","10","3"},
				/*{new Integer(2), new Integer(21564), "Bhupal Singh", "Male", null, new Integer(454), new Double(8956424.0), "Nepal", "Karnali", "dgd@gmail.com"},
				{new Integer(3), new Integer(24445), "Rajan Dangi", "Female", null, new Integer(454), new Double(8956424.0), "Nepal", "Salyan", "dgd@gmail.com"},
				{new Integer(4), new Integer(8965), "Hari Bahadur", "Male", null, new Integer(60), new Double(9.847562145E9), "China", "Pune", "hari@gmail.com"},
				{new Integer(5), new Integer(454), "Polo", "Male", null, new Integer(45), new Double(9.8561204E7), "Nepal", "Pyuthan", "polo@gmail.com"},
				{new Integer(10), new Integer(800), "Giriraj Basel", "Male", null, new Integer(70), new Double(9.809865145E9), "Nepal", "Butwal", "giriraj701@gmail.com"},
				{new Integer(7), new Integer(101), "santosh", "Male", null, new Integer(56), new Double(9.809522227E9), "Nepal", "Pyuthan", "dip@gmail.com"},*/
			},
			new String[] {
				"ID", "Membership No", "Full Name", "Registered Date", "Total fee","Paid Fee", "Contact No", "Start Date", "End Date", "Now Paid","Discount","Duration"
			}
		));
		
		btnNew1 = new JButton("New");
		btnNew1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_Fees adf=new Add_Fees();
				adf.show();
				
			}
		});
		btnNew1.setIcon(new ImageIcon(Show_All.class.getResource("/images/add product.png")));
		btnNew1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNew1.setBounds(10, 11, 95, 23);
		contentPanePay.add(btnNew1);
		
		/*JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="Select * from payment where membership_no_fee='"+txtSearch1.getText()+"'";
		        try{
		        	con=Connect.connectDb();
		            pst=con.prepareStatement(sql);
		            rs=pst.executeQuery();
		           if( rs.next())
		           {
		            Payment_Table.setModel(DbUtils.resultSetToTableModel(rs));
		           		           }
		           else {
		        	   JOptionPane.showMessageDialog(null, "There is no any data having Membership_No:'"+txtSearch1.getText()+"'");
		           }
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
		btnSearch.setIcon(new ImageIcon(Show_All.class.getResource("/images/search member.png")));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(1003, 11, 89, 23);
		contentPanePay.add(btnSearch);*/
		
		txtSearch1 = new JTextField();
		txtSearch1.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					DefaultTableModel table = (DefaultTableModel)Payment_Table.getModel();
			        String search = txtSearch1.getText();
			        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
			        Payment_Table.setRowSorter(tr);
			        tr.setRowFilter(RowFilter.regexFilter(search));
					
			}
		});
		txtSearch1.setBounds(883, 12, 110, 20);
		contentPanePay.add(txtSearch1);
		txtSearch1.setColumns(10);
		
		JLabel lblMembershipNo = new JLabel("Membership No:");
		lblMembershipNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMembershipNo.setBounds(764, 15, 110, 14);
		contentPanePay.add(lblMembershipNo);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 1344, 47);
		//panel1.setBackground(new Color(135, 206, 250));
                panel1.setBackground(new Color(0,205,0));
		contentPanePay.add(panel1);
		panel1.setLayout(null);
		
		btnUpdate1 = new JButton("Update");
		btnUpdate1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con= Connect.connectDb();
				
				int row= Payment_Table.getSelectedRow();
				if(row>0)
				{
				String table_click=Payment_Table.getModel().getValueAt(row,0).toString();
				
				Add_Fees admm=new Add_Fees();
                                
				admm.lblAddingNewMemberFee.setText("Updating Member Fees");
				admm.btnNewButtonPaid.setText("Update");
				admm.updating(table_click);
				admm.show();
				}
				else {
					JOptionPane.showMessageDialog(Payment_Table, "Please select at least one row");
				}
			}
		});
		btnUpdate1.setBounds(120, 11, 110, 23);
		panel1.add(btnUpdate1);
		btnUpdate1.setIcon(new ImageIcon(Show_All.class.getResource("/images/ediit.png")));
		btnUpdate1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnRefreshpay = new JButton("Refresh");
		btnRefreshpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Get_Data_fee();
			}
		});
		btnRefreshpay.setBounds(240, 11, 107, 23);
		panel1.add(btnRefreshpay);
		btnRefreshpay.setIcon(new ImageIcon(Show_All.class.getResource("/images/refresh.png")));
		btnRefreshpay.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnDelete1 = new JButton("Delete");
		btnDelete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					con= Connect.connectDb();
					
					int row= Payment_Table.getSelectedRow();
					if(row>0)
					{
						int p=JOptionPane.showConfirmDialog(null,"Are you sure to delete" , "Delete Confirmation", JOptionPane.YES_NO_OPTION);
						if(p==0)
						{
							
						String table_click=Payment_Table.getModel().getValueAt(row,0).toString();
					String sql="Delete from payment where idpayment="+table_click+"";
					pst=con.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(Payment_Table, "Deleted successfully");
					}
					}
					else {
						JOptionPane.showMessageDialog(Payment_Table, "Pleasse select any history");
						
						
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnDelete1.setIcon(new ImageIcon(Show_All.class.getResource("/images/delete1.png")));
		btnDelete1.setBounds(357, 11, 95, 23);
		panel1.add(btnDelete1);
		btnDelete1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnLatest1 = new JButton("Latest");
		btnLatest1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=Connect.connectDb();
					String sql="Select id payment as'ID',membership_no_fee as 'Membership No',full_name as 'Full Name',reg_date as 'Registered Date',total_fee as 'Total Fee',paid_fee as 'Paid Fee',contact as 'Contact No',start_date as 'Start Date',end_date as 'End Date',nowpaid as 'Now Paid', discount as 'Discount',duration as 'Duration' from payment order by idpayment desc";
			            con=Connect.connectDb();
			            pst=con.prepareStatement(sql);
			            rs=pst.executeQuery();
			        
			            Payment_Table.setModel(DbUtils.resultSetToTableModel(rs));
			                  
					
				}catch(Exception eee)
				{
					JOptionPane.showMessageDialog(null, eee);
				}
			}
		});
		btnLatest1.setBounds(462, 11, 101, 23);
		panel1.add(btnLatest1);
		btnLatest1.setIcon(new ImageIcon(Show_All.class.getResource("/images/latest history.png")));
		btnLatest1.setFont(new Font("Tahoma", Font.BOLD, 13));
		Get_Data_fee();
	}
}
