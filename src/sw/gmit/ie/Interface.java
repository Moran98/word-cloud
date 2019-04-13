package sw.gmit.ie;

import java.awt.Color;

public interface Interface {
	public void wordCloud(String outFile, Integer nWords) throws Exception;
	
	public int drawWord(String word, int wordFreq, int x, int y);
	
	public Color randColour();
}
