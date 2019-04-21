package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IgnoreWords {
	
	private static ArrayList<String> ignorewords = new ArrayList<String>();

	public IgnoreWords() throws Exception {
		ignore("./ignorewords.txt"); // "ignorewords.txt" has been placed into the JRE library as the user does not enter in this file.
	}
	
	public void ignore(String FileName) throws Exception {
		
		/*
		 * Using a BufferedReader to stream in the text from the files,
		 * Courtesy of laboratory examples.
		 */
 		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FileName)));
 		StringBuffer StringB = new StringBuffer();
 		
 		int i;
 		while((i = br.read()) != -1)
 		{
 			char next = (char) i;
 			
 			if(next != '\n')
 				StringB.append(next);
 			
 			else{
 				//Here we are adding any Strings that are in "ignorewords" to the ignorewords Arraylist
 				String ignore = StringB.toString().toUpperCase();
 				StringB = new StringBuffer();
 				ignorewords.add(ignore);
 			}
 		}
 		br.close();
	}
	
	public boolean split(String word){
		if(ignorewords.contains(word))
			return true;	
		else {
			return false;
		}
	}
}