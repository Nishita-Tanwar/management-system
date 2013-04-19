package satya.appin.karolbagh.method;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class datetime {
	 Calendar c,c1;
	 public SimpleDateFormat date;
	public SimpleDateFormat time;
	 public String dateNow,timeNow;
	 public void date()
	 {
		 c=Calendar.getInstance();
		 date= new SimpleDateFormat("dd/MM/yyyy");
		  String dateNow1 = date.format(c.getTime());
		  dateNow=dateNow1;

		System.out.println(dateNow);
		// date1=date;
	 }
	/* public void time()
	 {
		 c1=Calendar.getInstance();
		 time= new SimpleDateFormat("HH:mm:ss");
		  String time1 = time.format(c1.getTime());
		  dateNow=time1;
	//	 System.out.println(time1);
	 }
	public static void main(String a[])
	{
		new datetime().date();
	}*/

}
