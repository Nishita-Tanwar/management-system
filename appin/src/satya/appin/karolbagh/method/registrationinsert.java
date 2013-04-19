package satya.appin.karolbagh.method;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import satya.appin.karolbagh.connection.connection;

public class registrationinsert {
	String id1, enrol1, pass1, coursetype1, technology1, fee1, dis1, pay1,regdate;
	Date datereg;
	connection con;
	public void enrolstudent(String id, String enrol,String pass,String coursetype, String Technology,String fee,String discount, String pay)
	{
		id1=id;
		enrol1=enrol;
		pass1=pass;
		coursetype1=coursetype;
		technology1=Technology;
		fee1=fee;
		dis1=discount;
		pay1=pay;
		//System.out.println(id1+enrol1+pass1+coursetype1+technology1+fee1+dis1+pay1);
		insert();
		
	}
public	void regdate(String date)
	{
		regdate=date;
	///	System.out.println(regdate);
		//SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		try {
			datereg = parseDate(regdate, "dd/MM/yyyy");
			
			// System.out.println(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private Date parseDate(String date, String format) throws ParseException
	{
	        SimpleDateFormat formatter = new SimpleDateFormat(format);
	        return formatter.parse(regdate);
	}
	void insert()
	{
		 con=new connection();
		 try{
		 con.sql1="insert into enrollstudent values(?,?,?,?,?,?,?,?,?)";
		 con.insertconnect();

			
			
			java.sql.Date sqlDatequery = new java.sql.Date(datereg.getTime());

			con.pstm.setString(1, id1);
				con.pstm.setString(2, enrol1);
				con.pstm.setString(3, pass1);
				con.pstm.setString(4, coursetype1);
				con.pstm.setString(5, technology1);
				con.pstm.setString(6, fee1);
				con.pstm.setString(7, dis1);
				con.pstm.setString(8, pay1);
				con.pstm.setDate(9, sqlDatequery);

				
			
				
				con.pstm.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error in insert registration insert file");
			}
			
	}
}
