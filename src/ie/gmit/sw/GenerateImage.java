package ie.gmit.sw;

import java.awt.*;
import java.awt.image.*; 
import javax.imageio.*; 
import java.io.*;
import java.util.HashMap;
import java.util.Random; 

public class GenerateImage{  
	
	private Parser p; // This will allow us to get the wordHash with all of our filtered words.
	private Graphics graphics;
	private Color allColors;
	//SETTING HEIGHT AND WIDTH TO FINAL WILL RESTRICT THEIR SIZES
	private int HEIGHT = 0;
	private int WIDTH = 0;
	private BufferedImage img;
	private float red, blue, green;
	//Random colours to make design nicer
	private Random rand = new Random();
	
	public GenerateImage(String inFile, String outFile, Integer nWords) throws Exception {
		super();
		p = new Parser(inFile);
		Cloud(outFile, nWords);
	}
	
	public void Cloud(String outFile, Integer nWords) throws Exception{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map = p.getList();		
		
		//
		//
		//1920x1080 sets out resolution for the image output giving us a clear broad image
		img = new BufferedImage(1600, 1024, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = img.getGraphics();
		
		//Setting default background to WHITE
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, 1600, 1024);
				
		for (int i = 0; i < nWords; i++) {
			
			int j=0;
			int count=0;
			
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
					
					int fontHeight = drawWord(word, map.get(word),WIDTH, HEIGHT);
					HEIGHT+=fontHeight;
									
					// words are then moved on the WIDTH(x) coordinate and the counter resets
					count++;
					if(count >= nWords){
						WIDTH+=250;
						HEIGHT=0;
						count = 0;
					}
				}
			}
			ImageIO.write(img, "png", new File(outFile));
			
		}
		
		
	}
	
	public Color random()
	{
		
		/*
		 * Generates random numbers, which is then feed into the colour generator.
		 * Rand numbers are limited, so that it only will result in lighter colours, making them easy to see on the dark background
		 */

		float red = (float) (rand.nextFloat() / 2f + 0.5);
		float green = (float) (rand.nextFloat() / 2f + 0.5);
		float blue = (float) (rand.nextFloat() / 2f + 0.5);
		Color colour = new Color(red, green, blue);
		
		return colour;
	}
	
	public int drawWord(String word, int wordFreq, int x, int y) {
		
		int fontSize = (int)(Math.log(wordFreq)*35);	

		Font font = new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, fontSize);
		allColors = random();
		graphics.setColor(allColors);
		graphics.setFont(font);
		
		// Spacing between words
		FontMetrics fm = graphics.getFontMetrics(font);
		int height = fm.getHeight();
		graphics.drawString(word + "", x, y + fm.getAscent());
		return height;
	}
	

	

}