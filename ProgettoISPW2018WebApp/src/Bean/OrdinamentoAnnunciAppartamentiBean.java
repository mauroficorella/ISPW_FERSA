package Bean;

import Control.OrdinamentoAnnunciAppartamentiControl;
import Entity.Annuncio;
import Entity.Ordinamento;

import java.util.ArrayList;

public class OrdinamentoAnnunciAppartamentiBean {
    private  String order;

    public void setOrder(String order) {
        this.order = order;
    }


    public Ordinamento setOrdinamento()    {
        Ordinamento o = OrdinamentoAnnunciAppartamentiControl.getInstance().setOrdinamento(order);
        return o;
    }

    public ArrayList<Annuncio> ordinaAnnunci(ArrayList<Annuncio> a, Ordinamento o)  {
        ArrayList<Annuncio> annunci = OrdinamentoAnnunciAppartamentiControl.getInstance().sortApartmentAnnouncements(a, o);
        return annunci;
    }
}
