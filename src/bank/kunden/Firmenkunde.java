package bank.kunden;

import bank.adresse.Adresse;

public class Firmenkunde extends Kunde {
    private String firmenname;
    private Ansprechpartner ansprechpartner;

    public Firmenkunde(String kundennummer, String telefon, String email, Adresse adresse, String firmenname, Ansprechpartner ansprechpartner) {
        super(kundennummer, telefon, email, adresse);
        this.firmenname = firmenname;
        this.ansprechpartner = new Ansprechpartner(ansprechpartner);
    }

    public Firmenkunde(Firmenkunde firmenkunde) {
        super(firmenkunde.getKundennummer(), firmenkunde.getTelefon(), firmenkunde.getEmail(), firmenkunde.getAdresse());
        this.firmenname = firmenkunde.firmenname;
        this.ansprechpartner = new Ansprechpartner(firmenkunde.ansprechpartner);
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public Ansprechpartner getAnsprechpartner() {
        return new Ansprechpartner(ansprechpartner);
    }

    public void setAnsprechpartner(Ansprechpartner ansprechpartner) {
        this.ansprechpartner = new Ansprechpartner(ansprechpartner);
    }
}
