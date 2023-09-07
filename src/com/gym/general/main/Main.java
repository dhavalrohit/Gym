package com.gym.general.main;

import com.gym.controller.Add_Fees;
import com.gym.general.attendance.AttendanceNew;
import com.gym.general.bmi.Body_Measurment_Card;
import com.gym.general.bmi.bmi_main;
import com.gym.general.component.Header;
import com.gym.general.component.Menu;
import com.gym.general.diet.diet_main;
import com.gym.general.event.EventMenuSelected;
import com.gym.general.event.EventShowPopupMenu;
import com.gym.general.fees.Add_Payment;
import com.gym.general.form.Form1;
import com.gym.general.form.Form_Home;
import com.gym.general.form.MainForm;
import com.gym.general.members.Add_Member;
import com.gym.general.members.Delete_Member;
import com.gym.general.swing.MenuItem;
import com.gym.general.swing.PopupMenu;
import com.gym.general.swing.icon.GoogleMaterialDesignIcons;
import com.gym.general.swing.icon.IconFontSwing;
import com.itextpdf.text.log.Logger;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import com.gym.general.fees.Exisiting_Member;
import com.gym.general.fees.Fee_Detail;
import com.gym.general.fees.fees_payment_history;
import com.gym.general.fees.update_fees;
import com.gym.general.inquiry.inquiry_form;
import com.gym.general.inquiry.inquiry_history;
import com.gym.general.login.login_main;
import com.gym.general.members.Edit_Update_Member;
import com.gym.general.members.View_Member;
import com.gym.general.workout.Workout_Creator;
import com.gym.general.workout.added_workouts;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    private static Main main_obj;
    
    public Main() {
        initComponents();
        init();
    }
    
  

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Dashboard Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        try {
                            main.showForm(new Form_Home());
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    } 
                }
                if (menuIndex==11) {
                    if (subMenuIndex==-1) {
                         dispose();
                    }
                    
                }
                if (menuIndex==0) {
                    if (subMenuIndex==1) {
                        AttendanceNew aa = null;
                        try {
                             aa=new AttendanceNew();
                        } catch (Exception e) {
                            e.printStackTrace();
                            
                        }
                        aa.setVisible(true);
                    }
                }
                
                if (menuIndex==1) {
                    if (subMenuIndex==0) {
                        Add_Member add=null;
                        try {
                            add=new Add_Member();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        add.setVisible(true);
                    }
                }
                if (menuIndex==1) {
                    if (subMenuIndex==1) {
                        Delete_Member add=null;
                        try {
                             add=new Delete_Member();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        add.setVisible(true);
                    }
                }
                
                if (menuIndex==1) {
                    if (subMenuIndex==2) {
                        Edit_Update_Member add=null;
                        try {
                             add=new Edit_Update_Member();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        add.setVisible(true);
                    }
                }
                if (menuIndex==1) {
                    if (subMenuIndex==3) {
                        View_Member add=null;
                        try {
                             add=new View_Member();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        add.setVisible(true);
                    }
                }
                
                if (menuIndex==2) {
                    if (subMenuIndex==0) {
                        Fee_Detail fee=null;
                        try {
                            fee=new Fee_Detail();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        fee.setVisible(true);
                    }
                }
                if (menuIndex==2) {
                    if (subMenuIndex==1) {
                        Add_Fees fee=null;
                        try {
                            fee=new Add_Fees();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        fee.setVisible(true);
                    }
                }
                if (menuIndex==2) {
                    if (subMenuIndex==2) {
                        update_fees fee=null;
                        try {
                            fee=new update_fees();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        fee.setVisible(true);
                    }
                }
                
                
                
                if (menuIndex==3) {
                    if (subMenuIndex==0) {
                        Add_Payment add=null;
                        try {
                              add=new Add_Payment();
                             add.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                
                if (menuIndex==3) {
                    if (subMenuIndex==1) {
                         Exisiting_Member add=null;
                        try {
                             add=new Exisiting_Member();
                             add.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                
                if (menuIndex==3) {
                    if (subMenuIndex==2) {
                        fees_payment_history add=null;
                        try {
                             add=new fees_payment_history();
                             add.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                
                if (menuIndex==4) {
                    if (subMenuIndex==0) {
                        bmi_main bmi=null;
                        try {
                             bmi=new bmi_main();
                             bmi.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                
                if (menuIndex==4) {
                    if (subMenuIndex==1) {
                        Body_Measurment_Card bmi=null;
                        try {
                             bmi=new Body_Measurment_Card();
                             bmi.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                
                if (menuIndex==5) {
                    if (subMenuIndex==-1) {
                        diet_main diet=null;
                        try {
                             diet=new diet_main();
                             diet.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                if (menuIndex==6) {
                    if (subMenuIndex==0) {
                        Workout_Creator wrk=null;
                        try {
                             wrk=new Workout_Creator();
                             wrk.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                if (menuIndex==6) {
                    if (subMenuIndex==1) {
                        added_workouts wrk=null;
                        try {
                             wrk=new added_workouts();
                             wrk.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                
                if (menuIndex==7) {
                    if (subMenuIndex==0) {
                        AttendanceNew att=null;
                        try {
                             att=new AttendanceNew();
                             att.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                
                if (menuIndex==7) {
                    if (subMenuIndex==0) {
                        AttendanceNew att=null;
                        try {
                             att=new AttendanceNew();
                             att.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                
                if (menuIndex==7) {
                    if (subMenuIndex==1) {
                        fees_payment_history pay=null;
                        try {
                             pay=new fees_payment_history();
                             pay.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                if (menuIndex==7) {
                    if (subMenuIndex==2) {
                        inquiry_history inq=null;
                        try {
                             inq=new inquiry_history();
                             inq.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                    }
                    
                }
                
                if (menuIndex==8) {
                    if (subMenuIndex==0) {
                        inquiry_form inq=null;
                        try {
                             inq=new inquiry_form();
                             inq.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (menuIndex==8) {
                    if (subMenuIndex==1) {
                        inquiry_history inq=null;
                        try {
                             inq=new inquiry_history();
                             inq.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                
                if (menuIndex==10) {
                    if (subMenuIndex==0) {
                        login_main log=null;
                        try {
                             log=new login_main();
                             log.setVisible(true);
                             dispose();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
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
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                
                int x = Main.this.getX() + 52;
               
                int y = Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        
        bg.add(main, "w 100%, h 100%");
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
        try {
            //  Start with this form
            main.showForm(new Form_Home());
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void setroletext(String text){
        header.setrole_text(text);
    }
    
    public void setusernametest(String text){
        header.setusername_text(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               // new Main().setVisible(true);
               main_obj=new Main();
               main_obj.setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
