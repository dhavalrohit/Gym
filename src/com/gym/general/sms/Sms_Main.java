
package com.gym.general.sms;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class Sms_Main extends javax.swing.JFrame {

    	Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
         Statement st=null;
	
         private int total_noo=0;
	 double deducted_blnce=0;
	 int no_of_character=0;
	 
    
    public Sms_Main() {
          FlatIntelliJLaf.registerCustomDefaultsSource("Flatlab.propeties");
          FlatIntelliJLaf.setup();
        
        initComponents();
    }

    public void get_all_numbers(){
        try {
             String url = "jdbc:sqlserver://DESKTOP-LB3RB8G\\SQLSERVER;databaseName=attendance_manager";
            String username = "sa";
            String password = "Dhaval@7869";
            String query="select phoneno as Mobile_no from dbo.Mst_Employee";
            
            DefaultTableModel table1 = (DefaultTableModel)jTable1.getModel();
		        	
            
             con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(query);
            rs=pst.executeQuery();
            String message=message_TextArea.getText();
            String number;
            int n=0;
            while (rs.next()) {
                number=rs.getString(1);
                table1.addRow(new Object[]{number,message});
                n=n+1;
            }
            total_mem_count_Label.setText(String.valueOf(n));
            total_mem_count_Label.setForeground(new java.awt.Color(32,161,93));
            
            
            
           
            
        } catch (Exception e) {
                e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(),"DATA FETCH ERROR","Inquiry History",JOptionPane.ERROR_MESSAGE);
        
        }finally{
               try {
                pst.close();
		rs.close();
		con.close();
                                   
            } catch (Exception e) {
            }
        }
        
    
    }
    
    
    public boolean check_number_textfield(String text){

      boolean result=true;
        
               if (text.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Mobile No Field is Empty","Mobile No Field Error",JOptionPane.ERROR_MESSAGE);
            result=false;
        }
        else{
            int len=text.length();
            for (int i = 0; i < len; i++) {
                if(Character.toString(text.charAt(i)).matches("^[0-9]+$")){
                    result=true;
                    continue;
                        
                    
            }else{
                    JOptionPane.showMessageDialog(new JFrame(), "Only Digits Allowed","Mobile No Field Error",JOptionPane.ERROR_MESSAGE);
                     System.out.println("Contains Alphabets");
                     result=false;
                     break;
                }}
        }
 return result;

}

 public boolean check_all_fields(boolean[] fields) {
    for (boolean field : fields) {
        if (!field) {
            return false; 
        }
    }
    return true; 
}
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        phone_no_TextField = new javax.swing.JTextField();
        add_Button = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        total_members_textLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        clear_Button = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        message_TextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        send_Button = new javax.swing.JButton();
        reset_Button = new javax.swing.JButton();
        cancel_Button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        char_count_Label = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        balance_count_Label = new javax.swing.JLabel();
        total_mem_count_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(32, 161, 93));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SMS SERVICE");
        jLabel1.setOpaque(true);

        add_Button.setBackground(new java.awt.Color(32, 161, 93));
        add_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        add_Button.setForeground(java.awt.Color.white);
        add_Button.setText("ADD");
        add_Button.setBorderPainted(false);
        add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ButtonActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(32, 161, 93));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton2.setForeground(java.awt.Color.white);
        jButton2.setText("IMPORT ALL CONTACTS");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("ENTER RECIPIENT'S NUMBER");

        total_members_textLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        total_members_textLabel.setText("TOTAL NUMBERS ADDED:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile No", "Message"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        updateButton.setBackground(new java.awt.Color(32, 161, 93));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        updateButton.setForeground(java.awt.Color.white);
        updateButton.setText("UPDATE");
        updateButton.setBorderPainted(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(32, 161, 93));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton4.setForeground(java.awt.Color.white);
        jButton4.setText("UPDATE ALL");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        clear_Button.setBackground(new java.awt.Color(32, 161, 93));
        clear_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        clear_Button.setForeground(java.awt.Color.white);
        clear_Button.setText("CLEAR ");
        clear_Button.setBorderPainted(false);
        clear_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_ButtonActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(32, 161, 93));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton6.setForeground(java.awt.Color.white);
        jButton6.setText("CLEAR ALL");
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        message_TextArea.setColumns(20);
        message_TextArea.setRows(5);
        message_TextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                message_TextAreaKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(message_TextArea);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("Compose Message:");

        send_Button.setBackground(new java.awt.Color(32, 161, 93));
        send_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        send_Button.setForeground(java.awt.Color.white);
        send_Button.setText("SEND");
        send_Button.setBorderPainted(false);
        send_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_ButtonActionPerformed(evt);
            }
        });

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

        cancel_Button.setBackground(new java.awt.Color(32, 161, 93));
        cancel_Button.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cancel_Button.setForeground(java.awt.Color.white);
        cancel_Button.setText("CANCEL");
        cancel_Button.setBorderPainted(false);
        cancel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_ButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Character Used");

        char_count_Label.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("Deducted Balance");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setText("Per SMS");

        balance_count_Label.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        total_mem_count_Label.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phone_no_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(add_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(total_members_textLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(total_mem_count_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(send_Button)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(reset_Button)
                                                .addGap(18, 18, 18)
                                                .addComponent(cancel_Button))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clear_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(balance_count_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(char_count_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone_no_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_Button)
                    .addComponent(jButton2)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total_members_textLabel)
                    .addComponent(total_mem_count_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(char_count_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(send_Button)
                        .addComponent(reset_Button)
                        .addComponent(cancel_Button))
                    .addComponent(balance_count_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        get_all_numbers();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void reset_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ButtonActionPerformed
        // TODO add your handling code here:
        jTable1.setModel(new DefaultTableModel(null, new String[] {"Number", "Message"}));
        total_mem_count_Label.setText(null);
	message_TextArea.setText(null);
	phone_no_TextField.setText(null);
        char_count_Label.setText(null);
        balance_count_Label.setText(null);
    }//GEN-LAST:event_reset_ButtonActionPerformed

    private void add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ButtonActionPerformed
        // TODO add your handling code here:
      
           String mobile_no=phone_no_TextField.getText();
        

        
       boolean mob_no_check = check_number_textfield(mobile_no);
       
       boolean[] checkallfields_for_mob_no={mob_no_check};
       
       boolean check_constraints=check_all_fields(checkallfields_for_mob_no);
       
        
        DefaultTableModel table1 = (DefaultTableModel)jTable1.getModel();
				  
				try {	 
					String phoneno=phone_no_TextField.getText();
					String msg=message_TextArea.getText();
					if(phoneno.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter a number");
					}
					else if(msg.equals("")) {
						JOptionPane.showMessageDialog(null, "Empty Message");
					}
                                        
                                        else if(check_constraints==true) {
					Long num=Long.parseLong(phoneno);
			        table1.addRow(new Object[]{num,msg});
			        total_noo=total_noo+1;
			        String ss=String.valueOf(total_noo);
			        
			        total_mem_count_Label.setText(ss);
					}
                                        else{
                         System.out.println("Invalid Fields");
                               }
                                        
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
    }//GEN-LAST:event_add_ButtonActionPerformed

    private void clear_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_ButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table1 = (DefaultTableModel)jTable1.getModel();
				int row=jTable1.getSelectedRow();
				if(row>0)
				{
					table1.removeRow(row);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Select at least one row");
				}
    }//GEN-LAST:event_clear_ButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row=jTable1.getSelectedRow();
				if(row>0)
				{
				String no=jTable1.getModel().getValueAt(row,0).toString();
				String msg=jTable1.getModel().getValueAt(row,1).toString();
				phone_no_TextField.setText(no);
				message_TextArea.setText(msg);
				}
				else {
					JOptionPane.showMessageDialog(jTable1, "Please select at least one row");
				}
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void message_TextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_message_TextAreaKeyTyped
        // TODO add your handling code here:
        
        String k=message_TextArea.getText();
				no_of_character=k.length();
				
				if((no_of_character%10)==0)
				{
					deducted_blnce=deducted_blnce+1;
					balance_count_Label.setText(String.valueOf(deducted_blnce));
					
				}
				else {
					balance_count_Label.setText(String.valueOf(deducted_blnce));
					deducted_blnce=deducted_blnce+0.10;
					
				}
				char_count_Label.setText(String.valueOf(no_of_character));
				
				
    }//GEN-LAST:event_message_TextAreaKeyTyped

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table1 = (DefaultTableModel)jTable1.getModel();
				 int row= jTable1.getSelectedRow();
				 if(row>0)
				 {
				 table1.setValueAt(phone_no_TextField.getText(), row, 0);
				 table1.setValueAt(message_TextArea.getText(), row, 1);
				 }
				 else
				 {
					JOptionPane.showMessageDialog(new JFrame(), "Please Select Row to Update");
				 }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_ButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancel_ButtonActionPerformed

    private void send_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_ButtonActionPerformed
        // TODO add your handling code here:
        int p=JOptionPane.showConfirmDialog(null,"Are you sure to send message" , "Sending Message Confirmation", JOptionPane.YES_NO_OPTION);
				if(p==0)
				{
					JOptionPane.showMessageDialog(null, "Messages are sending");

					DefaultTableModel table1 = (DefaultTableModel)jTable1.getModel();
						
					for (int i = 0; i < table1.getRowCount(); i++) {
						System.out.println(table1.getValueAt(i, 0));
						System.out.println(table1.getValueAt(i, 1));
						sendSMS(table1.getValueAt(i, 0).toString() , table1.getValueAt(i, 1).toString());
					}
					  
					  
				}
				else {
					System.out.println("2");
				}
    }//GEN-LAST:event_send_ButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    	public void sendSMS(String mobileNUmbers,String message){
	try 
    {
		String username = "ssakah";
		String password = "8460815408";
        String data = "user=" + URLEncoder.encode(username, "UTF-8");
        data += "&password=" + URLEncoder.encode(password, "UTF-8");
        data += "&message=" + URLEncoder.encode(message, "UTF-8");
        data += "&sender=" + URLEncoder.encode("FITNESS-HUB", "UTF-8");
        data += "&mobile=" + URLEncoder.encode(mobileNUmbers , "UTF-8");
        data += "&type=" + URLEncoder.encode("3", "UTF-8");
        // Send data
        URL url = new URL("https://login.bulksmsgateway.in/sendmessage.php");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();
        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        String sResult="";
        while ((line = rd.readLine()) != null) 
        {
              // Process line...
              sResult=sResult+line+" ";
        }
        wr.close();
        rd.close();
         System.out.println("sResult="+sResult);
        } 
        catch (Exception e) 
        {
               System.out.println("Error SMS "+e);
                
        }
	}
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
            java.util.logging.Logger.getLogger(Sms_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sms_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sms_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sms_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sms_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_Button;
    private javax.swing.JLabel balance_count_Label;
    private javax.swing.JButton cancel_Button;
    private javax.swing.JLabel char_count_Label;
    private javax.swing.JButton clear_Button;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea message_TextArea;
    private javax.swing.JTextField phone_no_TextField;
    private javax.swing.JButton reset_Button;
    private javax.swing.JButton send_Button;
    private javax.swing.JLabel total_mem_count_Label;
    private javax.swing.JLabel total_members_textLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
