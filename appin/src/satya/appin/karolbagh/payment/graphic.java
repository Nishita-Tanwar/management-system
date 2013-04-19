package satya.appin.karolbagh.payment;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import satya.appin.karolbagh.graphics.StudentRegistration;
import satya.appin.karolbagh.secondmodule.method.Id;


public class graphic implements ActionListener{
	JFrame f;
//	JScrollPane main;
	JPanel main,main1,child1,child2;
	JTextField id;
//	JComboBox search;
	JButton find,all, home,searchdt,making_pay;
	JLabel enroll;
	public graphic()
	{
		f=new JFrame("Old Student Block");
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);  
		main=new JPanel();
		main.setBackground(Color.LIGHT_GRAY	);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLayout(null);
	JLabel	appin=new JLabel("Appin Technology Lab.");
		JLabel appin1=new JLabel("KarolBagh New Delhi "+new Date().getDate()+"/"+new Date().getMonth()+"/"+new Date().getYear());
		appin.setBounds(30,10,700,50);
		appin1.setBounds(30,60,500,30);
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
	/*	search=new JComboBox();
		search.addItem("Personal Details");
		search.addItem("Registration Details");
		search.addItem("Payment Details");
		search.setBounds(180,5, 120, 20);
		search.setOpaque(false);*/
	//	child1.add(search);
		find=new JButton("Search");
		find.addActionListener(this);
		find.setBounds(190,5,80,20);
		child1.add(find);
		making_pay=new JButton("Making Payment..");
		making_pay.addActionListener(this);
		making_pay.setBounds(280,5,160,20);
		child1.add(making_pay);
		//find.addActionListener(this);
		
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
		
		JLabel std=new JLabel("Start Date");
		JLabel end=new JLabel("End Date");
	//	JLabel task=new JLabel("Search Student Enrolled between dates");

		/*stdt=new JTextField();
		endt=new JTextField();
		searchdt=new JButton("Search");
		task.setBounds(50, 20, 700, 30);
		std.setBounds(50, 70, 80, 20);
		stdt.setBounds(120,70,120,20);
		end.setBounds(50, 100, 80, 20);
		endt.setBounds(120,100,120,20);
		searchdt.setBounds(50, 130, 80, 20);*/
		
	/*	child2.add(std);
		child2.add(task);
		child2.add(stdt);
		child2.add(end);
		child2.add(endt);*/
		//child2.add(searchdt);
		///endt.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		
		child2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	// stdt.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	id.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	//task.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	//task.setFont(new Font("Courier New", Font.BOLD,15));
	//task.setHorizontalTextPosition(JLabel.CENTER);
	//task.setVerticalAlignment(JLabel.LEADING);
	enroll=new JLabel();
	enroll.setFont(new Font("Courier New", Font.BOLD,15));
	enroll.setForeground(Color.red);
	enroll.setBounds(30, 605, 900, 30);
	main.add(enroll);

		//child2.setBorder(breg);
		main1.add(child2);
		//main.add(main1);
		f.setUndecorated(true);
		 f.setSize(1000,700);		
		 f.setVisible(true);///

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
		if(e.getSource()==find)
		{
			//new show();
			//f.dispose();
			Id check=new Id();
		check.getRegID();
			if(check.regID.contains(id.getText().toUpperCase()))
			{//f.dispose();
			forwordID farword=new forwordID();
			farword.getID(id.getText().toUpperCase());
				//logic log=new logic();
				//log.getPaymetDetails("select * from payment where ID='"+id.getText().toUpperCase()+"'");
			//show xx=	new show();xx.getdata(id.getText().toUpperCase());
			f.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(f, "Please Take Admission First", "Appin Karol Bagh", 0);
			}
		}
	}
/*public static void main(String a[])
{
	new graphic();
}*/
}
