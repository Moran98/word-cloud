package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FrequencyTable {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Path path = Paths.get(System.getProperty("user.dir")).resolve("DeBelloGallico.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
		
		Map<String, Integer> frequency = new HashMap<>();
		
		String line = reader.readLine();
		
		while(line!=null)
		{
			System.out.println(line);
			
			if(!line.trim().equals(""))
			{
				String [] words = line.split(" ");
				
				for(String word : words)
				{
					if(word == null || word.trim().equals(""))
					{
						continue;
					}
					String processed = word.toLowerCase();
					
					
					if(frequency.containsKey(processed))
					{
						frequency.put(processed, frequency.get(processed)+1);
					}
					
					else {
						frequency.put(processed, 1);
					}
				}
				
				
			}
			
			line= reader.readLine();
		}
		System.out.println(frequency);

	}

}
