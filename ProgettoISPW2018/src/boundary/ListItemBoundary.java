package boundary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ListItemBoundary {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelAppartamento;

    @FXML
    private Label labelLuogo;

    @FXML
    private Label labelPrezzo;

    @FXML
    private Label labelValutazione;

    public void setValues(String appartamento, String luogo, double prezzo, double valutazione) {
        labelAppartamento.setText(appartamento);
        labelLuogo.setText("Luogo: "+luogo);
        labelPrezzo.setText("Prezzo: "+prezzo+" €");
        labelValutazione.setText("Valutazione: "+valutazione+" stelle");
    }

    @FXML
    void initialize() {
        assert labelAppartamento != null : "fx:id=\"labelAppartamento\" was not injected: check your FXML file 'ListItem.fxml'.";
        assert labelLuogo != null : "fx:id=\"labelLuogo\" was not injected: check your FXML file 'ListItem.fxml'.";
        assert labelPrezzo != null : "fx:id=\"labelPrezzo\" was not injected: check your FXML file 'ListItem.fxml'.";
        assert labelValutazione != null : "fx:id=\"labelValutazione\" was not injected: check your FXML file 'ListItem.fxml'.";

    }
}

