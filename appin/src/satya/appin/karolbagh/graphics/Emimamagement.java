package satya.appin.karolbagh.graphics;

import java.util.Vector;

import satya.appin.karolbagh.connection.connection;

public class Emimamagement {
	connection con;
	public Vector emi_available;
	public void getEmi()
	{emi_available=new Vector();
		con=new connection();
		con.sql="select * from EMI ";
		con.connect();
		try
		{
			while(con.rs.next())
			{
				String emiavil=con.rs.getString(1);
				emi_available.add(emiavil);
				//System.out.println(emi_available);
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in emi file");
			
		}
	}

}
