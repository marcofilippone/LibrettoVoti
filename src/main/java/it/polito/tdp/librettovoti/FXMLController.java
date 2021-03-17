package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

	  @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField txtVoto;

	    @FXML
	    private DatePicker pickerData;

	    @FXML
	    private Button btnInserisci;

	    @FXML
	    private TextField txtEsame;

	    @FXML
	    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	// Leggi e controlla i dati
    	String nomeEsame = txtEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtResult.setText("Errore! Inserire almeno una lettera di nome esame");
    		return;
    	}
    	
    	String votoEsame = txtVoto.getText();
    	int votoInt = 0;
    	try {
    	votoInt = Integer.parseInt(votoEsame);
    	} catch(NumberFormatException nfe) {
    		txtResult.setText("Errore! Inserire voto numerico");
    		return;
    	}
    	if(votoInt<18 || votoInt>30) {
    		txtResult.setText("Errore! Il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	
    	LocalDate data = pickerData.getValue();
    	/*LocalDate data;
    	try {
    		data = LocalDate.parse(dataEsame);
    	} catch(DateTimeParseException e){
    		txtResult.setText("Errore! Data non inserita nel formato corretto");
    		return;
    	}*/
    	if(data==null) {
    		txtResult.setText("Errore! La data è errata o mancante");
    		return;
    	}
    	
    	//Esegui l'azione
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	//Aggiorna i risultati (nella View)
    	txtResult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	pickerData.setValue(null);
    	
    }

    @FXML
    void initialize() {
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerData != null : "fx:id=\"pickerData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

 
    public void setModel(Libretto model) {
    	this.model = model;
    }
}
