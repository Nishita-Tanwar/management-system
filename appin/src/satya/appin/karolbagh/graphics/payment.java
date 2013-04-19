package satya.appin.karolbagh.graphics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import satya.appin.karolbagh.connection.connection;
import satya.appin.karolbagh.method.cstd;

public class payment {
	connection con;
public String error;
Date paydate;

public String interest,date2;
public void getPaymet(String date, String slipno,String id, String enrol,String payment, String paid, String balance,String total_emi,String emi_intrest, String emi_no,String emi_pay,String kit,String paymenttype)
{con=new connection();
// System.out.println(date+slipno+id+enrol+payment+paid+balance+total_emi+emi_intrest+emi_no+emi_pay+kit+paymenttype);
con.sql1="insert into payment values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
con.insertconnect();
try
{
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	paydate = formatter.parse(date);;	
	java.sql.Date sqlDatequery1 = new java.sql.Date(paydate.getTime());
	//System.out.print(paydate);
	con.pstm.setDate(1, sqlDatequery1);
	con.pstm.setString(2,slipno);
	con.pstm.setString(3, id);
	con.pstm.setString(4, enrol);
	con.pstm.setString(5, payment);
	con.pstm.setString(6, paid);
	con.pstm.setString(7, balance);
	con.pstm.setString(8, paymenttype);
	con.pstm.setString(9, total_emi);
	con.pstm.setString(10, emi_no);
	con.pstm.setString(11, emi_intrest);
	con.pstm.setString(12, emi_pay);
	con.pstm.setString(13, kit);
	con.pstm.setString(14, "--");
	con.pstm.setString(15, "--");
	con.pstm.setString(16, "--");
	con.pstm.setString(17, "--");
	con.pstm.setString(18, "--");
	con.pstm.setString(19, "--");
	con.pstm.setString(20, "--");
	con.pstm.setString(21, "--");
	con.pstm.setString(22, "--");
	con.pstm.setString(23, "--");
	con.pstm.setString(24, "--");
	con.pstm.setString(25, "--");
	con.pstm.setString(26, "--");
	con.pstm.setString(27, "--");
	con.pstm.executeUpdate();
	
}
catch(Exception e)
{
	e.printStackTrace();
	System.out.println("Errro in payment");
	error="This slip No. is already used..........";
}
	
}
public void getInterest(String sql)
{
con=new connection();
//System.out.println(sql);
con.sql=sql;
con.connect();
try
{
	con.rs.next();
		interest=con.rs.getString(2);
	
}
catch(Exception e)
{
	
}

}

void setPayment()
{
	con=new connection();
con.sql="select * from  payment";
	//con.sql="select * from  details";
	
	try
	{con.connect();
		while(con.rs.next())
	{
		String kit=con.rs.getString(13);
	if(kit==null||kit==null)
		{
			//System.out.println("Stop");
			
			//break;
		}
	else
		{
		//System.out.println(kit);
		}
		//System.out.println(kit);
		//
	}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
/*public static void main(String a[])
{
	new payment().setPayment();
}*/
}
