package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import satya.appin.karolbagh.connection.connection;

//import appin.sadhna.hms.connection.Connect;

public class ServiceInvestigation implements ActionListener{
	JFrame f1;
	JPanel p1,p2;
	JTable table;
	JTextField mr,ip,docname,qty,charge,discount;
	JComboBox srvicetype,testname;
	JCheckBox payment;
	JButton save,cancel,close;
	ServiceInvestigation (String Id,String user)
	{
		f1=new JFrame("SERVICE INVESTIGATION :" +user);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setLayout(null);
		//f1.setResizable(false);
		p1=new JPanel();
		p1.setBounds(0,0,700,750);
		p1.setLayout(null);
		p1.setBackground(Color.green);
		f1.add(p1);
		
		JLabel l=new JLabel("MR_NO");
		l.setBounds(20,20,60,20);
		p1.add(l);
		mr=new JTextField();
		mr.setBounds(100,20,90,25);
		p1.add(mr);
		JLabel l1=new JLabel("IP_NO");
		l1.setBounds(250,20,60,20);
		p1.add(l1);
		ip=new JTextField();
		ip.setBounds(320,20,90,25);
		p1.add(ip);
		JLabel l2=new JLabel("Name");
		l2.setBounds(20,60,60,20);
		p1.add(l2);
		JLabel l3=new JLabel("Age");
		l3.setBounds(250,60,50,20);
		p1.add(l3);
		JLabel l4=new JLabel("Gender");
		l4.setBounds(470,60,50,20);
		p1.add(l4);
		JLabel l5=new JLabel("Type Of Services");
		l5.setBounds(20,110,120,20);
		p1.add(l5);
		srvicetype=new JComboBox();
		srvicetype.setBounds(150,110,170,25);
		srvicetype.addItem( " ");
		srvicetype.addItem("RADIOLOGY");
		srvicetype.addItem("HAEMATOLOGY");
		p1.add(srvicetype);
		JLabel l6=new JLabel("Doctor Name");
		l6.setBounds(380,110,130,20);
		p1.add(l6);
		docname=new JTextField();
		docname.setBounds(460,110,170,25);
		p1.add(docname);
		
		JLabel l7=new JLabel("Test Name");
		l7.setBounds(20,160,90,20);
		p1.add(l7);
		testname=new JComboBox();
		testname.setBounds(150,160,170,25);
		testname.addItem(" ");
		testname.addItem("X-Ray Plain");
		testname.addItem("X-Ray Rightm Hand K");
		testname.addItem("X-Ray Barium Enema");
		testname.addItem("X-Ray Barium Meal");
		testname.addItem("X-Ray ASU Ascend");
		p1.add(testname);
		//p2=new JPanel(new BorderLayout());
		//p2.setBounds(20,210,650,150);
		//p2.setBackground(Color.black);
		//p2.setLayout(new BorderLayout());
		//JTable tc=new JTable(3,4);
		//p2.add(tc);
	//	p1.add(p2);
		JLabel l8=new JLabel("Selected Service");
		l8.setBounds(20,500,100,20);
		p1.add(l8);
		JLabel l9=new JLabel("Test Name");
		l9.setBounds(20,540,70,20);
		p1.add(l9);
		JLabel la=new JLabel("Dept Name");
		la.setBounds(20,580,70,20);
		p1.add(la);
		JLabel lb=new JLabel("Qty");
		lb.setBounds(20,620,20,20);
		p1.add(lb);
		qty=new JTextField();
		qty.setBounds(50,620,50,25);
		p1.add(qty);
	    JLabel lc=new JLabel("Charges");
		lc.setBounds(130,620,50,20);
		p1.add(lc);
		charge=new JTextField();
		charge.setBounds(190,620,70,25);
		p1.add(charge);
		JLabel ld=new JLabel("Total Bill Amt");
		ld.setBounds(310,500,100,20);
	    p1.add(ld);
	    JLabel le=new JLabel("Total Discount");
		le.setBounds(490,500,100,20);
		p1.add(le);
		discount=new JTextField();
		discount.setBounds(590,500,70,25);
		p1.add(discount);
		JLabel lf=new JLabel("Payment");
		lf.setBounds(510,580,80,20);
		p1.add(lf);
		payment=new JCheckBox();
		payment.setBounds(480,580,20,25);
		p1.add(payment);
		save=new JButton("SAVE");
		save.addActionListener(this);
		save.setBounds(180,670,90,30);
		p1.add(save);
		cancel=new JButton("CANCEL");
		cancel.addActionListener(this);
		cancel.setBounds(290,670,90,30);
		p1.add(cancel);
		
		close=new JButton("CLOSE");
		close.addActionListener(this);
		close.setBounds(400,670,90,30);
		p1.add(close);
		
		
		
		
		
		
		
		f1.setSize(700,750);
		f1.setVisible(true);
		
	}
public	void getTest(String id)
	{
		connection con=new connection();
		con.sql="select SERVICENAME,TESTNAME,DEPNAME,QUANTITY,CHARGES,DISCOUNT,TOTALBILLINGAMOUNT from ServiceInvestigation where IP_NO='"+id+"'";
		//con.getConnect();
		Vector columnName=new Vector();
		//columnName.addElement("Service Name");
		
		Vector rowData=new Vector();
		
		try
		{
			ResultSetMetaData md=con.rs.getMetaData();
			int column=md.getColumnCount();
			System.out.println(column);
			
			while(con.rs.next())
			{
				Vector row=new Vector(column);
				for(int i=1;i<=column;i++)
				{
					//row.addElement(con.rs.getObject(i));
					System.out.println(con.rs.getString(i));
				}
				
				rowData.addElement(row);
				
			}
			con.rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//table=new JTable(rowData,columnName);
		
		JPanel p3=new JPanel(new BorderLayout());
		p3.setBounds(20,210,650,150);
		p3.setBackground(Color.black);
		
		table=new JTable(4,3);

		table.setEnabled(false);
		JButton s=new JButton("Enter");
		//p2.setOpaque(false);
		JScrollPane scroll=new JScrollPane(table);
		JTable x=new JTable(4,4);
		//p1.setOpaque(false);
	//	p2.setOpaque(false);
		p3.add(x);
		//p2.setBackground(Color.yellow);
		p1.add(p3,BorderLayout.CENTER);
		p1.setBackground(Color.red);
		//p2.setVisible(true);
System.out.println("Complete method run");
		

	}
	public static void main(String a[])
	{
		/*try
		{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel")	;
		
		}
		catch(Exception e)
		{
		
		e.printStackTrace();
	}*/
		new ServiceInvestigation("1010","satya").getTest("101");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==save)
		{
			System.out.println("Saving Your Data");
		}
		if(e.getSource()==cancel)
		{
		System.out.println("Data Is Cancelled");
		
		}
		if(e.getSource()==close)
		{
			System.out.println("Closed");
		}
		
		
	}
	
}
