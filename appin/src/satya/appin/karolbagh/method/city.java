package satya.appin.karolbagh.method;

import java.sql.SQLException;
import java.util.Vector;

import satya.appin.karolbagh.connection.connection;

public class city {
public Vector city;

public  void getCity()
{
	city=new Vector();
	connection con=new connection();
	con.sql="select city from city";
	con.connect();
	try {
		while(con.rs.next())
		{
			String city1=con.rs.getString("city");
			city.add(city1.toUpperCase());
		}
		//System.out.println(city);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void main(String a[])
{
	new city().getCity();
}
}
