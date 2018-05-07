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

public class Controller implements Initializable {

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
	 * CERCA LA RUTA DEL FITXER D'ENTRADA
	 * 
	 * @param ae
	 */
	@FXML
	public void onClickBtnIn(ActionEvent ae) {

		fileIn = fileChooser.showOpenDialog(null);
		lblRutaIn.setText(fileIn.getPath());

	}

	/**
	 * XIFA/DESXIFRA EL DOCUMENT ESCOLLIT
	 * 
	 * @param ae
	 */
	@FXML
	public void onClickBtnXif(ActionEvent ae) {

		fileOut = new File(tfOut.getText());
		XifLib xif = new XifLib();
		xif.xifrar(fileIn, fileOut);

		lblRutaIn.setText("");
		tfOut.setText("");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		fileChooser = new FileChooser();

	}
}
