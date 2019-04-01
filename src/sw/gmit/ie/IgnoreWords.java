package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IgnoreWords {
	
	public static HashSet<String> listWords;
	public static Map<String, Integer> freq;
	
	
	static {
		
		listWords = new HashSet<>();
		listWords.add("ignorewords.txt");
		freq=new HashMap<>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader reader = null;
		String line;
		
		try {
			
			reader = new BufferedReader(new FileReader("DeBelloGallico.txt"));
			
			while ((line = reader.readLine())!=null) {
				String [] words = line.split(" ");		
				
				
				for (String word : words) {
					
					if(listWords.contains(word))
					{
						continue;
					}
					
					Integer value = freq.get(word);
					
					if(value != null)
					{
						freq.put(word, value+1);
					}
					
					else
					{
						freq.put(word, 0);
					}
					
					System.out.println(word);

				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		catch (IOException e)
		{
			e.printStackTrace();
		}	
		//finally
		//{
			//reader.close();
		//}
		
		System.out.println(freq.values());
	}

}
