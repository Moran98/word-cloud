package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;


public class URLParser extends IgnoreWords {
	

private HashMap<String, Integer> list = new HashMap<String, Integer>();

	public URLParser(URL file) throws Exception {
		stream(file);
	}
		
		
		public HashMap<String, Integer> stream(URL file) throws IOException
		{
			
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(file.openStream()));
			StringBuffer sBuff = new StringBuffer();
			
			int next;
			while ((next= br.read()) != -1) {
				//DEBUG System.out.println(next);
				
				char text = (char)next;
				

				if (text >= 'A' && text <= 'Z'|| text>='a' && text <= 'z' || text == '\'')
				{
					sBuff.append(text);
				}
				else {
					String word = sBuff.toString().toUpperCase();
					sBuff = new StringBuffer();
	
					/*
					 * As specified in the brief here is the required Frequency table,
					 * String is passed in and the increment of Frequency counts its occurrences.
					 * (word, frequency) 
					 * word : displays the string
					 * frequency : (Integer)
					 */
					if(!split(word) && word.length() > 0)
					{
						int fCount = 0;	
						if(list.containsKey(word))
						{
							fCount = list.get(word);				
						}
						fCount++;
						//Passing the (key, value)
						list.put(word, fCount);
					}
				}
				
				/*
				 * This code is a DEBUG for displaying the contents of the URL input
				 * 
				 * String next;
				   while ((next= br.readLine()) != null) {
				   System.out.println(next);
				   }
				   br.close();
				 */
				
			}
			
				
			br.close();
			setMap(list);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid URL");
		}
		return list;
	
		}
		
		private void setMap(HashMap<String, Integer> wordList) {
			this.list = wordList;
		}


}
