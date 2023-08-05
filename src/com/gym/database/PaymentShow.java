/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.database;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author DELL
 */
public class PaymentShow extends JFrame{
      Connection con=null;
	 ResultSet rs=null;
	 PreparedStatement pst=null;
	 
	public JButton btnUpdatep,btnNewp,btnDeletep;
	private JPanel contentPanePm;
	private JTable Pay_Table;
	private JTextField txtSearchm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show_All frame = new Show_All();
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

    
    
    
    
    
    
}
