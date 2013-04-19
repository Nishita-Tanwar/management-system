package satya.appin.karolbagh.payment;

import java.sql.SQLException;

import satya.appin.karolbagh.connection.connection;

public class logic {
	connection con;

	
	public void getPaymetDetails(String SQL)
	{
		con=new connection();
		con.sql=SQL;
		con.connect();
		try {
			while(con.rs.next())
			{
				//System.out.println(con.rs.getString("Slip no"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void getPersonaldetails(String SQL)
	{
		
	}

}
