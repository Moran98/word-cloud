package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IgnoreWords {
	private static ArrayList<String> ignorewords = new ArrayList<String>();

	public IgnoreWords() throws Exception {
		super();
		parse("./ignorewords.txt"); // "ignorewords.txt" has been placed into the JRE library as the user does not enter in this file.
	}
	
	public void parse(String FileName) throws Exception {
		
		/*
		 * Using a BufferedReader to stream in the text from the files,
		 * Courtesy of labratory examples.
		 */
 		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FileName)));
 		StringBuffer sb = new StringBuffer();
 		
 		int i;
 		while((i = br.read()) != -1){
 			char next = (char) i;
 			
 			if(next != '\n')
 				sb.append(next);
 			
 			else{
 				String ignore = sb.toString().toLowerCase();
 				sb = new StringBuffer();
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
