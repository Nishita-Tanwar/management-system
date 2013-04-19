package satya.appin.karolbagh.secondmodule.graphics;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Vector;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*; 
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.*; 

import satya.appin.karolbagh.connection.connection;
import satya.appin.karolbagh.graphics.StudentRegistration;
import satya.appin.karolbagh.secondmodule.TextAreaRenderer;
 

public class CompleteInformation extends JFrame implements ActionListener { 
 
   JFrame f;
   JMenuBar m;
   connection con;
   Object o; 
   JMenuItem back,home,print;
   JToolBar tool;
   JTable table;
   	CompleteInformation() 
   	{ 
    	 m=new JMenuBar();
    	 tool=new JToolBar();
    	 home=new JMenuItem("Home");
    	 print=new JMenuItem("Print");
    	 home.addActionListener(this);
    	 print.addActionListener(this);
    	// f.add(tool);
    //	 tool.add(back);
    	// m1.add(back);
    	 m.setLayout(new FlowLayout());
    	 
    	 con=new connection();
    	 back=new JMenuItem("Back");
    	 back.addActionListener(this);
    	 m.add(back);
    	 m.add(home);
    	 m.add(print);
    	 Vector columnNames = new Vector();
    	 Vector data = new Vector();
    	con.sql="Select * from details";
    	con.connect();
    		try {
    	  	ResultSetMetaData md =con.rs.getMetaData();
    	  	int columns = md.getColumnCount();
    	  	for (int i = 1; i <= columns; i++) 
    	  	{
    	  		columnNames.addElement( md.getColumnName(i) );
    	  	}
    	  	while (con.rs.next())
    	  	{
    	  		Vector row = new Vector(columns);
    	  		for (int i = 1; i <= columns; i++)
    	  		{
    	  			row.addElement( con.rs.getObject(i) );
    	  		}
    	  		data.addElement( row );
    	}
    	con.rs.close();
    	}
    	catch(Exception e)
    	{
    	System.out.println(e);
    	}
    	table = new JTable(data, columnNames);
    	TableColumn col = null;

    	for (int i = 0; i < table.getColumnCount(); i++) {
    	col = table.getColumnModel().getColumn(i);
    	}
    	/*JScrollPane talkPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
    	        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//p.add( scrollPane ); 
    	//table.setFont(new Font("Times New Roman", Font.BOLD,20));
    	//table.setForeground(Color.BLUE);*/
        TableColumnModel cmodel = table.getColumnModel(); 
        TextAreaRenderer textAreaRenderer = new TextAreaRenderer(); 
 
        cmodel.getColumn(0).setCellRenderer(textAreaRenderer); 
        cmodel.getColumn(1).setCellRenderer(textAreaRenderer); 
       cmodel.getColumn(2).setCellRenderer(textAreaRenderer); 
       cmodel.getColumn(3).setCellRenderer(textAreaRenderer); 
       cmodel.getColumn(3).setCellRenderer(textAreaRenderer); 

       cmodel.getColumn(4).setCellRenderer(textAreaRenderer); 

       cmodel.getColumn(5).setCellRenderer(textAreaRenderer); 

       cmodel.getColumn(6).setCellRenderer(textAreaRenderer); 

       cmodel.getColumn(7).setCellRenderer(textAreaRenderer); 

       cmodel.getColumn(8).setCellRenderer(textAreaRenderer); 
       cmodel.getColumn(9).setCellRenderer(textAreaRenderer); 
       cmodel.getColumn(10).setCellRenderer(textAreaRenderer); 
       cmodel.getColumn(11).setCellRenderer(textAreaRenderer); 
       cmodel.getColumn(12).setCellRenderer(textAreaRenderer); 
       cmodel.getColumn(13).setCellRenderer(textAreaRenderer); 
       cmodel.getColumn(14).setCellRenderer(textAreaRenderer); 
    
       table.setEnabled(false);
    
    	f=new JFrame("ALL STUDENT DETAILS");
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);  

    	f.setJMenuBar(m);
    	//UIManager.put("JFrame.activeTitleBackground", Color.green);
        f.add(new JScrollPane(table)); 
       // f.setAlwaysOnTop(true);
        f.setUndecorated(true);
    	f.setSize(1024,500);
    	f.setVisible(true);
    	
    } 
   
     
     public void actionPerformed(ActionEvent e)
     {
    	 if(e.getSource()==back)
    	 {
    		new StudentInformation();
    		f.dispose();

    	 }
    	 if(e.getSource()==home)
    	 {
    		 new StudentRegistration();
    		 f.dispose();
    	 }
    	 if(e.getSource()==print)
    	 {
    		 try {
    			 PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
 				set.add(OrientationRequested.LANDSCAPE);
 				MessageFormat header = new MessageFormat("Appin Technology Lab"+" "+"(All Student Personal Details)");
    			 MessageFormat footer = new MessageFormat("Developed by Satys Prakash");
				//table.setName("Appin Technology Lab");
				//table.print();
				table.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);

				//table.print(JTable.PrintMode.FIT_WIDTH,"Appin Technology Lab","Developed by Satya Prakash",false,set,false);

			} catch (PrinterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	 }
     }
     public void itemStateChanged(ItemEvent e) {
    	
     }

 /*public static void main(String[] args) { 
    	try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e)
		{
			
		}
        new CompleteInformation();//.showTable(); 
    } */
    public void menuSelected(MenuEvent e) {
    	
      }
} 
