package satya.appin.karolbagh.method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import satya.appin.karolbagh.connection.connection;

public class imageStore {
	connection con;
	public void saveImg(String id,String Name,String file)// throws SQLException, FileNotFoundException
	{ FileInputStream fin;
	//System.out.println("Save image working");
	try {
		//System.out.println(file);
		File f=new File(file);
		fin = new FileInputStream(f);
        
		con=new connection();
		con.sql1="insert into photo values(?,?,?)";
		con.insertconnect();
		con.pstm.setString(1, id);
		con.pstm.setString(2, Name);
		con.pstm.setBinaryStream(3,fin,(int)f.length());
		// 
		con.pstm.executeUpdate();
        

		FileOutputStream fos = new FileOutputStream(new File("d://Appin//"+id+".jpeg"));
        int c;
        while ((c = fin.read()) != -1)
        {
        fos.write(c);
        }
        fos.close();
       // fin.close();
		 
	        
	} catch (FileNotFoundException e) {
		System.out.println("File not found");
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("SQL ERROR IN IMAGE SAVE FILE");
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}

}
