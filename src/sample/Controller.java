package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import xiflib.XifLib;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

	@FXML
	private Button btnIn;
	@FXML
	private Label lblRutaIn;
	@FXML
	private TextField tfOut;
	
	private FileChooser fileChooser;
	private File fileIn;
	private File fileOut;

	/**
	 * CERCA EL FITXER D'ENTRADA
	 * 
	 * @param e
	 */
	@FXML
	public void onClickBtnIn(ActionEvent e) {
		fileIn = fileChooser.showOpenDialog(null);
		lblRutaIn.setText(fileIn.getPath());
	}

	/**
	 * XIFRA / DESXIFRA EL DOCUMENT ESCOLLIT
	 * 
	 * @param e
	 */
	@FXML
	public void onClickBtnXif(ActionEvent e) {
		fileOut = new File(tfOut.getText());
		XifLib xif = new XifLib();
		xif.xifrar(fileIn, fileOut);

		lblRutaIn.setText("");
		tfOut.setText("");
	}

	public void initialize() {
		fileChooser = new FileChooser();
	}
}
