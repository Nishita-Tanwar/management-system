package satya.appin.karolbagh.method;

import java.util.Vector;

import satya.appin.karolbagh.connection.connection;

public class feedetails {
	public Vector v;
	public Vector vct;
	connection con;
	public String vs;
	public String rupee;
	
		
	
	public void technology()
	{
		v=new Vector();
		try
		{
		con=new connection();
		con.sql="select * from course";
		con.connect();
		while(con.rs.next())
		{
		vs=con.rs.getString(2);
		if(v.contains(vs.toUpperCase())==true)
		{
			
		}
		else
		{
			v.add(vs.toUpperCase());//vct.remove(vs);
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error in connection fee");
		}
	}
	
	public void coursetype()
	{
		vct=new Vector();
		try
		{
		con=new connection();
		con.sql="select * from course";
		con.connect();
		while(con.rs.next())
		{
		vs=con.rs.getString(1);
		if(vct.contains(vs.toUpperCase())==true)
		{
			//

		}
		else
		{
			vct.add(vs.toUpperCase());//vct.remove(vs);
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error in connection fee");
		}
	}
	/*public void rupee(String sql)
	{
		
		
		try
		{con=new connection();
			con.sql=sql;
			con.connect();
			//con.rs.next();
		
			while(con.rs.next())
			{
			rupee=con.rs.getString(3).to;
			}
			//return sql=con.rs.getString(3).toString();
		}
		catch(Exception e)
		{
			
		}
		
		
	}*/

}
