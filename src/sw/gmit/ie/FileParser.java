package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileParser {

	 void FileInput() throws IOException {
		// TODO Auto-generated method stub
		
		String inputf;
		int count=0;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the file directory : ");
		inputf = s.nextLine();
		
		File file = new File(inputf); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {
		    System.out.println(st); 
		  count++;
		  } 
		  
		  System.out.println("\n\n DEBUG  -- The count of words is : "+count);
	 
	 }
}
	

