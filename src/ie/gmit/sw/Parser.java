package ie.gmit.sw;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;


public class Parser extends IgnoreWords{	
	private HashMap<String, Integer> list = new HashMap<String, Integer>();
	Scanner s = new Scanner(System.in);
	
	public Parser(String file) throws Exception {
		//Calling super() which allows us to access Super class members, e.g Split()
		super();
		stream(file);
	}
	
	public HashMap<String, Integer> stream(String file) throws Exception{
		
		/*
		 * Using a BufferedReader to stream in the text from the files,
		 * StringBuffer allows us to append/add each string value to the HashMap.
		 * Courtesy of labratory examples.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringBuffer sb = new StringBuffer();
		
		int j;
		while((j = br.read()) != -1) {
			char next = (char)j;		
			if (next >= 'A' && next <= 'z' || next == '\''){
				//Delimiter to remove useless inputs from text file
				s.useDelimiter(",|\r\n, [0-9],123...");
				sb.append(next);
			}
			else {
				String word = sb.toString().toLowerCase();
				sb = new StringBuffer();
				
				/*
				 * As specified in the brief here is the required Frequency table,
				 * String is passed in and the increment of Frequency counts its occurences.
				 * (word, frequency) 
				 * word : displays the string
				 * frequency : (Integer)
				 */
				if(!split(word) && word.length() > 0){
					int frequency = 0;	
					if(list.containsKey(word)){
						frequency = list.get(word);				
					}
					frequency++;
					//Passign the (key, value)
					list.put(word, frequency);
				}
			}
		}	
		//Good practice.
		br.close();
		setList(list);
		return list;
	}
	
	public HashMap<String, Integer> getList() {
		return list;
	}
	
	private void setList(HashMap<String, Integer> wordHash) {
		this.list = wordHash;
	}
}
