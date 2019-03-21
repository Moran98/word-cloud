package sw.gmit.ie;

import java.io.IOException;
import java.net.*;
import java.net.URL;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.*;
import java.util.Scanner;

public class Menu extends Cloud{
	
	private Scanner s;
	static boolean keepGoing=true;
	
	public static void main(String[] args) {
		
		//Scanner 
		Scanner s = new Scanner(System.in);
		
		//Constants
		final int SENTINEL = -1;
		
		//Variables
		String name="";
		int choice=0;
		
		Menu user = new Menu();
	
		while (choice!=-1) {
			
			//Headers
			System.out.println("\nWelcome to the Word Cloud Generator");
			System.out.println("===================================");
			System.out.println(" 1) Select File URL.\n 2) Enter number of words.\n 3) Enter image name.\n-1) To Exit.");
			System.out.println("Choose an option : ");
			choice = s.nextInt();
			
			
			//SWITCH TO
			switch (choice) {
			case 1:
				user.fileURL();
				break;
				
			case 2:
				user.enterNumWords();
				break;
				
			case 3: 
				user.enterImageName();
				break;
					
			case -1:
				user.ExitProgram();
			break;

			default:
			break;
			}
			
			if((choice<1) || (choice>4))
			{
				System.out.println("Invalid entry. Try Again.");
				System.out.println("===================================");
			}
			
		}
	
	}
	
	// METHODS
	@Override
	void fileURL()
	{
		System.out.println("DEBUG FOR FILE URL");
		

		//VARIABLES
		Scanner s = new Scanner(System.in);
		String urlName;
	 
      try {
    	 //PROMPT USER FOR URL INPUT
    	 System.out.println("Please enter the URL name : ");
    	 urlName = s.next();
    	 
    	 //Create URL object
         URL url = new URL(urlName);
         
         System.out.println("URL is " + url.toString());
         System.out.println("protocol is " + url.getProtocol());
         System.out.println("authority is " + url.getAuthority());
         System.out.println("file name is " + url.getFile());
         System.out.println("host is " + url.getHost());
         System.out.println("path is " + url.getPath());
         System.out.println("port is " + url.getPort());
         System.out.println("default port is " + url.getDefaultPort());
         
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("Invalid URL input by the user.");
      }
	}

	@Override
	void enterNumWords()
	{
		int numWords=0;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of words :");
		numWords = s.nextInt();
		
		//READ FROM FILE THEN CLOSE WHEN DONE
		RandomWords r = new RandomWords();
		r.OpenFile();
		r.ReadFile();
		r.CloseFile();
	}
	
	@Override
	void enterImageName()
	{
		
		GenerateImage gen = new GenerateImage();
		
		//gen.GenerateImage();
		String imgName="";
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the image name : ");
		imgName = s.next();
		System.out.println("DEBUG : Image name is "+imgName);
	}
	
	@Override
	void ExitProgram() {
		System.out.println("Exiting program...");
		System.exit(0);
	}

}
