/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.controller;

import com.gym.database.Connect;
import com.gym.model.AddMemberData;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
public class AddMemberDataTest {
     Connection conn;
    //ResultSet rs=null;
	 PreparedStatement pst=null;
               // String str1,str2,str3,str4,str5,str6,str7;
                String str1[],str2[],str3[],str4[],str5[],str6[],str7[];

                Statement stmt;
        ResultSet rs;
        //Map map = new HashMap<String, List<RawPunchDetail>>();
       // Map<String, List<String>> peopleByForename = new HashMap<>(); 
       List<AddMemberData> people = new ArrayList<AddMemberData>();
        public AddMemberDataTest(){
       
       try
                        {
                                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                //String s="jdbc:ucanaccess://e://biometric//ARMS.mdb";
                                 //conn=DriverManager.getConnection("jdbc:ucanaccess://E:\\biometric\\ARMS.mdb;jackcessOpener=com.gym.classes.Test$CryptCodecOpener","Admin","arms2721954");
                                conn=Connect.connectaccessDb();
                            //Statement stmt1=conn.createStatement();
                               // ResultSet rs1=stmt1.executeQuery("Select * From empmst");
                                //ResultSetMetaData rsm=rs1.getMetaData();
                                //int rows=0;
                                //while(rs1.next())
                                //{
                                       //rows=rows+1;
                                       //System.out.println("Look ma, a row: " + rows);
                                //}
                                //rs1.close();
                                //stmt1.close();
                                Statement stmt2=conn.createStatement();                                
                                ResultSet rs2=stmt2.executeQuery("Select * From empmst");
                                final String[] colheads={"ID","EmpCode","CardNo","Datetrn","InTime","OutTime", "  "};                                        
                                //String data[][]=new String[rows][35];
                                int k=-1;
                                int a=0;
                                //rs2.next();
                              
                                while(rs2.next())
                                {
                                        //k=k+1;
                                        //for(int k=0;k<=25;k++){
                                        //{     
                                    AddMemberData member = new AddMemberData();
                                        
                                               //RawPunchDetail employee = new RawPunchDetail(rs2.getInt("ID"),rs.getString("EmpCode"),rs.getString("CardNo"),rs.getString("Datetrn"),rs.getString("InTime"),rs.getString("OutTime"),rs.getString("  "));
                                               member.setEmpCode(rs2.getString("EmpCode"));
                                                member.setCardNo(rs2.getString("CardNo"));
                                                member.setName(rs2.getString("Name"));
                                                member.setFather(rs2.getString("Father"));
                                                member.setAddress(rs2.getString("Address"));
                                               member.setCity(rs2.getString("City"));
                                               member.setState(rs2.getString("State"));
                                               member.setPin(rs2.getString("Pin"));
                                               member.setTel(rs2.getString("Tel"));
                                               member.setEmail(rs2.getString("Email"));
                                               member.setQualf(rs2.getString("Qualf"));
                                               member.setExp(rs2.getString("Exp"));
                                               member.setDob(rs2.getString("Dob"));
                                               member.setSex(rs2.getString("Sex"));
                                               member.setDeptId(rs2.getString("DeptId"));
                                               member.setCatId(rs2.getString("CatId"));
                                               member.setGradeId(rs2.getString("GradeId"));
                                               member.setCompanyId(rs2.getString("CompanyId"));
                                               member.setDesgId(rs2.getString("DesgId"));
                                               member.setEntryReq(rs2.getInt("EntryReq"));
                                               member.setOtFlg(rs2.getString("OtFlg"));
                                               member.setJoinOn(rs2.getString("JoinOn"));
                                               member.setResignOn(rs2.getString("ResignOn"));
                                               member.setStype(rs2.getString("Stype"));
                                               member.setFShift(rs2.getString("FShift"));
                                               member.setPCode(rs2.getString("PCode"));
                                               member.setStartingShift(rs2.getString("StartingShift"));
                                               member.setShiftStartDate(rs2.getString("ShiftStartDate"));
                                               member.setLocaladdress(rs2.getString("localaddress"));
                                               member.setCardStatus(rs2.getString("cardStatus"));
                                               member.setOff1(rs2.getString("Off1"));
                                               member.setOff2(rs2.getString("Off2"));
                                               member.setSat12345(rs2.getString("Sat12345"));
                                               member.setHf12345(rs2.getString("Hf12345"));
                                               member.setGrossSalary(rs2.getDouble("GrossSalary"));
                                               member.setOtApplicable(rs2.getInt("OtApplicable"));
                                               member.setPIC(rs2.getString("PIC"));
                                               member.setPICSIZE(rs2.getDouble("PICSIZE"));
                                               member.setShift2(rs2.getString("Shift2"));
                                               member.setShift3(rs2.getString("Shift3"));
                                               member.setShift4(rs2.getString("Shift4"));
                                               member.setBasic(rs2.getInt("basic"));
                                                  member.setHra(rs2.getInt("hra"));
                                                  member.setDa(rs2.getInt("da"));
                                                  member.setConvey(rs2.getInt("convey"));
                                                  member.setOthers(rs2.getInt("others"));
                                                  member.setPfno(rs2.getString("pfno"));
                                                   member.setEsino(rs2.getString("esino"));
                                                   member.setDed_head1(rs2.getInt("ded_head1"));
                                                   member.setDed_head2(rs2.getInt("ded_head2"));
                                                   member.setDed_head3(rs2.getInt("ded_head3"));
                                                   member.setDayWiseSalary(rs2.getInt("DayWiseSalary"));
                                                   member.setSwipeCard(rs2.getString("SwipeCard"));
                                                   member.setAccountno(rs2.getString("Accountno"));
                                                   member.setBankName(rs2.getString("BankName"));
                                                   member.setExt1(rs2.getDouble("Ext1"));
                                                   member.setExt2(rs2.getDouble("Ext2"));
                                                   member.setExt3(rs2.getDouble("Ext3"));
                                                   member.setExt4(rs2.getDouble("Ext4"));
                                                   member.setExt5(rs2.getDouble("Ext5"));
                                                   member.setDed_Head4(rs2.getDouble("ded_head4"));
                                                   member.setDed_Head5(rs2.getDouble("ded_head5"));
                                                   member.setDed_Head6(rs2.getDouble("ded_head6"));
                                                   member.setDed_Head7(rs2.getDouble("ded_head7"));
                                                   member.setDed_Head8(rs2.getDouble("ded_head8"));
                                                   member.setUIDNo(rs2.getString("UIDNo"));
                                                   member.setPANNo(rs2.getString("PANNo"));
                                                   
                                                   
                                               //System.out.println(employee.getID()); 
                                                
                                               // map.put(str1, people);
                                                //people.add(employee);
                                                //for (RawPunchDetail s : people) //Iterates as long as there are elements in the list. An object s is created of type Employee class.
        //{
            //System.out.print("ID, Name and City of the employee are : ");
            //System.out.println(s.getID()+" "+s.getEmpCode()+" " +s.getCardNo());
        //}
                                        people.add(member);
                                                
                                                
                                               
                                } 
                                   
                                // people.add(employee);
                                for (int v = 0; v < people.size(); v++) {

                                              System.out.println(people.get(v).getName());
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
    public void method2(List<AddMemberData> raw) {
    //write to file : "fileone"
    try {
      
       Connection conn1=Connect.connectDb();
                            Statement stmt1=conn1.createStatement();
                                ResultSet rs1=stmt1.executeQuery("Select * From empmst");
                                ResultSetMetaData rsm=rs1.getMetaData();
                                int rows=0;
                                //while(rs1.next())
                                //{
                                       //rows=rows+1;
                                       //System.out.println("Look ma, a row: " + rows);
                                //}
                                //rs1.close();
                                //stmt1.close();
        
        List<String> opp=new ArrayList<String>();
        
        
				conn=Connect.connectDb();
				String sql=null;
				
                                sql="insert into empmst\n" +
"(EmpCode,\n" +
"CardNo,\n" +
"Name,\n" +
"Father,\n" +
"Address,\n" +
"City,\n" +
"State,\n" +
"Pin,\n" +
"Tel,\n" +
"Email,\n" +
"Qualf,\n" +
"Exp,\n" +
"Dob,\n" +
"Sex,\n" +
"DeptId,\n" +
"CatId,\n" +
"GradeId,\n" +
"CompanyId,\n" +
"DesgId,\n" +
"EntryReq,\n" +
"OtFlg,\n" +
"JoinOn,\n" +
"ResignOn,\n" +
"Stype,\n" +
"FShift,\n" +
"PCode,\n" +
"StartingShift,\n" +
"ShiftStartDate,\n" +
"localaddress,\n" +
"cardStatus,\n" +
"Off1,\n" +
"Off2,\n" +
"Sat12345,\n" +
"Hf12345,\n" +
"GrossSalary,\n" +
"OtApplicable,\n" +
"PIC,\n" +
"PICSIZE,\n" +
"Shift2,\n" +
"Shift3,\n" +
"Shift4,\n" +
"basic,\n" +
"hra,\n" +
"da,\n" +
"convey,\n" +
"others,\n" +
"pfno,\n" +
"esino,\n" +
"ded_head1,\n" +
"ded_head2,\n" +
"ded_head3,\n" +
"DayWiseSalary,\n" +
"SwipeCard,\n" +
"Accountno,\n" +
"BankName,\n" +
"Ext1,\n" +
"Ext2,\n" +
"Ext3,\n" +
"Ext4,\n" +
"Ext5,\n" +
"ded_Head4,\n" +
"ded_Head5,\n" +
"ded_Head6,\n" +
"ded_Head7,\n" +
"ded_Head8,\n" +
"UIDNo,\n" +
"PANNo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
					pst = conn.prepareStatement(sql);
                                        while(rs1.next())
                                        {
                                            String  emp=rs1.getString("Empcode");
                                            opp.add(emp);
                                        }
                                            for (int i = 0; i < raw.size(); i++){
                                                
                                               //System.out.println("values" + raw.get(i).getEmpCode());
                                                   //if(emp!=raw.get(i).getEmpCode())
                                                   if(opp.contains(raw.get(i).getEmpCode()))
                                                      {
                                                            /*pst.setString(1, raw.get(i).getEmpCode());
                                                            pst.setString(2, raw.get(i).getCardNo());
                                                            pst.setString(3, raw.get(i).getName());
                                                            pst.setString(4, raw.get(i).getFather());
                                                            pst.setString(5, raw.get(i).getAddress());
                                                            pst.setString(6, raw.get(i).getCity());
                                                            pst.setString(7, raw.get(i).getState());
                                                            pst.setString(8, raw.get(i).getPin());
                                                            pst.setString(9, raw.get(i).getTel());
                                                            pst.setString(10, raw.get(i).getEmail());
                                                            pst.setString(11, raw.get(i).getQualf());
                                                            pst.setString(12, raw.get(i).getExp());
                                                            pst.setString(13, raw.get(i).getDob());
                                                            pst.setString(14, raw.get(i).getSex());
                                                            pst.setString(15, raw.get(i).getDeptId());
                                                            pst.setString(16, raw.get(i).getCatId());
                                                            pst.setString(17, raw.get(i).getGradeId());
                                                            pst.setString(18, raw.get(i).getCompanyId());
                                                            pst.setString(19, raw.get(i).getDesgId());
                                                            pst.setInt(20, raw.get(i).getEntryReq());
                                                            pst.setString(21, raw.get(i).getOtFlg());
                                                            pst.setString(22, raw.get(i).getJoinOn());
                                                            pst.setString(23, raw.get(i).getResignOn());
                                                            pst.setString(24, raw.get(i).getStype());
                                                            pst.setString(25, raw.get(i).getFShift());
                                                            pst.setString(26, raw.get(i).getPCode());
                                                            pst.setString(27, raw.get(i).getStartingShift());
                                                            pst.setString(28, raw.get(i).getShiftStartDate());
                                                            pst.setString(29, raw.get(i).getLocaladdress());
                                                            pst.setString(30, raw.get(i).getCardStatus());
                                                            pst.setString(31, raw.get(i).getOff1());
                                                            pst.setString(32, raw.get(i).getOff2());
                                                            pst.setString(33, raw.get(i).getSat12345());
                                                            pst.setString(34, raw.get(i).getHf12345());
                                                            pst.setDouble(35, raw.get(i).getGrossSalary());
                                                            pst.setInt(36, raw.get(i).getOtApplicable());
                                                            pst.setString(37, raw.get(i).getPIC());
                                                            pst.setDouble(38, raw.get(i).getPICSIZE());
                                                            pst.setString(39, raw.get(i).getShift2());
                                                            pst.setString(40, raw.get(i).getShift3());
                                                            pst.setString(41, raw.get(i).getShift4());
                                                            pst.setInt(42, raw.get(i).getBasic());
                                                            pst.setInt(43, raw.get(i).getHra());
                                                            pst.setInt(44, raw.get(i).getDa());
                                                            pst.setInt(45, raw.get(i).getConvey());
                                                            pst.setInt(46, raw.get(i).getOthers());
                                                            pst.setString(47, raw.get(i).getPfno());
                                                            pst.setString(48, raw.get(i).getEsino());
                                                            pst.setInt(49, raw.get(i).getDed_head1());
                                                            pst.setInt(50, raw.get(i).getDed_head2());
                                                            pst.setInt(51, raw.get(i).getDed_head3());
                                                            pst.setDouble(52, raw.get(i).getDayWiseSalary());
                                                            pst.setString(53, raw.get(i).getSwipeCard());
                                                            pst.setString(54, raw.get(i).getAccountno());
                                                            pst.setString(55, raw.get(i).getBankName());
                                                            pst.setDouble(56, raw.get(i).getExt1());
                                                            pst.setDouble(57, raw.get(i).getExt2());
                                                            pst.setDouble(58, raw.get(i).getExt3());
                                                            pst.setDouble(59, raw.get(i).getExt4());
                                                            pst.setDouble(60, raw.get(i).getExt5());
                                                            pst.setDouble(61, raw.get(i).getDed_Head4());
                                                            pst.setDouble(62, raw.get(i).getDed_Head5());
                                                            pst.setDouble(63, raw.get(i).getDed_Head6());
                                                            pst.setDouble(64, raw.get(i).getDed_Head7());
                                                            pst.setDouble(65, raw.get(i).getDed_Head8());
                                                            pst.setString(66, raw.get(i).getUIDNo());
                                                            pst.setString(67, raw.get(i).getPANNo());*/
                                                             
                                                    System.out.println("values end");
                                                   // while(rs1.next())
                                                   // {
                                                     // String  emp=rs1.getString("Empcode");
                                                      
                                                           System.out.println("emp check ");
                                                           //pst.executeUpdate();
                                                      
                                                      }else
                                                   {
                                                       pst.setString(1, raw.get(i).getEmpCode());
                                                            pst.setString(2, raw.get(i).getCardNo());
                                                            pst.setString(3, raw.get(i).getName());
                                                            pst.setString(4, raw.get(i).getFather());
                                                            pst.setString(5, raw.get(i).getAddress());
                                                            pst.setString(6, raw.get(i).getCity());
                                                            pst.setString(7, raw.get(i).getState());
                                                            pst.setString(8, raw.get(i).getPin());
                                                            pst.setString(9, raw.get(i).getTel());
                                                            pst.setString(10, raw.get(i).getEmail());
                                                            pst.setString(11, raw.get(i).getQualf());
                                                            pst.setString(12, raw.get(i).getExp());
                                                            pst.setString(13, raw.get(i).getDob());
                                                            pst.setString(14, raw.get(i).getSex());
                                                            pst.setString(15, raw.get(i).getDeptId());
                                                            pst.setString(16, raw.get(i).getCatId());
                                                            pst.setString(17, raw.get(i).getGradeId());
                                                            pst.setString(18, raw.get(i).getCompanyId());
                                                            pst.setString(19, raw.get(i).getDesgId());
                                                            pst.setInt(20, raw.get(i).getEntryReq());
                                                            pst.setString(21, raw.get(i).getOtFlg());
                                                            pst.setString(22, raw.get(i).getJoinOn());
                                                            pst.setString(23, raw.get(i).getResignOn());
                                                            pst.setString(24, raw.get(i).getStype());
                                                            pst.setString(25, raw.get(i).getFShift());
                                                            pst.setString(26, raw.get(i).getPCode());
                                                            pst.setString(27, raw.get(i).getStartingShift());
                                                            pst.setString(28, raw.get(i).getShiftStartDate());
                                                            pst.setString(29, raw.get(i).getLocaladdress());
                                                            pst.setString(30, raw.get(i).getCardStatus());
                                                            pst.setString(31, raw.get(i).getOff1());
                                                            pst.setString(32, raw.get(i).getOff2());
                                                            pst.setString(33, raw.get(i).getSat12345());
                                                            pst.setString(34, raw.get(i).getHf12345());
                                                            pst.setDouble(35, raw.get(i).getGrossSalary());
                                                            pst.setInt(36, raw.get(i).getOtApplicable());
                                                            pst.setString(37, raw.get(i).getPIC());
                                                            pst.setDouble(38, raw.get(i).getPICSIZE());
                                                            pst.setString(39, raw.get(i).getShift2());
                                                            pst.setString(40, raw.get(i).getShift3());
                                                            pst.setString(41, raw.get(i).getShift4());
                                                            pst.setInt(42, raw.get(i).getBasic());
                                                            pst.setInt(43, raw.get(i).getHra());
                                                            pst.setInt(44, raw.get(i).getDa());
                                                            pst.setInt(45, raw.get(i).getConvey());
                                                            pst.setInt(46, raw.get(i).getOthers());
                                                            pst.setString(47, raw.get(i).getPfno());
                                                            pst.setString(48, raw.get(i).getEsino());
                                                            pst.setInt(49, raw.get(i).getDed_head1());
                                                            pst.setInt(50, raw.get(i).getDed_head2());
                                                            pst.setInt(51, raw.get(i).getDed_head3());
                                                            pst.setDouble(52, raw.get(i).getDayWiseSalary());
                                                            pst.setString(53, raw.get(i).getSwipeCard());
                                                            pst.setString(54, raw.get(i).getAccountno());
                                                            pst.setString(55, raw.get(i).getBankName());
                                                            pst.setDouble(56, raw.get(i).getExt1());
                                                            pst.setDouble(57, raw.get(i).getExt2());
                                                            pst.setDouble(58, raw.get(i).getExt3());
                                                            pst.setDouble(59, raw.get(i).getExt4());
                                                            pst.setDouble(60, raw.get(i).getExt5());
                                                            pst.setDouble(61, raw.get(i).getDed_Head4());
                                                            pst.setDouble(62, raw.get(i).getDed_Head5());
                                                            pst.setDouble(63, raw.get(i).getDed_Head6());
                                                            pst.setDouble(64, raw.get(i).getDed_Head7());
                                                            pst.setDouble(65, raw.get(i).getDed_Head8());
                                                            pst.setString(66, raw.get(i).getUIDNo());
                                                            pst.setString(67, raw.get(i).getPANNo());
                                                            pst.executeUpdate();
                                                   System.out.println("one more ");
                                                   
                                                   }
                                                    //}
                                                    
                                            }
                                                       // }
                                               
           
                                        
                                       
                                        System.out.println("Data successfully ");
					
                                        
					JOptionPane.showMessageDialog(null, "Wait for Timer Complete for Data successfully inserted");
					
       
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
        new AddMemberDataTest();
}
}
