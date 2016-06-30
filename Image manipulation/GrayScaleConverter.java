
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (Rishab Verma) 
 * @version (30th June 2016)
 */
import java.io.*;
import edu.duke.*;

public class GrayScaleConverter {
    public ImageResource makeGray(ImageResource input)
    {
        ImageResource output = new ImageResource(input.getWidth(), input.getHeight());
        
        for(Pixel pix: output.pixels())
        {
            Pixel inputPix = input.getPixel(pix.getX(),pix.getY());
            int average = (inputPix.getRed()+inputPix.getBlue()+inputPix.getGreen())/3;
            pix.setRed(average);
            pix.setBlue(average);
            pix.setGreen(average);
        }
        return output;
    }
    public void testGray()
    {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    
    public void selectmany()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
            ImageResource ir = new ImageResource(f);
            ImageResource gray = makeGray(ir);
            gray.draw();
            
        }
    }
    
    public void saveGray()
    {
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles())
        {
            ImageResource ir = new ImageResource(f);
            ImageResource gray = makeGray(ir);
            String fname = ir.getFileName();
            String nname = "gray-" + fname;
            
            
            gray.setFileName(nname);
            
            gray.draw();
            gray.save();
            
            
        }
    }
}
