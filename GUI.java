
package pkgfinal.project.netbeans;

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
            System.out.println(fileTextField.getText());
            //openFile, readFile, closeFile methods called from Format class
        }
        });
        
        Scene scene = new Scene(grid, 600, 275);
        startPage.setScene(scene);
        startPage.show();
    
    
    }

    public static void main(String[] args) {
        launch(args);
    }

    
}
