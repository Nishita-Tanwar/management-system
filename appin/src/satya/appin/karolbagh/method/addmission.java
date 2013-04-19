package satya.appin.karolbagh.method;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import satya.appin.karolbagh.connection.connection;

public class addmission {

	String sn,fn,sex,nation,mb,add,city,cn,branch, year,exp,tt,tech,fee,offer,email;
	//
	public String id;
public	Date dob,querydate;
String qd;
	Date date;
	String enrol, path1;;
	private File file;
	connection con;
	public Vector vid;
	imagelogic ilogic;
	FileInputStream fis;
	URL path2;
	//connection con;
	
	public void querydate(String date)
	{
		qd=date;
		//SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		try {
			querydate = parseDate(qd, "dd/MM/yyyy");
			
			// System.out.println(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private Date parseDate(String date, String format) throws ParseException
	{
	        SimpleDateFormat formatter = new SimpleDateFormat(format);
	        return formatter.parse(qd);
	}
	
	public void personaldetail(String name, String fname, String sex1, Date dob1,String nationality,String mbn,String Address,String city1)
	{	//System.out.println(path1);

		sn=name;
		fn=fname;
		sex=sex1;
		dob=dob1;
		nation=nationality;
		add=Address;
		mb=mbn;
		city=city1;
		//System.out.println(sn+"  "+fn+"  "+sex+" "+dob+"  "+nation+"  "+add+"  "+mb+"  "+city);
		System.out.println(dob);
	}
	public void eductionaldetail(String college,String branch1,String year1,String expr)
	{
		cn=college;
		branch=branch1;
		year=year1;
		exp=expr;
				
	}
	public void trainingdetatil(String type,String technology, String fee1)
	{
		tt=type;
		tech=technology;
		fee=fee1;
	}
	public void insertingdetails()
	{id();
	///String file=ilogic.getImageFile();
//	file=new File(path1);

	//System.out.println(path1);
	con.sql1="insert into details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		con.insertconnect();
		try
		{   	//fis=new FileInputStream(file);
		//path2=new URL(path1);
		///URI uri = new URI(path2.getProtocol(), path2.getUserInfo(), path2.getHost(), path2.getPort(), path2.getPath(), path2.getQuery(), path2.getRef());
		///path2 = uri.toURL();
			java.sql.Date sqlDate = new java.sql.Date(dob.getTime());
			java.sql.Date sqlDatequery = new java.sql.Date(querydate.getTime());

		//FileInputStream fis = new FileInputStream(ilogic.file);
		//System.out.println(ilogic.file.getName());
		
	
		con.pstm.setString(1, id);
			con.pstm.setString(2, sn);
			con.pstm.setString(3, fn);
			con.pstm.setString(4, sex);
			con.pstm.setDate(5, sqlDate);
			con.pstm.setString(6, nation);
			con.pstm.setString(7, mb);
			con.pstm.setString(8, add);
			con.pstm.setString(9, city);
			con.pstm.setString(10, cn);
			con.pstm.setString(11, branch);
			con.pstm.setString(12, exp);
			con.pstm.setString(13, tt);
			con.pstm.setString(14, tech);
			con.pstm.setDate(15, sqlDatequery);

		//	con.pstm.setBinaryStream(15, fis);
			
			//System.out.println(ilogic.file.getName());
		//	con.pstm.setBinaryStream(15, (InputStream)phot, (int)(ilogic.file.length()));
			//con.pstm.setString(15, file.getName());
			//con.pstm.setURL(15, path2);//.setBinaryStream(15, fis, (int)file.length());
		//	con.pstm.setByte(parameterIndex, x)
			
			//con.pstm.setDate(5, dob.)
			
			con.pstm.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error in addission inserdetails method");
		}
		
	}
	public void id()
	{
	con=new connection();
	
	con.sql="select * from  details";
		con.connect();
		try{
			vid=new Vector();

			while(con.rs.next())
			{
				String id1=con.rs.getString(1);
				vid.add(id1);
			


			}
		}
		catch(Exception e)
		{
			System.out.println("addmission file");
		}
	//	System.out.println(vid);
		for(int i=1;i<vid.size()+2;i++)
		{
			id="AKSP0"+i;
			if(vid.contains(id.toString()))
			{

			}
			else
			{
			id=id;
			//System.out.print(id);
			break;
			}
		}
	}
}
