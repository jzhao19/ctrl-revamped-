import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends Format implements ActionListener {
	
	private JTextField text;
	
	public GUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create search button
		Button search = new Button("Search");
		frame.add(search, BorderLayout.EAST);
		search.addActionListener(this);
		
		//Create textbox
		text = new JTextField("Search for a word", 13);
		frame.add(text, BorderLayout.WEST);
		
		frame.setSize(250, 100);
		frame.setVisible(true);
	}
	
	//When search button is pressed, console prints the user-inputted word to be searched
	public void actionPerformed(ActionEvent evt){
		String word = text.getText();
		System.out.println(word);
	}
	
	public static void main(String[] args) {
		new GUI();
	}
}
