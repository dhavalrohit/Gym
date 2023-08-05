/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.database;

import com.gym.model.RawPunchDetail;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
public class RawPunchDetailTest {
       Connection conn;
    //ResultSet rs=null;
	 PreparedStatement pst=null;
               // String str1,str2,str3,str4,str5,str6,str7;
                String str1[],str2[],str3[],str4[],str5[],str6[],str7[];

                Statement stmt;
        ResultSet rs;
        //Map map = new HashMap<String, List<RawPunchDetail>>();
       // Map<String, List<String>> peopleByForename = new HashMap<>(); 
       List<RawPunchDetail> people = new ArrayList<RawPunchDetail>();
      //RawPunchDetail employee = new RawPunchDetail();
    //HashMap<String,String[][]> hm;
    public RawPunchDetailTest(){
        //hm=new HashMap<String,String[][]>();
         try
                        {
                                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                //String s="jdbc:ucanaccess://e://biometric//ARMS.mdb";
                                 //conn=DriverManager.getConnection("jdbc:ucanaccess://E:\\biometric\\ARMS.mdb;jackcessOpener=com.gym.classes.Test$CryptCodecOpener","Admin","arms2721954");
                                conn=Connect.connectaccessDb();
                            //Statement stmt1=conn.createStatement();
                                //ResultSet rs1=stmt1.executeQuery("Select * From RawPunchDetail");
                                //ResultSetMetaData rsm=rs1.getMetaData();
                               // c int rows=0;
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
                                //String data[][]=new String[rows][35];
                                int k=-1;
                                int a=0;
                                //rs2.next();
                              
                                while(rs2.next())
                                {
                                        //k=k+1;
                                        //for(int k=0;k<=25;k++){
                                        //{     
                                    RawPunchDetail employee = new RawPunchDetail();
                                        
                                               //RawPunchDetail employee = new RawPunchDetail(rs2.getInt("ID"),rs.getString("EmpCode"),rs.getString("CardNo"),rs.getString("Datetrn"),rs.getString("InTime"),rs.getString("OutTime"),rs.getString("McNo"));
                                               employee.setID(rs2.getInt("ID"));
                                               employee.setEmpCode(rs2.getString("EmpCode"));
                                               employee.setCardNo(rs2.getString("CardNo"));
                                                employee.setDatetrn(rs2.getString("Datetrn"));
                                                employee.setInTime(rs2.getString("InTime"));
                                               employee.setOutTime(rs2.getString("OutTime"));
                                               employee.setMcNo(rs2.getString("McNo"));
                                               //System.out.println(employee.getID()); 
                                                
                                               // map.put(str1, people);
                                                //people.add(employee);
                                                //for (RawPunchDetail s : people) //Iterates as long as there are elements in the list. An object s is created of type Employee class.
        //{
            //System.out.print("ID, Name and City of the employee are : ");
            //System.out.println(s.getID()+" "+s.getEmpCode()+" " +s.getCardNo());
        //}
                                        people.add(employee);
                                                
                                                
                                               
                                } 
                                   
                                // people.add(employee);
                                for (int v = 0; v < people.size(); v++) {

                                              System.out.println(people.get(v).getID());
                                               System.out.println(people.get(v).getEmpCode());
                                            }
                                
                               // method2(peopleByForename);
                               conn.close();
                        }
                        catch(Exception e)
                        {
                                System.out.println(e.getMessage());
                                //JOptionPane.showMessageDialog(null,"ERRROR!");
                        }
        //hm.put("1","A");
        //hm.put("2","B");
        //hm.put("3","C");
method2(people);
        //method2(hm);
        //method2(peopleByForename);

    }
    
        /****/
//public void method2(HashMap<String,String[][]> map) {
    public void method2(List<RawPunchDetail> raw) {
    //write to file : "fileone"
    try {
      
				Connection conn1=Connect.connectDb();
				String sql=null;
				
                                sql="Insert into rawpunchdetail(ID,EmpCode,CardNo,Datetrn,InTime,OutTime,McNo) values (?,?,?,?,?,?,?)";
				
					pst = conn.prepareStatement(sql);
                                        
                                            for (int i = 0; i < raw.size(); i++){
                                                
                                                System.out.println("values" + raw.get(i).getID());
                                                   
                                                            pst.setInt(1, raw.get(i).getID());
                                                            pst.setString(2, raw.get(i).getEmpCode());
                                                            pst.setString(3, raw.get(i).getCardNo());
                                                            pst.setString(4, raw.get(i).getDatetrn());
                                                            pst.setString(5, raw.get(i).getInTime());
                                                            pst.setString(6, raw.get(i).getOutTime());
                                                            pst.setString(7, raw.get(i).getMcNo());
                                                     
                                                    System.out.println("values end");
                                                    
                                                     pst.execute();
                                        
                                                        }
                                               
           
                                        
                                       
                                        System.out.println("Data successfully ");
					
                                        
					JOptionPane.showMessageDialog(null, "Data successfully inserted");
					
       
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
        new RawPunchDetailTest();
}
}
