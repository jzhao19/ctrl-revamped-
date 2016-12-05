package pkgfinal.project.netbeans;


import java.io.File;
import java.util.Scanner;

//Format class to load, read, and close the file chosen by the user
    public class Format {
	private Scanner input;

        public Format() {
        }
        
        public int findKey(String searchedWord) {
            String hashMe = searchedWord.toUpperCase();
            int asciiValue = 0;
            for (int i = 0; i < hashMe.length(); i++) {
                char character = hashMe.charAt(i);
                int ascii = (int) character;
                asciiValue = asciiValue + ascii;
            }
            return asciiValue;
        }
        
       
        
        
        public void read(String fileName) {
            try {
                File text = new File(fileName);
                input = new Scanner(text);
                readFile(input);
            }
            
            catch(Exception e) {
              System.out.println("Could not open file");      
            }
            
        }
        //make all words lower-case
	public void readFile(Scanner input) {
		while(input.hasNext()) {
                        StringBuilder nWord = new StringBuilder();   
			String word = input.next();
			//gets rid of ALL punctuation & numbers -- could change later to include characters like <3
			for (int i = 0; i < word.length() && !word.matches(".*\\d+.*"); i++) {
				if (Character.getNumericValue(word.charAt(i)) != -1) {
					nWord.append(word.charAt(i));
				}
			}
			if (nWord.length() > 0) {
                                int asciiValue = findKey(nWord.toString());
				System.out.println(nWord.toString().toUpperCase() + " " + asciiValue);
				//insert hash function here
                                hash hTable = new hash();
                                hTable.insert(asciiValue, nWord.toString().toUpperCase());
			}
		}
                closeFile(input);
	} 
	
	public void closeFile(Scanner input) {
		input.close();
	}
    }
