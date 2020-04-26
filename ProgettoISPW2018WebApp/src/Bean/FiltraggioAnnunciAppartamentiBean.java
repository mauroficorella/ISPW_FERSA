package Bean;

import Control.FiltraggioAnnunciAppartamentiControl;
import Dao.AnnunciAppartamentiDao;
import Entity.Annuncio;
import Entity.Filtri;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class FiltraggioAnnunciAppartamentiBean {
    private String luogo;
    private Date check_in;
    private Date check_out;
    private double prezzoMin;
    private double prezzoMax;
    private Boolean riscaldamento;
    private Boolean aria;
    private Boolean acqua;
    private Boolean elettricita;
    private Boolean gas;
    private Boolean condominio;
    private Boolean parcheggio;
    private Boolean pulizie;
    private Boolean wifi;
    private Boolean telefonia;
    private Boolean sorveglianza;
    private Boolean ascensore;
    private Boolean portierato;
    private int num_min_letti;
    private int num_max_letti;
    private int num_min_stanze;
    private int num_max_stanze;
    private String tipo_alloggio;
    private int num_max_persone;
    private Boolean animali;
    private Boolean fumatori;
    private String sesso;
    private Boolean paesi_conv;
    private Boolean studente;
    private Boolean lavoratore;

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public void setPrezzoMin(double prezzoMin) {
        this.prezzoMin = prezzoMin;
    }

    public void setPrezzoMax(double prezzoMax) {
        this.prezzoMax = prezzoMax;
    }

    public void setRiscaldamento(Boolean riscaldamento) {
        this.riscaldamento = riscaldamento;
    }

    public void setAria(Boolean aria) {
        this.aria = aria;
    }

    public void setAcqua(Boolean acqua) {
        this.acqua = acqua;
    }

    public void setElettricita(Boolean elettricita) {
        this.elettricita = elettricita;
    }

    public void setGas(Boolean gas) {
        this.gas = gas;
    }

    public void setCondominio(Boolean condominio) {
        this.condominio = condominio;
    }

    public void setParcheggio(Boolean parcheggio) {
        this.parcheggio = parcheggio;
    }

    public void setPulizie(Boolean pulizie) {
        this.pulizie = pulizie;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public void setTelefonia(Boolean telefonia) {
        this.telefonia = telefonia;
    }

    public void setSorveglianza(Boolean sorveglianza) {
        this.sorveglianza = sorveglianza;
    }

    public void setAscensore(Boolean ascensore) {
        this.ascensore = ascensore;
    }

    public void setPortierato(Boolean portierato) {
        this.portierato = portierato;
    }

    public void setNum_min_letti(int num_min_letti) {
        this.num_min_letti = num_min_letti;
    }

    public void setNum_max_letti(int num_max_letti) {
        this.num_max_letti = num_max_letti;
    }

    public void setNum_min_stanze(int num_min_stanze) {
        this.num_min_stanze = num_min_stanze;
    }

    public void setNum_max_stanze(int num_max_stanze) {
        this.num_max_stanze = num_max_stanze;
    }

    public void setTipo_alloggio(String tipo_alloggio) {
        this.tipo_alloggio = tipo_alloggio;
    }

    public void setNum_max_persone(int num_max_persone) {
        this.num_max_persone = num_max_persone;
    }

    public void setAnimali(Boolean animali) {
        this.animali = animali;
    }

    public void setFumatori(Boolean fumatori) {
        this.fumatori = fumatori;
    }

    public void setSesso(String sesso)    {
        this.sesso = sesso;
    }

    public void setPaesi_conv(Boolean paesi_conv) {
        this.paesi_conv = paesi_conv;
    }

    public void setStudente(Boolean studente) {
        this.studente = studente;
    }

    public void setLavoratore(Boolean lavoratore) {
        this.lavoratore = lavoratore;
    }

    public Filtri setFiltri()   {
        Filtri f = FiltraggioAnnunciAppartamentiControl.getInstance().setFilters(luogo, check_in, check_out, prezzoMin,
                prezzoMax, riscaldamento, aria, acqua,
                elettricita, gas, condominio, parcheggio,
                pulizie, wifi, telefonia, sorveglianza,
                ascensore, portierato, num_min_letti, num_max_letti, num_min_stanze, num_max_stanze, tipo_alloggio,
                num_max_persone, animali, fumatori, sesso,
                paesi_conv, studente, lavoratore);
        return f;
    }
    public ArrayList<Annuncio> filtraAnnunci(Filtri selectedFilters) throws IOException, SQLException {
        AnnunciAppartamentiDao annunciAppartamentiDao = new AnnunciAppartamentiDao();
        ArrayList<Annuncio> a = annunciAppartamentiDao.allAnnunciAppartamenti();
        ArrayList<Annuncio> annunci = FiltraggioAnnunciAppartamentiControl.getInstance().filterApartmentAnnouncements(a, selectedFilters);
        return annunci;
    }
}
