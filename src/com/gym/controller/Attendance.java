/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.controller;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.RepaintManager;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author DELL
 */
public class Attendance extends JPanel implements ActionListener{
    Connection conn;
        Statement stmt,stmtdel;
        ResultSet rs;
        String url;     
        
        int nrows,reply,response,stmtval,flag;

        Border border;

        Color c1=new Color(255,146,34);
        Color c2=new Color(251,254,120);//yellow
        Color c3=new Color(140,140,255);//Sky blue
        Color c4=new Color(120,120,230);
        Color c5=new Color(190,190,240);
        Color c6=new Color(147,255,174);//Light Green

        Font f1=new Font("Times New Roman",Font.BOLD,40);
        Font f2=new Font("Times New Roman",Font.BOLD,14);
        Font f3=new Font("Times New Roman",Font.BOLD,18);
        Font f4=new Font("Times New Roman",Font.BOLD,12);
        Font f5=new Font("Times New Roman",Font.BOLD,11);
        Font f6=new Font("COMIC SANS MS",Font.BOLD,22);
        Font fp=new Font("Times New Roman",Font.BOLD,45);
        Font fp1=new Font("COMIC SANS SERIF",Font.BOLD,30);

        JPanel pa,p1,p2;
        JButton btn_view,btn_exit;
        CardLayout cardView;
        String strview,strsel,strviewval;
        ViewRcrdClass vrd;

        public Attendance()
        {
                setBackground(c5);
                pa=new JPanel();
                p1=new JPanel();
                p2=new JPanel();

                pa.setBackground(c5);
                p1.setBackground(c5);
                p2.setBackground(c5);

                cardView=new CardLayout();
                pa.setLayout(cardView);

                setLayout(null);

                JLabel lbl_view=new JLabel("View Records");
                lbl_view.setBounds(350,20,350,30);
                lbl_view.setFont(f6);
                p1.add(lbl_view);                                                        

                p2.setLayout(null);

                //JButton View Records
                btn_view=new JButton("View Records");
                btn_view.setMnemonic(KeyEvent.VK_V);
                btn_view.setToolTipText("View Records");
                btn_view.setMnemonic('v');
                btn_view.addActionListener(this);
                
                btn_view.setBackground(c5);
                btn_view.setBounds(310,80,130,30);
                p2.add(btn_view);

                //JButton Exit
                btn_exit=new JButton("Exit");                                                
                btn_exit.setBackground(c5);                                                                                                                                                              
                btn_exit.setBounds(450,80,100,30);
                btn_exit.setMnemonic(KeyEvent.VK_X);
                btn_exit.setToolTipText("Exit");
                btn_exit.setMnemonic('x');
                btn_exit.addActionListener(this);
                p2.add(btn_exit);                                                                

                pa.setLayout(cardView);
                setLayout(new BorderLayout());
                add(p1,"North");
                add(p2,"Center");
        }
        public void actionPerformed(ActionEvent ae)
                     {
                if(ae.getSource()==btn_view)
                {
                        vrd=new ViewRcrdClass("View Records");
                        vrd.setSize(800,600);
                        vrd.setVisible(true);
                        vrd.setLocation(50,50);
                        vrd.setBackground(c5);                        
                }
                if(ae.getSource()==btn_exit)
               {
                        reply=JOptionPane.showConfirmDialog(null,"Do you Quit the Application ?");
                        if(reply==JOptionPane.YES_OPTION)
                        {                                                       
                                System.exit(0);                                
                        }                                       
                        if(reply==JOptionPane.NO_OPTION)
                        {                                               
                                return;
                        }       
                }
                }
                     
                
                
        //____________________________________________________________________
        /*                     START THE ViewRcrdClass Class                */
        //--------------------------------------------------------------------
        class ViewRcrdClass extends JFrame implements ActionListener,Printable
        {
                Container c;                                                
                private Component comToBePrinted;
                JMenuBar mnubar;
                JMenu mnu_print;
                JMenuItem mnuitem_print,mnuitem_exit;
                
               
               
                public ViewRcrdClass(String title)
               
               {
                        super(title);
                        c=getContentPane();
                        c.setBackground(c5);
                        mnubar=new JMenuBar();
                        mnubar.setBackground(c3);
                        setJMenuBar(mnubar);
                                
                        mnu_print=new JMenu("Print");
                        mnu_print.setBackground(c3);
                        mnu_print.setMnemonic('P');

                        Icon icon_print=new ImageIcon("images/printer.jpg");                                                
                        mnuitem_print=new JMenuItem("Print   ",icon_print);
                        mnuitem_print.setAccelerator( KeyStroke.getKeyStroke("ctrl P"));
                        mnuitem_print.addActionListener(this);                                
                        mnuitem_print.setBackground(c5);
                        mnu_print.addSeparator();

                        Icon icon_exit=new ImageIcon("images/exit.jpg");
                        mnuitem_exit=new JMenuItem("Exit   ",icon_exit);
                        mnuitem_exit.setAccelerator( KeyStroke.getKeyStroke("ctrl X"));
                        mnuitem_exit.addActionListener(this);
                        mnuitem_exit.setBackground(c5);

                        mnubar.add(mnu_print);
                        mnu_print.add(mnuitem_print);
                        mnu_print.add(mnuitem_exit);

                        //Calling the View_ClassesRecords() Method
                        View_ClassesRecords();                                
                }
                
                
                public void actionPerformed(ActionEvent ae)
                {
                        if(ae.getSource()==mnuitem_print)
                        {                                       
                               // PrintableDocument.printComponent(this);
                        }
                        if(ae.getSource()==mnuitem_exit)
                        {
                                reply=JOptionPane.showConfirmDialog(null,"Do you Quit the Application ?");
                                setBackground(c5);
                                if(reply==JOptionPane.YES_OPTION)
                                {
                                        vrd.setVisible(false);
                                }                                       
                                if(reply==JOptionPane.NO_OPTION)
                                {                                               
                                      return;
                                }                                                                                       
                        }
                }
                //THIS METHOD IS USED FOR PRINTING ONTO PRINTER
                public void printComponent(Component c)
                {
                       // new PrintableDocument(c).print();
                }
                public void PrintableDocument(Component comToBePrinted)
                {
                        this.comToBePrinted=comToBePrinted;
                }
                public void print()
                {
                        PrinterJob printJob=PrinterJob.getPrinterJob();
                        printJob.setPrintable(this);
                        if(printJob.printDialog())
                        try
                        {
                               printJob.print();
                        }
                        catch(PrinterException pe)
                        {
                                System.out.println(pe.getMessage());
                        }
                }
                public int print(Graphics g,PageFormat pageFormat, int pageIndex)
                {
                        if(pageIndex>0)
                        {
                                return(NO_SUCH_PAGE);
                        }
                        else
                        {
                                Graphics2D g2d=(Graphics2D)g;
                                g2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
                                disableDoubleBuffering(comToBePrinted);
                                comToBePrinted.paint(g2d);
                                enableDoubleBuffering(comToBePrinted);
                                return(PAGE_EXISTS);
                        }                                
                }
                public void disableDoubleBuffering(Component c)
                {
                        RepaintManager currentManager=RepaintManager.currentManager(c);
                        currentManager.setDoubleBufferingEnabled(false);
                }
                public void enableDoubleBuffering(Component c)
                {
                        RepaintManager currentManager=RepaintManager.currentManager(c);
                        currentManager.setDoubleBufferingEnabled(true);
                }
                //_____________________________________________________________________________
                /* Call the View_ClassesRecords() Which Shows all Records of Students */
                //-----------------------------------------------------------------------------
                public void View_ClassesRecords ()
                {
                        c.setLayout(new BorderLayout());
                        c.setBackground(c5);                                
                        JPanel p1=new JPanel();                                
                        p1.setBackground(c5);                                
                        JLabel schoolname=new JLabel("View Records",SwingConstants.CENTER);
                        schoolname.setFont(f6);
                        schoolname.setForeground(Color.black);                                
                        p1.add(schoolname);
                        c.add(p1,"North");                                                                

                        try
                        {
                                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                //String s="jdbc:ucanaccess://e://biometric//ARMS.mdb";
                                 conn=DriverManager.getConnection("jdbc:ucanaccess://E:\\bio\\ARMS.mdb;jackcessOpener=com.gym.classes.Test$CryptCodecOpener","Admin","arms2721954");
                                Statement stmt1=conn.createStatement();
                                ResultSet rs1=stmt1.executeQuery("Select * From RawPunchDetail");
                                ResultSetMetaData rsm=rs1.getMetaData();
                                int rows=0;
                                while(rs1.next())
                                {
                                       rows=rows+1;
                                }
                                rs1.close();
                                stmt1.close();
                                Statement stmt2=conn.createStatement();                                
                                ResultSet rs2=stmt2.executeQuery("Select * From RawPunchDetail");
                                final String[] colheads={"ID","EmpCode","CardNo","Datetrn","InTime","OutTime","McNo"};                                        
                                String data[][]=new String[rows][15];
                                int i=-1;
                                while(rs2.next())
                                {
                                        i=i+1;
                                        for(int k=0;k<=11;k++)
                                        {
                                                String str1=String.valueOf(rs2.getInt("ID"));
                                                String str2=rs2.getString("EmpCode");
                                                String str3=rs2.getString("CardNo");
                                                String str4=rs2.getString("Datetrn");
                                                String str5=rs2.getString("InTime");
                                                String str6=rs2.getString("OutTime");
                                                String str7=rs2.getString("McNo");
                                                //String strd=rs2.getString("DOB");
                                                //String str8=rs2.getString("Sex");
                                                //String str9=rs2.getString("Address");
                                                //String str10=rs2.getString("City");
                                                //String str11=rs2.getString("State");
                                                //String str12=rs2.getString("Phone_No");
                                                //String str13=rs2.getString("Mobile_No");
                                                                                                               
                                                data[i][k]=str1;     k=k+1;
                                                data[i][k]=str2;     k=k+1;
                                                data[i][k]=str3;     k=k+1;
                                                data[i][k]=str4;     k=k+1;
                                                data[i][k]=str5;     k=k+1;
                                                data[i][k]=str6;     k=k+1;
                                                data[i][k]=str7;     k=k+1;
                                                //data[i][k]=strd;     k=k+1;
                                                //data[i][k]=str8;     k=k+1;
                                                //data[i][k]=str9;     k=k+1;
                                                //data[i][k]=str10;    k=k+1;
                                                //data[i][k]=str11;    k=k+1;
                                                //data[i][k]=str12;    k=k+1;
                                                //data[i][k]=str13;
                                        }
                                }
                                DefaultTableModel model=new DefaultTableModel(data,colheads);
                                JTable table=new JTable(model)
                                {
                                        public Component prepareRenderer(TableCellRenderer renderer,int row,int col)
                                        {
                                                Component comp=super.prepareRenderer(renderer,row,col);                                                        
                                                JComponent jcomp=(JComponent)comp;
                                                if(comp==jcomp)
                                                {
                                                        jcomp.setToolTipText((String)getValueAt(row,col));
                                                }
                                                return comp;
                                         }
                                         public Dimension getPreferredScrollableViewportSize()
                                         {
                                                return getPreferredSize();
                                         }
                                };
                                table.setShowGrid(true);
                                table.setShowVerticalLines(true);
                                table.setGridColor(Color.red);
                                table.setBackground(c5);
                                //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                                Dimension dim=new Dimension(20,1);
                                table.setIntercellSpacing(new Dimension(dim));
                                //setRowHight(table);
                                table.setColumnSelectionAllowed(true);
                                table.setRowSelectionAllowed(true);
                                JTableHeader header=table.getTableHeader();
                                header.setBackground(Color.pink);
                                int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
                                int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
                                JScrollPane jsp=new JScrollPane(table,v,h);                                                                                
                                c.add(jsp,BorderLayout.CENTER);  
                                conn.close();
                        }
                        catch(Exception e)
                        {
                                System.out.println(e.getMessage());
                                JOptionPane.showMessageDialog(null,"ERRROR!");
                        }
                }
        }               /*CLOSED THE VIEW_PANEL CLASS */
        //_______________________________________________________________________________
        /* METHOD FOR PERSISTENT.ONE-TIME CONNECTION THROUGHOUT THE COMPLETE OPERATION */
        //-------------------------------------------------------------------------------        
        public void connection()
        {
            
                //url="jdbc:odbc:ARMS";
               //String databaseURL = "jdbc:ucanaccess://e://biometric//ARMS.mdb";
                try
                {
                        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        //con1=DriverManager.getConnection("jdbc:ucanaccess://E:\\biometric\\ARMS.accdb;jackcessOpener=com.gym.classes.CryptCodecOpener","ARMS", "arms2721954");
                        //stmt=con1.createStatement();
                   Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                   Connection  conurl=DriverManager.getConnection("jdbc:ucanaccess://E:\\biometric\\ARMS.mdb;jackcessOpener=com.gym.classes.Test$CryptCodecOpener","Admin","arms2721954");
                   System.out.println("sucessfull");
                   conurl.close();
                }
                catch(Exception se)
                {
                    se.printStackTrace();
                        System.out.println("ERROR:"+se);
                }
                

        }
        //______________________________________________________________
                                /* MAIN CLASS */
        //--------------------------------------------------------------
        public static void main(String[] args)
        {
            try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
               
                
                EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
                                        
                                         Attendance fr=new Attendance();                
                //fr.connection();                
                JFrame frm=new JFrame("View Records");
                frm.setContentPane(fr);
               frm.setSize(800,600);
                frm.setVisible(true);
                //fr.setVisible(true);
                frm.setResizable(false);
                
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        }
        

}
