package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser extends Menu {
	
	public static void main(String[] args) {
		
		ArrayList<String> text = new ArrayList<String>();
		ArrayList<String> ignorewords = new ArrayList<String>();
		

	}

	
	public void parse(InputStream in) throws IOException
	{
		//VARIABLES
		int count=0;
		int specCount=0;
		String next = null;
		BufferedReader br = null;
		String url="";
		Scanner s = new Scanner(System.in);
		ArrayList<String> text = new ArrayList<String>();
		ArrayList<String> ignorewords = new ArrayList<String>();
		
		//PROMPT USER FOR URL
		System.out.println("Please enter the URL name : ");
		// DEBUG URL TXT FILE ---- http://www.gutenberg.org/files/42571/42571-0.txt , http://www.gutenberg.org/files/22881/22881.txt
		url = s.nextLine();
    	InputStreamReader urlName = new InputStreamReader(System.in); 
		
		//URL PARSER
		URL u = new URL (url);
		//p.parse(url.openStream());
		InputStream stream = u.openStream();
		
		try {
			
			br = new BufferedReader(new InputStreamReader(stream));
			
			while ((next =br.readLine())!=null) {
				System.out.println(next);
				String[] words = next.split("");
				for (String word : words) {
					count++;
					//IF - contains ignore words, update map
					if(word.contains("ignorewords.txt"))
					{
						specCount++;
					}
					
				}
			}
			System.out.println("The total word count is : "+count);
			System.out.println("The specific word count is : "+specCount);

			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}

}
