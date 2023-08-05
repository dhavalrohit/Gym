/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.controller;

import com.gym.database.Connect;
import com.gym.database.Message1;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DELL
 */
public class Add_Fees extends JFrame{
    
	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
         public JLabel lblAddingNewMemberFee;
	private JDateChooser reg_Date,e_Date,s_Date;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtmNo;
	private JLabel lblFullName;
	private JLabel lblMemberStatus;
        private JLabel lblMember;
	private JLabel lblDuration;
	private JLabel lblTotal;
	private JLabel lblPaidFee;
	private JLabel lblEndDate;
	private JLabel lblTotalFee;
	private JLabel lblPaidFee_1;
	private JLabel lblChange;
        private JLabel lblidpayment;
        private JLabel lblnote;
	public JButton btnNewButtonPaid;
	private JButton btnNewButton_1;
	private JButton btnCancel;
        private JButton btndiscount_1;
        private JLabel lblcontact;
	private JTextField txtFull_Name;
	private JTextField txtTotal;
	private JTextField txtpaid;
	private JTextField txtTotal2;
	private JTextField txtdiscountfee;
	private JTextField txtdiscountper;
        private JTextField txtcontact;
        private JTextArea jt;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
        private JPanel panel_5;
	private JTable table;
	private JTextField txtnowpaid;
        private JTextField txtduration;
        private JTextField txtidpayment;
            private JDateChooser startDate;
	  private JDateChooser registeredDate;
	  private JDateChooser endDate;
	/**
	 * Launch the application.
	 */
        public void showTableData()
        {
            
             Vector cache = new Vector();
            String[] columnNames = {"membership_no_fee", "paid fee", "start date", "end date"};
            JFrame frame1 = new JFrame("Database Search Result");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel p =new JPanel();
            //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setLayout(new BorderLayout()); 
            //TableModel tm = new TableModel();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);
            //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
            //table = new JTable(model);
            table = new JTable();
            table.setModel(model); 
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setFillsViewportHeight(true);
            JScrollPane scroll = new JScrollPane(table);
            scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
            //String textvalue = txtmNo.getText();
            String membership_no_fee= "";
            String paid_fee= "";
            String start_date = "";
            String end_date = "";
             Object[] rowData = new Object[4];
                int colCount;
                
            try
            { 
            /*Class.forName(driverName); 
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql = "select * from student where rollno = "+textvalue;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();*/
                con=Connect.connectDb();
                
				/*String sql="SELECT a.*\n" +
                                            "FROM payment a\n" +
                                            "JOIN (SELECT membership_no_fee, contact, COUNT(*)\n" +
                                            "FROM payment \n" +
                                            "GROUP BY membership_no_fee='"+txtmNo.getText()+"', contact='"+txtcontact.getText()+"'\n" +
                                            "HAVING count(*) > 0 ) b\n" +
                                            "ON a.membership_no_fee =b.membership_no_fee\n" +
                                            "AND a.contact =b.contact\n" +
                                            "where a.contact='"+txtcontact.getText()+"'";*/
                                
                           String sql="SELECT a.*"
                                   + " FROM payment a "
                                   + "JOIN (SELECT membership_no_fee, contact, COUNT(*) "
                                   + "FROM payment GROUP BY membership_no_fee='"+txtmNo.getText()+"'"
                                   + "HAVING count(*) > 0 ) b "
                                   + "ON a.membership_no_fee =b.membership_no_fee "
                                   + "AND a.contact =b.contact "
                                   + "where a.contact='"+txtcontact.getText()+"'";
                                
                               
                                       pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
                                        
                                        //if(rs.next())
                                        //{
                                        table.setModel(DbUtils.resultSetToTableModel(rs));
                                        
                                        frame1.add(scroll);
                                        frame1.setVisible(true);
                                        frame1.setSize(1000,700);
                                        //}
                                       // else{
                                           // JOptionPane.showMessageDialog(null, "Please enter correct information");
                                       // }
                                        
            pst.close();
                                               rs.close();
                                               con.close();
            
            }
            catch(Exception ex)
            {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Please Enter correct membership number and contact number",
            JOptionPane.ERROR_MESSAGE);
            }
            
            
            }
         
        
	
	public static void main(String[] args) {
		
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Fees frame = new Add_Fees();
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
                InputStream input;
                FileOutputStream output;
		con=Connect.connectDb();
		 String sql="select * from payment where idpayment='"+idno+"'";
	       try {
		    	pst=con.prepareStatement(sql);
		        rs=pst.executeQuery();
                        //File checkfile=new File("images.png");
                       // output=new FileOutputStream(checkfile);
                         //InflaterOutputStream ios = new InflaterOutputStream(output);
		        if(rs.next())
		        {                       
                                                txtidpayment.setText(rs.getString("idpayment"));
                                                txtidpayment.setEnabled(false);
                                                txtFull_Name.setText(rs.getString("full_name"));
						txtmNo.setText(rs.getString("membership_no_fee"));
						txtcontact.setText(rs.getString("contact"));
						reg_Date.setDate(rs.getDate("reg_date"));
						//reg_Date.setEnabled(false);
                                               txtTotal.setText(rs.getString("total_fee"));
                                                txtdiscountper.setText(rs.getString("discount"));
						//reg_Date
						s_Date.setDate(rs.getDate("start_date"));
						//s_Date.setEnabled(false);
						//double a=(rs.getDouble("paid_fee"));
						e_Date.setDate(rs.getDate("end_date"));
						//e_Date.setEnabled(false);
                                                txtduration.setText(rs.getString("duration"));
						
						txtpaid.setText(rs.getString("paid_fee"));
                                                txtpaid.setEnabled(true);
                                                txtnowpaid.setText(rs.getString("nowpaid"));
                            ////////////////////////////////////////////
		        	  /*txtId.setText(rs.getString("id"));
		        	  txtmemberno.setText(rs.getString("membership_no"));
		        	  txtFullname.setText(rs.getString("full_name"));
		        	  txtEmail.setText(rs.getString("email"));
		        	  txtOccupation.setText(rs.getString("occupation"));
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
		        	 
		        	  txtAddress.setText(rs.getString("address"));
		        	  //cmbxStatus.setSelectedItem(rs.getString("status"));
                                  txtdiscount.setText(rs.getString("discount"));
		        	  comboCountry.setSelectedItem(rs.getString("area"));
		        	  txttotalfee.setText(rs.getString("total_fee"));
		        	  startDate.setDate(rs.getDate("start_date"));
		        	  endDate.setDate(rs.getDate("end_date"));
		        	  registeredDate.setDate(rs.getDate("reg_date"));
		        	  cmbxFeesmode.setSelectedItem(rs.getString("fees_mode"));
		        	  txtPaidfee.setText(rs.getString("paid_fee"));
		        	  cmbxDuration1.setText(rs.getString("duration"));
		        	  txtDiscription.setText(rs.getString("discription"));
		        	  dob.setDate(rs.getDate("dob"));
		        	  textContact.setText(rs.getString("contact_no"));
		        	byte imagebytes[] = rs.getBytes("img");
		        	  Image image=getToolkit().createImage(imagebytes);
		        	  Image newImage=image.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(),Image.SCALE_SMOOTH);
			    	  ImageIcon icon=new ImageIcon(newImage);		        	 
		        	  lblPhoto.setIcon(icon);
                                input=rs.getBinaryStream("img");
                                byte buffer[]=new byte[1024];
                                while(input.read(buffer)>0)
                                {
                                    output.write(buffer);
                                }
		        	 String path=checkfile.getAbsolutePath();
                                 ImageIcon icon=new ImageIcon(path);
                                 Image imag=icon.getImage();
                                 Image newImage=imag.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(),Image.SCALE_SMOOTH);
                                 ImageIcon icon1=new ImageIcon(newImage);
                                 lblPhoto.setIcon(icon1);
                                /* InputStream is = rs.getBinaryStream("img"); 
                                    // Decode the inputstream as BufferedImage
                                    BufferedImage bufImg = null;
                                    bufImg = ImageIO.read(is);
                                   
                                    Image image = bufImg.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(),Image.SCALE_SMOOTH);
                                    ImageIcon icon =new ImageIcon(image);
                                    lblPhoto.setIcon(icon);*/
                                 /*Blob aBlob = rs.getBlob("img");
InputStream is = aBlob.getBinaryStream(0, aBlob.length());
BufferedImage imag=ImageIO.read(is);
Image image = imag;
ImageIcon icon =new ImageIcon(image);
lblPhoto.setIcon(icon); */

                                  
                                  
		        	 // txtOccupation.setText(rs.getString("occupation"));
		        	  
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
        
        
        

	/**
	 * Create the frame.
	 */
	public Add_Fees() {
		setTitle("Fitness Hub||Add Fees");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(130, 150, 1200, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(0, 40, 715, 47);
		contentPane.add(panel);
		panel.setLayout(null);
                
                jt = new JTextArea();
                jt.setFont(new Font("Tahoma", Font.BOLD, 12));
		jt.setBounds(750, 30, 400,450);
		contentPane.add(jt);
		//txtmNo.setColumns(10);
                
                lblAddingNewMemberFee = new JLabel("Adding Member Fees");
		lblAddingNewMemberFee.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblAddingNewMemberFee.setBounds(200, 5, 291, 37);
		contentPane.add(lblAddingNewMemberFee);
                
                panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "Fee Receipt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(738, 10, 428, 480);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblFullname = new JLabel("Full Name:");
		lblFullname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFullname.setBounds(5, 10, 132, 25);
		panel.add(lblFullname);
		
		txtFull_Name = new JTextField();
		txtFull_Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFull_Name.setBounds(100, 10, 157, 24);
		panel.add(txtFull_Name);
		txtFull_Name.setColumns(10);
		
                JLabel lblcontact = new JLabel("Contact No:");
		lblcontact.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblcontact.setBounds(280, 10, 132, 25);
		panel.add(lblcontact);
		
		txtcontact = new JTextField();
		txtcontact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcontact.setBounds(390, 10, 157, 24);
		panel.add(txtcontact);
		txtcontact.setColumns(10);
                
                /*JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "Older Fee Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(318, 56, 399, 157);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 383, 134);
		panel_5.add(scrollPane);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null,null},
				//{null, null, null,null},
				//{null, null, null, null},
				//{null, null, null, null},
			},
			new String[] {
				"membership_no", "paid_fee", "start_date", "end_date"
                                //"reg_date", "Paid Amount", "New column"
			}
		));
		scrollPane.setViewportView(table);*/
                
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		
					con=Connect.connectDb();
					//String sql="Select full_name,reg_date,start_date,end_date from members where membership_no="+txtmNo.getText()+"";
                                       // String sql="Select paid_fee,duration,membership_no,reg_date,start_date,end_date from members where full_name='"+txtFull_Name.getText()+"' and contact_no='"+txtcontact.getText()+"'";
					//String sql="Select membership_no_fee,full_name,contact,reg_date,start_date,end_date,paid_fee,total_fee,discount from payment Where full_name='"+txtFull_Name.getText()+"' and contact='"+txtcontact.getText()+"'";
                                   /* String sql= "SELECT * "
                                            + "FROM payment "
                                            + "WHERE membership_no_fee IN (SELECT membership_no_fee FROM payment WHERE end_date = (SELECT MAX(end_date) FROM payment where membership_no_fee='"+txtmNo.getText()+"' )) "
                                            + "ORDER BY membership_no_fee='"+txtmNo.getText()+"' DESC "
                                            + "LIMIT 1";*/
                                   //select t.full_name, t.end_date, t.paid_fee from  payment t
                                 /*String sql =  "select t.* "
                                         + "from payment t"
                                         + "inner join ("
                                         + "select membership_no_fee, max(end_date) as end_date "
                                         + "from payment where membership_no_fee='"+txtmNo.getText()+"'"
                                         + "group by membership_no_fee "
                                         + ") tm on t.membership_no_fee = tm.membership_no_fee and t.end_date = tm.end_date";*/
                           String sql="select * \n" +
                                        "from payment where (membership_no_fee, end_date) in (\n" +
                                        "    select membership_no_fee, max(end_date) as date\n" +
                                        "    from payment where membership_no_fee="+txtmNo.getText()+"\n" +
                                        "    group by membership_no_fee\n" +
                                        ")";
                                         
                                        pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
                                        rs.next();
					//if(rs.next())
                                        //table.setModel(DbUtils.resultSetToTableModel(rs));
					//{
                                             //if( rs.next())
		          // {
                                                 //table.setModel(DbUtils.resultSetToTableModel(rs));
		           		          // }
		          // 
						//txtmNo.setText(rs.getString("membership_no_fee"));
						//txtmNo.setEnabled(false);
                                               txtFull_Name.setText(rs.getString("full_name"));
						//txtmNo.setEnabled(false);
						txtcontact.setText(rs.getString("contact"));
						reg_Date.setDate(rs.getDate("reg_date"));
						//reg_Date.setEnabled(false);
                                               txtTotal.setText(rs.getString("total_fee"));
                                                txtdiscountper.setText(rs.getString("discount"));
						//reg_Date
						s_Date.setDate(rs.getDate("start_date"));
						//s_Date.setEnabled(false);
						//double a=(rs.getDouble("paid_fee"));
						e_Date.setDate(rs.getDate("end_date"));
						//e_Date.setEnabled(false);
                                                txtduration.setText(rs.getString("duration"));
						if(rs.getString("nowpaid").equalsIgnoreCase("0") || rs.getString("nowpaid").equalsIgnoreCase(" "))
                                                {
						txtpaid.setText(rs.getString("paid_fee"));
                                                }
                                                else
                                                {
                                                    txtpaid.setText(rs.getString("nowpaid"));
                                                    //txtnowpaid.setText(rs.getString("nowpaid"));
                                                }
                                                //txtnowpaid.setText(rs.getString("nowpaid"));
                              //  table.setModel(DbUtils.resultSetToTableModel(rs));
                                                //else if {
		        	 // JOptionPane.showMessageDialog(null, "There is no any data having full_name:"+txtFull_Name.getText()+"");
                                     //   }
                                        pst.close();
                                        con.close();
                                        //}
                                                	
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
                
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setIcon(new ImageIcon(Add_Fees.class.getResource("/images/search1.png")));
		btnSearch.setBounds(570, 10, 107, 26);
		panel.add(btnSearch);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "Member Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(10, 100, 298, 119);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		//lblFullName = new JLabel("Full Name:");
		//lblFullName.setBounds(6, 17, 106, 14);
		//panel_4.add(lblFullName);
		//lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                  lblMember = new JLabel("MemberShip No:");
		lblMember.setBounds(6, 17, 106, 14);
		panel_4.add(lblMember);
		lblMember.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblRegDate = new JLabel("Reg. Date:");
		lblRegDate.setBounds(6, 38, 106, 23);
		panel_4.add(lblRegDate);
		lblRegDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtmNo = new JTextField();
                txtmNo.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent arg0) {
                                
                                try{
                                    con=Connect.connectDb();
		
                                    String sql="Select reg_date,paid_fee from payment where membership_no_fee='"+txtmNo.getText()+"'";
                                    pst=con.prepareStatement(sql);
                                    rs=pst.executeQuery();
                                    
                                    rs.next();
                                    
                                    reg_Date.setDate(rs.getDate("reg_date"));
                                   // txtpaid.setText(rs.getString("paid_fee"));
                                    
				
                                } catch (Exception nfe) {
                                //nfe.printStackTrace();
                                System.err.println("Ilegal membership no");
                                 }
                    }
                });
		txtmNo.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtmNo.setBounds(130, 16, 157, 20);
		panel_4.add(txtmNo);
		txtmNo.setColumns(10);
		
		 reg_Date = new JDateChooser();
		reg_Date.setBounds(130, 41, 157, 20);
                reg_Date.setDateFormatString("yyyy-MM-dd");
		panel_4.add(reg_Date);
		
		s_Date = new JDateChooser();
		s_Date.setBounds(130, 66, 157, 20);
                s_Date.setDateFormatString("yyyy-MM-dd");
		Date ddd=new Date();
                s_Date.setDate(ddd);
		panel_4.add(s_Date);
		
		e_Date = new JDateChooser();
		e_Date.setBounds(130, 92, 157, 20);
                e_Date.setDateFormatString("yyyy-MM-dd");
                //Date ddd1=new Date();
                //s_Date.setDate(ddd1);
		panel_4.add(e_Date);
		
		JLabel lblStartDate_1 = new JLabel("Start Date:");
		lblStartDate_1.setBounds(6, 66, 106, 19);
		panel_4.add(lblStartDate_1);
		lblStartDate_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblEndDate_1 = new JLabel("End Date:");
		lblEndDate_1.setBounds(6, 93, 106, 14);
		panel_4.add(lblEndDate_1);
		lblEndDate_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "Fee Information", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 230, 298, 191);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		/*lblMemberStatus = new JLabel("Member Status:");
                
		lblMemberStatus.setBounds(6, 38, 106, 14);
		panel_3.add(lblMemberStatus);
		lblMemberStatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));*/
		
		lblDuration = new JLabel("Duration(Month):");
		lblDuration.setBounds(6, 63, 106, 14);
		panel_3.add(lblDuration);
		lblDuration.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblTotal = new JLabel("Total Fee:");
		lblTotal.setBounds(6, 84, 106, 14);
		panel_3.add(lblTotal);
		lblTotal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblPaidFee = new JLabel("Paid Fee:");
		lblPaidFee.setBounds(6, 109, 106, 14);
		panel_3.add(lblPaidFee);
		lblPaidFee.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblEndDate = new JLabel("End Date:");
		lblEndDate.setVisible(false);
		lblEndDate.setBounds(6, 159, 106, 14);
		panel_3.add(lblEndDate);
		lblEndDate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setVisible(false);
		dateChooser_1.setBounds(122, 160, 153, 20);
		panel_3.add(dateChooser_1);
		
		/*JComboBox comboBox = new JComboBox();
                //lblEndDate.setVisible(false);
                comboBox.setEnabled(true);
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Registered", "Unregistered"}));
		comboBox.setBounds(122, 37, 153, 20);
		panel_3.add(comboBox);*/
		
                txtduration = new JTextField();
		//txtduration.setEnabled(false);
		txtduration.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtduration.setBounds(122, 62, 153, 20);
		panel_3.add(txtduration);
		txtduration.setColumns(10);
                
		/*JComboBox comboBox_1 = new JComboBox();
		//comboBox_1.setEnabled(false);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1","2", "3", "6", "12"}));
                /*comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		
					con=Connect.connectDb();
					//String sql="Select full_name,reg_date,start_date,end_date from members where membership_no="+txtmNo.getText()+"";
                                       String sql="Select amount from fees where duration='"+txtduration.getText()+"'";
                                      // String sql="Select * from fee";
					pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					rs.next();
                                        txtTotal.setText(rs.getString("amount"));
                                }
                                catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
                        }
                });
                                
		comboBox_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_1.setBounds(122, 62, 153, 20);
		panel_3.add(comboBox_1);*/
		
		txtTotal = new JTextField();
		//txtTotal.setEnabled(false);
		txtTotal.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtTotal.setBounds(122, 85, 153, 20);
		panel_3.add(txtTotal);
		txtTotal.setColumns(10);
		
		txtpaid = new JTextField();
		txtpaid.setEnabled(false);
		txtpaid.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtpaid.setBounds(122, 108, 153, 20);
		panel_3.add(txtpaid);
		txtpaid.setColumns(10);
		
		JLabel lblNowPaid = new JLabel("Now Paid");
		lblNowPaid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNowPaid.setBounds(6, 135, 106, 14);
		panel_3.add(lblNowPaid);
		
		txtnowpaid = new JTextField();
		/*txtnowpaid.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent arg0) {
				txtTotal2.setText(txtTotal.getText());
				
				int aa=Integer.parseInt(txtTotal2.getText());
				int s=Integer.parseInt(txtpaid.getText());
				int y=Integer.parseInt(txtnowpaid.getText());
				int z=s+y;
				int x=aa-z;
				txtPaid2.setText(String.valueOf(z));
				txtchange.setText(String.valueOf(x));
			
				
			}
		});*/
		txtnowpaid.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtnowpaid.setColumns(10);
		txtnowpaid.setBounds(122, 134, 153, 20);
		panel_3.add(txtnowpaid);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 250, 154), 2), "Fee Amount Discount", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(318, 100, 395, 99);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblTotalFee = new JLabel("Total Fee:");
		lblTotalFee.setBounds(6, 16, 62, 14);
		panel_2.add(lblTotalFee);
		lblTotalFee.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblPaidFee_1 = new JLabel("Discount Fee:");
		lblPaidFee_1.setBounds(6, 41, 120, 14);
		panel_2.add(lblPaidFee_1);
		lblPaidFee_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblChange = new JLabel("Discount %:");
		lblChange.setBounds(6, 64, 120, 23);
		panel_2.add(lblChange);
		lblChange.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtTotal2 = new JTextField();
		txtTotal2.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtTotal2.setBounds(179, 15, 133, 20);
		panel_2.add(txtTotal2);
		txtTotal2.setColumns(10);
		
		txtdiscountfee = new JTextField();
                //
                /*txtdiscountfee.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent arg0) {
				txtTotal.setText(txtTotal2.getText());
				txtnowpaid.setText(txtdiscountfee.getText());
				
			
				
			}
		});*/
                //
		txtdiscountfee.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtdiscountfee.setBounds(179, 40, 133, 20);
		panel_2.add(txtdiscountfee);
		txtdiscountfee.setColumns(10);
		
		txtdiscountper = new JTextField();
                txtdiscountper.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent arg0) {
                                double s, amount;
                                try{
				double aa=Integer.parseInt(txtTotal2.getText());
				double discount=Integer.parseInt(txtdiscountper.getText());
				//int y=Integer.parseInt(txtnowpaid.getText());
				//int z=s+y;
				//int x=aa-z;
                                s=100-discount;
                                amount=(s*aa)/100;
				txtdiscountfee.setText(String.valueOf(amount));
                                txtTotal.setText(txtTotal2.getText());
				txtnowpaid.setText(txtdiscountfee.getText());
                                } catch (NumberFormatException nfe) {
                                //nfe.printStackTrace();
                                System.err.println("Ilegal input");
                                 }
                    }
                });
		txtdiscountper.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtdiscountper.setBounds(179, 67, 133, 20);
		panel_2.add(txtdiscountper);
		txtdiscountper.setColumns(10);
                    
		//panel_2.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTotalFee, lblPaidFee_1, lblChange, txtTotal2, txtdiscountfee, txtdiscountper}));
                
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 250, 154), 2));
		panel_1.setBounds(318, 230, 395, 150);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
               // txtidpayment.setEnabled(false);
                //
                                //
                
		lblidpayment = new JLabel("Payment Id:");
		
		lblidpayment.setBounds(5, 10, 106, 14);
		panel_1.add(lblidpayment);
		lblidpayment.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                
                txtidpayment = new JTextField();
                //txtidpayment.setEnabled(false);
		
                
                try{con=Connect.connectDb();
		
		String sql1="Select idpayment from payment";
		pst=con.prepareStatement(sql1);
		rs=pst.executeQuery();
		int a=0;
		while(rs.next())
		{
			a=rs.getInt("idpayment");
                        System.out.println("check: "+a);
		}
		a=a+1;
		String aa=String.valueOf(a);
                System.out.println("new check: "+aa);
		txtidpayment.setText(aa);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
                txtidpayment.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtidpayment.setBounds(80, 10, 133, 20);
		panel_1.add(txtidpayment);
		txtidpayment.setColumns(10);
               // contentPane.add(txtidpayment);
                
		btnNewButtonPaid = new JButton("Paid Fee");
		btnNewButtonPaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Authentication ap= new Authentication();
				//ap.show();btnSearch.addActionListener(new ActionListener() {
			
				try {
		
					con=Connect.connectDb();
                                        String sql=null;
					//String sql="Select full_name,reg_date,start_date,end_date from members where membership_no="+txtmNo.getText()+"";
                                        if(btnNewButtonPaid.getText().equals("Paid Fee"))
                                        {
                                         sql="Insert into payment(membership_no_fee,full_name,contact,start_date,end_date,paid_fee,reg_date,duration,discount,total_fee,nowpaid)values(?,?,?,?,?,?,?,?,?,?,?)";
                                           
                                        }
				else if(btnNewButtonPaid.getText().equals("Update"))
				{
				
					sql="update payment set membership_no_fee=?,full_name=?,contact=?,start_date=?,end_date=?,paid_fee=?,"+ 
							"reg_date=?,duration=?,discount=?,total_fee=?,nowpaid=? where idpayment='"+txtidpayment.getText()+"'";
							
				}
				else {
					
				}
                                                
					pst=con.prepareStatement(sql);
                                        pst.setString (1,txtmNo.getText());   
					pst.setString (2, txtFull_Name.getText());
					pst.setString (3,txtcontact.getText());
                                        
                                        pst.setString (4, ((JTextField)s_Date.getDateEditor().getUiComponent()).getText());
					pst.setString (5, ((JTextField)e_Date.getDateEditor().getUiComponent()).getText());
					//pst.setString (11, ((JTextField)endDate.getDateEditor().getUiComponent()).getText());
					//pst.setString (4,txtAddress.getText());
                                        pst.setString  (6,txtpaid.getText());
                                        pst.setString (7, ((JTextField)reg_Date.getDateEditor().getUiComponent()).getText());
                                        pst.setString  (8,txtduration.getText());
                                        pst.setString  (9,txtdiscountper.getText());
                                        pst.setString  (10,txtTotal.getText());
                                        pst.setString  (11,txtnowpaid.getText());
					pst.execute();
					//rs.next();
                                        //table.setModel(DbUtils.resultSetToTableModel(rs));
                                       // if(pst.execute())
					//{
						//JOptionPane.showMessageDialog(null, "Sorry Registration fee canot be inserted");
						
					//}
					//else {
						//JOptionPane.showMessageDialog(null, "New Registration fee is Inserted");
					//}
                                        //
                                        
					//pst = con.prepareStatement(sql);
					
					//pst.close();
					//con.close();
					
					JOptionPane.showMessageDialog(null, "New enquiry is Inserted");
					//hide();
					
                                }	
				 catch (Exception e1) {
					//JOptionPane.showMessageDialog(null, "please enter correct membership number");
                                        JOptionPane.showMessageDialog(null, e1);
				}
				
				
			}
		});
		btnNewButtonPaid.setBounds(6, 50, 111, 23);
		panel_1.add(btnNewButtonPaid);
		btnNewButtonPaid.setIcon(new ImageIcon(Add_Fees.class.getResource("/images/paid.png")));
		btnNewButtonPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
                
                JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setModel(new DefaultTableModel(null, new String[] {"full_name", "contact"}));
				txtFull_Name.setText(null);
				txtcontact.setText(null);
                                txtmNo.setText(null);
                                s_Date.setDate(null);
                                e_Date.setDate(null);
                                txtnowpaid.setText(null);
                                txtTotal.setText(null);
                                txtTotal2.setText(null);
                                txtduration.setText(null);
                                txtpaid.setText(null);
                                reg_Date.setDate(null);
                                txtdiscountper.setText(null);
                                txtdiscountfee.setText(null);
                                jt.setText(null);
                                s_Date.setEnabled(true);
                                e_Date.setEnabled(true);
                                reg_Date.setEnabled(true);
				//phn_no.setText(null);
			}
		});
		btnReset.setIcon(new ImageIcon(Message1.class.getResource("/images/exit.png")));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(6, 80, 111, 23);
		panel_1.add(btnReset);
                
                JButton genreceipt = new JButton("Generate Receipt");
		genreceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setModel(new DefaultTableModel(null, new String[] {"full_name", "contact"}));
                                jt.setText(" ======================================= \n");
                                jt.setText(jt.getText()+" |                            Fitness Hub Fee Receipt                              | \n");
                                jt.setText(jt.getText()+" ======================================= \n");	
                                Date obj= new Date();
                                String feedate=obj.toString();
                                jt.setText(jt.getText()+"\n     "+feedate+"            Receipt no:  "+txtidpayment.getText()+"\n\n");
                                jt.setText(jt.getText()+"       Full Name:              "+txtFull_Name.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Contact No:             "+txtcontact.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Membership No:       "+txtmNo.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Register Date:             "+((JTextField)reg_Date.getDateEditor().getUiComponent()).getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Start Date:             "+((JTextField)s_Date.getDateEditor().getUiComponent()).getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Valid upto:             "+((JTextField)e_Date.getDateEditor().getUiComponent()).getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Total Fee:              "+txtTotal.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Discount %:             "+txtdiscountper.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       Registered Fee:               "+txtpaid.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"       New paid Fee:               "+txtnowpaid.getText()+"\n                                  ---------------------------------------\n");
                                jt.setText(jt.getText()+"\n\n\n                                                                         Signature");
			}
		});
		//genreceipt.setIcon(new ImageIcon(Message1.class.getResource("/images/exit.png")));
		genreceipt.setFont(new Font("Tahoma", Font.BOLD, 13));
		genreceipt.setBounds(230, 425, 150, 25);
		contentPane.add(genreceipt);
                
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
		receiptprint.setBounds(430, 425, 150, 25);
		contentPane.add(receiptprint);
                
                
                JButton fetch = new JButton("Fetch");
		fetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.setModel(new DefaultTableModel(null, new String[] {"full_name", "contact"}));
                               try {
		
					con=Connect.connectDb();
					//String sql="Select full_name,reg_date,start_date,end_date from members where membership_no="+txtmNo.getText()+"";
                                       // String sql="Insert into payment(membership_no_fee,full_name,contact,start_date,end_date,paid_fee)values(?,?,?,?,?,?)";
                                       //String sql="INSERT INTO payment(membership_no_fee,full_name,paid_fee,contact,start_date,end_date,duration,total_fee,discount) SELECT membership_no,full_name,paid_fee,contact_no,start_date,end_date,duration,total_fee,discount FROM members WHERE membership_no='"+txtmNo.getText()+"'";          
                                         String sql="INSERT INTO payment(membership_no_fee,full_name,paid_fee,contact,reg_date,start_date,end_date,duration,total_fee,discount) SELECT membership_no,full_name,paid_fee,contact_no,reg_date,start_date,end_date,duration,total_fee,discount FROM members WHERE membership_no='"+txtmNo.getText()+"'";     
					pst=con.prepareStatement(sql);
                                       /* pst.setString (1,txtmNo.getText());   
					pst.setString (2, txtFull_Name.getText());
					pst.setString (3,txtcontact.getText());
                                        
                                        pst.setString (4, ((JTextField)s_Date.getDateEditor().getUiComponent()).getText());
					pst.setString (5, ((JTextField)e_Date.getDateEditor().getUiComponent()).getText());
					//pst.setString (11, ((JTextField)endDate.getDateEditor().getUiComponent()).getText());
					//pst.setString (4,txtAddress.getText());
                                        pst.setString  (6,txtnowpaid.getText());*/
					pst.execute();
					//rs.next();
                                        //table.setModel(DbUtils.resultSetToTableModel(rs));
                                       // if(pst.execute())
					//{
						//JOptionPane.showMessageDialog(null, "Sorry Registration fee canot be inserted");
						
					//}
					//else {
						//JOptionPane.showMessageDialog(null, "New Registration fee is Inserted");
					//}
                                        //
                                        
					//pst = con.prepareStatement(sql);
					
					pst.close();
					con.close();
					
					JOptionPane.showMessageDialog(null, "New is Inserted");
					//hide();
					
                                }	
				 catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "please enter correct membership number");
				}
				
			}
		});
		//genreceipt.setIcon(new ImageIcon(Message1.class.getResource("/images/exit.png")));
		fetch.setFont(new Font("Tahoma", Font.BOLD, 13));
		fetch.setBounds(80, 425, 100, 25);
                 fetch.setForeground(Color.BLUE);
		contentPane.add(fetch);
                
                lblnote = new JLabel(" Note: Please Enter 'MemberShip No' before clicking 'Fetch' button ");
		lblnote.setBounds(5, 460, 1000, 20);
                lblnote.setForeground(Color.RED);
		contentPane.add(lblnote);
		lblnote.setFont(new Font("Times New Roman", Font.BOLD, 16));
                
                
                btndiscount_1 = new JButton("Apply discount");
                btndiscount_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//public void keyReleased(KeyEvent arg0) {
                                      
                             //txtTotal2.getText();
				double s, amount;
                                try{
				double aa=Integer.parseInt(txtTotal2.getText());
				double discount=Integer.parseInt(txtdiscountper.getText());
				//int y=Integer.parseInt(txtnowpaid.getText());
				//int z=s+y;
				//int x=aa-z;
                                s=100-discount;
                                amount=(s*aa)/100;
				txtdiscountfee.setText(String.valueOf(amount));
                                txtTotal.setText(txtTotal2.getText());
				txtnowpaid.setText(txtdiscountfee.getText());
				//txtchange.setText(String.valueOf(x));
                                } catch (NumberFormatException nfe) {
                                nfe.printStackTrace();
                                 }
                                         
                        }
                });
               
		btndiscount_1.setBounds(127, 80, 140, 23);
		panel_1.add(btndiscount_1);
		//btnNewButton_1.setIcon(new ImageIcon(Add_Fees.class.getResource("/images/clear all.png")));
		btndiscount_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnNewButton_1 = new JButton("Older info");
                btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                                        showTableData();
                                        //updating();
                                        
                        }
                });
               
		btnNewButton_1.setBounds(127, 50, 120, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(Add_Fees.class.getResource("/images/clear all.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(260, 50, 106, 23);
		panel_1.add(btnCancel);
		btnCancel.setIcon(new ImageIcon(Add_Fees.class.getResource("/images/cancel.png")));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
	
}	
}
