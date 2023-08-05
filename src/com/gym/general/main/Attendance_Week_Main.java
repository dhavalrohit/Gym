/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.general.main;

import com.gym.general.attendance.AttendanceForm;
import com.gym.general.attendance.AttendanceMainForm;
import com.gym.general.attendance.AttendanceWeekMainForm;
import com.gym.general.attendance.attendanceMenu;
import com.gym.general.attendance.attendanceWeekRecord;
import com.gym.general.attendance.attendanceweekmenu;
import com.gym.general.component.Header;
import com.gym.general.event.EventMenuSelected;
import com.gym.general.event.EventShowPopupMenu;
import com.gym.general.form.Form1;
import com.gym.general.swing.Menuitem;
import com.gym.general.swing.PopupMenu;
import com.gym.general.swing.icon.GoogleMaterialDesignIcons;
import com.gym.general.swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author DELL
 */
public class Attendance_Week_Main extends javax.swing.JFrame{
     private MigLayout layout;
    private attendanceweekmenu menu;
    private Header header;
    private AttendanceWeekMainForm main1;
   
    private Animator animator;
    private attendanceWeekRecord form;
    private static Attendance_Week_Main attendance_obj;
      
    public Attendance_Week_Main() throws SQLException {
        initComponents();
        init();
    }
    
    
  
    
    private void init() throws SQLException {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new attendanceweekmenu();
        header = new Header();
        main1 = new AttendanceWeekMainForm();
        
        menu.addEvent(new EventMenuSelected() {
            
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Week Attendance Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        try {
                            main1.showForm(new attendanceWeekRecord());
                            
                            //form=new AttendanceForm();
                            //form.initTableData();
                           
                        } catch (SQLException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (subMenuIndex == 1) {
                        main1.showForm(new Form1());
                    }
                }
                
                
                
                /*if (menuIndex==0) {
                    if (subMenuIndex==-1) {
                        try {
                            form=new AttendanceForm();
                            form.initTableData();
                        } catch (SQLException ex) {
                            Logger.getLogger(AttendanceNew.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }*/
                
                if (menuIndex==0) {
                    if (subMenuIndex==-1) {
                       dispose();
                    }
                    
                }
                
                
                
                
               
                
            }
        });
        
       /* menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    if (menuIndex==13 && subMenuIndex==-1) {
                        main_obj.dispose();
                }
                }
        });
        */
        
        
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                Menuitem item = (Menuitem) com;
                 PopupMenu popup = new PopupMenu(Attendance_Week_Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                
                int x = Attendance_Week_Main.this.getX() + 52;
               
                int y = Attendance_Week_Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        
        bg.add(main1, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main1.showForm(new attendanceWeekRecord());
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

       
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

       
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        
    
    
    
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
            java.util.logging.Logger.getLogger(Attendance_Week_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance_Week_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance_Week_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance_Week_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // new Main().setVisible(true);
                    attendance_obj=new Attendance_Week_Main();
                } catch (SQLException ex) {
                    Logger.getLogger(Attendance_Week_Main.class.getName()).log(Level.SEVERE, null, ex);
                }
               attendance_obj.setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLayeredPane bg;
    // End of variables declaration           }
}
