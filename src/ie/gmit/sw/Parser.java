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
			
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringBuffer StringB = new StringBuffer();
		
		int next;
		
		while((next = br.read()) != -1) {
			
			char text = (char)next;		
			
			if (text >= 'A' && text <= 'Z'|| text >='a' && text <= 'z' || text == '\''){
				
				//Delimiter to remove useless inputs from text file
				s.useDelimiter(",|\r\n, [0-9],123...");
				
				//Adding each new string to the String Buffer
				StringB.append(text);
			}
			else {
				String word = StringB.toString().toUpperCase();
				StringB = new StringBuffer();
				
				/*
				 * As specified in the brief here is the required Frequency table,
				 * String is passed in and the increment of Frequency counts its occurences.
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
	
	//Running time: O(n^2)
	public static boolean Duplicates(String[] args) {
	    for (int i = 0; i < args.length; i++) {
	         for (int j = 0; j < args.length; j++) {
	              if (i == j)
	                  break;
	              if (args[i] == args[j])
	                  return true;
	            }
	        }
	        return false;
	}
}