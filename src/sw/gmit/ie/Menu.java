package sw.gmit.ie;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			System.out.println(" 1) Select File URL.\n2) Enter File Directory\n 3) Enter number of words.\n 3) Enter image name.\n-1) To Exit.");
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
				user.enterNumWords();
				break;
				
			case 4: 
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
		//VARIABLES
		Scanner s = new Scanner(System.in);
		//InputStream urlName;
		Parser p = new Parser();
		
		InputStream urlName = null;
	 
      try {
    	 //PROMPT USER FOR URL INPUT
    
 		 p.parse(urlName);
 	

         
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("Invalid URL input by the user.");
      }
	}
	
	@Override
	void fileName() {
		
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
		gen.setName();
	
	}
	
	@Override
	void ExitProgram() {
		System.out.println("Exiting program...");
		System.exit(0);
	}


}
