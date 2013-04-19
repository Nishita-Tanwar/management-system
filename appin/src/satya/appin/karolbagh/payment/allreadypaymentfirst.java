package satya.appin.karolbagh.payment;

import java.sql.SQLException;
import java.util.Vector;

import satya.appin.karolbagh.connection.connection;

public class allreadypaymentfirst {
	public Vector paymentID;
	connection con;
	public void getPaymentID()
	{paymentID=new Vector();
		con=new connection();
		
		con.sql="select ID from payment";
		con.connect();
		try {
			while(con.rs.next())
			{
				String id=	con.rs.getString("id");

			paymentID.add(id);
			}
			//System.out.println(paymentID);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
