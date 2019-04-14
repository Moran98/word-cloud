package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class URLParser {
	
private HashMap<String, Integer> list = new HashMap<String, Integer>();
	
	public URLParser(URL file) throws Exception {
		super();
		stream(file);
	}
	
	public HashMap<String, Integer> stream(URL file) throws IOException{
		
		/*
		 * Using a BufferedReader to stream in the text from the files,
		 * Courtesy of labratory examples.
		 */
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(file.openStream()));
			StringBuffer sb = new StringBuffer();
			
			String nextLine;
			int j = 0;
			while((nextLine = br.readLine()) != null) {
				char next = (char) j;
				if (next >= 'A' && next <= 'z' || next == '\''){
					sb.append(next);
				}
				else {
					String word = sb.toString().toLowerCase();
					sb = new StringBuffer();
					
					// This will add words and how often they occur to the hashMap, which can then be called by other classes
					if(!compare(word) && word.length() > 0){
						int freq = 0;	
						if(list.containsKey(word)){
							freq = list.get(word);				
						}
						freq++;
						list.put(word, freq);
					}
				}
			}	
			br.close();
			setWordHash(list);
		
			
		} catch (MalformedURLException e) {
			// TODO: handle exception
			System.out.println("Invalid URL entered.");
		}
		return list;		
		
		
	}
	
	private boolean compare(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	public HashMap<String, Integer> getWordHash() {
		return list;
	}
	
	private void setWordHash(HashMap<String, Integer> wordHash) {
		this.list = wordHash;
	}
}

