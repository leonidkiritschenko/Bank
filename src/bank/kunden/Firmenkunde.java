package bank.kunden;

import bank.adresse.Adresse;

public class Firmenkunde extends Kunde {
    private static int kundennummerCounter = 1001;
    private String kundennummer;
    private String firmenname;
    private Ansprechpartner ansprechpartner;

    public Firmenkunde(String firmenname, Ansprechpartner ansprechpartner, String telefon, String email, Adresse adresse) {
        super(telefon, email, adresse);
        kundennummer = "F" + kundennummerCounter++;
        this.firmenname = firmenname;
        this.ansprechpartner = new Ansprechpartner(ansprechpartner);
    }

    public Firmenkunde(Firmenkunde firmenkunde) {
        super(firmenkunde.getTelefon(), firmenkunde.getEmail(), firmenkunde.getAdresse());
        this.kundennummer = firmenkunde.kundennummer;
        this.firmenname = firmenkunde.firmenname;
        this.ansprechpartner = new Ansprechpartner(firmenkunde.ansprechpartner);
    }

    public String getKundennummer() {
        return kundennummer;
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
