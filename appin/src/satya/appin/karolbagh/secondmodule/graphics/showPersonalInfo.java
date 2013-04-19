package satya.appin.karolbagh.secondmodule.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.jar.Attributes.Name;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import satya.appin.karolbagh.secondmodule.method.PersonalInfo;

public class showPersonalInfo implements ActionListener {
	
	JFrame f;
	JPanel pu, pc, pd, data;
	JButton close, print;
	PersonalInfo info;
	JTable table;
	public showPersonalInfo()
	{
		info=new PersonalInfo();
		f=new JFrame("Personal Information");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		pu=new JPanel();
		pc=new JPanel(null);
		pc.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		pd=new JPanel();
		f.add(pu, BorderLayout.NORTH);
		pu.setBackground(Color.gray);
		pc.setBackground(Color.LIGHT_GRAY);
		pd.setBackground(Color.GRAY);
		//pu.setOpaque(false);
		//pc.setOpaque(false);
		//pd.setOpaque(false);
		JLabel pdet=new JLabel("Personal Details");
		pdet.setFont(new Font("Courier New", Font.BOLD,20));
		pu.add(pdet);
		f.add(pc, BorderLayout.CENTER);
		f.add(pd, BorderLayout.SOUTH);
		
		close= new JButton("CLOSE");
		close.setFont(new Font("Courier New", Font.BOLD,15));
		pd.add(close);
		close.setBackground(Color.gray);
		//close.setOpaque(false);
		print=new JButton("PRINT");
		pd.add(print);
		print.setBackground(Color.gray);
		//print.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	//	print.setOpaque(false);
		print.setFont(new Font("Courier New", Font.BOLD,15));
		print.addActionListener(this);
		close.addActionListener(this);
		//close.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		//JLabel name=new JLabel("Name");
		data=new JPanel(new BorderLayout());
		data.setBackground(Color.red);
		data.setBounds(45, 30, 500, 250);
		pc.add(data);
		
		
		f.setUndecorated(true);
		f.setSize(600,400);
		f.setAlwaysOnTop(true);
		f.setVisible(true);
			System.out.println(info.name);
	}
	
public void getDetails(String id,String name, String fn, String dob,String gender,String phone, String email, String address, String city,String college, String branch,String workep, String querytype, String queryTraining,String querydate)
{
	Object rowData[][] = { { "ID", id},
	        { "Name",name},
			{"Father Name",fn},
			{"Gender",dob},
			{"Date of Birth",gender},{"Contact No.",phone},{"Email",email},{"Address",address},{"City",city},{"College",college},{"Branch",branch},{"Work Experience",workep},{"Query Course Type",querytype},{"Query Course",queryTraining},{"Query Date",querydate}
			};
	    Object columnNames[] = { "Personal", "Information"};
	     table = new JTable(rowData, columnNames);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setEnabled(false);

	    data.add(scrollPane, BorderLayout.CENTER);
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==close)
	{
		f.dispose();
		//System.out.println();
	}
	if(e.getSource()==print)
	{		

		try {
			 PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
			set.add(OrientationRequested.REVERSE_PORTRAIT);
			MessageFormat header = new MessageFormat("Appin Technology Lab");
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

/*public static void main(String a[])
{
	new showPersonalInfo();
}*/
}
