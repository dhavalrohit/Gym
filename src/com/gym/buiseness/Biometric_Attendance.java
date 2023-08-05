/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.buiseness;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author DELL
 */
public class Biometric_Attendance extends JFrame{
    private JPanel contentPane;
    //JPanel contentPane;
    Process pro;
    public static void main(String[] args) {
		
        
        
		try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Biometric_Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biometric_Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biometric_Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biometric_Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biometric_Attendance frame = new Biometric_Attendance();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    public Biometric_Attendance() throws IOException,
                           AWTException, InterruptedException {
		//setTitle("Fitness Hub || Adding New Member");
		//setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(10, 10, 1300, 700);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		//contentPane.setLayout(null);
                //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //try{rss
                    //Process p rss= Runtime.getRuntime().exec("C:\\Program Files (x86)\\realtime_biometrics\\Realsoft11.6\\Realsoft11.6.exe");
              //  }
               // catch(IOException e)
               // {
                   // e.printStackTrace();
               // }
               try{
                    
                    pro = Runtime.getRuntime().exec("C:\\Program Files (x86)\\realtime_biometrics\\Realsoft11.6\\Realsoft11.6.exe");
                    
               }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                Robot robot = new Robot();
 
        // Press keys using robot. A gap of
        // of 500 milli seconds is added after
        // every key press
        
        //Login to realsoft
        robot.mouseMove(630, 380); 
         Thread.sleep(1000);
         System.out.println("login start");
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           // Thread.sleep(200); // Click one second
           //System.out.println("Browse button press");
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           // System.out.println("Browse button clicked");
            Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_R);
         Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_S);
         Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_S);
        
        robot.mouseMove(630, 400);
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           // Thread.sleep(200); // Click one second
          // System.out.println("Browse button press");
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            //System.out.println("Browse button clicked");
            Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_R);
         Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_S);
         Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_S);
        
         Thread.sleep(2000);
          robot.mouseMove(650, 460);
       Thread.sleep(2000);
          robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(500); // Click one second
          // System.out.println("Browse button press");
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           // System.out.println("Browse button clicked");  
             Thread.sleep(1000);
             //login completerss
             System.out.println("login complete");  
			 
			  System.out.println("Data Transfer start");  
             //data Transfer
            /* robot.mouseMove(185, 75);
              Thread.sleep(2000);
              robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
             robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
               Thread.sleep(2000);*/
               
               
                robot.mouseMove(185, 75);
              Thread.sleep(2000);
              robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
             robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
               Thread.sleep(2000);
               
              
                System.out.println("date set");
                robot.mouseMove(640, 330);
              Thread.sleep(2000);
              robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
             Thread.sleep(2000);
             
             robot.mouseMove(558,361);
              Thread.sleep(2000);
              robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                Thread.sleep(2000);
             
             
            robot.mouseMove(640,510);
              Thread.sleep(2000);
              robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                Thread.sleep(2000);
                System.out.println("date set complete");
                
                
                
                 System.out.println("start connect"); 
                robot.mouseMove(400, 650);
              Thread.sleep(2000);
              robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
             //robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           //Thread.sleep(200); // Click one second
            //robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
               Thread.sleep(6000);
               
               
               
                System.out.println("complete connect"); 
                
               System.out.println("Data download"); 
               robot.mouseMove(480, 650);
              Thread.sleep(2000);
              robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
             //robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           //Thread.sleep(200); // Click one second
            //robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
               Thread.sleep(10000);
               
               
               
               System.out.println("Data download complete"); 
               
              // Thread.sleep(5000);
               //exit data Transfer exit
               robot.mouseMove(996, 156);
                 Thread.sleep(200);
              robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(2000);
          //robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
          // Thread.sleep(200); // Click one second
           // robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            // robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
          // Thread.sleep(200); // Click one second
           // robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           // Thread.sleep(1000);
          //robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
          // Thread.sleep(200); // Click one second
           // robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
			System.out.println("Data Transfer complete"); 
                        
              System.out.println("Data Processing"); 
              Thread.sleep(2000);
              robot.mouseMove(295, 75);
              Thread.sleep(2000);
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200);
           robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(2000);
           
            robot.mouseMove(445, 195);
              Thread.sleep(2000);
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200);
           
            robot.mouseMove(438, 265);
              Thread.sleep(2000);
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200);
           
           robot.mouseMove(375, 290);
              Thread.sleep(2000);
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200);
           
           robot.mouseMove(445, 400);
              Thread.sleep(2000);
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200);
           
           robot.mouseMove(620, 429);
              Thread.sleep(2000);
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(10000);
           
           robot.mouseMove(750, 450);
              Thread.sleep(2000);
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(1000);
           
           
           robot.mouseMove(1015, 138);
              Thread.sleep(2000);
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200);
              System.out.println("Data Processing complete"); 
                        
                        
                        
                        
                        
                        
                        
                        
                        
             
			 System.out.println("Data backup start");
            //Data Backup 
             robot.mouseMove(380, 30);
              Thread.sleep(2000);
         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200);
            
           robot.mouseMove(380, 140);
           Thread.sleep(200);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200);
           
           robot.mouseMove(650, 480);
            Thread.sleep(200);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(5000);
           
           
           robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(4000);
           
           robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(2000);
           
           robot.mouseMove(780, 450);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(2000);
           
           robot.mouseMove(780, 480);
           robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
           robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(2000);
             //Data backup complete
			 System.out.println("Data backup complete");
            // pro.destroy();
             //Exit processrss
            robot.mouseMove(930, 75);
              Thread.sleep(1000);
          robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
             robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(1000);
          robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
           Thread.sleep(200); // Click one second
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            dispose();
		pro.destroyForcibly();
                setVisible(false);
				System.out.println("exit");
            //exit process complete
           // Thread.sleep(2000);
                    //p.destroy();
           
             
    }
    
}
