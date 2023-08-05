/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.buiseness;

import com.gym.controller.Add_Fees;
import com.gym.controller.Add_Member;
import com.gym.database.Connect;
import com.gym.database.Message1;
import com.gym.database.ShowAll_MeasurmentCard;
import com.toedter.calendar.JDateChooser;
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
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author DELL
 */
public class BodyMeasurement extends JFrame{
    Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	 
	// private String updatedMember;
	 private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnMale;
	 //private ImageIcon finalImage;
	 //private String filename;
	 private String gender=null;
	 //private String contryVal=null;
	 private JPanel panel_1;
         private JPanel panel_2;
	public JButton btnSave;
         public JLabel lblAddingNewMeasurement;
	//private JComboBox comboCountry;
	  JPanel contentPane;
          public JButton btnNewButtonPaid;
	  private JTextField txtAge;
	  private JTextField txtWeight;
	  private JTextField txtHeight;
	  private JTextField txtBMI;
	  private JTextField textBodyfat;
	  private JTextField txtMuscles;
	  private JTextField txtBMR;
	  private JTextField txtVisceralfat;
          private JTextField txtNeck;
          private JTextField txtshoulder;
          private JTextField txtchest;
	  private JTextField txtArm;
          private JTextField txtWrist;
          private JTextField txtforeArms;
          private JTextField txtUpperABS;
          private JTextField txtLowerABS;
          private JTextField txtWaist;
          private JTextField txtHip;
          private JTextField txtUpperThighs;
          private JTextField txtLowerthighs;
          private JTextField txtcalf;
          private JTextField txtAnkle;
	 private ButtonGroup btnGroup1;
         private JTextArea jt;
	 // private JComboBox cmbxStatus;
	  private JTextArea txtDiscription ;
	  private JDateChooser measureDate;
	  //private JDateChooser registeredDate;
	  //private JDateChooser endDate;
	 // private JDateChooser dob;
	 // private JComboBox cmbxDuration;
         private JTextField txtmember_msId;
         private JTextField txtmember_mno;
	 // private JComboBox cmbxFeesmode;
	 // private JLabel lblPhoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BodyMeasurement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BodyMeasurement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BodyMeasurement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BodyMeasurement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BodyMeasurement frame = new BodyMeasurement();
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
	public void updating(String idno)
	{
                
		con=Connect.connectDb();
		 String sql="select * from bodymeasure where measurementid='"+idno+"'";
	       try {
		    	pst=con.prepareStatement(sql);
		        rs=pst.executeQuery();
                       
		        if(rs.next())
		        {
		        	  txtmember_msId.setText(rs.getString("measurementid"));
		        	  txtmember_mno.setText(rs.getString("membership_no"));
		        	  txtAge.setText(rs.getString("age"));
		        	  txtHeight.setText(rs.getString("height"));
		        	  txtWeight.setText(rs.getString("weight"));
		        	  String rgender=rs.getString("gender");
		        	  if(rgender.equals("Male"))
		        	  {
		        		  rdbtnMale.setSelected(true);
		        		  gender="Male";
		        	  }
		        	  else {
		        		  rdbtnFemale.setSelected(true);
		        		  gender="Female";
		        	  }
		        	 
		        	  txtBMI.setText(rs.getString("bmi"));
		        	  //cmbxStatus.setSelectedItem(rs.getString("status"));
                                  textBodyfat.setText(rs.getString("bodyfat"));
		        	 
		        	  txtMuscles.setText(rs.getString("muscles"));
		        	  measureDate.setDate(rs.getDate("measuredate"));
		        	  //endDate.setDate(rs.getDate("end_date"));
		        	  //registeredDate.setDate(rs.getDate("reg_date"));
		        	  //cmbxFeesmode.setSelectedItem(rs.getString("fees_mode"));
		        	  txtBMR.setText(rs.getString("bmr"));
		        	  //cmbxDuration1.setText(rs.getString("duration"));
		        	  txtVisceralfat.setText(rs.getString("visceralfat"));
		        	  //dob.setDate(rs.getDate("dob"));
		        	  txtNeck.setText(rs.getString("neck"));
		                  txtshoulder.setText(rs.getString("shoulder"));
		        	  txtchest.setText(rs.getString("chest"));
                                  txtArm.setText(rs.getString("arm"));
                                  txtWrist.setText(rs.getString("wrist"));
                                  txtforeArms.setText(rs.getString("forearms"));
                                  txtUpperABS.setText(rs.getString("upperabs"));
                                  txtLowerABS.setText(rs.getString("lowerabs"));
                                  txtWaist.setText(rs.getString("waist"));
                                  txtHip.setText(rs.getString("hip"));
                                  txtUpperThighs.setText(rs.getString("upperthighs"));
                                  txtLowerthighs.setText(rs.getString("lowerthighs"));
                                  txtcalf.setText(rs.getString("calf"));
                                  txtAnkle.setText(rs.getString("ankle"));
		        	   pst.close();
		    		   rs.close();
		    		   con.close();
				
				}
		        
	       }catch(Exception e)
	       {
	    	   JOptionPane.showMessageDialog(null, e);
	       }
	       finally {
	    	   try {
	    		   
	    		   pst.close();
	    		   rs.close();
	    		   con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
	       }
	
	}
	public BodyMeasurement() {
		setTitle("Fitness Hub || Adding Body Measurement");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(30, 50, 1200, 670);
		contentPane = new JPanel();
                contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                panel_2 = new JPanel();
                panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 0), 2), "Body Measurement Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		panel_2.setBounds(750, 10, 440, 630);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
                
                jt = new JTextArea();
                jt.setBackground(Color.WHITE);
                jt.setFont(new Font("Tahoma", Font.BOLD, 9));
		jt.setBounds(770, 30, 410,600);
		contentPane.add(jt);
                
                panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 0), 2), "ADD Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		panel_1.setBounds(5, 435, 370, 170);
                panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
                
                
                lblAddingNewMeasurement = new JLabel("Measurement Card");
                lblAddingNewMeasurement.setForeground(Color.WHITE);
		lblAddingNewMeasurement.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblAddingNewMeasurement.setBounds(450, 0, 291, 37);
		contentPane.add(lblAddingNewMeasurement);
		
		JLabel lblMembershipno = new JLabel("MemberShip No");
		lblMembershipno.setForeground(Color.GREEN);
		lblMembershipno.setBackground(Color.BLUE);
		lblMembershipno.setBounds(10, 45, 250, 20);
		lblMembershipno.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		contentPane.add(lblMembershipno);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.GREEN);
		lblGender.setBackground(Color.WHITE);
		lblGender.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblGender.setBounds(10, 105, 250, 20);
		contentPane.add(lblGender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(Color.GREEN);
		lblAge.setBackground(Color.WHITE);
		lblAge.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblAge.setBounds(10, 135, 250, 20);
		contentPane.add(lblAge);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.GREEN);
		lblDate.setBackground(Color.WHITE);
		lblDate.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblDate.setBounds(10, 165, 250, 20);
		contentPane.add(lblDate);
		
		/*JLabel lblWeight = new JLabel("Weight");
		lblWeight.setForeground(Color.ORANGE);
		lblWeight.setBackground(Color.WHITE);
		lblWeight.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblWeight.setBounds(194, 261, 128, 14);
		contentPane.add(lblWeight);*/
		
                JLabel lblHeight = new JLabel("Height");
		lblHeight.setForeground(Color.GREEN);
		lblHeight.setBackground(Color.WHITE);
		lblHeight.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblHeight.setBounds(10, 195, 250, 20);
		contentPane.add(lblHeight);
                
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setForeground(Color.GREEN);
		lblWeight.setBackground(Color.WHITE);
		lblWeight.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblWeight.setBounds(10, 225, 250, 20);
		contentPane.add(lblWeight);
		
		JLabel lblBMI = new JLabel("BMI");
		lblBMI.setForeground(Color.GREEN);
		lblBMI.setBackground(Color.WHITE);
		lblBMI.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblBMI.setBounds(10, 255, 250,20);
		contentPane.add(lblBMI);
		
		/*JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.ORANGE);
		lblStatus.setBackground(Color.WHITE);
		lblStatus.setFont(new Font("Traditional Arabic", Font.BOLD, 16));
		lblStatus.setBounds(194, 286, 118, 14);
		contentPane.add(lblStatus);*/
                
                JLabel lblBodyfat = new JLabel("Body Fat");
		lblBodyfat.setForeground(Color.GREEN);
		lblBodyfat.setBackground(Color.WHITE);
		lblBodyfat.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblBodyfat.setBounds(10, 285, 250, 20);
		contentPane.add(lblBodyfat);
		
		JLabel lblMuscles = new JLabel("Muscles");
		lblMuscles.setForeground(Color.GREEN);
		lblMuscles.setBackground(Color.WHITE);
		lblMuscles.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblMuscles.setBounds(10, 315, 250, 20);
		contentPane.add(lblMuscles);
		
		JLabel lblBMR = new JLabel("BMR");
		lblBMR.setForeground(Color.GREEN);
		lblBMR.setBackground(Color.WHITE);
		lblBMR.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblBMR.setBounds(10, 345, 250, 20);
		contentPane.add(lblBMR);
		
		JLabel lblVisceralfat = new JLabel("Visceral Fat");
		lblVisceralfat.setForeground(Color.GREEN);
		lblVisceralfat.setBackground(Color.WHITE);
		lblVisceralfat.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblVisceralfat.setBounds(10, 375, 250, 20);
		contentPane.add(lblVisceralfat);
		
		JLabel lblNeck = new JLabel("Neck");
		lblNeck.setForeground(Color.GREEN);
		lblNeck.setBackground(Color.WHITE);
		lblNeck.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblNeck.setBounds(400, 45, 250, 20);
		contentPane.add(lblNeck);
		
		JLabel lblShoulder = new JLabel("Shoulder");
		lblShoulder.setForeground(Color.GREEN);
		lblShoulder.setBackground(Color.WHITE);
		lblShoulder.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblShoulder.setBounds(400, 75, 250, 20);
		contentPane.add(lblShoulder);
		
		JLabel lblChest = new JLabel("Chest");
		lblChest.setForeground(Color.GREEN);
		lblChest.setBackground(Color.WHITE);
		lblChest.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblChest.setBounds(400, 105, 250, 20);
		contentPane.add(lblChest);
		
		JLabel lblArm = new JLabel("Arm");
		lblArm.setForeground(Color.GREEN);
		lblArm.setBackground(Color.WHITE);
		lblArm.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblArm.setBounds(400, 135, 250, 20);
		contentPane.add(lblArm);
		
		JLabel lblWrist = new JLabel("Wrist");
		lblWrist.setForeground(Color.GREEN);
		lblWrist.setBackground(Color.WHITE);
		lblWrist.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblWrist.setBounds(400, 165, 250, 20);
		contentPane.add(lblWrist);
		
                JLabel lblForeArms = new JLabel("ForeArms");
		lblForeArms.setForeground(Color.GREEN);
		lblForeArms.setBackground(Color.WHITE);
		lblForeArms.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblForeArms.setBounds(400, 195, 250, 20);
		contentPane.add(lblForeArms);
                
                JLabel lblUpperABS = new JLabel("Upper ABS");
		lblUpperABS.setForeground(Color.GREEN);
		lblUpperABS.setBackground(Color.WHITE);
		lblUpperABS.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblUpperABS.setBounds(400, 225, 250, 20);
		contentPane.add(lblUpperABS);
                
                JLabel lblLowerABS = new JLabel("Lower ABS");
		lblLowerABS.setForeground(Color.GREEN);
		lblLowerABS.setBackground(Color.WHITE);
		lblLowerABS.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblLowerABS.setBounds(400, 255, 250, 20);
		contentPane.add(lblLowerABS);
                
                JLabel lblWaist = new JLabel("Waist");
		lblWaist.setForeground(Color.GREEN);
		lblWaist.setBackground(Color.WHITE);
		lblWaist.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblWaist.setBounds(400, 285, 250, 20);
		contentPane.add(lblWaist);
                
                JLabel lblHip = new JLabel("Hip");
		lblHip.setForeground(Color.GREEN);
		lblHip.setBackground(Color.WHITE);
		lblHip.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblHip.setBounds(400, 315, 250, 20);
		contentPane.add(lblHip);
                
                JLabel UpperThighs = new JLabel("Upper Thighs");
		UpperThighs.setForeground(Color.GREEN);
		UpperThighs.setBackground(Color.WHITE);
		UpperThighs.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		UpperThighs.setBounds(400, 345, 250, 20);
		contentPane.add(UpperThighs);
                
                JLabel lblLowerThighs = new JLabel("Lower Thighs");
		lblLowerThighs.setForeground(Color.GREEN);
		lblLowerThighs.setBackground(Color.WHITE);
		lblLowerThighs.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblLowerThighs.setBounds(400, 375, 250, 20);
		contentPane.add(lblLowerThighs);
                
                JLabel lblcalf = new JLabel("calf");
		lblcalf.setForeground(Color.GREEN);
		lblcalf.setBackground(Color.WHITE);
		lblcalf.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblcalf.setBounds(400, 405, 395, 20);
		contentPane.add(lblcalf);
                
                JLabel lblAnkle = new JLabel("Ankle");
		lblAnkle.setForeground(Color.GREEN);
                lblAnkle.setBackground(Color.WHITE);
		lblAnkle.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblAnkle.setBounds(400, 435, 250, 20);
		contentPane.add(lblAnkle);
                
		JLabel lblMembershipNo = new JLabel("Measurement ID");
		lblMembershipNo.setForeground(Color.GREEN);
		lblMembershipNo.setBackground(Color.WHITE);
		lblMembershipNo.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblMembershipNo.setBounds(10, 75, 250, 20);
		contentPane.add(lblMembershipNo);
		
		txtmember_mno = new JTextField();
                txtmember_mno.setForeground(new Color(0, 0, 0));
		txtmember_mno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtmember_mno.setBounds(180, 45, 181, 20);
		contentPane.add(txtmember_mno);
		txtmember_mno.setColumns(10);
		
		
		
		
		
		txtmember_msId = new JTextField();
		
		txtmember_msId.setEnabled(false);
		try{con=Connect.connectDb();
		
		String sql1="Select measurementid from bodymeasure";
		pst=con.prepareStatement(sql1);
		rs=pst.executeQuery();
		int b=0;
		while(rs.next())
		{
			b=rs.getInt("measurementid");
		}
		b=b+1;
		String bb=String.valueOf(b);
		txtmember_msId.setText(bb);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		txtmember_msId.setForeground(new Color(0, 0, 0));
		txtmember_msId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtmember_msId.setBounds(180, 75, 181, 20);
		contentPane.add(txtmember_msId);
		txtmember_msId.setColumns(10);
		
                btnGroup1=new ButtonGroup();
                
                 rdbtnMale = new JRadioButton("Male");
                 rdbtnMale.setBackground(Color.BLACK);
                 rdbtnMale.setForeground(Color.GREEN);
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender="Male";
				}
		});
		rdbtnMale.setBounds(175, 100, 71, 23);
		contentPane.add(rdbtnMale);
		
		 rdbtnFemale = new JRadioButton("Female");
                 rdbtnFemale.setBackground(Color.BLACK);
                 rdbtnFemale.setForeground(Color.GREEN);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender="Female";
			}
		});
		rdbtnFemale.setBounds(250, 100, 71, 23);
		contentPane.add(rdbtnFemale);
		btnGroup1.add(rdbtnFemale);
		btnGroup1.add(rdbtnMale);
                
		txtAge = new JTextField();
		txtAge.setForeground(new Color(0, 0, 0));
		txtAge.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtAge.setColumns(10);
		txtAge.setBounds(180, 135, 181, 20);
		contentPane.add(txtAge);
                
                measureDate = new JDateChooser();
		measureDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MMMMMM-dd");
				String s=format.format(measureDate.getDate());
				String arr[]=s.split("-");
				int year=Integer.parseInt(arr[0]);
				Month month=(Month.valueOf(arr[1].toUpperCase()));
				int day=Integer.parseInt(arr[2]);
				
				LocalDate localDate=LocalDate.now();
				LocalDate birthday=LocalDate.of(year, month, day);
				
				Period p=Period.between(birthday, localDate);
				int curAge=p.getYears();
				String curAge1=String.valueOf(curAge);
                                txtAge.setText(curAge1);
				
			}
		});
		
		measureDate.setDateFormatString(" yyyy-MM-dd");
		measureDate.getCalendarButton().setForeground(Color.BLACK);
		measureDate.setToolTipText("");
		measureDate.getCalendarButton().setToolTipText("");
		measureDate.getCalendarButton().setBackground(Color.WHITE);
		measureDate.setBounds(180, 165, 181, 20);
		contentPane.add(measureDate);
                
                txtHeight = new JTextField();
		txtHeight.setForeground(new Color(0, 0, 0));
		txtHeight.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtHeight.setColumns(10);
		txtHeight.setBounds(180, 195, 181, 20);
		contentPane.add(txtHeight);
                
                 txtWeight = new JTextField();
		 txtWeight.setForeground(new Color(0, 0, 0));
		 txtWeight.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 txtWeight.setColumns(10);
		 txtWeight.setBounds(180, 225, 181, 20);
		contentPane.add(txtWeight);
                
                 txtBMI = new JTextField();
		txtBMI.setForeground(new Color(0, 0, 0));
		txtBMI.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtBMI.setColumns(10);
		txtBMI.setBounds(180, 255, 181, 20);
		contentPane.add(txtBMI);
                
                textBodyfat = new JTextField();
		textBodyfat.setForeground(new Color(0, 0, 0));
		textBodyfat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textBodyfat.setColumns(10);
		textBodyfat.setBounds(180, 285, 181, 20);
		contentPane.add(textBodyfat);
                
                txtMuscles = new JTextField();
		txtMuscles.setForeground(new Color(0, 0, 0));
		txtMuscles.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMuscles.setColumns(10);
		txtMuscles.setBounds(180, 315, 181, 20);
		contentPane.add(txtMuscles);
                
                txtBMR = new JTextField();
                 txtBMR.setForeground(new Color(0, 0, 0));
		 txtBMR.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 txtBMR.setColumns(10);
		 txtBMR.setBounds(180, 345, 181, 20);
		contentPane.add(txtBMR);
                
                txtVisceralfat = new JTextField();
		txtVisceralfat.setForeground(new Color(0, 0, 0));
		txtVisceralfat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtVisceralfat.setColumns(10);
		txtVisceralfat.setBounds(180, 375, 181, 20);
		contentPane.add(txtVisceralfat);
                
                txtNeck = new JTextField();
		txtNeck.setForeground(new Color(0, 0, 0));
		txtNeck.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtNeck.setColumns(10);
		txtNeck.setBounds(550, 45, 181, 20);
		contentPane.add(txtNeck);
                
                txtshoulder = new JTextField();
		txtshoulder.setForeground(new Color(0, 0, 0));
		txtshoulder.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtshoulder.setColumns(10);
		txtshoulder.setBounds(550, 75, 181, 20);
		contentPane.add(txtshoulder);
                
                txtchest = new JTextField();
		txtchest.setForeground(new Color(0, 0, 0));
		txtchest.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtchest.setColumns(10);
		txtchest.setBounds(550, 105, 181, 20);
		contentPane.add(txtchest);
                
                txtArm = new JTextField();
		txtArm.setForeground(new Color(0, 0, 0));
		txtArm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtArm.setColumns(10);
		txtArm.setBounds(550, 135, 181, 20);
		contentPane.add(txtArm);
                
                txtWrist = new JTextField();
		txtWrist.setForeground(new Color(0, 0, 0));
		txtWrist.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtWrist.setColumns(10);
		txtWrist.setBounds(550, 165, 181, 20);
		contentPane.add(txtWrist);
                
                txtforeArms = new JTextField();
		txtforeArms.setForeground(new Color(0, 0, 0));
		txtforeArms.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtforeArms.setColumns(10);
		txtforeArms.setBounds(550, 195, 181, 20);
		contentPane.add(txtforeArms);
                
                txtUpperABS = new JTextField();
		 txtUpperABS.setForeground(new Color(0, 0, 0));
		 txtUpperABS.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 txtUpperABS.setColumns(10);
		 txtUpperABS.setBounds(550, 225, 181, 20);
		contentPane.add( txtUpperABS);
                
                 txtLowerABS = new JTextField();
		 txtLowerABS.setForeground(new Color(0, 0, 0));
		 txtLowerABS.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 txtLowerABS.setColumns(10);
		 txtLowerABS.setBounds(550, 255, 181, 20);
		contentPane.add(txtLowerABS);
                
                txtWaist = new JTextField();
		 txtWaist.setForeground(new Color(0, 0, 0));
		 txtWaist.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 txtWaist.setColumns(10);
		 txtWaist.setBounds(550, 285, 181, 20);
		contentPane.add(txtWaist);
                
                txtHip = new JTextField();
		 txtHip.setForeground(new Color(0, 0, 0));
		 txtHip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 txtHip.setColumns(10);
		 txtHip.setBounds(550, 315, 181, 20);
		contentPane.add(txtHip);
                
                 txtUpperThighs = new JTextField();
		 txtUpperThighs.setForeground(new Color(0, 0, 0));
		 txtUpperThighs.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 txtUpperThighs.setColumns(10);
		 txtUpperThighs.setBounds(550, 345, 181, 20);
		contentPane.add(txtUpperThighs);
                
                txtLowerthighs = new JTextField();
		 txtLowerthighs.setForeground(new Color(0, 0, 0));
		 txtLowerthighs.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 txtLowerthighs.setColumns(10);
		 txtLowerthighs.setBounds(550, 375, 181, 20);
		contentPane.add(txtLowerthighs);
                
                txtcalf = new JTextField();
		 txtcalf.setForeground(new Color(0, 0, 0));
		 txtcalf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 txtcalf.setColumns(10);
		 txtcalf.setBounds(550, 405, 181, 20);
		contentPane.add(txtcalf);
                
                txtAnkle = new JTextField();
		  txtAnkle.setForeground(new Color(0, 0, 0));
		 txtAnkle.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  txtAnkle.setColumns(10);
		  txtAnkle.setBounds(550, 435, 181, 20);
		contentPane.add(txtAnkle);
                
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(Add_Member.class.getResource("/images/cancel.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			dispose();
			
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(430, 500, 89, 23);
		contentPane.add(btnCancel);
                
                JButton btnshowall = new JButton("Display All");
		//btnCancel.setIcon(new ImageIcon(Add_Member.class.getResource("/images/cancel.png")));
		btnshowall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			ShowAll_MeasurmentCard showmeasure=new ShowAll_MeasurmentCard();
                        showmeasure.show();
			
			}
		});
		btnshowall.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnshowall.setBounds(430, 500, 89, 23);
		panel_1.add(btnshowall);
                
                btnNewButtonPaid = new JButton("Save");
		btnNewButtonPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Authentication ap= new Authentication();
				//ap.show();btnSearch.addActionListener(new ActionListener() {
			
				try {
		
					con=Connect.connectDb();
                                        String sql=null;
					//String sql="Select full_name,reg_date,start_date,end_date from members where membership_no="+txtmNo.getText()+"";
                                        if(btnNewButtonPaid.getText().equals("Save"))
                                        {
                                         sql="Insert into bodymeasure(membership_no,age,gender,measuredate,height,weight,bmi,bodyfat,muscles,bmr,visceralfat,neck,shoulder,chest,arm,wrist,forearms,upperabs,lowerabs,waist,hip,upperthighs,lowerthighs,calf,ankle)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                           
                                        }
				else if(btnNewButtonPaid.getText().equals("Update"))
				{
				
					sql="update bodymeasure set membership_no=?,age=?,gender=?,measuredate=?,height=?,weight=?,bmi=?,"+ 
							"bodyfat=?,muscles=?,bmr=?,visceralfat=?,neck=?,shoulder=?,chest=?,arm=?,wrist=?,forearms=?,"
                                                + "upperabs=?,lowerabs=?,waist=?,hip=?,upperthighs=?,lowerthighs=?,calf=?,ankle=? where measurementid='"+txtmember_msId.getText()+"'";
							
				}
				else {
					
				}
                                                
					pst=con.prepareStatement(sql);
                                        pst.setString (1,txtmember_mno.getText());   
					pst.setString (2, txtAge.getText());
                                        pst.setString (3,gender);
					pst.setString (4, ((JTextField)measureDate.getDateEditor().getUiComponent()).getText());
                                        if(txtHeight.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(5, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (5,txtHeight.getText());
                                        }
                                        
                                        if(txtWeight.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(6, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (6,txtWeight.getText());
                                        }
                                        if(txtBMI.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(7, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (7,txtBMI.getText());
                                        }
                                        if(textBodyfat.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(8, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (8,textBodyfat.getText());
                                        }
                                        if(txtMuscles.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(9, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (9,txtMuscles.getText());
                                        }
                                        if(txtBMR.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(10, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (10,txtBMR.getText());
                                        }
                                        if(txtVisceralfat.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(11, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (11,txtVisceralfat.getText());
                                        }
                                        if(txtNeck.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(12, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (12,txtNeck.getText());
                                        }
                                        if(txtshoulder.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(13, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (13,txtshoulder.getText());
                                        }
                                        if(txtchest.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(14, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (14,txtchest.getText());
                                        }
                                        if(txtArm.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(15, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (15,txtArm.getText());
                                        }
                                        if(txtWrist.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(16, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (16,txtWrist.getText());
                                        }
                                        if(txtforeArms.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(17, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (17,txtforeArms.getText());
                                        }
                                        if(txtUpperABS.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(18, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (18,txtUpperABS.getText());
                                        }
                                        if(txtLowerABS.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(19, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (19,txtLowerABS.getText());
                                        }
                                        if(txtWaist.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(20, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (20,txtWaist.getText());
                                        }
                                        if(txtHip.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(21, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (21,txtHip.getText());
                                        }
                                        if(txtUpperThighs.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(22, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (22,txtUpperThighs.getText());
                                        }
                                        if(txtLowerthighs.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(23, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (23,txtLowerthighs.getText());
                                        }
                                        if(txtcalf.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(24, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (24,txtcalf.getText());
                                        }
                                        if(txtAnkle.getText().equalsIgnoreCase(""))
                                        {
                                            pst.setNull(25, Types.NULL);
					
                                        }
                                        else
                                        {
                                            pst.setString (25,txtAnkle.getText());
                                        }
                                        /*pst.setString  (6,txtWeight.getText());
                                        pst.setString  (7,txtBMI.getText());
                                        pst.setString  (8,textBodyfat.getText());
                                        pst.setString  (9,txtMuscles.getText());
                                        pst.setString  (10,txtBMR.getText());
                                        pst.setString  (11,txtVisceralfat.getText());
                                        pst.setString  (12,txtNeck.getText());
                                        pst.setString  (13,txtshoulder.getText());
                                        pst.setString  (14,txtchest.getText());
                                        pst.setString  (15,txtArm.getText());
                                        pst.setString  (16,txtWrist.getText());
                                        pst.setString  (17,txtforeArms.getText());
                                        pst.setString  (18,txtUpperABS.getText());
                                        pst.setString  (19,txtLowerABS.getText());
                                        pst.setString  (20,txtWaist.getText());
                                        pst.setString  (21,txtHip.getText());
                                        pst.setString  (22,txtUpperThighs.getText());
                                        pst.setString  (23,txtLowerthighs.getText());
                                        pst.setString  (24,txtcalf.getText());
                                        pst.setString  (25,txtAnkle.getText());*/
					pst.execute();
									
					JOptionPane.showMessageDialog(null, "New enquiry is Inserted");
					//hide();
					
                                }	
				 catch (Exception e1) {
					//JOptionPane.showMessageDialog(null, "please enter correct membership number");
                                        JOptionPane.showMessageDialog(null, e1);
				}
				
				
			}
		});
		btnNewButtonPaid.setBounds(120, 40, 111, 23);
		panel_1.add(btnNewButtonPaid);
		btnNewButtonPaid.setIcon(new ImageIcon(Add_Fees.class.getResource("/images/paid.png")));
		btnNewButtonPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
                
                JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setModel(new DefaultTableModel(null, new String[] {"full_name", "contact"}));
				txtmember_mno.setText(null);
				txtAge.setText(null);
                                txtHeight.setText(null);
                                measureDate.setDate(null);
                                txtchest.setText(null);
                                txtWeight.setText(null);
                                txtBMI.setText(null);
                                textBodyfat.setText(null);
                                txtMuscles.setText(null);
                                txtBMR.setText(null);
                                txtVisceralfat.setText(null);
                                txtNeck.setText(null);
                                txtshoulder.setText(null);
                                txtArm.setText(null);
                                txtWrist.setText(null);
                                txtforeArms.setText(null);
                                txtUpperABS.setText(null);
                                txtLowerABS.setText(null);
                                txtWaist.setText(null);
                                txtBMR.setText(null);
                                txtHip.setText(null);
                                txtUpperThighs.setText(null);
                                txtLowerthighs.setText(null);
                                txtcalf.setText(null);
                                txtAnkle.setText(null);
                                
                                jt.setText(null);
                                
				//phn_no.setText(null);
			}
		});
		btnReset.setIcon(new ImageIcon(Message1.class.getResource("/images/exit.png")));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(570, 500, 111, 23);
		contentPane.add(btnReset);
                
                JButton genreceipt = new JButton("Generate Receipt");
		genreceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setModel(new DefaultTableModel(null, new String[] {"full_name", "contact"}));
                                jt.setText(" **************************************************** \n");
                                jt.setText(jt.getText()+" *                            Fitness Hub || Measurement Card                * \n");
                                jt.setText(jt.getText()+" **************************************************** \n");	
                                Date obj= new Date();
                                String feedate=obj.toString();
                                jt.setText(jt.getText()+"\n     "+feedate+"            Receipt no:  "+txtmember_msId.getText()+"\n\n");
                                jt.setText(jt.getText()+"       Membership_No:              "+txtmember_mno.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Age:                                  "+txtAge.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Height:                              "+txtHeight.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Weight:                              "+txtWeight.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Date:                                "+((JTextField)measureDate.getDateEditor().getUiComponent()).getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       BMI:                                  "+txtBMI.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Body Fat:                          "+textBodyfat.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Muscles:                            "+txtMuscles.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       BMR:                                 "+txtBMR.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Visceral Fat:                     "+txtVisceralfat.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Neck:                                 "+txtNeck.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Shoulder:                          "+txtshoulder.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Chest:                                "+txtchest.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Arm:                                  "+txtArm.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Wrist:                                "+txtWrist.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       ForeArms:                        "+txtforeArms.getText()+"\n                                  ---------------------------------------\n");       
                                jt.setText(jt.getText()+"       Upper ABS:                       "+txtUpperABS.getText()+"\n                                  ---------------------------------------\n");     
                                jt.setText(jt.getText()+"       Lower ABS:                       "+txtLowerABS.getText()+"\n                                  ---------------------------------------\n");   
                                jt.setText(jt.getText()+"       Hip:                                   "+txtHip.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Upper Thighs:                   "+txtUpperThighs.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Lower Thighs:                   "+txtLowerthighs.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       calf:                                  "+txtcalf.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Ankle:                               "+txtAnkle.getText()+"\n                                  ---------------------------------------");               
                                jt.setText(jt.getText()+"\n\n                                                                        Signature");
			}
		});
		//genreceipt.setIcon(new ImageIcon(Message1.class.getResource("/images/exit.png")));
		genreceipt.setFont(new Font("Tahoma", Font.BOLD, 12));
		genreceipt.setBounds(15,100 , 150, 25);
		panel_1.add(genreceipt);
                
                JButton receiptprint = new JButton("Receipt Print");
		receiptprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setModel(new DefaultTableModel(null, new String[] {"full_name", "contact"}));
                                try
                                {
				jt.print();
                                }
                                catch(Exception p)
                                {
                                   p.printStackTrace();
                                }
			}
		});
		//genreceipt.setIcon(new ImageIcon(Message1.class.getResource("/images/exit.png")));
		receiptprint.setFont(new Font("Tahoma", Font.BOLD, 13));
		receiptprint.setBounds(180, 100, 150, 25);
		panel_1.add(receiptprint);
	}
}
