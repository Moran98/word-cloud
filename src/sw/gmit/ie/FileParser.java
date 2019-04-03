package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class FileParser {

	 void FileInput() throws IOException {
		// TODO Auto-generated method stub
		
		 Map<String, Integer> words = new HashMap<String, Integer>();
		 ArrayList<String> IGNORE = new ArrayList<>(); 
		 ArrayList<String> TEXT = new ArrayList<>(); 

		 
		String file;
		int count=0;
		int i=0;
		int numWords=0;
		Scanner scanner = new Scanner(System.in);
		
		File ignore = new File("ignorewords.txt");
		Scanner Ignore = new Scanner(ignore);
		
		System.out.println("Enter the amount of words you want to display : ");
		//numWords = scanner.nextInt();
		
		System.out.println("Enter the file directory : ");
		file = scanner.nextLine();
		
		File inputf = new File(file);
		Scanner s = new Scanner(inputf);
	
		//delimiter
		s.useDelimiter(",|\r\n");
		
		//File file = new File(inputf); 
		  
		 // BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  while (Ignore.hasNext())
		  {
			  IGNORE.add(Ignore.next()); 
		  }
		  
		  while(i < TEXT.size() )
		  {
			  if(IGNORE.contains(TEXT.get(i).toLowerCase())) {
				  IGNORE.remove(i);
			  }
			  else {
				  i++;
			  }
			  
		  }
		  
		  for (int j = 0; j < TEXT.size(); j++) {
			  
			  System.out.println(TEXT.get(i));
			
		}
		  
		  
		  //PRINTS ENTIRE TXT FILE
		//  String st; 
		  //while ((st = br.readLine()) != null) 
		  //{
			//  
			  // System.out.println(st); 
			   //count++;
			    
			  //for (int j = 0; j < numWords; j++) {	
			//}
		
		  //} 
		  
		  System.out.println("\n\n DEBUG  -- The count of words is : "+count);
	//	  WordFrequencies(file, words);
		//  System.out.println(words);
	 }
	 
	 void WordFrequencies(String fileName, Map<String, Integer> words) throws FileNotFoundException
	 {
		 
		 Scanner file = new Scanner(new File(fileName));
		 
		 while (file.hasNext()) {
			String word = file.next();
			
			Integer count = words.get(word);
			
			if(count!=null)
			{
				count++;
			}
			else {
				count = 1;
				words.put(word, count);
			}
			
		}
		 file.close();
	 }
}
	

