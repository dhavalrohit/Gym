package com.gym.general.attendance;


import com.gym.general.attendance.advance.Attendance_Advanced_Search_Main;
import com.gym.general.attendance.month.Attendance_Month_Main;
import com.gym.general.attendance.threemonth.Attendance_threeMonths_Main;
import com.gym.general.attendance.week.*;
import com.gym.general.main.*;
import com.gym.general.component.Header;
import com.gym.general.component.Menu;
import com.gym.general.event.EventMenuSelected;
import com.gym.general.event.EventShowPopupMenu;
import com.gym.general.fees.Add_Payment;
import com.gym.general.fees.Exisiting_Member;
import com.gym.general.fees.fees_payment_history;
import com.gym.general.form.Form1;
import com.gym.general.form.Form_Home;
import com.gym.general.form.MainForm;
import com.gym.general.members.Add_Member;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gym.general.swing.MenuItem;
import com.gym.general.swing.PopupMenu;
import com.gym.general.swing.icon.GoogleMaterialDesignIcons;
import com.gym.general.swing.icon.IconFontSwing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class AttendanceNew extends javax.swing.JFrame {

    private MigLayout layout;
    private attendanceMenu menu;
    private Header header;
    private AttendanceMainForm main1;
    private Animator animator;
    private static AttendanceNew main_obj;
    
    public AttendanceNew() throws SQLException, IOException {
        initComponents();
        init();
    }
    
  

    private void init() throws SQLException, IOException {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new attendanceMenu();
        header = new Header();
        main1 = new AttendanceMainForm();
        menu.addEvent(new EventMenuSelected() {
            
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Attendance Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        try {
                            main1.showForm(new AttendanceForm());
                            
                            //form=new AttendanceForm();
                            //form.initTableData();
                           
                        } catch (SQLException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AttendanceNew.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(new JFrame(), "Connection File Error");
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
                         Attendance_Week_Main aa = null;
                        try {
                           aa=new Attendance_Week_Main();
                        } catch (SQLException ex) {
                            Logger.getLogger(AttendanceNew.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AttendanceNew.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(new JFrame(), "Connection File Error");
                        }
                        aa.setVisible(true);
                    }
                }
                
                if (menuIndex==1) {
                    if (subMenuIndex==-1) {
                         Attendance_Month_Main aa = null;
                        try {
                           aa=new Attendance_Month_Main();
                        } catch (SQLException ex) {
                            Logger.getLogger(AttendanceNew.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AttendanceNew.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(new JFrame(), "Connection File Error");
                        }
                        aa.setVisible(true);
                    }
                }
                
                 if (menuIndex==2) {
                    if (subMenuIndex==-1) {
                         Attendance_threeMonths_Main aa = null;
                        try {
                           aa=new Attendance_threeMonths_Main();
                        } catch (SQLException ex) {
                            Logger.getLogger(AttendanceNew.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AttendanceNew.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(new JFrame(), "Connection File Error");
                        }
                        aa.setVisible(true);
                    }
                }
                 
                 if (menuIndex==3) {
                    if (subMenuIndex==-1) {
                         Attendance_Advanced_Search_Main aa = null;
                        try {
                           aa=new Attendance_Advanced_Search_Main();
                        } catch (SQLException ex) {
                            Logger.getLogger(AttendanceNew.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        aa.setVisible(true);
                    }
                } 
                
                if (menuIndex==4) {
                    if (subMenuIndex==-1) {
                        dispose();;
                    }
                    
                }
                
                
                
                
               
                
            }
        }); 
        
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(AttendanceNew.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = AttendanceNew.this.getX() + 52;
                int y = AttendanceNew.this.getY() + com.getY() + 86;
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
        main1.showForm(new AttendanceForm());
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);
        bg.setPreferredSize(new java.awt.Dimension(1366, 768));

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
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AttendanceNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // new Main().setVisible(true);
                    main_obj=new AttendanceNew();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(AttendanceNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AttendanceNew.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(new JFrame(), "Connection File Error");
                }
               main_obj.setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
