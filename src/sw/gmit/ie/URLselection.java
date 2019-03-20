package sw.gmit.ie;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class URLselection extends Menu {
	
	 public static void main(String [] args) {
		 
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
}
