
/**
 * Write a description of ImageSave here.
 * 
 * @author (Rishab Verma) 
 * @version (30th June 2016)
 */

import edu.duke.*;
import java.io.*;

public class ImageSave {
    public void doSave()
    {
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr .selectedFiles())
        {
            ImageResource ir = new ImageResource(f);
            String fname = ir.getFileName();
            String nname = "Copy-" + fname;//created a string
            
            ir.setFileName(nname);
                   
            ir.draw();
            ir.save();
        }
    }
}
