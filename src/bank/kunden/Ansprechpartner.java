package bank.kunden;

public class Ansprechpartner {
    private String vorname;
    private String nachname;
    private String telefon;

    public Ansprechpartner(String vorname, String nachname, String telefon) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefon = telefon;
    }

    public Ansprechpartner(Ansprechpartner ansprechpartner) {
        this.vorname = ansprechpartner.vorname;
        this.nachname = ansprechpartner.nachname;
        this.telefon = ansprechpartner.telefon;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getTelefon() {
        return telefon;
    }

}
