package satya.appin.karolbagh.method;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class cstd {
	String date1;
	public Date time;
	
	public	void getdate(String date)
	{
		//System.out.println(date);
		date1=date;
		System.out.println(date1);
		try 
		{
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			time = formatter.parse(date1);;
			System.out.print(time);
			
		} 
		catch (ParseException e1)
		{
			e1.printStackTrace();
		}
	}
	
}
