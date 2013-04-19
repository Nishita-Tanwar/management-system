package satya.appin.karolbagh.method;

import java.util.Vector;

import satya.appin.karolbagh.connection.connection;

public class slipmanag {
connection con;
public Vector slip;
public void getSlip()
{
	slip=new Vector();
	con=new connection();
	con.sql="select * from  payment";
	con.connect();
	try
	{
		while(con.rs.next())
		{
			String s=con.rs.getString(2);
			slip.addElement(s);
		}
	//	System.out.println(slip);
	}
	catch(Exception e)
	{
		System.out.println("Error in silpmanag file");
	}
}
}

