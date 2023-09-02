/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gym.general.fees;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.raven.datechooser.DateChooser;
import java.awt.Color;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Exisiting_Member extends javax.swing.JFrame {

    Connection con=null;
      ResultSet rs=null;
      Statement st=null;
      PreparedStatement pst=null;
     private int total_members_count;
       int totalamount=0;
     int currentpayment=0;
     DefaultTableModel model=null;
     
     TextPrompt memberid_prompt;
     TextPrompt membername_prompt;
     TextPrompt mobileno_prompt;
     
    private JPopupMenu popupmenu;
    private JPanel panelsearch;
     private JTable Jtable1;
     
     private DateChooser renew_membership_start_date;
    
    public Exisiting_Member() {
       FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
        FlatIntelliJLaf.setup();
        //total_member_count();
        this.setResizable(false);
        renew_membership_start_date=new DateChooser();
        renew_membership_start_date.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
        
        initComponents();
        duration_TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                calculate_fees();
            }
            
        });
        
        
        
        memberid_prompt=new TextPrompt("Enter Member ID to Start Searching ", member_id_TextField);
        memberid_prompt.setForeground(Color.GRAY);
        memberid_prompt.setHorizontalAlignment((int) LEFT_ALIGNMENT);
        memberid_prompt.changeStyle(Font.BOLD+Font.ITALIC);
        memberid_prompt.setShowPromptOnce(true);
        
        membername_prompt=new TextPrompt("Enter Name to Start Searching", membername_TextField);
        membername_prompt.setForeground(Color.GRAY);
        membername_prompt.setHorizontalAlignment((int) LEFT_ALIGNMENT);
        membername_prompt.changeStyle(Font.BOLD+Font.ITALIC);
        membername_prompt.setShowPromptOnce(true);
        
        mobileno_prompt=new TextPrompt("Enter Mobile No to Start Searching", mobileno_TextField);
        mobileno_prompt.setForeground(Color.GRAY);
        mobileno_prompt.setHorizontalAlignment((int) LEFT_ALIGNMENT);
        mobileno_prompt.changeStyle(Font.BOLD+Font.ITALIC);
        mobileno_prompt.setShowPromptOnce(true);
        
        member_id_TextField.setEditable(true);
        dateofjoin_TextField.setEditable(false);
        mem_start_date_TextField.setEditable(false);
        mem_end_date_TextField.setEditable(false);
        mem_renewed_end_date_TextField.setEditable(false);
        discount_ComboBox.setEnabled(false);
        discount_ComboBox.setEditable(false);
        
        membername_TextField.setEditable(true);
        finalamount_TextField.setEditable(false);
        Jtable1=new JTable();
        showall_members();
        
        namesearchComboBox.setVisible(false);
        idSearchComboBox.setVisible(false);
        mobilenoSearchComboBox.setVisible(false);
        
        
    }

    
        
    public boolean check_numeric_textfields(String text){
    
        boolean result=true;
        
        /*if (text.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Hieght Field Can't be Empty");
            result=false;
        }*/
        
            int len=text.length();
            for (int i = 0; i < len; i++) {
                if(Character.toString(text.charAt(i)).matches("^[0-9]+$")){
                    result=true;
                    continue;
                        
                    
            }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","Hieght Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabet");
                     result=false;
                     
                     break;
                }
            }
        
 return result;
}


  
    public void show_members_details_by_name() throws SQLException{
    
        System.out.println("show members details by mobileNo");
        
        member_id_TextField.setEditable(true);
        mem_start_date_TextField.setEditable(true);
        mem_end_date_TextField.setEditable(true);
        dateofjoin_TextField.setEditable(true);
        membername_TextField.setEditable(true);
        mobileno_TextField.setEditable(true);
        
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        String membership_id_rs;
        String dateofjoin_rs;
        String member_name_rs;
        String mobile_no_rs;
        
        String mem_name=membername_TextField.getText();
        
        String query="select * from dbo.Mst_Employee where EmpName='"+mem_name+"'";
        
        try {
             con=DriverManager.getConnection(url, username, password);
             st=con.createStatement();
             rs=st.executeQuery(query);
             
             if (rs.next()) {                
                 membership_id_rs=rs.getString("EmpID");
                 mobile_no_rs=rs.getString("phoneno");
                dateofjoin_rs=rs.getDate("DateofJoin").toString();
                String membership_start_date_rs=rs.getDate("ShiftStartDate").toString();
                String membership_end_date_rs=rs.getString("ReginDate");
                
                member_id_TextField.setText(membership_id_rs);
                member_id_TextField.setEditable(false);
                
                mobileno_TextField.setText(mobile_no_rs);
                mobileno_TextField.setEditable(false);
                
                dateofjoin_TextField.setText(dateofjoin_rs);
                dateofjoin_TextField.setEditable(false);
                
                membername_TextField.setText(mem_name);
                membername_TextField.setEditable(false);
                
                
                mem_start_date_TextField.setText(membership_start_date_rs);
                mem_start_date_TextField.setEditable(false);
               mem_end_date_TextField.setText(membership_end_date_rs);
                mem_end_date_TextField.setEditable(false);
                
             }     
                 }catch(NullPointerException e){
                      JOptionPane.showMessageDialog(new Frame(), "SQL EXCEPTION");
                      e.printStackTrace();
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                 }
                
        finally{
            con.close();
            member_id_TextField.setEditable(false);
        mem_start_date_TextField.setEditable(false);
        mem_end_date_TextField.setEditable(false);
        dateofjoin_TextField.setEditable(false);
        
        }
    }

    
   public void show_members_details_by_id() throws SQLException{
    
        member_id_TextField.setEditable(true);
        mem_start_date_TextField.setEditable(true);
        mem_end_date_TextField.setEditable(true);
        dateofjoin_TextField.setEditable(true);
        membername_TextField.setEditable(true);
        mobileno_TextField.setEditable(true);
        
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        String membership_id_rs;
        String dateofjoin_rs;
        String member_name_rs;
        String mobile_no_rs;
        
        String mem_id=member_id_TextField.getText();
        
        String query="select * from dbo.Mst_Employee where EmpId='"+mem_id+"'";
        
        try {
             con=DriverManager.getConnection(url, username, password);
             st=con.createStatement();
             rs=st.executeQuery(query);
             
             if (rs.next()) {    
                 member_name_rs=rs.getString("EmpName");
                // membership_id_rs=rs.getString("EmpCode");
                 mobile_no_rs=rs.getString("phoneno");
                dateofjoin_rs=rs.getDate("DateofJoin").toString();
                String membership_start_date_rs=rs.getDate("ShiftStartDate").toString();
                String membership_end_date_rs=rs.getString("ReginDate");
                
                member_id_TextField.setText(mem_id);
                member_id_TextField.setEditable(false);
                
                mobileno_TextField.setText(mobile_no_rs);
                mobileno_TextField.setEditable(false);
                
                dateofjoin_TextField.setText(dateofjoin_rs);
                dateofjoin_TextField.setEditable(false);
                
                membername_TextField.setText(member_name_rs);
                membername_TextField.setEditable(false);
                
                
                mem_start_date_TextField.setText(membership_start_date_rs);
                mem_start_date_TextField.setEditable(false);
               mem_end_date_TextField.setText(membership_end_date_rs);
                mem_end_date_TextField.setEditable(false);
                
             }     
                 }catch(NullPointerException e){
                      JOptionPane.showMessageDialog(new Frame(), "SQL EXCEPTION");
                      e.printStackTrace();
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                 }
                
        finally{
            con.close();
            membername_TextField.setEditable(false);
        mem_start_date_TextField.setEditable(false);
        mem_end_date_TextField.setEditable(false);
        dateofjoin_TextField.setEditable(false);
        
        }
    }
   
  
   public void show_members_details_by_mobileNo() throws SQLException{
    
        member_id_TextField.setEditable(true);
        mem_start_date_TextField.setEditable(true);
        mem_end_date_TextField.setEditable(true);
        dateofjoin_TextField.setEditable(true);
        membername_TextField.setEditable(true);
        mobileno_TextField.setEditable(true);
        
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        String membership_id_rs;
        String dateofjoin_rs;
        String member_name_rs;
        String mobile_no_rs;
        
        String mem_mobileno=mobileno_TextField.getText();
        
        String query="select * from dbo.Mst_Employee where phoneNo='"+mem_mobileno+"'";
        
        try {
             con=DriverManager.getConnection(url, username, password);
             st=con.createStatement();
             rs=st.executeQuery(query);
             
             if (rs.next()) {    
                 member_name_rs=rs.getString("EmpName");
                 membership_id_rs=rs.getString("EmpId");
                // mobile_no_rs=rs.getString("phoneno");
                dateofjoin_rs=rs.getDate("DateofJoin").toString();
                String membership_start_date_rs=rs.getDate("ShiftStartDate").toString();
                String membership_end_date_rs=rs.getString("ReginDate");
                
                member_id_TextField.setText(membership_id_rs);
                member_id_TextField.setEditable(false);
                
                mobileno_TextField.setText(mem_mobileno);
                mobileno_TextField.setEditable(false);
                
                dateofjoin_TextField.setText(dateofjoin_rs);
                dateofjoin_TextField.setEditable(false);
                
                membername_TextField.setText(member_name_rs);
                membername_TextField.setEditable(false);
                
                
                mem_start_date_TextField.setText(membership_start_date_rs);
                mem_start_date_TextField.setEditable(false);
                mem_end_date_TextField.setText(membership_end_date_rs);
                mem_end_date_TextField.setEditable(false);
                
             }     
                 }catch(NullPointerException e){
                      JOptionPane.showMessageDialog(new Frame(), "SQL EXCEPTION");
                      e.printStackTrace();
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                 }
                
        finally{
            con.close();
            member_id_TextField.setEditable(false);
            membername_TextField.setEditable(false);
        mem_start_date_TextField.setEditable(false);
        mem_end_date_TextField.setEditable(false);
        dateofjoin_TextField.setEditable(false);
        
        }
    }
   
 
    
    private List<String> namesearchresult(String prefix) {
   
          String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        List<String> list = new ArrayList<>();
    String query = "SELECT empname FROM dbo.mst_employee WHERE empname LIKE ?";
    try {
       con=DriverManager.getConnection(url,username,password);
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, prefix + "%");  
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            list.add(rs.getString("empname"));
        }
        rs.close();
        pst.close();
        
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(new JFrame(), "SEARCH ERROR");
        e.printStackTrace();
    }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
            
        }
    return list;
    
    
    
}
    
    
    private List<String> idsearchresult(String prefix) {
   
          String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        List<String> list = new ArrayList<>();
    String query = "SELECT EmpId FROM dbo.mst_employee WHERE EmpId LIKE ?";
    try {
       con=DriverManager.getConnection(url,username,password);
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, prefix + "%");  
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            list.add(rs.getString("empid"));
        }
        rs.close();
        pst.close();
        
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(new JFrame(), "SEARCH ERROR");
        e.printStackTrace();
    }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
            
        }
    return list;
    
    
    
}
    
    
    
     private List<String> mobilesearchresult(String prefix) {
   
          String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        List<String> list = new ArrayList<>();
    String query = "SELECT phoneNo FROM dbo.mst_employee WHERE PhoneNo LIKE ?";
    try {
       con=DriverManager.getConnection(url,username,password);
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, prefix + "%");  
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            list.add(rs.getString("phoneNo"));
        }
        rs.close();
        pst.close();
        
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(new JFrame(), "SEARCH ERROR");
        e.printStackTrace();
    }
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
            
        }
    return list;
    
    
    
} 
       
    
    
    
    public void showall_members(){
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
      
        String query="select * from dbo.mst_employee";
        
        try {
            con=DriverManager.getConnection(url,username,password);
           pst=con.prepareStatement(query);
           ResultSet rs=pst.executeQuery();
           
            while (rs.next()) {
                String memID=rs.getString("empid").toString();
                String memName=rs.getString("empname");
                String phoneno=rs.getString("phoneno");
                
                Object[] obj={memID,memName,phoneno};
                 model=(DefaultTableModel) Jtable1.getModel();
                 model.addRow(obj);
                 
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
   
      
    public void calculate_fees(){
      String text=duration_TextField.getText();
      for(int i=0;i<text.length();i++){
          if(duration_TextField.getText().length()>0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")){
          System.out.println("calculate fee method");
          
          int dur=Integer.parseInt(duration_TextField.getText());
           totalamount=1200*dur;//to fetch from DB
          totalfee_TextField.setText(String.valueOf(totalamount));
          totalfee_TextField.setEditable(false);
          
          //int feespaying=Integer.parseInt(currentpayment_TextField.getText());
          
            
          
          finalamount_TextField.setText(String.valueOf(totalamount));
          finalamount_TextField.setEditable(false);
         
          
          
          discount_ComboBox.setEnabled(true);
             totalamount=Integer.valueOf(totalfee_TextField.getText().toString());
          System.out.println(totalamount);
          
          

          }
        else{
            duration_TextField.setText("");
        }
        
        
      }
        
      }
      
        
      
       public void set_renew_mem_end_date(){
           if (mem_renewed_start_date_TextField.getText().length()>0) {
               String startdate=mem_renewed_start_date_TextField.getText();
               System.out.println(startdate);
               try {
                   SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd");
                   LocalDate datefrom=LocalDate.parse(startdate);
                   System.out.println("Date from "+datefrom);
                   int dur_months=Integer.parseInt(duration_TextField.getText());
                   LocalDate dateto=datefrom.plusMonths(dur_months);
                   System.out.println("Date to"+dateto);
                   mem_renewed_end_date_TextField.setEditable(true);
                   mem_renewed_end_date_TextField.setText(dateto.toString());
                   mem_renewed_end_date_TextField.setEditable(false);
                   
               } catch (Exception ex) {
                   Logger.getLogger(Add_Payment.class.getName()).log(Level.SEVERE, null, ex);
                   ex.printStackTrace();
                   JOptionPane.showMessageDialog(new JFrame(), "DATE ERROR");
               }
                
           }
           
           System.out.println(duration_TextField.getText().toString());
            
    }
       
       public void set_new_mem_dates(){
           String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
           String username = "sa";
           String password = "Dhaval@7869";
       
           String empid=member_id_TextField.getText();
           String shiftstart =mem_renewed_start_date_TextField.getText();
           String regindate=mem_renewed_end_date_TextField.getText();
           
           String query="update attendance_manager.dbo.Mst_Employee\n" +
"set ShiftStartDate=?,ReginDate=? where empid="+empid;           
           
           try {
               con=DriverManager.getConnection(url,username,password);
               pst=con.prepareCall(query);
               pst.setString(1, shiftstart);
               pst.setString(2, regindate);
               int count=pst.executeUpdate();
               if (count>0) {
                   System.out.println(empid);
                   JOptionPane.showMessageDialog(new JFrame(), "MemberShip Date Updated");
               }
               
           } catch (Exception e) {
               e.printStackTrace();
               JOptionPane.showMessageDialog(new JFrame(), "DATE ERROR");
               
           }
           
           System.out.println(shiftstart);
           System.out.println(regindate);
           System.out.println(empid);
           
           
           
           
           
           
           
       }
      
      public void add_payment(){
      
          int extradiscount=0;
          
          int memberid=Integer.parseInt(member_id_TextField.getText());
          int duration=Integer.parseInt(duration_TextField.getText());
          int totalfee=Integer.parseInt(totalfee_TextField.getText());
          int discount=Integer.parseInt(discount_ComboBox.getSelectedItem().toString());
          int pendingfees=Integer.parseInt(pendingamount_TextField.getText());
          int final_amount=Integer.parseInt(finalamount_TextField.getText());
          int current_payment=Integer.parseInt(current_payment_TextField.getText());          
      
          
          
          String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
          String username = "sa";
          String password = "Dhaval@7869";
       
         String query="INSERT INTO [dbo].[payments]\n" +
"           ([member_id]\n" +
"           ,[fee_id]\n" +
"           ,[duration]\n" +
"           ,[total_fees]\n" +
"           ,[balance]\n" +
"           ,[current_payment]\n" +
"           ,[discount]\n" +
"           ,[additional_discount]\n" +
"           ,[final_amount])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?,?)";
         
         

          System.out.println(memberid);
          System.out.println(duration);
          System.out.println(totalfee);
          System.out.println(discount);
          System.out.println(extradiscount);
          System.out.println(final_amount);
          System.out.println(current_payment);
          
          int memid=(Integer.parseInt(member_id_TextField.getText()));
          
          try {
            con=DriverManager.getConnection(url, username, password);
              pst=con.prepareStatement(query);
              pst.setInt(1, memberid);
              pst.setInt(2, duration);
              pst.setInt(3, duration);
              pst.setInt(4, totalfee);
              pst.setInt(5, pendingfees);
              pst.setInt(6, current_payment);
              pst.setInt(7, discount);
              pst.setInt(8, extradiscount);
              pst.setInt(9, final_amount);
              
              int count=pst.executeUpdate();
              
              if (count>0) {
                  System.out.println("success");
                  JOptionPane.showMessageDialog(new JFrame(), "Payment Added Successfully");
              } else {
                  System.out.println("failure");
                  JOptionPane.showMessageDialog(new JFrame(), "ERROR!:OPERATION FAILED");
              }
              
              try {
              set_new_mem_dates();
          } catch (Exception e) {
              e.printStackTrace();
              JOptionPane.showMessageDialog(new JFrame(), "DATE ERROR");
          }
              
          }
          
         
          catch (Exception e) {
              e.printStackTrace();
              JOptionPane.showMessageDialog(new JFrame(), "ERROR!:OPERATION FAILED");
          }
          finally{
               membername_TextField.setEditable(true);
        membername_TextField.setText("");
        mem_start_date_TextField.setEditable(true);
        mem_start_date_TextField.setText("");
        mem_end_date_TextField.setEditable(true);
        mem_end_date_TextField.setText("");
        member_id_TextField.setEditable(true);
        member_id_TextField.setText("");
        dateofjoin_TextField.setEditable(true);
        dateofjoin_TextField.setText("");
        
        
          }
                 
      }
          
  /*  public void total_member_count(){
        
        
        String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
        String username = "sa";
        String password = "Dhaval@7869";
        String query="select count(empname) from dbo.Mst_Employee";
        
        try {
            con=DriverManager.getConnection(url, username, password);
            st=con.createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {                
               total_members_count=rs.getInt(1);
               
               
            }
            memberscount_Label.setText(total_members_count+"");
            
        } catch (Exception e) {
        }
        System.out.println("total count:"+total_members_count);
        
    }*/
      
    
    
    
      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateofjoin_TextField = new javax.swing.JTextField();
        mem_start_date_TextField = new javax.swing.JTextField();
        mem_end_date_TextField = new javax.swing.JTextField();
        member_id_TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        totalfee_TextField = new javax.swing.JTextField();
        finalamount_TextField = new javax.swing.JTextField();
        duration_TextField = new javax.swing.JTextField();
        discount_ComboBox = new javax.swing.JComboBox<>();
        addpayment_Button = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        reset_Button = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        current_payment_TextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        membername_TextField = new javax.swing.JTextField();
        pendingamount_TextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mobileno_TextField = new javax.swing.JTextField();
        view_payment_history_Button = new javax.swing.JButton();
        idSearchComboBox = new javax.swing.JComboBox<>();
        mobilenoSearchComboBox = new javax.swing.JComboBox<>();
        mem_renewed_end_date_TextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        namesearchComboBox = new javax.swing.JComboBox<>();
        mem_renewed_start_date_TextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(32, 161, 93));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EXISTING MEMBER PAYMENT");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(32, 161, 93));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Member Information");
        jLabel2.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("MEMBER ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("DATE OF JOINING");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("MEM START DATE");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setText("MEM END DATE");

        dateofjoin_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateofjoin_TextFieldActionPerformed(evt);
            }
        });

        mem_start_date_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_start_date_TextFieldActionPerformed(evt);
            }
        });

        mem_end_date_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_end_date_TextFieldActionPerformed(evt);
            }
        });

        member_id_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                member_id_TextFieldActionPerformed(evt);
            }
        });
        member_id_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                member_id_TextFieldKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setText("DURATION");

        jLabel7.setBackground(new java.awt.Color(32, 161, 93));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FEES DETAILS");
        jLabel7.setOpaque(true);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setText("TOTAL FEE");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setText("DISCOUNT%");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel12.setText("FINAL AMOUNT");

        totalfee_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalfee_TextFieldActionPerformed(evt);
            }
        });

        duration_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                duration_TextFieldFocusLost(evt);
            }
        });
        duration_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duration_TextFieldActionPerformed(evt);
            }
        });
        duration_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                duration_TextFieldKeyReleased(evt);
            }
        });

        discount_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "5", "10", "15", "20", " " }));
        discount_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discount_ComboBoxActionPerformed(evt);
            }
        });

        addpayment_Button.setBackground(new java.awt.Color(32, 161, 93));
        addpayment_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        addpayment_Button.setForeground(java.awt.Color.white);
        addpayment_Button.setText("ADD PAYMENT ");
        addpayment_Button.setBorderPainted(false);
        addpayment_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpayment_ButtonActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(32, 161, 93));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton4.setForeground(java.awt.Color.white);
        jButton4.setText("CLEAR");
        jButton4.setBorderPainted(false);

        reset_Button.setBackground(new java.awt.Color(32, 161, 93));
        reset_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        reset_Button.setForeground(java.awt.Color.white);
        reset_Button.setText("RESET");
        reset_Button.setBorderPainted(false);
        reset_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_ButtonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel13.setText("CURRENT PAYMENT");

        current_payment_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                current_payment_TextFieldKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel14.setText("MEMBER NAME");

        membername_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                membername_TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                membername_TextFieldFocusLost(evt);
            }
        });
        membername_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membername_TextFieldActionPerformed(evt);
            }
        });
        membername_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                membername_TextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                membername_TextFieldKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel15.setText("BALANCE/PENDING");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setText("MOBILE NO");

        mobileno_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mobileno_TextFieldFocusGained(evt);
            }
        });
        mobileno_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileno_TextFieldActionPerformed(evt);
            }
        });
        mobileno_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobileno_TextFieldKeyReleased(evt);
            }
        });

        view_payment_history_Button.setBackground(new java.awt.Color(32, 161, 93));
        view_payment_history_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        view_payment_history_Button.setForeground(java.awt.Color.white);
        view_payment_history_Button.setText("VIEW PAYMENT HISTORY");
        view_payment_history_Button.setBorderPainted(false);
        view_payment_history_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_payment_history_ButtonActionPerformed(evt);
            }
        });

        idSearchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idSearchComboBoxActionPerformed(evt);
            }
        });
        idSearchComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idSearchComboBoxKeyPressed(evt);
            }
        });

        mobilenoSearchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobilenoSearchComboBoxActionPerformed(evt);
            }
        });
        mobilenoSearchComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobilenoSearchComboBoxKeyPressed(evt);
            }
        });

        mem_renewed_end_date_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_renewed_end_date_TextFieldActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("RENEW END DATE");

        namesearchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namesearchComboBoxActionPerformed(evt);
            }
        });
        namesearchComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namesearchComboBoxKeyPressed(evt);
            }
        });

        renew_membership_start_date.setTextField(mem_renewed_start_date_TextField);
        mem_renewed_start_date_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mem_renewed_start_date_TextFieldActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText(" RENEW START DATE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(member_id_TextField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(view_payment_history_Button)
                        .addGap(16, 16, 16)
                        .addComponent(reset_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addpayment_Button))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pendingamount_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(finalamount_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(current_payment_TextField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(membername_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mem_renewed_start_date_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateofjoin_TextField)
                                    .addComponent(mem_start_date_TextField)
                                    .addComponent(mobileno_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mem_end_date_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mem_renewed_end_date_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(namesearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mobilenoSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalfee_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(discount_ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(duration_TextField))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(member_id_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(membername_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namesearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileno_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mobilenoSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateofjoin_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mem_start_date_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(mem_end_date_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(mem_renewed_start_date_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mem_renewed_end_date_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duration_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalfee_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discount_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalamount_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(current_payment_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pendingamount_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(addpayment_Button)
                    .addComponent(reset_Button)
                    .addComponent(view_payment_history_Button))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateofjoin_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateofjoin_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateofjoin_TextFieldActionPerformed

    private void mem_start_date_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_start_date_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mem_start_date_TextFieldActionPerformed

    private void mem_end_date_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_end_date_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mem_end_date_TextFieldActionPerformed

    private void member_id_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_member_id_TextFieldActionPerformed
        // TODO add your handling code here:
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

            }

        });
    }//GEN-LAST:event_member_id_TextFieldActionPerformed

    private void member_id_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_member_id_TextFieldKeyReleased
        // TODO add your handling code here:

        String searchstring = member_id_TextField.getText();
        idSearchComboBox.setVisible(true);
        idSearchComboBox.setEnabled(true);

        try {
            List<String> idsearchresult_list=idsearchresult(searchstring);
            idSearchComboBox.setModel(new DefaultComboBoxModel<>(idsearchresult_list.toArray(new String[0])));
            //namesearchComboBox.requestFocusInWindow();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Search ERROR");
        }

    }//GEN-LAST:event_member_id_TextFieldKeyReleased

    private void totalfee_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalfee_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalfee_TextFieldActionPerformed

    
    private void duration_TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_duration_TextFieldFocusLost
        // TODO add your handling code here:
        if (duration_TextField.getText().length()>0) {
            set_renew_mem_end_date();
        }
        
        
    }//GEN-LAST:event_duration_TextFieldFocusLost

    private void duration_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duration_TextFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_duration_TextFieldActionPerformed

    private void discount_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discount_ComboBoxActionPerformed
        // TODO add your handling code here:
        int discount_perc=0;
        try{
            if (discount_ComboBox.getSelectedIndex()>0) {
                finalamount_TextField.setEditable(true);

                discount_perc=Integer.parseInt(discount_ComboBox.getSelectedItem().toString());
                System.out.println(discount_perc);
                int discount_amount=(totalamount*discount_perc/100);
                totalamount=totalamount-discount_amount;
                System.out.println(discount_amount);
                //int additional_discount=extra_discount_TextField.getText().toString();
                finalamount_TextField.setText(String.valueOf(totalamount));

                finalamount_TextField.setEditable(false);

            }else{
                System.out.println(discount_perc);
            }

        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "ERROR");
        }

    }//GEN-LAST:event_discount_ComboBoxActionPerformed

    private void addpayment_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpayment_ButtonActionPerformed
        // TODO add your handling code here:
        add_payment();
    }//GEN-LAST:event_addpayment_ButtonActionPerformed

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
        membername_TextField.setEditable(true);
        membername_TextField.setText("");
        mem_start_date_TextField.setEditable(true);
        mem_start_date_TextField.setText("");
        mem_end_date_TextField.setEditable(true);
        mem_end_date_TextField.setText("");
        member_id_TextField.setEditable(true);
        member_id_TextField.setText("");
        dateofjoin_TextField.setEditable(true);
        dateofjoin_TextField.setText("");

    }//GEN-LAST:event_reset_ButtonActionPerformed

    
    
    private void current_payment_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_current_payment_TextFieldKeyReleased
        // TODO add your handling code here:
    
                    String text=String.valueOf(current_payment_TextField.getText());
      for(int i=0;i<text.length();i++){
         
        if (current_payment_TextField.getText().length()>0 && Character.toString(text.charAt(i)).matches("^[0-9]+$")) {
            currentpayment=Integer.parseInt(current_payment_TextField.getText());
         
          int pendingamount=totalamount;
          pendingamount=totalamount-currentpayment;
         pendingamount_TextField.setText(String.valueOf(pendingamount));
        
        }else{
             JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","Hieght Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabet");
                   current_payment_TextField.setText(null);
                   pendingamount_TextField.setText(null);
        }
 
        
    }
    }//GEN-LAST:event_current_payment_TextFieldKeyReleased

    private void membername_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_membername_TextFieldFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_membername_TextFieldFocusGained

    private void membername_TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_membername_TextFieldFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_membername_TextFieldFocusLost

    private void membername_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membername_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_membername_TextFieldActionPerformed

    private void membername_TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_membername_TextFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_membername_TextFieldKeyPressed

    private void membername_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_membername_TextFieldKeyReleased
        String searchstring = membername_TextField.getText();
        namesearchComboBox.setVisible(true);
        namesearchComboBox.setEnabled(true);

        try {
            List<String> namesearchresult_list=namesearchresult(searchstring);
            namesearchComboBox.setModel(new DefaultComboBoxModel<>(namesearchresult_list.toArray(new String[0])));
            //namesearchComboBox.requestFocusInWindow();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Search ERROR");
        }

    }//GEN-LAST:event_membername_TextFieldKeyReleased

    private void mobileno_TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobileno_TextFieldFocusGained
        // TODO add your handling code here:
        namesearchComboBox.setVisible(false);
        idSearchComboBox.setVisible(false);
    }//GEN-LAST:event_mobileno_TextFieldFocusGained

    private void mobileno_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileno_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileno_TextFieldActionPerformed

    private void mobileno_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileno_TextFieldKeyReleased
        // TODO add your handling code here:

        String searchstring = mobileno_TextField.getText();
        mobilenoSearchComboBox.setVisible(true);
        mobilenoSearchComboBox.setEnabled(true);

        try {
            List<String> mobileNosearchresult_list=mobilesearchresult(searchstring);
            mobilenoSearchComboBox.setModel(new DefaultComboBoxModel<>(mobileNosearchresult_list.toArray(new String[0])));
            //namesearchComboBox.requestFocusInWindow();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Search ERROR");
        }
    }//GEN-LAST:event_mobileno_TextFieldKeyReleased

    private void view_payment_history_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_payment_history_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_view_payment_history_ButtonActionPerformed

    private void idSearchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idSearchComboBoxActionPerformed
        // TODO add your handling code here:

        String selectedResult = (String) idSearchComboBox.getSelectedItem();
        if (selectedResult != null) {
            // Set the selected result to the searchTextField
            member_id_TextField.setText(selectedResult);
            idSearchComboBox.setVisible(false);
            try {
                show_members_details_by_id();
            } catch (SQLException ex) {
                Logger.getLogger(Add_Payment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_idSearchComboBoxActionPerformed

    private void idSearchComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idSearchComboBoxKeyPressed
        // TODO add your handling code here:
        String result=idSearchComboBox.getSelectedItem().toString();
        member_id_TextField.setText(result);

        idSearchComboBox.setVisible(false);

    }//GEN-LAST:event_idSearchComboBoxKeyPressed

    private void mobilenoSearchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobilenoSearchComboBoxActionPerformed
        // TODO add your handling code here:

        String selectedResult = (String) mobilenoSearchComboBox.getSelectedItem();
        if (selectedResult != null) {
            // Set the selected result to the searchTextField
            mobileno_TextField.setText(selectedResult);
            mobilenoSearchComboBox.setVisible(false);
            try {
                show_members_details_by_mobileNo();
            } catch (SQLException ex) {
                Logger.getLogger(Add_Payment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mobilenoSearchComboBoxActionPerformed

    private void mobilenoSearchComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobilenoSearchComboBoxKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobilenoSearchComboBoxKeyPressed

    private void mem_renewed_end_date_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_renewed_end_date_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mem_renewed_end_date_TextFieldActionPerformed

    private void namesearchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namesearchComboBoxActionPerformed
        // TODO add your handling code here:
        
        String selectedResult = (String) namesearchComboBox.getSelectedItem();
        if (selectedResult != null) {
            // Set the selected result to the searchTextField
            membername_TextField.setText(selectedResult);
            namesearchComboBox.setVisible(false);
            try {
                show_members_details_by_name();
            } catch (SQLException ex) {
                Logger.getLogger(Add_Payment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_namesearchComboBoxActionPerformed

    private void namesearchComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namesearchComboBoxKeyPressed
        // TODO add your handling code here:
         String result=namesearchComboBox.getSelectedItem().toString();
        membername_TextField.setText(result);

        namesearchComboBox.setVisible(false);

    }//GEN-LAST:event_namesearchComboBoxKeyPressed

    private void mem_renewed_start_date_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mem_renewed_start_date_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mem_renewed_start_date_TextFieldActionPerformed

    private void duration_TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duration_TextFieldKeyReleased
        // TODO add your handling code here:
        boolean check=check_numeric_textfields(duration_TextField.getText());
            
            if (check=false) {
            duration_TextField.setText("");
        }else{
            calculate_fees();
            }
    }//GEN-LAST:event_duration_TextFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Exisiting_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exisiting_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exisiting_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exisiting_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exisiting_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addpayment_Button;
    private javax.swing.JTextField current_payment_TextField;
    private javax.swing.JTextField dateofjoin_TextField;
    private javax.swing.JComboBox<String> discount_ComboBox;
    private javax.swing.JTextField duration_TextField;
    private javax.swing.JTextField finalamount_TextField;
    private javax.swing.JComboBox<String> idSearchComboBox;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField mem_end_date_TextField;
    private javax.swing.JTextField mem_renewed_end_date_TextField;
    private javax.swing.JTextField mem_renewed_start_date_TextField;
    private javax.swing.JTextField mem_start_date_TextField;
    private javax.swing.JTextField member_id_TextField;
    private javax.swing.JTextField membername_TextField;
    private javax.swing.JComboBox<String> mobilenoSearchComboBox;
    private javax.swing.JTextField mobileno_TextField;
    private javax.swing.JComboBox<String> namesearchComboBox;
    private javax.swing.JTextField pendingamount_TextField;
    private javax.swing.JButton reset_Button;
    private javax.swing.JTextField totalfee_TextField;
    private javax.swing.JButton view_payment_history_Button;
    // End of variables declaration//GEN-END:variables
}
