package bank.kunden;

import bank.konto.Konto;
import bank.adresse.Adresse;

import java.util.ArrayList;

public abstract class Kunde {
    private String telefon;
    private String email;
    private Adresse adresse;

    // max 10 Konten
    private ArrayList<Konto> konten;

    protected Kunde(String telefon, String email, Adresse adresse) {
        this.telefon = telefon;
        this.email = email;
        this.adresse = adresse;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return new Adresse(adresse);
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = new Adresse(adresse);
    }

    public ArrayList<Konto> getKonten() {
        return new ArrayList<Konto>(this.konten);
    }

    public boolean addKonto(Konto konto) {
        if (this.konten.size() == 10) {
            this.konten.add(new Konto(konto));
            return true;
        } else {
            return false;
        }

    }
}
