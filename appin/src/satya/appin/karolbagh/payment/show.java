package satya.appin.karolbagh.payment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import satya.appin.karolbagh.connection.connection;
import satya.appin.karolbagh.graphics.StudentRegistration;
import satya.appin.karolbagh.graphics.payment;
import satya.appin.karolbagh.method.datetime;
import satya.appin.karolbagh.method.kit;
import satya.appin.karolbagh.method.slipmanag;


public class show implements ActionListener{
	JFrame f;int totalpaid=0;
	int totalpay=0;	Vector Emi;
	int totalbalance=0;
	int totalEmi,totalEmi1;
//	JScrollPane main;
	JPanel main,main1,child1,child2;
	JTextField id,slipNo,slipdate,Enrol1;
//	JComboBox search;
	JButton  home,submit;
	JTable table;JPanel datashow;
	JLabel enroll,name,phone1,coursetype1,course1,addmission1;
	JLabel Emi1,totalpay1,paid1,balance1;
	JLabel Currentemi1,pay12;
	String IDcheck;
	JPanel photo,slip;
	JComboBox kit1;
	int currentpayment;
	kit getkit;
	String emiIterest,paymentType;
	int EmiNo;
	
	public show()
	{
		f=new JFrame("Payment block");
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);  
		main=new JPanel();
		main.setBackground(Color.LIGHT_GRAY	);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLayout(null);
	JLabel	appin=new JLabel("Appin Technology Lab.");
		JLabel appin1=new JLabel("KarolBagh New Delhi "+new Date().getDate()+"/"+new Date().getMonth()+"/"+new Date().getYear());
		appin.setBounds(30,10,700,50);
		appin1.setBounds(30,60,700,30);
		appin.setFont(new Font("Courier New", Font.BOLD,50));
		appin1.setFont(new Font("Courier New", Font.BOLD,20));
		main.add(appin);
		main.add(appin1);
		f.add(main);
		main1=new JPanel();
		main1.setBounds(30,100,900,500);
		
		
		main1.setLayout(null);
		main.add(main1);
		main1.setOpaque(false);
		
		child1=new JPanel();
		child1.setBackground(Color.gray);
		child1.setBounds(0,0,900,30);
		child1.setLayout(null);
		main1.add(child1);
		main.add(main1);
		
	JLabel	l1=new JLabel("ID");

		l1.setBounds(20,5,30,20);
		child1.add(l1);
		id=new JTextField();
		id.setBounds(50,5,90,20);
		child1.add(id);
		
		
		JLabel Enrol=new JLabel("Enrollment");
		Enrol.setBounds(140, 5, 80, 20);
		child1.add(Enrol);
		Enrol.setOpaque(true);
		Enrol.setBackground(Color.yellow);
		
		Enrol1=new JTextField();
		Enrol1.setBackground(Color.yellow);
		Enrol1.setBounds(220, 5, 100, 20);
		child1.add(Enrol1);
		datetime date=new datetime();

		JLabel slipdate1=new JLabel("Date");
		slipdate1.setBounds(330, 5, 70, 20);
		child1.add(slipdate1);
		date.date();
		Enrol1.setEditable(false);
		
		slipdate=new JTextField(date.dateNow);
		slipdate.setBounds(380, 5, 100, 20);
		child1.add(slipdate);
		
		
		slipNo=new JTextField();
		slipNo.setBounds(560, 5, 120, 20);
		child1.add(slipNo);
		
		JLabel slipNo1=new JLabel("Slip No.");
		slipNo1.setBounds(490, 5, 80, 20);
		child1.add(slipNo1);
		l1.setOpaque(true);
		JPanel personaldetail=new JPanel(null);
		personaldetail.setOpaque(false);
		personaldetail.setBounds(40,40,270,320);
		
				JLabel	lid=new JLabel("NAME");
				lid.setBounds(20,30,80,20);
				personaldetail.add(lid);
				name=new JLabel();
				name.setBounds(120,30,160,20);
				personaldetail.add(name);
				
				
				JLabel	phone=new JLabel("PHONE NO.");
				phone.setBounds(20,60,80,20);
				personaldetail.add(phone);
				phone1=new JLabel();
				phone1.setBounds(120,60,160,20);
				personaldetail.add(phone1);
				
				JLabel	coursetype=new JLabel("COURSE TYPE");
				coursetype.setBounds(20,90,80,20);
				personaldetail.add(coursetype);
				coursetype1=new JLabel();
				coursetype1.setBounds(120,90,160,20);
				personaldetail.add(coursetype1);
				
				JLabel	course=new JLabel("COURSE");
				course.setBounds(20,120,80,20);
				personaldetail.add(course);
				course1=new JLabel();
				course1.setBounds(120,120,160,20);
				personaldetail.add(course1);
				
				JLabel	addmission=new JLabel("ADMISSION");
				addmission.setBounds(20,150,100,20);
				personaldetail.add(addmission);
				addmission1=new JLabel();
				addmission1.setBounds(120,150,160,20);
				personaldetail.add(addmission1);
				
				JLabel	totalPay=new JLabel("Total Payment");
				totalPay.setBounds(20,180,100,20);
				personaldetail.add(totalPay);
				totalpay1=new JLabel();
				totalpay1.setBounds(120,180,160,20);
				personaldetail.add(totalpay1);
				
				
				JLabel	paid=new JLabel("Paid");
				paid.setBounds(20,210,100,20);
				personaldetail.add(paid);
				paid1=new JLabel();
				paid1.setBounds(120,210,160,20);
				personaldetail.add(paid1);
				
				JLabel	balance=new JLabel("Balance");
				balance.setBounds(20,240,100,20);
				personaldetail.add(balance);
				balance1=new JLabel();
				balance1.setBounds(120,240,160,20);
				personaldetail.add(balance1);
				
				JLabel	Emi=new JLabel("Total EMI");
				Emi.setBounds(20,270,100,20);
				personaldetail.add(Emi);
				Emi1=new JLabel();
				Emi1.setBounds(120,270,160,20);
				personaldetail.add(Emi1);
				
				
		main1.add(personaldetail);
		 slip=new JPanel(null);
		slip.setBounds(315,40,600,320);
		main1.add(slip);
		slip.setBackground(Color.cyan);
	slip.setOpaque(false);
		
		JPanel insert=new JPanel(null);
		insert.setBounds(0, 0, 400, 120);
		insert.setBackground(Color.GREEN);
		
		
		JLabel	Currentemi=new JLabel("Current EMI");
		Currentemi.setBounds(10,0,80,20);
		insert.add(Currentemi);
			
		Currentemi1=new JLabel();
		Currentemi1.setBounds(90,00,80,20);
		insert.add(Currentemi1);
		
		
		JLabel	pay=new JLabel("Pay");
		pay.setBounds(10,30,80,20);
		insert.add(pay);
			
		pay12=new JLabel();
		pay12.setBounds(90,30,80,20);
		insert.add(pay12);
		kit1=new JComboBox();

		JLabel	kit=new JLabel("Kit Issue");
		kit.setBounds(10,60,80,20);
		getkit=new kit();
		getkit.getKit();
		for(int kit2=0;kit2<getkit.kit.size();kit2++)
		{
			kit1.addItem(getkit.kit.elementAt(kit2));//
		}
		insert.add(kit);
			
		kit1.setBounds(90,60,160,20);
		insert.add(kit1);
		
		insert.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		insert.setOpaque(false);
		submit=new JButton("Submit");
		submit.setBounds(10,90,80,20);
		insert.add(submit);
			submit.addActionListener(this);
		
		slip.add(insert);
		JLabel payment =new JLabel("PAYMENT");
		payment.setFont(new Font("Courier New", Font.BOLD,20));

		payment.setBounds(10,100,100,60);
		slip.add(payment);
	datashow=new JPanel(new BorderLayout());
		datashow.setBounds(10,150,500,150);
		datashow.setBackground(Color.red);
		slip.add(datashow);
datashow.setOpaque(false);
	home=new JButton("Home");
		 home.setBounds(50,380,80,30);
		main1.add(home);
		home.addActionListener(this);
	
		Border breg=BorderFactory.createTitledBorder("Search");

	id.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	Enrol.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	Enrol1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

	l1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	personaldetail.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

l1.setBackground(Color.yellow);
	id.setBackground(Color.yellow);
	id.setForeground(Color.red);
	id.setEditable(false);

		f.setUndecorated(true);
		 f.setSize(1000,700);		
		 f.setVisible(true);///

	}

public void getPayment()
{
	connection con=new connection();
	con.sql="select * from payment where id='"+IDcheck+"'";
	con.connect();
	try {
		con.rs.next();
		String pay=con.rs.getString("payment");
		totalpay=Integer.parseInt(pay);
		//System.out.println("total payment "+pay);
		String getEmi=con.rs.getString("total_emi");
		 Emi1.setText(getEmi);
		 emiIterest=con.rs.getString("Emi_interest");
		totalEmi=Integer.parseInt(getEmi);//getEmi;
		 totalpay1.setText("Rs. "+totalpay+"/-");
		 paymentType=con.rs.getString("payment_type");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void pay()
{
	connection con=new connection();
	con.sql="select Emi_payment from payment where id='"+IDcheck+"'";
	con.connect();
	try {
		while(con.rs.next())
		{
		String pay=con.rs.getString("Emi_payment");
		int x=Integer.parseInt(pay);
		totalpaid=totalpaid+x;
		}
		
		//System.out.println("Totla Paid " +totalpaid);
		paid1.setText("Rs. "+totalpaid+"/-");
		totalbalance=totalpay-totalpaid;
		balance1.setText("Rs. "+totalbalance+"/-");

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void balance()
{
	//totalbalance=totalpay-totalpaid;
	//System.out.println("Balance "+totalbalance);
	//balance1.setText("Rs. "+totalbalance+"/-");
	
}
	public void getdata(String ID)
	{	IDcheck=ID;
	
		connection con=new connection();
		 Vector columnNames = new Vector();
	 Vector data = new Vector();
	con.sql="Select slip_no,date,emi_no,emi_payment,kit_issue1 from payment where id='"+ID+"'";
	con.connect();
		try {
	  	ResultSetMetaData md =con.rs.getMetaData();
	  	int columns = md.getColumnCount();
	  	for (int i = 1; i <= columns; i++) 
	  	{
columnNames.addElement(md.getColumnName(i));
	  	
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
	//System.out.println(e);
	}
	table = new JTable(data, columnNames);
	
   

  table.setEnabled(false);

JScrollPane pane=new JScrollPane(table);
pane.setHorizontalScrollBar(null);

 datashow.add(pane); 
 

	Personal();
	getPhoto();
	id.setText(IDcheck);
//f.dispose();
	}
	
	public void getError(String error2)
	{
		
		enroll.setText(null);
		enroll.setText(error2);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==home)
		{
			new StudentRegistration();
			f.dispose();
		}
		if(e.getSource()==submit)
		{
			slipmanag slip1=new slipmanag();
			slip1.getSlip();
			//if(slip1.slip.contains(slipNo.getText()))
				if(slip1.slip.contains(slipNo.getText().toUpperCase())||slip1.slip.contains(slipNo.getText().toLowerCase())||slip1.slip.contains(slipNo.getText()))

			{
				JOptionPane.showMessageDialog(f, "This Slip No. already used", "Appin Karol Bagh", 0);
			}
			else
			{
				if(totalEmi==EmiNo)
				{
					
				}
				
			//	System.out.println(totalpay);
				new payment().getPaymet(slipdate.getText(), slipNo.getText().toUpperCase(), id.getText().toUpperCase(), Enrol1.getText(), Integer.toString(totalpay), Integer.toString(totalpaid+currentpayment), Integer.toString(totalbalance-currentpayment), Integer.toString(totalEmi), emiIterest, Integer.toString(EmiNo), Integer.toString(currentpayment), kit1.getSelectedItem().toString().toUpperCase(), paymentType);
				JOptionPane.showMessageDialog(f, "Payment Successfully"+"\n"+"Slip No : "+slipNo.getText()+"\n"+"ID: "+id.getText(), "Appin Karol Bagh", 0);
				new StudentRegistration();
				f.dispose();

			}	}
	}
	
	public void erolldetail()
	{
		connection	con=new connection();
		con.sql="select * from enrollstudent where id='"+IDcheck+"'";
		con.connect();
		try {
			con.rs.next();
			//name.setText(con.rs.getString("name"));
			//phone1.setText(con.rs.getString("phone"));
		coursetype1.setText(con.rs.getString("Course_type"));
			course1.setText(con.rs.getString("Technology"));
			Date d=con.rs.getDate("enrol_date");
			Enrol1.setText(con.rs.getString("Enroll No"));
			String dat=d.toString();
			//System.out.println(dat);
			addmission1.setText(dat);//.(con.rs.getDate("Query_date").toString());

		} catch (SQLException e) {
			System.out.print("Error in show");			e.printStackTrace();
		}
	}
	
	public void Personal() //throws SQLException
	{
	connection	con=new connection();
		con.sql="select * from details where id='"+IDcheck+"'";
		con.connect();
		try {
			con.rs.next();
			name.setText(con.rs.getString("name"));
			phone1.setText(con.rs.getString("phone"));
		//	coursetype1.setText(con.rs.getString("Training_type"));
			//course1.setText(con.rs.getString("Technology"));
			//Date d=con.rs.getDate("Query_date");
	//		Enrol1.setText(con.rs.getString(arg0))
			//String dat=d.toString();
			//addmission1.setText(dat);//.(con.rs.getDate("Query_date").toString());

		} catch (SQLException e) {
			System.out.print("Error in show");			e.printStackTrace();
		}
		
	}
	public void getPhoto()
	{
		connection con=new connection();
		con.sql="select photo from photo where id='"+IDcheck+"'";
		con.connect();
		try {
			con.rs.next();
			InputStream stream =con.rs.getBinaryStream("photo");
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            int a1 = stream.read();
            while (a1 >= 0) {
              output.write((char) a1);
              a1 = stream.read();
            }
            Image myImage = Toolkit.getDefaultToolkit().createImage(output.toByteArray());
            Image send=myImage.getScaledInstance(105,-1, Image.SCALE_SMOOTH);
           drawing(send);
            output.close();
    		//img = img.getScaledInstance(105, -1, Image.SCALE_SMOOTH);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void drawing(final Image img)
	{
		/*	 photo=new JPanel();
		photo.setBackground(Color.GREEN);
		*/
		photo=new JPanel(null){
			protected void paintComponent(Graphics g)
			{
				
				g.drawImage(img,0,0,this);
			super.paintComponent(g);
			}
			
		};
		photo.setOpaque(false);
		photo.setBounds(450,0,104,134);
		slip.add(photo);
	}
public static void main(String a[])
{
	new show().getdata("aksp014");
}


public void getEmit()
{Emi=new Vector();
	connection con=new connection();
	con.sql="select Emi_no from payment where id='"+IDcheck+"'";
	con.connect();
	try {
		while(con.rs.next())
		{
			String pay=con.rs.getString("Emi_no");
			
			totalEmi1=Integer.parseInt(pay);
			Emi.addElement(totalEmi1);
			//System.out.println("total payment "+pay);
		}
		
	//	System.out.println(Emi);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int x=1;x<totalEmi+1;x++)
	{
		if(Emi.contains(x))
		{
			
		}
		else
		{
			Currentemi1.setText(Integer.toString(x));
		//	System.out.println("CurrenctEmi "+x);
			EmiNo=x;
			break;
		}
	}
}
public void currentpay()
{
	connection con=new connection();
	con.sql="select paid from payment where id='"+IDcheck+"'";
	con.connect();
	try {
		con.rs.next();
		{
		String pay=con.rs.getString("paid");
		int x=Integer.parseInt(pay);
		currentpayment=x;
		//System.out.println(x);
		//pay12.setText("Rs. "+pay+"/-");
	//	System.out.println("EMI"+EmiNo);
		if(totalEmi==EmiNo)
		{
			pay12.setText("Rs. "+totalbalance+"/-");
			//balance1.setText("Rs. 000.00/-");

		}else
		{
			if(EmiNo==0)
			{
				JOptionPane.showMessageDialog(f, "Payment allready completed", "Appin Karol Bagh", 0);
				submit.setEnabled(false);

			}
			else
			{
				pay12.setText("Rs. "+pay+"/-");

			}
		}
		//totalpaid=totalpaid+x;
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
