package control;

import dao.AnnunciAppartamentiDao;
import entity.Annuncio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
        return annunci;
    }
}
