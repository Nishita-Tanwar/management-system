package satya.appin.karolbagh.method;

import java.util.Vector;

import satya.appin.karolbagh.connection.connection;

public class kit {
	connection con;
	public Vector kit;
	public void getKit()
	{con=new connection();
		kit=new Vector();
		try
	{ 
		con.sql="select * from kit";
		con.connect();
		while(con.rs.next())
		{
		String kit1=con.rs.getString(2);
		kit.add(kit1);
		//System.out.println(kit);
		}
	}
	catch(Exception e)
	{
		System.out.print("Error in kit file");
	}
		
	}

}
