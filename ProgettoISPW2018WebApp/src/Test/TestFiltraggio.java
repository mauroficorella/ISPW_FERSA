package Test;

import Control.FiltraggioAnnunciAppartamentiControl;
import Dao.AnnunciAppartamentiDao;
import Entity.Annuncio;
import Entity.Filtri;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestFiltraggio {
    @Test
    public void testFilter() throws IOException, SQLException {
        //TEST FILTRAGGIO REALE
        ArrayList<String> risultatoAtteso1 = new ArrayList<>();
        ArrayList<String> testAnnunci1 = new ArrayList<>();
        ArrayList<Annuncio> annunciFiltrati1;
        AnnunciAppartamentiDao annunciAppartamentiDao = new AnnunciAppartamentiDao();
        ArrayList<Annuncio> ann1 = annunciAppartamentiDao.allAnnunciAppartamenti();
        risultatoAtteso1.add("appart1");
        risultatoAtteso1.add("appart11");
        Filtri filtraggio = new Filtri("Roma", Date.valueOf("2018-05-20"), Date.valueOf("2018-06-01"), 0, 0, true, null, true,
                true, null, null, null, null, null, null, null, null, null, 0,
                0, 0, 0, null, 0, null, null, null, null, null, null);
        annunciFiltrati1 = FiltraggioAnnunciAppartamentiControl.getInstance().filterApartmentAnnouncements(ann1, filtraggio);
        for (int i=0; i<annunciFiltrati1.size(); i++) {
            testAnnunci1.add(annunciFiltrati1.get(i).getNome());
        }
        //TEST FILTRAGGIO VUOTO
        ArrayList<String> risultatoAtteso2 = new ArrayList<>();
        ArrayList<String> testAnnunci2 = new ArrayList<>();
        ArrayList<Annuncio> annunciFiltrati2;
        ArrayList<Annuncio> ann2 = annunciAppartamentiDao.allAnnunciAppartamenti();
        Filtri filtraggio1 = new Filtri("Roma", Date.valueOf("2018-05-20"), Date.valueOf("2018-07-01"), 0, 0, null, null, null,
                null, null, null, null, null, null, null, null, null, null, 0,
                0, 0, 0, null, 0, null, null, null, null, null, null);
        annunciFiltrati2 = FiltraggioAnnunciAppartamentiControl.getInstance().filterApartmentAnnouncements(ann2, filtraggio1);
        for (int i=0; i<annunciFiltrati2.size(); i++)   {
            testAnnunci2.add(annunciFiltrati2.get(i).getNome());
        }
        //VERIFICO L'ESITO DEL TEST
        assertEquals("test sul filtraggio 1", risultatoAtteso1, testAnnunci1);
        assertEquals("test sul filtraggio 2", risultatoAtteso2, testAnnunci2);
    }
}
