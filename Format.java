/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrlf;

//Format class to load, read, and close the file chosen by the user

import java.io.File;
import java.util.Scanner;
import javafx.application.Platform;

    public class Format {
	private Scanner input;
        private boolean toolarge = false;

        public Format() {
        }
        
        public int getAscii(String searchedWord) { //gets the ascii value of the string
            String hashMe = searchedWord.toUpperCase();
            int asciiValue = 0;
            for (int i = 0; i < hashMe.length(); i++) {
                char character = hashMe.charAt(i);
                int ascii = (int) character;
                asciiValue = asciiValue + ascii;
            }
            return asciiValue;
        }
             
        public boolean read(String fileName) { //reads the file using scanner
            try {
                input = new Scanner(new File(fileName));
                readFile(input);
                return true;
            }
            catch(Exception e) {
                return false;
            }
        }
        //make all words lower-case
        
        public boolean readFile(Scanner input) { //loads the file and deletes all characters that do not make up a word. eg, punctuation
            int index = 0;
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
                                int asciiValue = getAscii(nWord.toString());
				System.out.println(nWord.toString().toUpperCase() + " " + asciiValue);
				//insert hash function here
                                hash hTable = new hash();
                                hTable.insert(asciiValue, nWord.toString().toUpperCase(), index);
                                if (hTable.isfull(index)){
                                    toolarge = true;
                                    System.out.println("File too large");
                                    
                                }
			}
                        index++;
		}
                closeFile(input);
                return true;
	} 
        
        public boolean islarge(){
            return toolarge;
        }
	
	public void closeFile(Scanner input) {
		input.close();
	}
    }


