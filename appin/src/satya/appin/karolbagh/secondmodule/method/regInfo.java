package satya.appin.karolbagh.secondmodule.method;

import java.util.Vector;

import satya.appin.karolbagh.connection.connection;
import satya.appin.karolbagh.secondmodule.graphics.showRegInfo;

public class regInfo {
	connection con;
	public String sql, id, name;
	public Vector reg;
	
	public void getDetails()
	{
		con=new connection();
	con.sql=sql;
	con.connect();
	try
	{
		con.rs.next();
		//name=con.rs.getString(2);
		showRegInfo info=new showRegInfo();
		
		info.getDetails(con.rs.getString(1), con.rs.getString(2), con.rs.getString(3), con.rs.getString(4), con.rs.getString(5), con.rs.getString(6), con.rs.getString(7),con.rs.getString(8), con.rs.getDate(9));
//System.out.println(con.rs.getDate(9));
	}
	catch(Exception e)
	{
		System.out.println("Error in Reginfo");
	}
	//System.out.println(id+name);
	}

}
