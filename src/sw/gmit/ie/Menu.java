package sw.gmit.ie;

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
			System.out.println("Welcome to the Word Cloud Generator");
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
	}

	@Override
	void enterNumWords()
	{
		int numWords=0;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of words :");
		numWords = s.nextInt();
	}
	
	@Override
	void enterImageName()
	{
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
