package ie.gmit.sw;

import java.awt.*;
import java.awt.image.*; 
import javax.imageio.*; 
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Random; 

public class GenerateImage{  
	
	//Creating objects for TXT and URL parsers;
	private Parser p;
	private URLParser u;
	private Graphics graphics;
	private Font font;
	private Color color;
	//SETTING HEIGHT AND WIDTH TO FINAL WILL RESTRICT THEIR SIZES
	private int HEIGHT = 0;
	private int WIDTH = 0;
	private BufferedImage img;
	private float red, blue, green;
	private String word;
	//Random colours to make design nicer
	private Random rand = new Random();
	
	
	// Constructor #1 -FILE 
	public GenerateImage(String inFile, String outFile, int nWords) throws Exception {
		super();
		p = new Parser(inFile);
		Display(outFile, nWords);
	}
	
	// Constructor #2 -URL 
	public GenerateImage(URL urlInput, String outFile, int nWords) throws Exception {
		super();
		u = new URLParser(urlInput);
		Display(outFile, nWords);
	}
	
	public int paint(String word, int nItems, int w, int h) {
		
		int size = (int)(Math.log(nItems)*31);
		Font font = new Font(Font.MONOSPACED, Font.BOLD, size);
		graphics.setFont(font);
		FontMetrics fontMet = graphics.getFontMetrics(font);
		
		// Spacing between words
		h = fontMet.getHeight();
		graphics.drawString(word + "", WIDTH, HEIGHT + fontMet.getAscent());
		
		return h;
	}
	
	public void Display(String outFile, int nWords) throws Exception{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map = p.getList();		
		
		//
		//
		//1600x1024 sets out resolution for the image output giving us a clear broad image
		img = new BufferedImage(1600, 1024, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = img.getGraphics();
		
		
		//Setting default background to WHITE
		graphics.setColor(Color.black);
		graphics.fillRect(1,2, 1600, 1024);
		
				
		for (int i = 0; i < nWords; i++) {
			
			int j=0;
			int numIter=0;
			
			/*
			 * Noticing the larger the number entered for nWords ,
			 * The longer the program completes to compile.
			 * example of 10 words takes N amount of time
			 * and 100 words takes N amount of time. Very slow.
			 * 
			 */
	
			for (String word : map.keySet())
			{
				if (map.get(word) > 1 && j < map.size())
				{
					
					int fontHeight = paint(word, map.get(word),WIDTH, HEIGHT);
					HEIGHT+=fontHeight;
					
					float red = (rand.nextFloat());
					float green = (rand.nextFloat());
					float blue = (rand.nextFloat());
					Color color = new Color(red, green, blue);
					
					//color = random();
					graphics.setColor(color);
									
					// words are then moved on the WIDTH(x) coordinate and the counter resets
					numIter++;
					
					if(numIter >= nWords){
						WIDTH+=250;
						HEIGHT=0;
						numIter = 0;
					}
				}
			}
			graphics.dispose();
			ImageIO.write(img, "png", new File(outFile));
			
		}
	}
}