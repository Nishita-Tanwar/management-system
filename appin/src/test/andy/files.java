package test.andy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class files {
	
	void filecreation() throws IOException
	{
	File f= new File("d:/andy/andy1/appin/anant.doc/andy.txt");
//          	f.mkdirs();
	f.createNewFile();
	System.out.println("file");
	}
	public static void main(String a[]) throws IOException
	{
		new files().filecreation();
		/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		File f=new File("d:/anant.java"); 
		f.createNewFile();
		System.out.println("file is created");*/
		
	}

}
