/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.database;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author DELL
 */
public class Search_Member extends JFrame{
    Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	private String filename;
	public JButton btnDelete;
	public JLabel lblSearchMember;
	private JPanel contentPane;
	private JTextField txtFullname;
	private JTextField txtMno;
        private JTextField txtcontactno;
	private JButton imagebutton ;
   private JLabel imagelabel;
   private JTextField imagejtf;
   private ImageIcon finalImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Search_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Member frame = new Search_Member();
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
	public Search_Member() {
		setTitle("Fitness Hub || Search Member");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 200, 860, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadFullName = new JLabel("Full Name");
		lblHeadFullName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHeadFullName.setBounds(10, 68, 94, 22);
		contentPane.add(lblHeadFullName);
		
		txtFullname = new JTextField();
		txtFullname.setBounds(114, 70, 194, 20);
		contentPane.add(txtFullname);
		txtFullname.setColumns(10);
		
		txtcontactno = new JTextField();
		txtcontactno.setBounds(460, 70, 194, 20);
		contentPane.add(txtcontactno);
		txtcontactno.setColumns(10);
		
		JLabel lblId = new JLabel("Contact No:");
		lblId.setToolTipText("");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(350, 71, 144, 23);
		contentPane.add(lblId);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 854, 54);
		panel.setBackground(new Color(135, 206, 250));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblSearchMember = new JLabel("Search Member");
		lblSearchMember.setBounds(345, 11, 220, 28);
		panel.add(lblSearchMember);
		lblSearchMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchMember.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblFullName.setBounds(10, 124, 104, 14);
		contentPane.add(lblFullName);
		
		JLabel lblMembershipNo = new JLabel("Membership No");
		lblMembershipNo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMembershipNo.setBounds(10, 149, 104, 14);
		contentPane.add(lblMembershipNo);
		
		/*JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblWeight.setBounds(10, 292, 104, 23);
		contentPane.add(lblWeight);*/
                
                JLabel lbltotalfee = new JLabel("Total fee");
		lbltotalfee.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbltotalfee.setBounds(10, 292, 104, 23);
		contentPane.add(lbltotalfee);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblContactNo.setBounds(10, 236, 104, 14);
		contentPane.add(lblContactNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEmail.setBounds(317, 128, 107, 14);
		contentPane.add(lblEmail);
		
		JLabel lblRegisteredDate = new JLabel("Registered Date");
		lblRegisteredDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRegisteredDate.setBounds(317, 153, 107, 14);
		contentPane.add(lblRegisteredDate);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblStartDate.setBounds(317, 178, 107, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblEnddate = new JLabel("End Date");
		lblEnddate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEnddate.setBounds(317, 203, 107, 14);
		contentPane.add(lblEnddate);
		
		/*JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCountry.setBounds(10, 261, 101, 20);
		contentPane.add(lblCountry);*/
                
                JLabel lblarea = new JLabel("Area");
		lblarea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblarea.setBounds(10, 261, 101, 20);
		contentPane.add(lblarea);
                
		
		/*JLabel slblPhoto = new JLabel("");
                slblPhoto.setIcon(new ImageIcon(Add_Member.class.getResource("/images/man.png")));
		slblPhoto.setBounds(550, 100, 184, 213);
		contentPane.add(slblPhoto);*/
		
		JLabel slblFullname = new JLabel("");
		slblFullname.setForeground(new Color(220, 20, 60));
		slblFullname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblFullname.setBounds(124, 124, 104, 14);
		contentPane.add(slblFullname);
		
		JLabel slblMembershipno = new JLabel("");
		slblMembershipno.setForeground(new Color(220, 20, 60));
		slblMembershipno.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblMembershipno.setBounds(124, 149, 104, 14);
		contentPane.add(slblMembershipno);
		
		JLabel slblGender = new JLabel("");
		slblGender.setForeground(new Color(220, 20, 60));
		slblGender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblGender.setBounds(124, 174, 104, 20);
		contentPane.add(slblGender);
		
		JLabel slblAge = new JLabel("");
		slblAge.setForeground(new Color(220, 20, 60));
		slblAge.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblAge.setBounds(124, 208, 101, 20);
		contentPane.add(slblAge);
		
		JLabel slblContact = new JLabel("");
		slblContact.setForeground(new Color(220, 20, 60));
		slblContact.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblContact.setBounds(124, 236, 104, 14);
		contentPane.add(slblContact);
		
		/*JLabel slblCountry = new JLabel("");
		slblCountry.setForeground(new Color(220, 20, 60));
		slblCountry.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblCountry.setBounds(124, 261, 101, 20);
		contentPane.add(slblCountry);*/
                
                JLabel slblarea = new JLabel("");
		slblarea.setForeground(new Color(220, 20, 60));
		slblarea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblarea.setBounds(124, 261, 101, 20);
		contentPane.add(slblarea);
                
		
		/*JLabel slblWeight = new JLabel("");
		slblWeight.setForeground(new Color(220, 20, 60));
		slblWeight.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblWeight.setBounds(124, 292, 104, 14);
		contentPane.add(slblWeight);*/
		
                JLabel slbltotalfee = new JLabel("");
		slbltotalfee.setForeground(new Color(220, 20, 60));
		slbltotalfee.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slbltotalfee.setBounds(124, 292, 104, 14);
		contentPane.add(slbltotalfee);
                
		JLabel slblEmail = new JLabel("");
		slblEmail.setForeground(new Color(220, 20, 60));
		slblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblEmail.setBounds(434, 128, 136, 14);
		contentPane.add(slblEmail);
		
		JLabel slblRegistereddate = new JLabel("");
		slblRegistereddate.setForeground(new Color(220, 20, 60));
		slblRegistereddate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblRegistereddate.setBounds(434, 153, 136, 14);
		contentPane.add(slblRegistereddate);
		
		JLabel slblStartdate = new JLabel("");
		slblStartdate.setForeground(new Color(220, 20, 60));
		slblStartdate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblStartdate.setBounds(434, 178, 136, 14);
		contentPane.add(slblStartdate);
		
		JLabel slblEnddate = new JLabel("");
		slblEnddate.setForeground(new Color(220, 20, 60));
		slblEnddate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblEnddate.setBounds(434, 203, 136, 14);
		contentPane.add(slblEnddate);
		
		JLabel slblOccupation = new JLabel("");
		slblOccupation.setForeground(new Color(220, 20, 60));
		slblOccupation.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblOccupation.setBounds(434, 231, 136, 14);
		contentPane.add(slblOccupation);
		
		JLabel slblFeesmode = new JLabel("");
		slblFeesmode.setForeground(new Color(220, 20, 60));
		slblFeesmode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblFeesmode.setBounds(434, 259, 136, 14);
		contentPane.add(slblFeesmode);
		
		JLabel slblDuration = new JLabel("");
		slblDuration.setForeground(new Color(220, 20, 60));
		slblDuration.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		slblDuration.setBounds(434, 292, 136, 14);
		contentPane.add(slblDuration);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(Search_Member.class.getResource("/images/cancel.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnCancel.setForeground(new Color(0, 206, 209));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBounds(705, 317, 106, 23);
		contentPane.add(btnCancel);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String sql="Select * from members where membership_no="+txtMno.getText()+" and full_name='"+txtFullname.getText()+"'";
                                //JFileChooser imgchooser=new JFileChooser();
				//imgchooser.showOpenDialog(null);
                               // File f= new File("E:\\resources");
				//filename=f.getAbsolutePath();
                                //ImageIcon myImage= new ImageIcon(filename);
				//Image  img= myImage.getImage();
				//Image newImage=img.getScaledInstance(slblPhoto.getWidth(), slblPhoto.getHeight(),Image.SCALE_SMOOTH);
				//finalImage=new ImageIcon(newImage);
				//slblPhoto.setIcon(finalImage);
                                
                                //String sql="Select * from members where full_name='"+txtFullname.getText()+"' and  contact_no='"+txtcontactno.getText()+"'";
				String sql="Select * from empmst where Name='"+txtFullname.getText()+"' or  Tel='"+txtcontactno.getText()+"'";
                                try {
					con=Connect.connectDb();
					pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					rs.next();
					{
						slblMembershipno.setText(rs.getString("EmpCode"));
						slblFullname.setText(rs.getString("Name"));
						slblGender.setText(rs.getString("gender"));
						slblarea.setText(rs.getString("area"));
						slblContact.setText(rs.getString("contact_no"));
						slblOccupation.setText(rs.getString("occupation"));
						slblFeesmode.setText(rs.getString("fees_mode"));
						slblRegistereddate.setText(rs.getString("reg_date"));
						slblEmail.setText(rs.getString("email"));
						slblDuration.setText(rs.getString("duration"));
						slblStartdate.setText(rs.getString("start_date"));
						slblEnddate.setText(rs.getString("end_Date"));
						slbltotalfee.setText(rs.getString("total_fee"));
						
						SimpleDateFormat format= new SimpleDateFormat("yyyy-MMMMMM-dd");
						String s=format.format(rs.getDate("dob"));
						String arr[]=s.split("-");
						int year=Integer.parseInt(arr[0]);
						Month month=(Month.valueOf(arr[1].toUpperCase()));
						int day=Integer.parseInt(arr[2]);
						
						LocalDate localDate=LocalDate.now();
						LocalDate birthday=LocalDate.of(year, month, day);
						
						Period p=Period.between(birthday, localDate);
						int curAge=p.getYears();
						String curAge1=String.valueOf(curAge);
						slblAge.setText(curAge1);
						
						/*byte[] imagebytes = rs.getBytes("img");
                                                
                                                //Resize The ImageIcon
                    ImageIcon image = new ImageIcon(imagebytes);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(slblPhoto.getWidth(), slblPhoto.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    slblPhoto.setIcon(newImage);*/
                                                //
			        	//Image image=getToolkit().createImage(imagebytes);
			        	//Image newImage=image.getScaledInstance(slblPhoto.getWidth(), slblPhoto.getHeight(), Image.SCALE_SMOOTH);
				    	//ImageIcon icon=new ImageIcon(newImage);
				    	//slblPhoto.setIcon(icon);
                                        //if(filename!=null)
                                
                                //FileOutputStream fos=new FileOutputStream(f);
			//byte b[];
			//Blob blob;
                               // pst=con.prepareStatement("select img from members where full_name='"+txtFullname.getText()+"'"); 
			//ResultSet rs=pst.executeQuery();
			
			//while(rs.next()){
				//blob=rs.getBlob("image");
				//b=blob.getBytes(19,(int)blob.length());
				//fos.write(b);
			//}
                                
				    	pst.close();
						rs.close();
						con.close();
						
					}
					
				}catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, "please enter valid information");
				}
				finally {
					try {
						pst.close();
						rs.close();
						con.close();
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "please enter valid information");
					}
				}
			}
		});
		btnSearch.setIcon(new ImageIcon(Search_Member.class.getResource("/images/search1.png")));
		btnSearch.setForeground(new Color(0, 206, 209));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(690, 67, 107, 23);
		contentPane.add(btnSearch);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblOccupation.setBounds(317, 231, 107, 14);
		contentPane.add(lblOccupation);
		
		JLabel lblFeesMode = new JLabel("Fees Mode");
		lblFeesMode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblFeesMode.setBounds(317, 259, 107, 14);
		contentPane.add(lblFeesMode);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDuration.setBounds(317, 292, 107, 22);
		contentPane.add(lblDuration);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGender.setBounds(10, 174, 104, 20);
		contentPane.add(lblGender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAge.setBounds(10, 208, 101, 20);
		contentPane.add(lblAge);
		//
                /*imagebutton = new JButton("Retrieve");
    imagebutton.setBounds(250,300,100,40);
    
    imagejtf = new JTextField();
    imagejtf.setBounds(360,310,100,20);
    
    imagelabel = new JLabel();
    imagelabel.setBounds(10,10,670,250);
    
    add(imagebutton);
    add(imagelabel);
    add(imagejtf);
    imagebutton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        
            try{
                con=Connect.connectDb();
                String sql="Select img from members where full_name='"+txtFullname.getText()+"'";
					pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					
                //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_images","root","");
                //Statement st = con.createStatement();
                //ResultSet rs = st.executeQuery("select * from myimages where ID = '"+jtf.getText()+"'");
                if(rs.next()){
                    byte[] img = rs.getBytes("Image");



                    //Resize The ImageIcon
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(slblPhoto.getWidth(), slblPhoto.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    slblPhoto.setIcon(newImage);
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "No Data");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
        }
    });*/
    
                //
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=Connect.connectDb();
					String sql="Delete from empmst where EmpCode='"+slblMembershipno.getText()+"'";
					pst=con.prepareStatement(sql);
					if(pst.execute())
					{
						JOptionPane.showMessageDialog(null, "Sorry member can't be deleted");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Deleted successfully");
						
					}
					pst.close();
					con.close();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				finally{
					try {
						pst.close();
						con.close();
					} catch (Exception e3) {
						JOptionPane.showMessageDialog(null,e3);
					}
					
				}
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setIcon(new ImageIcon(Search_Member.class.getResource("/images/delete user.png")));
		btnDelete.setForeground(new Color(0, 206, 209));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(592, 317, 106, 23);
		contentPane.add(btnDelete);
		
	
	}
}
