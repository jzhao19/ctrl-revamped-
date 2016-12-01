import java.io.File;
import java.util.Scanner;

public class Format {
	private Scanner input;
	//private char[] punctuation = {'.', ',', ';', ':', '?', '!', '(', ')', '/', '\'', '&', '^', '$', '#', '@', '~'}; 
	
	public static void main(String[] args) {
		Format file = new Format();
		file.openFile();
		file.readFile();
		file.closeFile();
	}
	
	public void openFile(){
		try {	
			input = new Scanner(new File("hashText1.txt"));
		}
		catch(Exception e) {
			System.out.println("Could not find file");
		}
	}
	
	//make all words lower-case
	public void readFile() {
		while(input.hasNext()) {
			String nWord = "";
			String word = input.next();
			//gets rid of ALL punctuation & numbers -- could change later to include characters like <3
			for (int i = 0; i < word.length() && !word.matches(".*\\d+.*"); i++) {
				if (Character.getNumericValue(word.charAt(i)) != -1) {
					nWord += word.charAt(i);
				}
			}
			if (nWord != "") 
				System.out.println(nWord.toLowerCase() + " ");
		}
	}
	
	public void closeFile() {
		input.close();
	}
}
