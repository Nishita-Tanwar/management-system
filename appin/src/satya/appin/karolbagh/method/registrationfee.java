package satya.appin.karolbagh.method;

import satya.appin.karolbagh.connection.connection;

public class registrationfee {
	public String rate,discount;
	String course1;
	String tech1;
	String course2;
	String tech2;
	connection con;
	public void coursetype(String course)
	{
		course1=course;
		
	}
	public void technology(String tech)
	{
		tech1=tech;
	}
	public   String  courserate()
	 {
		
		 return rate;
	 }

	 public void feerate()
	 {
		 try
			{
			con=new connection();
			con.sql="select * from course";
			con.connect();
			while(con.rs.next())
			{
			course2=con.rs.getString(1);
			
		if(course2.equalsIgnoreCase(course1))
			{
				tech2=con.rs.getString(2);
				if(tech2.equalsIgnoreCase(tech1))
				{

					rate=con.rs.getString(3);
					discount=con.rs.getString(4);
				//	System.out.println(rate);
					//System.out.println(vct1+"\t"+vc1+"\t"+vr1);


				}
				

				
			}
		
			
			}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				System.out.println("Error in connection fee");
			}
	 }
	

}
