package sw.gmit.ie;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileInputStream;


public class Parser extends IgnoreWords{	
	private HashMap<String, Integer> list = new HashMap<String, Integer>();
	
	public Parser(String file) throws Exception {
		super();
		readFile(file);
	}
	
	public HashMap<String, java.lang.Integer> readFile(String file) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringBuffer sb = new StringBuffer();
		
		int j;
		while((j = br.read()) != -1) {
			char next = (char)j;		
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
		return list;
	}
	
	public HashMap<String, Integer> getWordHash() {
		return list;
	}
	
	private void setWordHash(HashMap<String, Integer> wordHash) {
		this.list = wordHash;
	}
}
