package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileExplorer {
	
	File selectedFile;
	@FXML
	FileChooser fc = new FileChooser();

	    @FXML
	    private Button selectFile;

	    @FXML
	    private Label fileName;

	    @FXML
	    private TextField tf;

	    @FXML
	    private Button search;

	    @FXML
	    private Label result;
	    
	    @FXML
		private void initialize() {
	    	
	    	selectFile.setOnAction((ae) -> {
	    		try {
				selectedFile = fc.showOpenDialog(null);
				fileName.setText(selectedFile.getName());
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
				if (selectedFile == null) {
					result.setText("Wybierz plik!");
				}
			});
	    	
	    	search.setOnAction((ae) -> {
				if (selectedFile != null && (!tf.getText().equals(""))) {
					int found = findWord(selectedFile, tf.getText().trim());
						result.setText(Integer.toString(found));
				}});
	    }
	    
	    private int findWord(File file, String word) {
			int found = 0;
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String i;
				while ((i = br.readLine()) != null) {
					if (i.contains(word)) {
						found++;
					} 
				} 	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return found;
		}
}
		

