package entity;

import java.sql.Date;

public class Filtri {
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
    public Filtri(String luogo, Date check_in, Date check_out, double prezzoMin,
                  double prezzoMax, Boolean riscaldamento, Boolean aria, Boolean acqua,
                  Boolean elettricita, Boolean gas, Boolean condominio, Boolean parcheggio,
                  Boolean pulizie, Boolean wifi, Boolean telefonia, Boolean sorveglianza,
                  Boolean ascensore, Boolean portierato, int num_min_letti, int num_max_letti, int num_min_stanze, int num_max_stanze, String tipo_alloggio,
                  int num_max_persone, Boolean animali, Boolean fumatori, String sesso,
                  Boolean paesi_conv, Boolean studente, Boolean lavoratore) {
        this.luogo = luogo;
        this.check_in = check_in;
        this.check_out = check_out;
        this.prezzoMin = prezzoMin;
        this.prezzoMax = prezzoMax;
        this.riscaldamento = riscaldamento;
        this.aria = aria;
        this.acqua = acqua;
        this.elettricita = elettricita;
        this.gas = gas;
        this.condominio = condominio;
        this.parcheggio = parcheggio;
        this.pulizie = pulizie;
        this.wifi = wifi;
        this.telefonia = telefonia;
        this.sorveglianza = sorveglianza;
        this.ascensore = ascensore;
        this.portierato = portierato;
        this.num_min_letti = num_min_letti;
        this.num_max_letti = num_max_letti;
        this.num_min_stanze = num_min_stanze;
        this.num_max_stanze = num_max_stanze;
        this.tipo_alloggio = tipo_alloggio;
        this.num_max_persone = num_max_persone;
        this.animali = animali;
        this.fumatori = fumatori;
        this.sesso = sesso;
        this.paesi_conv = paesi_conv;
        this.studente = studente;
        this.lavoratore = lavoratore;
    }
    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public double getPrezzoMin() {
        return prezzoMin;
    }

    public void setPrezzoMin(double prezzoMin) {
        this.prezzoMin = prezzoMin;
    }

    public double getPrezzoMax() {
        return prezzoMax;
    }

    public void setPrezzoMax(double prezzoMax) {
        this.prezzoMax = prezzoMax;
    }

    public Boolean isRiscaldamento() {
        return riscaldamento;
    }

    public void setRiscaldamento(Boolean riscaldamento) {
        this.riscaldamento = riscaldamento;
    }

    public Boolean isAria() {
        return aria;
    }

    public void setAria(Boolean aria) {
        this.aria = aria;
    }

    public Boolean isAcqua() {
        return acqua;
    }

    public void setAcqua(Boolean acqua) {
        this.acqua = acqua;
    }

    public Boolean isElettricita() {
        return elettricita;
    }

    public void setElettricita(Boolean elettricita) {
        this.elettricita = elettricita;
    }

    public Boolean isGas() {
        return gas;
    }

    public void setGas(Boolean gas) {
        this.gas = gas;
    }

    public Boolean isCondominio() {
        return condominio;
    }

    public void setCondominio(Boolean condominio) {
        this.condominio = condominio;
    }

    public Boolean isParcheggio() {
        return parcheggio;
    }

    public void setParcheggio(Boolean parcheggio) {
        this.parcheggio = parcheggio;
    }

    public Boolean isPulizie() {
        return pulizie;
    }

    public void setPulizie(Boolean pulizie) {
        this.pulizie = pulizie;
    }

    public Boolean isWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean isTelefonia() {
        return telefonia;
    }

    public void setTelefonia(Boolean telefonia) {
        this.telefonia = telefonia;
    }

    public Boolean isSorveglianza() {
        return sorveglianza;
    }

    public void setSorveglianza(Boolean sorveglianza) {
        this.sorveglianza = sorveglianza;
    }

    public Boolean isAscensore() {
        return ascensore;
    }

    public void setAscensore(Boolean ascensore) {
        this.ascensore = ascensore;
    }

    public Boolean isPortierato() {
        return portierato;
    }

    public void setPortierato(Boolean portierato) {
        this.portierato = portierato;
    }

    public int getNum_min_letti() {
        return num_min_letti;
    }

    public void setNum_min_letti(int num_min_letti) {
        this.num_min_letti = num_min_letti;
    }

    public int getNum_max_letti() {
        return num_max_letti;
    }

    public void setNum_max_letti(int num_max_letti) {
        this.num_max_letti = num_max_letti;
    }

    public int getNum_min_stanze() {
        return num_min_stanze;
    }

    public void setNum_min_stanze(int num_min_stanze) {
        this.num_min_stanze = num_min_stanze;
    }

    public int getNum_max_stanze() {
        return num_max_stanze;
    }

    public void setNum_max_stanze(int num_max_stanze) {
        this.num_max_stanze = num_max_stanze;
    }

    public String getTipo_alloggio() {
        return tipo_alloggio;
    }

    public void setTipo_alloggio(String tipo_alloggio) {
        this.tipo_alloggio = tipo_alloggio;
    }

    public int getNum_max_persone() {
        return num_max_persone;
    }

    public void setNum_max_persone(int num_max_persone) {
        this.num_max_persone = num_max_persone;
    }

    public Boolean isAnimali() {
        return animali;
    }

    public void setAnimali(Boolean animali) {
        this.animali = animali;
    }

    public Boolean isFumatori() {
        return fumatori;
    }

    public void setFumatori(Boolean fumatori) {
        this.fumatori = fumatori;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public Boolean isPaesi_conv() {
        return paesi_conv;
    }

    public void setPaesi_conv(Boolean paesi_conv) {
        this.paesi_conv = paesi_conv;
    }

    public Boolean isStudente() {
        return studente;
    }

    public void setStudente(Boolean studente) {
        this.studente = studente;
    }

    public Boolean isLavoratore() {
        return lavoratore;
    }

    public void setLavoratore(Boolean lavoratore) {
        this.lavoratore = lavoratore;
    }
}
