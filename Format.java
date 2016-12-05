/**This program has a screen pop up asking for user-input for a filename to read
 * then asks for a word to search for. A hash function  is still needed to
 * finish the code. 
*/
package ctrlf;

/**
 *
 * @author jenniferwourms
 */
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//For Format class
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class FinalProjectNetbeans extends Application {

    @Override
    public void start(Stage startPage) throws Exception {
        startPage.setTitle("Hello there");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
         
        //Creates a title page asking for the word to be searched
        Text pageTitle = new Text("Looking for a word?");
        pageTitle.setFont(Font.font("Lora", FontWeight.NORMAL, 20));
        grid.add(pageTitle, 0, 0, 2, 1);
        
        Label fileName = new Label("Enter the name of the file you wish to search:");
        grid.add(fileName, 0, 1);
        
        TextField fileTextField = new TextField();
        grid.add(fileTextField, 1, 1);      
        fileTextField.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            Format file = new Format();
            //reads file using Format class
            file.read(fileTextField.getText());
            
            
            //New textbox appears asking for specific word to find
            Label searchFor = new Label("What word are you looking for?");
            grid.add(searchFor, 0, 3);
            TextField fileTextField2 = new TextField();
            grid.add(fileTextField2, 1, 3);
            fileTextField2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                  //find word
                  ArrayList <String> Found = new ArrayList <String>();
                  Format file2 = new Format();
                  String sWord = fileTextField2.getText();
                  int asciiv = file2.getAscii(sWord.toUpperCase());
                  hash h2 = new hash();
                  h2.find(sWord.toUpperCase(), asciiv);
                  h2.printtable();
            }
            
        });
        };
        });
        
        
        Scene scene = new Scene(grid, 600, 275);
        startPage.setScene(scene);
        startPage.show();
    
    
    }

    public static void main(String[] args) {
        launch(args);
    }

    
    //Format class to load, read, and close the file chosen by the user
    private static class Format {
	private Scanner input;

        public Format() {
        }
        
        public int getAscii(String searchedWord) {
            //ArrayList <String> Found = new ArrayList <String>();
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
                input = new Scanner(new File(fileName));
                System.out.println("Successfully loaded file ");
                readFile(input);
            }
            catch(Exception e) {
                System.out.println("Could not find file");
            }
        }
        //make all words lower-case
	public void readFile(Scanner input) {
            int index = 0;
		while(input.hasNext()) {
			String nWord = "";
			String word = input.next();
			//gets rid of ALL punctuation & numbers -- could change later to include characters like <3
			for (int i = 0; i < word.length() && !word.matches(".*\\d+.*"); i++) {
				if (Character.getNumericValue(word.charAt(i)) != -1) {
					nWord += word.charAt(i);
				}
			}
			if (nWord != "") {
                                int asciiValue = getAscii(nWord);
				System.out.println(nWord.toUpperCase() + " " + asciiValue);
				//insert hash function here
                                hash hTable = new hash();
                                hTable.insert(asciiValue, nWord.toUpperCase(), index);
                               
			}
                        index++;
		}
                closeFile(input);
	}
	
	public void closeFile(Scanner input) {
		input.close();
	}
    }

    
}
