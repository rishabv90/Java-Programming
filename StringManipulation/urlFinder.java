/**
 * String manipulation to find the particular urls from a webpage.
 *  
 * @author (Rishab Verma) 
 * @version (15th July 2016)
 */

import edu.duke.*;
import java.io.*;

public class urlFinder {
    
    public void readWeb(){
        URLResource file = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        
        for(String item: file.words()){
            String lowcase = item.toLowerCase();
            
            int pos = lowcase.indexOf("youtube.com");
            
            if(pos != -1){
                int start = item.lastIndexOf("\"", pos);
                int end = item.indexOf("\"", pos +1);
                System.out.println(item.substring(start+1,end));
            }
            
            
        }
    
    
    }
  
}
