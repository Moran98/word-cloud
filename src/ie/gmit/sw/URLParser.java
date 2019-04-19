package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class URLParser extends IgnoreWords {
	
private HashMap<String, Integer> list = new HashMap<String, Integer>();
	
	public URLParser(URL file) throws Exception {
		super();
		stream(file);
	}
	
	public HashMap<String, Integer> stream(URL file) throws IOException{
		
		/*
		 * Using a BufferedReader to stream in the text from the files,
		 * Courtesy of laboratory examples.
		 */
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(file.openStream()));
			StringBuffer sBuff = new StringBuffer();
			
			String nextLine;
			int j = 0;
			while((nextLine = br.readLine()) != null)
			{
				char text= (Character) null;
				
				if (text >= 'A' && text <= 'Z'|| text>='a' && text <= 'z' || text == '\'')
				{
					sBuff.append(text);
				}
				else {
					String word = sBuff.toString().toLowerCase();
					sBuff = new StringBuffer();
					
					// This will add words and how often they occur to the hashMap, which can then be called by other classes
					if(!split(word) && word.length() > 0)
					{
						int fCount = 0;	
						if(list.containsKey(word))
						{
							fCount = list.get(word);				
						}
						fCount++;
						list.put(word, fCount);
					}
				}
			}	
			br.close();
			setMap(list);
		
			
		} catch (MalformedURLException e) {
			System.out.println("Invalid URL entered.");
		}
		return list;		
		
		
	}
	
	private void setMap(HashMap<String, Integer> wordList) {
		this.list = wordList;
	}


}
