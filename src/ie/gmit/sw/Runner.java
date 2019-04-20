package ie.gmit.sw;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) throws Exception {
		
		//Variables && Scanners
		int option=0;
		String fname="default";
		String sFile="";
		String url="";
		int numWords=0;
		Scanner s = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		
		while (option!=-1) {
			
			//Headers
			System.out.println("\nWelcome to the Word Cloud Generator");
			System.out.println("===================================");
			System.out.println(" 1) Text File.\n 2) URL FIle\n\n-1) To Exit.");
			System.out.println("Choose an option : ");
			option = s.nextInt();
			
			if(option == 1)
			{
				
				System.out.println("Enter the File Path :");
				sFile = in.nextLine();
				File file = new File(sFile);
				
				//Parser object to pass the input of sFile to be passed through the Parser, it is then used as a paramater in creating the image.
				Parser p = new Parser(sFile);
				p.ignore(sFile);
				
				//SETTING THE FILE NAME 
				System.out.println("Enter the Image name :");
				fname = s.next();
				//SETTING THE AMOUNT OF WORD ITERATIONS
				System.out.println("Enter number of words : ");
				numWords = s.nextInt();
				GenerateImage textFile = new GenerateImage(sFile, fname+".png", numWords);
			}
			
			else if(option == 2)
			{
				System.out.println("Enter the URL : ");
				url = in.nextLine();
				URL urlInput = new URL(url);
				
				//Parser object to pass the input of sFile to be passed through the Parser, it is then used as a paramater in creating the image.
				URLParser u = new URLParser(urlInput);
				u.ignore(url);
				
				//SETTING THE FILE NAME 
				System.out.println("Enter the Image name :");
				fname = s.next();
				
				//SETTING THE AMOUNT OF WORD ITERATIONS
				System.out.println("Enter number of words : ");
				numWords = s.nextInt();
				
				//IMAGE I/O
				GenerateImage urlFile = new GenerateImage(urlInput, fname+".png", numWords);
			}
			else if(option == -1)
			{
				System.out.println("Exiting program . . .");
			}
		}
			
			
	}
}