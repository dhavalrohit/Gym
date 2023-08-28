
package com.gym.database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Connect {
    Connection con=null;
        Connection conaccess=null;
	public static Connection connectDb()
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_mgmt_system","root","admin");
		 return con;
		 }
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
        public static Connection connectaccessDb()
	{
		try {
		//Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 Connection conaccess=DriverManager.getConnection("jdbc:ucanaccess://E:\\biometric\\ARMS.mdb;password=arms2721954");
		 //Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E:\\biometric\\ARMS.mdb;jackcessOpener=com.gym.classes.Test$CryptCodecOpener","Admin","arms2721954");
                                
                 System.out.print("connected");
                 return conaccess;
                 //return conn;
		 }
		catch(Exception e)
		{
                    System.out.print(e);
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public static void main(String[] args) {
		Connect c= new Connect();
		//c.connectDb();
                c.connectaccessDb();
}

}
