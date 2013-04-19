package satya.appin.karolbagh.method;

import java.io.File;

public class ImageFilter extends javax.swing.filechooser.FileFilter {

public boolean accept(File f) {
if (f.isDirectory())
return true; 
String name = f.getName();
if (name.matches(".*((.jpg)|(.gif)|(.png))"))
return true;
else
return false;
}

public String getDescription() {
return "Image files (*.jpg, *.gif, *.png)";
}

}
