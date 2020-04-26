package control;

import entity.Annuncio;
import entity.Filtri;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class FiltraggioAnnunciAppartamentiControl {
    private static FiltraggioAnnunciAppartamentiControl istance = null;
    private FiltraggioAnnunciAppartamentiControl()  {
    }
    public static FiltraggioAnnunciAppartamentiControl getInstance()    {
        if (FiltraggioAnnunciAppartamentiControl.istance == null)    {
            FiltraggioAnnunciAppartamentiControl.istance = new FiltraggioAnnunciAppartamentiControl();
        }
        return istance;
    }

    public Filtri setFilters(String luogo, Date dataIn, Date dataOut, double prezzoMin,
                             double prezzoMax, Boolean riscaldamento, Boolean aria, Boolean acqua,
                             Boolean elettricita, Boolean gas, Boolean condominio, Boolean parcheggio,
                             Boolean pulizie, Boolean wifi, Boolean telefonia, Boolean sorveglianza,
                             Boolean ascensore, Boolean portierato, int numMinLetti, int numMaxLetti, int numMinStanze, int numMaxStanze, String tipoAlloggio,
                             int numMaxPersone, Boolean animali, Boolean fumatori, String sesso,
                             Boolean paesi_conv, Boolean studente, Boolean lavoratore)  {
        Filtri filtri = new Filtri(luogo, dataIn, dataOut, prezzoMin, prezzoMax, riscaldamento, aria, acqua, elettricita, gas,
                condominio, parcheggio, pulizie, wifi, telefonia, sorveglianza, ascensore, portierato, numMinLetti, numMaxLetti, numMinStanze, numMaxStanze, tipoAlloggio,
                numMaxPersone, animali, fumatori, sesso, paesi_conv, studente, lavoratore);
        return filtri;
    }

    public ArrayList<Annuncio> filterApartmentAnnouncements(ArrayList<Annuncio> a1, Filtri filtri) throws IOException, SQLException {
        ArrayList<Annuncio> a = new ArrayList<>();
        int size = a1.size();
        int found_luogo = 1;
        int found_data = 1;
        int found_prezzo = 1;
        int found_riscald = 1;
        int found_aria = 1;
        int found_acqua = 1;
        int found_elettric = 1;
        int found_gas = 1;
        int found_cond = 1;
        int found_parch = 1;
        int found_pulizie = 1;
        int found_wifi = 1;
        int found_tel = 1;
        int found_sorv = 1;
        int found_asc = 1;
        int found_port = 1;
        int found_nletti = 1;
        int found_nstanze = 1;
        int found_tipoall = 1;
        int found_nummaxpers = 1;
        int found_animali = 1;
        int found_fumatori = 1;
        int found_sesso = 1;
        int found_paesiconv = 1;
        int found_studente = 1;
        int found_lavoratore = 1;

        for (int i=0; i<size; i++)  {

            if (filtri.getCheck_in()!=null && filtri.getCheck_out()!=null) {
                if ((filtri.getCheck_in().compareTo(a1.get(i).getData_min())>=0) && (filtri.getCheck_in().compareTo(a1.get(i).getData_max())<=0)
                        && (filtri.getCheck_out().compareTo(a1.get(i).getData_min())>=0) && (filtri.getCheck_out().compareTo(a1.get(i).getData_max())<=0)) {
                    found_data = 1;
                }
                else found_data = 0;
            }

            if (filtri.getLuogo()!=null)    {
                if (filtri.getLuogo().equalsIgnoreCase(a1.get(i).getLuogo()))   {
                    found_luogo = 1;
                }
                else found_luogo = 0;
            }

            if (filtri.getPrezzoMax()!=0)   {
                if (filtri.getPrezzoMax() >= a1.get(i).getPrezzo() && filtri.getPrezzoMin() <= a1.get(i).getPrezzo()) {
                    found_prezzo = 1;
                }
                else found_prezzo = 0;
            }

            if (filtri.isRiscaldamento()!=null)    {
                if (filtri.isRiscaldamento() == a1.get(i).isRiscaldamento())  {
                    found_riscald = 1;
                }
                else found_riscald = 0;
            }

            if (filtri.isAria() != null)   {
                if (a1.get(i).isAria()==filtri.isAria()) found_aria = 1;
                else found_aria = 0;
            }


            if (filtri.isAcqua() != null)  {
                if (a1.get(i).isAcqua()==filtri.isAcqua()) found_acqua = 1;
                else found_acqua = 0;
            }

            if (filtri.isElettricita() != null)    {
                if (a1.get(i).isElettricita()==filtri.isElettricita()) found_elettric = 1;
                else found_elettric = 0;
            }

            if (filtri.isGas() != null)    {
                if (a1.get(i).isGas()==filtri.isGas()) found_gas = 1;
                else found_gas = 0;
            }

            if (filtri.isCondominio() != null) {
                if (a1.get(i).isCondominio()==filtri.isCondominio()) found_cond = 1;
                else found_cond = 0;
            }

            if (filtri.isParcheggio() != null) {
                if (a1.get(i).isParcheggio()==filtri.isParcheggio()) found_parch = 1;
                else found_parch = 0;
            }

            if (filtri.isPulizie() != null)    {
                if (a1.get(i).isPulizie()==filtri.isPulizie()) found_pulizie = 1;
                else found_pulizie = 0;
            }

            if (filtri.isWifi() != null)   {
                if (a1.get(i).isWifi()==filtri.isWifi()) found_wifi = 1;
                else found_wifi = 0;
            }

            if (filtri.isTelefonia() != null)  {
                if (a1.get(i).isTelefonia()==filtri.isTelefonia()) found_tel = 1;
                else found_tel = 0;
            }

            if (filtri.isSorveglianza() != null)   {
                if (a1.get(i).isSorveglianza()==filtri.isSorveglianza()) found_sorv = 1;
                else found_sorv = 0;
            }

            if (filtri.isAscensore() != null)  {
                if (a1.get(i).isAscensore()==filtri.isAscensore()) found_asc = 1;
                else found_asc = 0;
            }

            if (filtri.isPortierato() != null) {
                if (a1.get(i).isPortierato()==filtri.isPortierato()) found_port = 1;
                else found_port = 0;
            }


            if (filtri.getNum_min_letti()!=0 && filtri.getNum_max_letti()!=0)   {
                if (filtri.getNum_min_letti()<=a1.get(i).getNum_letti() && filtri.getNum_max_letti()>=a1.get(i).getNum_letti())   {
                    found_nletti = 1;
                }
                else found_nletti = 0;
            }

            if (filtri.getNum_min_stanze()!=0 && filtri.getNum_max_stanze()!=0) {
                if (a1.get(i).getNum_stanze()>=filtri.getNum_min_stanze() && a1.get(i).getNum_stanze()<=filtri.getNum_max_stanze()) {
                    found_nstanze = 1;
                }
                else found_nstanze = 0;
            }

            if (filtri.getTipo_alloggio() != null)  {
                if (filtri.getTipo_alloggio().equals(a1.get(i).getTipo_alloggio()) || filtri.getTipo_alloggio() == "Tutti")   {
                    found_tipoall = 1;
                }
                else found_tipoall = 0;
            }

            if (filtri.getNum_max_persone() != 0)   {
                if (filtri.getNum_max_persone() == a1.get(i).getNum_max_persone())   {
                    found_nummaxpers = 1;
                }
                else found_nummaxpers = 0;
            }

            if (filtri.isAnimali() != null)    {
                if (a1.get(i).isAnimali()==filtri.isAnimali()) found_animali = 1;
                else found_animali = 0;
            }

            if (filtri.isFumatori() != null)   {
                if (a1.get(i).isFumatori()==filtri.isFumatori()) found_fumatori = 1;
                else found_fumatori = 0;
            }


            if (filtri.getSesso() != null)  {
                if (filtri.getSesso().equalsIgnoreCase(a1.get(i).getSesso()) || filtri.getSesso().equalsIgnoreCase("tutti"))   {
                    found_sesso = 1;
                }
                else found_sesso = 0;
            }

            if (filtri.isPaesi_conv() != null) {
                if (a1.get(i).isPaesi_conv()==filtri.isPaesi_conv()) found_paesiconv = 1;
                else found_paesiconv = 0;
            }

            if (filtri.isStudente() != null)   {
                if (a1.get(i).isStudente()==filtri.isStudente()) found_studente = 1;
                else found_studente = 0;
            }

            if (filtri.isLavoratore() != null) {
                if (a1.get(i).isLavoratore()==filtri.isLavoratore()) found_lavoratore = 1;
                else found_lavoratore = 0;
            }


            if (found_luogo == 1 && found_prezzo == 1 && found_aria == 1 && found_asc == 1 && found_cond == 1 && found_data == 1 && found_elettric == 1 && found_fumatori == 1 && found_gas == 1
                    && found_lavoratore == 1 && found_acqua == 1 && found_nletti == 1 && found_nstanze == 1 && found_nummaxpers == 1 && found_paesiconv == 1 && found_parch == 1 && found_port == 1 && found_animali == 1 && found_pulizie == 1
                    && found_riscald == 1 && found_sesso == 1 && found_sorv == 1 && found_studente == 1 && found_tel == 1 && found_tipoall == 1 && found_wifi == 1) {
                a.add(a1.get(i));
            }
        }
        return a;
    }
}
