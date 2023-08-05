/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Test2 {
    Connection conn;
    //ResultSet rs=null;
	 PreparedStatement pst=null;
                String str1,str2,str3,str4,str5,str6,str7;
                Statement stmt;
        ResultSet rs;
        Map map = new HashMap<String, List<String>>();
       // Map<String, List<String>> peopleByForename = new HashMap<>(); 
       List<String> people = new ArrayList<>();
    //HashMap<String,String[][]> hm;
    public Test2(){
        //hm=new HashMap<String,String[][]>();
         try
                        {
                                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                //String s="jdbc:ucanaccess://e://biometric//ARMS.mdb";
                                 //conn=DriverManager.getConnection("jdbc:ucanaccess://E:\\biometric\\ARMS.mdb;jackcessOpener=com.gym.classes.Test$CryptCodecOpener","Admin","arms2721954");
                                conn=Connect.connectaccessDb();
                            Statement stmt1=conn.createStatement();
                                ResultSet rs1=stmt1.executeQuery("Select * From RawPunchDetail");
                                ResultSetMetaData rsm=rs1.getMetaData();
                                int rows=0;
                                //while(rs1.next())
                                //{
                                       //rows=rows+1;
                                       //System.out.println("Look ma, a row: " + rows);
                                //}
                                //rs1.close();
                                //stmt1.close();
                                Statement stmt2=conn.createStatement();                                
                                ResultSet rs2=stmt2.executeQuery("Select * From RawPunchDetail");
                                final String[] colheads={"ID","EmpCode","CardNo","Datetrn","InTime","OutTime","McNo"};                                        
                                String data[][]=new String[rows][35];
                                int i=-1;
                                int a=0;
                                //rs2.next();
                              
                                while(rs2.next())
                                {
                                        //i=i+1;
                                        //for(int k=0;k<=11;k++)
                                        //{
                                                str1=String.valueOf(rs2.getInt("ID"));
                                                str2=rs2.getString("EmpCode");
                                                str3=rs2.getString("CardNo");
                                               str4=rs2.getString("Datetrn");
                                               str5=rs2.getString("InTime");
                                                str6=rs2.getString("OutTime");
                                                str7=rs2.getString("McNo");
                                //}var map = new HashMap<String, List<String>>();
        map.put(str1, Arrays.asList(str2, str3, str4,str5,str6,str7));
       // map.put("key2", Arrays.asList("value4", "value5", "value6"));

        
                                                
                                                //String strd=rs2.getDate(url)
                                                //String str8=rs2.getString("Sex");
                                                //String str9=rs2.getString("Address");
                                                //String str10=rs2.getString("City");
                                                //String str11=rs2.getString("State");
                                                //String str12=rs2.getString("Phone_No");
                                                //String str13=rs2.getString("Mobile_No");
                                                                                                               
                                              // data[i][k]=str1;     k=k+1;
                                                //data[i][k]=str2;     k=k+1;
                                                //data[i][k]=str3;     k=k+1;
                                                //data[i][k]=str4;     k=k+1;
                                               // data[i][k]=str5;     k=k+1;
                                               // data[i][k]=str6;     k=k+1;
                                               // data[i][k]=str7;     k=k+1;
                                               
                                                //data[i][k]=strd;     k=k+1;
                                                //data[i][k]=str8;     k=k+1;
                                                //data[i][k]=str9;     k=k+1;
                                                //data[i][k]=str10;    k=k+1;
                                                //data[i][k]=str11;    k=k+1;
                                                //data[i][k]=str12;    k=k+1;
                                                //data[i][k]=str13;
                                        //}
                                         people.add(str2);
                                                 people.add(str3);
                                                 people.add(str4);
                                                 people.add(str5);
                                                   people.add(str6);
                                                    people.add(str7);
                                                    //peopleByForename.put(str1, people);
                                                    
                                       
                               }
                               
                                                    //peopleByForename.put(str1, people);
                                        
                                        //hm.put(str1,data);
                                conn.close();
                               // method2(peopleByForename);
                               method2(map);
                        }
         catch(Exception e)
                        {
                                System.out.println(e.getMessage());
                                //JOptionPane.showMessageDialog(null,"ERRROR!");
                        }
        //hm.put("1","A");
        //hm.put("2","B");
        //hm.put("3","C");

        //method2(hm);
        //method2(peopleByForename);

    }

//public void method2(HashMap<String,String[][]> map) {
    public void method2(Map<String,List<String>> map) {
    //write to file : "fileone"
    try {
        /**update**/
       // btnSave = new JButton("Save");
		//btnSave.setIcon(new ImageIcon(Add_Member.class.getResource("/images/save.png")));
		//btnSave.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
			 String EmpCode,CardNo,Datetrn, InTime,OutTime,McNo;
                                                    
                                                   
                                                    
                                                    
                                                    
				conn=Connect.connectDb();
				String sql=null;
				//if(btnSave.getText().equals("Save"))
				//{
				//sql="Insert into members(membership_no,full_name,gender,address,area,"+
				//"total_fee,discount,email,reg_date,start_date,end_date,fees_mode,discription,duration,paid_fee,"+
				//"contact_no,dob,occupation,img) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				//}
                                sql="Insert into rawpunchdetail(ID,EmpCode,CardNo,Datetrn,InTime,OutTime) values (?,?,?,?,?,?)";
				//else if(btnSave.getText().equals("Update"))
				//{
				
					//sql="update members set membership_no=?,full_name=?,gender=?,address=?,country=?,weight=?,"+ 
							//"status=?,email=?,re++g_date=?,start_date=?,end_date=?,fees_mode=?,discription=?,duration=?,paid_fee=?,"+ 
							//"contact_no=?,dob=?,occupation=?,img=? where membership_no="+txtmemberno.getText()+"";
				//}
				//else {
					
				//}
				//try{
					pst = conn.prepareStatement(sql);
                                        //List<String> myList = new ArrayList<String>();
                                        
                                        for(Map.Entry<String,List<String>> m :map.entrySet()){
                                                //pw.println(m.getKey()+"="+m.getValue());
                                                String ID=m.getKey();
                                                pst.setString (1,ID);
                                                System.out.println("start");
                                                System.out.println(m.getKey()+"=");
                                                for (int i = 1; i < m.getValue().size(); i++) {
                                                
                                                System.out.println("values");
                                                    //for(List<String> values : people) { // use for each for rows
                                                            //for(int i=0;i<values.size();i++) { // set argument values to prepared statement
                                                            
                                                            pst.setString((i+1), m.getValue().get(i));
                                                     //EmpCode=m.getValue().get(i);
                                                    //CardNo=m.getValue().get(i);
                                                    //Datetrn=m.getValue().get(i);
                                                    //InTime=m.getValue().get(i);
                                                    //OutTime=m.getValue().get(i);
                                                    //McNo=m.getValue().get(i);
                                                    System.out.println(m.getValue().get(i));
                                                    System.out.println("values end");
                                                    //pst.setString (2,EmpCode);
       
                                                   
					//pst.setString (3, CardNo);
					//pst.setString (4,Datetrn);
					//pst.setString (5,InTime);
                                        //pst.setString (6,OutTime);
                                        //pst.setString (7,McNo);
                                        
                                                        }
                                                pst.execute();
            // Print all elements of List
           // System.out.println(myList.get(i));    
                                                   
                                                    
                                        
					
					//contryVal=comboCountry.getSelectedItem().toString();;
					//pst.setString (5, contryVal);
					//pst.setString (6, txtWeight.getText());
                                        //pst.setString(6, txttotalfee.getText());
					
					//String statusVal=cmbxStatus.getSelectedItem().toString();	
					//pst.setString (7, txtdiscount.getText());
                                         
                                        // }
                                        }
                                       
                                        System.out.println("Data successfully ");
					
					//pst.setString (8, txtEmail.getText());
				
					//pst.setString (9, ((JTextField)registeredDate.getDateEditor().getUiComponent()).getText());
					//pst.setString (10, ((JTextField)startDate.getDateEditor().getUiComponent()).getText());
					//pst.setString (11, ((JTextField)endDate.getDateEditor().getUiComponent()).getText());
					
					//String feesModeVal=cmbxFeesmode.getSelectedItem().toString();				
					//pst.setString (12, feesModeVal);

					//pst.setString (13, txtDiscription.getText());
					
					//String durationVal=cmbxDuration.getSelectedItem().toString();
					//pst.setString(14, cmbxDuration1.getText());
					//pst.setString(15, txtPaidfee.getText());
					//pst.setString(16, textContact.getText());
					//pst.setString (17, ((JTextField)dob.getDateEditor().getUiComponent()).getText());
					//pst.setString(18, txtOccupation.getText());
                                        //pst.setString(19, txttotalfee.getText());
                                        //pst.setString(20, txtdiscount.getText());
					
					//if(filename!=null)
		           // {
					//FileInputStream fis=new FileInputStream(filename);
		            //pst.setBinaryStream(19,fis,(int)filename.length());
					//pst.executeUpdate();
					
					//Date det=new Date();
					//SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
					//String date=format.format(det);
					//Login log=new Login();
					
					//if(btnSave.getText().equals("Update"))
					//{
						//JOptionPane.showMessageDialog(null, "Data updated successfully");
						
						/* For Storing History in database*/
						//String msz="Member "+txtFullname.getText()+" is updated to "+updatedMember+" by "+log.Hitory_User+"";
						//String sql1="Insert into history(date,task) values(?,?)";
						//pst=con.prepareStatement(sql1);
						//pst.setString(1, date);
						//pst.setString(2, msz);
						//pst.execute();
					//}
					//else if(btnSave.getText().equals("Save"))
					//{
                                        
					JOptionPane.showMessageDialog(null, "Data successfully inserted");
					//String msz="Member "+txtFullname.getText()+" is added by "+log.txtUsername.getText()+"";
					//String sql1="Insert into history(date,task) values(?,?)";
					//pst=conn.prepareStatement(sql1);
					//pst.setString(1, date);
					//pst.setString(2, msz);
					
					//}
					//else {
						
					//}
		            //}
					//else {
						//JOptionPane.showMessageDialog(null, "Please Select the image");
					//}
				
			     //}
			    /* catch(Exception e1)
			     {
			    	 JOptionPane.showMessageDialog(null, e1);
			     }
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(656, 330, 95, 23);
		contentPane.add(btnSave);**/
        
        
        /****/
        
        
        
        
        
        
        File fileTwo=new File("E:/filetwo3.txt");
        FileOutputStream fos=new FileOutputStream(fileTwo);
        PrintWriter pw=new PrintWriter(fos);

        //for(Map.Entry<String,String[][]> m :map.entrySet()){
        for(Map.Entry<String,List<String>> m :map.entrySet()){
            pw.println(m.getKey()+"="+m.getValue());
        }

        pw.flush();
        pw.close();
        fos.close();
    } catch(Exception e) {
        e.printStackTrace();
    //System.out.println("exception:"+e);
    }

    //read from file 
    try {
        File toRead=new File("E:/filetwo3.txt");
        FileInputStream fis=new FileInputStream(toRead);

        Scanner sc=new Scanner(fis);

       HashMap<String,String> mapInFile=new HashMap<String,String>();
      // Map<String,List<String>> mapInFile=new HashMap<String,List<String>>();
        //read data from file line by line:
        String currentLine;
        while(sc.hasNextLine()) {
            currentLine=sc.nextLine();
            //now tokenize the currentLine:
           StringTokenizer st=new StringTokenizer(currentLine,"=",false);
           //StringTokenizer st=new StringTokenizer(currentLine,str7,false);
            //put tokens ot currentLine in map
            mapInFile.put(st.nextToken(),st.nextToken());
            //mapInFile.put(st.nextToken(),st.nextToken(str1));
        }
        fis.close();

        //print All data in MAP
        for(Map.Entry<String,String> m :mapInFile.entrySet()) {
           // System.out.println(m.getKey()+"="+m.getValue());
        }
    }catch(Exception e) {}
  }

public static void main(String args[]) {
        new Test2();
}

}
