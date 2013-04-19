package satya.appin.karolbagh.method;

//import ImageFilter;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class imagelogic {
	addmission ad=new addmission();
	File file;
	ImageFilter filter=new ImageFilter();
	public String getImageFile() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(filter);//.setFileFilter(filter);
		int result = fc.showOpenDialog(null);
		 file = null;
		if (result == JFileChooser.APPROVE_OPTION) {
		file = fc.getSelectedFile();
		// System.out.println(file.getParent().toString());
		//s=file.getPath();
		
		//ad.file=file;
		return file.getPath();

		} else
		return null;

		}


}
