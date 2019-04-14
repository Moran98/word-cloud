package sw.gmit.ie;

import java.awt.*;
import java.awt.image.*; 
import javax.imageio.*; 
import java.io.*;
import java.util.HashMap;
import java.util.Random; 

public class GenerateImage implements Interface{  
	
	private Parser p; // This will allow us to get the wordHash with all of our filtered words.
	private Graphics graphics;
	private Color c;
	//SETTING HEIGHT AND WIDTH TO FINAL WILL RESTRICT THEIR SIZES
	private int HEIGHT = 0;
	private int WIDTH = 0;
	private BufferedImage img;
	//Random colours to make design nicer
	private final Random rand = new Random();
	
	public GenerateImage(String inFile, String outFile, Integer nWords) throws Exception {
		super();
		p = new Parser(inFile);
		wordCloud(outFile, nWords);
	}
	
	public void wordCloud(String outFile, Integer nWords) throws Exception{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map = p.getWordHash();		
		
		//
		//
		//1920x1080 sets out resolution for the image output giving us a clear broad image
		img = new BufferedImage(1920, 1080, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = img.getGraphics();
		
		//Setting default background to WHITE
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 1920, 1080);
		
		for (int i = 0; i < nWords; i++) {
			
			/*
			 * Noticing the larger the number entered for nWords ,
			 * The longer the program completes to compile.
			 * example of 10 words takes N amount of time
			 * and 100 words takes N amount of time. Very slow.
			 * 
			 */
			int x = 0, y=20, j=0, count=0;
			for (String word : map.keySet()) {
				if (map.get(word) > 1 && j < map.size()) {
					//int fontWidth = drawWord(word, map.get(word),y, x);
					int fontHeight = drawWord(word, map.get(word),WIDTH, HEIGHT);
					HEIGHT+=fontHeight;
					//x+=fontWidth;
				
					// words are then moved on the x coordinate and the counter resets
					count++;
					if(count >= nWords){
						WIDTH+=250;
						HEIGHT=100;
						count = 0;
					}
				}
			}
			ImageIO.write(img, "png", new File(outFile));
			
		}
		
		
	}
	
	public int drawWord(String word, int wordFreq, int x, int y) {
		int fontSize = (int)(Math.log(wordFreq)*20);	
		Font font = new Font(Font.DIALOG_INPUT, Font.PLAIN, fontSize);
		c = randColour();
		graphics.setColor(c);
		graphics.setFont(font);
		
		// Spacing between words
		FontMetrics fm = graphics.getFontMetrics(font);
		int height = fm.getHeight();
		graphics.drawString(word + "", x, y + fm.getAscent());
		return height;
	}
	
	/*
	 * Generates random numbers, which is then feed into the colour generator.
	 * Rand numbers are limited, so that it only will result in lighter colours, making them easy to see on the dark background
	 */
	public Color randColour() {
		float r = (float) (rand.nextFloat() / 2f + 0.5);
		float g = (float) (rand.nextFloat() / 2f + 0.5);
		float b = (float) (rand.nextFloat() / 2f + 0.5);
		
		Color colour = new Color(r, g, b);
		return colour;
	}

}