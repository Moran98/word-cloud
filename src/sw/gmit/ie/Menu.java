package sw.gmit.ie;

import java.util.*;

public class Menu {
	
	private Scanner s;
	boolean keepGoing=true;
	
	public static void main(String[] args) {
		
		//Scanner 
		Scanner console = new Scanner(System.in);
		
		//Constants
		final int SENTINEL = -1;
		
		//Variables
		String name="";
		int choice=0;
	
		while (choice!=SENTINEL) {
			
			//Headers
			System.out.println("Welcome to the Word Cloud Generator");
			System.out.println("===================================");
			System.out.println(" 1) Select File URL.\n 2) Enter number of words.\n 3) Enter image name.\n-1) To Exit.");
			System.out.println("Choose an option : ");
			choice = console.nextInt();
			
			
			//SWITCH TO
			switch (choice) {
			case 1:
				fileURL();
			break;
			
			case 2:
				enterNumWords();
				break;
				
			case 3: 
				enterImageName();
				break;
					
			case -1:
				ExitProgram();
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
	public static void fileURL()
	{
		System.out.println("DEBUG. FILE URL.");
	}
	
	public static void enterNumWords()
	{
		System.out.println("DEBUG. NUMBER WORDS.");
	}
	
	public static void enterImageName()
	{
		System.out.println("DEBUG. IMAGE NAME.");
	}
	
	public static void ExitProgram() {
		System.out.println("Exiting program...");
	}

}
