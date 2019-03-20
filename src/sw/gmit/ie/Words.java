package sw.gmit.ie;

public class Words {
	
	private String word;

	public Words(String word) {
		this.word = word;
	}
	
	public String getWord() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		return word;
	}

}
