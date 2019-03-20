package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


public class RandomWords {
	
	private List<Words> wordList = new ArrayList<Words>(); //Instance variable of type List (an interface)
	private final String DICTIONARY_FILE = "./dictionary.txt"; //A string instance variable

	public void load() throws Exception{ //If anything goes wrong, throw the exception to the calling method. Very lazy indeed!
		
		
		try {
			
			FileInputStream fileStream = new FileInputStream(DICTIONARY_FILE); //Wrap the file name in an input stream
			DataInputStream in = new DataInputStream(fileStream); //Allows us to read primitive data types (ints, chars, floats) from a stream
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); //Buffers the data input stream
			
			String next;
			while ((next = br.readLine()) != null) { //Loop through each line in the dictionary file
				 Words word = new Words(next); //Create a new Word object using the next word in the dictionary
				 wordList.add(word); //Add the word to our array list
			}
			in.close(); //Good manners to close any in/out streams.
		} catch (Exception e) {
			throw new Exception("The FIle was unable to be read." + e.getMessage());		
		}

	}
	

}
