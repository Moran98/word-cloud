package sw.gmit.ie;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) throws Exception {
		int option=0;
		String fname="default";
		int numWords=0;
		Scanner s = new Scanner(System.in);
		
		while (option!=-1) {
			
			//Headers
			System.out.println("\nWelcome to the Word Cloud Generator");
			System.out.println("===================================");
			System.out.println(" 1) URL File.\n 2) Text FIle\n\n-1) To Exit.");
			System.out.println("Choose an option : ");
			option = s.nextInt();
			
			if(option == 1)
			{
				//SETTING THE FILE NAME 
				System.out.println("Enter the file name :");
				fname = s.next();
				//SETTING THE AMOUNT OF WORD ITERATIONS
				System.out.println("Enter number of words : ");
				numWords = s.nextInt();
				GenerateImage url = new GenerateImage("./Deb.txt", fname+".png", numWords);
			}
			
			else if(option == 2)
			{
				//SETTING THE FILE NAME 
				System.out.println("Enter the file name :");
				fname = s.next();
				//SETTING THE AMOUNT OF WORD ITERATIONS
				System.out.println("Enter number of words : ");
				numWords = s.nextInt();
				GenerateImage txt = new GenerateImage("./Deb.txt", fname+".png", numWords);
			}
			else if(option == -1)
			{
				System.out.println("Exiting program . . .");
			}
		}
			
			
	}
}
