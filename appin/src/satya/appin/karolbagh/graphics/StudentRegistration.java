package satya.appin.karolbagh.graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import satya.appin.karolbagh.connection.ErrorMessage;
import satya.appin.karolbagh.connection.connection;
import satya.appin.karolbagh.method.AllreadyRegisterd;
import satya.appin.karolbagh.method.addmission;
import satya.appin.karolbagh.method.city;
import satya.appin.karolbagh.method.cstd;
import satya.appin.karolbagh.method.datetime;
import satya.appin.karolbagh.method.enrolmanag;
import satya.appin.karolbagh.method.feedetails;
import satya.appin.karolbagh.method.feelogic;
import satya.appin.karolbagh.method.imageStore;
import satya.appin.karolbagh.method.imagelogic;
import satya.appin.karolbagh.method.kit;
import satya.appin.karolbagh.method.registrationfee;
import satya.appin.karolbagh.method.registrationinsert;
import satya.appin.karolbagh.method.slipmanag;
import satya.appin.karolbagh.payment.allreadypaymentfirst;
import satya.appin.karolbagh.payment.graphic;
import satya.appin.karolbagh.secondmodule.graphics.CompleteInformation;
import satya.appin.karolbagh.secondmodule.graphics.StudentInformation;


public class StudentRegistration implements ActionListener{
	Date date;
	int x, y, z,te,payvalue,interest1,value,intev;
	static city city12;
	String pay1;
	payment paymentcheck;
	public String file, error;
	String id1,registrationrate;
	AllreadyRegisterd allreg;
	cstd getdate;
	registrationinsert reginst;
	public JFrame f;
	Emimamagement emimang;
	ErrorMessage founderror;
	Image img;
	JPanel p1,p2,p3,p4,p5,p6,p7,pdetail,plp,ppayment;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,mn,add,lc,appin,appin1,error1;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,tmn;
	JLabel cn,ly,br,we,tt,lt,lf,lff;
	JLabel lff1;
	JLabel pd,psn,pid,pen,ptp,pp,pb,ppplt,pppemi,pppemin,pppp,pppkit,pppint;
	JTextField ptd,ptsn,pten,pttp,ptp1,ptb,ptid,ppptemin,ppptint,ppptp;
	JTextField tcn,ty,tb,twe,aksp06,aksp07,aksp08,aksp09,aksp010,aksp011,aksp012;
	JTextArea tadd;
	datetime datetime1;
    JComboBox c,c1,c2,ppptemi;
    JButton b1,b2,b3,b4, find, reg,submit,pay,changereg,back,ppdback,ppppay,pppcal,paymentchange;
	public JComboBox cbc,cy,ct,ctech,crct,crtt,pppckit,ppptt;
	
    ImageIcon i;
    TitledBorder br1,br2,br3,bor,bor1,breg,brfee,brdetail,brd1,brp;
    feedetails fee;
    connection con;
    feelogic fl;
    String rate;
    addmission adm;
    imagelogic ilogic;
    JPanel pan,regp,imgp,ppd,ppp;
	 JPanel pan1,pfee;
	 kit kit1;
	 JTextField txtid,trp,tre,rtd,rtfe,rtpaid,rtdate;
	 JLabel lid,Enroll,lre,lrp,lrct,lrtt,rlfe,rld,rlpaid,rldate;
	 registrationfee totalfee;
    void getrate(String r)
    {
    	rate=r;
    }
    
    void setRate()
    {
    	lff.setText(rate);
    }
	 public StudentRegistration()
	{
		 
		con=new connection();
		fee=new feedetails();
		/*====================*/
		adm=new addmission();
		//adm.id();adm.id();
		adm.id();
		f=new JFrame("Details");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);  

		
		/*====================*/
		kit1=new kit();
		i=new ImageIcon("d://books.jpg");
		p1=new JPanel(null){
			protected void paintComponent(Graphics g)
			{
				
				g.drawImage(i.getImage(),0,0,null);
			super.paintComponent(g);
			}
			
		};
	
		//p1.setOpaque(false);
		p1.setBounds(0,0,1000,1000);		
		p1.setBackground(Color.LIGHT_GRAY);
		f.add(p1);
		
		/*====================*/
		
		p2=new JPanel();
		p2.setBounds(30,100,900,500);
		
		//p2.setBackground(Color.LIGHT_GRAY);
		//p2.setBackground(Color.pink);/********************modification here**********/
		p2.setOpaque(false);
		p2.setLayout(null);
		//p2.setOpaque(false);
	////////////////////// //////////////////     
		//  changes                         //////////
		//                            //   
	p1.add(p2);             //      /
		///                       //
		///////////////////////////
		
		/*=====================*/
		br1=BorderFactory.createTitledBorder("Personal details");
		br2=BorderFactory.createTitledBorder("Education details");
		br3=BorderFactory.createTitledBorder("Training details");
		breg=BorderFactory.createTitledBorder("Registration");
		brfee=BorderFactory.createTitledBorder("Fee Details");
		brdetail=BorderFactory.createTitledBorder("Personal Details");
		brd1=BorderFactory.createTitledBorder("Check Details");

		brp=BorderFactory.createTitledBorder("Payment");





		//br1.setTitlePosition(TitledBorder.LEFT);	
		
		appin=new JLabel("Appin Technology Lab.");
		appin1=new JLabel("KarolBagh New Delhi");
		error1=new JLabel();
		//error1.setText(error);
		appin.setBounds(30,10,700,50);
		appin1.setBounds(30,60,500,30);
		appin.setFont(new Font("Courier New", Font.BOLD,50));
		appin1.setFont(new Font("Courier New", Font.BOLD,20));
		error1.setFont(new Font("Courier New", Font.BOLD,15));
		error1.setForeground(Color.red);
		error1.setBounds(30, 605, 900, 30);
		p1.add(error1);

		p1.add(appin1);
		p1.add(appin);
		/*=======================*/
		
		p5=new JPanel();
		p5.setBounds(40,40,270,320);
		
        p5.setLayout(null);
        //p5.setOpaque(false);/******************modification here***********/
       // p5.setBackground(Color.green);
        p5.setOpaque(false);
        
        p5.setBorder(br1);
        p2.add(p5);
        
        p6=new JPanel();
		p6.setBounds(330,40,270,150);
        p6.setLayout(null);
        //p5.setOpaque(false);/******************modification here***********/
       // p6.setBackground(Color.cyan);
        p6.setOpaque(false);
        
        p6.setBorder(br2);
        p2.add(p6);
		
        cn=new JLabel("College Name:");
		cn.setBounds(20,30,80,20);
		p6.add(cn);
		tcn=new JTextField();
		tcn.setBounds(95,30,160,20);
		p6.add(tcn);
        
        
		br=new JLabel("Branch:");
		br.setBounds(20,60,80,20);
		p6.add(br);
		tb=new JTextField();
		tb.setBounds(95,60,160,20);
		p6.add(tb);
		
		
		
		/*=========================*/
		
		ly=new JLabel("Year:");
		ly.setBounds(20,90,80,20);
		p6.add(ly);
		//ty=new JTextField();
		//ty.setBounds(95,90,160,20);
	//	p6.add(ty);
		cy=new JComboBox();
		
		for(int ii=1995;
				ii<2015;ii++)
		{
			cy.addItem(ii);
		}
		cy.setBounds(95,90,160,20);
		p6.add(cy);
		we=new JLabel("Work Exp:");
		we.setBounds(20,120,80,20);
		p6.add(we);
		
		twe=new JTextField();
		twe.setBounds(95,120,160,20);
		p6.add(twe);
		/*==================*/
		p3=new JPanel();
		p3.setBackground(Color.gray);
		p3.setBounds(0,0,900,30);
		p3.setLayout(null);
		p2.add(p3);
		
		
		
		
		p7=new JPanel();
		p7.setBounds(330,210,270,150);
        p7.setLayout(null);
        //p5.setOpaque(false);/******************modification here***********/
       // p7.setBackground(Color.orange);
        p7.setOpaque(false);
        
        p7.setBorder(br3);
        p2.add(p7);
        
        
        tt=new JLabel("Training Type:");
		tt.setBounds(20,30,80,20);
		p7.add(tt);
		fee.coursetype();
		ct=new JComboBox();
		ct.setBounds(95,30,160,20);
		for(int ii1=0;ii1<fee.vct.size();ii1++)
		{
		ct.addItem(fee.vct.elementAt(ii1));

		}
		p7.add(ct);
	
		
		/*====================*/
	
		
		
		lt=new JLabel("Technology:");
		lt.setBounds(20,60,80,20);
		p7.add(lt);
		
		
		/**********************technology ***************/
		ctech=new JComboBox();
		ctech.addActionListener(this);
		fee.technology();
		ctech.setBounds(95,60,160,20);
		for(int ii=0;ii<fee.v.size();ii++)
		{
			ctech.addItem(fee.v.elementAt(ii));

		}
		p7.add(ctech);
		
		/*****************************technology item adding throw data base**********/
		
		/*=========================*/
		
		lf=new JLabel("Fee :");
		lf.setBounds(20,90,50,20);
		p7.add(lf);
		//lff=new JLabel("R");
		//lff.setBounds(95,90,160,20);
		lff1=new JLabel("-------");
		lff1.setBounds(95,90,160,20);
		lff1.setFont(new Font("Courier New", Font.BOLD,15));

		//lff.setText(rate);
		p7.add(lff1);
		find=new JButton("Find>");
		find.setBounds(20,120,80,20);
        find.addActionListener(this);
        p7.add(find);
        lff1.setForeground(Color.red);
		/*===============*/
		l1=new JLabel("Reg No.");
		l1.setBounds(20,5,50,20);
		p3.add(l1);
		t1=new JTextField();
		t1.setBounds(80,5,90,20);
		p3.add(t1);
		
		/*====================*/
		datetime1=new datetime();
		datetime1.date();
		//datetime1.time();
		l2=new JLabel("Time:");
		l2.setBounds(190,5,70,20);
		p3.add(l2);
		t2=new JTextField();
		//t2.setText(datetime1.dateNow);
		t2.setBounds(265,5,90,20);
		p3.add(t2);
		
		/*==================*/
		
		l3=new JLabel("Date:");
		l3.setBounds(380,5,50,20);
		p3.add(l3);
		t3=new JTextField();
		t3.setText(datetime1.dateNow);
		t3.setBounds(430,5,90,20);
		p3.add(t3);
		
		
		
		
		/*=====================*/
		
		l4=new JLabel("Name :");
		l4.setBounds(20,30,40,20);
		p5.add(l4);
		t4=new JTextField();
		t4.setBounds(95,30,160,20);
		p5.add(t4);
	
		
		/*====================*/
	
		
		
		l5=new JLabel("Father Name:");
		l5.setBounds(20,60,80,20);
		p5.add(l5);
		t5=new JTextField();
		t5.setBounds(95,60,160,20);
		p5.add(t5);
		
		
		
		/*=========================*/
		
		l6=new JLabel("Sex:");
		l6.setBounds(20,90,50,20);
		p5.add(l6);
		t6=new JTextField();
		t6.setBounds(95,90,160,20);
		p5.add(t6);
		
		/*======================*/
		
		l7=new JLabel("D.O.B:");
		l7.setBounds(20,120,40,20);
		p5.add(l7);
		
		
	   /*===============================*/
		c=new JComboBox();
		c.setBounds(95,120,40,20);
		c1=new JComboBox();
		c1.setBounds(135,120,50,20);
		c2=new JComboBox();
		c2.setBounds(185,120,70,20);
		/*c1.addItem("jan");
		c1.addItem("feb");
		c1.addItem("march");
		c1.addItem("apr");
		c1.addItem("may");
		c1.addItem("june");
		c1.addItem("july");
		c1.addItem("aug");
		c1.addItem("sep");
		c1.addItem("oct");
		c1.addItem("nov");
		c1.addItem("dec");*/
		for(int month=1;month<13;month++)
		{
			c1.addItem(month);
		}
		for(int year=1980;year<2100;year++)
		{
			c2.addItem(year);
		}
		/*c2.addItem(1985);
		c2.addItem(1986);
		c2.addItem(1987);
		c2.addItem(1988);
		c2.addItem(1989);
		c2.addItem(1990);
		c2.addItem(1991);
		c2.addItem(1992);
		c2.addItem(1993);
		c2.addItem(1994);
		c2.addItem(1995);*/

		c.addItem(1);
		c.addItem(2);
		c.addItem(3);
		c.addItem(4);
		c.addItem(5);
		c.addItem(6);
		c.addItem(7);
		c.addItem(8);
		c.addItem(9);
		c.addItem(10);
		c.addItem(11);
		c.addItem(12);
		c.addItem(13);
		c.addItem(14);
		c.addItem(15);
		c.addItem(16);
		c.addItem(17);
		c.addItem(18);
		c.addItem(19);
		c.addItem(20);
		c.addItem(21);
		c.addItem(22);
		c.addItem(23);
		c.addItem(24);
		c.addItem(25);
		c.addItem(26);
		c.addItem(27);
		c.addItem(28);
		c.addItem(29);
		c.addItem(30);
		c.addItem(31);
c.addActionListener(this);
		p5.add(c);
		p5.add(c1);
		p5.add(c2);

		
		/*======================*/
		
		
		l8=new JLabel("Email :");
		l8.setBounds(20,155,80,20);
		p5.add(l8);
		t7=new JTextField();
		t7.setBounds(95,155,160,20);
		p5.add(t7);
		
		
		
		
		
		
		/*****************************modification here********/
		
		mn=new JLabel("Mobile No:");
		mn.setBounds(20,185,80,20);
		p5.add(mn);
		tmn=new JTextField();
		tmn.setBounds(95,185,160,20);
		p5.add(tmn);
		
		add=new JLabel("Address:");
		add.setBounds(20,215,80,20);
		p5.add(add);
		tadd=new JTextArea();
		tadd.setBounds(95,215,160,60);
		p5.add(tadd);
		
		lc=new JLabel("City:");
		lc.setBounds(20,285,80,20);
		p5.add(lc);
		cbc=new JComboBox();
		cbc.setBounds(95,285,160,20);
		city12=new city();
		city12.getCity();
		for(int ii1=0;ii1<city12.city.size();ii1++)
		{
		cbc.addItem(city12.city.elementAt(ii1));

		}
		p5.add(cbc);
		
		/***************************email***************/
		
		/*=====================*/
		 b1=new JButton("Submit");
		 b1.setBounds(50,380,80,30);
		 
		 p2.add(b1);
		 b1.addActionListener(this);
		
		/*=====================*/
	
		 b2=new JButton("Payment");
		 b2.setBounds(380,380,100,30);
		 b2.setForeground(Color.red);
		 p2.add(b2);
		 b2.addActionListener(this);
		reg=new JButton("Registration:");
		reg.setBounds(140, 380, 100, 30);
		reg.addActionListener(this);
		p2.add(reg);
		

		/*=====================*/ 
	imgp=new JPanel();
	imgp.setLayout(null);
	imgp.setBounds(618, 38, 107, 137);
	imgp.setBackground(Color.darkGray);
	p2.add(imgp);
		 p4=new PicturePanel();
	     p4.setBounds(2,2,104,134);
		// p4.setBackground(Color.gray);
	   //  p4.setBackground(Color.yellow);//modification here
		 p4.setLayout(null);
		// String photo_id=adm.id();
			
		imgp.add(p4);
		 
		/*====================*/ 
		
		
		/*======================*/ 
		 b3=new JButton("Upload");
		 b3.setBounds(620,175,105,20);
		 p2.add(b3);
		 b3.addActionListener(this);
		 
		 /*=================*/
		 ct.addActionListener(this);
		 
		 
		 b4=new JButton("VISITED");
		 b4.setForeground(Color.BLUE);
		 b4.setBounds(250,380,120,30);
		 p2.add(b4);
		 b4.addActionListener(this);
		 lff1.setText("Rs. "+rate+"/-");
		 /*=====================*/
		 
		 
		 ///////////shakti coding*********************************
		 
		 pan=new JPanel();
		 pan.setBounds(30, 100, 900, 500);
		 pan.setLayout(null);
		 pan.setBackground(Color.lightGray);
		 pan1=new JPanel();
		 pan1.setBounds(0, 0, 900, 30);
		 //pan1.setLayout(null);
		 pan1.setBackground(Color.gray);
		 pan.add(pan1);
		 JLabel lab=new JLabel("Student Registration Form");
		 lab.setFont(new Font("Comic Sans Ms", Font.BOLD,18));
		 lab.setForeground(Color.cyan);
		 pan1.add(lab);
		 //TitledBorder bor=new TitledBorder();
		 bor=BorderFactory.createTitledBorder("Registration Details");
		 JLabel id=new JLabel("ID1:");
		 id.setBounds(10,10,50,20);
		// pan.add(id);
		 // txtid=new JTextField();
		 //txtid.setBounds(80,10,100,30);
		 //pan.add(txtid);
		 // Enroll=new JLabel("Enrollment No.");
		// Enroll.
		 regp=new JPanel();
		 ///pan1.add(Enroll);
		 regp.setBounds(40,40,270,220);
		 regp.setLayout(null);
		// regp.setBackground(Color.green);
		 regp.setOpaque(false);
		 regp.setBorder(breg);
		lid=new JLabel("ID :");
	lid.setBounds(20,30,80,20);
			regp.add(lid);
			txtid=new JTextField();
			//txtid.setEditable(false);
			txtid.setFocusable(true);
			txtid.setBounds(95,30,160,20);
			regp.add(txtid);
			lre=new JLabel("Enrolment:");
			lre.setBounds(20,60,80,20);
			regp.add(lre);
			tre=new JTextField();
			tre.setBounds(95,60,160,20);
			regp.add(tre);
			
			
			
			/*=========================*/
			
			lrp=new JLabel("Password:");
			lrp.setBounds(20,90,50,20);
			regp.add(lrp);
			trp=new JTextField();
			trp.setBounds(95,90,160,20);
			regp.add(trp);
			
			lrct=new JLabel("Course Type:");
			lrct.setBounds(20,120,80,20);
			regp.add(lrct);
			//trp=new JPasswordField();
			crct=new JComboBox();
			
			crct.setBounds(95,120,160,20);
			regp.add(crct);
			//regp.add(p6);
			lrtt=new JLabel("Technology:");
			
			lrtt.setBounds(20,150,80,20);
			regp.add(lrtt);
			//trp=new JPasswordField();
			crtt=new JComboBox();
			
			crtt.setBounds(95,150,160,20);
			for(int ii1=0;ii1<fee.vct.size();ii1++)
			{
			crct.addItem(fee.vct.elementAt(ii1));

			}
			for(int ii=0;ii<fee.v.size();ii++)
			{
				crtt.addItem(fee.v.elementAt(ii));

			}
			regp.add(crtt);
			submit=new JButton("Submit");
			submit.addActionListener(this);
			submit.setBounds(20, 180, 80, 20);
			regp.add(submit);
			changereg=new JButton("Change");
			changereg.setBounds(110, 180, 80, 20);
			changereg.setEnabled(false);
			regp.add(changereg);
			changereg.addActionListener(this);
		 pan.add(regp);
		 
		 pdetail=new JPanel();
		// pdetail.setBackground(Color.cyan);
		 pdetail.setLayout(null);
		 pdetail.setOpaque(false);
		 pdetail.setBounds(600, 40, 270, 220);
		 pdetail.setBorder(brdetail);
		 pan.add(pdetail);
			///pfee.setBounds(330,40,270,220);
/****************************************************************/
		 
		 
		 
		 
		 JLabel aksp01=new JLabel("Name :");
			aksp01.setBounds(20,30,80,20);
			pdetail.add(aksp01);
			aksp07=new JTextField();
			aksp07.setEditable(false);
			aksp07.setForeground(Color.red);
			aksp07.setBackground(Color.yellow);
	//	rtfe.setFont(new Font("Courier New", Font.BOLD,18));
		
			aksp07.setBounds(95,30,160,20);
			pdetail.add(aksp07);
	        
	        
		JLabel aksp02=new JLabel("Query Date:");
			aksp02.setBounds(20,60,80,20);
			pdetail.add(aksp02);
			aksp08=new JTextField();
			aksp08.setBounds(95,60,160,20);
			aksp08.setEditable(false);
			aksp08.setForeground(Color.BLUE);
			aksp08.setBackground(Color.yellow);
		//rtd.setFont(new Font("Courier New", Font.BOLD,18));


			pdetail.add(aksp08);
			JLabel aksp03=new JLabel("Phone No:");
			aksp03.setBounds(20,90,80,20);
			pdetail.add(aksp03);
			aksp09=new JTextField();
			aksp09.setBounds(95,90,160,20);
			aksp09.setEditable(false);
			aksp09.setForeground(Color.red);
			aksp09.setBackground(Color.yellow);
		//rtpaid.setFont(new Font("Courier New", Font.BOLD,18));

			pdetail.add(aksp09);
			
			
		JLabel	aksp04=new JLabel("Email :");
			aksp04.setBounds(20,120,80,20);
			pdetail.add(aksp04);
			aksp010=new JTextField();
			aksp010.setBounds(95,120,160,20);
			//aksp010.setText();
			aksp010.setEditable(false);
			aksp010.setForeground(Color.red);
			aksp010.setBackground(Color.yellow);
			pdetail.add(aksp010);
			
			JLabel	aksp05=new JLabel("Query Course:");
			aksp05.setBounds(20,150,80,20);
			pdetail.add(aksp05);
			aksp011=new JTextField();
			aksp011.setBounds(95,150,160,20);
			//aksp011.setText();
			aksp011.setEditable(false);
			aksp011.setForeground(Color.red);
			aksp011.setBackground(Color.yellow);
			pdetail.add(aksp011);
			
			JLabel	aksp06=new JLabel("Course Period");
			aksp06.setBounds(20,180,80,20);
			pdetail.add(aksp06);
			aksp012=new JTextField();
			aksp012.setBounds(95,180,160,20);
			//aksp012.setText();
			aksp012.setEditable(false);
			aksp012.setForeground(Color.red);
			aksp012.setBackground(Color.yellow);
			pdetail.add(aksp012);
		//rtpaid.setFont(new Font("Courier New", Font.BOLD,18));
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 /********************************************************/
		 
		 pfee=new JPanel();
			pfee.setBounds(320,40,270,220);
	        pfee.setLayout(null);
	        //p5.setOpaque(false);/******************modification here***********/
	        //pfee.setBackground(Color.magenta);
	        pfee.setOpaque(false);
	        pfee.setBorder(brfee);
	        rlfe=new JLabel("Total Fee:");
			rlfe.setBounds(20,30,80,20);
			pfee.add(rlfe);
			rtfe=new JTextField();
			rtfe.setEditable(false);
			rtfe.setForeground(Color.red);
			rtfe.setBackground(Color.yellow);
	//	rtfe.setFont(new Font("Courier New", Font.BOLD,18));
		
			rtfe.setBounds(95,30,160,20);
			pfee.add(rtfe);
	        
	        
			rld=new JLabel("Discount:");
			rld.setBounds(20,60,80,20);
			pfee.add(rld);
			rtd=new JTextField();
			rtd.setBounds(95,60,160,20);
			rtd.setEditable(false);
			rtd.setForeground(Color.BLUE);
			rtd.setBackground(Color.yellow);
		//rtd.setFont(new Font("Courier New", Font.BOLD,18));


			pfee.add(rtd);
			rlpaid=new JLabel("Total Pay:");
			rlpaid.setBounds(20,90,80,20);
			pfee.add(rlpaid);
			rtpaid=new JTextField();
			rtpaid.setBounds(95,90,160,20);
			rtpaid.setEditable(false);
			rtpaid.setForeground(Color.red);
			rtpaid.setBackground(Color.yellow);
		//rtpaid.setFont(new Font("Courier New", Font.BOLD,18));

			pfee.add(rtpaid);
			
			
			rldate=new JLabel("Date :");
			rldate.setBounds(20,120,80,20);
			pfee.add(rldate);
			rtdate=new JTextField();
			rtdate.setBounds(95,120,160,20);
			rtdate.setText(datetime1.dateNow);
			rtdate.setEditable(false);
			rtdate.setForeground(Color.red);
			rtdate.setBackground(Color.yellow);
		//rtpaid.setFont(new Font("Courier New", Font.BOLD,18));

			pfee.add(rtdate);
			pay=new JButton("Payment");
			pay.setBounds(20, 180, 80, 20);
			pay.addActionListener(this);
			pay.setEnabled(false);
			pfee.add(pay);
			back=new JButton("Back");
			back.setBounds(110, 180, 80, 20);
			//changereg.setEnabled(false);
			pfee.add(back);
			back.addActionListener(this);
			
			
			
			
			
	        pan.add(pfee);
		// p1.add(pan);
		 

		 
	////////////////////////////********************************************s	 
		 
		 /////////////////////////////////////////////////////////////////////////////////////////////////
	        ///////////////////////////////////////////////////////////////////////////////////////////////
	        /***********************Payment Structure**********************************************/
	        																						///
    																								///
        																							///
			///
ppayment=new JPanel();																					///
ppayment.setBounds(30, 100, 900, 500);
//ppayment.setBackground(Color.pink);///		

ppayment.setLayout(null);///
ppayment.setOpaque(false);

//p1.add(ppayment);																						///
   plp=new JPanel()   ;  
   //plp.setLayout(mgr)///
plp.setBounds(0, 0, 900, 30);
//pan1.setLayout(null);
plp.setBackground(Color.gray);
///lp.add(plp);
JLabel payment=new JLabel("Make Payment");
payment.setFont(new Font("Comic Sans Ms", Font.BOLD,18));
payment.setForeground(Color.cyan);
plp.add(payment);     																							///
ppayment.add(plp);     																						///
//re xcgp.setBounds(40,40,270,220);
ppd=new JPanel();																							///
ppd.setBounds(40, 40, 270, 320);	
ppd.setLayout(null);///
ppd.setBorder(brd1);
ppayment.add(ppd);///

pd=new JLabel("Date :");
pd.setBounds(20,30,80,20);
		ppd.add(pd);
		ptd=new JTextField(datetime1.dateNow);
		//txtid.setEditable(false);
		ptd.setFocusable(true);
		ptd.setBounds(95,30,160,20);
		ppd.add(ptd);	        																						///
	        																						///
	        																						///
    		psn=new JLabel("Slip No:");
    		
			///lre=new JLabel("Enrolment:");
			psn.setBounds(20,60,80,20);
			ppd.add(psn);
			ptsn=new JTextField();
			ptsn.setBounds(95,60,160,20);
			ppd.add(ptsn);												///
        																							///
			pid=new JLabel("ID :");																	///
    		pid.setBounds(20,90,80,20);																///
	ppd.add(pid);																					///
			ptid=new JTextField();																	///
		ptid.setBounds(95,90,160,20);																////
			ppd.add(ptid);																			///
			pen=new JLabel("Enrollment No:");																	///
    		pen.setBounds(20,120,80,20);																///
	ppd.add(pen);																					///
			pten=new JTextField();																	///
		pten.setBounds(95,120,160,20);																////
			ppd.add(pten);																					///
	        																						///
			ptp=new JLabel("Payment:");																	///
    		ptp.setBounds(20,150,80,20);																///
	ppd.add(ptp);																					///
			pttp=new JTextField();																	///
		pttp.setBounds(95,150,160,20);																////
			ppd.add(pttp);																							///
        																							///
			pp=new JLabel("Paid:");																	///
    		pp.setBounds(20,180,80,20);																///
	ppd.add(pp);																					///
			ptp1=new JTextField();																	///
		ptp1.setBounds(95,180,160,20);																////
			ppd.add(ptp1);																								///
	        																						///
					///
			pb=new JLabel("Balance:");																	///
    		pb.setBounds(20,210,80,20);																///
	ppd.add(pb);																					///
			ptb=new JTextField();																	///
		ptb.setBounds(95,210,160,20);																////
			ppd.add(ptb);																					///
			ppdback=new JButton("Home");
			ppdback.setBounds(20,270,80,20);
			ppdback.addActionListener(this);
			ppd.add(ppdback);
			//ppdback.setEnabled(false);
			
			paymentchange=new JButton("Change EMI");
			paymentchange.setBounds(110,270,100,20);
			paymentchange.addActionListener(this);
			ppd.add(paymentchange);

			/*****************************************************************************///
	        																				
			ppp=new JPanel();																							///
			ppp.setBounds(320, 40, 270, 320);	
			ppp.setLayout(null);///
			ppp.setBorder(brp);
			ppayment.add(ppp);///
///
			     																						///
			ppplt=new JLabel("Payment Type :");
			ppplt.setBounds(20,30,80,20);
					ppp.add(ppplt);
					ppptt=new JComboBox();
					ppptt.addItem("Cash");
					ppptt.addItem("Check");
					ppptt.addItem("Transfer");
					ppptt.addItem("Other");
					//txtid.setEditable(false);
					//ppptt.setFocusable(true);
				ppptt.setBounds(95,30,160,20);
					ppp.add(ppptt);	   																						///
		        																						///
	    		pppemi=new JLabel("Total EMI:");
	    		
				///lre=new JLabel("Enrolment:");
				pppemi.setBounds(20,60,80,20);
				ppp.add(pppemi);
				ppptemi=new JComboBox();
				emimang=new Emimamagement();
			
				ppptemi.setBounds(95,60,160,20);
				//ppptemi.addItem("1");
				emimang.getEmi();
					for(int emii=0;emii<emimang.emi_available.size();emii++)
				{
				ppptemi.addItem(emimang.emi_available.elementAt(emii));

				}
				ppp.add(ppptemi);												///
	        																							///
				pppemin=new JLabel("EMI No:");																	///
	    		pppemin.setBounds(20,90,80,20);																///
		ppp.add(pppemin);																					///
				ppptemin=new JTextField();
				ppptemin.setText("0");///
			ppptemin.setBounds(95,90,160,20);	
			ppptemin.setEditable(false);////
				ppp.add(ppptemin);																			///
				pppint=new JLabel("EMI Interest:");																	///
	    		pppint.setBounds(20,120,80,20);		
	    		//pppint.setEnabled(false); ///
		ppp.add(pppint);																					///
				ppptint=new JTextField();																	///
			ppptint.setBounds(95,120,160,20);	
			ppptint.setEditable(false);////.
    		ppptint.setText("0%");

				ppp.add(ppptint);	
				ppp.setOpaque(false);
				ppd.setOpaque(false);///
		        																						///
				pppp=new JLabel("Pay :");																	///
	    		pppp.setBounds(20,150,80,20);																///
		ppp.add(pppp);																					///
				ppptp=new JTextField();		
				ppptp.setEditable(false);///
			ppptp.setBounds(95,150,160,20);																////
				ppp.add(ppptp);																							///
	        																							///
				pppkit=new JLabel("Kit Issued:");																	///
	    		pppkit.setBounds(20,180,80,20);																///
		ppp.add(pppkit);																					///
				//ptp1=new JTextField();	
		pppckit=new JComboBox();///
			pppckit.setBounds(95,180,160,20);	
			kit1.getKit();
			for(int kit2=0;kit2<kit1.kit.size();kit2++)
			{
				pppckit.addItem(kit1.kit.elementAt(kit2));//
			}
			//
				ppp.add(pppckit);																								///
		        					
				ppppay=new JButton ("Calculte fee");
				ppppay.setBounds(20,270,100,20);
				ppppay.addActionListener(this);
				ppp.add(ppppay);
				
				pppcal=new JButton("Pay");
				pppcal.setBounds(130,270,100,20);
				pppcal.addActionListener(this);
				ppp.add(pppcal);
				pppcal.setEnabled(false);
				paymentchange.setEnabled(false);
				///
																										///
				/*pb=new JLabel("Balance:");																	///
	    		pb.setBounds(20,210,80,20);																///
		ppd.add(pb);																					///
				ptb=new JTextField();																	///
			ptb.setBounds(95,210,160,20);																////
				ppd.add(ptb);	*/																			///
        																							///
	        																						///
	        																						///
																									///
        																							///
	        
	        /*********************Payment Structure Ending*******************************************/
	        /////////////////////////////////////////////////////////////////////////////////////////////
	        /////////////////////////////////////////////////////////////////////////////////////////////
		 
		 
////////////////////////////********************************************s	 
			 
/////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
/***********************-------- Structure**********************************************/
																					///
																						///
																					///
																					///
																					///
			 tadd.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));																	///
																					///
																					///
																					///
				//JTextField ;
																///
				ptd.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
																				///
				ptd.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				ptsn.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				pten.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				pttp.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				ptp1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				ptb.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				ptid.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				ppptemin.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				ppptint.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				ppptp.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));																	///
																					///
				tcn.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				//ty.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				tb.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				twe.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				//aksp06.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				aksp07.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				aksp08.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				aksp09.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				aksp010.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				aksp011.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				aksp012.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				t1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
				t2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				t3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				t4.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				t5.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				t6.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				t7.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				//t8.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			//	t9.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			//	t10.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				tmn.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));	
				txtid.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				trp.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				tre.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				rtd.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				rtfe.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				rtpaid.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				rtdate.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));///
																					///
																					///
																					///
																					///
																					///
																					///
																					///
																					///
																					///
																					///
																					///
																					///
																					///
																					///
																					///

/*********************Payment Structure Ending*******************************************/
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

		 
		 
		 
//////////////////////////////////////////////////////////////////////////		 
		///////////////////////////////////////////////////
	        ///										///
	      ///										///
		 f.setSize(1000,700);						///
		f.setVisible(true);							///		
		id1=adm.id;									///
		t1.setText(id1);							///
		t1.setEditable(false);						///
		t1.setBackground(Color.yellow);				///	
	t1.setForeground(Color.red);					///
		//f.setResizable(false);					///
		///////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	}
	public static void main(String a[])
	{
	//	j.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\mylogo.png"));
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e)
		{
			
		}
	new StudentRegistration();

}
	public void getError(String error2)
	{
		
		error1.setText(null);
		error1.setText(error2);
	}
	void editfalsereg()
	{
		rtd.setEditable(false);
		rtpaid.setEditable(false);
		rtfe.setEditable(false);
		crtt.setEnabled(false);
		tre.setEditable(false);
		crct.setEnabled(false);
		txtid.setEditable(false);
		trp.setEditable(false);
		crct.setEditable(false);
		submit.setEnabled(false);
		changereg.setEnabled(false);
		pay.setEnabled(false);

	}
	void edittrueereg()
	{
		rtd.setEditable(true);
		rtpaid.setEditable(true);
		rtfe.setEditable(true);
		crtt.setEnabled(true);
		tre.setEditable(true);
		crct.setEnabled(true);
		txtid.setEditable(true);
		trp.setEditable(true);
		crct.setEditable(true);
		tre.setText("");
		trp.setText("");
		changereg.setEnabled(true);
		submit.setEnabled(true);
		pay.setEnabled(true);
		

	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==paymentchange)
		{
			ppppay.setEnabled(true);
			pppcal.setEnabled(false);
			ptd.setEditable(true);
			ptsn.setEditable(true);
			ppptt.setEnabled(true);
			ppptemi.setEditable(true);
			
			ppptt.setEnabled(true);
			ptsn.setEditable(true);
			ptsn.setText(null);
			////tre.setText(null);
			//tre.setEditable(true);
		//	/trp.setEditable(true);
			//trp.setText(null);
			pppckit.setEnabled(true);
			ppptemi.setEnabled(true);
			crct.setEnabled(true);
			submit.setEnabled(true);
			crtt.setEnabled(true);
			//ppptt
		}
		if(e.getSource()==pppcal)
		{paymentchange.setEnabled(false);
			
			ppppay.setEnabled(false);
			
			if(ppptemi.getSelectedItem().toString().equalsIgnoreCase("0"))
					{
				//paymentcheck.getPaymet(date, slipno, id, enrol, payment, paid, balance, total_emi, emi_intrest, emi_no, emi_pay, kit, paymenttype)
				paymentcheck.getPaymet(ptd.getText().toString(), ptsn.getText().toUpperCase(), ptid.getText(), pten.getText(), pay1, pay1, "Rs. 0000/-", ppptemi.getSelectedItem().toString(), ppptint.getText(), ppptemin.getText(),"Rs. 0000/-", pppckit.getSelectedItem().toString().toUpperCase(),ppptt.getSelectedItem().toString().toUpperCase());
				getError("Paymet has been successfully........");
				JOptionPane.showMessageDialog(f, "Successfully Payment Completed"+"\n"+"Slip No. "+ptsn.getText().toUpperCase()+"\n"+"ID. "+ptid.getText(), "Appin Karol Bagh", 1);
				

				
					}
			else
			{
				paymentcheck.getPaymet(ptd.getText().toString(), ptsn.getText().toUpperCase(), ptid.getText(), pten.getText(), Integer.toString(value), Integer.toString(value/te), Integer.toString(payvalue-value/te), ppptemi.getSelectedItem().toString(), ppptint.getText(), ppptemin.getText(), Integer.toString(value/te), pppckit.getSelectedItem().toString().toUpperCase(),ppptt.getSelectedItem().toString().toUpperCase());
					JOptionPane.showMessageDialog(f, "Successfully Payment Completed"+"\n"+"Slip No. "+ptsn.getText().toUpperCase()+"\n"+"ID. "+ptid.getText(), "Appin Karol Bagh", 1);

				
			}
			pan.setVisible(false);
			p1.add(p2);
			p2.setVisible(true);
			p1.remove(ppayment);
			ppptt.setEnabled(true);
			ptsn.setEditable(true);
			ptsn.setText(null);
			tre.setText(null);
			tre.setEditable(true);
			trp.setEditable(true);
			trp.setText(null);
			pppckit.setEnabled(true);
			ppptemi.setEnabled(true);
			crct.setEnabled(true);  
			paymentchange.setEnabled(false);
			ppppay.setEnabled(true);
			submit.setEnabled(true);
			crtt.setEnabled(true);
			//ptp.setText(null);
		//	ptp.sete

		}
		if(e.getSource()==ppppay)
		{	
			slipmanag slip1=new slipmanag();
			slip1.getSlip();
			if(slip1.slip.contains(ptsn.getText().toUpperCase())||slip1.slip.contains(ptsn.getText().toLowerCase())||slip1.slip.contains(ptsn.getText()))
			{
				JOptionPane.showMessageDialog(f, "This Slip No. already used", "Appin Karol Bagh", 0);
			}
			else
			{

				if(ppptt.getSelectedItem().toString().equalsIgnoreCase("cash"))

				{	
				if(ptsn.getText().equalsIgnoreCase("")||ptsn.getText().equalsIgnoreCase(null))
					{
					JOptionPane.showMessageDialog(f, "Please Enter the Slip No.", "Appin Karol Bagh", 0);
					}
				else
				{
				pppcal.setEnabled(true);

				paymentchange.setEnabled(true);
			///	System.out.println("This is Payment");
				getError("Calculating Payment............");
					if(ppptemi.getSelectedItem().toString().equalsIgnoreCase("0"))
					{
					ppptemin.setText("0");
					ppptint.setText("0%");
					ppptp.setText("Rs. "+pay1+"/-");
					pttp.setText("Rs. "+pay1+"/-");
					ptb.setText("Rs. 0000/-");
					ptp1.setText("Rs. "+pay1+"/-");
					paymentcheck=new payment();
					}
					else
					{
					String emin1=ppptemi.getSelectedItem().toString();
					paymentcheck=new payment();
					paymentcheck.getInterest("select * from EMI where TotalEMI='"+emin1+"' ");
					ppptint.setText(paymentcheck.interest+"%");
					ppptemin.setText("1");
					 te=Integer.parseInt(emin1);
					 payvalue =Integer.parseInt(pay1);
					
					 interest1=Integer.parseInt(paymentcheck.interest);
					 intev=(payvalue*interest1)/100;
					 value=payvalue+intev;
					ppptp.setText("Rs. "+Integer.toString(value/te)+"/-"); 
					ptb.setText("Rs. "+Integer.toString(payvalue-value/te)+"/-");
					pttp.setText("Rs. "+Integer.toString(value)+"/-");
					ptp1.setText("Rs. "+Integer.toString(value/te)+"/-");
					getdate=new cstd();
					//getdate.getdate(ptd.getText());
					//paymentcheck.getPaymet(ptd.getText().toString(), ptsn.getText().toUpperCase(), ptid.getText(), pten.getText(), Integer.toString(value), Integer.toString(payvalue-value/te), Integer.toString(payvalue-value/te), ppptt.getSelectedItem().toString(), ppptint.getText(), ppptemin.getText(), Integer.toString(value/te), pppckit.getSelectedItem().toString().toUpperCase(),ppptt.getSelectedItem().toString().toUpperCase());
				//	paymentcheck.getPaymet(ptd.getText(), psn.getText().toUpperCase(), ptid.getText(), pten.getText(), Integer.toString(value), Integer.toString(payvalue-value/te), Integer.toString(payvalue-value/te), ppptt.getSelectedItem().toString(), ppptint.getText(), ppptemin.getText(), Integer.toString(value/te), pppckit.getSelectedItem().toString().toUpperCase());
				ppppay.setEnabled(false);
				}
				ptd.setEditable(false);
				ptsn.setEditable(false);
				ppptt.setEnabled(false);
				ppptemi.setEnabled(false);
				pppckit.setEnabled(false);
				pppcal.setEnabled(true);
				getError(paymentcheck.error);
				
				}
				}
				else
				{
					JOptionPane.showMessageDialog(f, "Only Cash Payment ", "Appin Karol Bagh", 0);
					getError("Only cash payment................");

				}
				
				
				
			}
		}
		if(e.getSource()==ctech)
		{	//p7.remove(lff);
			fl=new feelogic();
			fl.coursetype(ct.getSelectedItem().toString());
			fl.couretechnology(ctech.getSelectedItem().toString());
			fl.feerate();
			String rate1=fl.courserate();
			getrate(rate1);
			//setRate();
			//lff1.setText(null);
		
		}
		if(e.getSource()==ct)
		{
			fl=new feelogic();
			fl.coursetype(ct.getSelectedItem().toString());
			fl.couretechnology(ctech.getSelectedItem().toString());
			fl.feerate();
			String rate1=fl.courserate();
			getrate(rate1);
		}
		if(e.getSource()==reg)
		{allreg=new AllreadyRegisterd();
			Object r=JOptionPane.showInputDialog( f, "Enter Id:", "Appin Karol Bagh", 3);
			allreg.checkregid();
			
			if(allreg.regid.contains(r.toString().toUpperCase()))
			{allreg.getId(r.toString().toUpperCase());
			allreg.getdata();
				getError("This ID: "+r.toString().toUpperCase()+" is already registered");
				txtid.setText(r.toString().toUpperCase());
			//	System.out.println(allreg.enrol);
				tre.setText(allreg.enrol.toUpperCase());
				trp.setText(allreg.pass.toUpperCase());
				crct.setSelectedItem(allreg.ct);
				crtt.setSelectedItem(allreg.tech);
				rtfe.setText("Rs. "+allreg.tfee+"/-");
				rtpaid.setText("Rs. "+allreg.tpay+"/-");
				rtd.setText(allreg.dis+"%");
				rtdate.setText(allreg.date);
				paymentcheck=new payment();
			//	paymentcheck.getRate(allreg.tfee, allreg.tpay);
				
				
				editfalsereg();



				
			}
			else
			{
				getError("Registring new ID..........");

			}
		//	System.out.println(r.toString());
			if(adm.vid.contains(r.toString().toUpperCase()))
			{allreg.getId(r.toString().toUpperCase());
				allreg.geDetails();
				aksp07.setText(allreg.aksp01);
				aksp08.setText(allreg.aksp02);
				aksp09.setText(allreg.aksp03);
				aksp010.setText(allreg.aksp04);
				aksp011.setText(allreg.aksp05);
				aksp012.setText(allreg.aksp06);
				//rtdate.setText(allreg.date.toString());
			//	System.out.println(allreg.aksp02);

				pan.setVisible(true);
				p1.add(pan);
				p2.setVisible(false);
				p1.remove(p2);
				txtid.setText(r.toString().toUpperCase());
				txtid.setEditable(false);
			
				

				
			}
			else
			{
				getError("Please take registration first........");
				JOptionPane.showMessageDialog(f, "This is not a vaild id."+"\n"+"Please submit addmission form first.", "Appin Karol Bagh", 0);
			//System.out.println("Id not found");
			
				

			}
			getError("Admission new ID..........");


		}
		if(e.getSource()==back)
		{
			/*p2.setVisible(true);
			p1.add(p2);
			pan.setVisible(false);
			p1.remove(pan);*/
			new StudentRegistration();
			f.dispose();
			edittrueereg();getError("Registration Block........");
		}
		if(e.getSource()==ppdback)
		{
			/*pan.setVisible(true);
			p1.add(pan);
			ppayment.setVisible(false);
			p1.remove(ppayment);	*/
			new StudentRegistration();
			f.dispose();
		}
		if(e.getSource()==find)
		{
			if(rate==null)
			{
			//	System.out.println("Error");
			//	getError("This Technology is not vaild"+"\n"+"for "+ct.getSelectedItem().toString().toLowerCase()");
				JOptionPane.showMessageDialog(f, "This Technology is not vaild"+"\n"+"for "+ct.getSelectedItem().toString().toLowerCase()+" period!", "Appin Karol Bagh", 2);

			}
		 lff1.setText("Rs. "+rate+"/-");
		 
		}
		if(e.getSource()==b3)
		{
			ilogic=new imagelogic();
			
		 file = ilogic.getImageFile();
		
	//	System.out.print(file);
		if (file != null) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(file);
		img = img.getScaledInstance(105, -1, Image.SCALE_SMOOTH);
		f.repaint();
		}
		b3.setLabel("Change");
		}
		if(e.getSource()==submit)
		{	enrolmanag enrolm=new enrolmanag();		
			enrolm.getEnrol();
			if(enrolm.enrol.contains(tre.getText()))
			{
				JOptionPane.showMessageDialog(f, "This enrol already registered", "Appin KarolBagh"	, 0	);
			}
			else{
				totalfee=new registrationfee();

				//rate2=totalfee.rate;
				
					totalfee.coursetype(crct.getSelectedItem().toString());
					totalfee.technology(crtt.getSelectedItem().toString());
					totalfee.feerate();
					
				//	System.out.println(totalfee.courserate());
					String rate2=totalfee.rate;
					

					if(rate2==null)
					{
						//System.out.println("Error");
						rtfe.setText("Rs. 0000.00/-");
		getError(crtt.getSelectedItem()+" is not vaild for "+crct.getSelectedItem()+" period.......");
						JOptionPane.showMessageDialog(f, "This Technology is not vaild"+"\n"+"for "+crct.getSelectedItem().toString().toLowerCase()+" period!", "Appin Karol Bagh", 2);

					}
					else
					{
						
								crct.setEnabled(false);
								crtt.setEnabled(false);
								tre.setEditable(false);
								trp.setEditable(false);
							
						
					}
					rtfe.setText("Rs. "+totalfee.rate+"/-");
					rtd.setText(totalfee.discount+"%");
					 x=Integer.parseInt(totalfee.rate);
					 y=Integer.parseInt(totalfee.discount);
					 z=x-(x*y)/100;
					 pay1=Integer.toString(z);
					rtpaid.setText("Rs. "+pay1+"/-");
					
					pay.setEnabled(true);
					submit.setEnabled(false);
					changereg.setEnabled(true); 
				
			}
			
			
		}
		if(e.getSource()==pay)

		{if(tre.getText().equalsIgnoreCase(""))
		{
			getError("Please Enter Enrolement.........");
			JOptionPane.showMessageDialog(f, "Enter Enrolment", "Appin Karolbage", 3);

		}
		else
		{
			if(trp.getText().equalsIgnoreCase(""))
			{
				getError("Please Enter Password..............");
				JOptionPane.showMessageDialog(f, "Enter Password", "Appin Karolbage", 3);

			}
			else
			{
				reginst=new registrationinsert();
				reginst.regdate(rtdate.getText());
				reginst.enrolstudent(txtid.getText().toUpperCase(), tre.getText().toUpperCase(), trp.getText(), crct.getSelectedItem().toString().toUpperCase(), crtt.getSelectedItem().toString().toUpperCase(), Integer.toString(x), Integer.toString(y), Integer.toString(z));
				JOptionPane.showMessageDialog(f, "Registration successfull", "Appin Karol Bagh", 3);
				ppayment.setVisible(true);
				p1.add(ppayment);
				pan.setVisible(false);
				p1.remove(pan);	
				//allreg=new AllreadyRegisterd();
				ptid.setText(txtid.getText());
				pten.setText(tre.getText());
			//	pttp.setText(t)
				pttp.setText(rtpaid.getText());
				ptp1.setText("Rs. 0000/-");
				ptb.setText(rtpaid.getText());
			//	rtd.setText(allreg.dis+"%");
				getError("Making Payment................");
				ptid.setEditable(false);
				pten.setEditable(false);
				pttp.setEditable(false);
				ptp1.setEditable(false);
				ptb.setEditable(false);
			}
		}
			
		
		}
		if(e.getSource()==changereg)
		{
			pay.setEnabled(false);
			submit.setEnabled(true);
			changereg.setEnabled(false);
			crct.setEnabled(true);
			crtt.setEnabled(true);
			tre.setEditable(true);
			trp.setEditable(true);
		}
		if(e.getSource()==b1)
		{
			if(t6.getText().equalsIgnoreCase("")||t5.getText().equalsIgnoreCase("")||t7.getText().equalsIgnoreCase("")||tmn.getText().equalsIgnoreCase("")||tadd.getText().equalsIgnoreCase("")||tcn.getText().equalsIgnoreCase("")||tb.getText().equalsIgnoreCase("")||twe.getText().equalsIgnoreCase(""))
			{
				
				error="Enter in all fields";

				getError(error);
				JOptionPane.showMessageDialog(f, "Enter in all fields", "Appin Karolbage", 2);

			}
			else
				
			{System.out.println("file"+file);
			
			if(file==null||file==""||file.equalsIgnoreCase(null)||file.equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(f, "Please Upload photo", "Appin Karolbage", 2);

			}
			else
			{
				imageStore photo22=new imageStore();
				//try {
					photo22.saveImg(t1.getText().toUpperCase(), t4.getText().toUpperCase(), file);
				//} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					//e2.printStackTrace();
				//} catch (SQLException e2) {
					// TODO Auto-generated catch block
				//	e2.printStackTrace();
				//}
			String Dob=c.getSelectedItem().toString()+"/"+c1.getSelectedItem().toString()+"/"+c2.getSelectedItem().toString();
			//System.out.println(Dob);
			SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
			try {
				 date = parseDate(Dob, "dd/MM/yyyy");
				// System.out.println(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			adm.querydate(t3.getText());
			adm.personaldetail(t4.getText().toString().toUpperCase(), t5.getText().toString().toUpperCase(), t6.getText().toString().toUpperCase(), date, t7.getText().toString(), tmn.getText().toString(), tadd.getText().toString().toUpperCase(), cbc.getSelectedItem().toString().toUpperCase());
			adm.eductionaldetail(tcn.getText().toString().toUpperCase(), tb.getText().toString().toUpperCase(), cy.getSelectedItem().toString(), twe.getText().toString());
		adm.trainingdetatil(ct.getSelectedItem().toString().toUpperCase(), ctech.getSelectedItem().toString(), rate);
			
		adm.insertingdetails();/*	adm.id();
			String id1=adm.id;
			t1.setText(id1);*/
		error="Record added ID: "+adm.id;

		JOptionPane.showMessageDialog(f, "Record Added"+"\n"+"Your ID: "+adm.id, "Appin Karol Bagh", 1);
		adm.id();
		
		t1.setText(adm.id);

		t4.setText("");
		t5.setText("");
		t6.setText("");
		tcn.setText("");
		tb.setText("");
		twe.setText("");
		tadd.setText("");
		tmn.setText("");
		t7.setText("");
		founderror=new ErrorMessage();
		founderror.errorfind(error);

		getError(error);
		
new StudentRegistration();
f.dispose();

			}
				
		}
			
		}
		if(e.getSource()==b4)
		{new StudentInformation();
			//Object old=JOptionPane.showInputDialog( f, "Enter Id:", "Appin Karol Bagh", 3);
			f.dispose();
		
		//	f.getFrames();
		
		}
		if(e.getSource()==b2)
		{
			Object[] selectionValues = { "First Time Payment", "Next Payment" };
		    //String initialSelection = "Dogs";
		    Object selection = JOptionPane.showInputDialog(null, "Select One",
		        "Appin Karol Bagh", JOptionPane.QUESTION_MESSAGE, null, selectionValues,null);
		   // System.out.println(selection);
		    if(selection.toString().equalsIgnoreCase("Next Payment"))
		    {
		    	f.dispose();
				new graphic();
		    }
		    else
		    {
		    	  if(selection.toString().equalsIgnoreCase("First Time Payment"))
		    	  {
		    		  
		    		  
		    		  allreg=new AllreadyRegisterd();
		  			Object r=JOptionPane.showInputDialog( f, "Enter Id:", "Appin Karol Bagh", 3);
		  			allreg.checkregid();
		  			
		  			if(allreg.regid.contains(r.toString().toUpperCase()))
		  			{
		  				allreadypaymentfirst satya=new allreadypaymentfirst();
		  				satya.getPaymentID();
		  				//System.out.println(satya.paymentID);

		  				if(satya.paymentID.contains(r.toString().toUpperCase()))
		  				{
		  					getError("Check Payment details......");
			  				JOptionPane.showMessageDialog(f,"Allready Payment Deposite "+"\n"+"Check Payment details","Appin Karol ",0);
		  				}
		  				else
		  				{

			  				allreg.getId(r.toString().toUpperCase());
			  			allreg.getdata();
			  				getError("This ID: "+r.toString().toUpperCase()+" is already registered");
			  				txtid.setText(r.toString().toUpperCase());
			  			//	System.out.println(allreg.enrol);
			  			//	tre.setText(allreg.enrol.toUpperCase());
			  			////	trp.setText(allreg.pass.toUpperCase());
			  				//crct.setSelectedItem(allreg.ct);
			  			//	crtt.setSelectedItem(allreg.tech);
			  				//rtfe.setText("Rs. "+allreg.tfee+"/-");
			  				//rtpaid.setText("Rs. "+allreg.tpay+"/-");
			  				//rtd.setText(allreg.dis+"%");
			  				//rtdate.setText(allreg.date);
			  			//	paymentcheck=new payment();
			  			//	paymentcheck.getRate(allreg.tfee, allreg.tpay);
			  				
			  				
			  				
			  				
			  				
			    		  reginst=new registrationinsert();
							reginst.regdate(rtdate.getText());
							//reginst.enrolstudent(txtid.getText().toUpperCase(), tre.getText().toUpperCase(), trp.getText(), crct.getSelectedItem().toString().toUpperCase(), crtt.getSelectedItem().toString().toUpperCase(), Integer.toString(x), Integer.toString(y), Integer.toString(z));
							//JOptionPane.showMessageDialog(f, "Registration successfull", "Appin Karol Bagh", 3);
							ppayment.setVisible(true);
							p1.add(ppayment);
							p2.setVisible(false);
							p1.remove(p2);	
							//allreg=new AllreadyRegisterd();
							ptid.setText(r.toString().toUpperCase());
							pten.setText(allreg.enrol.toUpperCase());
						//	pttp.setText(t)
	pay1=allreg.tpay;
							pttp.setText("Rs. "+allreg.tpay+"/-");
							ptp1.setText("Rs. 0000/-");
							ptb.setText("Rs. "+allreg.tpay+"/-");
						//	rtd.setText(allreg.dis+"%");
							getError("Making Payment................");//sf
							ptid.setEditable(false);
							pten.setEditable(false);
							pttp.setEditable(false);
							ptp1.setEditable(false);
							ptb.setEditable(false);
		  					
		  					/************************************************/
		  					
		  				}
		    	  }
		  			else
		  			{
		  				getError("ID not found");
		  				JOptionPane.showMessageDialog(f,"Enter Valid ID ","Appin Karol ",0);
		  			}
		    }
			
		    }
		}
	}
	private Date parseDate(String date, String format) throws ParseException
	{
	        SimpleDateFormat formatter = new SimpleDateFormat(format);
	        return formatter.parse(date);
	}
class PicturePanel extends JPanel {
public void paint(Graphics g) {
g.drawImage(img, 0, 0, this);
}

}}