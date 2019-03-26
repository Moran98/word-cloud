package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Parser extends Menu {
	
	public void parse(InputStream in) throws IOException
	{
		
		String next = null;
		BufferedReader br = null;
		String url="";
		Scanner s = new Scanner(System.in);
		
		 System.out.println("Please enter the URL name : ");
		 url = s.nextLine();
    	 InputStreamReader urlName = new InputStreamReader(System.in); 
		
		//URL PARSER
		URL url2 = new URL (url);
		//p.parse(url.openStream());
		InputStream stream = url2.openStream();
		
		try {
			
			br = new BufferedReader(new InputStreamReader(stream));
			
			while ((next =br.readLine())!=null) {
				System.out.println(next);
				String[] words = next.split("");
				for (String word : words) {
					//IF - contains ignore words, update map
					
				}
			}
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}

}
