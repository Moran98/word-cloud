package sw.gmit.ie;

import java.io.IOException;
import java.util.Scanner;

public abstract class Cloud {
	
	//Scanner 
	Scanner s = new Scanner(System.in);
	//Constants
	final int SENTINEL = -1;	
	//Variables
	String name="";
	int choice=0;

	
	// METHODS
	abstract void fileURL() throws IOException;
	
	abstract void textFile() throws IOException;
	
	abstract void fileName();
	
	abstract void enterNumWords();
	
	abstract void enterImageName();
	
	abstract void ExitProgram();
	

}
