package satya.appin.karolbagh.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class connection {
	Statement smt;
	public ResultSet rs;
	public String sql,sql1;
	Connection con;
	public PreparedStatement pstm;
	public void connect()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:satya");
			smt=con.createStatement();
		rs=smt.executeQuery(sql);
			/*rs=smt.executeQuery("select * from course");
			while(rs.next());
			{
				System.out.println(rs.getString(1));
			}

		//	pstm=con.prepareStatement(sql1);
			
			//rs.next();*/

		}
		catch(Exception e)
		{e.printStackTrace();
			System.out.println("Error in Connetion main file");
		}
	}
	public static void main(String a[])
	{
		new connection().connect();
	}
	public void insertconnect()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:satya");
			smt=con.createStatement();
			//rs=smt.executeQuery(sql);
			pstm=con.prepareStatement(sql1);
			
			//rs.next();

		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error in Connetion main file for insert");
		}
	}

}
