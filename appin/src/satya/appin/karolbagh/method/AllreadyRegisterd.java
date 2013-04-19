package satya.appin.karolbagh.method;

import java.util.Date;
import java.util.Vector;

import satya.appin.karolbagh.connection.connection;

public class AllreadyRegisterd {
	connection con;
	public Vector regid;
	public String aksp01,aksp03,aksp04,aksp05,aksp06,aksp000;
	public String enrol,pass,ct,tech,tfee,dis,tpay,id1,aksp02;
	public String date;
	public void checkregid()
	{regid=new Vector();
		try
		{con=new connection();
			con.sql="select * from enrollstudent";
			con.connect();
			while(con.rs.next())
			{
			String id=	con.rs.getString(1);
			/*enrol=con.rs.getString(2);
			pass=con.rs.getString(3);
			ct=con.rs.getString(4);
			tech=con.rs.getString(5);
			tfee=con.rs.getString(6);
			dis=con.rs.getString(7);
			tpay=con.rs.getString(8);
			date=con.rs.getDate(9);*/
			regid.add(id);
			//	System.out.println(regid);
				
				
			}
		}
		catch(Exception e)
		{e.printStackTrace();
			System.out.println("Error in allready registrated file");
		}
	}
	public void getId(String id)
	{
		id1=id;
	}
	public void getdata()
	{
		try
		{con=new connection();
			con.sql="select * from enrollstudent where ID='"+id1+"' ";
			con.connect();
			while(con.rs.next())
			{
			id1=	con.rs.getString(1);
			enrol=con.rs.getString(2);
			pass=con.rs.getString(3);
			ct=con.rs.getString(4);
			tech=con.rs.getString(5);
			tfee=con.rs.getString(6);
			dis=con.rs.getString(7);
			tpay=con.rs.getString(8);
			date=con.rs.getString(9);
			
			//regid.add(id);
				//System.out.println(regid);
				
			}
		}
		catch(Exception e)
		{e.printStackTrace();
			System.out.println("Error in allready registrated file");
		}
	}
	public void geDetails()
	{
		try
		{con=new connection();
			con.sql="select * from details where ID='"+id1+"' ";
			con.connect();
			while(con.rs.next())
			{
				//System.out.println(id1);
				aksp01=con.rs.getString(2);
			aksp02=con.rs.getString(15);
				aksp03=con.rs.getString(7);
				
				aksp04=con.rs.getString(6);
				aksp05=con.rs.getString(14);
				aksp06=con.rs.getString(13);
				//System.out.println(con.rs.getString(15));
				
			}
		}
		catch(Exception e)
		{e.printStackTrace();
			 aksp000="Error in allready registrated file getDetails";
			// System.out.println(aksp000);
		}
	}

}
