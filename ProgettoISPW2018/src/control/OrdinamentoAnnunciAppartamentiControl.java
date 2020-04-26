package control;

import entity.Annuncio;
import entity.Ordinamento;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Comparator;

public class OrdinamentoAnnunciAppartamentiControl {
    private static OrdinamentoAnnunciAppartamentiControl istance = null;
    private OrdinamentoAnnunciAppartamentiControl() {
    }

    public static OrdinamentoAnnunciAppartamentiControl getInstance()   {
        if (OrdinamentoAnnunciAppartamentiControl.istance == null)    {
            OrdinamentoAnnunciAppartamentiControl.istance = new OrdinamentoAnnunciAppartamentiControl();
        }
        return istance;
    }

    public Ordinamento setOrdinamento(String ordinazione)   {
        Ordinamento o = new Ordinamento(ordinazione);
        return o;
    }

    public ObservableList<Annuncio> sortApartmentAnnouncements(ObservableList<Annuncio> a, Ordinamento ordinazione)  {
        try {
            if (ordinazione.getOrdinamento() == "Prezzo crescente")    {
                Collections.sort(a, new Comparator<Annuncio>() {
                    @Override
                    public int compare(Annuncio a1, Annuncio a2)
                    {
                        return String.valueOf(a1.getPrezzo()).compareTo(String.valueOf(a2.getPrezzo()));
                    }
                });
            }
            else if (ordinazione.getOrdinamento() == "Prezzo decrescente")    {
                Collections.sort(a, new Comparator<Annuncio>() {
                    @Override
                    public int compare(Annuncio ann1, Annuncio ann2)
                    {
                        return  String.valueOf(ann2.getPrezzo()).compareTo(String.valueOf(ann1.getPrezzo()));
                    }
                });
            }
            else if (ordinazione.getOrdinamento() == "Valutazioni migliori-peggiori")  {
                Collections.sort(a, new Comparator<Annuncio>() {
                    @Override
                    public int compare(Annuncio ann1, Annuncio ann2)
                    {
                        return  String.valueOf(ann2.getValutazione()).compareTo(String.valueOf(ann1.getValutazione()));
                    }
                });
            }
            else {
                Collections.sort(a, new Comparator<Annuncio>() {
                    @Override
                    public int compare(Annuncio ann1, Annuncio ann2)
                    {
                        return  String.valueOf(ann1.getValutazione()).compareTo(String.valueOf(ann2.getValutazione()));
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
}
