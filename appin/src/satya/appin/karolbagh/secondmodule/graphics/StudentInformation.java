package satya.appin.karolbagh.secondmodule.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import satya.appin.karolbagh.graphics.StudentRegistration;
import satya.appin.karolbagh.payment.forwordID;
import satya.appin.karolbagh.secondmodule.method.Id;
import satya.appin.karolbagh.secondmodule.method.PersonalInfo;
import satya.appin.karolbagh.secondmodule.method.regInfo;

public class StudentInformation implements ActionListener{
 JFrame f;
//	JScrollPane main;
	JPanel main,main1,child1,child2;
	JTextField id,stdt,endt;
	JComboBox search;
	JButton find,all, home,searchdt;
	private JTextField phoneT;
	private JTextField DOBT;
	public StudentInformation()
	{
		f=new JFrame("Old Student Block");
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);  
		main=new JPanel();
		main.setBackground(Color.LIGHT_GRAY	);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLayout(null);
		java.util.Date dq = new Date();
	JLabel	appin=new JLabel("Appin Technology Lab.");
		JLabel appin1=new JLabel("KarolBagh New Delhi, "+dq.toString() );
		appin.setBounds(30,10,700,50);
		appin1.setBounds(30,60,700,30);
		appin.setFont(new Font("Courier New", Font.BOLD,50));
		appin1.setFont(new Font("Courier New", Font.BOLD,20));
		main.add(appin);
		main.add(appin1);
		f.add(main);
		main1=new JPanel();
		main1.setBounds(30,100,900,500);
		
		//p2.setBackground(Color.LIGHT_GRAY);
	//	main1.setBackground(Color.pink);
		main1.setLayout(null);
		main.add(main1);
		main1.setOpaque(false);
		
		child1=new JPanel();
		child1.setBackground(Color.gray);
		child1.setBounds(0,0,900,30);
		child1.setLayout(null);
		main1.add(child1);
		main.add(main1);
		
	JLabel	l1=new JLabel("Enter ID.");
		l1.setBounds(20,5,50,20);
		child1.add(l1);
		id=new JTextField();
		id.setBounds(80,5,90,20);
		child1.add(id);
		search=new JComboBox();
		search.addItem("Personal Details");
		search.addItem("Registration Details");
		search.addItem("Payment Details");
		search.setBounds(180,5, 120, 20);
		search.setOpaque(false);
		child1.add(search);
		find=new JButton("Search");
		find.addActionListener(this);
		find.setBounds(310,5,80,20);
		child1.add(find);
		
		 all=new JButton("All Student");
		all.setBounds(140,380,120,30);
		 main1.add(all);
		 all.addActionListener(this);
		
		/*=====================*/
	
	home=new JButton("Home");
		 home.setBounds(50,380,80,30);
		main1.add(home);
		home.addActionListener(this);/*
		H=new JButton("Registration:");
		reg.setBounds(140, 380, 100, 30);
		reg.addActionListener(this);
		p2.add(reg);*/
		// f.setAlwaysOnTop(true);
		// f.MAXIMIZED_BOTH;
		child2=new JPanel();
		Border breg=BorderFactory.createTitledBorder("Search");

		//child2.setBackground(Color.gray);
		child2.setBounds(30,50,800,300);
		child2.setLayout(null);
		child2.setOpaque(false);
		
		JLabel std=new JLabel("Name");
		JLabel end=new JLabel("Father Name");
		JLabel phone=new JLabel("Mobile No.");
		JLabel DOB=new JLabel("D.O.B");
		JLabel task=new JLabel("Search Student If ID not Remembered");

		stdt=new JTextField();
		endt=new JTextField();
		phoneT=new JTextField();
		DOBT=new JTextField();
		searchdt=new JButton("Search");
		task.setBounds(50, 20, 700, 30);
		std.setBounds(50, 70, 80, 20);
		stdt.setBounds(120,70,120,20);
		end.setBounds(50, 100, 80, 20);
		endt.setBounds(120,100,120,20);
		phone.setBounds(50,130,80,20);
		phoneT.setBounds(120,130,120,20);
		DOB.setBounds(50, 160, 80, 20);
		DOBT.setBounds(120,160,120,20);
		searchdt.setBounds(50, 190, 80, 20);
		child2.add(DOB);
		child2.add(phoneT);
		child2.add(DOBT);
		child2.add(phone);
		child2.add(std);
		child2.add(task);
		child2.add(stdt);
		child2.add(end);
		child2.add(endt);
		child2.add(searchdt);
		searchdt.addActionListener(this);
		endt.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		
		child2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	 stdt.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	id.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	//task.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	task.setFont(new Font("Courier New", Font.BOLD,15));
	//task.setHorizontalTextPosition(JLabel.CENTER);
	//task.setVerticalAlignment(JLabel.LEADING);


		//child2.setBorder(breg);
		main1.add(child2);
		//main.add(main1);
		f.setUndecorated(true);
		 f.setSize(1000,700);		
		 f.setVisible(true);///

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==all)
		{
			 Object[] selectionValues = { "Personal Details", "Registration Details", "Payment" };
			    //String initialSelection = "Dogs";
			    Object selection = JOptionPane.showInputDialog(null, "What is your query?",
			        "Appin Karol Bagh", JOptionPane.QUESTION_MESSAGE, null, selectionValues,null);
			   // System.out.println(selection);
			    if(selection.toString().equalsIgnoreCase("Personal Details"))
			    {
			    	new CompleteInformation();
			    	f.dispose();

			    }
		}
		if(e.getSource()==home)
		{
			new StudentRegistration();
			f.dispose();

		}
		if(e.getSource()==find)
		{
			if(search.getSelectedItem().toString().equalsIgnoreCase("Personal Details"))
			{
				PersonalInfo info=new PersonalInfo();
				Id ID=new Id();
				ID.getId();
				if(ID.id.contains(id.getText().toUpperCase()))
				{
					info.sql="select * from details where id='"+id.getText().toUpperCase()+"'";
					info.getDetails();
					
					//new showPersonalInfo();
				}
				else
				{
					JOptionPane.showMessageDialog(f, "This is Not vaild ID","Appin Karol Bagh",0);
				}
				
				
			}
			else
			{
				if(search.getSelectedItem().toString().equalsIgnoreCase("Registration Details"))
				{
					Id ID=new Id();
					ID.getRegID();
					if(ID.regID.contains(id.getText().toUpperCase()))
					{
						regInfo info1=new regInfo();
						info1.sql="select * from enrollstudent where id='"+id.getText().toUpperCase()+"'";
						info1.getDetails();
						//JOptionPane.showMessageDialog(f, " vaild ID","Appin Karol Bagh",0);
						
						//new showPersonalInfo();
					}
					else
					{
						JOptionPane.showMessageDialog(f, "This is Not vaild ID","Appin Karol Bagh",0);
					}				}
				else
				{

					//new show();
					//f.dispose();
					Id check=new Id();
				check.getRegID();
					if(check.regID.contains(id.getText().toUpperCase()))
					{f.dispose();
					forwordID farword=new forwordID();
					farword.getID(id.getText().toUpperCase());
						//logic log=new logic();
						//log.getPaymetDetails("select * from payment where ID='"+id.getText().toUpperCase()+"'");
					//show xx=	new show();xx.getdata(id.getText().toUpperCase());
						
					}
					else
					{
						JOptionPane.showMessageDialog(f, "Please Take Admission First", "Appin Karol Bagh", 0);
					}
				}
				}
			}
		if(e.getSource()==searchdt)
		{
			String name=stdt.getText();
			String fname=endt.getText();
			String mobile=phoneT.getText();
			String dob=DOBT.getText();
			System.out.println(name+fname+mobile+dob);
			try
			{
				long x=Integer.parseInt(mobile);
				//System.out.print(Integer.toString(x));
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(f, "Please Enter number only" , "Appin Karolbagh", 0);
				phoneT.setText(name);
				phoneT.setBackground(Color.yellow);
				e1.printStackTrace();
			}
		}
			
		}
	
	public static void main(String a[])
	{try{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	}
	catch(Exception e)
	{
		
	}
		new StudentInformation();
	}
	}
	


