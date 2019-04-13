package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IgnoreWords {
	private static ArrayList<String> ignorewords = new ArrayList<String>();

	public IgnoreWords() throws Exception {
		super();
		parse("./ignorewords.txt"); // File is hardcoded, as this is the only file that is going to be used for the stopwords.
	}
	
	public void parse(String FileName) throws Exception {
 		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FileName)));
 		StringBuffer sb = new StringBuffer();
 		
 		int i;
 		while((i = br.read()) != -1){
 			char next = (char) i;
 			
 			if(next != '\n')
 				sb.append(next);
 			
 			else{
 				String stopWord = sb.toString().toLowerCase();
 				sb = new StringBuffer();
 				ignorewords.add(stopWord);
 			}
 		}
 		br.close();
	}
	
	public boolean compare(String word){
		if(ignorewords.contains(word))
			return true;	
		else
			return false;
	}
}
