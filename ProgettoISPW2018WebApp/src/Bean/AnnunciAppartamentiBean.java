package Bean;

import Control.AnnunciAppartamentiController;
import Entity.Annuncio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnnunciAppartamentiBean {
    public ArrayList<Annuncio> getAllAnnunci() throws IOException, SQLException {
        return AnnunciAppartamentiController.getIstance().getAnnunci();
    }
}
