package test.andy;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class lay {
	JFrame f;
	JButton b1,b2,b3,b4,b5;
	lay()
	{
		f=new JFrame("flow layout use");
		f.setLayout(new FlowLayout());
		b1=new JButton("enter1");
		b2=new JButton("enter2");
		b3=new JButton("enter3");
		b4=new JButton("enter4");
		b5=new JButton("enter5");
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.pack();
		f.show();
		//f.setSize(200,200);
		//f.setVisible(true);
	}
		public static void main(String a[])
		{
			
			new lay();
		}
		
		
			   
			  
				
		
		
	

}
