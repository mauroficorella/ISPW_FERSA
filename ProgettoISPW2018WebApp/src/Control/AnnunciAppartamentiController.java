package Control;

import Dao.AnnunciAppartamentiDao;
import Entity.Annuncio;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import Thread.CounterThread;

public class AnnunciAppartamentiController {
    private static AnnunciAppartamentiController istance = null;
    private AnnunciAppartamentiController() {
    }

    public static AnnunciAppartamentiController getIstance()  {
        if (AnnunciAppartamentiController.istance == null)    {
            AnnunciAppartamentiController.istance = new AnnunciAppartamentiController();
        }
        return istance;
    }

    public ArrayList<Annuncio> getAnnunci() throws IOException, SQLException {
        AnnunciAppartamentiDao annunciAppartamentiDao = new AnnunciAppartamentiDao();
        ArrayList<Annuncio> annunci = annunciAppartamentiDao.allAnnunciAppartamenti();
        CounterThread counterThread = new CounterThread(annunci);
        counterThread.start();
        return annunci;
    }
}
