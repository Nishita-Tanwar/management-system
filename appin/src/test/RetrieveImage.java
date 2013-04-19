package test;

import java.sql.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.*;

public class RetrieveImage {
        public static void main(String argv[]) {
                try {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 	           Connection con = DriverManager.getConnection("jdbc:odbc:satya");
                                    //    "jdbc:mysql://localhost:3306/test", "root", "root");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select photo,ID from photo where ID='AKSP0160'");
                        rs.next();
                     /*   InputStream fis1;
                        FileOutputStream fos;
                        fis1 = rs.getBinaryStream("photo");
                        //Image phot=fis1.g
                        fos = new FileOutputStream(new File("d://SunsetImageRead.jpg"));
                        int c;
                        while ((c = fis1.read()) != -1)
                        {
                        fos.write(c);
                        }
                        fis1.close();
                        fos.close();*/
                        InputStream stream = rs.getBinaryStream(1);
                        ByteArrayOutputStream output = new ByteArrayOutputStream();
                        int a1 = stream.read();
                        while (a1 >= 0) {
                          output.write((char) a1);
                          a1 = stream.read();
                        }
                        Image myImage = Toolkit.getDefaultToolkit().createImage(output.toByteArray());
                       drawimg(myImage);
                        output.close();
                       
                      
                } catch (Exception e) {
                	e.printStackTrace();
                }
        }
        public static void drawimg(final Image photo)
        {
        	JFrame f=new JFrame();
        	f.setLayout(null);
       JPanel 	p1=new JPanel(null){
    			protected void paintComponent(Graphics g)
    			{
    				
    				g.drawImage(photo,0,0,this);
    			super.paintComponent(g);
    			}
    			
    		};
    		p1.setBackground(Color.red);
    		p1.setOpaque(false);
    	p1.setBounds(0, 0, 500, 400);
    		f.add(p1);
    	
        	f.setSize(500,400);
        	f.setVisible(true);
        }
}

/*class Pane extends JDesktopPane {
        private Image image;

        public Pane(Image image) {
                this.image = image;
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this);
        }
}*/