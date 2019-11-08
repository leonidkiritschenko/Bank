package bank.kunden;

import bank.adresse.Adresse;
import java.time.LocalDate;

public class Privatkunde extends Kunde {
    private static int kundennummerCounter = 1001;
    private String kundennummer;
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;

    public Privatkunde(String vorname, String nachname, String telefon, String email, LocalDate geburtsdatum,
                       Adresse adresse) {
        super(telefon, email, adresse);
        this.kundennummer = "P" + kundennummerCounter++;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
    }

    public Privatkunde(Privatkunde privatkunde) {
        super(privatkunde.getTelefon(), privatkunde.getEmail(), privatkunde.getAdresse());
        this.kundennummer = privatkunde.kundennummer;
        this.vorname = privatkunde.vorname;
        this.nachname = privatkunde.nachname;
        this.geburtsdatum = privatkunde.geburtsdatum;
    }

    public String getKundennummer() {
        return kundennummer;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }
}
