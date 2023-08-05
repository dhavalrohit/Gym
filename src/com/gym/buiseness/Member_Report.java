/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.buiseness;

import java.awt.EventQueue;
import java.io.File;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.gym.database.Connect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.DataUtilities;
import org.jfree.data.*;
import org.jfree.chart.*;
import org.jfree.chart.util.*;

public class Member_Report extends JFrame{
    Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	 int no_female=0;
	 int no_male=0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Member_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Member_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Member_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Member_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Member_Report frame = new Member_Report();
                                       // JavaApplication2 frame=new JavaApplication2("Member Report");
					//frame.setVisible(true);
                                         //frame.pack();
        //RefineryUtilities.centerFrameOnScreen(frame);
        //frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
    @SuppressWarnings("static-access")
	public void get_rep()
	{
		try {
		con=Connect.connectDb();
		String sql="Select gender from members";
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next())
		{
			if(rs.getString(1).equals("Female"))
			{
				no_female=no_female+1;
			}
			else
			{
				no_male=no_male+1;
			}
		}
		int total_no=no_female+no_male;
				
	   
                DefaultPieDataset dataset = new DefaultPieDataset( );
               
               
             dataset.setValue("Female", no_female);
	    dataset.setValue("Male", no_male);
	   dataset.setValue("Due Members", 4);
                
          
	    
	      // create the chart...
           /*   
	    JFreeChart chart = ChartFactory.createPieChart(
	        "Members Report",   // chart title           
	        dataset,          // data           
	        true,             // include legend          
	         true,           
	        false );*/

	      int width = 560;    /* Width of the image */
	      int height = 370;   /* Height of the image */ 
	  	//ChartFrame frame=new ChartFrame("Deep Da Gym ||Reports ", chart);
		
		
		//frame.setVisible(true);
		//frame.setSize(600,600);
		//frame.setLocationRelativeTo(this);
	    File pieChart = new File( "Members_Reports.jpeg" );
	   // ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
/*public Member_Report( String a) {
		super(a);
			get_rep();
			this.hide();
		
	}*/
}
