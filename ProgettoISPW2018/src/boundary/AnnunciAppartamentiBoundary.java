package boundary;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import control.AnnunciAppartamentiController;
import control.FiltraggioAnnunciAppartamentiControl;
import control.OrdinamentoAnnunciAppartamentiControl;
import dao.AnnunciAppartamentiDao;
import entity.Annuncio;
import entity.Filtri;
import entity.Ordinamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import thread.CounterThread;


public class AnnunciAppartamentiBoundary {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField luogoTf;

    @FXML
    private DatePicker checkInDp;

    @FXML
    private Slider prezzoMinSldr;

    @FXML
    private Slider prezzoMaxSldr;

    @FXML
    private DatePicker checkOutDp;

    @FXML
    private Button searchBtn;

    @FXML
    private CheckBox riscaldamentoCb;

    @FXML
    private CheckBox ariaCb;

    @FXML
    private CheckBox acquaCb;

    @FXML
    private CheckBox elettricitàCb;

    @FXML
    private CheckBox gasCb;

    @FXML
    private CheckBox condominioCb;

    @FXML
    private CheckBox parcheggioCb;

    @FXML
    private CheckBox pulizieCb;

    @FXML
    private CheckBox wifiCb;

    @FXML
    private CheckBox telefoniaCb;

    @FXML
    private CheckBox ascensoreCb;

    @FXML
    private CheckBox sorveglianzaCb;

    @FXML
    private CheckBox portieratoCb;

    @FXML
    private ComboBox<String> tipoAlloggioCb;

    @FXML
    private TextField numeroMaxPersoneTf;

    @FXML
    private TextField numeroMinLettiTf;

    @FXML
    private TextField numeroMaxLettiTf;

    @FXML
    private TextField numeroMinStanzeTf;

    @FXML
    private TextField numeroMaxStanzeTf;

    @FXML
    private CheckBox animaliAmmessiCb;

    @FXML
    private CheckBox nonFumatoriCb;

    @FXML
    private CheckBox soloDonneCb;

    @FXML
    private CheckBox soloUominiCb;

    @FXML
    private CheckBox soloPaesiConvenzionatiCb;

    @FXML
    private CheckBox studenteCb;

    @FXML
    private CheckBox lavoratoreCb;

    @FXML
    private ComboBox<String> ordinaCb;

    @FXML
    private ListView<Annuncio> listAnnunciLV;

    public Boolean checkBox(CheckBox checkBox) {
        Boolean filtroCheckBox;
        if (checkBox.isSelected()) {
            filtroCheckBox = true;
        } else {
            filtroCheckBox = null;
        }
        return filtroCheckBox;
    }

    public void setListView(ObservableList list) {
        listAnnunciLV.setItems(list);
        listAnnunciLV.setCellFactory(lv -> new ListCell<Annuncio>() {
            private Node graphic;
            private ListItemBoundary controller;

            {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/FXML/ListItem.fxml"));
                    graphic = loader.load();
                    controller = loader.getController();
                } catch (IOException exc) {
                    throw new RuntimeException(exc);
                }
            }

            @Override
            protected void updateItem(Annuncio a, boolean empty) {
                super.updateItem(a, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    controller.setValues(a.getNome(), a.getLuogo(), a.getPrezzo(), a.getValutazione());
                    setGraphic(graphic);
                }
            }
        });
    }

    @FXML
    void doSearchBtn(ActionEvent event) throws IOException, SQLException, NumberFormatException {
        AnnunciAppartamentiDao annunciAppartamentiDao = new AnnunciAppartamentiDao();
        ArrayList<Annuncio> annunci = annunciAppartamentiDao.allAnnunciAppartamenti();
        if (luogoTf.getText().length() == 0 || checkInDp.getValue() == null || checkOutDp.getValue() == null)  {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Attenzione!");
            alert.setContentText("Luogo, check-in e check-out campi obbligatori!");
            alert.showAndWait();
            return;
        }
        String luogo = luogoTf.getText();
        Date dataIn = Date.valueOf(checkInDp.getValue());
        Date dataOut = Date.valueOf(checkOutDp.getValue());
        Double prezzoMin = prezzoMinSldr.getValue();
        Double prezzoMax = prezzoMaxSldr.getValue();
        Integer numMinLetti = 0;
        Integer numMaxLetti = 0;
        Integer numMinStanze = 0;
        Integer numMaxStanze = 0;
        Integer numMaxPersone = 0;
        String tipoAlloggio = null;
        String sesso = null;
        Boolean riscaldamento = checkBox(riscaldamentoCb);
        Boolean aria = checkBox(ariaCb);
        Boolean acqua = checkBox(acquaCb);
        Boolean elettricita = checkBox(elettricitàCb);
        Boolean gas = checkBox(gasCb);
        Boolean condominio = checkBox(condominioCb);
        Boolean parcheggio = checkBox(parcheggioCb);
        Boolean pulizie = checkBox(pulizieCb);
        Boolean wifi = checkBox(wifiCb);
        Boolean telefonia = checkBox(telefoniaCb);
        Boolean sorveglianza = checkBox(sorveglianzaCb);
        Boolean ascensore = checkBox(ascensoreCb);
        Boolean portierato = checkBox(portieratoCb);
        Boolean animali = checkBox(animaliAmmessiCb);
        Boolean fumatori = checkBox(nonFumatoriCb);
        Boolean paesi_conv = checkBox(soloPaesiConvenzionatiCb);
        Boolean studente = checkBox(studenteCb);
        Boolean lavoratore = checkBox(lavoratoreCb);

        if (!numeroMaxPersoneTf.getText().trim().isEmpty())   {
            numMaxPersone = Integer.parseInt(numeroMaxPersoneTf.getText());
        } else  {
            numMaxPersone = 0;
        }
        if (!numeroMinLettiTf.getText().trim().isEmpty())   {
            numMinLetti = Integer.parseInt(numeroMinLettiTf.getText());
        } else  {
            numMinLetti = 0;
        }
        if (!numeroMaxLettiTf.getText().trim().isEmpty())   {
            numMaxLetti = Integer.parseInt(numeroMaxLettiTf.getText());
        } else  {
            numMaxLetti = 0;
        }
        if (!numeroMinStanzeTf.getText().trim().isEmpty())   {
            numMinStanze = Integer.parseInt(numeroMinStanzeTf.getText());
        } else  {
            numMinStanze = 0;
        }
        if (!numeroMaxStanzeTf.getText().trim().isEmpty())   {
            numMaxStanze = Integer.parseInt(numeroMaxStanzeTf.getText());
        } else  {
            numMaxStanze = 0;
        }
        if (!tipoAlloggioCb.getSelectionModel().isEmpty())  {
            tipoAlloggio = tipoAlloggioCb.getValue();
        } else  {
            tipoAlloggio = null;
        }
        if (soloDonneCb.isSelected())   {
            sesso = "donne";
        } else if (soloUominiCb.isSelected())  {
            sesso = "uomini";
        } else  {
            sesso = "tutti";
        }

        if (dataIn.compareTo(dataOut)>0 || dataOut.compareTo(dataIn)<0)    {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Attenzione!");
            alert.setContentText("Inserire una data di check-in precedente alla data di check-out ed una data di check-out successiva alla data di check-in!");
            alert.showAndWait();
        } else if (prezzoMin>prezzoMax) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Attenzione!");
            alert.setContentText("Inserire un prezzo minimo minore del prezzo massimo!");
            alert.showAndWait();
        }
        else    {
            Filtri filtri = FiltraggioAnnunciAppartamentiControl.getInstance().setFilters(luogo, dataIn, dataOut, prezzoMin, prezzoMax, riscaldamento, aria, acqua, elettricita, gas,
                    condominio, parcheggio, pulizie, wifi, telefonia, sorveglianza, ascensore, portierato, numMinLetti, numMaxLetti, numMinStanze, numMaxStanze, tipoAlloggio,
                    numMaxPersone, animali, fumatori, sesso, paesi_conv, studente, lavoratore);
            ArrayList<Annuncio> a = FiltraggioAnnunciAppartamentiControl.getInstance().filterApartmentAnnouncements(annunci, filtri);
            if (a.isEmpty())    {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Attenzione!");
                alert.setContentText("Nessun elemento trovato con i criteri di filtraggio inseriti!");
                alert.showAndWait();
            }
            CounterThread counterThread = new CounterThread(a);
            list = FXCollections.observableArrayList(a);
            setListView(list);
            counterThread.start();
        }
    }

    private ObservableList<Annuncio> list;

    @FXML
    void onOrderBtn(ActionEvent event) {
        Ordinamento ordinazione = OrdinamentoAnnunciAppartamentiControl.getInstance().setOrdinamento(ordinaCb.getValue());
        ObservableList<Annuncio> a = listAnnunciLV.getItems();
        ObservableList<Annuncio> a1 = OrdinamentoAnnunciAppartamentiControl.getInstance().sortApartmentAnnouncements(a, ordinazione);
        list = FXCollections.observableArrayList(a1);
        setListView(list);
    }

    public void impostaListView() throws IOException, SQLException {
        ArrayList<Annuncio> a = AnnunciAppartamentiController.getIstance().getAnnunci();
        CounterThread counterThread = new CounterThread(a);
        list = FXCollections.observableArrayList(a);
        listAnnunciLV.setItems(list);
        setListView(list);
        counterThread.start();
    }

    @FXML
    void initialize() throws IOException, SQLException {
        impostaListView();
        ObservableList<String> orderList = FXCollections.observableArrayList("Prezzo crescente", "Prezzo decrescente", "Valutazioni migliori-peggiori", "Valutazioni peggiori-migliori");
        ordinaCb.setItems(orderList);
        ObservableList<String> tipoAlloggioList = FXCollections.observableArrayList("Appartamento intero", "Stanza privata", "Stanza condivisa");
        tipoAlloggioCb.setItems(tipoAlloggioList);
        assert luogoTf != null : "fx:id=\"luogoTf\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert checkInDp != null : "fx:id=\"checkInDp\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert checkOutDp != null : "fx:id=\"checkOutDp\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert searchBtn != null : "fx:id=\"searchBtn\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert prezzoMinSldr != null : "fx:id=\"prezzoMinSldr\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert prezzoMaxSldr != null : "fx:id=\"prezzoMaxSldr\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert riscaldamentoCb != null : "fx:id=\"riscaldamentoCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert ariaCb != null : "fx:id=\"ariaCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert acquaCb != null : "fx:id=\"acquaCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert elettricitàCb != null : "fx:id=\"elettricitàCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert gasCb != null : "fx:id=\"gasCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert condominioCb != null : "fx:id=\"condominioCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert parcheggioCb != null : "fx:id=\"parcheggioCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert pulizieCb != null : "fx:id=\"pulizieCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert wifiCb != null : "fx:id=\"wifiCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert telefoniaCb != null : "fx:id=\"telefoniaCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert ascensoreCb != null : "fx:id=\"ascensoreCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert sorveglianzaCb != null : "fx:id=\"sorveglianzaCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert portieratoCb != null : "fx:id=\"portieratoCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert tipoAlloggioCb != null : "fx:id=\"tipoAlloggioCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert numeroMaxPersoneTf != null : "fx:id=\"numeroMaxPersoneTf\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert numeroMinLettiTf != null : "fx:id=\"numeroMinLettiTf\" was not injected: check your FXML file 'AnnunciAppartamenti.fxml'.";
        assert numeroMaxLettiTf != null : "fx:id=\"numeroMaxLettiTf\" was not injected: check your FXML file 'AnnunciAppartamenti.fxml'.";
        assert numeroMinStanzeTf != null : "fx:id=\"numeroMinStanzeTf\" was not injected: check your FXML file 'AnnunciAppartamenti.fxml'.";
        assert numeroMaxStanzeTf != null : "fx:id=\"numeroMaxStanzeTf\" was not injected: check your FXML file 'AnnunciAppartamenti.fxml'.";
        assert animaliAmmessiCb != null : "fx:id=\"animaliAmmessiCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert nonFumatoriCb != null : "fx:id=\"nonFumatoriCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert soloDonneCb != null : "fx:id=\"soloDonneCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert soloUominiCb != null : "fx:id=\"soloUominiCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert soloPaesiConvenzionatiCb != null : "fx:id=\"soloPaesiConvenzionatiCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert studenteCb != null : "fx:id=\"studenteCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert lavoratoreCb != null : "fx:id=\"lavoratoreCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert ordinaCb != null : "fx:id=\"ordinaCb\" was not injected: check your FXML file 'AnnunciAppartamentiBoundary.fxml'.";
        assert listAnnunciLV != null : "fx:id=\"listAnnunciLV\" was not injected: check your FXML file 'AnnunciAppartamenti.fxml'.";
    }
}
