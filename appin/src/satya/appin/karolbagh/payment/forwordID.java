package satya.appin.karolbagh.payment;

import java.sql.SQLException;
import java.util.Vector;

import satya.appin.karolbagh.connection.connection;

public class forwordID {
	
	int totalpaid=0;
	int totalpay=0;
	int totalbalance=0;
	String getID;
	Vector Emi;
	
	
public void getID(String ID)

{
	getID=ID;
	show display=new show();
	//display.totalpaymencheck();
	display.getdata(ID);
	display.getPayment();
	display.pay();
	display.balance();
	display.getEmit();
	display.currentpay();
	display.erolldetail();
}

/*public void getEmit(String ID)
{Emi=new Vector();
	connection con=new connection();
	con.sql="select Emi_no from payment where id='"+ID+"'";
	con.connect();
	try {
		while(con.rs.next())
		{
			String pay=con.rs.getString("Emi_no");
			
			totalpay=Integer.parseInt(pay);
			Emi.addElement(totalpay);
			System.out.println("total payment "+pay);
		}
		
		System.out.println(Emi);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int x=1;x<6;x++)
	{
		if(Emi.contains(x))
		{
			
		}
		else
		{
			System.out.println("CurrenctEmi "+x);
		}
	}
}

*/


public void balance()
{
	totalbalance=totalpay-totalpaid;
	//System.out.println("Balance "+totalbalance);
	
}
public static void main(String a[])
{
	forwordID get=new forwordID();
	//get.currentpay("AKSP0141");//("");
	//get.pay();
	//get.balance();
}
}
