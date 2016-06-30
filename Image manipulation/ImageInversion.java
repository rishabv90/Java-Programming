
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (Rishab Verma) 
 * @version (30th June 2016)
 */
import java.io.*;
import edu.duke.*;

public class ImageInversion {
    public ImageResource makeInverted(ImageResource input)
    {
        ImageResource output = new ImageResource(input.getWidth(), input.getHeight());
        
        for(Pixel pix: output.pixels())
        {
            Pixel inputPix = input.getPixel(pix.getX(),pix.getY());
            //int average = (inputPix.getRed()+inputPix.getBlue()+inputPix.getGreen())/3;
            pix.setRed(255-inputPix.getRed());
            pix.setBlue(255 - inputPix.getBlue());
            pix.setGreen(255 - inputPix.getGreen());
        }
        return output;
    }
    public void testInverted()
    {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeInverted(ir);
        gray.draw();
    }
    
    public void selectmany()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
            ImageResource ir = new ImageResource(f);
            ImageResource gray = makeInverted(ir);
            gray.draw();
            
        }
    }
    
    public void saveInverted()
    {
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles())
        {
            ImageResource ir = new ImageResource(f);
            ImageResource gray = makeInverted(ir);
            String fname = ir.getFileName();
            String nname = "gray-" + fname;
            
            
            gray.setFileName(nname);
            
            gray.draw();
            gray.save();
            
            
        }
    }
}
