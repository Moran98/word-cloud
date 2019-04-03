package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


public class RandomWords {
	
	//private List<Words> wordList = new ArrayList<Words>(); //Instance variable of type List (an interface)
	private final static String DICTIONARY_FILE = "./dictionary.txt"; //A string instance variable
	private Scanner x;
	

	public static void main(String[] args) {
		
		//System.out.println(DICTIONARY_FILE[new Random().nextInt(DICTIONARY_FILE.length())]);
	}
	
	public void OpenFile()
	{
		try {
			
			x = new Scanner(new File ("DeBelloGallico.txt"));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Could not open file");
		}
	
	}
	
	public void ReadFile()
	{
		
		while (x.hasNext()) {
			
			Random rn = new Random();
			//int x = rn.nextInt(numWords);
			
			String a=x.next();
			System.out.printf("%s\n" ,a);

		}
	}
	
	public void CloseFile()
	{
		x.close();
	}
	/*
	public void load() throws Exception{ //If anything goes wrong, throw the exception to the calling method. Very lazy indeed!
		
		try {
			
			FileInputStream fileStream = new FileInputStream(DICTIONARY_FILE); //Wrap the file name in an input stream
			//DataInputStream in = new DataInputStream(fileStream); //Allows us to read primitive data types (ints, chars, floats) from a stream
			BufferedReader br = new BufferedReader(new InputStreamReader(fileStream)); //Buffers the data input stream
			
			String strLine;
			List<String> filearray = new ArrayList<String>();
			
			while ((strLine = br.readLine()) != null) { //Loop through each line in the dictionary file
				
				//GET WHOLE LINE AND DIVIDE INTO INDIVIDUAL WORDS
			
				 Words word = new Words(strLine); //Create a new Word object using the next word in the dictionary
				 wordList.add(word); //Add the word to our array list
			}
			fileStream.close(); //Good manners to close any in/out streams.
		} catch (Exception e) {
			throw new Exception("The FIle was unable to be read." + e.getMessage());		
		}

	}
	*/

}
