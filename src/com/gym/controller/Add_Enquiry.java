/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.controller;

import com.gym.database.Connect;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author DELL
 */
public class Add_Enquiry extends JFrame{
    Connection con=null;
	ResultSet rs=null;
	PreparedStatement pst=null;

	private JPanel contentPane;
	private JTextField eid;
	private JTextField fullname;
	private JTextField address;
	private JTextField contact;
	private JTextField enquiry_for;
	private JTextField email;
        private JDateChooser edate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
         UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Enquiry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Enquiry frame = new Add_Enquiry();
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
	public Add_Enquiry() {
		setTitle(" Fitness Hub || Adding Enquiry ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 550, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 257, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdjust = new JLabel("Adding Enquiry");
		lblAdjust.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdjust.setBounds(63, 11, 150, 30);
		panel.add(lblAdjust);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 2), "Add Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 54, 241, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEnquiryId = new JLabel("Enquiry ID:");
		lblEnquiryId.setBounds(6, 16, 80, 23);
		panel_1.add(lblEnquiryId);
		lblEnquiryId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setBounds(6, 41, 80, 14);
		panel_1.add(lblFullName);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(6, 66, 80, 14);
		panel_1.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblConactNo = new JLabel("Contact No:");
		lblConactNo.setBounds(6, 91, 80, 14);
		panel_1.add(lblConactNo);
		lblConactNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEnquryFor = new JLabel("Inquiry For:");
		lblEnquryFor.setBounds(6, 116, 80, 23);
		panel_1.add(lblEnquryFor);
		lblEnquryFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(6, 143, 80, 14);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
                JLabel lbledate = new JLabel("Date");
		lbledate.setForeground(Color.ORANGE);
		lbledate.setBackground(Color.WHITE);
		lbledate.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lbledate.setBounds(300, 68, 127, 14);
		contentPane.add(lbledate);
                
                //
                 eid = new JTextField();
		
		eid.setEnabled(false);
		try{con=Connect.connectDb();
		
		String sql1="Select eid from enquiry";
		pst=con.prepareStatement(sql1);
		rs=pst.executeQuery();
		int a=0;
		while(rs.next())
		{
			a=rs.getInt("eid");
		}
		a=a+1;
		String aa=String.valueOf(a);
		eid.setText(aa);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
                //eid.setForeground(Color.BLACK);
		//eid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                eid.setForeground(new Color(0, 128, 128));
		eid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eid.setColumns(10);
		eid.setBounds(96, 19, 132, 20);
                panel_1.add(eid);
		eid.setColumns(10);
                
		//eid = new JTextField();
		//eid.setBounds(96, 19, 132, 20);
		//panel_1.add(eid);
		//eid.setForeground(new Color(0, 128, 128));
		//eid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		//
		fullname = new JTextField();
		fullname.setBounds(96, 40, 132, 20);
		panel_1.add(fullname);
		fullname.setForeground(new Color(0, 128, 128));
		fullname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fullname.setColumns(10);
		
		address = new JTextField();
		address.setBounds(96, 65, 132, 20);
		panel_1.add(address);
		address.setForeground(new Color(0, 128, 128));
		address.setFont(new Font("Tahoma", Font.PLAIN, 13));
		address.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(96, 90, 132, 20);
		panel_1.add(contact);
		contact.setForeground(new Color(0, 128, 128));
		contact.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contact.setColumns(10);
		
		enquiry_for = new JTextField();
		enquiry_for.setBounds(96, 119, 132, 20);
		panel_1.add(enquiry_for);
		enquiry_for.setForeground(new Color(0, 128, 128));
		enquiry_for.setFont(new Font("Tahoma", Font.PLAIN, 13));
		enquiry_for.setColumns(10);
		
		email = new JTextField();
		email.setBounds(96, 142, 132, 20);
		panel_1.add(email);
		email.setForeground(new Color(0, 128, 128));
		email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		email.setColumns(10);
                
                edate = new JDateChooser();
		edate.setDateFormatString("yyyy-MM-dd");
		edate.setBounds(350, 68, 181, 20);
		contentPane.add(edate);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		panel_2.setBounds(10, 228, 241, 46);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		//
               
                
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					  con=Connect.connectDb();
					 
						String sql=null;				
					sql="Insert into enquiry(fullname,address,contact,enquiry_for,email,edate) values(?,?,?,?,?,?)";
					
					pst=con.prepareStatement(sql);
                                       // pst.setString (0,eid.getText());   
					pst.setString (1, fullname.getText());
					pst.setString (2,address.getText());
					pst.setString (3,contact.getText());
					pst.setString (4,enquiry_for.getText());
                                        pst.setString (5,email.getText());
                                        pst.setString (6,((JTextField)edate.getDateEditor().getUiComponent()).getText());
                                        pst.execute();
					/*if(pst.execute())
					{
						JOptionPane.showMessageDialog(null, "Sorry Registration fee canot be inserted");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "New Registration fee is Inserted");
					}*/
                                        //
                                        
					//pst = con.prepareStatement(sql);
					
                                        
                                        
                                        
					pst.close();
					con.close();
					
					
				
					JOptionPane.showMessageDialog(null, "New enquiry is Inserted");
					hide();
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
				
				
			}
		});
		btnSave.setIcon(new ImageIcon(Add_Enquiry.class.getResource("/images/save.png")));
		btnSave.setBounds(29, 11, 89, 23);
		panel_2.add(btnSave);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(Add_Enquiry.class.getResource("/images/cancel.png")));
		btnCancel.setBounds(128, 11, 103, 23);
		panel_2.add(btnCancel);
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
	}
}
