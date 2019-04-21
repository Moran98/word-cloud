package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;


public class URLParser extends IgnoreWords {
	

private HashMap<String, Integer> list = new HashMap<String, Integer>();

	public URLParser(URL file) throws Exception {
		stream(file);
	}
	
	/*
	 * Running Times : 19.843503s
	 * (Parsing and creatinng Image)
	 * Executed much faster until changes had to be made.
	 */
		
		public HashMap<String, Integer> stream(URL file) throws IOException
		{
			
		//Start of running time
		float startTime = System.nanoTime();
			
			
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
			
			//Finish
			float endTime = System.nanoTime();
			
			final float duration = System.nanoTime() - startTime;
			NumberFormat format = new DecimalFormat("#0.00000");
			
			// DEBUG
			// EXECUTION TIME IN nanoTime()
			// Dividing by 1,000,000,000 displays the output in seconds
			//System.out.println(duration/1000000000);
			System.out.println("Execution time is : " +(duration/1000000000) +" seconds");
			
				
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
