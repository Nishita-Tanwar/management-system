package satya.appin.karolbagh.method;

import java.util.Vector;

import satya.appin.karolbagh.connection.connection;

public class enrolmanag {
connection con;
public Vector enrol;
public void getEnrol()
{enrol=new Vector();
	con=new connection();
	con.sql="select * from  enrollstudent";
	con.connect();
	try
	{
		while(con.rs.next())
		{
			String z=con.rs.getString(2);
			enrol.addElement(z);

		}
		//System.out.print(enrol);
	}
	catch(Exception e)
	{
		System.out.println("Error in enrolmanag file");
	}
}
/*public static void main(String a[])
{
	new enrolmanag().getEnrol();
}*/
}
