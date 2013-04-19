package test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class form implements ActionListener
{
	JFrame f;
	JButton button;
	JTextField textfield;
	JPasswordField textarea;
	
	JRadioButton sex ;
	JRadioButton sexf;
	JComboBox courses;
	JCheckBox hobbies;
	JCheckBox hobbies2;
	JCheckBox hobbies3;
	JCheckBox hobbies4;
	JCheckBox hobbies5;
	
	
	
	form()
	{
		f = new JFrame("Registration Form");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		JLabel l = new JLabel("Username");
		JLabel l2 = new JLabel("Password");
		JLabel l3 = new JLabel("Sex");
		JLabel l4 = new JLabel("Courses");
		JLabel l5 = new JLabel("Hobbies");
		JTextField textfield = new JTextField();
		JPasswordField textarea = new JPasswordField();
		button = new JButton("Submit");
		JRadioButton sex = new JRadioButton("M");
		JRadioButton sexf = new JRadioButton("F");
		JComboBox courses = new JComboBox();
		JCheckBox hobbies = new JCheckBox("Sports");
		JCheckBox hobbies2 = new JCheckBox("Reading");
		JCheckBox hobbies3 = new JCheckBox("Travelling");
		JCheckBox hobbies4 = new JCheckBox("Shopping");
		JCheckBox hobbies5 = new JCheckBox("Other");
		
		
		
		courses.addItem("Core Java");
		courses.addItem("Advance Java");
		courses.addItem("Ethical Hacking");
		courses.addItem(".NET");
		courses.addItem("Python");
		
		
		ButtonGroup gen=new ButtonGroup();
		button.setBounds(350,500,100,40);
		textarea.setBounds(90,100,100,20);
		textfield.setBounds(90,50,100,20);
		l2.setBounds(20,100,70,20);
		l.setBounds(20,50,70,20);
		l3.setBounds(20,150,40,20);
		l4.setBounds(20,200,50,20);
		l5.setBounds(20,250,70,20);
		sex.setBounds(90,150,40,20);
		sexf.setBounds(130,150,40,20);
		gen.add(sexf);
		gen.add(sex);
		courses.setBounds(90,200,100,20);
		hobbies.setBounds(90,250,100,20);
		hobbies2.setBounds(190,250,100,20);
		hobbies3.setBounds(290,250,100,20);
		hobbies4.setBounds(90,280,100,20);
		hobbies5.setBounds(190,280,100,20);
		button.addActionListener(this);
		
		f.add(textfield);
		f.add(hobbies);
		f.add(hobbies2);
		f.add(hobbies3);
		f.add(hobbies4);
		f.add(hobbies5);
		f.add(textarea);
		f.add(l);
		f.add(l2);
		f.add(l3);
		f.add(button);
		f.add(sex);
		f.add(sexf);
		f.add(courses);
		f.add(l4);
		f.add(l5);
		f.add(hobbies);
		f.setSize(800,600);
		f.setVisible(true);
		
	}
	public static void main(String args[])
	{
		new form();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==button )
		{
			String sql="insert into user values(?,?,?,?,?)";
			//coon con=new coon();
		//	con.connect(sql, "anand");
		//	connect(sql, textfield.getText());
			System.out.println("Success!");
		}
	}

}

