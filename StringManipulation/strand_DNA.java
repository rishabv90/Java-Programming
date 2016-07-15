/**
 * String manipulation to find the protiends in the DNA strands.
 *  
 * @author (Rishab Verma) 
 * @version (15th July 2016)
 */

import edu.duke.*;
import java.io.*;

public class strand_DNA {
    
    public String findProtien(String dna){
        int startcode = dna.indexOf("ATG");
        int stopcode1 = dna.indexOf("TAG", startcode+3);
        int stopcode2 = dna.indexOf("TGA", startcode+3);
        int stopcode3 = dna.indexOf("TAA", startcode+3);
        
        if(startcode == -1){
            return "Start Codon Not Found!";
        }
        
        if ((stopcode1-startcode) % 3 == 0){
            //to find protien
            System.out.println("stopcode1");
            return dna.substring(startcode,stopcode1+3);
        }
        else if((stopcode2-startcode) % 3 == 0){
            System.out.println("stopcode2");
            return dna.substring(startcode, stopcode2+3);
        }
        else if((stopcode3-startcode) % 3 == 0){
            System.out.println("stopcode3");
            return dna.substring(startcode, stopcode3+3);
        }
        else{
            return "This is not a multiple of 3";
        }
    }
    
    public void checking(){
        String one = "AATGCTAGTTTAAATCTGA";
        String gene = "ATGCTAGTTTAAATCTGA";   
        
        String ans = findProtien(one);
        System.out.println(one);
        if(ans.equals(gene)){
            System.out.println("Success");
        }else{
            System.out.println("Fail");
        }
    }
    

}
