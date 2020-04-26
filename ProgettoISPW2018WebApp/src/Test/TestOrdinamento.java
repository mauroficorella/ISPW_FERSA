package Test;

import Control.OrdinamentoAnnunciAppartamentiControl;
import Dao.AnnunciAppartamentiDao;
import Entity.Annuncio;
import Entity.Ordinamento;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class TestOrdinamento {

    @Test
    public void testOrder() throws IOException, SQLException {
        //TEST ORDINAMENTO PREZZO CRESCENTE
        ArrayList<String> risultatoAttesoPrezzoCrescente = new ArrayList<>();
        ArrayList<String> testAnnunciPrezzoCrescente = new ArrayList<>();
        ArrayList<Annuncio> annunciOrdinatiPrezzoCrescente;
        AnnunciAppartamentiDao annunciAppartamentiDao = new AnnunciAppartamentiDao();
        ArrayList<Annuncio> ann1 = annunciAppartamentiDao.allAnnunciAppartamenti();
        risultatoAttesoPrezzoCrescente.add("appart10");
        risultatoAttesoPrezzoCrescente.add("appart3");
        risultatoAttesoPrezzoCrescente.add("appart9");
        risultatoAttesoPrezzoCrescente.add("appart2");
        risultatoAttesoPrezzoCrescente.add("appart7");
        Ordinamento ordinamento = new Ordinamento("Prezzo crescente");
        annunciOrdinatiPrezzoCrescente = OrdinamentoAnnunciAppartamentiControl.getInstance().sortApartmentAnnouncements(ann1, ordinamento);
        for (int i=0; i<5; i++) {
            testAnnunciPrezzoCrescente.add(annunciOrdinatiPrezzoCrescente.get(i).getNome());
        }
        //TEST ORDINAMENTO VALUTAZIONI MIGLIORI
        ArrayList<String> risultatoAttesoValutazioniMigliori = new ArrayList<>();
        ArrayList<String> testAnnunciValutazioniMigliori = new ArrayList<>();
        ArrayList<Annuncio> annunciOrdinatiValutazioniMigliori;
        ArrayList<Annuncio> ann2 = annunciAppartamentiDao.allAnnunciAppartamenti();
        risultatoAttesoValutazioniMigliori.add("appart4");
        risultatoAttesoValutazioniMigliori.add("appart9");
        risultatoAttesoValutazioniMigliori.add("appart7");
        risultatoAttesoValutazioniMigliori.add("appart2");
        risultatoAttesoValutazioniMigliori.add("appart10");
        Ordinamento ordinamento1 = new Ordinamento("Valutazioni migliori-peggiori");
        annunciOrdinatiValutazioniMigliori = OrdinamentoAnnunciAppartamentiControl.getInstance().sortApartmentAnnouncements(ann2,ordinamento1);
        for (int i=0; i<5; i++) {
            testAnnunciValutazioniMigliori.add(annunciOrdinatiValutazioniMigliori.get(i).getNome());
        }
        //VERIFICO L'ESITO DEL TEST
        assertEquals("test sul prezzo crescente non riuscito", risultatoAttesoPrezzoCrescente, testAnnunciPrezzoCrescente);
        assertEquals("test sulle valutazioni migliori non riuscito", risultatoAttesoValutazioniMigliori, testAnnunciValutazioniMigliori);
    }
}
