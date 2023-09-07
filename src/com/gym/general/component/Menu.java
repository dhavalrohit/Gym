package com.gym.general.component;

import com.gym.general.event.EventMenu;
import com.gym.general.event.EventMenuSelected;
import com.gym.general.event.EventShowPopupMenu;
import com.gym.general.model.ModelMenu;
import com.gym.general.swing.MenuAnimation;
import com.gym.general.swing.MenuItem;
import com.gym.general.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

     private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    
    
    
    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }
    
    
    

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

   

    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
        
        
        
        
    }

    public void initMenuItem() {
         addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/1.png")), "Dashboard", "Home",  "Attendance"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/2.png")), "Members", "Add New Member", "Delete Member","Update Member Details","Search/View Members Details"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/3.png")), "Fees", "Fees Detail", "Add Fees/Duration","Update Fees/Duration"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/4.png")), "Payments", "Add New Member Payments", "Renew Membership/Add Payments","Show Payment History"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/5.png")), "Body Measurments", "BMI/Fat Calculator","Body Measurement Form"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/6.png")), "Diet Planner"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/7.png")), "Workout", "Create Workout", "Show Added Workouts"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/8.png")), "History", "Attendance History", "Payment History","Inquiry History"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/10.png")), "Inquiry", "Add Inquiry", "Inquiry History"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/12.png")), "Help", "About","Update Software", "How To?"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/13.png")), "Account","Log Out","Update Accounts"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/gym/general/icon/close.png")), "Close"));
   
    }

    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile1 = new com.gym.general.component.Profile();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(33, 105, 249), getWidth(), 0, new Color(93, 58, 196));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private com.gym.general.component.Profile profile1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
