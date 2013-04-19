package satya.appin.karolbagh.secondmodule.method;

import java.util.Vector;

import satya.appin.karolbagh.connection.connection;
import satya.appin.karolbagh.secondmodule.graphics.showPersonalInfo;

public class PersonalInfo {
	connection con;
	public String sql, id, name;
	//public Vector personal;
	
	public void getDetails()
	{con=new connection();
	con.sql=sql;
	con.connect();
	try
	{
		con.rs.next();
		name=con.rs.getString(2);
		showPersonalInfo info=new showPersonalInfo();
		info.getDetails(con.rs.getString(1), name, con.rs.getString(3), con.rs.getString(4), con.rs.getString(5), con.rs.getString(7), con.rs.getString(6), con.rs.getString(8), con.rs.getString(9), con.rs.getString(10), con.rs.getString(11), con.rs.getString(12), con.rs.getString(13), con.rs.getString(14), con.rs.getString(15));

	}
	catch(Exception e)
	{
		System.out.println("Error in PersonalInfo");
	}
	//System.out.println(id+name);
	}

}
