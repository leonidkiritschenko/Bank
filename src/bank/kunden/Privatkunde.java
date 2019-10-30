package bank.kunden;


import bank.adresse.Adresse;

import java.time.LocalDate;

public class Privatkunde extends Kunde {
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;

    public Privatkunde(String kundennummer, String telefon, String email, Adresse adresse, String vorname, String nachname, LocalDate geburtsdatum) {
        super(kundennummer, telefon, email, adresse);
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
    }
}
