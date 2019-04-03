package sw.gmit.ie;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner; 
  
public class Parser 
{ 
    void Parse() throws IOException  
    { 
    	
    	String urlName;
    	int count=0;
    	Scanner s = new Scanner(System.in);
    	
    	System.out.println("Enter the URL :" );
    	urlName = s.nextLine();
    	
    	 try {
             
             URL url = new URL(urlName);
              
             // read text returned by server
             BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
              
             String line;
             while ((line = br.readLine()) != null) {
                 System.out.println(line);
                 count++;
             }
             br.close();
              
         }
         catch (MalformedURLException e) {
             System.out.println("Invalid URL");
         }
    	 
		  System.out.println("\n\n DEBUG  -- The count of words is : "+count);

    } 


}



















/*package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Parser extends Menu {
	
	ArrayList<String> text = new ArrayList<String>();
	ArrayList<String> ignorewords = new ArrayList<String>();

	   public static void main(String[] args) throws IOException  
	    { 
	        // PrintWriter object for output.txt 
	        PrintWriter pw = new PrintWriter("output.txt"); 
	          
	        // BufferedReader object for delete.txt 
	        BufferedReader br2 = new BufferedReader(new FileReader("ignorewords.txt")); 
	          
	        String line2 = br2.readLine(); 
	          
	        // hashset for storing lines of delete.txt 
	        HashSet<String> hs = new HashSet<String>(); 
	          
	        // loop for each line of delete.txt 
	        while(line2 != null) 
	        { 
	            hs.add(line2); 
	            line2 = br2.readLine(); 
	        } 
	                      
	        // BufferedReader object for input.txt 
	        BufferedReader br1 = new BufferedReader(new FileReader("DeBelloGallico.txt")); 
	          
	        String line1 = br1.readLine(); 
	          
	        // loop for each line of input.txt 
	        while(line1 != null) 
	        { 
	            // if line is not present in delete.txt 
	            // write it to output.txt 
	            if(!hs.contains(line1)) 
	                pw.println(line1); 
	              
	            line1 = br1.readLine(); 
	        } 
	          
	        pw.flush(); 
	          
	        // closing resources 
	        br1.close(); 
	        br2.close(); 
	        pw.close(); 
	          
	        System.out.println("File operation performed successfully"); 
	    } 
}

*/
