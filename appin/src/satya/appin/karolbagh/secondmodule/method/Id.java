package satya.appin.karolbagh.secondmodule.method;

import java.util.Vector;

import satya.appin.karolbagh.connection.connection;

public class Id {
	connection con;
	public Vector id,regID,paymentID;
	
	public void getId()
	{
		id=new Vector();
		con=new connection();
		con.sql="select * from details";
		con.connect();
		try
		{while(con.rs.next())
		{
			id.addElement(con.rs.getString(1));
		}
		//System.out.println(id);
			
		}
		catch(Exception e)
		{
			System.out.println("Error in ID file");
		}	
	}
	public void getRegID()
	{
		regID=new Vector();
		con=new connection();
		con.sql="select * from enrollstudent";
		con.connect();
		try
		{while(con.rs.next())
		{
			regID.addElement(con.rs.getString(1));
		}
		//System.out.println(id);
			
		}
		catch(Exception e)
		{
			System.out.println("Error in ID file");
		}	
	}
	public void getPaymentID()
	{paymentID=new Vector();
	con=new connection();
	con.sql="select * from payment";
	con.connect();
	try
	{while(con.rs.next())
	{
		regID.addElement(con.rs.getString(1));
	}
	//System.out.println(id);
		
	}
	catch(Exception e)
	{
		System.out.println("Error in ID file");
	}	
		
	}

}
