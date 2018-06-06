package it.polito.tdp.rivers;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.Risultato;
import it.polito.tdp.rivers.model.River;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RiversController {
	
	private Model model;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<River> boxRiver;

    @FXML
    private TextField txtStartDate;

    @FXML
    private TextField txtEndDate;

    @FXML
    private TextField txtNumMeasurements;

    @FXML
    private TextField txtFMed;

    @FXML
    private TextField txtK;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;
    
    @FXML
    void doPopola(ActionEvent event) {
    	River r = boxRiver.getValue();
    	Risultato risultato = model.getRisultato(r);
    	txtStartDate.setText(risultato.getStartDate().toString());
    	txtEndDate.setText(risultato.getEndDate().toString());
    	txtNumMeasurements.setText(String.format("%d",risultato.getNumMeasurements()));
    	txtFMed.setText(String.format("%f",risultato.getFMed()));
    	
    }

    @FXML
    void doSimula(ActionEvent event) {
    	try {
    		int k = Integer.parseInt(txtK.getText());
    		if(k<=0) {
    			txtResult.setText("Inserire un valore numerico intero k>0");
        		return;
    		}
    		
    		model.simula(k);
    		
    	}catch(NumberFormatException e) {
    		txtResult.setText("Inserire un valore numerico intero k>0");
    		return;
    	}
    }

    @FXML
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rivers.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	boxRiver.getItems().addAll(model.getFiumi());
    }
}
