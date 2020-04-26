package entity;

import java.sql.Date;

public class Annuncio {
    private int id;
    private String nome;
    private String luogo;
    private Date data_min;
    private Date data_max;
    private double prezzo;
    private boolean riscaldamento;
    private boolean aria;
    private boolean acqua;
    private boolean elettricita;
    private boolean gas;
    private boolean condominio;
    private boolean parcheggio;
    private boolean pulizie;
    private boolean wifi;
    private boolean telefonia;
    private boolean sorveglianza;
    private boolean ascensore;
    private boolean portierato;
    private int num_letti;
    private int num_stanze;
    private String tipo_alloggio;
    private int num_max_persone;
    private boolean animali;
    private boolean fumatori;
    private String sesso;
    private boolean paesi_conv;
    private boolean studente;
    private boolean lavoratore;
    private double valutazione;
    public Annuncio(int id, String nome, String luogo, Date data_min, Date data_max, double prezzo,
                    boolean riscaldamento, boolean aria, boolean acqua, boolean elettricita, boolean gas, boolean condominio,
                    boolean parcheggio, boolean pulizie, boolean wifi, boolean telefonia, boolean sorveglianza, boolean ascensore,
                    boolean portierato, int num_letti, int num_stanze, String tipo_alloggio, int num_max_persone, boolean animali, boolean fumatori,
                    String sesso, boolean paesi_conv, boolean studente, boolean lavoratore, double valutazione)   {
        this.id = id;
        this.nome = nome;
        this.luogo = luogo;
        this.data_min = data_min;
        this.data_max = data_max;
        this.prezzo = prezzo;
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
        this.num_letti = num_letti;
        this.num_stanze = num_stanze;
        this.tipo_alloggio = tipo_alloggio;
        this.num_max_persone = num_max_persone;
        this.animali = animali;
        this.fumatori = fumatori;
        this.sesso = sesso;
        this.paesi_conv = paesi_conv;
        this.studente = studente;
        this.lavoratore = lavoratore;
        this.valutazione = valutazione;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public Date getData_min() {
        return data_min;
    }

    public void setData_min(Date data_min) {
        this.data_min = data_min;
    }

    public Date getData_max() {
        return data_max;
    }

    public void setData_max(Date data_max) {
        this.data_max = data_max;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isRiscaldamento() {
        return riscaldamento;
    }

    public void setRiscaldamento(boolean riscaldamento) {
        this.riscaldamento = riscaldamento;
    }

    public boolean isAria() {
        return aria;
    }

    public void setAria(boolean aria) {
        this.aria = aria;
    }

    public boolean isAcqua() {
        return acqua;
    }

    public void setAcqua(boolean acqua) {
        this.acqua = acqua;
    }

    public boolean isElettricita() {
        return elettricita;
    }

    public void setElettricita(boolean elettricita) {
        this.elettricita = elettricita;
    }

    public boolean isGas() {
        return gas;
    }

    public void setGas(boolean gas) {
        this.gas = gas;
    }

    public boolean isCondominio() {
        return condominio;
    }

    public void setCondominio(boolean condominio) {
        this.condominio = condominio;
    }

    public boolean isParcheggio() {
        return parcheggio;
    }

    public void setParcheggio(boolean parcheggio) {
        this.parcheggio = parcheggio;
    }

    public boolean isPulizie() {
        return pulizie;
    }

    public void setPulizie(boolean pulizie) {
        this.pulizie = pulizie;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isTelefonia() {
        return telefonia;
    }

    public void setTelefonia(boolean telefonia) {
        this.telefonia = telefonia;
    }

    public boolean isSorveglianza() {
        return sorveglianza;
    }

    public void setSorveglianza(boolean sorveglianza) {
        this.sorveglianza = sorveglianza;
    }

    public boolean isAscensore() {
        return ascensore;
    }

    public void setAscensore(boolean ascensore) {
        this.ascensore = ascensore;
    }

    public boolean isPortierato() {
        return portierato;
    }

    public void setPortierato(boolean portierato) {
        this.portierato = portierato;
    }

    public int getNum_letti() {
        return num_letti;
    }

    public void setNum_letti(int num_letti) {
        this.num_letti = num_letti;
    }

    public int getNum_stanze() {
        return num_stanze;
    }

    public void setNum_stanze(int num_stanze) {
        this.num_stanze = num_stanze;
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

    public boolean isAnimali() {
        return animali;
    }

    public void setAnimali(boolean animali) {
        this.animali = animali;
    }

    public boolean isFumatori() {
        return fumatori;
    }

    public void setFumatori(boolean fumatori) {
        this.fumatori = fumatori;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public boolean isPaesi_conv() {
        return paesi_conv;
    }

    public void setPaesi_conv(boolean paesi_conv) {
        this.paesi_conv = paesi_conv;
    }

    public boolean isStudente() {
        return studente;
    }

    public void setStudente(boolean studente) {
        this.studente = studente;
    }

    public boolean isLavoratore() {
        return lavoratore;
    }

    public void setLavoratore(boolean lavoratore) {
        this.lavoratore = lavoratore;
    }

    public double getValutazione() {
        return valutazione;
    }

    public void setValutazione(double valutazione) {
        this.valutazione = valutazione;
    }
}
