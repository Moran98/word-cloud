package sw.gmit.ie;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class GenerateImage {
	public static void main(String args[]) throws IOException {
		
		//VARIABLES 
		int width=600;
		int height=300;
		
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 62);
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = img.getGraphics();
		graphics.setColor(Color.red);
		graphics.setFont(font);
		//graphics.fillRect(0, 0, width, height);
		
		graphics.drawString("Data Structures", 0, 100);
		font = new Font(Font.SANS_SERIF, Font.ITALIC, 42);
		graphics.setFont(font);
		graphics.setColor(Color.yellow);
		graphics.drawString("and Algorithms", 10, 150);
		font = new Font(Font.MONOSPACED, Font.PLAIN, 22);
		graphics.setFont(font);
		graphics.setColor(Color.blue);
		graphics.drawString("2019Assignment", 40, 180);
		graphics.setColor(Color.green);
		graphics.drawString("Aaron Moran - G00356519", 70, 210);
		graphics.dispose();
		
		//Save File
		//File file = new File("images.png");
		ImageIO.write(img, "png", new File("test.png"));
	}
}