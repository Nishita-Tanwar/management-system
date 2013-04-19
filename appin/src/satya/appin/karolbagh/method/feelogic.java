package satya.appin.karolbagh.method;

import java.util.Vector;

import satya.appin.karolbagh.connection.connection;
import satya.appin.karolbagh.graphics.StudentRegistration;

public class feelogic {
	connection con;

	 String vct1,vc1,vr1, ct1, ctech1, cr1;
	 
	 public void coursetype(String ct)
	 {
		 ct1=ct;
	 }
	 public void couretechnology(String ctech)
	 {
		 ctech1=ctech;
	 }
	 public   String  courserate()
	 {
		
		 return vr1;
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
			vct1=con.rs.getString(1);
			
		if(vct1.equalsIgnoreCase(ct1))
			{
				vc1=con.rs.getString(2);
				if(vc1.equalsIgnoreCase(ctech1))
				{

					vr1=con.rs.getString(3);
					
					//System.out.println(vct1+"\t"+vc1+"\t"+vr1);


				}
				

				
			}
		
			
			}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				//System.out.println("Error in connection fee");
			}
	 }
	
	

}
