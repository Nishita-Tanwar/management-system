package test;

import java.io.*;
import java.sql.*;

public class img {
public static void main(String a[])
{
	try{
	    InputStream sImage;
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	           Connection con = DriverManager.getConnection("jdbc:odbc:satya");
	File imgfile = new File("d:/satya.jpg");
	      FileInputStream fin = new FileInputStream(imgfile);
	      PreparedStatement pre = con.prepareStatement("insert into photo values(?,?,?)");
	      pre.setString(1,"B");
	      pre.setString(2,"Delhi");
	      pre.setBinaryStream(3,fin,(int)imgfile.length());
	      pre.executeUpdate();
	    System.out.println("Inserting Successfully!");
	      pre.close();
	      con.close();
	}
	catch(Exception ex){
	System.out.println("error :"+ex);
	}
}
}
