package ie.gmit.sw;

import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;


public class Parser extends IgnoreWords{	
	
	//Variables && Scanners
	private HashMap<String, Integer> list = new HashMap<String, Integer>();
	private static char WORD;
	private static String words;
	private static int next;
	private static int fCount = 0;	
	private static BufferedReader br;
	private static StringBuffer StringB;
	private static NumberFormat format;
	Scanner s = new Scanner(System.in);
	
	/*
	 * Running times : 17.497587s
	 * (Parsing and creating the image)
	 *  
	 */
	
	public Parser(String file) throws Exception {
		stream(file);
	}
	
	public HashMap<String, Integer> stream(String file) throws Exception{
		
		/*
		 * Using a BufferedReader to stream in the text from the files,
		 * StringBuffer allows us to append/add each string value to the HashMap.
		 * Courtesy of labratory examples.
		 */
		
	//Start
	float startTime = System.nanoTime();
		
	try {
			
		br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringB = new StringBuffer();
		
		while((next = br.read()) != -1) {
			
			WORD = (char)next;		
			
			if (WORD >= 'A' && WORD <= 'Z'|| WORD >='a' && WORD <= 'z' || WORD == '\''){
				
				//Delimiter to remove useless inputs from text file
				s.useDelimiter(",|\r\n, [0-9],123...");
				
				//Adding each new string to the String Buffer
				StringB.append(WORD);
			}
			else {
				words = StringB.toString().toUpperCase();
				StringB = new StringBuffer();
				
				/*
				 * As specified in the brief here is the required Frequency table,
				 * String is passed in and the increment of Frequency counts its occurences.
				 * (word, frequency) 
				 * word : displays the string
				 * frequency : (Integer)
				 */
				if(!split(words) && words.length() > 0)
				{
					if(list.containsKey(words))
					{
						fCount = list.get(words);				
					}
					fCount++;
					//Passing the (key, value)
					list.put(words, fCount);
				}
			}
		}	
		
		//Finish
		float endTime = System.nanoTime();
		
		final float duration = System.nanoTime() - startTime;
		format = new DecimalFormat("#0.00000");
		
		// DEBUG
		// EXECUTION TIME IN nanoTime()
		// Dividing by 1,000,000,000 displays the output in seconds
		//System.out.println(duration/1000000000);
		System.out.println("Execution time is : " +(duration/1000000000) +" seconds");
		
		//Good practice to close.
		br.close();
		setList(list);
	}
	
		catch (Exception e) {
			System.out.println("Invalid file path entered.");
		}
		return list;
		
		/*
		 * This code is a DEBUG for displaying the contents of the TEXT FILE input
		 * 
		 * String next;
		   while ((next= br.readLine()) != null) {
		   System.out.println(next);
		   }
		   br.close();
		 */
	}
	
	public HashMap<String, Integer> getList() {
		return list;
	}
	
	private void setList(HashMap<String, Integer> wordList) {
		this.list = wordList;
	}
	
}